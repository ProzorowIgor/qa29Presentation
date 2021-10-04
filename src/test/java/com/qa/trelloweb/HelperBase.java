package com.qa.trelloweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }




    public boolean isHomeButtonOnHeader(){
        return isElementPresent(By.cssSelector("[data-test-id='header-home-button']"));
    }

    public boolean isTrelloButtonOnHeader(){
        return isElementPresent(By.cssSelector("[aria-label='Back to home']"));
    }

    public void retunToHomePage() {
        if (isTrelloButtonOnHeader()) {
            click(By.cssSelector("[aria-label='Back to home']"));
        } else
            click(By.cssSelector("[data-test-id='header-home-button']"));
    }
}
