package TestBase;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Base
{
	
    @Before
    public void setup() 
    {
    	System.out.println("*******************************Hooks are calling now for launch browser******************************************");
        DriverLaunch.launchBrowser();
    }

    @After
    public void tearDown() 
    {
    	System.out.println("*******************************Hooks are calling now for quit browser******************************************");
    	DriverLaunch.quitBrowser();
    }
    }


