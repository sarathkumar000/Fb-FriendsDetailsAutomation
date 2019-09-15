package automationTest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestData {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		driver.findElement(By.id("email")).sendKeys("");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//*[@data-click=\"profile_icon\"]")).click();
		//driver.findElement(By.xpath("//(a[contains(text(),\"Friends\")])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"fbTimelineHeadline\"]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(3000);
		for(int i=0;i<30;i++)
		{
			System.out.println(i+"times");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		}
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		List<WebElement> li = driver.findElements(By.xpath("//div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2][a and a]"));
		//div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2]/a/ancestor::div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2]/div/a
		//div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2]/a/ancestor::div/a
		//List<WebElement> le = driver.findElements(By.xpath("//div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2]/a"));
		//*[@class='fsl fwb fcb']
		//div[@id='pagelet_timeline_medley_friends']/div[2]/div/ul/li/div/div/div[2]/div/div[2]/div/a
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(li.size());
		//System.out.println(le.size());
		for(int i=0;i<li.size();i++)
		{
			String temp =li.get(i).getText();
			String arr[]=temp.split("\\n");
			System.out.println(arr[0]+"  " + arr[1]);
			list.add(arr[0]);
			//System.out.println(le.get(i).getText());
		}
		//.get(i).getText()
		
		for(int i=0;i<list.size();i++)
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='inputtext' and @role='combobox']")).sendKeys(list.get(i));
		Thread.sleep(2000);
		
		//div[@class="fsl fwb fcb"]/a
		List<WebElement> finde = driver.findElements(By.xpath("//li[@class=\"fbProfileBrowserListItem\"]/div/a"));
		if(finde.size()>1)
		{
		for(int j=0;j<finde.size();j++)
		{
			//driver.findElement(By.xpath("//li[@class=\"fbProfileBrowserListItem\"][j]/div/a")).click();
			System.out.println(finde.get(j));
		}
		}
		else
		{
			driver.findElement(By.xpath("//li[@class=\"fbProfileBrowserListItem\"]/div/a")).click();
		}
		
		//List<WebElement> college = driver.findElements(By.xpath("//a[@class=\"profileLink\"][2]"));
		//List<WebElement> place = driver.findElements(By.xpath("//div/*[contains(text(),'Lives in')]/a"));
		driver.navigate().back();
		Thread.sleep(3000);
		
		//div/*[contains(text(),'Lives in')]/a
		}
		/*for(int i=0;i<list.size();i++)
		{
			System.out.println(college.get(i).getText()+" "+place.get(i).getText());
		}*/
		
		
		
	}

}
