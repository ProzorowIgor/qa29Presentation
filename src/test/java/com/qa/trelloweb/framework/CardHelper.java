package com.qa.trelloweb.framework;

import com.qa.trelloweb.model.Card;
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

    public void fillCreationForm(Card card) {

        type(By.cssSelector(".js-card-title"), card.getCardName());
        if(card.getColor()!=null) {
            openCardMenu();
            selectLabelsFromMenu();
            click(By.cssSelector("[data-color=" + card.getColor() + "]"));
        }

    }

    private void selectLabelsFromMenu() {
        click(By.cssSelector(".js-label-selector"));
    }

    private void openCardMenu() {
        click(By.cssSelector(".js-cc-menu"));
    }
}
