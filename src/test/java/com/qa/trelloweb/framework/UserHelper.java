package com.qa.trelloweb.framework;

import com.qa.trelloweb.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void login(User user) throws InterruptedException {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("#user"), user.getUser());
        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), user.getPassword());
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

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.cssSelector("#user"), user.getUser());

        Thread.sleep(2000);
        click(By.id("login"));
        type(By.name("password"), user.getPassword());
    }

    public void openWindow(String path) {
        ((JavascriptExecutor) wd).executeScript("window.open('"+path+"')");
    }

    public void chooseWindow(int i) {
        LinkedHashSet<String> allWindows = new LinkedHashSet <>(wd.getWindowHandles()); //sorting in collection Set
        List<String> myWindows = new ArrayList<>(allWindows);//move all elements to another collection that has method "get"
        System.out.println("============== "+allWindows.size());
        wd.switchTo().window(myWindows.get(i)).close();

        // List<String> allWindows = new ArrayList<>(wd.getWindowHandles()); 2-nd method
        //wd.switchTo().window(allWindows.get(i)).close();
    }
}
