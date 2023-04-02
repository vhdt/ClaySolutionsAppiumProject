package com.salto_ks.pages;

import com.salto_ks.utils.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()), this);
    }

    //Locators

    @AndroidFindBy(id = "android:id/button1")
    public WebElement warningMessage;

    @AndroidFindBy(xpath = "//*[@class='android.widget.TextView'][4]")
    public WebElement continueButton;

    @AndroidFindBy(id= "nl.moboa.myclay:id/input")
    public WebElement emailInputBox;

    @AndroidFindBy(id = "nl.moboa.myclay:id/button")
    public WebElement continueButtonAfterEmail;

    @AndroidFindBy(xpath = "//*[@resource-id='SubmitButton']")
    public WebElement logInButton;

    @AndroidFindBy(xpath = "//*[@text='Salto KS Demo']")
    public WebElement saltoKsDemoSite;

    @AndroidFindBy(xpath = "//*[@resource-id='Password']")
    public WebElement passwordInputBox;

    @AndroidFindBy(xpath = "//*[@text='NEXT']")
    public WebElement nextButton;

    @AndroidFindBy(xpath = "//*[@text='DONE']")
    public WebElement doneButton;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    public WebElement nextButton2;

    @AndroidFindBy(xpath = "//*[@text='CONTINUE']")
    public WebElement getStartedButton;

    @AndroidFindBy(xpath= "//*[@text='CONTINUE']")
    public WebElement continueButtonAfterActivation;

    @AndroidFindBy(xpath = "//*[@text='RETRY']")
    public WebElement retryButton;





    //Methods
    //public void enterEmail(String){

    //}

}
