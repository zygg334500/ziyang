package Edit_test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;

public class DiaochawenjuanEdit implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String diaochawenjuanTitle;
	  @Test(dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
public void diaochawenjuan_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("调查问卷")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发调查问卷")).click();
		  driver.findElement(By.id("all")).click();
		  diaochawenjuanTitle =Uti.get_cooperationName();
		  driver.findElement(By.id("input_title")).sendKeys(diaochawenjuanTitle);
		  JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
	        //remove readonly attribute
	      
	      removeAttribute.executeScript("var setDate=document.getElementById(\"starttime\");setDate.removeAttribute('readonly');") ; 
		  driver.findElement(By.id("starttime")).sendKeys(Uti.get_currenttime());	  
		  removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ;//通过javaScript移除readonly字段
		  driver.findElement(By.id("endtime")).sendKeys("2018-04-05");
		  Uti.richText(driver,0,"信息概述");
		  
		  driver.findElement(By.linkText("下一步")).click();
		  driver.findElement(By.linkText("人工录入调查问卷")).click();
		  driver.findElement(By.linkText("判断题")).click();
		  driver.findElement(By.xpath("(//textarea[contains(@class,'w718')])[1]")).sendKeys("判断题123123");
		  //driver.findElement(By.xpath("(//a[contains(text(),'去学习')])[1]")).click();
		  driver.findElement(By.linkText("保存")).click();
		  driver.findElement(By.linkText("预览已有试题")).click();
		  driver.findElement(By.linkText("确认发布")).click();
		  Assert.assertEquals(true,isTextPresent(diaochawenjuanTitle));
		  driver.findElement(By.xpath("(//li[contains(text(),'布置的调查问卷')])[1]")).click();
		  try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的调查问卷，删除刚刚发的调查问卷
	      Assert.assertEquals(false,isTextPresent(diaochawenjuanTitle));
	      System.out.println("调查问卷被成功移除");
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
		  if(title.indexOf(diaochawenjuanTitle)!=-1){
			  return true;
			  }
			  else{
			  return false;
			  }
		  
	  }
	  public boolean isTitlePresent(String what){
		  try {
			  driver.findElement(By.linkText(what));
			  return true;
		} catch (Exception e) {		
			return false;
			// TODO: handle exception
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
