package com.qa.trelloweb;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends  TestBase{
    @BeforeMethod(enabled = false)
    public void preconditions() throws InterruptedException {
        if(!app.getUser().isTrelloButtonOnHeader()){
            app.getUser().login("rochman.elena@gmail.com", "12345.com");
        }
    }

    @Test
    public void testBoardDeletion(){
        int boardsCountBeforeDeletion = app.getBoard().getBoardsCount();
        //click on first board
       // click(By.xpath("//*[@class='boards-page-board-section-header-name'][2]/../..//li"));
        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard();
        app.getBoard().retunToHomePage();
        int boardsCountAfterDeletion = app.getBoard().getBoardsCount();

        Assert.assertEquals(boardsCountAfterDeletion, boardsCountBeforeDeletion-1);

    }

}
