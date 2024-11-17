package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class commonMethods {
    public static String generateRandomEmail() {
        // Generate a random UUID
        String randomString = UUID.randomUUID().toString().substring(0, 8); // 8 characters for brevity

        // Return email with random string and specified domain
        return randomString + "@gmail.com" ;
    }

    public static void setInputField(WebElement element, String text) {
        // Clear the existing text in the input field
        element.clear();

        // Send the new text
        element.sendKeys(text);
    }
    // Method to wait for text in confirmationMsg
    public static String waitForMsgAndRetrieve(WebDriver driver, WebElement element){

        // Wait for the expected text to appear in the confirmation message
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
        // Retrieve and return the text after ensuring it is present
        return element.getText();
    }
}
