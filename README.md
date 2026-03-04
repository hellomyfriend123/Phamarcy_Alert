# PharmaLedger Auto Alert

PharmaLedger Auto Alert is a Java Web (Servlet + JSP) system for managing pharmacy inventory, expiry tracking, automatic alerts, and audit logging.

The system focuses on reducing stockout, minimizing expiry waste, and improving audit transparency in hospital pharmacy warehouses.

---

## 🎯 Problem Context

Pharmacy warehouses often face:

- Stockout risk
- Expiry waste cost
- Lack of traceable audit logs

Manual processes make it difficult to detect near-expiry batches, low stock levels, and abnormal inventory adjustments.

This system digitizes inventory operations with auto alert and AI-supported forecasting.

---

## 🏗 System Architecture

MVC2 Pattern (Java Web)

- **Controller:** Java Servlet
- **View:** JSP
- **Model:** JPA Entities (EclipseLink)
- **Database:** SQL Server
- **Server:** Apache Tomcat 9

---

## 🛠 Technology Stack

- NetBeans 13
- JDK 1.8.0_172
- Apache Tomcat 9
- Java Servlet & JSP
- JPA (EclipseLink)
- SQL Server (JDBC)
- Bootstrap (UI)

---

## 📦 Core Modules

### 1. Drug & Supplier Management
- CRUD Drug
- CRUD Supplier
- Search by name, active ingredient, supplier

### 2. Batch & Inventory Management
- Batch with expiry date
- Inventory by location
- Near-expiry search
- Low stock detection

### 3. Inbound / Outbound / Ledger
- Inbound Order
- Outbound Order
- Stock Ledger (audit log of all inventory movements)

### 4. Alert & Case Workflow
- Alert Rules
- Auto Alert Events
- Case Ticket assignment
- Case closing with evidence

### 5. AI Forecast Module
- Weekly demand forecast
- Reorder suggestion
- Forecast explanation

### 6. Audit & Blockchain Anchor
- Hash-based transaction verification
- Inventory change traceability

---

## 🗂 Main Entities

- Drugs
- Batches
- Suppliers
- InventoryBalances
- StockLedger
- AlertRules
- AlertEvents
- CaseTickets
- ForecastSeries
- ForecastPoints
- BlockchainAnchors

---

## 🔍 Advanced Search Features

- Search inventory by drug name, supplier, location
- Search near-expiry batches by days threshold
- Search low stock drugs
- Search transaction history by time and operator

---

## 📊 Evaluation Metrics

- Stockout Rate
- Expiry Waste Cost
- Service Level
- Forecast MAE / RMSE
- Alert Precision / Recall
- Time to Detect anomaly

---

## 🚀 How to Run the Project

### 1️⃣ Requirements

- NetBeans 13
- JDK 8u172
- Apache Tomcat 9
- SQL Server

### 2️⃣ Setup Database

- Create database in SQL Server
- Update JDBC configuration in:


- Update connection string, username, password

### 3️⃣ Deploy to Tomcat

- Open project in NetBeans
- Clean and Build
- Run on Tomcat 9

### 4️⃣ Access Application

---

## 👤 Author

Minh Phúc 
FPT University  
PRJ301 – Java Web Application Development