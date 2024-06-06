package com.aka.stepdef;

import com.aka.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.aka.utils.TestUtils;

public class VPNTestStepDef {

    @Given("user has VPN app running")

    public void userHasVPNAppRunning() {
        TestUtils.log().info("Checking if VPN app is active..");
       new AdDisplayPage().clickContinue();
    }
    @Given("user navigates to connect page")
    public void userNavigatedToConnectPage() {
        TestUtils.log().info("Navigating to connect page..");
        new SelectConnectionTypePage().clickContinueWithAds();
    }
    @Given("user clicks on connect button")
    public void userClicksOnConnectButton() {
        TestUtils.log().info("Clicking on connect button..");
        new MainPage().clickConnectButton();
    }
    @When("user is connected to VPN")
    public void userIsConnectedToVPN() {
        TestUtils.log().info("Checking if user is connected to VPN..");
        new ConnectionStatusPage().checkConnectionStatus();
    }
    @Then("user launches {string} to check speed")
    public void userLaunches(String pageAddress) {
        TestUtils.log().info("Launching fast.com to check internet speed..");
        try {
            new WebPageSpeedTest().checkInternetSpeed(pageAddress);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

}
