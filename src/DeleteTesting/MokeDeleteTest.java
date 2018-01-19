package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;
//待定，有个bug没有修复
public class MokeDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String mokeTitle;
	  @Test(dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
public void moke_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("磨课")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  driver.findElement(By.id("startTime")).sendKeys(Uti.get_currenttime());
		  driver.findElement(By.name("endTime")).sendKeys(Uti.get_currenttime());
		  new Select(driver.findElement(By.id("kindId"))).selectByVisibleText("专题研讨");
		  driver.findElement(By.name("cengji")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.id("dict_tree_con1_1_check")).click();
		  driver.findElement(By.id("dict_tree_con2_1_check")).click();
		  driver.findElement(By.linkText("确定")).click();   //选择所有层级下的人
		  
		  mokeTitle= Uti.get_mokeName();
		  //TitleQueue.push(activityTitle, this.getClass().getName(), "")
		  driver.findElement(By.id("input_title")).sendKeys(mokeTitle);//输入磨课标题
		 
		  Uti.richText(driver,0,"信息概述");
		  Uti.richText(driver,1,"装甲和请问请问撒地方请问qq微软");//发表磨课内容
		  
		  Uti.UploadFile(driver, filePath, "SWFUpload_0");
		  
		  driver.findElement(By.linkText("发布")).click();
		  Thread.sleep(1000);
		  Assert.assertEquals(true,isTextPresent(mokeTitle));//未发布的磨课在我发起的列表下无法看见
		  try {
			 driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			 driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		} 
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的磨课，删除刚刚发的磨课
	      Assert.assertEquals(false,isTextPresent(mokeTitle));//我发起的磨课也看看不见了
	      System.out.println("磨课被成功删除");
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
		  if(title.indexOf(mokeTitle)!=-1){
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
