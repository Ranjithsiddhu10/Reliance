package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
				ldriver = rdriver;	 
			PageFactory.initElements(rdriver, this);
	       	}
	
	@FindBy(xpath= "//button[@id='wzrk-cancel']")
	WebElement cancelUpdate;
	
	
	@FindBy(id = "RIL_HeaderLoginAndMyAccount")
	WebElement loginbtn;

	@FindBy(xpath = "//button//span[text()='Proceed']")
	WebElement proceedbtn;
	
	@FindBy(xpath = "//button//span[text()='Login']")
	WebElement otploginbtn;

	@FindBy(id = "lMobileNumber")
	WebElement enterMobile;
	
	@FindBy(xpath="//input[@id='l-m-otp']")
	WebElement otpbox;
	
	
	@FindBy(xpath="//div[@class='Input__Error-sc-q4csvm-7 hMaMHi']")
	WebElement errorText;
	
	public void cancelUpdateClick() {
		//System.out.println("cancel btn click");
		
		if (cancelUpdate.isDisplayed()) {
			cancelUpdate.click();
		}
	}
	
	public void loginclick() {
		System.out.println("profile btn click");
		loginbtn.click();
	}
	
	public void entermobile(String number) {
		enterMobile.sendKeys(number);
	}
	
	public void proceedclick() {
		proceedbtn.click();
	}

	public void otploginclick() {
		otploginbtn.click();
	}


	public void enterotp(String otpvalue) {
		otpbox.sendKeys(otpvalue);
	}
	
	public String getErrorText() {
		return errorText.getText();
	}
	public boolean hasErrorText() {
		return errorText.isDisplayed();
	}
}

