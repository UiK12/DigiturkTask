package com.umitkaya.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(name = "Subscribe")
    public WebElement subscribeButton;

    public void clickSubcribeButton(){
        subscribeButton.click();
    }

}
