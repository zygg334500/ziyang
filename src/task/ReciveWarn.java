package task;

import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;
import Interface.TitleQueue2;


import uti.Uti;
//学员二应该收到老师发布的作业提醒
public class ReciveWarn implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
  
  @Test(groups = {"task"},dataProvider = "xueyuan2",dataProviderClass = DateProvider.class)
  public void submit_Task(String username,String password) throws Exception {
		
	  Uti.ChromeBrowser_setup(driver, username, password);
	   driver.findElement(By.partialLinkText("通知")).click();
	   Uti.ChangeWindows(driver, 2);
	   String title =TitleQueue2.pop(this.getClass().getName());
	   driver.findElement(By.linkText(title)).click();
	   driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}

}
