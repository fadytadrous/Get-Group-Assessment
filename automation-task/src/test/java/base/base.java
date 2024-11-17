package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.ExtentTestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.RegisterPage;
import org.testng.ITestContext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class base {

    protected WebDriver driver;
    protected Properties properties = new Properties();

    protected RegisterPage RegisterPage;
    protected ConfirmationPage ConfirmationPage;
    protected LoginPage LoginPage;


    /**
     * Method to set up the WebDriver instance and navigate to the application URL before each test method.
     * It initializes the WebDriver using WebDriverManager for Chrome, navigates to the application URL,
     * maximizes the browser window, and initializes the RegisterPage object.
     * For the sake of making all tests in one run under RegisterTests Class BeforeMethod was used
     */
    @BeforeMethod
    public void setup(ITestContext context) throws IOException {
        // Setup WebDriver using WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized");


        driver = new ChromeDriver(options);
        context.setAttribute("WebDriver", driver);


        // Navigate to the application URL and maximize the window
        driver.get("https://phptravels.net/signup");

        // Load the properties file
        properties.load(Files.newInputStream(Paths.get("src/main/resources/config.properties")));

        // Initialize the RegisterPage and confirmationPage object
        RegisterPage = new RegisterPage(driver);
        ConfirmationPage = new ConfirmationPage(driver);
        LoginPage = new LoginPage(driver);

    }

    /**
     * Method to tear down the WebDriver instance after executing tests.
     * Quits the WebDriver session.
     * For the sake of making all tests in one run under searchTest Class AfterMethod was used
     */
    @AfterMethod
    public void tearDown(){
        // Quit the WebDriver session
        driver.quit();
    }


}
