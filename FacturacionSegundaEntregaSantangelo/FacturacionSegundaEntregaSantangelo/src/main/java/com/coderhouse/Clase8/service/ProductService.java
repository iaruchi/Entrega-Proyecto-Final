package com.coderhouse.Clase8.service;

import ch.qos.logback.core.net.server.Client;
import com.coderhouse.Clase8.model.Cliente;
import com.coderhouse.Clase8.model.Product;
import com.coderhouse.Clase8.repository.ClienteRepository;
import com.coderhouse.Clase8.repository.ProductRepository;
import org.apache.catalina.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.coderhouse.Clase8.model.RequestProductDetail;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.Period;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    public Product getProduct(int id){

        return productRepository.findById(id).get();
    }
    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct :
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()) {
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public void DeleteProduct(int id){
        productRepository.deleteById(id);
    }

    public Product updateProduct (int id, Product product){
        Product p = productRepository.findById(id).get();
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setStock(product.getStock());
        return productRepository.save(p);
    }
}
