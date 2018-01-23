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
//学员三不提交附件
public class Submit_Task3{

  
  @Test(groups = {"task"},dataProvider = "xueyuan3withvedioPath",dataProviderClass = DateProvider.class)
  public void submit_Task(String username,String password,String vedioPath) throws Exception {
	    DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  	    Uti.ChromeBrowser_setup(driver, username, password);
	    
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
        Uti.richText(driver,0,"老师好啊，我发布了作业内容，请查看附件!");
        try {
        	Uti.UploadVedio(driver,vedioPath);//上传视频方法
		} catch (Exception e) {
		}finally{
        Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.className("video_close")).click();//关闭窗口	
	    driver.findElement(By.linkText("提 交")).click();
	    System.out.println("作业参加成功");
	    driver.quit();
		}
  }

}
