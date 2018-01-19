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

public class exchange_comments implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();
   //文章评论和删除
  @Test(groups = {"Documentation_and_exchange"},dataProvider = "xueyuanFilePath",dataProviderClass = DateProvider.class)
  public void exchangeComments(String username,String password,String filePath,String vedioPath) throws Exception {
	    
	    Uti.ChromeBrowser_setup(driver, username, password);
	    driver.findElement(By.partialLinkText("交流")).click();
	    
	    driver.findElement(By.id("tab6")).click();
	    
	    //取消所有置顶
        Uti.getFindElementCount(driver, "取消置顶");
        //取消所有精华
		 Uti.getFindElementCount(driver, "取消精华帖");
		//获取交流标题
		 
	    driver.findElement(By.linkText(TitleQueue.pop(this.getClass().getName()))).click();
	    
	    Uti.ChangeWindows(driver, 2);
	    Thread.sleep(5000);
	    try {			
		    //new WebDriverWait(driver, 4).until(ExpectedConditions.presenceOfElementLocated(By.id( "viewCount" )));//等待4秒，直至指定元素出现
		    WebElement count = driver.findElement(By.id("viewCount"));
		    AssertJUnit.assertEquals("1",count.getText());
		    driver.navigate().refresh();
		    driver.navigate().refresh();
	        Thread.sleep(6000);
	        WebElement count2 = driver.findElement(By.id("viewCount"));
	        AssertJUnit.assertEquals("3",count2.getText());
		} catch (Exception e) {
			System.out.println("交流的浏览数不对");
			// TODO: handle exception
		}
        driver.switchTo().frame("iframe1");
        driver.switchTo().frame(0);
        
	    driver.findElement(By.tagName("body")).sendKeys("give,some,comments.please do not take any attention!");	    
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
