package org.aka.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.chromium.ChromiumDriver;
import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.time.Duration;


public class WebDriverManager {
    private static WebDriver webDriver;

    public WebDriver getDriver() {
        return webDriver;
    }

    public void setDriver(WebDriver driver1) {
        webDriver = driver1;
    }

    public void initDriver() {
        try {

            if (webDriver == null) {
                TestUtils.log().info("Initializing Appium driver...");
                webDriver = new ChromiumDriver(new URL("http://localhost:4723"),
                        new DesiredCapabilitiesLoader().getDesiredCapabilitiesWeb());
                webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                TestUtils.log().info("Chrome driver initialized successfully..");
            }
        } catch (Exception e) {
            TestUtils.log().error("Chrome driver initialization failed..{}",e.toString());
        }
    }
}
