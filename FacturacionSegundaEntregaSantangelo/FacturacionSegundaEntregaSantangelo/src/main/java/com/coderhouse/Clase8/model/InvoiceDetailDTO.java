package com.coderhouse.Clase8.model;

public class InvoiceDetailDTO {
    private String description;
    private String code;
    private double price;
    private int quantity;

    public InvoiceDetailDTO(String description, String code, double price, int quantity) {
        this.description = description;
        this.code = code;
        this.price = price;
        this.quantity = quantity;

    }

    //Getters And Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //ToString

    @Override
    public String toString() {
        return "InvoiceDetailDTO{" +
                "description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

