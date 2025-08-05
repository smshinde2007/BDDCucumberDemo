package stepDefinitions;

import PageObjects.CaptureLinksObject;
import TestBase.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CaptureLinksSteps
{
	CaptureLinksObject capture;
	@Given("open webSite")
	public void open_web_site() {
	   
		capture= new CaptureLinksObject(Base.getDriver());
		capture.open();
	}
	@And("get all links in list")
	public void get_all_links_in_list() {
	  
		capture.links();
	}

}
