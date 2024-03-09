package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.*;

public class MyHooks {
	WebDriver driver;
	@Before
	public void setup() {
	DriverFactory.initializeBrowser("chrome");
	driver = DriverFactory.getDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://tutorialsninja.com/demo/");
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
