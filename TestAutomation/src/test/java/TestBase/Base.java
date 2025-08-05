package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base
{
	//public static WebDriver driver; // removed this for threadLocal
	 private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public static WebDriver getDriver() {
	        return driver.get();
	    }
    @Before
    public void setup() 
    {
    	System.out.println("Hooks is calling now--------------->");
    	WebDriver newDriver = new ChromeDriver();
        newDriver.manage().window().maximize();
        driver.set(newDriver);
        newDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
    	if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
    }
    }

}
