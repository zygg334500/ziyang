package Activity;


import java.net.SocketException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import DateProvider.DateProvider;
import Interface.TestInfo;
import Interface.TitleQueue;
import uti.Uti;

public class  To_joinActivity implements TestInfo{

	private static final ChromeDriver driver=new ChromeDriver();
	@Test(groups = {"Activity"},dataProvider = "xueyuanContainsClist",dataProviderClass = DateProvider.class)
	public void to_joinActivity(String username,String password,String filePath,String vedioPath,String clist) throws Exception {
		Uti.ChromeBrowser_setup(driver, username, password);
		driver.findElement(By.partialLinkText("活动")).click();
		//driver.findElement(By.id("tab2")).click();//调试专用，稍后注释2018125
		Thread.sleep(1000);
		String title =TitleQueue.pop(this.getClass().getName());
		try {
			driver.findElement(By.id("msg_close")).click();

		} catch (Exception e) {
			System.out.println("没有弹出框");
			// TODO: handle exception
		}
		if(null==title){
			driver.findElement(By.xpath("(//a[contains(text(),'参与活动')])[1]")).click();
		}else {
			driver.findElement(By.linkText(title)).click();   
		}
	    //判断是否获取到标题（该标题来自于全局队列TitleQuue），没有获取到标题那么直接点击第一个活动进行提交
		Thread.sleep(1000);
		Uti.ChangeWindows(driver, 2);//2017/6/27修改了页面标签位置

		Thread.sleep(1000);
		try {
			driver.findElement(By.id("msg_close")).click();

		} catch (Exception e) {
			System.out.println("没有弹出框");
			// TODO: handle exception
		}
		//参加步骤一：讨论
		//driver.findElement(By.id("pl_con_msg_43687")).sendKeys("学习学习");
		driver.findElement(By.xpath("//*[contains(@id, 'pl_con_msg')]")).sendKeys("xuexixuexi");//没有写[]，默认查找第一个id包含pl_con_msg的元素，这种动态id不太好定位，通过这种定位还是比较好的，不会随着项目变化而变化。
		//*[@id="buzhou_div1"]
		driver.findElement(By.className("btnbbs")).click();
		//参加步骤二：问答
		driver.findElement(By.cssSelector("#jiadd2 > em")).click();//css定位，选择第二个步骤
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[2]")).sendKeys("xuexixuexi");  //写了[],制定索引的序号，查找到任意类型（*代表类型）第二个id包含 pl_con_msg的元素
		//driver.findElement(By.id("pl_con_msg_43689")).sendKeys("我要提问");
		driver.findElement(By.cssSelector("#buzhou_div2 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();//根据css定位元素，这很重要，找到最重要的分支点，以#buzhou_div2开始(活动的步骤一)层层剥开
		//参加步骤三：下载资源
		driver.findElement(By.cssSelector("#jiadd3 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[3]")).sendKeys("xuexixuexi");
		driver.findElement(By.cssSelector("#buzhou_div3 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();
		driver.findElement(By.cssSelector("a.downbtn.r")).click();
		Uti.ChangeWindows(driver, 2);
		//参加步骤四：附件上传
		driver.findElement(By.cssSelector("#jiadd4 > em")).click();//第四步，附件上传
		Thread.sleep(3000);
		try {
			driver.findElement(By.id("SWFUpload_0")).click();
			driver.findElement(By.id("SWFUpload_0")).click();
			driver.findElement(By.id("SWFUpload_0")).click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec(filePath);
			WebElement text= driver.findElement(By.className("progressName"));
			Assert.assertEquals("courseImportnew.xls", text.getText());
		} catch (Exception e) {
			System.out.println("没上传文件附件");
			Uti.UploadFile(driver, filePath,"SWFUpload_0");//没有上传文件，再次上传文件
			// TODO: handle exception
		}
		Thread.sleep(3000);
		//参与步骤五：辩论
		driver.findElement(By.cssSelector("#jiadd5 > em")).click();
		driver.findElement(By.xpath("(//textarea[contains(@id, 'zhengfang')])[1]")).sendKeys("xuexixuexi");    //意思相同，查找第一个id包含zhengfang字符串的元素，也就是输入框，这个zhengfangid是动态叠加的，每次都变不好计算。
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.findElement(By.xpath("(//textarea[contains(@id, 'fanfang')])[1]")).sendKeys("xuexixuexi");    
		driver.findElement(By.xpath("(//input[@name=''])[10]")).click();		
		//参加步骤六：观看视频
		driver.findElement(By.cssSelector("#jiadd6 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[4]")).sendKeys("xuexixuexi");
		driver.findElement(By.cssSelector("#buzhou_div6 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();
		//参加步骤七：观课
		driver.findElement(By.cssSelector("#jiadd7 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[5]")).sendKeys("xuexixuexi");
		driver.findElement(By.cssSelector("#buzhou_div7 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText(clist)).click();        
		Thread.sleep(2000);   
		Uti.ChangeWindows(driver,3);
		driver.close();//关闭新打开的查看视频窗口
		Uti.ChangeWindows(driver,2);
		//Thread.sleep(1000);
		//driver.findElement(By.cssSelector("#buzhou_div7 > div.bbslist.linexu > form.taolunfrom > input.btnbbs")).click();
		//参加步骤八：指定提交人
		driver.findElement(By.cssSelector("#jiadd8 > em")).click();
		Thread.sleep(2000);
		try {
			Uti.UploadFile(driver, filePath,"SWFUpload_1");//上传文件
		}catch(SocketException e){
			driver.navigate().refresh();
			driver.findElement(By.cssSelector("#jiadd8 > em")).click();
			Uti.UploadFile(driver, filePath,"SWFUpload_1");//上传文件
		}catch (ElementNotVisibleException e){
			driver.navigate().refresh();
			driver.findElement(By.cssSelector("#jiadd8 > em")).click();
			Uti.UploadFile(driver, filePath,"SWFUpload_1");//上传文件
		} catch (Exception e) {
			Uti.UploadFile(driver, filePath,"SWFUpload_1");//上传文件
			// TODO: handle exception
		}
		driver.findElement(By.partialLinkText("活动")).click();
		driver.findElement(By.id("tab2")).click();
		System.out.println("活动参加成功");
		driver.quit();
	}

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
