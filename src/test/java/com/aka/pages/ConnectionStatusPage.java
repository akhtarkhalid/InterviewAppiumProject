package com.aka.pages;

import org.aka.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ConnectionStatusPage extends BasePage {
    private final By connectionStatus = By.xpath("//android.widget.TextView[@resource-id='app.java.vpn:id/tv_status']");

    private WebElement continueWithAds;

    public void checkConnectionStatus() {
        waitForTextDisplay(connectionStatus,"Connected", Duration.ofSeconds(30));
        TestUtils.log().info("User is connected to to VPN successfully..");

                try {
            Thread.sleep(10);
            //return new MainPage();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
