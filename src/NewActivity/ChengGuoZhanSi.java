package NewActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;

import uti.Uti;

public class ChengGuoZhanSi implements TestInfo{
	
	private static final ChromeDriver driver=new ChromeDriver();
	
  @Test(groups = {"Activity"},dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
  public void publishHuodong(String username,String password,String filePath,String vedioPath) throws Exception {
	  Uti.ChromeBrowser_setup(driver, username, password);
	  driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
	  driver.findElement(By.linkText("发布")).click();
	  driver.findElement(By.className("yd")).click();
	  String huodongTitle=Uti.get_activityName();
	  TitleQueue.push(huodongTitle,this.getClass().getName(),"NewActivity.JoinActivity");
	  driver.findElement(By.id("activityName")).sendKeys(huodongTitle);
	  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
	  driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
	  Uti.richText(driver,0,"活动内容我去饿请问企鹅请问请问请问请问额");
	  driver.findElement(By.linkText("保存到下一步")).click();
	  driver.findElement(By.linkText("发布")).click();
	  try {
		Uti.waitForAlertAndCloseAlert(driver);
	} catch (Exception e) {
	    System.out.println("没有捕捉到alert框");
		// TODO: handle exception
	}
	  driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[1]")).click();
	  driver.findElement(By.linkText("保存")).click();//没有上传附件，点击保存，会有相关提示，无法保存步骤
      Assert.assertEquals(isTextPresent("附件不能为空"), true);
	  Uti.richText(driver,0,"活动内容我去饿请问企鹅请问请问请问请问额");
	  Uti.UploadFile(driver, filePath, "SWFUpload_0");
	  driver.findElement(By.linkText("保存")).click();
	  
	  driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[4]")).click();
	  Uti.UploadFile(driver, filePath, "SWFUpload_0");
	  driver.findElement(By.linkText("保存")).click();
	  //实现活动步骤的拖拽效果
	   WebElement orange=driver.findElement(By.xpath("(//span[contains(@class,'orange')])[1]"));
	   WebElement orange3=driver.findElement(By.xpath("(//span[contains(@class,'orange')])[3]"));
       Uti.dragHuodongStep(orange, orange3, driver);
       driver.findElement(By.linkText("发布")).click();
       driver.quit();
	   
  }
  
  public  boolean isTextPresent(String what) {
	  try{
	  return driver.findElement(By.tagName("body")).getText().contains(what);// 遍历body节点下的所有节点 取其文本值 并判断是否包含文本 what
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
