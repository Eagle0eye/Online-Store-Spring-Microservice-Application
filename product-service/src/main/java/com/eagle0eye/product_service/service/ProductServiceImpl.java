package com.eagle0eye.product_service.service;

import com.eagle0eye.product_service.dto.ProductRequestDTO;
import com.eagle0eye.product_service.dto.ProductResponse;
import com.eagle0eye.product_service.dto.ProductSerial;
import com.eagle0eye.product_service.mapper.ProductMapper;
import com.eagle0eye.product_service.model.Product;
import com.eagle0eye.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper = new ProductMapper();

    @Override
    public void createProduct(ProductRequestDTO form) {
        if(productRepository.checkItem(form.getId(), form.getSerial_number(), form.getTitle()) != null) {
            throw new RuntimeException("Already exist");
        }

        Product product = productMapper.MapToProduct(form);
        productRepository.save(product);
    }

    @Override
    public ProductResponse viewProduct(String serial_number) {
        Product product = productRepository.findProductBySerialNumber(serial_number).orElseThrow(()->new RuntimeException("Not Found"));
        return productMapper.MapToProductShow(product);
    }

    @Override
    public List<ProductResponse> viewProducts() {
        List<ProductResponse> products = productRepository.getProductToShow();
        return (products.size()!=0)? products:new ArrayList<>();
    }

    @Override
    public List<Product> viewProductsInDetail() {
        List<Product> products = productRepository.findAll();
        return (products.size()!=0)? products:new ArrayList<>();
    }

    @Override
    public Product activate(String serial) {
        return this.changeStatus(serial,true);
    }

    @Override
    public Product DeActivate(String serial) {
        return this.changeStatus(serial,false);
    }

    @Override
    public List<String> viewSerials() {
        List<ProductSerial> serials = productRepository.getAllSerials();


        return serials.stream()
                .map(ProductSerial::getSerialNumber)
                .filter(Objects::nonNull)
                .toList();
    }


    @Override
    public void remove(String serial) {
        Product product = productRepository.findProductBySerialNumber(serial).orElseThrow(()->new RuntimeException("Not Found"));
        productRepository.delete(product);
    }


    private Product changeStatus(String serial_number, boolean status) {
        Product product = productRepository.findProductBySerialNumber(serial_number).orElseThrow(()->new RuntimeException("Not Found"));
        product.setAllowed(status);
        return productRepository.save(product);
    }


}
