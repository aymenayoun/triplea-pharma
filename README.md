# TripleA Pharma - Pharmacy Management System

![Project Banner](https://via.placeholder.com/800x200.png?text=TripleA+Pharma) <!-- Replace with actual image -->

A full-stack pharmacy management system with Angular frontend and Spring Boot backend.

## 📌 Features

### Frontend (Angular)
- User authentication (login/register)
- Product catalog management
- Shopping cart functionality
- Order processing
- Responsive UI design

### Backend (Spring Boot)
- RESTful API endpoints
- JWT authentication
- MySQL database integration
- AWS S3 file storage
- Email notification system

## 🛠️ Tech Stack

**Frontend:**
- Angular 15+
- TypeScript
- Bootstrap 5
- RxJS
- NgRx (State Management)

**Backend:**
- Spring Boot 3.x
- Spring Security
- JPA/Hibernate
- MySQL Database
- AWS S3 Integration
- JWT Authentication

## 🚀 Getting Started

### Prerequisites
- Node.js 16+ (for Angular)
- Java 17+ (for Spring Boot)
- MySQL 8.0+
- Maven 3.8+

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/aymenayoun/triplea-pharma.git
   cd triplea-pharma

2.**Backend Setup**

bash
Copy
cd backend
# Create application.properties from example
cp src/main/resources/application.properties.example src/main/resources/application.properties
# Update the properties with your credentials
mvn spring-boot:run

3.**Frontend Setup**

bash
Copy
cd ../frontend
npm install
ng serve

**⚙️ Configuration**
* Backend Configuration
Create application.properties from the example file and configure:

Database connection

AWS S3 credentials

JWT secret

Email service settings

* Frontend Configuration
Configure environment variables in:

src/environments/environment.ts (development)

src/environments/environment.prod.ts (production)

🌐 API Documentation
API endpoints are available at:

Swagger UI: http://localhost:2424/swagger-ui.html

OpenAPI Docs: http://localhost:2424/v3/api-docs

📦 Deployment
Backend
bash
Copy
mvn clean package
java -jar target/triplea-pharma-0.0.1-SNAPSHOT.jar
Frontend
bash
Copy
ng build --prod
# Deploy the /dist folder to your hosting provider
🤝 Contributing
Fork the project

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📄 License
Distributed under the MIT License.

📧 Contact
Aymen Ayouni - ayouniaymen.inc@gmail.com

Project Link: https://github.com/aymenayoun/triplea-pharma



   
