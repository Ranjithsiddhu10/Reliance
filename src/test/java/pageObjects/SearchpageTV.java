package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchpageTV {
	WebDriver ldriver;

	public  SearchpageTV(WebDriver rdriver) {
				ldriver = rdriver;	 
			PageFactory.initElements(rdriver, this);
	       	}
	@FindBy	(id="suggestionBoxEle")
	WebElement searchbox;
	
	@FindBy(id ="RIL_HomeSearchButton")
	WebElement searchicon ;
	
	@FindBy(xpath ="//div[text()='Smartphones']")
	WebElement category;
	
	
	// Brand selction
	
	@FindBy(xpath="//div[@class='sf sf__accord__locked']//div[text()='Apple']")
	WebElement  brandfilterclick;
	
	@FindBy(xpath="//div[@class='sf sf__accord__locked']")
	WebElement  brands;
	
	@FindBy(xpath ="//div[text()='10% to 20%']")
	WebElement discountpercent;
	
	
	@FindBy(xpath = "//div[@class='Input__InputWrapper-sc-q4csvm-0 iszwHb']//input")
	List<WebElement> minMaxInput;
	
	@FindBy(xpath = "//div[@class='Input__InputWrapper-sc-q4csvm-0 iszwHb']//input[@value='15000']")
	WebElement minPriceInput;
	
	@FindBy(xpath = "//div[@class='Input__InputWrapper-sc-q4csvm-0 iszwHb']//input[@value='45000']")
	WebElement maxPriceInput;
	// features list
	
	@FindBy(xpath = "//h4 [text()='Features']")
	WebElement featureclick;
	
	@FindBy(xpath ="//div [@class='sf__checks']//*[text()= 'LG']")
	WebElement features5Gbox ;
	
	@FindBy(xpath ="//div [@class='sf__checks']//*[text()= 'Bluetooth']")
	WebElement bluetoothbox ;
	
	//feature see more click
	
	@FindBy(xpath ="//div [@class='sf__checks']//*[text()= 'See More']")
	WebElement seemore ;
	
	@FindBy(xpath ="//div [@class='sf__checks']//*[text()='Wi-Fi']")
	WebElement wifi_box ;
	
	// internal storage
	@FindBy(xpath ="//h4[text()='Internal Storage']")
	WebElement  internalstorage;
	
	@FindBy(xpath ="//div [@class='sf__checks']//*[text()='128 GB']")
	WebElement storage128gbbox;
	
	// Find All category like Brand, Featurs, etc
	@FindBy(xpath="//div [@class='sf ']")
	List<WebElement> ListOfCategory;

	
	// elements methods
	public void searchinput(String searchvalue) {
		searchbox.sendKeys(searchvalue);
	}
	
		 public void searchiconclick() {
			searchicon.click();
		}	
		 
		 public void categoryclick() {
				category.click();
			}

		 public void brandclick() {
				brandfilterclick.click();
			}	
		 
		 public void discountclick() {
				discountpercent.click();
			}
		// feature method
		 
		 public void featurelistclick() {
				featureclick.click();
			}
		 
		 public void feature5Gclick() {
				features5Gbox.click();
			}
		 
		 public void featurebluetoothclick() {
				bluetoothbox.click();
			}
		
			//feature see more click
		 
		 public void featureseemoreclick() {
				seemore.click();
			}
		 
		 
		 public void feature_wifi_click() {
				wifi_box.click();
			}
		 
		 public void internalstorageclick() {
				internalstorage.click();
			}
		 public void storage128gbbox() {
				storage128gbbox.click();
			}
		 
		 public void setMinMaxPrice(String min, String max) {
			 minPriceInput.sendKeys(min);
			 maxPriceInput.sendKeys(max);
			}
		 
	}
	
	
	
