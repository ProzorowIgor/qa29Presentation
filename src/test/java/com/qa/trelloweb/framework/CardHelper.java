package com.qa.trelloweb.framework;

import com.qa.trelloweb.model.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CardHelper extends HelperBase {
    public CardHelper(WebDriver wd) {
        super(wd);
    }


    public void initCreation() {

        waitForElementAndClick(5, By.cssSelector(".js-add-a-card"));
//input.js-add-card // blue button
    }

    public void confirmCreation() {
        click(By.cssSelector(".js-add-card"));
    }

    public void fillCreationForm(Card card) {

        type(By.cssSelector(".js-card-title"), card.getCardName());
        if (card.getColor() != null) {
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

    public void changePlaceOfCard() {
        List<WebElement> allCards = new ArrayList<>(wd.findElements(By.cssSelector(".js-list.list-wrapper")));
        String str = allCards.get(0).getText();
        System.out.println("=================================================" + str);

        //actions.moveToElement(allCards.get(0)).clickAndHold().moveToElement(allCards.get(2)).release().build().perform();
        // actions.dragAndDrop(allCards.get(0),allCards.get(2));

        Actions actions = new Actions(wd);
        Rectangle rec = allCards.get(0).getRect();
        int xFrom = rec.getX() + rec.getWidth() / 2;
        int y = rec.getY() + rec.getHeight() / 20;
        int xTo = xFrom + rec.getWidth() * 2;
        actions.dragAndDropBy(allCards.get(0), xFrom, xTo);

    }

    public void clickOnBoard() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector(".board-tile-details.is-badged"))))
                .click();
    }
}


