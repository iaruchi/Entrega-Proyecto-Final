package com.coderhouse.Clase8.controller;

import com.coderhouse.Clase8.middleware.ResponseHandler;
import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Para poder utilizar el POST en Product
    @PostMapping
    public ResponseEntity<Object> postProduct(@RequestBody Product product) {
        try {
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Product stored successfully",
                    HttpStatus.OK,
                    productSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
    }

    // Para poder utilizar el GET en Product
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct(@PathVariable() int id) {
        try {
            Product getProduct = productService.getProduct(id);
            return ResponseHandler.generateResponse(
                    "Product extracted successfully",
                    HttpStatus.OK,
                    getProduct

            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
    }

    // Para poder utilizar el DELETE en Product
    @DeleteMapping(path = "{id}")
    public void DeleteProduct(@PathVariable int id) throws Exception {
        productService.DeleteProduct(id);
    }

    // Para poder utilizar el PUT en Product
    @PutMapping(path = "{id}")
    public ResponseEntity<Object> UpdateProduct(@PathVariable int id,@RequestBody Product product) throws Exception {
        try {
            Product productUpdated = productService.updateProduct(id,product);
            return ResponseHandler.generateResponse(
                    "Client extracted successfully",
                    HttpStatus.OK,
                    productUpdated
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null );
        }
    }
}


