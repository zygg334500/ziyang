package live;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;

public class AilipayLive implements TestInfo{
	private static final ChromeDriver driver=new ChromeDriver();

	  @Test(groups = {"course_learning"},dataProvider = "zhuanjia",dataProviderClass = DateProvider.class)
  public void raimn(String username,String password) throws Exception {
		  
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("直播")).click();
		  driver.findElement(By.linkText("开启直播")).click();
		  String recordTitle= "支付宝付费直播"+Uti.get_random();
		  driver.findElement(By.id("input_title")).sendKeys(recordTitle);
		  driver.findElement(By.name("subjectId")).click();
          new Select(driver.findElement(By.name("subjectId"))).selectByVisibleText("语文");
		  JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	        //remove readonly attribute
		  removeAttribute.executeScript("var setDate=document.getElementById(\"startTime\");setDate.removeAttribute('readonly');") ; 
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ; 
		  driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
          new Select(driver.findElement(By.id("shour"))).selectByValue(Uti.getTime().get(0));
          new Select(driver.findElement(By.id("ehour"))).selectByValue(Uti.getENdTime().get(0));
          new Select(driver.findElement(By.id("sminute"))).selectByValue(Uti.getTime().get(1));
          new Select(driver.findElement(By.id("eminute"))).selectByValue(Uti.getENdTime().get(1));
          driver.findElement(By.id("alno")).sendKeys("13097384816");
          driver.findElement(By.name("alrealName")).sendKeys("陈益风");
          driver.findElement(By.id("liveFee")).sendKeys("3");
          driver.findElement(By.id("recordFee")).sendKeys("3");
          driver.findElement(By.name("metDesc")).sendKeys("直播简介");
          driver.findElement(By.linkText("发 布")).click();
          driver.findElement(By.linkText("我的直播")).click();
          Thread.sleep(2000);
		  Assert.assertEquals(true,isTextPresent(recordTitle));
		  driver.findElement(By.xpath("(//a[contains(text(),'编辑')])[1]")).click();
          driver.findElement(By.name("metDesc")).sendKeys("555");
          
		  Assert.assertEquals(false,isTagPresent("mtgTitle"));
		  Assert.assertEquals(true,isTagPresent("xkId"));
		  Assert.assertEquals(false,isTagPresent("startDate"));
		  Assert.assertEquals(false,isTagPresent("endDate"));
		  Thread.sleep(2000);
		  
		  Assert.assertEquals(false,isTagPresent("payWay"));
		  Assert.assertEquals(true,isTagPresent("metDesc"));
		  Thread.sleep(1000);

		  driver.findElement(By.xpath("(//a[contains(text(),'更新')])[1]")).click();
          //Assert.assertEquals(true,isTextPresent(recordIntroduce+"555"));

		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("(//a[@value='1' and @class='btn'])")).click();	
          Thread.sleep(2000);
		  Assert.assertEquals(false,isTextPresent(recordTitle));
		  //重新发布直播，并且把标题发送给参与的学员
		  driver.findElement(By.linkText("开启直播")).click();
		  String recordTitle1= "支付宝付费直播"+Uti.get_random();
		  driver.findElement(By.id("input_title")).sendKeys(recordTitle1);
		  driver.findElement(By.name("subjectId")).click();
          new Select(driver.findElement(By.name("subjectId"))).selectByVisibleText("语文");
		  JavascriptExecutor removeAttribute1 = (JavascriptExecutor)driver;  
	        //remove readonly attribute
		  removeAttribute1.executeScript("var setDate=document.getElementById(\"startTime\");setDate.removeAttribute('readonly');") ; 
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ; 
		  driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
          new Select(driver.findElement(By.id("shour"))).selectByValue(Uti.getTime().get(0));
          new Select(driver.findElement(By.id("ehour"))).selectByValue(Uti.getENdTime().get(0));
          new Select(driver.findElement(By.id("sminute"))).selectByValue(Uti.getTime().get(1));
          new Select(driver.findElement(By.id("eminute"))).selectByValue(Uti.getENdTime().get(1));
          driver.findElement(By.id("alno")).sendKeys("13097384816");
          driver.findElement(By.name("alrealName")).sendKeys("陈益风");
          driver.findElement(By.id("liveFee")).sendKeys("3");
          driver.findElement(By.id("recordFee")).sendKeys("3");
          driver.findElement(By.name("metDesc")).sendKeys("直播简介");
          driver.findElement(By.linkText("发 布")).click();
          driver.findElement(By.linkText("我的直播")).click();
          Thread.sleep(2000);
		  Assert.assertEquals(true,isTextPresent(recordTitle1));
		  TitleQueue.push(recordTitle1, this.getClass().getName(),"live.JoinLive");
		  driver.quit();

  }
	  
	  public  boolean isTagPresent(String value) {
		  try{
		  return   driver.findElement(By.name(value)).isEnabled();// 遍历查找到的标签下的所有属性值 并判断是否包含文本 what
		  }
		  catch (Exception e){
		  return false;// 没有该文本 则 返回 false
		  }
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
