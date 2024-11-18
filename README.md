# Get-Group-Assessment

## How to Run the Tests
To execute the test cases, you can simply run the `testng.xml` file. It contains all the test configurations and specifies the test methods to be executed.

## Test Class Details
All the test cases are located in the `registerTests` class. These tests focus on user registration functionality and cover various input scenarios.

## Object-Oriented Model Used
The **Page Object Model (POM)** was implemented for this project to separate the test scripts from the underlying UI elements. This enhances readability, maintainability, and reusability of the code.

### Page Structure
The page classes are organized as follows:
- All page classes are located under the `main/java/pages` directory.
- **Classes Created:**
  - `RegistrationPage`: Handles UI elements and actions for the registration form.
  - `LoginPage`: Manages login page interactions.
  - `ConfirmationPage`: Includes methods for verifying registration success messages.

## Data Insertion
The test data is managed using the `config.properties` file, which is located under the `resources` folder. This file contains all the configurable data such as user credentials, URLs, and other test parameters.

## Base Class
The `base Class` handles all the setup and teardown tasks required for running the tests. It includes:
- **Driver Instantiation**: Initializes the WebDriver.
- **`@BeforeMethod` and `@AfterMethod`**: Configures the preconditions and postconditions for each test case.

## Report Generation
Test execution results are captured using **ExtentReports**. Version 5.1.2 of ExtentReports is used, as defined in the `pom.xml` file. The reports are generated in an HTML format and include:
- Test execution details.
- Screenshots for failed test cases.

## File Organization Summary
- **Test Scripts**: `registerTests` class.
- **Page Classes**: `RegistrationPage`, `LoginPage`, and `ConfirmationPage` under `main/java/pages`.
- **Configuration**: `config.properties` under `resources`.
- **Base Class**: Contains WebDriver setup and test lifecycle methods.
- **Reports**: Generated using ExtentReports version 5.1.2.

---
# Test Cases for the Workflow

## Test Case 1: Verify Successful Thumbprint Authentication
- **Priority**: High  
- **Explanation**: Ensure the system correctly matches the user's thumbprint during authentication. This is the first critical step for any transaction.

---

## Test Case 2: Verify Retry Mechanism for Thumbprint Mismatch
- **Priority**: High  
- **Explanation**: Validate that the system allows users to retry thumbprint verification if the initial attempt fails.

---

## Test Case 3: Verify System Behavior for Thumbprint Mismatch After All Retries
- **Priority**: Medium  
- **Explanation**: Confirm that the system terminates the process if the user's thumbprint fails to match after the maximum number of retries.

---

## Test Case 4: Verify PIN Verification on Thumbprint Match
- **Priority**: High  
- **Explanation**: Ensure the system prompts the user for PIN entry after successful thumbprint verification.

---

## Test Case 5: Verify Retry Mechanism for Incorrect PIN
- **Priority**: High  
- **Explanation**: Validate that the system allows up to three attempts for entering the correct PIN.

---

## Test Case 6: Verify System Behavior for Exceeding PIN Attempts
- **Priority**: High  
- **Explanation**: Ensure the system blocks further access and terminates the transaction process if the user exceeds three incorrect PIN attempts.

---

## Test Case 7: Verify ATM Transaction on Successful PIN Entry
- **Priority**: High  
- **Explanation**: Confirm that the system allows the user to proceed with ATM transactions after successful PIN verification.

---

## Test Case 8: Verify System Logs for Thumbprint and PIN Events
- **Priority**: Medium  
- **Explanation**: Ensure that the system logs every thumbprint and PIN verification attempt for auditing and security purposes.

---

## Test Case 9: Verify Error Messaging for Thumbprint and PIN Issues
- **Priority**: Medium  
- **Explanation**: Validate that the system displays clear and actionable error messages for thumbprint mismatches or incorrect PIN entries.

---

## Test Case 10: Verify End-to-End Flow for Successful Transaction
- **Priority**: High  
- **Explanation**: Ensure the user can complete the entire process—thumbprint verification, PIN entry, and transaction—successfully without any issues.

---

## Test Case 11: Verify System Timeout for Inactive Sessions
- **Priority**: Low  
- **Explanation**: Confirm that the system times out and terminates the process if the user remains inactive during thumbprint or PIN verification steps.

---

## Test Case 12: Verify ATM Transaction within the user balance
- **Priority**: High  
- **Explanation**: Confirm that the system allows only transactions within the balance of the user by trying to take the whole balance.

---

## Test Case 13: Verify ATM Transaction above the user balance
- **Priority**: High  
- **Explanation**: Confirm that the system allows only transactions within the balance of the user by trying to take more than the balance.
---
