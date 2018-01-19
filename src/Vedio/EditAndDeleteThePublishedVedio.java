package Vedio;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import DateProvider.DateProvider;

import uti.Uti;

public class EditAndDeleteThePublishedVedio {
  
	  @SuppressWarnings("deprecation")
	@Test(groups = {"vedio"},dataProvider = "teacherFilePath",dataProviderClass = DateProvider.class)
    public void upVedio(String username,String password,String filePath,String vedioPath) throws Exception {
	    
		DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  		
	    Uti.ChromeBrowser_setup(driver, username, password);
	    driver.findElement(By.partialLinkText("视频")).click();
	    driver.findElement(By.id("upload_pop")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.className("video_close")).click();
	    Thread.sleep(1000);
	    Uti.UploadVedio(driver, vedioPath);
	    Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.className("video_close")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("发布")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[1]")).click(); //编辑第一个视频，也就是我刚刚发布的视频
	    driver.findElement(By.name("_fm.v._0.t")).clear();
	    String vedioTitle= "视频标题"+Uti.get_random();
	    driver.findElement(By.name("_fm.v._0.t")).sendKeys(vedioTitle);
	    driver.findElement(By.linkText("确认")).click();
        System.out.println("成功编辑视频标题并发布");
        Thread.sleep(1000);
        Assert.assertEquals(Uti.isTextPresent(driver, vedioTitle), true); //验证编辑之后的视频标题是否与预期一致
	    driver.findElement(By.id("tabs_1")).click();
	    Thread.sleep(500);
	    
		try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
		  
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的视频，删除刚刚发的视频
		  driver.findElement(By.id("tabs_1")).click();
	      Thread.sleep(1000);
	      Assert.assertEquals(Uti.isTextPresent(driver, vedioTitle), false);//验证删除之后，我发布的视频不再可见
		  driver.quit();

  }
}
