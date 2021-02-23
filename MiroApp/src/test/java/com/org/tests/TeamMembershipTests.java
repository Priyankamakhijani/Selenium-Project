package com.org.tests;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.org.utility.StartWebsiteTest;





public class TeamMembershipTests extends StartWebsiteTest {
	

@Test
public void tc_01_ViewPlanClick() {

	
	ugp.ClickOnViewPlanButton();
	try {
		Thread.sleep(500);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 

}
@Test
public void tc_03_UpgradeButtonClick()
{
	ugp.ClickOnUpgradeButton();
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
}
@Test
public void tc_04_CheckForYearlyBillingPeriod()
{
	ugp.SelectOptionYearly();
}

@Test
public void tc_05_CheckForMonthlyBillingPeriod()
{	
ugp.SelectOptionMonthly();
}

@Test
public void tc_06_CheckCreditCardDetails()
{
	//ugp.Check();
}
}



	

