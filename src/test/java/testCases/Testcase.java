package testCases;

import java.time.Duration;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
public class Testcase extends BaseClass {

   @Test
    public void logintest() throws InterruptedException {
	   System.out.println("profile click");
       logger.info("Browser opened");

        // Instantiate the LoginPage object
        LoginPage lp = new LoginPage(driver);
        logger.info("login is activated");

        // Perform login steps
       Thread.sleep(3000);
       lp.cancelUpdateClick();
       Thread.sleep(3000);
        lp.loginclick();
        System.out.println("profile click");
        logger.info("profile click");
        
        Thread.sleep(5000);
        lp.entermobile(number);
        lp.proceedclick();
        Thread.sleep(Duration.ofMinutes(1));
        logger.info("Click the otp login");
        lp.otploginclick();
        
        logger.info("login successfull");
        
//        lp.enterMobile(number);
//        logger.info("entered themobile number");
//
//        lp.continuebtn();
//        logger.info("Click the continue button");
    }
}













