package com.umitkaya.Pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentPage {
    @FindBy(name = "Ecom_Payment_Card_Name")
    public WebElement cardHolderNameTextBox;

    @FindBy(name = "Ecom_Payment_Card_Number")
    public WebElement cardNumberTextBox;

    @FindBy(name = "Ecom_Payment_Card_ExpDate_Month")
    public Select expireMonthCombo;

    @FindBy(name = "Ecom_Payment_Card_ExpDate_Year")
    public Select expireYearCombo;

    @FindBy(name = "Ecom_Payment_Card_Verification")
    public WebElement cardVerificationCodeTextBox;

    @FindBy(name = "payment")
    public WebElement paymentButton;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Total charge :'])[1]/following::small[1]")
    public WebElement totalCharge;

    public void setText(WebElement element,String string) throws InterruptedException {
        element.sendKeys(string);
        Thread.sleep(500);
    }

    public void setExpire(Select select){
        select.selectByIndex(2);
    }

    public void checkCharge(WebElement element,String string){
        Assert.assertTrue(element.getText().contains(string), "Charge Result is wrong!!");
    }

    public void clickPaymentButton(){
        paymentButton.click();
    }

}
