package org.aka.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


import java.util.Properties;

public class AppiumServer{

    Properties prop = LoadProperties.getProperties();
    private static ThreadLocal<AppiumDriverLocalService> service = new ThreadLocal<>();


    public void startServer() {

            TestUtils.log().info("Starting Appium Server at IP:{}  Port:{}", prop.getProperty("serverURL"), prop.getProperty("serverPort1"));
            AppiumDriverLocalService service = WindowsGetAppiumService();
            service.start();
            if(!service.isRunning()){
                TestUtils.log().fatal("Appium server not started. ABORT!!!");
                throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
            }
            service.clearOutPutStreams();
            AppiumServer.service.set(service);
            TestUtils.log().info("Appium server started");
    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .withIPAddress(prop.getProperty("serverURL"))
                .usingPort(Integer.parseInt(prop.getProperty("serverPort1")))
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload")
                .withArgument(GeneralServerFlag.ALLOW_INSECURE, "adb_shell"));
    }

    public AppiumDriverLocalService getServer() {
        return service.get();
    }

}
