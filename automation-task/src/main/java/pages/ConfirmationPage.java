package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConfirmationPage {

    private final WebDriver driver;  // WebDriver instance to interact with the browser
    public String url = "https://phptravels.net/signup_success";

    /**
     * Constructor to initialize the RegisterPage object with WebDriver instance.
     * @param driver WebDriver instance
     */
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p strong")
    public WebElement confirmationMsg;




}
