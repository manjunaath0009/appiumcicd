package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class DriverManager {

    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver(){
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2){
        driver.set(driver2);
    }

    public void initializeDriver() throws IOException {
        AppiumDriver driver = null;
        if(driver == null){
            utils.log().info("Initializing Appium Driver");
            driver=new AndroidDriver(new ServerManager().getServer().getUrl(), new CapabilitiesManager().getCaps());
                /*
                    throw new Exception("Driver is null Abort!!");
                }*/
            utils.log().info("Driver is initialized");
            this.driver.set(driver);
        }
    }
}
