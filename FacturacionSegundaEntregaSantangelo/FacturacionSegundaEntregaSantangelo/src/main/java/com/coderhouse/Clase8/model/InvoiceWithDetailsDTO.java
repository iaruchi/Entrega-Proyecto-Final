package com.coderhouse.Clase8.model;
import java.util.List;
public class InvoiceWithDetailsDTO {
    private int invoice_id;
    private String created_at;
    private double total;
    private List<InvoiceDetailDTO> details;

    public InvoiceWithDetailsDTO(int invoice_id, String created_at, double total, List<InvoiceDetailDTO> details) {
        this.invoice_id = invoice_id;
        this.created_at = created_at;
        this.total = total;
        this.details = details;

    }
//GettersAndSetters
    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<InvoiceDetailDTO> getDetails() {
        return details;
    }

    public void setDetails(List<InvoiceDetailDTO> details) {
        this.details = details;
    }
//ToString
    @Override
    public String toString() {
        return "InvoiceWithDetailsDTO{" +
                "invoice_id=" + invoice_id +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                ", details=" + details +
                '}';
    }
}