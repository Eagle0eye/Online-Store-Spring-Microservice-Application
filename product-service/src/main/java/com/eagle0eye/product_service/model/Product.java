package com.eagle0eye.product_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String product_id;
    private String serial_number;
    private String title;
    private String description;
    private BigDecimal price;
    private boolean isAllowed;
}
