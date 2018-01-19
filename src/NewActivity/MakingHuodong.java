package NewActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
 

public class MakingHuodong implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
	@Test(groups = {"Activity"},dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
  public void checkHuodongOfStudents(String username,String password,String filePath,String vedioPath) throws Exception {
		Uti.ChromeBrowser_setup(driver, username, password);
	    //driver.manage().window().maximize();
	    driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
	    driver.findElement(By.linkText("提交详情")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'未参加')])")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[contains(text(),'未完成')])")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("(//a[contains(text(),'未批阅')])")).click();
	    
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("查看并批阅")).click();
	    Uti.ChangeWindows(driver, 2);
	    driver.findElement(By.id("RadioGroup1_0")).click();
	    driver.findElement(By.id("TextArea2")).sendKeys("干得漂亮，老师相信你");
	    driver.findElement(By.name("isRecommend")).click();
	    driver.findElement(By.cssSelector("input[class='btn l']")).click();//处理带空格的classname的方法，而不是直接用classname的方法查找，那样子会报错
	    
	    Thread.sleep(1000);
	    Uti.waitForAlertAndCloseAlert(driver);   
	    System.out.println("活动批阅成功");
	    driver.quit();
  }
	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
