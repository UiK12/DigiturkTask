package com.umitkaya.TestCases;

import com.umitkaya.BaseClasses.BaseTest;
import java.util.concurrent.TimeUnit;

import com.umitkaya.BaseClasses.Parameters;
import com.umitkaya.Pages.*;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 extends BaseTest{
	
	@Test(priority = 1)
	@Description("User go to beinsports connect thailand page and click subscribe button in the homepage")
	public void step1() {
		driver.navigate().to("https://connect-th.beinsports.com/en");
		WebDriverWait wait = new WebDriverWait(driver,100);
		
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);

		HomePage homepage = PageFactory.initElements(driver,HomePage.class);
		homepage.clickSubcribeButton();
	}

	@Test(priority = 2)
	@Description("User select One Month(Monthly Pass with One Week Free Trial) package in the select your package page.")
	public void step2() throws InterruptedException {
		SubscribePage subscribePage = PageFactory.initElements(driver,SubscribePage.class);
		subscribePage.clickPackageButton();

		subscribePage.getPrice1();

		subscribePage.clickSubscribeMonthButton();
	}
	@Test(priority = 3)
	@Description("User select package and after click subscribe button open create account page. User enter the account information and click create account button")
	public void step3() throws InterruptedException {
		CreateAccountPage createAccountPage = PageFactory.initElements(driver,CreateAccountPage.class);
		Parameters parameters = new Parameters();

		createAccountPage.setTextBox(createAccountPage.firstNameTextBox,parameters.FIRSTNAME);
		createAccountPage.setTextBox(createAccountPage.lastNameTextBox,parameters.LASTNAME);
		createAccountPage.setTextBox(createAccountPage.emailOrPhoneTextBox,parameters.EMAIL);
		createAccountPage.setTextBox(createAccountPage.password,parameters.PASSWORD);

		createAccountPage.createAccount();
	}

	@Test(priority = 4)
	@Description("After user click create account button, open payment method page. Check the subscription price (it must be same select your package page package price) click checkbox and paynow button")
	public void step4() throws InterruptedException {
		ConfirmPaymentPage confirmPaymentPage = PageFactory.initElements(driver,ConfirmPaymentPage.class);
		Parameters parameters = new Parameters();

        confirmPaymentPage.clickButtons(confirmPaymentPage.cancelButton);
		confirmPaymentPage.clickButtons(confirmPaymentPage.checkbox);

        confirmPaymentPage.getPrice2();

        confirmPaymentPage.checkPriceMonth(parameters.PRICE2,parameters.PRICE1);

		confirmPaymentPage.clickButtons(confirmPaymentPage.payNowButton);

	}

        @Test(priority = 5)
		@Description("In payment page, user enter the payment information but card number is wrong. After click payment button and error text must be visible.")
        public void step5() throws InterruptedException {
            PaymentPage paymentPage = PageFactory.initElements(driver,PaymentPage.class);
            Parameters parameters = new Parameters();

            paymentPage.checkCharge(paymentPage.totalCharge,parameters.TOTALCHARGE);

            paymentPage.setText(paymentPage.cardHolderNameTextBox,parameters.CARHOLDERNAME);
            paymentPage.setText(paymentPage.cardNumberTextBox,parameters.CARDNUMBER);

            paymentPage.setExpire(paymentPage.expireMonthCombo);
            paymentPage.setExpire(paymentPage.expireYearCombo);

			paymentPage.setText(paymentPage.cardVerificationCodeTextBox,parameters.VERIFICATIONCODE);

            paymentPage.clickPaymentButton();

            String alert = driver.switchTo().alert().getText();

            Assert.assertTrue(alert.contains(parameters.ERROR));

            driver.switchTo().alert().accept();
	    }



}
