package com.aka.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aka.utils.DriverManager;
import org.aka.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private AppiumDriver driver;
    TestUtils utils = new TestUtils();

    public BasePage(){
        this.driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public void waitForVisibility(WebElement e){
        WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForTextDisplay(By e,String displayText,Duration waitTime){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.textToBe(e, displayText));
    }

    public void waitForTextDisplay(By e,String displayText){
        WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
        wait.until(ExpectedConditions.textToBe(e, displayText));
    }

    public void waitForVisibility(WebElement e,Duration waitTime){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForVisibility(By e){
        WebDriverWait wait = new WebDriverWait(driver,TestUtils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }
    public void waitForVisibility(By e,Duration waitTime){
        WebDriverWait wait = new WebDriverWait(driver,waitTime);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
    }

    public void clear(WebElement e){
        waitForVisibility(e);
        e.clear();
    }

    public void clear(By e){
        waitForVisibility(e);
        driver.findElement(e).clear();
    }

    public void click(WebElement e){
        waitForVisibility(e);
        e.click();
    }
    public void click(WebElement e,Duration waitTime){
        waitForVisibility(e,waitTime);
        e.click();
    }

    public void click(By e){
        waitForVisibility(e);
        driver.findElement(e).click();
    }

    public void click(By e, Duration waitTime){
        waitForVisibility(e,waitTime);

        driver.findElement(e).click();
    }

    public void sendKeys(WebElement e,String text){
        waitForVisibility(e);
        e.sendKeys(text);
    }

    public void sendKeys(By e,String text){
        waitForVisibility(e);
        driver.findElement(e).sendKeys(text);
    }

    public String getText(WebElement e){
        return e.getText();
    }
    public String getText(By e){
        return driver.findElement(e).getText();
    }

    public boolean findControl(WebElement e){
        return e.isDisplayed();
    }

    public boolean findControl(By e){
        return driver.findElement(e).isDisplayed();
    }

}
