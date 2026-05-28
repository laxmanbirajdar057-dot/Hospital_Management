# 🏥 Hospital Management System

A Spring Boot REST API for managing patients, doctors, appointments, and billing.

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.2**
- **Spring Data JPA**
- **MySQL**
- **Maven**



---

## ⚙️ Setup Instructions

### 1. Prerequisites
- Java 17+
- MySQL running locally
- Maven

### 2. Configure Database

Open `src/main/resources/application.properties` and update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password
```

> The database `hospital_db` will be **auto-created** on first run.

### 3. Run the Project

```bash
cd hospital-management
mvn spring-boot:run
```

App starts at: `http://localhost:8080`

---

## 📁 Project Structure

```
src/main/java/com/hospital/
├── HospitalManagementApplication.java
├── model/
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   └── Bill.java
├── repository/
│   ├── PatientRepository.java
│   ├── DoctorRepository.java
│   ├── AppointmentRepository.java
│   └── BillRepository.java
├── service/
│   ├── PatientService.java
│   ├── DoctorService.java
│   ├── AppointmentService.java
│   └── BillingService.java
├── controller/
│   ├── PatientController.java
│   ├── DoctorController.java
│   ├── AppointmentController.java
│   └── BillingController.java
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## 🔗 API Endpoints

### 👤 Patient APIs — `/api/patients`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Add new patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |
| GET | `/api/patients/search?name=John` | Search by name |
| GET | `/api/patients/bloodgroup/A+` | Filter by blood group |

### 🩺 Doctor APIs — `/api/doctors`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/doctors` | Get all doctors |
| GET | `/api/doctors/{id}` | Get doctor by ID |
| POST | `/api/doctors` | Add new doctor |
| PUT | `/api/doctors/{id}` | Update doctor |
| DELETE | `/api/doctors/{id}` | Delete doctor |
| GET | `/api/doctors/available` | Get available doctors |
| GET | `/api/doctors/specialization/Cardiology` | Filter by specialization |
| GET | `/api/doctors/department/ICU` | Filter by department |

### 📅 Appointment APIs — `/api/appointments`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/appointments` | Get all appointments |
| GET | `/api/appointments/{id}` | Get appointment by ID |
| POST | `/api/appointments/book?patientId=1&doctorId=2` | Book appointment |
| PUT | `/api/appointments/{id}/status?status=COMPLETED` | Update status |
| PUT | `/api/appointments/{id}/cancel` | Cancel appointment |
| GET | `/api/appointments/patient/{patientId}` | Get by patient |
| GET | `/api/appointments/doctor/{doctorId}` | Get by doctor |
| GET | `/api/appointments/status/SCHEDULED` | Filter by status |

### 💰 Billing APIs — `/api/bills`

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/bills` | Get all bills |
| GET | `/api/bills/{id}` | Get bill by ID |
| POST | `/api/bills?patientId=1&appointmentId=1` | Create bill |
| PUT | `/api/bills/{id}/pay` | Mark bill as paid |
| GET | `/api/bills/patient/{patientId}` | Get bills by patient |
| GET | `/api/bills/status/PENDING` | Filter by payment status |
| DELETE | `/api/bills/{id}` | Delete bill |

---

## 📝 Sample Request Bodies

### Create Patient
```json
POST /api/patients
{
  "name": "Ravi Sharma",
  "age": 35,
  "gender": "Male",
  "email": "ravi@example.com",
  "phone": "9876543210",
  "address": "Mumbai, Maharashtra",
  "admissionDate": "2024-01-15",
  "bloodGroup": "B+"
}
```

### Create Doctor
```json
POST /api/doctors
{
  "name": "Dr. Priya Mehta",
  "specialization": "Cardiology",
  "email": "priya@hospital.com",
  "phone": "9123456789",
  "department": "Cardiology",
  "experienceYears": 10
}
```

### Book Appointment
```json
POST /api/appointments/book?patientId=1&doctorId=1
{
  "appointmentDateTime": "2024-02-10T10:30:00",
  "reason": "Chest pain and breathlessness"
}
```

### Create Bill
```json
POST /api/bills?patientId=1&appointmentId=1
{
  "consultationFee": 500.0,
  "medicineCost": 300.0,
  "testCharges": 1200.0,
  "billDate": "2024-02-10"
}
```

---

## 🔄 Enums Reference

- **Appointment Status:** `SCHEDULED`, `COMPLETED`, `CANCELLED`
- **Payment Status:** `PENDING`, `PAID`, `CANCELLED`

---

## 💡 Key Features

- Full CRUD for Patients, Doctors, Appointments, Billing
- Relationship mapping: Appointment links Patient + Doctor
- Bill auto-calculates total (consultation + medicine + tests)
- Global exception handling with proper HTTP status codes
- Search and filter endpoints for each entity
