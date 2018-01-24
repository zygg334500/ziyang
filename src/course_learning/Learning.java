package course_learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;

public class Learning implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();

	  @Test(groups = {"course_learning"},dataProvider = "xueyuan",dataProviderClass = DateProvider.class)
  public void raimn(String username,String password) throws Exception {
		  String comment="学习雷锋好榜样123123123123";
		  String note = "随堂笔记请问企鹅去完全恶气日去微软为其而犬瘟热";
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("课程学习")).click();
		  Thread.sleep(2000);
	      try {
				driver.findElement(By.id("msg_close")).click();  
			} catch (Exception e) {
				// TODO: handle exception
			}
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("(//a[contains(text(),'去学习')])[1]")).click();
          Uti.ChangeWindows(driver, 2);
          //Assert.assertEquals(true,isTextPresent("T2教学与信息化技术手段312313"));	
          String time= driver.findElement(By.id("zonggong")).getText();   //课程详情页的该门课程的总学习时长
          driver.findElement(By.linkText("课程介绍")).click();
          driver.findElement(By.linkText("关闭")).click();
          driver.findElement(By.linkText("发表评论")).click();
          driver.findElement(By.id("user_Comment")).sendKeys(comment);
          driver.findElement(By.linkText("评论")).click();
          driver.findElement(By.linkText("随堂笔记")).click();
          driver.findElement(By.id("user_note")).sendKeys(note);
          driver.findElement(By.linkText("记录")).click();
          driver.findElement(By.linkText("结束学习")).click();
          Uti.waitForAlertAndCloseAlert(driver);
          Thread.sleep(2000);
		  driver.findElement(By.partialLinkText("课程学习")).click();
		  String times=driver.findElement(By.xpath("(//span[@class='fl'])[1]")).getText();//课程列表下第一门课程总学习时间
          //Assert.assertEquals(true,Uti.stringCompare(driver, times, time));		//验证字符串times是否包含time，期望得到的结果是true，即课程列表下的一门课程与课程详情页的总学习时长显示的是一样的
		  Thread.sleep(2000);
	      try {
				driver.findElement(By.id("msg_close")).click();  
			} catch (Exception e) {
				// TODO: handle exception
			}
		  driver.findElement(By.xpath("(//a[contains(text(),'评论')])[1]")).click(); 
		  Thread.sleep(3000);
		  driver.switchTo().frame(driver.findElement(By.className("if_pl")));
          //Assert.assertEquals(true,isTextPresent(comment));		//验证刚刚评论是否生效
          driver.findElement(By.linkText("删除")).click();
          Uti.waitForAlertAndCloseAlert(driver);
          Thread.sleep(1000);
          driver.switchTo().defaultContent();
          driver.findElement(By.linkText("随堂笔记")).click();
          //Assert.assertEquals(true,isTextPresent(note));     //验证刚刚笔记是否生效
          driver.findElement(By.linkText("删除")).click();
          Thread.sleep(2000);
	      driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	//确认删除
	      Thread.sleep(3000);
	      try {
			driver.findElement(By.id("msg_close")).click();  
		} catch (Exception e) {
			// TODO: handle exception
		}
          //Assert.assertEquals(false,isTextPresent(note)); //笔记被删除，不再显示
          driver.quit();
  }
	  
	  
	  public  boolean isTextPresent(String what) {
		  try{
		  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含 文本 what
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
		 
	  }	  

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
