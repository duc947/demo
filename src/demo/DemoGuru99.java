package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoGuru99 {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Work\\Selenium\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","D:\\Work\\Selenium\\chromedriver.exe");
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		
		String  baseurl = "http://demo.guru99.com/v1/";
		driver.get(baseurl);
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		WebElement userName = driver.findElement(By.name("uid"));
		WebElement passWord = driver.findElement(By.xpath("//input[@name='password']"));
		userName.sendKeys("duc");
		passWord.sendKeys("zxcasdqwe321");
		System.out.println("xpath");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("here")).click();
		System.out.println("text()");
		driver.findElement(By.xpath("//*[text()='Email ID']//following::input")).sendKeys("ngoc-duc");
		System.out.println("following");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.navigate().back();
		
		driver.findElement(By.xpath("//*[text()='UserID']//following::input")).clear();
		driver.findElement(By.xpath("//*[@type='text']//following::input")).sendKeys("12345678");
		System.out.println("following");
		driver.findElement(By.xpath("//*[text()='Password']//preceding::input")).sendKeys("abcdef");
		System.out.println("preceding");
		driver.findElement(By.xpath("//*[@type='text']//following::input[2]")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		WebElement navBar = driver.findElement(By.cssSelector("ul[class = 'nav navbar-nav']"));
		List<WebElement> navBarList = navBar.findElements(By.cssSelector("li.dropdown"));
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		navBarList.get(0).click();//findElement(By.cssSelector("a.dropdown-toggle")).click();
//		driver.findElement(By.cssSelector("a[class = 'dropdown-toggle']")).click();
		System.out.println("open menu");
		driver.findElement(By.cssSelector("a[href = '../../test/link.html']")).click();
//		driver.findElement(By.xpath("//a[text()= 'Accessing Link']")).click();
		System.out.println("click link");
		driver.findElement(By.cssSelector("a[href='http://demo.guru99.com/V1/index.php']")).click();
		System.out.println("click Bank");
		
		driver.close();
//		driver.quit();
		
		System.out.println("close");
	}

}
