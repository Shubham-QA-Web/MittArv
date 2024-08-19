package Maven_project.Mittarv;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class MIttArv_Validation_1 {

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
		driver.manage().deleteAllCookies();
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
		//wait
		//Thread.sleep(130000);
		//Resend Otp Button Click
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]")).click(); // Click on Resend otp


		//Wait For Login page Loading
		Thread.sleep(9000);

		//Click On View Profile
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]")).click();	 

		//Wait
		Thread.sleep(1000);

		//Click on Edit Button
		driver.findElement(By.className("edit_button")).click();

		//Wait
		Thread.sleep(1000);

		//Name Field Clear
		driver.findElement(By.xpath("//input[@value='Shubham Suryawanshi']")).clear();



		//Update Name Field
		driver.findElement(By.xpath("//input[@value='Shubham Suryawanshi']")).sendKeys("Shubh Surya");

		Thread.sleep(1000);

		//Update Status To Terminally ill
		WebElement Dropdown = driver.findElement(By.xpath("//div[@class='main_container']//div[2]//div[1]//div[1]//img[1]"));
		Dropdown.click();
		driver.findElement(By.xpath("//p[@class='t105'][normalize-space()='Terminally ill']")).click();

		//wait
		Thread.sleep(2000);

		//Add New Email Id
		driver.findElement(By.xpath("//div[@class='label-03-bold-ul alternate_mail']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter email']")).sendKeys("shubhamsuryawanshi956@gmail.com");

		//Wait
		Thread.sleep(1000);



		//ScrollDown Till Country
		WebElement element = driver.findElement(By.xpath("//div[6]//div[1]//div[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		//Wait
		Thread.sleep(2000);


		//Scroll up
		WebElement element2 = driver.findElement(By.className("heading_text"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("arguments[0].scrollIntoView(true);", element2);

		//Wait
		Thread.sleep(1000);

		//Click On Save Button
		driver.findElement(By.xpath("//button[@class='B47']")).click();

		//Wait
		Thread.sleep(16000);

		//Verify Otp
		driver.findElement(By.xpath("//button[normalize-space()='VERIFY']")).click();

		//Wait
		Thread.sleep(7000);

		//Save Button
		driver.findElement(By.xpath("//span[@class='save_button_text']")).click();


		//Wait
		Thread.sleep(2000);

		//Scroll Down To Log Out
		WebElement DashBoardHome = driver.findElement(By.className("home__profile"));
		WebElement logoutButton = driver.findElement(By.xpath("//p[normalize-space()='Logout']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);

		//Click On LogOut Button
		logoutButton.click();

		//Wait 
		Thread.sleep(2000);
	}

	@AfterClass

	public void tearDown( ) {
		driver.close();	     

	}


}
















