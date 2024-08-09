package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.relevantcodes.extentreports.ExtentReports;


public class Constant {
	public static WebDriver driver;
	//Log initialization
	public static Logger log = Logger.getLogger("Constant");
	
	public static long Min_Sleep = 2000;
	
	public static long Medium_Sleep = 4000;
	
	public static long Max_Sleep = 6000;
    
    public static String NormalDateFormat(){
    	 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		    
		 //get current date time with Date()
		  Date date = new Date();
		    
		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
    }
    
    public static String get_Month(){
		   Date date = new Date();
		   SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
		   return formatter.format(date);          
	}
    
    public static List<String> monthList(){
	    List<String> monthsList = new ArrayList<String>();
	    String[] months = new DateFormatSymbols().getMonths();
	    for (int i = 0; i < months.length; i++) {
	      monthsList .add(months[i]);
	    }
	     return monthsList;
    }
    
    public static String lastDateOfMonth(){
   	 Date today = new Date();  

        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(today);  

        calendar.add(Calendar.MONTH, 1);  
        calendar.set(Calendar.DAY_OF_MONTH, 1);  
        calendar.add(Calendar.DATE, -1);  

        Date lastDayOfMonth = calendar.getTime();  
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String date = sdf.format(lastDayOfMonth).substring(8, 10); 
        return date;
   }
    
    public static void closeBrowser() throws Exception{
		Constant.driver.close();
//		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
		Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
        Constant.driver.quit();
        
	}
    
    public static String DateTimeFormat(){
    	DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
		    
		 //get current date time with Date()
		  Date date = new Date();
		    
		 // Now format the date
		 String date1= dateFormat.format(date);
		 return date1;
   }
    
    public static String PreviousDate(){
    	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    	//get previous day date
		Date date = DateUtils.addDays(new Date(), -1);
		 // Now format the date
		String date1 = dateFormat.format(date);
		return date1;
    }
    
    public static String NextDate(){
    	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    	//get previous day date
		Date date = DateUtils.addDays(new Date(), +1);
		 // Now format the date
		String date1 = dateFormat.format(date);
		return date1;
    }
 
    
    public static String captureScreen_Positive(String ScriptName) throws Exception {
    	ReadPropertyFile property = new ReadPropertyFile();
    	String path;
        try {
        	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	String date = DateTimeFormat();
            path = property.getScreenshotpath()+"Screenshots_Positive\\"+ScriptName+"."+date+"\\" + source.getName();
            FileUtils.copyFile(source, new File(path)); 
            log.info("Screenshot captured for successful execution");
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
    
    public static String captureScreen_Negative(String ScriptName) throws Exception {
    	ReadPropertyFile property = new ReadPropertyFile();
        String path;
        try {
        	File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        	String date = DateTimeFormat();
            path = property.getScreenshotpath()+"Screenshots_Negative\\"+ScriptName+"."+date+"\\" + source.getName();
            FileUtils.copyFile(source, new File(path)); 
            log.info("Screenshot captured for failure");
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
    
	public static File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	public static void BrowserInitialization_download() throws Exception{
    	ReadPropertyFile property = new ReadPropertyFile();
    	//Browser Initialisation
    	System.setProperty("webdriver.gecko.driver",property.getGeckodriverpath());		
    	FirefoxProfile profile = profile();
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(500000, TimeUnit.SECONDS);
    	log.info("Browser Inisialization is successful");
    }
	
	public static void BrowserInitialization_firefox() throws Exception{
		ReadPropertyFile property = new ReadPropertyFile();

    	//Browser Initialisation
    	System.setProperty("webdriver.gecko.driver",property.getGeckodriverpath());	
    	driver = new FirefoxDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(500000, TimeUnit.SECONDS);
    	log.info("Browser Inisialization is successful");
    	
    }
	
	public static void BrowserInitialization_Chrome() throws Exception{
		ReadPropertyFile property = new ReadPropertyFile();
		System.setProperty("webdriver.chrome.driver",property.getChromeDrivePath());
		driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(500000, TimeUnit.SECONDS);
    	Constant.log.info("Browser Inisialization is successful");
	}
    
    public static FirefoxProfile profile() throws Exception{
    	  //Create FireFox Profile object
    	FirefoxProfile profile = new FirefoxProfile();
    	ReadPropertyFile property = new ReadPropertyFile();
    	//Set Location to store files after downloading.
    	profile.setPreference("browser.download.dir", property.getdownloadPath());
    	profile.setPreference("browser.download.folderList", 2);
    	
    	//Set Preference to not show file download confirmation dialogue using MIME types Of different file extension types.
    	profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
    		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"); 
    	profile.setPreference( "browser.download.manager.showWhenStarting", false );
    	profile.setPreference( "pdfjs.disabled", true );
    			
    	return profile;
    }
    
    public static <T> T waitFor(ExpectedCondition<T> condition, String errorMessage) {
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    	                             .withTimeout(20, TimeUnit.SECONDS)
    	                             .ignoring(NullPointerException.class)
    	                             .ignoring(StaleElementReferenceException.class)
    	                             .ignoring(NoSuchElementException.class)
    	                             .ignoring(ElementNotVisibleException.class)
    	                             .ignoring(WebDriverException.class)
    	                             .pollingEvery(100, TimeUnit.MILLISECONDS)
    	                             .withMessage(errorMessage);
    	T result = wait.until(condition);
    	return result;
    	} 
    
    public static void logFile(String logfile) throws Exception{
    	ReadPropertyFile property = new ReadPropertyFile();
    	// This block configure the logger with handler and formatter  
    	String date = DateTimeFormat();
    	FileHandler fh = new FileHandler(property.getLogFilePath()+logfile+date+".log");  
        log.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
        log.info("Log file created");
    }
    
    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
       }  //for letters

	public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
       }  //for numbers
    
	 public static String reverseNumber(String number){
		 int n = Integer.parseInt(number);
	    	int reverse = 0;
	    	while(n > 0 )
	    	 {
	    		int rem = n%10;
	    		reverse = rem+(reverse * 10);
	    	    n = n/10;
	    	 }
	    	number = Integer.toString(reverse);
	    	return number;
	    }
}
