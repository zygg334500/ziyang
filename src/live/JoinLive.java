package live;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;
import Interface.TitleQueue1;
import Interface.TitleQueue2;

public class JoinLive implements TestInfo{
	
	private static final ChromeDriver driver=new ChromeDriver();

  @Test(groups = {"course_learning"},dataProvider = "xueyuan",dataProviderClass = DateProvider.class)
  public void raimn(String username,String password) throws Exception {
		  
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("直播")).click();
		  String a1 = TitleQueue.pop(this.getClass().getName());
		  String a2 = TitleQueue1.pop(this.getClass().getName());
		  String a3 = TitleQueue2.pop(this.getClass().getName());
		  System.out.println(a1+a2+a3);
  }

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
