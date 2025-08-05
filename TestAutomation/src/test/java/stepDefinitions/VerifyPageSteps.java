package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import PageObjects.VerifyPageObject;
import TestBase.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyPageSteps
{

	VerifyPageObject VerifyPage;
	@Given("open a page URL")
	public void open_a_page_url() 
	{
		VerifyPage = new VerifyPageObject(Base.getDriver());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VerifyPage.open();
		VerifyPage.search();
		
	}

	@When("verify page title")
	public void verify_page_title() 
	{
		VerifyPage.titleCheck();
	}

	@Then("enter text into serach box")
	public void enter_text_into_serach_box() 
	{
	   
	}

	@And("close the browser")
	public void close_the_browser()
	{
	   
	}

}
