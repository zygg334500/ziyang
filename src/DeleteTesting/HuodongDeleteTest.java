package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
//已完成 2017年7/21更新，活动的标题classname更改，脚本需要更新
public class HuodongDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title1;
	  private String title2;
	  private String equals;
	  private String activityTitle;
	  private WebElement webElement;
	  @Test(dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
  public void huodong_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("活动")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  driver.findElement(By.linkText("集体备课")).click();
		  activityTitle= Uti.get_activityName();
		  //TitleQueue.push(activityTitle, this.getClass().getName(), "")
		  driver.findElement(By.id("activityName")).sendKeys(activityTitle);
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		  Uti.richText(driver,0,"活动内容");
		  driver.findElement(By.linkText("保存到下一步")).click();
		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
	      //System.out.println("完成第一次删除");
	      Thread.sleep(1000);
	      driver.findElement(By.xpath("(//a[contains(text(),'删除')])[2]")).click();
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
	      Thread.sleep(1000);
		  driver.findElement(By.linkText("预览")).click();
		  Uti.ChangeWindows(driver, 2);
		  title1=driver.findElement(By.xpath("(//p[contains(@class,'tbxz_tit_bt')])")).getText();//活动标题内容
		  title2=driver.findElement(By.xpath("(//span[contains(@class,'tbxz_zt_go')])")).getText();//发布状态
		  //String a=title.replace(" ", "");
		  //System.out.println(a);
		  equals="活动主题："+activityTitle+"\r"+"未发布状态";
		  System.out.println("发布状态是否符合要求"+checkdata());
		  System.out.println("活动标题是否符合要求"+checkdata2());
		  Assert.assertEquals(true,checkdata());//检查活动的标题名字，确定是否符合预期
		  Assert.assertEquals(true,checkdata2());//检查活动的标题的发布状态，确定是否符合预期
		  driver.close();
		  Uti.ChangeWindows(driver, 1);
		  driver.findElement(By.linkText("发布")).click();	 
		  //Assert.assertEquals(true,isTextPresent(activityTitle));
		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();//删除刚发布的活动
		  driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();//确认删除	  
		  Thread.sleep(2000);
		  Assert.assertEquals(false,isTextPresent(activityTitle));		  
		  System.out.println("无学员参与的活动被成功删除");  
		  driver.quit();
	  }
	  
	  public boolean checkdata(){
		  if(title2.indexOf("未发布状态")!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
		  
	  }
	  public boolean checkdata2(){
		  if(title1.indexOf(activityTitle)!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
		  
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
