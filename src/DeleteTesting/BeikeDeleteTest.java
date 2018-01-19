package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;
//已完成
public class BeikeDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String beikeTitle;
	  @Test(dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
public void beike_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("备课")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  //driver.findElement(By.linkText("集体备课")).click();
		  beikeTitle= Uti.get_beikeName();
		  //TitleQueue.push(activityTitle, this.getClass().getName(), "")
		  driver.findElement(By.id("teachingplanTitle")).sendKeys(beikeTitle);
		  //driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.name("endtime")).sendKeys(Uti.get_currenttime());
		  
		  Uti.richText(driver,0,"备课内容");
		  
		  driver.findElement(By.linkText("发布")).click();
		  Thread.sleep(2000);
		  Assert.assertEquals(true,isTextPresent(beikeTitle));	
		  System.out.println("验证完毕");
	try {
		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();  
	} catch (Exception e) {
		  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click(); 
		// TODO: handle exception
	}
		  
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
	      System.out.println("完成第一次删除");
	      Assert.assertEquals(false,isTextPresent(beikeTitle));	
		  System.out.println("备课被成功删除");  
		  driver.quit();
	  }
	  
	  public boolean checkdata(){
		  if(title.indexOf("未发布状态")!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
	  }
	  public boolean checkdata2(){
		  if(title.indexOf(beikeTitle)!=-1){
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