package com.aka.pages;


import org.aka.utils.TestUtils;
import org.openqa.selenium.By;


import java.time.Duration;

public class AdDisplayPage extends BasePage{
TestUtils utils = new TestUtils();

private final By continueToApp = By.xpath("//android.widget.TextView[@text='Continue to app']");

    public SelectConnectionTypePage clickContinue(){
        click(continueToApp, Duration.ofSeconds(60));
        TestUtils.log().info("VPN app is currently active...");

        return new SelectConnectionTypePage();
    }

    public AdDisplayPage checkLandingPageLoaded(){
        waitForVisibility(continueToApp);
        return this;
    }

}
