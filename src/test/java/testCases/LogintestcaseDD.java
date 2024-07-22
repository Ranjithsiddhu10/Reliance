package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import utility.XLUtilities;

public class LogintestcaseDD extends BaseClass {
	@Test(dataProvider ="LoginData" )
	public  void logintestcase(String mobilenum , String Otp, String message) throws InterruptedException, IOException {
    	logger.info("Browser opened" + mobilenum + " " + Otp);
    	   Thread.sleep(Duration.ofSeconds(10));
        
        // to cancel the notification value form loginpage
        LoginPage lp = new LoginPage(driver);
        
        Thread.sleep(Duration.ofSeconds(5));
        // notification cancel
        lp.cancelUpdateClick();
        logger.info("notification cancel");
        
        lp.loginclick();
        logger.info("clicked login button");
        Thread.sleep(Duration.ofSeconds(5));
         lp.entermobile(mobilenum);
         logger.info("entered mobile num");
        
         
         Thread.sleep(Duration.ofSeconds(5));
         lp.proceedclick();

         Thread.sleep(Duration.ofSeconds(3));
         logger.info("clicked precced button==>"+ lp.hasErrorText());
         if(lp.hasErrorText()) {
        	 String hasErrorText = lp.getErrorText();
        	 System.out.println( "error text " + " ==>" + hasErrorText);
         Assert.assertEquals("OTP Limit exceeded. Please try after some time.", hasErrorText);
         Thread.sleep(Duration.ofSeconds(5));
         } else {
        	 lp.enterotp(Otp);
             logger.info("Entered otp");
             
             Thread.sleep(Duration.ofSeconds(5));
             lp.otploginclick();
             Thread.sleep(Duration.ofSeconds(5));
              String hasErrorText1 = lp.getErrorText();
              if(hasErrorText1.equals("OTP entered is incorrect. Please enter the correct OTP"))
              {
                 Assert.assertEquals( hasErrorText1,"OTP entered is incorrect. Please enter the correct OTP");
                 logger.info("clicked login otp btn"+ hasErrorText1);
                 captureScreen(driver, Otp);
                 Thread.sleep(Duration.ofSeconds(5));
              }
              else if (hasErrorText1.equals("Invalid OTP")){
            	  Assert.assertEquals( hasErrorText1,"Invalid OTP");
                  logger.info("clicked login otp btn"+ hasErrorText1);
                  captureScreen(driver, Otp);
                  Thread.sleep(Duration.ofSeconds(5));
              }
         }
         Thread.sleep(Duration.ofSeconds(5));
        	 logger.info("");
         }
        
	
      @DataProvider(name = "LoginData")
        public Object[][] getData() throws IOException {
            // Debugging: Print the working directory
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
            
         // Corrected the file path assignment
        String excelFilePath = System.getProperty("user.dir") + "/src/test/java/testDatas/relianceData.xlsx"; 
        // Update the path to your Excel file
        FileInputStream fis = new FileInputStream(excelFilePath);
        int rowcount = XLUtilities.getRowCount(excelFilePath, "Sheet3" );
        int colcount = XLUtilities.getCellCount(excelFilePath, "Sheet3", 1);
        System.out.println("colcount"+ colcount + "  " + rowcount);
        String  logindata[][] = new String [rowcount][colcount];
        	for(int i=0; i<rowcount; i++ )	{
        		for(int j=0; j<colcount; j++) {
        			String cellValue = XLUtilities.getCellData(excelFilePath, "Sheet3", i, j);
        			if (cellValue.length() > 0) {
        				logindata [i][j]= cellValue;
            			System.out.println("loop =>"+logindata [i][j]);
        			}
        		}
        	}
        	System.out.println("logindata length==>"+ logindata.length);
        	
        		 return logindata;
      }
   }
