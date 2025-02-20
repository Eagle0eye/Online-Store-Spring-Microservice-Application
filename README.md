# Online-Store-Spring-Microservice-Application

## Overview
This project is a **Spring Boot Microservices** application for an online store. It follows a distributed architecture where each service handles a specific domain.

## Services
### 1. **Product Service**
   - **Port:** `8080`
   - Manages products, including creation, retrieval, activation, and deactivation.
   
### 2. **Order Service**
   - **Port:** `8081`
   - Handles customer orders, order creation, and order management.

### 3. **Inventory Service**
   - **Port:** `8082`
   - Manages product stock and availability.

### 4. **Voucher Service**
   - **Port:** `8083`
   - Handles discount vouchers and promotional offers.

## API Endpoints
### **Product Service (`8080`)**
- `POST /api/v1/products` - Create a new product.
- `GET /api/v1/products` - Retrieve all products.
- `GET /api/v1/products/{serialNumber}` - Get product by serial number.
- `GET /api/v1/products/details` - Get detailed product information.
- `PUT /api/v1/products/active/{serialNumber}` - Activate a product.
- `PUT /api/v1/products/de-active/{serialNumber}` - Deactivate a product.
- `DELETE /api/v1/products/{serialNumber}` - Delete a product.
- `GET /api/v1/products/serials` - Retrieve product serial numbers.


## Technologies Used
- **Spring Boot** (Microservices Architecture)
- **Spring Cloud** (Service Discovery, Config Server, API Gateway)  -> inprogress
- **Spring Data JPA** (Database Access)
- **Spring Security** (Authentication & Authorization) -> inprogress
- **MySQL** (Database)
- **Docker & Kubernetes** (Containerization & Orchestration) -> inprogress
- **RabbitMQ/Kafka** (Event-Driven Communication) -> inprogress



## Contributing
Contributions are welcome! Feel free to open an issue or submit a pull request.

## License
This project is licensed under the [MIT License](LICENSE).

