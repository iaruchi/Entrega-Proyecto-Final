package com.coderhouse.Clase8.repository;
import com.coderhouse.Clase8.model.*;
import com.coderhouse.Clase8.model.Invoice;
import com.coderhouse.Clase8.model.InvoiceDTO;
import com.coderhouse.Clase8.model.InvoiceWithDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Integer> {
    @Query("SELECT new com.coderhouse.Clase8.repository.InvoiceDetailRepository(" +
            "p.description, " +
            "p.code, " +
            "d.price, " +
            "d.quantity" +
            ") FROM Invoice i JOIN i.invoiceDetail d JOIN d.product p WHERE i.id = :id")
    List<InvoiceDetailDTO> getInvoiceDetailsByInvoiceId(@Param("id") int invoice_id);
}
