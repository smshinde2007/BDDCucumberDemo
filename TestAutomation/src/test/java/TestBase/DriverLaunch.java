package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverLaunch 
{
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() 
    {
        return driver.get();
    }
    
    public static void launchBrowser() {
    	
    	String browserName= ConfigReader.getProperty("browser");
    	if (browserName == null || browserName.isEmpty())
    	{
    		throw new RuntimeException("browser property is missing or emplty in config.properties file");
    	}
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException("❌ Unsupported browser: " + browserName);
        }

        getDriver().manage().window().maximize();
    }

    public static void quitBrowser() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
   } 
}
