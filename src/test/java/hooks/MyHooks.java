package hooks;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.*;
import utils.ConfigReader;

public class MyHooks {
	WebDriver driver;
	ConfigReader configreader;
	DriverFactory driverfactory;
	@Before
	public void setup() {
    configreader = new ConfigReader();
    driverfactory = new DriverFactory();
	Properties prop= configreader.initializePropeties();
	driver = driverfactory.initializeBrowser(prop.getProperty("browser"));
	driver.get(prop.getProperty("url"));
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
}
