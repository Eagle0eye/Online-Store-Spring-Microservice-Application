package com.eagle0eye.product_service;

import com.eagle0eye.product_service.dto.ProductRequestDTO;
import com.eagle0eye.product_service.repository.ProductRepository;

import jakarta.servlet.ServletException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
class ProductServiceApplicationTests {

	@Container
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

	@Test
	void contextLoads() {
	}

	@Autowired
	private   MockMvc mockMvc;
	private  ObjectMapper objectMapper;

	@Autowired
	private  ProductRepository productRepository;


	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry)
	{
		dynamicPropertyRegistry.add("spring.data.mongodb.url",mongoDBContainer::getReplicaSetUrl);

	}
	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void shouldCreateProduct() throws Exception {
		productRepository.deleteAll();
		ProductRequestDTO productRequest = this.getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/products")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1,productRepository.findAll().size());
	}

	private ProductRequestDTO getProductRequest(){
		return ProductRequestDTO.builder()
				.id("b2e1d4c8-a7f3-41d9-84c5-3e6d9b1f7a2d")
				.serial_number("SN-1708264201245")
				.title("Wireless Gaming Controller")
				.description("Ergonomic wireless gamepad with haptic feedback and built-in rechargeable battery.")
				.price(BigDecimal.valueOf(69.99))
				.build();
	}
}
