package com.aka.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.aka.utils.DriverManager;
import org.aka.utils.LoadProperties;
import org.aka.utils.TestUtils;
import org.aka.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

public class WebPageSpeedTest {
    @FindBy(id ="your-speed-message")
    private WebElement netSpeedMessage;

    @FindBy(id="speed-value")
    private WebElement speedResult;

    private WebDriver webDriver;

    public WebPageSpeedTest(){
        new WebDriverManager().initDriver();
        this.webDriver = new WebDriverManager().getDriver();
        PageFactory.initElements(this.webDriver,this);
    }



    public void checkInternetSpeed(String webURL) throws MalformedURLException,InterruptedException {
        webDriver.get(webURL);
        new WebPageSpeedTest().waitForSpeedTestCompletion();


        TestUtils.log().info("Your Internet Speed for Service Provider {} is {} Mbps", TestUtils.getProviderName(),speedResult.getText());
//Thread Sleep so speed result stays on screen for few seconds..
        try {
            Thread.sleep(10);
            //return new MainPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        MobileElement speedElement = (MobileElement) new WebDriverWait(browserDriver, 60)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("speed-value")));
//        String speed = speedElement.getText();
//        System.out.println("Internet Speed: " + speed + " Mbps");
    }

    public void waitForSpeedTestCompletion(){
        TestUtils.log().info("Waiting for speed test to complete..");
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(netSpeedMessage));
        TestUtils.log().info("Speed test completed successfully..");
    }
}
