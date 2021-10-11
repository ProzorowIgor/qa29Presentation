package com.qa.trelloweb.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.user().isTrelloButtonOnHeader()){
            app.user().login("rochman.elena@gmail.com", "12345.com");
        }
    }


    @Test
    public void testBoardCtreation() throws InterruptedException {
        int boardsCountBeforeCreation = app.board().getBoardsCount();
        System.out.println(boardsCountBeforeCreation);

        app.board().initBoardCreationFromHeader();

        app.board().fillBoardCreationForm("test-board");

        Thread.sleep(15000);
        app.board().retunToHomePage();
        int boardsCountAfterCreation = app.board().getBoardsCount();
        System.out.println(boardsCountAfterCreation);

        Assert.assertEquals(boardsCountAfterCreation, boardsCountBeforeCreation+1);

    }


}
