package org.aka.utils;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.Properties;

public class DesiredCapabilitiesLoader {
    Properties prop = LoadProperties.getProperties();

    public DesiredCapabilities getDesiredCapabilities() {
        try {
            TestUtils.log().info("Loading desired capabilities for App..");
            DesiredCapabilities desCaps = new org.openqa.selenium.remote.DesiredCapabilities();
            desCaps.setCapability("platformName", prop.getProperty("platformName"));
            TestUtils.log().info("Platform name {} loaded..",prop.getProperty("platformName"));
            //desCaps.setCapability("appium:deviceName", "Pixel 8");
            desCaps.setCapability("appium:deviceName", prop.getProperty("deviceName"));
            TestUtils.log().info("Device name {} loaded..",prop.getProperty("deviceName"));
            desCaps.setCapability("appium:automationName", prop.getProperty("droidAutomationName"));
            TestUtils.log().info("Automation name {} loaded..",prop.getProperty("droidAutomationName"));
            desCaps.setCapability("appium:appPackage", prop.getProperty("droidAppPackage"));
            TestUtils.log().info("App package {} loaded..",prop.getProperty("droidAppPackage"));
            desCaps.setCapability("appium:appActivity", prop.getProperty("droidAppMain"));
            TestUtils.log().info("App activity {} loaded..",prop.getProperty("droidAppMain"));
            //desCaps.setCapability("appium:udid", "emulator-5554");
            desCaps.setCapability("appium:udid", prop.getProperty("deviceUDID"));
            TestUtils.log().info("Device UDID {} loaded..",prop.getProperty("deviceUDID"));
            //String appLocation = System.getProperty("user.dir") + "/src/main/resources/VPN-debug.apk";
            // desCaps.setCapability("appium:app", appLocation);
            desCaps.setCapability("appium:appium:avdLaunchTimeout",Integer.valueOf(prop.getProperty("avdLaunchTimeout")));
            TestUtils.log().info("AVD launch timeout set to {} seconds..",prop.getProperty("avdLaunchTimeout"));
            return desCaps;
        }catch(Exception e){
            TestUtils.log().error("An error occured while loading Capabilities for Apps..{}",e.getMessage());
            throw e;
        }

    }

    public DesiredCapabilities getDesiredCapabilitiesWeb(){
        try{
        System.out.println("Loading desired capabilities for browser..");
        DesiredCapabilities webDesCaps = new org.openqa.selenium.remote.DesiredCapabilities();
            webDesCaps.setCapability("platformName", prop.getProperty("platformName"));
            TestUtils.log().info("Platform name {} loaded..",prop.getProperty("platformName"));
            webDesCaps.setCapability("appium:automationName", prop.getProperty("droidAutomationName"));
            TestUtils.log().info("Automation name {} loaded..",prop.getProperty("droidAutomationName"));
            webDesCaps.setCapability("appium:deviceName", prop.getProperty("deviceName"));
            TestUtils.log().info("Device name {} loaded..",prop.getProperty("deviceName"));
            webDesCaps.setCapability("browserName", prop.getProperty("browserName"));
            TestUtils.log().info("Browser set to {}..",prop.getProperty("browserName"));
        return webDesCaps;
        }catch(Exception e){
            TestUtils.log().error("An error occured while loading Capabilities for browser..{}",e.getMessage());
            throw e;
        }
    }
}
