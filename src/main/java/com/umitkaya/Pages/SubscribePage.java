package com.umitkaya.Pages;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.umitkaya.BaseClasses.Parameters;

public class SubscribePage {

    Parameters parameters = new Parameters();

    @FindBy(xpath = "//span[text()='ONE MONTH']")
    public WebElement packageButton;

    @FindBy(xpath = "(.//*[text()='Monthly Pass with One Week Free Trial'])/following::a[1]") //(.//*[text()='ONE MONTH'])[1]/following::span[2]
    public WebElement subscribeForMonthButton;

    @FindBy(xpath = "(.//*[text()='ONE MONTH'])[1]/following::span[2]") //(.//*[text()='ONE MONTH'])[1]/following::span[2]
    public WebElement priceMonth1;

    public void clickPackageButton() throws InterruptedException {
        packageButton.click();
        Thread.sleep(2000);
    }

    public void getPrice1(){
        parameters.PRICE1 = priceMonth1.getText();
        System.out.println(parameters.PRICE1);
    }

    public void clickSubscribeMonthButton() throws InterruptedException{
        subscribeForMonthButton.click();
        Thread.sleep(2000);
    }
}
