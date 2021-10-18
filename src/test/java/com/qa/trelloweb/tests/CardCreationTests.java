package com.qa.trelloweb.tests;

import com.qa.trelloweb.model.Card;
import com.qa.trelloweb.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardCreationTests extends TestBase{
    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if(!app.user().isTrelloButtonOnHeader()){
            app.user().login(new User().withUser("rochman.elena@gmail.com").withPassword("12345.com"));
        }
    }

    @Test
    public void cardWithLableCreationTest(){
        app.board().clickOnTheFirstBoard();
        if(app.list().getCount()==0) {
            app.list().create("Test");
        }
        app.card().initCreation();
        app.card().fillCreationForm(new Card().withName("new card").withColor("yellow"));
        app.card().confirmCreation();

    }
    @Test
    public void cardCreationTest(){
        app.board().clickOnTheFirstBoard();
        if(app.list().getCount()==0) {
            app.list().create("Test");
        }
        app.card().initCreation();
        app.card().fillCreationForm(new Card().withName("new card"));
        app.card().confirmCreation();
    }
}
