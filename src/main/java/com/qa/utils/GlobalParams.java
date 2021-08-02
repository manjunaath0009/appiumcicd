package com.qa.utils;

public class GlobalParams {

    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> chromeDriverPort = new ThreadLocal<String>();

    public void setPlatformName(String platformName2){
        platformName.set(platformName2);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public void setUdid(String udid2){
        udid.set(udid2);
    }

    public String getUdid(){
        return udid.get();
    }

    public void setDeviceName(String deviceName2){
        deviceName.set(deviceName2);
    }

    public String getDeviceName(){
        return deviceName.get();
    }

    public void setSystemPort(String systemPort2){
        systemPort.set(systemPort2);
    }

    public String getSystemPort(){
        return systemPort.get();
    }

    public void setChromeDriverPort(String chromeDriverPort2){
        chromeDriverPort.set(chromeDriverPort2);
    }

    public String getChromeDriverPort(){
        return chromeDriverPort.get();
    }

    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Android"));
        params.setUdid(System.getProperty("UdID", "emulator-5554"));
        params.setDeviceName(System.getProperty("deviceName", "Pixel_2"));

        params.setSystemPort(System.getProperty("systemPort", "10000"));
        params.setChromeDriverPort(System.getProperty("chromeDriverPort", "11000"));
    }

}
