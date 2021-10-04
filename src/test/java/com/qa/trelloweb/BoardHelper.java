package com.qa.trelloweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void closeBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector(".js-delete"));
        click(By.cssSelector(".js-confirm"));
    }

    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void openSideBoardMenu() {
        click(By.cssSelector(".js-show-sidebar"));
    }

    public void clickOnTheFirstBoard() {
        click(By.cssSelector(".boards-page-board-section-list-item"));
    }

    public int getBoardsCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size() - 1;
    }

    public void fillBoardCreationForm(String boardName) {
        //fillBoardCreationForm
        type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
        //confirmBoardCreation
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void initBoardCreationFromHeader() {
        //clickCreateButtonOnHeader
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        //selectCreateBoard
        click(By.cssSelector("[aria-label='BoardIcon']"));//
    }
}
