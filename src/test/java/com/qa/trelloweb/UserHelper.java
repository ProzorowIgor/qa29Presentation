package com.qa.trelloweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }
    public void login(String user, String password) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), user);
        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), password);
        click(By.id("login-submit"));
        Thread.sleep(15000);
    }

    public void logout() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
        click(By.cssSelector("[data-test-id=header-member-menu-logout]"));
        click(By.id("logout-submit"));
    }

    public void submitLogin() {
        click(By.id("login-submit"));
    }

    public void fillLoginForm(String user, String password) throws InterruptedException {
        type(By.cssSelector("#user"), user);

        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), password);
    }



}
