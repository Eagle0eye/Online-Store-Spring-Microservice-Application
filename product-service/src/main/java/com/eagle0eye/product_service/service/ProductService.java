package com.eagle0eye.product_service.service;

import com.eagle0eye.product_service.dto.ProductRequestDTO;
import com.eagle0eye.product_service.dto.ProductResponse;
import com.eagle0eye.product_service.model.Product;

import java.util.List;

public interface ProductService {
    // up level
    void createProduct(ProductRequestDTO form);

    // consumer
    ProductResponse viewProduct(String serial_number);
    List<ProductResponse> viewProducts();

    // up level
    List<Product> viewProductsInDetail();
    Product activate(String serial);
    Product DeActivate(String serial);

    List<String> viewSerials();
    void remove(String serial);
}
