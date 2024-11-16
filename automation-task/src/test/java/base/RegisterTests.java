package base;

import org.testng.Assert;
import org.testng.annotations.Test;



public class RegisterTests extends base {

    @Test
    public void testSuccessfulRegister() throws InterruptedException {
        // Read valid data from properties file
        String firstName = properties.getProperty("validFirstName");
        String lastName = properties.getProperty("validLastName");
        String phone = properties.getProperty("validPhone");
        String email = properties.getProperty("validEmail");
        String password = properties.getProperty("validPassword");

        RegisterPage.setInputField(RegisterPage.firstName, firstName);
        RegisterPage.setInputField(RegisterPage.lastName, lastName);


        RegisterPage.selectCountry(properties.getProperty("validCountry"));
        RegisterPage.setInputField(RegisterPage.phone, phone);
        RegisterPage.setInputField(RegisterPage.email, email);
        RegisterPage.setInputField(RegisterPage.password, password);

        // Validate First Name starts with capital letter
        Assert.assertTrue(firstName.matches("^[A-Z].*"), "First Name should start with a capital letter.");
        // Validate Last Name starts with capital letter and is different from First Name
        Assert.assertTrue(lastName.matches("^[A-Z].*"), "Last Name should start with a capital letter.");
        Assert.assertNotEquals(firstName, lastName, "First Name and Last Name cannot be the same.");
        // Validate Phone number
        Assert.assertTrue(phone.matches("^[0-9]{10}$"), "Phone number must be a valid 10-digit number.");
        // Validate Email format and uniqueness
        Assert.assertTrue(email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"), "Email must be valid.");

        RegisterPage.clickSubmit();

        // Get the current URL
        String currentUrl = driver.getCurrentUrl();

        // Assert that the current URL is as expected
        Assert.assertEquals(currentUrl, "https://phptravels.net/signup_success",
                "URL does not match the expected value.");

    }

}
