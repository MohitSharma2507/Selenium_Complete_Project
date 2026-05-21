# Selenium Automation Framework

A Hybrid Test Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM) design pattern.

---

# 🚀 Features

- Selenium WebDriver
- Java Automation Framework
- TestNG Framework
- Maven Build Management
- Page Object Model (POM)
- Extent Reports Integration
- Screenshot Capture on Failure
- WebDriverManager Support
- Configurable Environment using Properties File
- Excel Data Driven Testing
- Reusable Utility Classes
- Explicit Waits Implementation

---

# 🛠️ Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Extent Reports
- WebDriverManager

---

# 📁 Project Structure

```text
New_Selenium_project
│
├── .mvn
├── reports
│     └── TestReport.html
│
├── screenshots
│
├── src
│   ├── main
│   │   └── java
│   │       ├── drivers
│   │       │     └── DriverFactory.java
│   │       │
│   │       ├── pages
│   │       │     ├── BasePage.java
│   │       │     ├── LoginPage.java
│   │       │     ├── InventoryPage.java
│   │       │     ├── CartPage.java
│   │       │     └── CheckoutPage.java
│   │       │
│   │       └── utils
│   │             ├── ConfigReader.java
│   │             ├── ExcelReader.java
│   │             ├── ExcelDataProvider.java
│   │             └── ExtentReportManager.java
│   │
│   └── test
│       ├── java
│       │   ├── base
│       │   │     └── BaseTest.java
│       │   │
│       │   └── tests
│       │         ├── LoginTest.java
│       │         └── CheckoutFlowTest.java
│       │
│       └── resources
│             ├── config.properties
│             └── testData
│                   └── LoginData.xlsx
│
├── testng.xml
├── pom.xml
└── .gitignore
```

---

# ⚙️ Framework Components

## BaseTest
Handles:
- Browser setup & teardown
- Driver initialization
- Test execution setup
- Extent report setup
- Screenshot capture on failure

---

## BasePage
Contains reusable Selenium methods:
- click()
- type()
- getText()
- explicit waits

---

## DriverFactory
Responsible for browser driver initialization and management.

---

## ConfigReader
Reads configuration values from `config.properties`.

---

## ExcelDataProvider
Provides test data from Excel files for Data-Driven Testing.

---

## ExtentReportManager
Generates HTML execution reports with logs and screenshots.

---

# 🧪 Test Scenarios Covered

- Valid Login
- Invalid Login
- Add Product to Cart
- Complete Checkout Flow
- Order Confirmation Validation

---

# ▶️ Run Tests

## Run all tests

```bash
mvn test
```

---

## Run using TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

# 📸 Reporting

- Extent HTML reports generated after execution
- Screenshots captured automatically on failure

### Report Location

```text
reports/TestReport.html
```

---

# 📌 Design Patterns Used

- Page Object Model (POM)
- Factory Design Pattern
- Utility Pattern

---

# 🔥 Highlights

- Scalable framework architecture
- Reusable code structure
- Easy maintenance
- Data-driven testing support
- Professional reporting integration

---

# 👨‍💻 Author

Mohit Sharma
