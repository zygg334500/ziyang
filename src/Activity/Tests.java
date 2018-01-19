package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;



import DateProvider.DateProvider;
import Interface.TestInfo;

public class Tests implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();

  @Test(dataProvider = "teacher",dataProviderClass = DateProvider.class)
  public void raimn(String username,String password) throws Exception {
		  
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("活动")).click();
		   
  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
