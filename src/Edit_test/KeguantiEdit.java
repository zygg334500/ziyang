package Edit_test;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;

public class KeguantiEdit implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String keguantiTitle;
	  @Test(dataProvider = "zhuanjiaFilePath",dataProviderClass = DateProvider.class)
public void diaochawenjuan_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);
		  driver.findElement(By.partialLinkText("客观题")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  driver.findElement(By.id("ajh")).click();
		 new Select(driver.findElement(By.id("p_list"))).selectByVisibleText("语文教学计划");
		  
		  keguantiTitle =Uti.get_docName();
		  driver.findElement(By.id("input_title")).sendKeys(keguantiTitle);
		  
		  JavascriptExecutor removeAttribute = (JavascriptExecutor)driver;  
		  removeAttribute.executeScript("var setDate=document.getElementById(\"endtime\");setDate.removeAttribute('readonly');") ;//通过javaScript移除readonly字段
		  driver.findElement(By.id("endtime")).sendKeys(Uti.get_currenttime());
		  
		  driver.findElement(By.linkText("下一步")).click();
		  driver.findElement(By.linkText("人工录入")).click();
		  driver.findElement(By.linkText("判断题")).click();
		  driver.findElement(By.name("score")).sendKeys("3");
		  String coditiontitle="判断题123123";
		  driver.findElement(By.xpath("(//textarea[contains(@class,'w718')])[1]")).sendKeys(coditiontitle);		  
		  driver.findElement(By.xpath("(//input[contains(@name,'rightAnswer')])[1]")).click();  
		  driver.findElement(By.linkText("保存")).click();
		  driver.findElement(By.linkText("预览已有试题")).click();
		  Assert.assertEquals(true,isTextPresent("共 3.0 分"));
		  driver.findElement(By.linkText("确认发布")).click();
		  Assert.assertEquals(true,isTextPresent(keguantiTitle));
		  driver.findElement(By.xpath("(//li[contains(text(),'布置的客观题')])[1]")).click();
		  try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的调查问卷，删除刚刚发的调查问卷
	      Assert.assertEquals(false,isTextPresent(keguantiTitle));
	      System.out.println("客观题被成功移除");
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
	public static  void changes(int index2){
			    java.util.Set<String> handles = driver.getWindowHandles();//获取所有窗口句柄  
			    List<String> it = new ArrayList<String>(handles);
			    driver.switchTo().window(it.get(index2));	
			
	  }
	  public boolean checkdata2(){
		  if(title.indexOf(keguantiTitle)!=-1){
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