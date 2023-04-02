package com.salto_ks.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    // Declare private static variables in order to be able to use them in different method
    private static AppiumDriver driver;
    private static URL url;

    //Private constructor to be able to make it accessible only class level
    private Driver(){
    }

    // Create getDriver method to be able to set desired driver to interact with appium server.
    public static AppiumDriver getDriver(){
        String platform=ConfigurationReader.getProperty("platform");

        if(driver==null){
            switch (platform){
                case "android":
                    DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.0");
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel_5");
                    desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/SALTO_KS.apk");
                    desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 20000);

                    try {
                        url=new URL("http://0.0.0.0:4723/wd/hub");
                       driver=new AndroidDriver(url,desiredCapabilities);
                       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "android-remote":
                    DesiredCapabilities caps= new DesiredCapabilities();
                     caps.setCapability("browserstack.user","test_auffjaf");
                     caps.setCapability("browserstack.key","aufuagfukahf");

                     caps.setCapability("app","bs://jnfljegnlkegnqkengikneqgikneqglqk");

                    try {
                        driver=new AndroidDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    break;

            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }

    }



}
