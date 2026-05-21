# Selenium Automation Framework

A Hybrid Test Automation Framework built using Java, Selenium WebDriver, TestNG, Maven, and Page Object Model (POM) design pattern.

---

## 🚀 Features

- Selenium WebDriver
- Java Automation Framework
- TestNG Framework
- Page Object Model (POM)
- Extent Reports
- Screenshot Capture on Failure
- WebDriverManager Integration
- Configurable Browser & URL
- Reusable Base Classes
- Explicit Waits
- Utility Classes
- Scalable Framework Structure

---

## 🛠️ Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- WebDriverManager

---

## 📁 Project Structure

```text
src
 ├── main
 │    ├── java
 │    │     ├── pages
 │    │     ├── utils
 │    │     ├── drivers
 │    │     └── base
 │
 ├── test
 │    ├── java
 │    │     └── tests
 │
 └── resources
       └── config.properties
```

---

## ⚙️ Framework Components

### BaseTest
Handles:
- Browser setup
- Driver initialization
- Test setup & teardown
- Extent report initialization
- Screenshot capture on failure

### BasePage
Contains reusable Selenium methods:
- click()
- type()
- getText()
- waits

### DriverFactory
Handles browser driver creation.

### ConfigReader
Reads data from `config.properties`.

### ExtentReportManager
Generates HTML execution reports.

---

## ▶️ Running Tests

### Run using Maven

```bash
mvn test
```

### Run specific TestNG XML

```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 📸 Reporting

- Extent HTML reports generated after execution
- Screenshots captured automatically on failure

Report Location:

```text
reports/TestReport.html
```

---

## 🧪 Sample Test Scenarios

- Login Functionality
- Invalid Login Validation
- Add to Cart
- Checkout Flow
- Order Confirmation Validation

---

## 📌 Design Patterns Used

- Page Object Model (POM)
- Factory Design Pattern
- Reusable Utility Pattern

---

## 👨‍💻 Author

Mohit Sharma
