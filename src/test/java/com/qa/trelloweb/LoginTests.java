package com.qa.trelloweb;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preconditions() {
        if (app.getUser().isTrelloButtonOnHeader()) {
            app.getUser().logout();
        }
    }


    @Test
    public void testLogin() throws InterruptedException {
        app.getUser().initLogin();
        app.getUser().fillLoginForm("rochman.elena@gmail.com", "12345.com");
        app.getUser().submitLogin();
        Thread.sleep(15000);

        Assert.assertTrue(app.getUser().isTrelloButtonOnHeader(), "Element 'Logo' not found");
    }

    @Test(enabled = false)
    public void negativeLoginWithoutPassword() throws InterruptedException {
        /*
         * 1. init login
         * 2. fillLogin form
         * 3. submit Login
         * */

        app.getUser().initLogin();
        app.getUser().fillLoginForm("rochman.elena@gmail.com", "");
        app.getUser().submitLogin();
        Thread.sleep(15000);

        //Assert.assertTrue(isErrorPresent(), "Element 'Error' not found");
    }


}
