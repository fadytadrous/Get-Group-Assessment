package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.UUID;

public class RegisterPage {
    private final WebDriver driver;  // WebDriver instance to interact with the browser

    /**
     * Constructor to initialize the RegisterPage object with WebDriver instance.
     * @param driver WebDriver instance
     */
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements representing search elements on the page

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(css = "div.dropdown button")
    public WebElement countrySelect;

    @FindBy(xpath = "//span[contains(text(), 'Egypt')]")
    public WebElement egyptCode;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "user_email")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(css = "span.recaptcha-checkbox")
    public WebElement recaptcha;

    @FindBy(id = "submitBTN")
    public WebElement submitBtn;

    @FindBy(css = "button.cc-dismiss ")
    public WebElement dismissCookieBtn;

    @FindBy(css = "p strong")
    public WebElement confirmationMsg;

    private WebElement findElementByText(String text) {
        // Create a dynamic XPath
        String xpath = String.format("//span[contains(text(), '%s')]", text);

        // Find and return the element
        return driver.findElement(By.xpath(xpath));
    }



    public void selectCountry(String countryName) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(this.countrySelect)).click();

        WebElement countryItem = findElementByText(countryName);
        countryItem.click();
    }

    public void clickSubmit(){
        dismissCookieBtn.click();
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,500).perform();
        // Remove the 'disabled' attribute using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].removeAttribute('disabled');", submitBtn);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

    }





}
