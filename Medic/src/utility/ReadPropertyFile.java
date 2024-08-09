package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
	protected static Properties prop = null;
	
	 public ReadPropertyFile() throws Exception{
		 File file = new File("C:/config.PROPERTIES");
		 FileInputStream objfile = new FileInputStream(file);
		 prop = new Properties();
		 prop.load(objfile);
	
	    }
 
	 public String getUrl_ERP(){
		 return prop.getProperty("URL_ERP");
		  
	 }
	 
	 public String getUrl_Medic(){
		 return prop.getProperty("URL_Medic");
		  
	 }
	 
	 public  String getTestDataPath_ERP(){
		 return prop.getProperty("Path_TestData_ERP");
	 }
	 
	 public  String getTestDataPath_Medic(){
		 return prop.getProperty("Path_TestData_Medic");
	 }
	 
	 public String getScreenshotpath(){
		 return prop.getProperty("ScreenshotPath");
	 }
	 
	 public String getGeckodriverpath(){
		 return prop.getProperty("GeckoDriverPath");
	 }
	 
	 public String getTestResultpath(){
		 return prop.getProperty("Path_TestResult");
	 }
	 
	 public String getLogFilePath(){
		 return prop.getProperty("Path_LogFile");
	 }
	 
	 public String getdownloadPath(){
		 return prop.getProperty("DownloadPath");
	 }
	 
	 public String getChromeDrivePath(){
		 return prop.getProperty("ChromeDriverPath");
	 }
	 
	 public String getExtentReportFile(){
		 return prop.getProperty("ExtentReportFile");
	 }
	 
	 public String getExtentReportImg(){
		 return prop.getProperty("ExtentReportImage");
	 }
	 
	 public String getJunitReport(){
		 return prop.getProperty("JunitReport");
	 }
}
