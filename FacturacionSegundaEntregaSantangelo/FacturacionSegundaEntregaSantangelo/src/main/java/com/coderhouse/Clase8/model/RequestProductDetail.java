package com.coderhouse.Clase8.model;

public class RequestProductDetail {
    private int productId;
    private int quantity;

    public RequestProductDetail(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
//Getter And Setter
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
