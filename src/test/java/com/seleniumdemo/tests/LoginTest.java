package com.seleniumdemo.tests;

import com.seleniumdemo.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginUserTest() {

        WebElement entryTitle = new HomePage(driver)
                .openMyAccountPage()
                .loginUserValidData("test1@test1.com", "test1@test1.com")
                .getEntryTitle();

        Assert.assertTrue(entryTitle.getText().contains("Hello"));
    }

    @Test
    public void loginWithInvalidPasswordTest() {

        WebElement failedLoginAlert = new HomePage(driver)
                .openMyAccountPage()
                .loginUserInvalidData("test1@test1.com", "test@test.com")
                .getError();

        Assert.assertTrue(failedLoginAlert.getText().contains("Incorrect username or password.") || failedLoginAlert.getText().contains("Too many failed login attempts"), "Expected alert text doesn't match - " + failedLoginAlert.getText());
    }
}
