package com.eagle0eye.product_service.mapper;

import com.eagle0eye.product_service.dto.ProductRequestDTO;
import com.eagle0eye.product_service.dto.ProductResponse;
import com.eagle0eye.product_service.model.Product;

public class ProductMapper {
    // show item
    public ProductResponse MapToProductShow(Product product)
    {
        return ProductResponse.builder()
                .title(product.getTitle())
                .description(product.getDescription())
                .price(product.getPrice())
                .isAllowed(product.isAllowed())
                .build();
    }

    // add item
    public Product MapToProduct(ProductRequestDTO requestDTO){
        return Product.builder()
                .product_id(requestDTO.getId())
                .serial_number(requestDTO.getSerial_number())
                .title(requestDTO.getTitle())
                .description(requestDTO.getDescription())
                .price(requestDTO.getPrice())
                .isAllowed(true)
                .build();
    }



}
