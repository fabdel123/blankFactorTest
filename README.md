# 🚀 BlankFactor Automation Framework

Automated testing framework built with **Java**, **Selenium WebDriver**, **Cucumber**, and **Maven**, designed to validate the functionality of the BlankFactor website through maintainable and scalable practices.

---

## 📁 Project Structure

```
blankfactor-automation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/              # Page Object classes (HomePage, ContactPage, etc.)
│   │   │   └── utils/              # Shared utilities (DriverFactory, ConfigReader, DataStore)
│   └── test/
│       ├── java/
│       │   ├── hooks/              # Test lifecycle hooks (Before, After)
│       │   ├── runners/            # Cucumber test runners
│       │   ├── stepdefinitions/    # Step definitions for Gherkin scenarios
│       └── resources/
│           ├── features/           # Gherkin .feature files
│           └── config.properties   # Environment configuration
```

---

## 🛠 Tech Stack

- **Java 17+**
- **Maven**
- **Selenium WebDriver 4+**
- **Cucumber 7+**
- **WebDriverManager**
- **JUnit 4**
- **SLF4J (Logging)**
- *(Optional: Allure / ExtentReports for reporting)*

---

## 🚦 How to Run the Project

1. **Clone the repository:**
```bash
git clone https://github.com/fabdel123/blankFactorTest.git
cd blankFactorTest
```

2. **Run tests with Maven:**
```bash
mvn clean test
```

---

## 🌐 Configuration

All environment-specific values are stored in:

```
src/test/resources/config.properties
```

Example:
```
base.url=https://blankfactor.com
browser=chrome
```

---

## ✅ Features Automated

- Accept cookies
- Navigate to **Industries > Retirement and Wealth**
- Scroll and capture the text of the third tile in the **"Powering Innovation"** section
- Click on **"Let's Get Started"** and validate navigation to the Contact page
- BlankFactor page, get the page URL
- BlankFactor page, verify the page URL is correct **"https://blankfactor.com/contact/"**

---

## 💡 Best Practices Applied

- Page Object Model (POM)
- Separation of concerns
- Explicit waits over hardcoded sleeps
- Assert-based validations
- Centralized WebDriver management
- Logging with SLF4J
- Maintainable naming conventions (camelCase)

---

## 🔧 Future Improvements

- CI integration (GitHub Actions)
- Reporting (Allure or ExtentReports)
- Cross-browser testing support
- Docker-based test execution

---

## 👤 Author

**Fabián de la Rosa**  
QA Automation Engineer
