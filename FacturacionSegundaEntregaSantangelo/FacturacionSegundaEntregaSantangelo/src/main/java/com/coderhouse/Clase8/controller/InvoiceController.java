package com.coderhouse.Clase8.controller;
import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.service.InvoiceService;
import com.coderhouse.Clase8.model.InvoiceWithDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping
    public ResponseEntity<Object> postInvoice (@RequestBody InvoiceRequest reqInvoice) {
        try {
            System.out.println(reqInvoice);
            //DTO Data transfer object
            InvoiceDTO data = invoiceService.postInvoice(reqInvoice);
            return ResponseHandler.generateResponse(
                    "Invoice created successfully",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
    //Añadir getInvoice by id
    @GetMapping(path = "{invoice_id}")
    public ResponseEntity<Object> getInvoiceById (@PathVariable int invoice_id) {
        try {
            System.out.println(invoice_id);
            InvoiceWithDetailsDTO data = invoiceService.getInvoiceById(invoice_id);
            return ResponseHandler.generateResponse(
                    "Get Invoice by Id successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }

    @GetMapping(path = "/getInvoicesByClientId/{clientId}")
    public ResponseEntity<Object> getInvoiceByClientId (@PathVariable int clientId){
        try {
            List<InvoiceDTO> data = invoiceService.getInvoicesByClientId(clientId);
            return ResponseHandler.generateResponse(
                    "Get Invoices by Client id successful",
                    HttpStatus.OK,
                    data
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
}
