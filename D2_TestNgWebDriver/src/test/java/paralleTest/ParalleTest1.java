package paralleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParalleTest1 {
	WebDriver wd;

	@Parameters("browser" )
	@BeforeTest
	public void setup(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver(option);
		}
	}

	@Test
	public void parallelTest() throws InterruptedException {

		wd.get("https://www.google.com/");
		Dimension newsize = new Dimension(600, 950);
		wd.manage().window().setSize(newsize);
		wd.findElement(By.name("q")).sendKeys("chennai");
		wd.findElement(By.name("q")).submit();
		Thread.sleep(2000);
		wd.navigate().back();
		Thread.sleep(2000);
		wd.navigate().forward();
		Thread.sleep(2000);
		wd.navigate().back();
		Thread.sleep(2000);
		wd.navigate().forward();
	}

}
