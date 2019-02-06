package com.workmarket.test.qe;

import org.junit.Test;
import org.openqa.selenium.Keys;

import static org.junit.Assert.assertEquals;

import java.util.Random;

public class LandingPageTest extends TestBase {

    private static final String TOO_SIMPLE_PASSWORD = "Your password entered is not allowed because it is too simple";
    private static final String INVALID_FIRST_NAME = "Please enter a valid first name";
    private static final String INVALID_LAST_NAME = "Please enter a valid last name";
    private static final String INVALID_EMAIL = "Please enter a valid email";
    private static final String INVALID_PASSWORD = "Please enter a valid password";
    private static final String SUCCESS_MESSAGE = "Thank You from CoName_6225";
    private static final String EMAIL_ALREADY_EXISTS = "The email address bladerunner@wmdev.com is already being used.";
    private static final String REGISTRATION_PROBLEM = "There was a problem submitting your registration. Please try again.";

    @Test
    public void testUserCanSignUpWithValidCredentials() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String uniqueID = firstName + lastName + new Random().nextInt(100);
        String email = uniqueID + "@wmtest.com";
        
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys(firstName);
        landingPage().lastName().sendKeys(lastName);
        landingPage().email().sendKeys(email);
        landingPage().password().sendKeys(uniqueID);
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String success = regLandingPage().successMessage().getText();
        assertEquals(SUCCESS_MESSAGE, success);

    }

    @Test    
    public void testExistingUserWithSameEmailCannotRegister() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys("Blade");
        landingPage().lastName().sendKeys("Runner");
        landingPage().email().sendKeys("bladerunner@wmdev.com");
        landingPage().password().sendKeys("bladerunner111");
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String errMessage = landingPage().getErrorMessage("being used").getText();
        assertEquals(EMAIL_ALREADY_EXISTS, errMessage);

    }

    // @Test    
    // public void testExistingUserWithSameNameCanRegister() {

    // }

    @Test
    public void testUserWithTooSimplePasswordIsNotAllowed() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String uniqueID = firstName + lastName + new Random().nextInt(100);
        String email = uniqueID + "@wmtest.com";

        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys(firstName);
        landingPage().lastName().sendKeys(lastName);
        landingPage().email().sendKeys(email);
        landingPage().password().sendKeys("abcd1234");
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String errMessage = landingPage().getErrorMessage("too simple").getText();
        assertEquals(TOO_SIMPLE_PASSWORD, errMessage);
    }

    @Test
    public void testUserPasswordWithNoNumberIsNotAllowed() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String uniqueID = firstName + lastName + new Random().nextInt(100);
        String email = uniqueID + "@wmtest.com";

        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys(firstName);
        landingPage().lastName().sendKeys(lastName);
        landingPage().email().sendKeys(email);
        landingPage().password().sendKeys("bcdf@#$%");
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String errMessage = landingPage().getErrorMessage("valid password").getText();
        assertEquals(INVALID_PASSWORD, errMessage);
    }

    @Test
    public void testUserPasswordWithLessThan8CharsIsNotAllowed() {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String uniqueID = firstName + lastName + new Random().nextInt(100);
        String email = uniqueID + "@wmtest.com";

        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys(firstName);
        landingPage().lastName().sendKeys(lastName);
        landingPage().email().sendKeys(email);
        landingPage().password().sendKeys("bcdf");
        landingPage().checkAgreement().click();

        String errMessage = landingPage().getErrorMessage("valid password").getText();
        assertEquals(INVALID_PASSWORD, errMessage);
    }

    @Test
    public void testEmptyFirstNameIsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys("m");
        landingPage().firstName().sendKeys(Keys.BACK_SPACE);
        landingPage().lastName().click();
        
        String errMessage = landingPage().getErrorMessage("first name").getText();
        assertEquals(INVALID_FIRST_NAME, errMessage);
    }

    @Test
    public void testEmptyLastNameIsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().lastName().sendKeys("m");
        landingPage().lastName().sendKeys(Keys.BACK_SPACE);
        landingPage().firstName().click();
        
        String errMessage = landingPage().getErrorMessage("last name").getText();
        assertEquals(INVALID_LAST_NAME, errMessage);
    }

    @Test
    public void testEmptyEmailIsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().email().sendKeys("m");
        landingPage().email().sendKeys(Keys.BACK_SPACE);
        landingPage().lastName().click();
        
        String errMessage = landingPage().getErrorMessage("email").getText();
        assertEquals(INVALID_EMAIL, errMessage);
    }

    @Test
    public void testEmptyPasswordIsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().password().sendKeys("m");
        landingPage().password().sendKeys(Keys.BACK_SPACE);
        landingPage().lastName().click();
        
        String errMessage = landingPage().getErrorMessage("password").getText();
        assertEquals(INVALID_PASSWORD, errMessage);
    }

    @Test
    public void testFirstNameMoreThan50CharsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys("ThisIsATestUserThisIsATestUserThisIsATestUserTestUs");
        landingPage().lastName().sendKeys("Runner");
        landingPage().email().sendKeys("bladerunnerX@wmdev.com");
        landingPage().password().sendKeys("bladerunner111");
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String errMessage = landingPage().getErrorMessage("try again").getText();
        assertEquals(REGISTRATION_PROBLEM, errMessage);
    }

    @Test
    public void testLastNameMoreThan50CharsNotAllowed() {
        navigateToSignUpPage();
        landingPage().joinAsAnIndividual().click();
        landingPage().firstName().sendKeys("Blade");
        landingPage().lastName().sendKeys("ThisIsATestUserThisIsATestUserThisIsATestUserTestUs");
        landingPage().email().sendKeys("bladerunnerX@wmdev.com");
        landingPage().password().sendKeys("bladerunner111");
        landingPage().checkAgreement().click();
        landingPage().register().click();

        String errMessage = landingPage().getErrorMessage("try again").getText();
        assertEquals(REGISTRATION_PROBLEM, errMessage);
    }



}
