package NewActivity;

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
import Interface.TitleQueue2;


import uti.Uti;
//学员四应该收到老师发布的作业提醒
public class ReciveWarn{

  
  @Test(groups = {"task"},dataProvider = "xueyuan4",dataProviderClass = DateProvider.class)
  public void submit_Task(String username,String password) throws Exception {
	    //DesiredCapabilities chromeDesiredcap = DesiredCapabilities.chrome();  
	    //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeDesiredcap);  	  
	    ChromeDriver driver=new ChromeDriver();
	    Uti.ChromeBrowser_setup(driver, username, password);
	   driver.findElement(By.partialLinkText("通知")).click();
	   Uti.ChangeWindows(driver, 2);
	   String title =TitleQueue2.pop(this.getClass().getName());
	   driver.findElement(By.linkText(title)).click();
	   driver.quit();
  }


}
