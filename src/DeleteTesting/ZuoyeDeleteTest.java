package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import uti.Uti;

import DateProvider.DateProvider;
import Interface.TestInfo;
//已完成
public class ZuoyeDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String zuoyeTitle;
	  @Test(dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
  public void zuoye_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("作业")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  driver.findElement(By.id("alluser")).click();
		  
		  zuoyeTitle= Uti.get_zuoyeName();
		  //TitleQueue.push(activityTitle, this.getClass().getName(), "")
		  driver.findElement(By.id("input_title")).sendKeys(zuoyeTitle);
		  //driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	        //remove readonly attribute
	        removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ;
		  driver.findElement(By.name("endtime")).sendKeys(Uti.get_currenttime());
		  
		  Uti.richText(driver,0,"作业内容");
		  
		  try {
			  Uti.UploadFile(driver, filePath, "SWFUpload_0");
			  Uti.UploadVedio(driver, vedioPath);
		} catch (Exception e) {
			  Uti.waitForAlertAndCloseAlert(driver);
			// TODO: handle exception
		}
		  Uti.waitForAlertAndCloseAlert(driver);
		  driver.findElement(By.className("video_close")).click();
		  driver.findElement(By.linkText("预览")).click();
		  Uti.ChangeWindows(driver, 2);
		  driver.close();
		  Uti.ChangeWindows(driver, 1);
//		  driver.findElement(By.className("ke-dialog-icon-close")).click();
		  driver.findElement(By.linkText("保存为草稿")).click();
		  driver.findElement(By.id("tab1")).click();
		  Assert.assertEquals(false,isTextPresent(zuoyeTitle));
		  driver.findElement(By.id("tab3")).click();
		  driver.findElement(By.linkText("编辑")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.linkText("发 布")).click();
		  driver.findElement(By.id("tab1")).click();
		  driver.findElement(By.id("tab1")).click();
	      driver.navigate().refresh();
	      driver.navigate().refresh();
	      Thread.sleep(2000);
		  driver.findElement(By.id("tab1")).click();
		  Thread.sleep(2000);
		  Assert.assertEquals(true,isTextPresent(zuoyeTitle));
		  Thread.sleep(1000);
		  driver.findElement(By.id("tab2")).click();
		  //System.out.println("在tab2中");
		  try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
		  //driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click();
	      Thread.sleep(3000);
	      
	      System.out.println("作业被成功删除");
	      System.out.println(zuoyeTitle);
	      driver.navigate().refresh();
	      driver.navigate().refresh();
	      Thread.sleep(1000);
	      Assert.assertEquals(false,isTextPresent(zuoyeTitle));
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
		  if(title.indexOf(zuoyeTitle)!=-1){
			  return true;
			  }
			  else{
			  return false;
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
