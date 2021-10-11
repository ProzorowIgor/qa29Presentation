package com.qa.trelloweb.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase{
    public CardHelper(WebDriver wd) {
        super(wd);
    }


    public void initCreation() {
click(By.cssSelector(".js-add-a-card"));

    }

    public void confirmCreation() {
        click(By.cssSelector(".js-add-card"));
    }

    public void fillCreationForm(String cardName) {
        type(By.cssSelector(".js-card-title"), cardName);
    }
}
