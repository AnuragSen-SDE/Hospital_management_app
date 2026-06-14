# Healthcare ERP Backend

A production-inspired Healthcare ERP Backend built using Java, Spring Boot, Spring Security, JPA/Hibernate, and PostgreSQL.

This project simulates a real-world healthcare management system where hospital staff can manage patients, doctors, appointments, prescriptions, medicines, billing, insurance, and payments through a secure JWT-based authentication and Role-Based Access Control (RBAC) system.

---

# Features

## Authentication & Security

* JWT Authentication
* Spring Security Integration
* BCrypt Password Encryption
* Custom JWT Authentication Filter
* Role-Based Access Control (RBAC)
* Method-Level Authorization using `@PreAuthorize`
* Database-driven Roles and Permissions
* Custom Authentication Entry Point
* Custom Access Denied Handler

### RBAC Architecture

```text
User
 ↓
Role
 ↓
Permission
```

### Example Roles

* ROLE_ADMIN
* ROLE_DOCTOR
* ROLE_PATIENT
* ROLE_RECEPTIONIST

### Example Permissions

* PATIENT_CREATE
* PATIENT_VIEW
* DOCTOR_CREATE
* APPOINTMENT_CREATE
* APPOINTMENT_UPDATE
* PRESCRIPTION_CREATE
* PRESCRIPTION_UPDATE
* PRESCRIPTION_VIEW
* BILL_CREATE
* BILL_VIEW
* PAYMENT_PROCESS
* MEDICINE_CREATE
* MEDICINE_UPDATE

---

# Core Modules

## Patient Management

Features:

* Register Patient
* View Patient Records
* Patient Validation
* Patient Authentication Integration

Business Rules:

* Duplicate patient emails are prevented.
* Patient records are linked with authenticated users.

---

## Doctor Management

Features:

* Register Doctors
* Manage Doctor Profiles
* Doctor Availability Tracking

Business Rules:

* Duplicate doctor emails are prevented.
* Duplicate room assignments are prevented.

---

## Appointment Management

Features:

* Book Appointments
* Update Appointment Status
* Retrieve Appointment Details

Business Rules:

* Appointments cannot be booked in the past.
* Doctors cannot be double-booked.
* Patients cannot have overlapping appointments.
* Doctor availability is validated before scheduling.
* Completed appointments cannot be modified.

---

## Prescription Management

Features:

* Generate Prescriptions
* Add Medicines to Prescriptions
* Finalize Prescriptions
* Retrieve Prescription Details

Business Rules:

* One prescription per appointment.
* Prescription linked to doctor, patient, and appointment.
* Medicine stock validation before prescription generation.
* Automatic medicine stock deduction.

---

## Medicine Management

Features:

* Register Medicines
* Manage Inventory
* Update Medicine Stock

Business Rules:

* Medicine stock cannot be negative.
* Inventory updates are transactional.

---

## Billing Management

Features:

* Generate Bills
* Retrieve Billing Details
* Billing Item Management

Business Rules:

* One bill per prescription.
* Consultation fee automatically included.
* Medicine charges automatically calculated.
* Total and due amounts calculated dynamically.

Billing Components:

* Consultation Fee
* Prescribed Medicines

---

## Payment Processing

Features:

* Process Payments
* Track Payment Status
* Generate Transaction IDs

Business Rules:

* Overpayment is prevented.
* Billing status automatically updated.
* Partial payments supported.
* Supports CASH and Digital Payments.

Payment States:

* PENDING
* PAID

Billing States:

* PENDING
* PARTIALLY_PAID
* PAID

---

## Insurance Management

Features:

* Create Insurance Policies
* Associate Insurance with Patients

Business Rules:

* Duplicate policy numbers are prevented.
* One patient cannot have duplicate insurance records.

---

# Security Architecture

## Authentication Flow

```text
Login Request
      ↓
AuthenticationManager
      ↓
CustomUserDetailsService
      ↓
JWT Generation
      ↓
JWT Validation Filter
      ↓
Security Context
```

## Authorization Flow

```text
User
 ↓
Role
 ↓
Permissions
 ↓
GrantedAuthority
 ↓
@PreAuthorize
```

Example:

```java
@PreAuthorize("hasAuthority('PATIENT_VIEW')")
```

```java
@PreAuthorize("hasAuthority('PRESCRIPTION_CREATE')")
```

---

# Global Exception Handling

Centralized exception handling using `@RestControllerAdvice`.

Handled Exceptions:

* AppointmentException
* DoctorException
* PatientException
* PrescriptionException
* BillingException
* InsuranceException
* PaymentException
* MedicineException
* UserException
* RoleException
* Validation Exceptions

Provides consistent API error responses.

---

# Technology Stack

## Backend

* Java 17
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

## Database

* PostgreSQL

## Security

* JWT
* BCrypt

## Build Tool

* Maven

---

# Design Patterns & Concepts Used

* Layered Architecture
* DTO Pattern
* Mapper Pattern
* Repository Pattern
* Service Layer Pattern
* Dependency Injection
* Transaction Management
* RBAC Authorization
* Exception Handling Strategy

---

# Database Design

Core Tables:

* users
* roles
* permissions
* role_permissions
* patients
* doctors
* appointments
* prescriptions
* prescription_medicines
* medicines
* billings
* billing_items
* payments
* insurances

---

# Sample Business Workflow

Patient Visit Flow

```text
Patient Registration
        ↓
Appointment Booking
        ↓
Doctor Consultation
        ↓
Prescription Generation
        ↓
Medicine Assignment
        ↓
Bill Generation
        ↓
Payment Processing
```

---

# Future Enhancements

* Audit Logging
* Notification Service
* Reporting Dashboard
* Docker Deployment
* CI/CD Pipeline
* Unit Testing
* Integration Testing
* Email Notifications
* Appointment Reminders

---

# Key Learning Outcomes

This project was built to gain practical experience in:

* Enterprise Backend Development
* Spring Security
* JWT Authentication
* Role-Based Access Control
* REST API Design
* Database Modeling
* Business Logic Design
* Transaction Management
* Exception Handling
* Healthcare Domain Modeling

---

# Author

Anurag Sen

Java Backend Developer

Tech Stack:
Java • Spring Boot • Spring Security • Hibernate • PostgreSQL
