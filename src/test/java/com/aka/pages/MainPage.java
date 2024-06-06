package com.aka.pages;

import org.aka.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private final By connectButton = By.xpath("//android.widget.ImageView[@content-desc='connectVPN']");

    private WebElement continueWithAds;

    public void clickConnectButton() {
        click(connectButton);
        TestUtils.log().info("Clicked on connect button successfully..");

    }
}
