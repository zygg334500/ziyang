package com.example.tests;

import org.openqa.selenium.chrome.ChromeDriver;

import uti.Uti;

public class Test01 {
		
	public static void main(String[] args) throws Exception{
		
		ChromeDriver driver = new ChromeDriver();
		
		Uti.ChromeBrowser_setup(driver, "devstudent2", "123123");
		driver.manage().window().maximize();
		
//		String s1 = "//td[@class='title1'][contains(@title,'客观题')]/following-sibling::*/a[contains(text(),'去查看')]";
//		driver.findElementByXPath(s1).click();
		
		driver.findElementByPartialLinkText("作业").click();
		Thread.sleep(1000);
		driver.findElementById("tab3").click();
		Thread.sleep(1000);
		
		String s2 = "//a[contains(text(),'自动化测试')]/parent::*/parent::*/following-sibling::*/ul/li/a[@class='t_btn'][contains(text(),'提交')]";
		driver.findElementByXPath(s2).click();
		
	}
	
}
