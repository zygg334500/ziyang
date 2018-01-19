package DeleteTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import uti.Uti;
import DateProvider.DateProvider;
import Interface.TestInfo;
//已完成
public class WenzhangDeleteTest implements TestInfo {
	  private static final ChromeDriver driver=new ChromeDriver();
	  private String title;
	  private String wenzhangTitle;
	  @Test(dataProvider = "guanliyuanFilePath",dataProviderClass = DateProvider.class)
public void wenzhang_delete(String username,String password,String filePath,String vedioPath) throws Exception {
		  Uti.ChromeBrowser_setup(driver, username, password);	
		  driver.findElement(By.partialLinkText("文章")).click();//原来是用xpath或者是用linkText，都不如这个好，这个可变性比较好
		  driver.findElement(By.linkText("发布")).click();
		  wenzhangTitle= Uti.get_docName();
		  //TitleQueue.push(activityTitle, this.getClass().getName(), "")
		  driver.findElement(By.id("input_title")).sendKeys(wenzhangTitle);//输入文章标题
		  
		  Uti.richText(driver,0,"文章内容");
		  
		  try {
			  Uti.UploadFile(driver, filePath, "SWFUpload_0");
			  Uti.UploadVedio(driver, vedioPath);
		} catch (Exception e) {
			  Uti.waitForAlertAndCloseAlert(driver);
			// TODO: handle exception
		}
		  Uti.waitForAlertAndCloseAlert(driver);
		  driver.findElement(By.className("video_close")).click();
		  driver.findElement(By.linkText("保存为草稿")).click();
		  
		  driver.findElement(By.id("tab1")).click(); 
		  Assert.assertEquals(false,isTitlePresent(wenzhangTitle));//未发布的文章在我发起的列表下无法看见
     	  driver.findElement(By.id("tab4")).click();
		  Assert.assertEquals(true,isTitlePresent(wenzhangTitle));//我的草稿下文章能看见
		  driver.findElement(By.linkText("编辑")).click();
		  try {
			  new Select(driver.findElement(By.id("sel_sysDictId2"))).selectByVisibleText("数学");
		} catch (Exception e) {
			// TODO: handle exception
		}		  
		  driver.findElement(By.linkText("发布")).click();
		  driver.findElement(By.id("tab1")).click();
		  Assert.assertEquals(true,isTitlePresent(wenzhangTitle));		
		  
		  Uti.getFindElementCount(driver, "取消置顶");
		  
		  try {
			  driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
		} catch (Exception e) {
			driver.findElement(By.xpath("(//a[contains(text(),'删除')])[1]")).click();
			// TODO: handle exception
		}
		  
	      driver.findElement(By.xpath("//a[contains(@value,'1')]")).click(); //我发起的磨课，删除刚刚发的磨课
	      Assert.assertEquals(false,isTitlePresent(wenzhangTitle));//我发起的磨课也看看不见了
	      System.out.println("文章删除成功");
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
		  if(title.indexOf(wenzhangTitle)!=-1){
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