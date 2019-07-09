package com.automation.automation_lab_03.cucumber_framework_01;

import com.automation.automation_lab_03.cucumber_framework_01.driver.DriverHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    private DriverHelper driverHelper = new DriverHelper();

    @Before
    public void setUp() {
        driverHelper.browserSetUp("Chrome", "https://www.argos.co.uk/");
        driverHelper.maximizeBroser();
        driverHelper.applyImplicitlyWait();
        driverHelper.privacyFooter();
    }

    //@After
    public void tearDown() {
        driverHelper.quitTheBrowser();
    }
}
