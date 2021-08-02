package com.qa.utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class ServerManager {

    private static ThreadLocal<AppiumDriverLocalService> server=new ThreadLocal<>();
    TestUtils utils=new TestUtils();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        utils.log().info("Starting Appium Server");
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium Server not started. ABORT!!");
        }
        // server.clearOutPutStreams();
        this.server.set(server);
        utils.log().info("Appium Server Started");
    }


    public AppiumDriverLocalService getAppiumServerDefault(){
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService WindowsGetAppiumService(){
        GlobalParams params = new GlobalParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
            .usingAnyFreePort()
            .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
            .withLogFile(new File(params.getPlatformName() + "_"
                + params.getDeviceName() + File.separator + "Server.Log")));
    }
}
