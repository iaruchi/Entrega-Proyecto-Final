package com.coderhouse.Clase8.model;
import java.util.List;
import jakarta.persistence.*;
public class InvoiceRequest { private int client_id;

    //Luego añadiremos los details que serán añadidos.
    private List<RequestProductDetail> product_list;

    public InvoiceRequest(int client_id, List<RequestProductDetail> product_list) {
        this.client_id = client_id;
        this.product_list = product_list;
    }
//Getter And Setter
    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public List<RequestProductDetail> getProduct_list() {
        return product_list;
    }

    public void setProduct_list(List<RequestProductDetail> product_list) {
        this.product_list = product_list;
    }
    //ToString

    @Override
    public String toString() {
        return "InvoiceRequest{" +
                "client_id=" + client_id +
                ", product_list=" + product_list +
                '}';
    }
}
