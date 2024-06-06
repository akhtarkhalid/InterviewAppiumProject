package com.aka.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.aka.utils.AppiumServer;
import org.aka.utils.DriverManager;
import org.aka.utils.WebDriverManager;


public class Hooks {

    @Before
    public static void initialize() throws Exception {

        new AppiumServer().startServer();
        new DriverManager().initDriver();
    }

    @After
    public static void quit(){
        try{
        DriverManager driverManager = new DriverManager();
        WebDriverManager webDriverManager = new WebDriverManager();
        if(driverManager.getDriver() != null ){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        if(webDriverManager.getDriver() != null ){
            webDriverManager.getDriver().quit();
            //webDriverManager.setDriver(null);
        }
        AppiumServer serverManager = new AppiumServer();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
        }catch(Exception ignored){

        }

    }

}
