package base;

import org.testng.Assert;
import org.testng.annotations.Test;


import static helpers.commonMethods.*;


public class RegisterTests extends base {

    @Test
    public void testSuccessfulRegister()  {
        // Read valid data from properties file
        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String phone = properties.getProperty("validPhone");
        String password = properties.getProperty("validPassword");
        pages.LoginPage.confirmedEmail = generateRandomEmail();

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);

        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, pages.LoginPage.confirmedEmail);
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        String successMsg = waitForMsgAndRetrieve(driver, ConfirmationPage.confirmationMsg);
        // Assert that the current URL is as expected
        Assert.assertEquals(currentUrl, ConfirmationPage.url,
                "URL does not match the expected value.");


        Assert.assertEquals( successMsg,
                "Your account has been created" ,
                "No message for account creation" );

    }

    @Test(dependsOnMethods = {"testSuccessfulRegister"})
    public void testSuccessfulLogin(){
        driver.get("https://phptravels.net/login");
        String password = properties.getProperty("validPassword");

        setInputField(LoginPage.loginEmail, pages.LoginPage.confirmedEmail);
        setInputField(LoginPage.password,password);

        LoginPage.loginBtn.click();

        String accountNotActiveMsg = waitForMsgAndRetrieve(driver,LoginPage.accountActivationMsg);

        Assert.assertEquals( accountNotActiveMsg,
                "Account not active" ,
                "User is not created " );

    }

    @Test
    public void testFirstNameWithoutCapital() {
        // Read invalid first name from properties file
        String firstName = properties.getProperty("invalidFirstName");
        String lastName = properties.getProperty("validLastName");
        String phone = properties.getProperty("validPhone");
        String password = properties.getProperty("validPassword");

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);


        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, generateRandomEmail());
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Assert that the current URL is as expected
        Assert.assertNotEquals(currentUrl, ConfirmationPage.url,
                "Invalid first name");

    }

    @Test
    public void testInvalidEmail() {
        // Read invalid email from properties file

        String phone = properties.getProperty("validPhone");
        String email = properties.getProperty("invalidEmail");
        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String password = properties.getProperty("validPassword");

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);

        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, email);
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Validate that success message should not be displayed bec. of incorrect data
        Assert.assertNotEquals(currentUrl, ConfirmationPage.url,
                "Invalid email");
    }

    @Test
    public void testInvalidPhoneNumber() {
        // Read invalid phone number from properties file

        String phone = properties.getProperty("invalidPhone");

        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String password = properties.getProperty("validPassword");

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);

        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, generateRandomEmail());
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();


        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Validate that success message should not be displayed bec. of incorrect data
        Assert.assertNotEquals(currentUrl, ConfirmationPage.url,
                "Invalid phone number");
    }

    @Test
    public void testInvalidPassword() {
        // Read invalid email from properties file

        String phone = properties.getProperty("validPhone");
        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String password = properties.getProperty("invalidPassword");

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);

        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, generateRandomEmail());
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();


        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Validate that success message should not be displayed bec. of incorrect data
        Assert.assertNotEquals(currentUrl, ConfirmationPage.url,
                "Invalid email");
    }

    @Test
    public void testUniqueEmail() {
        // Read duplicate email from properties file that was registered before

        String phone = properties.getProperty("validPhone");
        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String password = properties.getProperty("invalidPassword");

        setInputField(RegisterPage.firstName, firstName);
        setInputField(RegisterPage.lastName, lastName);

        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        setInputField(RegisterPage.phone, phone);
        setInputField(RegisterPage.email, properties.getProperty("duplicateEmail"));
        setInputField(RegisterPage.password, password);

        RegisterPage.clickSubmit();


        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Validate that success message should not be displayed bec. of incorrect data
        Assert.assertNotEquals(currentUrl, ConfirmationPage.url,
                "Email is not unique");
    }
}
