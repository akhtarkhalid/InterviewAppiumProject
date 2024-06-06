package com.aka.pages;

import org.aka.utils.TestUtils;
import org.openqa.selenium.By;

import java.time.Duration;

public class SelectConnectionTypePage extends BasePage {
    TestUtils utils = new TestUtils();

    private final By continueWithAds = By.xpath("//android.widget.Button[@resource-id='app.java.vpn:id/buttonContinue']");

    public MainPage clickContinueWithAds(){
        click(continueWithAds);
        TestUtils.log().info("Navigation to connect page successful..");
        return new MainPage();
    }

}
