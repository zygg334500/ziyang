package Activity;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Interface.TestInfo;
import uti.Uti;

public class To_joinActivity implements TestInfo {
	private static final ChromeDriver driver = new ChromeDriver();

	@Test(groups = { "Activity" })
	public void to_joinActivity() throws Exception {
		Uti.ChromeBrowser_setup(driver, "1.44105915053E12", "123123");
		// driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("�")).click();
		// driver.findElement(By.id("tab2")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("����")).click();
		Thread.sleep(1000);

		Uti.ChangeWindows(driver, 2);

		Thread.sleep(1000);
		// driver.findElement(By.id("pl_con_msg_43687")).sendKeys("ѧϰѧϰ");
		driver.findElement(By.xpath("//*[contains(@id, 'pl_con_msg')]")).sendKeys("xuexixuexi");// û��д[]��Ĭ�ϲ��ҵ�һ��id����pl_con_msg��Ԫ�أ����ֶ�̬id��̫�ö�λ��ͨ�����ֶ�λ���ǱȽϺõģ�����������Ŀ�仯���仯��
		// *[@id="buzhou_div1"]
		driver.findElement(By.className("btnbbs")).click();
		driver.findElement(By.cssSelector("#jiadd2 > em")).click();// css��λ��ѡ��ڶ�������
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[2]")).sendKeys("xuexixuexi"); // д��[],�ƶ���������ţ����ҵ��������ͣ�*�������ͣ��ڶ���id����
																										// pl_con_msg��Ԫ��
		// driver.findElement(By.id("pl_con_msg_43689")).sendKeys("��Ҫ����");
		driver.findElement(By.cssSelector("#buzhou_div2 > div.bbslist.linexu > form.taolunfrom > input.btnbbs"))
				.click();// ����css��λԪ�أ������Ҫ���ҵ�����Ҫ�ķ�֧�㣬��#buzhou_div2��ʼ(��Ĳ���һ)������
		driver.findElement(By.cssSelector("#jiadd3 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[3]")).sendKeys("xuexixuexi");
		driver.findElement(By.cssSelector("#buzhou_div3 > div.bbslist.linexu > form.taolunfrom > input.btnbbs"))
				.click();
		driver.findElement(By.cssSelector("a.downbtn.r")).click();

		driver.findElement(By.cssSelector("#jiadd4 > em")).click();// ���Ĳ��������ϴ�
		try {
			driver.findElement(By.id("SWFUpload_0")).click();
			driver.findElement(By.id("SWFUpload_0")).click();
			driver.findElement(By.id("SWFUpload_0")).click();
			Thread.sleep(2000);
			Runtime.getRuntime().exec("C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe");
			WebElement text = driver.findElement(By.className("progressName"));
			Assert.assertEquals("courseImportnew.xls", text.getText());

		} catch (Exception e) {
			System.out.println("û�ϴ��ļ�����");
			Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe", "SWFUpload_0");// û���ϴ��ļ����ٴ��ϴ��ļ�
			// TODO: handle exception
		}
		driver.findElement(By.cssSelector("#jiadd5 > em")).click();
		driver.findElement(By.xpath("(//textarea[contains(@id, 'zhengfang')])[1]")).sendKeys("xuexixuexi"); // ��˼��ͬ�����ҵ�һ��id����zhengfang�ַ�����Ԫ�أ�Ҳ������������zhengfangid�Ƕ�̬���ӵģ�ÿ�ζ��䲻�ü��㡣
		driver.findElement(By.cssSelector("input.btn")).click();
		driver.findElement(By.xpath("(//textarea[contains(@id, 'fanfang')])[1]")).sendKeys("xuexixuexi");
		driver.findElement(By.xpath("(//input[@name=''])[10]")).click();
		driver.findElement(By.cssSelector("#jiadd6 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[4]")).sendKeys("xuexixuexi");
		// driver.findElement(By.id("pl_con_msg_43697")).sendKeys("��������Ƶ������");
		driver.findElement(By.cssSelector("#buzhou_div6 > div.bbslist.linexu > form.taolunfrom > input.btnbbs"))
				.click();
		driver.findElement(By.cssSelector("#jiadd7 > em")).click();
		driver.findElement(By.xpath("(//*[contains(@id, 'pl_con_msg')])[5]")).sendKeys("xuexixuexi");
		driver.findElement(By.cssSelector("#buzhou_div7 > div.bbslist.linexu > form.taolunfrom > input.btnbbs"))
				.click();

		driver.findElement(By.linkText("�������ģ��񣩿��ý�ѧ������˼������������")).click();
		Thread.sleep(4000);
		Uti.ChangeWindows(driver, 3);
		driver.close();// �ر��´򿪵Ĳ鿴��Ƶ����
		Uti.ChangeWindows(driver, 2);
		// Thread.sleep(1000);
		// driver.findElement(By.cssSelector("#buzhou_div7 > div.bbslist.linexu
		// > form.taolunfrom > input.btnbbs")).click();
		driver.findElement(By.cssSelector("#jiadd8 > em")).click();
		Thread.sleep(2000);
		try {
			Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe", "SWFUpload_1");// �ϴ��ļ�
		} catch (Exception e) {
			System.out.println("û���ϴ����ļ��������ϴ�һ��");
			Thread.sleep(2000);
			Uti.UploadFile(driver, "C:/Program Files (x86)/Mozilla Firefox/uploadFile.exe", "SWFUpload_1");// �ϴ��ļ�
			// TODO: handle exception
		}
		driver.findElement(By.partialLinkText("�")).click();
		driver.findElement(By.id("tab2")).click();
		System.out.println("��μӳɹ�");
		driver.quit();
		// driver.findElement(By.linkText("�������")).click();
		// //ȷ�ϴ��Ѳμӻ�б��ҵ��˸û
	}

	@Override
	public ChromeDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
