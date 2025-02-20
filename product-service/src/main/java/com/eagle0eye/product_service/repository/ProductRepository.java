package com.eagle0eye.product_service.repository;

import com.eagle0eye.product_service.dto.ProductResponse;
import com.eagle0eye.product_service.dto.ProductSerial;
import com.eagle0eye.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    @Query("{ 'serial_number': ?0 }")
    Optional<Product> findProductBySerialNumber(String serial);

    @Query(value = "{}",fields = "{'_id': 0,'title': 1,'description': 1,'price': 1,'isAllowed': 1}")
    List<ProductResponse> getProductToShow();
    @Query("{$or: [{'product_id': ?0},{'serial_number': ?1},{title:?2 }]}")
    Product checkItem(String pid,String Serial,String title);

    @Query(value = "{}",fields = "{'_id': 0,'serial_number': 1}")
    List<ProductSerial> getAllSerials();


}
