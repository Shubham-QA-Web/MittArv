package Maven_project.Mittarv;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MittArv_Validation2 {

	WebDriver driver;

	@BeforeClass 
	public void WebSite() {

		System.setProperty("webdriver.chrome.driver", "C:\\Chrome driver\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();     
	}

	@Test (priority = 1)
	public void VisitURL() {
		driver.get("https://app.mittarv.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void testValidLogin() throws InterruptedException {
		//Email ID Field
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")).sendKeys("ShubhSurya77@gmail.com");

		// click on Send OTP button 
		driver.findElement(By.id("t2")).click();   

		//Wait
		Thread.sleep(20000);

		// Click on sign in
		driver.findElement(By.cssSelector("#t2")).click(); 

		//Wait For Login page Loading
		Thread.sleep(9000);


		//Click on Add Contact Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/button")).click();

		//click on create new contact field (name) 
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[2]/input")).sendKeys("ABCD");

		//Click On Email Id Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[3]/input")).sendKeys("Abcd@gmail.com");

		//Click On Next Button
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[4]/button")).click();


		//Wait
		Thread.sleep(1000);

		//Add Country Code
		WebElement Dropdown = driver.findElement(By.xpath("//div[@class='DD15__Container']//img"));
		Dropdown.click();
		driver.findElement(By.xpath("//p[@class='t105'][normalize-space()='91']")).click();


		//Add Phone Number
		driver.findElement(By.xpath("//input[@placeholder='0000000000']")).sendKeys("1234567890");

		//Wait
		Thread.sleep(2000);

		//Click On Create Button 
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[4]/div[2]/div[2]/div/span/input")).click();

		//Click On Done Button Through ElementView Scroll
		WebElement DoneButton = driver.findElement(By.className("B47"));
		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		js5.executeScript("arguments[0].scrollIntoView(true);", DoneButton);
		DoneButton.click();

		Thread.sleep(3000);

		//PopUp Alert Button Handle
		Alert alert = driver.switchTo().alert();
		alert.accept();


		//Wait 
		Thread.sleep(1000);


		//Logout
		WebElement DashBoardHome = driver.findElement(By.className("home__profile"));
		WebElement logoutButton = driver.findElement(By.xpath("//p[normalize-space()='Logout']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);
		logoutButton.click();


		//Wait 
		Thread.sleep(2000);
	}

	@AfterClass

	public void tearDown( ) {
		driver.close();	     

	}




}

