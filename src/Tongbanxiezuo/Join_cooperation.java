package Tongbanxiezuo;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;


public class Join_cooperation implements TestInfo{
	
  private static final ChromeDriver driver =new ChromeDriver();	
  @Test(groups = {"Cooperation"},dataProvider = "xueyuanFilePath",dataProviderClass = DateProvider.class)
  public void join_cooperation(String username,String password,String filePath,String vedioPath) throws Exception {
	  Uti.ChromeBrowser_setup(driver, username, password);	
      driver.findElement(By.partialLinkText("同伴协作")).click();
      driver.findElement(By.id("tab4")).click();
      String xiezuoTitle = TitleQueue.pop(this.getClass().getName());
      System.out.println("协作的标题是"+xiezuoTitle);
//    System.out.println("协作的标题是"+TitleQueue.pop());
      driver.findElement(By.id("tab3")).click();
     // driver.findElement(By.xpath("(//span[contains(text(),'按最新')])[1]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//span[text()='按最新']")).click();
	  driver.findElement(By.partialLinkText(xiezuoTitle)).click(); 
      driver.findElement(By.linkText("同意")).click();
      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
      Uti.waitForAlertAndCloseAlert(driver);
		// TODO: handle exception
	  System.out.println("同伴协作参与成功");
      driver.quit();
  }

@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
