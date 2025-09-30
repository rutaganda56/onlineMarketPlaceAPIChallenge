# 🚀 Online Marketplace RESTful API
## 📝 Introduction

This project is a comprehensive, feature-rich RESTful API for an online marketplace platform, enabling users to register as buyers or sellers, manage stores, list products, process orders, and submit reviews.

The API is built on Spring Boot, utilizes JWT for secure authentication, is fully containerized with Docker, and offers live documentation via Swagger UI. Robust validation and clear DTOs (Data Transfer Objects) are employed across all layers to ensure data integrity and separation of concerns.

## 🛠️ Technology Stack

| Category | Technology | Version / Notes |
|----------|------------|-----------------|
| Backend | Java / Spring Boot | 17+ (Spring Boot 3) |
| Database | PostgreSQL  | PostgreSQL (Production/Containerized)|
| Containerization | Docker & Docker Compose | For local environment consistency |
| Security | Spring Security & JWT | JSON Web Tokens for stateless authentication |
| Documentation | Swagger UI | OpenAPI 3 specification |
| Build Tool | Maven | Project dependency and build management |

## 🏗️ Data Model & Entity Relationships

The system employs a relational structure to manage user interactions, inventory, and transactions:

| Entity | Key Relationships | Description / Responsibilities |
|--------|-------------------|-------------------------------|
| User | 1:1 with Store (optional) | Handles registration, authentication, and profile management |
| Store | 1:M with Product | Created and managed by a User (Seller). Represents a seller's storefront |
| Category | 1:M with Product | Classifies products into different categories |
| Product | M:1 with Store, 1:M with Review | The core inventory item. Managed by the Store/Seller |
| Order | M:1 with User (Buyer) | Represents a historical transaction, enabling the review eligibility check |
| Review | M:1 with User, M:1 with Product | User feedback on a product, validated against purchase history |

# System Architecture: Spring Boot E-Commerce Marketplace

## Entity Relationships & API Design

The system features a relational database design with carefully crafted entity relationships that support complex business operations while maintaining data consistency.

## Diagram
![System design](https://github.com/user-attachments/assets/6a4eadd6-4adb-42f9-bdfa-caad6cc5fe7c)


## 🚀 Setup & Installation

### Prerequisites

You must have the following software installed on your system:

- Java 17+ (JDK)
- Maven 3.6+
- Docker & Docker Compose (Recommended for easiest setup)

### 1. Running with Docker Compose (Recommended)

The `docker-compose.yml` file handles building the application and setting up a PostgreSQL database instance, making the setup process seamless.

#### 1. *Clone the repository*:
```bash
   git clone https://github.com/rutaganda56/onlineMarketPlaceAPIChallenge
   cd onlineMarketPlaceAPIChallenge
```
#### Build and Start Services:
```bash
docker-compose up --build -d
```
This command compiles the Spring Boot application, builds the image, and starts both the API and the PostgreSQL database in the background.

### Access the Application:
The API will be accessible at http://localhost:8080.

#### 2. Running Locally (Manual Setup)
Clone the repository (as above).
Build the Project:
####  Run:
```bash
mvn clean install
```
#### Run the Spring Boot Application:
```bash
mvn spring-boot:run
```
## 🔒 API Documentation and Usage
Accessing Swagger UI
Once the application is running, the full interactive documentation is available:

🔗 Swagger UI URL: [http://localhost:/8080-ui.html](http://localhost:8080/swagger-ui/index.html#/) (development)

Soon it will be deployed on render.com

Authentication Flow (JWT)
All secure endpoints require authentication. Follow these steps to generate and use a token:

Register a User (Buyer or Seller):

Endpoint: POST /api/auth/register

Body: Provide user details (email, password, name, role).

Login to Get Token:

Endpoint: POST /api/auth/login

Body: Provide login credentials (email, password).

Response: The response body will contain the JWT Bearer Token.

Use the Token:
For all subsequent protected calls (e.g., managing products, placing orders), include the token in the request header:

text
Authorization: Bearer <Your JWT Token>
Key Endpoints (Examples)
Auth	POST	/api/auth/register	NONE
Products	GET	/api/product/products	ANY (Public read)
Products	POST	/api/product/createProduct	
Orders	POST	/api/order/createOrder	BUYER
Reviews	UPDATE	/api/review/{id}	BUYER

## 🚀 Deployment
the api is going to be deployed on render.com very soon. thanks !!!!




