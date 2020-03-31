package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoGuru99 {
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\Work\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver","D:\\Work\\Selenium\\chromedriver.exe");
//		driver = new ChromeDriver();
		
		Actions builder = new Actions(driver);
//		String  baseurl = "http://demo.guru99.com/v1/";
//		driver.get(baseurl);
//		driver.manage().window().maximize();
		
		//Launching popup site
		driver.get("http://demo.guru99.com/popup.php");
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
		Thread.sleep(2000);
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                // Switching to Child window
                driver.switchTo().window(ChildWindow);	 
                System.out.println("ChildWindow");
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");     
                driver.findElement(By.name("btnLogin")).click();			
                driver.close();		
            }		
        }		
		// Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        System.out.println("MainWindow");
        
        driver.findElement(By.xpath("//a[contains(text(), 'Bank')]")).click();
		WebElement userName = driver.findElement(By.name("uid"));
		WebElement passWord = driver.findElement(By.xpath("//input[@name = 'password']"));
		userName.sendKeys("duc");
		passWord.sendKeys("zxcasdqwe321");
		System.out.println("xpath");
		
		Action seriesOfActions = builder
				.moveToElement(userName)
				.click()
				.keyDown(userName, Keys.SHIFT)
				.sendKeys(userName, "hello")
				.keyUp(userName, Keys.SHIFT)
				.doubleClick(userName)
				.contextClick()
				.build();
		seriesOfActions.perform() ;
		System.out.println("keyboard mouse events");
		
		driver.findElement(By.linkText("here")).click();
		System.out.println("linkText");
		driver.findElement(By.xpath("//*[text() = 'Email ID']//following::input[1]")).sendKeys("ngoc-duc");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[text() = 'UserID']//following::input")).clear();
		driver.findElement(By.xpath("//*[@type = 'text']//following::input")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[text() ='Password']//preceding::input")).sendKeys("abcdef");
		System.out.println("xpath axes");
		
		driver.findElement(By.xpath("//*[@type='text']//following::input[2]")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		WebElement navBar = driver.findElement(By.xpath("//*[@class = 'nav navbar-nav']"));
		List<WebElement> navBarList = navBar.findElements(By.cssSelector("li.dropdown"));
		Thread.sleep(1000);
		navBarList.get(0).click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", navBarList.get(0));
		System.out.println("open menu");
		driver.findElement(By.cssSelector("a[href = '../../test/link.html']")).click();
		driver.findElement(By.cssSelector("a[href ='http://demo.guru99.com/V1/index.php']")).click();
		driver.findElement(By.cssSelector("a[href = '../../test/radio.html']")).click();
		
		
//		driver.findElement(By.cssSelector("a[href = '../../test/link.html']")).click();
		
		
		
        
//		driver.quit();
		driver.close();
		System.out.println("close");
	}

}
