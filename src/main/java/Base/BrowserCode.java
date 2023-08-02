package Base;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import Utility.CommonFiles;
public class BrowserCode extends CommonFiles {
	
//we can do perfect booking
//Maintain_Booking --> Multiple_Booking	
		protected static WebDriver driver;

		public void initilization() throws Exception {
			
//Without Using Headless Browser			
	/*		System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);
			driver = new ChromeDriver(options);
			driver.get(readExcelFileFinal(3, 1));
			driver.manage().window().maximize();    
			
			

//Using Headless Browser 			
			System.setProperty("webdriver.chrome.driver",
		            "C:\\Users\\Admin\\eclipse-workspace\\MainBooking\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--remote-allow-origins=*","ignore-certificate-errors"); 
		    options.addArguments("headless");
		    options.addArguments("window-size=1200x600");                                              //Its Run properly
		    driver = new ChromeDriver(options);
		    driver.get(readExcelFileFinal(3, 1));	*/
		}

		public WebDriver getLocalDriver() {
			SeleniumManager.getInstance();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();

			return driver;
		}

		public WebDriver getRemoteDriver() throws MalformedURLException {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("chrome");
			WebDriver driver = new RemoteWebDriver(new URL("http://seleniumgrid.jbmcloud.com:4567/wd/hub"), dc);

			return driver;
		}
			

			
			
		
}
