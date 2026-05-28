# Hospital Management System

A backend project built using Java and Spring Boot. It manages patients, doctors, appointments and billing for a hospital.

---

## About the Project

I built this project to understand how REST APIs work in real world applications. A hospital needs to manage a lot of data like patient records, doctor schedules, appointments and bills. So I thought this would be a good project to practice.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

I did not use Lombok because it was causing errors, so all getters and setters are written manually.

---


## Features

- Add, update, delete and view patients
- Add, update, delete and view doctors
- Book appointments between patient and doctor
- Generate bills and mark them as paid

---

## API Endpoints

**Patients**
- GET /api/patients - get all patients
- GET /api/patients/{id} - get one patient
- POST /api/patients - add patient
- PUT /api/patients/{id} - update patient
- DELETE /api/patients/{id} - delete patient

**Doctors**
- GET /api/doctors - get all doctors
- POST /api/doctors - add doctor
- PUT /api/doctors/{id} - update doctor
- DELETE /api/doctors/{id} - delete doctor
- GET /api/doctors/available - get available doctors

**Appointments**
- GET /api/appointments - get all appointments
- POST /api/appointments/book?patientId=1&doctorId=1 - book appointment
- PUT /api/appointments/{id}/cancel - cancel appointment

**Billing**
- GET /api/bills - get all bills
- POST /api/bills?patientId=1&appointmentId=1 - create bill
- PUT /api/bills/{id}/pay - mark as paid

---

## What I Learned

- How Spring Boot works
- How to connect Java with MySQL
- How to create REST APIs
- How JPA handles database tables automatically
- Layered structure - controller, service, repository

---


Laxman Birajdar
GitHub - https://github.com/laxmanbirajdar057-dot
