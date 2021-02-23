package com.org.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions ;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.org.utility.UIOperation;




public class UpgradePlan extends UIOperation {
	
	 static Logger logger = Logger.getLogger(UpgradePlan.class.getName());
	private static final boolean True = false;
	private static final boolean False = false;
	private static final String Null = null;
	WebDriver driver;
	
	public UpgradePlan(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	String ViewPlan = "/html/body/div[6]/div[5]/div/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]";
	 String  MemberSize="//*[@id=\"react-modals-container\"]/div/div/div[2]/section/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/div/div";
	 String Upgrade="/html/body/div[5]/div/div/div[2]/section/div[2]/div[2]/div[2]/div[3]/button";
	 String radiobutton_yearly="/html/body/payment-modal-container/div/div/div/div/div/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/label/div[2]/div/span";

	 String radiobutton_monthly="/html/body/payment-modal-container/div/div/div/div/div/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/label/div[2]/div/span";
	 String TotalAmount="/html/body/payment-modal-container/div/div/div/div/div/div[2]/div/div/div[1]/span";
	 int yearly_amount=0,calculatedfees=0,totalfees=0;
	 int monthly_amount=0;
	 String TotalFees,error;
	 String seats ="/html/body/payment-modal-container/div/div/div/div/div/div[1]/div[1]/div[2]/div[2]/div/button/span";
	 String CCNumber="/html/body/div/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input";
	 String Cnumber;
	 String ccerrormessage="/html/body/payment-modal-container/div/div/div/div/div/div[1]/div[1]/div[5]/div/div[1]/div/div[3]";
	 
	 String CardNumber="4485254741688559";
	 String review;
	 String iframexpath="/html/body/payment-modal-container/div/div/div/div/div/div[1]/div[1]/div[5]/div/div[1]/div/div[2]/div/iframe";
@Test
	public void ClickOnViewPlanButton()
{
	assertAndClick(ViewPlan);
	logger.info("Clicked the \"View\"Plan Button");
}
 

@Test
public void ClickOnUpgradeButton()
{
driver.findElement(By.xpath(ViewPlan)).click();
try {
	Thread.sleep(800);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Set<String> Windowids= driver.getWindowHandles();
System.out.println("no of windows" +Windowids.size());
String mainwindow = driver.getWindowHandle();
String window1=Windowids.iterator().next();

String window2=Windowids.iterator().next();

if(window1.equals(mainwindow)){

    //System.out.println("in parent windows.. switiching to child");

    driver.switchTo().window(window2);

}
else
{

    driver.switchTo().window(window1);

  System.out.println("switched to second window");
  }

assertAndClick(Upgrade);
try {
	Thread.sleep(500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
logger.info("Clicked on Upgrade button");

}

@Test
public void SelectOptionYearly()
{
	System.out.println("Selecting Yearly Option");
	ClickOnUpgradeButton();
	assertAndClick(radiobutton_yearly);
	TotalFees= assertAndGetText(TotalAmount);
	System.out.println("Total Amount is : "+TotalFees);
	logger.info("Selected Yearly Option" +TotalFees);
	calculatedfees=8*12*2 ;
	totalfees = Integer.parseInt(TotalFees);
	if (calculatedfees==totalfees)
	{
		logger.info("Yearly Fees Calculated Correct" +TotalFees);
	
	}
	else
	{
		logger.info("Amount Calcualted is Incorrect");
	
	}
	
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	@Test
	public void SelectOptionMonthly()
	{
		logger.info("Selecting Monthly Option");
		ClickOnUpgradeButton();
		assertAndClick(radiobutton_monthly);
		TotalFees= assertAndGetText(TotalAmount);
		logger.info("Total Amount is : "+TotalFees);
		calculatedfees=10*2 ;
		totalfees = Integer.parseInt(TotalFees);
		if (calculatedfees==totalfees)
		{
			logger.info("Monthly Fees Calculated Correct" +TotalFees);
			
	}
		else
		{

			logger.info("Amount Calcualted is Incorrect");
			
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
}

	@Test
public void Check()

{      
		ClickOnUpgradeButton();
		new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(iframexpath)));
		driver.findElement(By.cssSelector("#root > form > div > div.CardField-input-wrapper.is-ready-to-slide > span.CardField-number.CardField-child > span:nth-child(2) > div > div.CardNumberField-input-wrapper > span > input")).sendKeys("1234");
		
	//	driver.findElement(By.name("cardnumber")).click();
		
         
		//String Message= driver.findElement(By.xpath("//*[@id=\"root\"]/form/div")).getAttribute("Inner HTML");
		//System.out.println(Message);
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ccerrormessage)));
	    //System.out.println("frame worked");
}

}	


	




