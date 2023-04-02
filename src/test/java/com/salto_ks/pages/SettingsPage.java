package com.salto_ks.pages;

import com.salto_ks.utils.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    //Locators
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Settings\"]/android.widget.FrameLayout/android.widget.ImageView")
    public WebElement settingsModule;

    @AndroidFindBy(id = "nl.moboa.myclay:id/user_email")
    public WebElement userEmailInSettings;

    @AndroidFindBy(id = "nl.moboa.myclay:id/user_fullname")
    public WebElement userFullNameInSettings;

    @AndroidFindBy(xpath = "//*[@text='Key settings']")
    public WebElement keySettingsHeader;

    @AndroidFindBy(xpath = "//*[@text='Digital Key settings']")
    public WebElement digitalKeySettingsHeader;

    @AndroidFindBy(xpath = "//*[@text='Tag settings']")
    public WebElement tagSettingsHeader;

    @AndroidFindBy(xpath = "//*[@text='Pin settings for pin locks']")
    public WebElement pinSettingsHeader;

}