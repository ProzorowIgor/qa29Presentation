package com.qa.trelloweb;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.getUser().isTrelloButtonOnHeader()){
            app.getUser().login("rochman.elena@gmail.com", "12345.com");
        }
    }


    @Test
    public void testBoardCtreation() throws InterruptedException {
        int boardsCountBeforeCreation = app.getBoard().getBoardsCount();
        app.getBoard().initBoardCreationFromHeader();

        app.getBoard().fillBoardCreationForm("test-board");

        Thread.sleep(15000);
        app.getBoard().retunToHomePage();
        int boardsCountAfterCreation = app.getBoard().getBoardsCount();
        Assert.assertEquals(boardsCountAfterCreation, boardsCountBeforeCreation+1);

    }


}
