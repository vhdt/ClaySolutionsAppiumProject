package com.salto_ks.test;

import com.salto_ks.pages.LoginPage;
import com.salto_ks.pages.SettingsPage;
import com.salto_ks.utils.ConfigurationReader;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class SaltoSettingsAutomation {

    LoginPage loginPage=new LoginPage();
    SettingsPage settingsPage=new SettingsPage();


  //------------------------------Login app with valid credential and move forward until main menu page----------------------------
    @Test
    public void LoginWithValidCredential() throws InterruptedException {
        loginPage.warningMessage.click();
        loginPage.continueButton.click();
        loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("email"));
        loginPage.continueButtonAfterEmail.click();
        Thread.sleep(10000);
        loginPage.passwordInputBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.logInButton.click();

        loginPage.saltoKsDemoSite.click();

        for (int i = 0; i < 3; i++) {
            loginPage.nextButton.click();
        }
        loginPage.doneButton.click();

        loginPage.continueButtonAfterActivation.click();

        for (int i = 0; i < 2; i++) {
            loginPage.nextButton2.click();
        }
        loginPage.getStartedButton.click();

        if(loginPage.retryButton.isDisplayed()){
            loginPage.retryButton.click();
        }else if(loginPage.continueButtonAfterActivation.isDisplayed()){
            loginPage.continueButtonAfterActivation.click();
        }
        Thread.sleep(5000);

        loginPage.continueButtonAfterActivation.click();
        for (int i = 0; i < 2; i++) {
            loginPage.nextButton2.click();
        }
        loginPage.getStartedButton.click();

        assertTrue(settingsPage.settingsModule.isDisplayed());
    }

    //-------------------In settings page , verify the user email is as expected----------------------------------------
    @Test
    public void userEmailInSettingModule(){
        settingsPage.settingsModule.click();
        String expectedUserEmail=ConfigurationReader.getProperty("email");
        String actualUserEmail=settingsPage.userEmailInSettings.getText();
        assertEquals(expectedUserEmail,actualUserEmail);
    }

    //-------------------In settings page , verify the user full name is as expected----------------------------------------
    @Test
    public void userFullNameInSettingModule(){
        settingsPage.settingsModule.click();
        String expectedUserEmail="Latha Prod - Test";
        String actualUserFullName=settingsPage.userFullNameInSettings.getText();
        assertEquals(expectedUserEmail,actualUserFullName);
    }

    //------------------Verify Key settings header is existing and verify the text is as expected--------------------------
    @Test
    public void verifyHeaderInSettings() throws InterruptedException {
        settingsPage.settingsModule.click();
        assertTrue(settingsPage.keySettingsHeader.isDisplayed());
        String expectedHeader="Key settings";
        String actualHeader=settingsPage.keySettingsHeader.getText();
        assertEquals(expectedHeader,actualHeader);
    }

    //------------------------Verify headers under Key settings are as expected--------------------------------------------
    @Test
    public void verifyHeadersUnderKeySetting(){
        List<String> expectedHeaderList= new ArrayList<>();
        expectedHeaderList.addAll(Arrays.asList("Digital Key settings","Tag settings","Pin settings for pin locks"));
        List<String> actualHeaderList=new ArrayList<>();
        String digitalKeySettingsHeaderText=settingsPage.digitalKeySettingsHeader.getText();
        String tagSettingsHeaderText=settingsPage.tagSettingsHeader.getText();
        String pinSettingsHeaderText=settingsPage.pinSettingsHeader.getText();
        actualHeaderList.addAll(Arrays.asList(digitalKeySettingsHeaderText,tagSettingsHeaderText,pinSettingsHeaderText));
        assertEquals(expectedHeaderList,actualHeaderList);
    }
    }







