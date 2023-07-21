package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod
    public void inIt() {

        homePage = new HomePage();
        registerPage = new RegisterPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {

        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Verify "Register" text
        Assert.assertEquals(registerPage.verifyRegisterText(), "Register", "");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {

        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify the error message "First name is required."
        Assert.assertEquals(registerPage.verifyFirstNameError(),"First name is required.", "Unable to verify error.");
        // Verify the error message "Last name is required."
        Assert.assertEquals(registerPage.verifyLastNameError(),"Last name is required.", "Unable to verify error.");
        // Verify the error message "Email is required."
        Assert.assertEquals(registerPage.verifyEmailError(),"Email is required.", "Unable to verify error.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyPasswordError(),"Password is required.", "Unable to verify error.");
        // Verify the error message "Password is required."
        Assert.assertEquals(registerPage.verifyConfirmPasswordError(),"Password is required.", "Unable to verify error.");
    }

    @Test(groups = {"regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() {

        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectGender("Female");
        // Enter firstname
        registerPage.enterFirstName("Aarti");
        // Enter lastname
        registerPage.enterLastName("Doshi");
        // Select day
        registerPage.dateOfBirthDay("12");
        // Select month
        registerPage.dateOfBirthMonth("January");
        // Select year
        registerPage.dateOfBirthYear("2001");
        // Enter email
        registerPage.enterEmail("Aarti123@gmail.com");
        // Enter password
        registerPage.enterPassword("Hello123");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("Hello123");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterButton();
        // Verify message "Your registration completed"
        Assert.assertEquals(registerPage.verifyRegistrationCompleteMessage(),"Your registration completed", "Unable to verify message.");

    }

}
