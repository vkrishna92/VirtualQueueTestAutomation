# Virtual Queue Test Automation

A comprehensive Selenium-based test automation framework for testing Virtual Queue application across multiple platforms (Desktop, Mobile, Tablet).

## 🚀 Features

### Multi-Platform Support
- **Desktop Testing**: Full desktop browser automation
- **Mobile Testing**: Mobile-responsive UI testing
- **Tablet Testing**: Tablet-specific UI validation
- **Cross-Platform Factory Pattern**: Automatic page object selection based on platform

### Test Framework Architecture
- **Page Object Model (POM)**: Clean separation of test logic and page elements
- **Page Factory Pattern**: Dynamic page object instantiation based on platform
- **Interface-Based Design**: Consistent API across different platform implementations
- **Base Page Classes**: Reusable WebDriver utilities and wait strategies

### Environment Management
- **Multi-Environment Support**: Dev, QA, and Staging configurations
- **Property-Based Configuration**: Environment-specific settings via properties files
- **Dynamic Environment Loading**: Runtime environment selection via TestNG parameters

### Logging & Reporting
- **Log4j2 Integration**: Comprehensive logging with console and file output
- **Structured Logging**: Timestamped logs with different severity levels
- **Test Execution Logs**: Detailed test step logging for debugging

### Test Data Management
- **Environment-Specific Test Data**: Separate test data for QA and Staging
- **JSON-Based Data Storage**: Structured test data in JSON format
- **Configurable Queue Settings**: Dynamic queue ID and base URL configuration

## 🏗️ Project Structure

```
VirtualQueueTestAutomation/
├── src/
│   ├── main/java/com/virtualqueue/
│   │   ├── pageobjects/
│   │   │   ├── desktop/           # Desktop-specific page objects
│   │   │   ├── mobile/            # Mobile-specific page objects
│   │   │   ├── tablet/            # Tablet-specific page objects
│   │   │   ├── pagefactory/       # Factory classes for page creation
│   │   │   ├── pagerepository/    # Interface definitions
│   │   │   └── BasePage.java      # Common WebDriver utilities
│   │   └── utils/
│   │       └── LoggerHelper.java  # Logging utility
│   └── test/java/com/virtualqueue/
│       ├── uitests/               # UI test classes
│       ├── apitests/              # API test placeholder
│       ├── bddtests/              # BDD test placeholder
│       ├── sanity/                # Sanity test placeholder
│       └── utils/
│           └── PropertyReader.java # Configuration management
├── src/test/resources/
│   ├── config/                    # Environment configurations
│   ├── testdata/                  # Test data files
│   ├── testng-desktop-qa.xml      # Desktop test suite
│   └── testng-mobile-qa.xml       # Mobile test suite
└── logs/                          # Test execution logs
```

## 🧪 Test Scenarios

### Add to Queue Tests
- **Page Verification**: Validates presence of all form elements
- **Banner Validation**: Verifies restaurant name and branding
- **Form Functionality**: Tests customer name input and party size selection
- **Queue Joining**: End-to-end queue joining workflow
- **Status Verification**: Confirms customer status after joining queue

### Customer Status Tests
- **Status Page Navigation**: Validates redirect after queue joining
- **Customer Information Display**: Verifies name and party size display
- **Queue Status Tracking**: Confirms waiting status indication

## 🛠️ Technology Stack

- **Java**: Core programming language
- **Selenium WebDriver 4.35.0**: Browser automation
- **TestNG 7.11.0**: Test framework and execution
- **Log4j2 2.25.0**: Logging framework
- **Maven**: Build and dependency management
- **Chrome WebDriver**: Primary browser for testing

## ⚙️ Configuration

### Environment Properties
```properties
# QA Environment (qa.properties)
app.baseUrl=http://localhost:4200/
app.queueId=3fa85f64-5717-4562-b3fc-2c963f66afa6
```

### TestNG Suite Configuration
- **Desktop Suite**: `testng-desktop-qa.xml`
- **Mobile Suite**: `testng-mobile-qa.xml`
- **Parameterized Execution**: Environment and platform selection

## 🚦 Getting Started

### Prerequisites
- Java 8 or higher
- Maven 3.6+
- Chrome browser
- ChromeDriver (managed by Selenium Manager)

### Running Tests

#### Desktop Tests
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-desktop-qa.xml
```

#### Mobile Tests
```bash
mvn test -DsuiteXmlFile=src/test/resources/testng-mobile-qa.xml
```

#### Custom Environment
```bash
mvn test -Denv=stg -Dplatform=desktop
```

## 📋 Test Execution Flow

1. **Suite Setup**: Environment configuration and WebDriver initialization
2. **Test Setup**: Navigate to specific page and initialize page objects
3. **Test Execution**: Run test scenarios with assertions
4. **Logging**: Capture detailed execution logs
5. **Cleanup**: Browser cleanup and resource disposal

## 🔧 Key Design Patterns

### Factory Pattern
- **AddToPageFactory**: Creates platform-specific page objects
- **ViewToCustomerStatusPageFactory**: Handles status page instantiation

### Interface Segregation
- **IAddToQueuePage**: Defines add-to-queue operations
- **IViewToCustomerStatusPage**: Defines status page operations

### Base Class Hierarchy
- **BasePage**: Common WebDriver utilities
- **BaseDesktopPage/BaseMobilePage/BaseTabletPage**: Platform-specific base classes

## 📊 Logging Configuration

- **Console Output**: Real-time test execution feedback
- **File Logging**: Persistent logs in `logs/test.log`
- **Configurable Levels**: INFO, DEBUG, WARN, ERROR support
- **Timestamped Entries**: Detailed execution timeline

## 🎯 Future Enhancements

- API testing implementation in `apitests` package
- BDD testing with Cucumber in `bddtests` package
- Sanity test suite development
- Cross-browser testing support
- Parallel test execution
- Test reporting with ExtentReports
- CI/CD pipeline integration