# 🏥 Hospital Management System

A backend-based Hospital Management System developed using **Spring Boot**, **Hibernate**, and **PostgreSQL**. This application provides RESTful APIs to manage hospital operations such as handling patients, doctors, and receptionists efficiently.

## 🚀 Features

* 👨‍⚕️ Manage Doctors (Add, View, Update, Delete)
* 🧑‍🤝‍🧑 Manage Patients
* 🧾 Manage Receptionists
* 🔗 RESTful API architecture
* 🏗️ Layered Architecture (Controller, Service, Repository)
* 🔄 DTO Pattern implementation to avoid infinite recursion
* 🗄️ PostgreSQL database integration
* ⚡ Efficient data handling using Spring Data JPA

## 🛠️ Technologies Used

* **Java**
* **Spring Boot**
* **Hibernate (JPA)**
* **PostgreSQL**
* **Maven**
* **Postman** (for API testing)
  
## 📂 Project Structure

src/main/java/com/example/hospitalmanagement
│
├── controller      # REST Controllers
├── service         # Business logic
├── repository      # Database layer
├── dto             # Data Transfer Objects
├── entity          # JPA Entities
└── HospitalManagementApplication.java

## 🔌 API Endpoints

### 👤 Patient

* `POST /patient/save` → Add a new patient
* `GET /patient/{id}` → Get patient by ID
* `GET /patient/all` → Get all patients
* `PUT /patient/update` → Update patient
* `DELETE /patient/{id}` → Delete patient

## 📥 Sample Request (POST)

POST /patient/save
```

```json
{
  "id": 1006,
  "age": 35,
  "gender": "male",
  "name": "Alex",
  "doctorId": 1,
  "receptionistId": 101
}

## ⚙️ Setup Instructions

1. Clone the repository

git clone https://github.com/your-username/hospital-management-system.git

2. Open in IDE (Eclipse / IntelliJ)

3. Configure PostgreSQL database in `application.properties`

properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

4. Run the application

5. Test APIs using Postman

## 📸 API Testing

Use **Postman** to test all endpoints.

## 💡 Key Learning

* Built REST APIs using Spring Boot
* Implemented layered architecture
* Handled JPA relationships using DTO
* Integrated PostgreSQL database
* Debugged real-world backend issues

## 👨‍💻 Author

**Rakesh Kumar Mohanta**
📧 [rakeshkumarmohanta04@gmail.com](mailto:rakeshkumarmohanta04@gmail.com)

