package com.umitkaya.Pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.umitkaya.BaseClasses.Parameters;

public class ConfirmPaymentPage {

    Parameters parameters = new Parameters();
    WebDriverWait wait;

    @FindBy(id = "close")
    public WebElement cancelButton;

    @FindBy(tagName = "strong")
    public WebElement priceMonth2;

    @FindBy(xpath = "//*[@id=\"form-basket\"]/div[1]/div[4]/div[1]/label")
    public WebElement checkbox;

    @FindBy(name = "pay-now")
    public WebElement payNowButton;

    public void clickButtons(WebElement element) throws InterruptedException {
        element.click();
        Thread.sleep(500);
    }

    public void getPrice2(){
        parameters.PRICE2 = priceMonth2.getText();
        System.out.println(parameters.PRICE2);
    }

    public void checkPriceMonth(String s1,String s2){
        Assert.assertTrue(s1.contains(s2),"Prices is not equals");
    }
}
