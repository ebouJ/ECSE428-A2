package A2;

import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Assignment2 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/mac/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.gmail.com");

		driver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		sleep(1000);

		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("");
		driver.findElement(By.xpath("//span[.='Next']")).click();
		sleep(5000);
		driver.findElement(By.xpath("//*[@role='button' and text()='Compose']")).click();

		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("parkability@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("selenium test");
		
		driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']")).click();
		Thread.sleep(2000);
		 
		//File Need to be imported
		 
		File file = new File("/Users/mac/Desktop/EbouJobeCV.pdf");
		 
		StringSelection stringSelection= new StringSelection(file.getAbsolutePath());
		 
		//Copy to clipboard Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		 
		Robot robot = new Robot();
		StringSelection stringSelection5 = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(
		            stringSelection, null);
		 
		// Cmd + Tab is needed since it launches a Java app and the browser looses focus
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_TAB);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_TAB);
		 
		robot.delay(200);
		 
		//Open Goto window
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_SHIFT);
		 
		robot.keyPress(KeyEvent.VK_G);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_SHIFT);
		 
		robot.keyRelease(KeyEvent.VK_G);
		
		
		 
		//Paste the clipboard value
		 
		robot.keyPress(KeyEvent.VK_META);
		 
		robot.keyPress(KeyEvent.VK_V);
		 
		robot.keyRelease(KeyEvent.VK_META);
		 
		robot.keyRelease(KeyEvent.VK_V);
		 
		//Press Enter key to close the Goto window and Upload window
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		 
		robot.delay(500);
		 
		robot.keyPress(KeyEvent.VK_ENTER);
		 
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
		sleep(5000);
		
		driver.findElement(By.xpath("//*[@role='button' and text()='Send']")).click();
		
		
		
		confirmSent(driver);
	
	}
	
	
	
	private static void sleep(int seconds) {
		  try {
		        Thread.sleep(seconds);
		    } catch (InterruptedException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		   }
	}
	
	private static void confirmSent(WebDriver driver) {
		   WebElement messageSent = (new WebDriverWait(driver, 10))
	        		.until(ExpectedConditions.elementToBeClickable(By.className("bAq")));
	    	
	        if (messageSent != null) {
	        	System.out.println("confirm: email sent");
	        }
	}


}
