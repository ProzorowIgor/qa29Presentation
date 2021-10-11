package com.qa.trelloweb.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.user().isTrelloButtonOnHeader()){
            app.user().login("rochman.elena@gmail.com", "12345.com");
        }
    }

    @Test
    public void cardCreationTest(){
        app.board().clickOnTheFirstBoard();
        app.list().create("Test");
        app.card().initCreation();
        app.card().fillCreationForm("new card");
        app.card().confirmCreation();

    }
}
