package Vedio;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import DateProvider.DateProvider;

import uti.Uti;

public class UploadVedio {
  
	  @Test(groups = {"vedio"},dataProvider = "teacherFilePath",dataProviderClass = DateProvider.class)
    public void upVedio(String username,String password,String filePath,String vedioPath) throws Exception {
	    
		//DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  		
		ChromeDriver driver = new ChromeDriver();
		Uti.ChromeBrowser_setup(driver, username, password);
	    driver.findElement(By.partialLinkText("视频")).click();
	    driver.findElement(By.id("upload_pop")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.className("video_close")).click();

		//修改学段、学科
		try{
			new Select(driver.findElement(By.id("sel_sysDictId1"))).selectByIndex(2);  

			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId2"))).selectByIndex(1);   
			Thread.sleep(500);
		}catch (Exception e){
			System.out.println("无学段、学科");
		}
				
		//修改教材版本
		try{
			new Select(driver.findElement(By.id("sel_sysDictId3"))).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId4"))).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId5"))).selectByIndex(1);  
			Thread.sleep(500);
			new Select(driver.findElement(By.id("sel_sysDictId6"))).selectByIndex(1);  
			Thread.sleep(500);
		}catch (Exception e){
			System.out.println("无教材版本");
		}

	    
	    Thread.sleep(1000);
	    Uti.UploadVedio(driver, vedioPath);
	    Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.className("video_close")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("发布")).click();
		driver.quit();

  }
}
