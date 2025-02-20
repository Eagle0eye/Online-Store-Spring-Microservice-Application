package com.eagle0eye.product_service.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
public class ProductResponse {
    private String title;
    private String description;
    private BigDecimal price;
    private boolean isAllowed;
    public ProductResponse(String title, String description, BigDecimal price,boolean isAllowed) {
        this.title = title != null ? title : "N/A";
        this.description = description != null ? description : "No Description";
        this.price = price != null ? price :BigDecimal.valueOf(0.0);
        this.isAllowed = isAllowed;
    }
}
