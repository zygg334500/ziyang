package Documentation_and_exchange;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Interface.TestInfo;

import uti.Uti;

public class Sent_Exchange implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  @Test(groups = {"Documentation_and_exchange"})
  public void sent_exchange() throws Exception {
	    
	    Uti.ChromeBrowser_setup( driver, "devguanliyuan", "3edc$RFV");
	    driver.findElement(By.partialLinkText("交流")).click();
	    driver.findElement(By.linkText("发布")).click();
	    driver.findElement(By.id("input_title")).clear();
	    driver.findElement(By.id("input_title")).sendKeys("交流标题");
        Uti.richText(driver, 0, "交流内容");  
	    Uti.UploadFile(driver, "E:/Downloads/uploadFile.exe","SWFUpload_0");//上传文件	    	
	    driver.findElement(By.linkText("发 布")).click();
	    driver.findElement(By.linkText("退出")).click();
	    System.out.println("交流发布成功");
	    driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
