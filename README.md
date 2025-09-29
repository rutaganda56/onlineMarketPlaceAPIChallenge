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

## 🚀 Setup & Installation

### Prerequisites

You must have the following software installed on your system:

- Java 17+ (JDK)
- Maven 3.6+
- Docker & Docker Compose (Recommended for easiest setup)

### 1. Running with Docker Compose (Recommended)

The `docker-compose.yml` file handles building the application and setting up a PostgreSQL database instance, making the setup process seamless.

1. **Clone the repository**:
   ```bash
   git clone [Your Repository URL]
   cd [your-repo-name]

### Link To Swagger Documentation
http://localhost:8080/swagger-ui/index.html#
