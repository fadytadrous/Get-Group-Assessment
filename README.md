# Get-Group-Assessment

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
