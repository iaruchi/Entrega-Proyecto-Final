package com.coderhouse.Clase8.service;
import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @Autowired
    private ClientService clientService;
    public InvoiceDTO postInvoice (InvoiceRequest invoiceRequest) throws Exception {

        //Buscar a traves de Id
        Cliente clientExist =
                clientService.getClient(invoiceRequest.getClient_id());
        List<Product> productList =
                productService.getProductsById(invoiceRequest.getProduct_list());

        //Total
        double total = 0;
        int i = 0;
        for (Product product:
        productList) {
            total += product.getPrice() * invoiceRequest.getProduct_list().get(i).getQuantity();
            i++;
        }
        //instanciamos un objeto invoice
        Invoice invoiceCreated = new Invoice();
        invoiceCreated.setCreated_at(new Date().toString());
        invoiceCreated.setClient(clientExist);
        invoiceCreated.setTotal(total);
        invoiceCreated = invoiceRepository.save(invoiceCreated);

        //Settamos los invoice_details
        i = 0;
        for (Product productForDetail:
                productList) {
        InvoiceDetail newInvoice = new InvoiceDetail();
        newInvoice.setPrice(productForDetail.getPrice());
        newInvoice.setInvoice(invoiceCreated);
        newInvoice.setProduct(productForDetail);
        newInvoice.setQuantity(invoiceRequest.getProduct_list().get(i).getQuantity());
        invoiceDetailService.saveInvoiceDetail(newInvoice);
        i++;
        }
        //Retornamos DTO
        return new InvoiceDTO (
                invoiceCreated.getId(),
                invoiceCreated.getCreated_at(),
                invoiceCreated.getTotal() );
    }
    public List<InvoiceDTO> getInvoicesByClientId (int clientId) throws Exception {
        System.out.println(clientId);
        return invoiceRepository.getInvoicesByClientById(clientId);
    }
    public InvoiceWithDetailsDTO getInvoiceById (int invoice_id) throws Exception {
        Optional<Invoice> invoiceFound = invoiceRepository.findById(invoice_id);
        if (invoiceFound.isEmpty()) {
            throw new Exception("Invoice not found");
        }
        List<InvoiceDetailDTO> invoice_details =
                invoiceDetailService.getInvoiceDetailsByInvoiceId(invoice_id);

        return new InvoiceWithDetailsDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal(),
                invoice_details
        );
        /*return new InvoiceDTO(
                invoiceFound.get().getId(),
                invoiceFound.get().getCreated_at(),
                invoiceFound.get().getTotal()
        );*/
    }

}
