package testCases;
import java.time.Duration;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.Searchpage;
public class Testcase2 extends BaseClass {

   @Test
    public void Searchvalue() throws InterruptedException {
	   
       logger.info("Browser opened");
       Thread.sleep(3000);
       // to cancel the notification vallue form loginpage
       LoginPage lp = new LoginPage(driver);
       // notification cancel
       lp.cancelUpdateClick();
       logger.info("notification cancel");
       
        // Instantiate the searchPage object
        Searchpage sp = new Searchpage(driver);
        logger.info("main page");
        
        // search content
        Thread.sleep(3000);
        sp.searchinput(searchvalue);
        logger.info("search click");
        
        Thread.sleep(Duration.ofSeconds(5));
        sp.searchiconclick();
        logger.info("search loading");
        
        // Category
        
        Thread.sleep(Duration.ofSeconds(10));
        sp.categoryclick();
        logger.info("select caregory smatphone");
//        
        //brand
        
      try {
    	  Thread.sleep(Duration.ofSeconds(10));
    	  sp.brandclick();
        logger.info("selected brand item");
          } 
      catch (Exception e) {
        logger.error("Error selecting Brand Apple checkbox", e);
    } 
       
        // discount percent
        Thread.sleep(Duration.ofSeconds(5));
        sp.discountclick();
        logger.info("selected discont pers");
        
        // features click
        
        Thread.sleep(Duration.ofSeconds(5));
        sp.featurelistclick();
        logger.info("clicked  feature list ");
        
        // feature see more
        Thread.sleep(Duration.ofSeconds(5));
       sp.featureseemoreclick();
       logger.info("clciked see more");
        
//        //feature list
       Thread.sleep(Duration.ofSeconds(5));
       sp.feature5Gclick();
       logger.info("selected 5G feature");
        
       	// bluetooth feature        
       Thread.sleep(Duration.ofSeconds(5));
        sp.featurebluetoothclick();
        logger.info("selected bluetooth feature");
        // wifi featrure
        Thread.sleep(Duration.ofSeconds(5));
        sp.feature_wifi_click();
        logger.info("selected wifi feature");
        
        // internal storage option
        
        Thread.sleep(Duration.ofSeconds(5));
        sp.internalstorageclick();
        logger.info("internal stoarge list clicked");
        
        Thread.sleep(Duration.ofSeconds(5));
        sp.storage128gbbox();
        logger.info("internal stoarge 128GB clicked");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}}
