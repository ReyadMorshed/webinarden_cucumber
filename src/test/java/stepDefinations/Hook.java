package stepDefinations;

import base.Base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
//import utilities.EmailUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hook extends Base {

	public static FileInputStream fis;
	public static Properties configProperties;

	@Before
	public void setUp() throws IOException {
		String projectPath = System.getProperty("user.dir");
		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\Properties\\configuration.properties");
		configProperties = new Properties();
		configProperties.load(fis);

		fis = new FileInputStream(projectPath + "\\src\\test\\resources\\properties\\project.properties");
		configProperties.load(fis);

		if (configProperties.getProperty("browser").contains("chrome")) {
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*");
//
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver(options);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (configProperties.getProperty("browser").contains("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (configProperties.getProperty("browser").contains("edge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		} else if (configProperties.getProperty("browser").contains("safari")) {
			SafariOptions options = new SafariOptions();
			options.asMap().put("--remote-allow-origins", "*");

			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
	}

	@After
	public void tearDownAndSendReport() {
		driver.close();
//        driver.quit();
		//EmailUtils.sendExtentReportToEmail("extent-report.html");
	}

	@AfterStep
	public void endStep(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
	}

}
