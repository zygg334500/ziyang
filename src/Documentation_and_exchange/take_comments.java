package Documentation_and_exchange;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Interface.TestInfo;

import uti.Uti;

public class take_comments implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
   //文章评论和删除
  @Test(groups = {"Documentation_and_exchange"})
  public void document() throws Exception {
	    
	    Uti.ChromeBrowser_setup( driver, "1.44105915053E12", "123123");
	    driver.findElement(By.partialLinkText("文章")).click();
	    driver.findElement(By.id("tab4")).click();
	    driver.findElement(By.linkText("文章标题")).click();
	    System.out.printf("当前窗口是:"+ driver.getTitle());
	    Uti.ChangeWindows(driver, 2);
	    
	    System.out.printf("当前窗口是:"+ driver.getTitle());
	    Thread.sleep(1000);
	    WebElement count = driver.findElement(By.id("viewCount"));
	    AssertJUnit.assertEquals("1",count.getText());
	    driver.navigate().refresh();
	    driver.navigate().refresh();
	    Thread.sleep(1000);
        WebElement count2 = driver.findElement(By.id("viewCount"));
        AssertJUnit.assertEquals("3",count2.getText());
        
	    driver.switchTo().frame("iframe1");
	    driver.switchTo().frame(0);
	    driver.findElement(By.className("ke-content")).sendKeys("give,some,comments.please do not take any attention!");	    
	    driver.switchTo().parentFrame();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("评论")).click();
	    WebElement Activity_comments= driver.findElement(By.className("txt"));
	    AssertJUnit.assertEquals("give,some,comments.please do not take any attention!",Activity_comments.getText());    
	    //Uti.waitForAlertAndCloseAlert(driver);
	    driver.findElement(By.linkText("删除")).click();
	    Uti.waitForAlertAndCloseAlert(driver);
	    
        WebElement checkcomments= driver.findElement(By.className("fanye"));
	    Assert.assertEquals("共 0 条记录",checkcomments.getText());
	    
  }
  //交流评论和删除
  @Test(groups = {"Documentation_and_exchange"})
  public void exchange() throws Exception {
	    ChromeDriver driver=new ChromeDriver();
	    Uti.ChromeBrowser_setup( driver, "1.44105915053E12", "123123");
	    driver.findElement(By.partialLinkText("交流")).click();
	    
	    driver.findElement(By.id("tab6")).click();
	    driver.findElement(By.linkText("交流标题")).click();
	    
	    Uti.ChangeWindows(driver, 2);
	    WebElement count = driver.findElement(By.id("viewCount"));
	    AssertJUnit.assertEquals("1",count.getText());
	    driver.navigate().refresh();
	    driver.navigate().refresh();
        Thread.sleep(1000);
        WebElement count2 = driver.findElement(By.id("viewCount"));
        AssertJUnit.assertEquals("3",count2.getText());
        driver.switchTo().frame("iframe1");
        driver.switchTo().frame(0);
        
	    driver.findElement(By.className("ke-content")).sendKeys("give,some,comments.please do not take any attention!");	    
	    driver.switchTo().parentFrame();
	    Thread.sleep(1000);
	    driver.findElement(By.linkText("评论")).click();
	    WebElement my_exchange_comments=driver.findElement(By.xpath("(//p[contains(@id,'noesc_context')])[1]"));
	    AssertJUnit.assertEquals("give,some,comments.please do not take any attention!",my_exchange_comments.getText());
	    driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
	    Uti.waitForAlertAndCloseAlert(driver);
	    //AssertJUnit.assertEquals("give,some,comments.please do not take any attention!",my_exchange_comments.getText());
	    System.out.println("评论验证成功");
	    driver.quit();
  }
@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
