package com.qa.trelloweb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.TimeUnit;


public class TestWithActions {

    WebDriver driver;

    @Test
    public void DragAndDrop() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://crossbrowsertesting.github.io/drag-and-drop.html");
        Actions action = new Actions(driver);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("draggable"))));
        WebElement element1 = driver.findElement(By.id("draggable"));
        WebElement element2 = driver.findElement(By.id("droppable"));

        // action.dragAndDrop(element1, element2).release().perform(); //1 variant
        // action.moveToElement(element1).clickAndHold().moveToElement(element2).release().build().perform(); //2 variant
        Point location = element2.getLocation();
        int x = location.getX();
        int y = location.getY() - 120;
        action.dragAndDropBy(element1, x, y).release().perform(); // 3 variant
     

    }
}
