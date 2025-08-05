package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CaptureLinksObject
{
	WebDriver driver;
	@FindBy(xpath="//a[@href]")
	WebElement allLink;
	
	

    public CaptureLinksObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void open() {
        driver.get("https://www.google.com");
    }
    
    public void links()
    {
    	List<WebElement> listOfLink= driver.findElements(By.xpath("//a[@href]"));
    	System.out.println(listOfLink.size());
    }
}
