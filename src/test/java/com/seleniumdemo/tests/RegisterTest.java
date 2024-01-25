package com.seleniumdemo.tests;

import com.seleniumdemo.pages.RegisterPage;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test
    public void registerUserTest() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.openMyAccountLink();
        Thread.sleep(2000);
    }
}
