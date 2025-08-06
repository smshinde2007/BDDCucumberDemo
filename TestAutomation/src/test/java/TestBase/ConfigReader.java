package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader
{
	 private static final ThreadLocal<Properties> threadLocalProps = new ThreadLocal<Properties>()
	 {
		 protected Properties initialValue()
		 {
		 Properties prop = new Properties();
		 try 
		 {
			 //use this commented code instead of FileInputStream while running in CI/CD jenkis if that fails and instead of fis use input
             //InputStream input= ConfigReader.class.getClassLoader().getResourceAsStream("config/config.properties");   
			 FileInputStream fis= new FileInputStream("src/test/resources/config/config.properties");
             /*if(fis == null){
            	 throw new RuntimeException("Config file not found"); 
             	}
             */
             prop.load(fis);
             fis.close();
             
         }	
		 catch (IOException e) 
		 {
             throw new RuntimeException("❌ Failed to load config.properties: " + e.getMessage());
         }
		  return prop;
		 }
	 };

    public static String getProperty(String key)
    {
        return threadLocalProps.get().getProperty(key);
    }
    
    public static void printAllProperties()
    {
    	threadLocalProps.get().list(System.out);
    }
  }
