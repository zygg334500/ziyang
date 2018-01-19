package Documentation_and_exchange;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;

import uti.Uti;

public class doc_comments implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
   //文章评论和删除
  @Test(groups = {"Documentation_and_exchange"},dataProvider = "xueyuanFilePath",dataProviderClass = DateProvider.class)
  public void documentComments(String username,String password,String filePath,String vedioPath) throws Exception {
	    
	  Uti.ChromeBrowser_setup(driver, username, password);
	  driver.findElement(By.partialLinkText("文章")).click();
	  driver.findElement(By.id("tab4")).click();
	  driver.findElement(By.linkText(TitleQueue.pop(this.getClass().getName()))).click();

	    Uti.ChangeWindows(driver, 2);
	//	  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("viewCount")));
		Thread.sleep(6000);
	    WebElement count = driver.findElement(By.id("viewCount"));
	    try {
		    AssertJUnit.assertEquals("1",count.getText());
		    driver.navigate().refresh();
		    driver.navigate().refresh();
		    Thread.sleep(1000);
	        WebElement count2 = driver.findElement(By.id("viewCount"));
	        AssertJUnit.assertEquals("3",count2.getText());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("文章的浏览数不对");
		}
	    driver.switchTo().frame("iframe1");
	    driver.switchTo().frame(0);
	    driver.findElement(By.tagName("body")).sendKeys("give,some,comments.please do not take any attention!");	    
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
	    driver.quit();
  }
  
@Override
public ChromeDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}
}
