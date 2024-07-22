package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Readconfig;


public class BaseClass {
	
	Readconfig readconfig = new Readconfig();


    public String baseurl = readconfig.getbaseURL();
    public String number = readconfig.getnumber();
    public String searchvalue = readconfig.getsearchvalue();

    public static WebDriver driver;

    public static Logger logger;
    
    
    @Parameters("browser")
    // @BeforeClass - for looping before class not opened the another browser
    
    
    @BeforeMethod
    public void setup(String br) throws InterruptedException {
        logger = Logger.getLogger("Reliance digital");
        PropertyConfigurator.configure("log4j.properties");
        logger.info("browser br = "+ br);
        switch (br.toLowerCase()) {
            case "chrome":
                logger.info("Starting Chrome browser");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                logger.info("Starting Firefox browser");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                logger.info("Starting Internet Explorer browser");
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + br);
        }

        driver.manage().window().maximize();
        driver.get(baseurl);
        logger.info("URL is opened");
    }
       //@AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//            logger.info("Browser is closed");
//        }
  //  }
       
    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    
    
    
    
}




