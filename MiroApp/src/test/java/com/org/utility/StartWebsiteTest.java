
package  com.org.utility;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.pages.UpgradePlan;






public class StartWebsiteTest {
	
	static Logger logger = Logger.getLogger(StartWebsiteTest.class.getName());
	
	 private static Properties prop = ConfigFileReader.ReadProperties();
	    public final static String URL = prop.getProperty("url");
	    public final static String BROWSER = prop.getProperty("browser");
	    public final static String USERNAME = prop.getProperty("username");
	    public final static String PWD = prop.getProperty("pwd");

	String LoginButton ="x";
	String LoginId="//*[@id=\"email\"]";
	String Pass = "//*[@id=\"password\"]";
	String Signin="/html/body/div[2]/div/div[2]/div[1]/div/div/form/button";
	public WebDriver driver;
	public UpgradePlan ugp;
	 @BeforeMethod(alwaysRun = true)
	    public void setUp() {
		 System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");   
		 driver = new ChromeDriver();
	        
		
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get(URL);
	        ugp=new UpgradePlan(driver);
			
	        driver.findElement(By.xpath(LoginId)).clear();
	        driver.findElement(By.xpath(LoginId)).sendKeys(USERNAME);
			
	    
	        driver.findElement(By.xpath(Pass)).clear();
	        driver.findElement(By.xpath(Pass)).sendKeys(PWD);
	        
	       
	        driver.findElement(By.xpath(Signin)).click();
			
	        try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        
	       
	        logger.info("Logged into Miro Website");
		}
	 
	      
	  /* private void assertElementPresent(String loginId2) {
		// TODO Auto-generated method stub
		
	}*/

	@AfterMethod(alwaysRun = true)
	  public void teardown(ITestResult result) {
	        if (driver != null) {
	            if (ITestResult.FAILURE == result.getStatus()) {
	                ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
	            } }   
		driver.quit();
	   }    
		/*@Test
	      public void checkTest()
	      {System.out.print("From @Test");
	      }*/
	      
}	      






