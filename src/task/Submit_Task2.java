package task;

import org.testng.annotations.Test;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;


import uti.Uti;
//学员二不提交视频
public class Submit_Task2 {

  
  @Test(groups = {"task"},dataProvider = "xueyuan2withfilePath",dataProviderClass = DateProvider.class)
  public void submit_Task(String username,String password,String filePath) throws Exception {
	    DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  	  Uti.ChromeBrowser_setup(driver, username, password);
	    
	    driver.findElement(By.partialLinkText("作业")).click();
        driver.findElement(By.id("tab3")).click();
        Thread.sleep(2000);
        try {
			driver.findElement(By.id("msg_close")).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
        driver.findElement(By.linkText("提交")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.className("ke-edit-iframe")));
        driver.findElement(By.className("ke-content")).sendKeys("老师好啊，我发布了作业内容，请查看附件!");
        driver.switchTo().defaultContent();
        Uti.UploadFile(driver, filePath,"SWFUpload_0");//上传文件
	    driver.findElement(By.linkText("提 交")).click();
	    System.out.println("作业参加成功");
	    driver.quit();
		
  }
}
