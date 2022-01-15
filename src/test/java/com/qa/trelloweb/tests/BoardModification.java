package com.qa.trelloweb.tests;

import com.qa.trelloweb.model.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BoardModification extends TestBase {

    @BeforeTest
    public void preCondition() throws InterruptedException {
        if (app.user().isTrelloButtonOnHeader()) {
            return;
        }
        app.user().initLogin();
        app.user().fillLoginForm(new User().withUser("rochman.elena@gmail.com").withPassword("12345.com"));
        app.user().submitLogin();

    }


    @Test
    public void moveCard() {
        app.card().clickOnBoard();
        app.card().changePlaceOfCard();


    }

}
