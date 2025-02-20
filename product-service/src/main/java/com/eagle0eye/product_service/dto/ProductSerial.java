package com.eagle0eye.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
public class ProductSerial {
    private String serial_number;
    public  ProductSerial(String serial_number){
        this.serial_number = serial_number;
    }

    public String getSerialNumber() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}
