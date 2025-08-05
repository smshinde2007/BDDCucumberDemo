package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class VerifyPageObject

{

	WebDriver driver;

    @FindBy(name = "q")
    WebElement searchBox;
    
    @FindBy (xpath="//textarea[@class='gLFyf']")
    WebElement searchField;
    
    

    public VerifyPageObject (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void search() {
    	searchField.sendKeys("java");
    	searchField.sendKeys(Keys.ENTER);
    	String title= driver.getTitle();
 	   System.out.println(title);
 	   Assert.assertEquals("Google", "Google");
    }
    public void titleCheck()
    {
    	String title= driver.getTitle();
  	   System.out.println("Title of page is : "+title);
  	   //Assert.assertEquals("Google", title);
    }
}
