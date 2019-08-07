package com.umitkaya.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage {

    @FindBy(name = "FirstName")
    public WebElement firstNameTextBox;

    @FindBy(name = "LastName")
    public WebElement lastNameTextBox;

    @FindBy(name = "EmailOrPhone")
    public WebElement emailOrPhoneTextBox;

    @FindBy(name = "Password")
    public WebElement password;

    @FindBy(xpath = "//input[@value='CREATE ACCOUNT']")
    public WebElement createAccountButton;

    public void setTextBox(WebElement element, String string) throws InterruptedException{
        element.sendKeys(string);
        Thread.sleep(1000);
    }

    public void createAccount() throws InterruptedException {
        createAccountButton.click();
        Thread.sleep(10000);
    }
}
