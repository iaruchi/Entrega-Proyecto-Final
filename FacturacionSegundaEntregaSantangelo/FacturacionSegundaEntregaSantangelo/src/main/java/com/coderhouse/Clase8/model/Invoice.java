package com.coderhouse.Clase8.model;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Cliente client;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoiceDetail;
    private String created_at;
    private double total;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public List<InvoiceDetail> getInvoiceDetail() {
        return invoiceDetail;
    }

    public void setInvoiceDetail(List<InvoiceDetail> invoiceDetail) {
        this.invoiceDetail = invoiceDetail;
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


    //ToString

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", cliente=" + client +
                ", created_at='" + created_at + '\'' +
                ", total=" + total +
                '}';
    }
}
