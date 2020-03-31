package demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DemoGuru99 {
	static String  baseurl = "http://demo.guru99.com/v1/";
	
	static void switchWindows(WebDriver driver) throws InterruptedException {
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
                driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");     
                driver.findElement(By.name("btnLogin")).click();			
                driver.close();		
            }		
        }		
		// Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
        System.out.println("switchWindows");
        driver.get(baseurl);
	}
	
	static void keyMouseEvents(WebDriver driver, WebElement userName) throws InterruptedException {
		Actions builder = new Actions(driver);
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
		System.out.println("keyMouseEvents");
	}
	
	static void xpathAxesAndAleart(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("here")).click();
		driver.findElement(By.xpath("//*[text() = 'Email ID']//following::input[1]")).sendKeys("ngoc-duc");
		driver.navigate().back();
		driver.findElement(By.xpath("//*[text() = 'UserID']//following::input")).clear();
		driver.findElement(By.xpath("//*[@type = 'text']//following::input")).sendKeys("12345678");
		driver.findElement(By.xpath("//*[text() ='Password']//preceding::input")).sendKeys("abcdef");
		driver.findElement(By.xpath("//*[@type='text']//following::input[2]")).click();
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		System.out.println("xpathAxesAndAleart");
	}
	
	static void openMenu(WebDriver driver) throws InterruptedException {
		WebElement navBar = driver.findElement(By.xpath("//*[@class = 'nav navbar-nav']"));
		List<WebElement> navBarList = navBar.findElements(By.cssSelector("li.dropdown"));
		Thread.sleep(1000);
		navBarList.get(0).click();
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", navBarList.get(0));
//		System.out.println("open menu");
	}
	
	static void scroll(WebDriver driver) throws InterruptedException {
		openMenu(driver);
		driver.findElement(By.xpath("//a[contains(@href, 'scrolling')]")).click();
		WebElement scrollFeature = driver.findElement(By.id("rt-feature"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollBy(100,0)", scrollFeature);
		System.out.println("scroll");
		driver.get(baseurl);
	}
	
	static void radioCheckBox(WebDriver driver) throws InterruptedException {
		openMenu(driver);
		driver.findElement(By.cssSelector("a[href = '../../test/radio.html']")).click();
		List<WebElement> radioList = driver.findElements(By.cssSelector("input[type = 'radio']"));
		radioList.get(0).click();
		radioList.get(1).click();
		radioList.get(2).click();
		radioList.get(1).click();
		radioList.get(0).click();
		radioList.get(2).click();
		driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox1']")).click();
		while(driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox1']")).isSelected() 
				|| driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox3']")).isSelected())
		{
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox2']")).click();
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox3']")).click();
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox2']")).click();
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox1']")).click();
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox2']")).click();
			driver.findElement(By.cssSelector("input[type = 'checkbox'][value = 'checkbox3']")).click();
		}
		System.out.println("radioCheckBox");
		driver.get(baseurl);
	}
	
	public static void main(String[] args) throws InterruptedException, AWTException
	{
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "D:\\Work\\Selenium\\geckodriver.exe");
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver","D:\\Work\\Selenium\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		
//		switchWindows(driver);
		
		driver.get(baseurl);        
//		WebElement userName = driver.findElement(By.name("uid"));
//		WebElement passWord = driver.findElement(By.xpath("//input[@name = 'password']"));
//		userName.sendKeys("duc");
//		passWord.sendKeys("zxcasdqwe321");
//		System.out.println("xpath");
	
//		keyMouseEvents(driver, userName);
	
//		xpathAxesAndAleart(driver);
		
		openMenu(driver);		
		driver.findElement(By.cssSelector("a[href = '../../test/link.html']")).click();
		WebElement fb =  driver.findElement(By.xpath("//a[contains(@href, 'fb')]"));
		System.out.println("fb");
		Actions builder = new Actions(driver);	
		Action seriesOfActions = builder
				.moveToElement(fb)
//				.contextClick()
				.keyDown(fb, Keys.CONTROL)
				.click()
//				.keyUp(fb, Keys.CONTROL)
				.build();
		seriesOfActions.perform() ;
//		Robot rob = new Robot();
//		rob.keyPress(KeyEvent.VK_DOWN);
//		rob.keyRelease(KeyEvent.VK_DOWN);
//		rob.keyPress(KeyEvent.VK_ENTER);
//		rob.keyRelease(KeyEvent.VK_ENTER);
		
		
//		google.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

		
//		driver.get(baseurl);
		
		
//		radioCheckBox(driver);
//        
//		scroll(driver);
//		
//		driver.get(baseurl);
		
        
//		driver.quit();
//		driver.close();
		System.out.println("close");
	}

}
