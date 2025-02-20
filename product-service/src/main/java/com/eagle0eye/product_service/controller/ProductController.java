package com.eagle0eye.product_service.controller;

import com.eagle0eye.product_service.dto.ProductRequestDTO;
import com.eagle0eye.product_service.dto.ProductResponse;
import com.eagle0eye.product_service.model.Product;
import com.eagle0eye.product_service.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServiceImpl productService;

    // consumers
    @GetMapping
    public ResponseEntity<List<ProductResponse>> viewProducts()
    {   return ResponseEntity.ok().body(productService.viewProducts());   }

    @GetMapping("/{serial}")
    public ResponseEntity<ProductResponse> viewProduct(@PathVariable String serial)
    {   return ResponseEntity.status(HttpStatus.FOUND).body(productService.viewProduct(serial));  }


    @PostMapping
    private ResponseEntity<?> addProduct(@RequestBody ProductRequestDTO form)
    {   productService.createProduct(form);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/serials")
    public ResponseEntity<List<String>> viewProductsSerials()
    {   return ResponseEntity.ok().body(productService.viewSerials());   }

    @GetMapping("/details")
    public ResponseEntity<List<Product>> viewProductInDetails()
    {   return ResponseEntity.ok().body(productService.viewProductsInDetail());   }

    @PutMapping("/active/{serial}")
    public ResponseEntity<Product> activateProduct(@PathVariable String serial){
        return ResponseEntity.accepted().body(productService.activate(serial));
    }
    @PutMapping("/de-active/{serial}")
    public ResponseEntity<Product> deActivateProduct(@PathVariable String serial){
        return ResponseEntity.accepted().body(productService.DeActivate(serial));
    }

    @DeleteMapping("/{serial}")
    public ResponseEntity<?> removeProduct(@PathVariable String serial)
    {   productService.remove(serial);
        return ResponseEntity.status(HttpStatus.OK).build();  }
}
