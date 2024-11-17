package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;  // WebDriver instance to interact with the browser

    public static String confirmedEmail;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    @FindBy(id = "email")
    public WebElement loginEmail;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submitBTN")
    public WebElement loginBtn;

    @FindBy(css = "div.text-group h4")
    public WebElement accountActivationMsg;

//    Account not active

}
