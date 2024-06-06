package org.aka.utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedHashMap;


public class DriverManager {
    private static AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver1) {
        driver = driver1;
    }

    public void initDriver() {
        try {

            if (driver == null) {
                TestUtils.log().info("Initializing Appium driver...");
                driver = new AndroidDriver(new AppiumServer().getServer().getUrl(),
                        new DesiredCapabilitiesLoader().getDesiredCapabilities());
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                TestUtils.log().info("Appium driver initialized successfully..");

                // Get the service provider name
                LinkedHashMap<String,String> serviceProviderName =(LinkedHashMap<String, String>) driver.executeScript("mobile: shell",
                        ImmutableMap.of("command", "getprop",
                                "args", Arrays.asList("gsm.operator.alpha"),
                                "includeStderr", true,
                                "timeout", 5000));

                String providerName = serviceProviderName.get("stdout").stripTrailing();
                TestUtils.setProviderName(providerName);
            }
        } catch (Exception e) {
            TestUtils.log().error("Appium driver initialization failed..{}",e.toString());
        }
    }
}
