package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	public void teardown(Scenario scenario) {
		String scenarioName = scenario.getName().replace(" " , "_");
		if(scenario.isFailed()) {
			TakesScreenshot screenShot = (TakesScreenshot) driver;
		byte[] ss=	screenShot.getScreenshotAs(OutputType.BYTES);
		scenario.attach(ss, "image/png", scenarioName);
		}
		driver.quit();
	}
}
