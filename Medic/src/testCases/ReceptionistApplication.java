package testCases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.ReceptionistPage;
import utility.Constant;
import utility.JUnitHTMLReporter;
import utility.Log;
import utility.ReadPropertyFile;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReceptionistApplication extends JUnitHTMLReporter {
	
	static ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	Log log = PageFactory.initElements(Constant.driver, Log.class);
	ReceptionistPage receptionist = PageFactory.initElements(Constant.driver, ReceptionistPage.class);
	static String extentReportFile;
	static ExtentReports extent;
	static String extentReportImage;
	static ExtentTest extentTest;
	static String date = Constant.DateTimeFormat();
	 //define an Excel Work Book
	  static HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  static HSSFSheet sheet;
	  static //define a test result data object
	Map<String, Object[]> testresultdata;
	
	@BeforeClass
	public static void BeforeClass() throws Exception{
		extentReportFile = property.getExtentReportFile()+"Receptionist"+date+"."+"html";
		extentReportImage = property.getExtentReportImg()+"Receptionist Image"+date+"."+"png";
		// Create object of extent report and specify the report file path.
		extent = new ExtentReports(extentReportFile, false);
		Constant.logFile("Receptionist");
		 //Browser Initialization
		 Constant.BrowserInitialization_firefox();
		//create a new work book
			workbook = new HSSFWorkbook();
			//create a new work sheet
			sheet = workbook.createSheet("Receptionist");
			testresultdata = new LinkedHashMap<String, Object[]>();
			//add test result excel file column header
			// write the header in the first row
			testresultdata.put("1", new Object[] {"S.No", "Scenario", "Expected Result","Pass/Fail"});
			
	}
	 
	@Before
	public void Before() throws Exception{
		DOMConfigurator.configure("log4j.xml");
		
	}
	
	@Test
	public void test001_Login() throws Exception{
		Log.startTestCase("Login");
		// Start the test using the ExtentTest class object.
		extentTest = extent.startTest("Login",
				"Verify medic login page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			boolean flag = receptionist.login("Receptionist",0);
			if(flag == true){
				Constant.log.info("test001_Login: Login to Medic test case is successful");
				extentTest.log(LogStatus.PASS, "Login Successful");
				testresultdata.put("2", new Object[] {1d, "navigate to site and login", "site opens and login success","Pass"});
			}else{
				System.err.println("test001_Login: Login to Medic test case failed ");
				Constant.captureScreen_Negative("Login");
				extentTest.log(LogStatus.FAIL, "Login failed");
				testresultdata.put("2", new Object[] {1d, "navigate to site and login", "Login failed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Login");
	}
	
	@Test
	public void test002_RegPatient() throws Exception{
		Log.startTestCase("Add a token for reg. patient");
		extentTest = extent.startTest("Registered Patient", 
				"Verify token is alloted for registered patient");

		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			receptionist.login("Receptionist",1);
			boolean flag = receptionist.Add_AvailablePatient(1);
			if(flag == true){
				Constant.log.info("test002_RegPatient: Booking token for Registered patient is successful");
				extentTest.log(LogStatus.PASS, "Booking token for Registered patient is successful");
				testresultdata.put("3", new Object[] {2d, "Add a token for registered patient", "Added a token for registered patient","Pass"});
			}else{
				System.err.println("test002_RegPatient: Booking token for Registered patient test case failed ");
				Constant.captureScreen_Negative("Registered Patient");
				testresultdata.put("3", new Object[] {2d, "Add a token for registered patient", "Failed to add token for reg. patient","Fail"});
				extentTest.log(LogStatus.FAIL, "Booking token for Registered patient test case failed");
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Add a token for reg. patient");
	}
	
	@Test
	public void test003_NewPatient_withoutRegNumber() throws Exception{
		Log.startTestCase("Add a token for new patient without registered number");
		extentTest = extent.startTest("Patient without Registered number", 
				"Add a token for new patient without registered number");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		try{
			receptionist.login("Receptionist",2);
			boolean flag = receptionist.AddNewPatient(2);
			if(flag == true){
				Constant.log.info("test003_NewPatient_withoutRegNumber: Create token for new patient without reg number test case is successful");
				extentTest.log(LogStatus.PASS, "Create token for new patient without reg number test case is successful");
				testresultdata.put("4", new Object[] {3d, "Add a Token for New patient", "Added Token for New patient","Pass"});
			}else{
				System.err.println("test003_NewPatient_withoutRegNumber: Create token for new patient without reg number test case failed ");
				Constant.captureScreen_Negative("NewPatient_withoutRegNumber");
				extentTest.log(LogStatus.FAIL, "Create token for new patient without reg number test case failed");
				testresultdata.put("4", new Object[] {3d, "Add a Token for New patient", "Failed to add token for new patient","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Add a token for new patient without registered number");
	}
	
  @Test
	public void test004_NewPatient_RegNo() throws Exception{
		Log.startTestCase("Add a token for new patient with Reg. Number");
		extentTest = extent.startTest("New patient for Registered number", 
				"Add a token for new patient without registered number");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",3);
		try{
			boolean flag = receptionist.AddPatient_RegNo(3);
			if(flag == true){
				Constant.log.info("test004_NewPatient_RegNo: Create token for new patient with Reg. number test case is successful");
				extentTest.log(LogStatus.PASS, "Create token for new patient with Reg. number test case is successful");
				testresultdata.put("5", new Object[] {4d, "Add a patient for the registered mobile number", "Added Token for new patient for already registered number","Pass"});
			}else{
				System.err.println("test004_NewPatient_RegNo: Create token for new patient with Reg. number test case failed ");
				Constant.captureScreen_Negative("New Patient_RegNO");
				extentTest.log(LogStatus.FAIL, "Create token for new patient with Reg. number test case failed");
				testresultdata.put("5", new Object[] {4d, "Add a patient for the registered mobile number", "Failed to add Token for new patient for already registered number","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Add a token for New patient with reg. Number");
	}
	
	@Test
	public void test005_BookAppointment() throws Exception{
		Log.startTestCase("Book appointment");
		extentTest = extent.startTest("Book appointment", 
				"verify whether appointment booked for new patient");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",4);
		try{
			boolean flag = receptionist.BookAppointment(4);
			if(flag == true){
				Constant.log.info("test005_BookAppointment: Book appointment test case is successful");
				extentTest.log(LogStatus.PASS, "Book appointment test case is successful");
				testresultdata.put("6", new Object[] {5d, "Book appointment", "New appointment added","Pass"});
			}else{
				System.err.println("test005_BookAppointment: Book appointment test case failed ");
				Constant.captureScreen_Negative("Book appointment");
				extentTest.log(LogStatus.FAIL, "Book appointment test case failed");
				testresultdata.put("6", new Object[] {5d, "Book appointment", "Faied to add new appointment","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Book appointment");
	}
	
	@Test
	public void test006_MandatoryFields() throws Exception{
		Log.startTestCase("Mandatory fields");
		extentTest = extent.startTest("Mandatory fields", 
				"verify mandatory field in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",5);
		try{
			boolean flag = receptionist.MandatoryFields(5);
			if(flag == true){
				Constant.log.info("test006_MandatoryFields: Mandatory field check test case is successful");
				extentTest.log(LogStatus.PASS, "Mandatory field check test case is successful");
				testresultdata.put("7", new Object[] {6d, "Mandatory field checks in Token allot pop up", "Mandatory field warning messages displayed","Pass"});
			}else{
				System.err.println("test006_MandatoryFields: Mandatory field check test case failed ");
				Constant.captureScreen_Negative("Mandatory fields");
				extentTest.log(LogStatus.FAIL, "Mandatory field check test case failed ");
				testresultdata.put("7", new Object[] {6d, "Mandatory field checks in Token allot pop up", "Failed to display mandatory field warning messages","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Mandatory fields");
	}
	
	@Test
	public void test007_SearchPatient() throws Exception{
		Log.startTestCase("Search Patient");
		extentTest = extent.startTest("Search Patient", 
				"verify search patient button in Add Patient pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",6);
		try{
			boolean flag1 = receptionist.SearchPatient_withoutFilter(6);
			boolean flag2 = receptionist.SearchPatient_WithFilter(6);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test007_SearchPatient: Search Patient button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Search Patient button validation test case is successful");
				testresultdata.put("8", new Object[] {7d, "Search pop up from Add Patient", "Search result displayed","Pass"});
			}else{
				System.err.println("test007_SearchPatient: Search Patient button validation test case failed ");
				Constant.captureScreen_Negative("Search Patient");
				extentTest.log(LogStatus.FAIL, "Search Patient button validation test case failed ");
				testresultdata.put("8", new Object[] {7d, "Search pop up from Add Patient", "Search result is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Search Patient");
	}
	
	@Test
	public void test008_CancelBtn_AddPatient() throws Exception{
		Log.startTestCase("CancelBtn_AddPatient");
		extentTest = extent.startTest("Cancel button of Add Patient", 
				"verify cancel button in add patient pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",7);
		try{
			boolean flag = receptionist.CancelBtn_Add();
			if(flag == true){
				Constant.log.info("test008_CancelBtn_AddPatient: Cancel button in Add Patient pop up validation test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel button in Add Patient pop up validation test case is successful");
				testresultdata.put("9", new Object[] {8d, "Check Cancel button in Add A Patient pop up", "Cancel button closes the pop up","Pass"});
			}else{
				System.err.println("test008_CancelBtn_AddPatient: Cancel button in Add Patient pop up validation test case failed ");
				Constant.captureScreen_Negative("CancelBtn_AddPatient");
				extentTest.log(LogStatus.FAIL, "Cancel button in Add Patient pop up validation test case failed  ");
				testresultdata.put("9", new Object[] {8d, "Check Cancel button in Add A Patient pop up", "Cancel button does not close the pop up","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Search Patient");
	}
	
	@Test
	public void test009_RescheduleAppointment() throws Exception{
		Log.startTestCase("Reschedule Appointment");
		extentTest = extent.startTest("Reschedule Appointment", 
				"verify reschdule appoinment in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",8);
		try{
			boolean flag = receptionist.RescheduleAppointment(8);
			if(flag == true){
				Constant.log.info("test009_RescheduleAppointment: Reschedule Appointment button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Reschedule Appointment button validation test case is successful");
				testresultdata.put("10", new Object[] {9d, "Reschedule appointment", "Able to reschedule the appointment","Pass"});
			}else{
				System.err.println("test009_RescheduleAppointment: Reschedule Appointment button validation test case failed ");
				Constant.captureScreen_Negative("Reschedule Appointment");
				extentTest.log(LogStatus.FAIL, "Reschedule Appointment button validation test case failed ");
				testresultdata.put("10", new Object[] {9d, "Reschedule appointment", "Unable to reschedule the appointment","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule Appointment");
	}
	
	@Test
	public void test010_RescheduleToken() throws Exception{
		Log.startTestCase("Reschedule Token");
		extentTest = extent.startTest("Reschedule Token", 
				"verify reschdule Token in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",9);
		try{
			boolean flag = receptionist.RescheduleToken(9);
			if(flag == true){
				Constant.log.info("test010_RescheduleToken: Reschedule Token button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Reschedule Token button validation test case is successful");
				testresultdata.put("11", new Object[] {10d, "Reschedule Token", "Able to reschedule token","Pass"});
			}else{
				System.err.println("test010_RescheduleToken: Reschedule Token button validation test case failed ");
				Constant.captureScreen_Negative("Reschedule Token");
				extentTest.log(LogStatus.FAIL, "Reschedule Token button validation test case failed ");
				testresultdata.put("11", new Object[] {10d, "Reschedule Token", "Unable to reschedule token","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule Token");
	}
	
	@Test
	public void test011_CancelAppointment() throws Exception{
		Log.startTestCase("Cancel Appointment");
		extentTest = extent.startTest("Cancel Appointment", 
				"Verify appointment can be cancelled");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",10);
		try{
			boolean flag = receptionist.CancelAppointment(10);
			if(flag == true){
				Constant.log.info("Cancelled Appointment test case is successful");
				extentTest.log(LogStatus.PASS, "Cancelled Appointment test case is successful");
				testresultdata.put("12", new Object[] {11d, "Cancel Appointment", "Able to Cancel appointment","Pass"});
			}else{
				System.err.println("Cancelled Appointment test case failed ");
				Constant.captureScreen_Negative("Cancelled Appointment");
				extentTest.log(LogStatus.FAIL, "Cancelled Appointment test case failed ");
				testresultdata.put("12", new Object[] {11d, "Cancel Appointment", "Unable to Cancel appointment","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel Appointment");
	}
	
	@Test
	public void test012_CancelToken() throws Exception{
		Log.startTestCase("Cancel Token");
		extentTest = extent.startTest("Cancel Token", 
				"Verify token can be cancelled");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",11);
		try{
			boolean flag = receptionist.CancelToken(11);
			if(flag == true){
				Constant.log.info("Cancel Token test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel Token test case is successful");
				testresultdata.put("13", new Object[] {12d, "Cancel Token", "Able to Cancel Token","Pass"});
			}else{
				System.err.println("Cancel Token test case failed ");
				Constant.captureScreen_Negative("Cancel Token");
				extentTest.log(LogStatus.FAIL, "Cancel Token test case failed ");
				testresultdata.put("13", new Object[] {12d, "Cancel Token", "Unable to Cancel Token","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel Token");
	}
	
	@Test
	public void test013_PrintToken() throws Exception{
		Log.startTestCase("Print Token");
		extentTest = extent.startTest("Print Token", 
				"verify Print Token in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",12);
		try{
			boolean flag1 = receptionist.PrintToken_PopUp(12);
			boolean flag2 = receptionist.PrintToken_Lnk(12);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test013_PrintToken: Print Token link validation test case is successful");
				extentTest.log(LogStatus.PASS, "Print Token link validation test case is successful");
				testresultdata.put("14", new Object[] {13d, "Print Token", "Able to Print Token","Pass"});
			}else{
				System.err.println("test013_PrintToken: Print Token link validation test case failed ");
				Constant.captureScreen_Negative("Print Token");
				extentTest.log(LogStatus.FAIL, "Print Token link validation test case failed ");
				testresultdata.put("14", new Object[] {13d, "Print Token", "Unable to Print Token","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Print Token");
	}
	
	@Test
	public void test014_PrintBill() throws Exception{
		Log.startTestCase("Print Bill");
		extentTest = extent.startTest("Print Bill", 
				"verify Print Bill in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",13);
		try{
			boolean flag = receptionist.printBill(13);
			if(flag == true){
				Constant.log.info("test014_PrintBill: Print Bill link validation test case is successful");
				extentTest.log(LogStatus.PASS, "Print Bill link validation test case is successful");
				testresultdata.put("15", new Object[] {14d, "Print Bill", "Able to Print Bill","Pass"});
			}else{
				System.err.println("test014_PrintBill: Print Bill link validation test case failed ");
				Constant.captureScreen_Negative("Print Bill");
				extentTest.log(LogStatus.FAIL, "Print Bill link validation test case failed ");
				testresultdata.put("15", new Object[] {14d, "Print Bill", "Unable to Print Bill","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Print Bill");
	}
	
	@Test
	public void test015_IDCardPrint() throws Exception{
		Log.startTestCase("ID Card Print");
		extentTest = extent.startTest("ID Card Print", 
				"verify ID Card Print in allot token page");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",14);
		try{
			boolean flag = receptionist.IDCardPrint(14);
			if(flag == true){
				Constant.log.info("test015_IDCardPrint: ID Card Print link validation test case is successful");
				extentTest.log(LogStatus.PASS, "ID Card Print link validation test case is successful");
				testresultdata.put("16", new Object[] {15d, "ID Card Print", "Able to Print ID Card","Pass"});
			}else{
				System.err.println("test015_IDCardPrint: ID Card Print link validation test case failed ");
				Constant.captureScreen_Negative("ID Card Print");
				extentTest.log(LogStatus.FAIL, "ID Card Print link validation test case failed ");
				testresultdata.put("16", new Object[] {15d, "ID Card Print", "Unable to Print ID Card Print","Pass"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("ID Card Print");
	}
	
	@Test
	public void test016_Refund() throws Exception{
		Log.startTestCase("Refund");
		extentTest = extent.startTest("Refund", 
				"Verify whether refund is working");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",14);
		try{
			boolean flag = receptionist.Refund(14);
			if(flag == true){
				Constant.log.info("Refund test case is successful");
				extentTest.log(LogStatus.PASS, "Refund test case is successful");
				testresultdata.put("17", new Object[] {16d, "Refund", "Able to Refund amount","Pass"});
			}else{
				System.err.println("Refund test case failed ");
				Constant.captureScreen_Negative("Refund");
				extentTest.log(LogStatus.FAIL, "Refund test case failed ");
				testresultdata.put("17", new Object[] {16d, "Refund", "Unable to Refund amount","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Refund");
	}
	
	@Test
	public void test017_SearchToken() throws Exception{
		Log.startTestCase("Search Token");
		extentTest = extent.startTest("Search Token", 
				"verify Search Token field");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",16);
		try{
			boolean flag = receptionist.SearchToken(16);
			if(flag == true){
				Constant.log.info("test017_SearchToken: Search Token field validation test case is successful");
				extentTest.log(LogStatus.PASS, "Search Token field validation test case is successful");
				testresultdata.put("18", new Object[] {17d, "Search token no. and medic id", "Search result displayed for token no. and medic id","Pass"});
			}else{
				System.err.println("test017_SearchToken: Search Token field validation test case failed ");
				Constant.captureScreen_Negative("Search Token");
				extentTest.log(LogStatus.FAIL, "Search Token field validation test case failed ");
				testresultdata.put("18", new Object[] {17d, "Search token no. and medic id", "Search result not displayed for token no. and medic id","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Search Token");
	}
	
	@Test
	public void test018_ShowAvailableDocs() throws Exception{
		Log.startTestCase("Show Available Doctors");
		extentTest = extent.startTest("Show Available Doctors", 
				"verify Show available Doctors icon");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",17);
		try{
			boolean flag = receptionist.ShowAvalDoc();
			if(flag == true){
				Constant.log.info("test018_ShowAvailableDocs: Show Available Doctors link validation test case is successful");
				extentTest.log(LogStatus.PASS, "Show Available Doctors link validation test case is successful");
				testresultdata.put("19", new Object[] {18d, "Show Available Doctors", "Available doctors are displayed","Pass"});
			}else{
				System.err.println("test018_ShowAvailableDocs: Show Available Doctors link validation test case failed ");
				Constant.captureScreen_Negative("Show Available Doctors");
				extentTest.log(LogStatus.FAIL, "Show Available Doctors link validation test case failed ");
				testresultdata.put("19", new Object[] {18d, "Show Available Doctors", "Available doctors are not displayed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Show Available Doctors");
	}
	
	@Test
	public void test019_SelectDocs_Apply() throws Exception{
		Log.startTestCase("Select Doctor-Apply button");
		extentTest = extent.startTest("Select Doctor_apply button", 
				"verify apply button in Select doctor pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",18);
		try{
			boolean flag = receptionist.SelectDoc_ApplyBtn(18);
			if(flag == true){
				Constant.log.info("test019_SelectDocs_Apply: Select Doctor-Apply button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Select Doctor-Apply button validation test case is successful");
				testresultdata.put("20", new Object[] {19d, "Apply button in Select Dept and Doctors", "On clicking apply button selected doctors are displayed","Pass"});
			}else{
				System.err.println("test019_SelectDocs_Apply: Select Doctor-Apply button validation test case failed ");
				Constant.captureScreen_Negative("Select Doctor-Apply button");
				extentTest.log(LogStatus.FAIL, "Select Doctor-Apply button validation test case failed ");
				testresultdata.put("20", new Object[] {19d, "Apply button in Select Dept and Doctors", "On clicking apply button selected doctors are not displayed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Select Doctor-Apply button");
	}
	
	@Test
	public void test020_SelectDocs_Cancel() throws Exception{
		Log.startTestCase("Select Doctor-Cancel button");
		extentTest = extent.startTest("Select Doctor_cancel button", 
				"verify cancel button in Select doctor pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		 receptionist.login("Receptionist",19);
		try{
			boolean flag = receptionist.SelectDoc_CancelBtn(19);
			if(flag == true){
				Constant.log.info("test020_SelectDocs_Cancel: Select Doctor-Cancel button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Select Doctor-Cancel button validation test case is successful");
				testresultdata.put("21", new Object[] {20d, "Cancel button in Select Dept and Doctors", "On clicking cancel button does not display selected doctors","Pass"});
			}else{
				System.err.println("test020_SelectDocs_Cancel: Select Doctor-Cancel button validation test case failed ");
				Constant.captureScreen_Negative("Select Doctor-Cancel button");
				extentTest.log(LogStatus.FAIL, "Select Doctor-Cancel button validation test case failed ");
				testresultdata.put("21", new Object[] {20d, "Cancel button in Select Dept and Doctors", "On clicking cancel button displays selected doctors","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Select Doctor-Cancel button");
	}
	
	@Test
	public void test021_SelectDocs_Clear_Yes() throws Exception{
		Log.startTestCase("Select Doctor-Clear_Yes button");
		extentTest = extent.startTest("Select Doctor_Clear_Yes button", 
				"verify Clear_Yes button in Select doctor pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",20);
		try{
			boolean flag = receptionist.SelectDoc_ClearYesBtn(20);
			if(flag == true){
				Constant.log.info("test021_SelectDocs_Clear_Yes: Select Doctor-Clear_Yes button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Select Doctor-Clear_Yes button validation test case is successful");
				testresultdata.put("22", new Object[] {21d, "Select Doctor-Clear_Yes button", "On clicking yes button in clear pop up, unselected doctors","Pass"});
			}else{
				System.err.println("test021_SelectDocs_Clear_Yes: Select Doctor-Clear_Yes button validation test case failed ");
				Constant.captureScreen_Negative("Select Doctor-Clear_Yes button");
				extentTest.log(LogStatus.FAIL, "Select Doctor-Clear_Yes button validation test case failed ");
				testresultdata.put("22", new Object[] {21d, "clear button in Select Dept and Doctors", "On clicking yes button in clear pop up does not unselect doctors","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Select Doctor-Clear_Yes button");
	}
	
	@Test
	public void test022_SelectDocs_Clear_Cancel() throws Exception{
		Log.startTestCase("Select Doctor-Clear_Cancel button");
		extentTest = extent.startTest("Select Doctor_Clear_Cancel button", 
				"verify Clear_Cancel button in Select doctor pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",21);
		try{
			boolean flag = receptionist.SelectDoc_ClearCancelBtn(21);
			if(flag == true){
				Constant.log.info("test022_SelectDocs_Clear_Cancel: Select Doctor-Clear_Cancel button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Select Doctor-Clear_Cancel button validation test case is successful");
				testresultdata.put("23", new Object[] {22d, "Select Doctor-Clear_Cancel button", "On clicking cancel button in clear pop up does not unselect doctors","Pass"});
			}else{
				System.err.println("test022_SelectDocs_Clear_Cancel: Select Doctor-Clear_Cancel button validation test case failed ");
				Constant.captureScreen_Negative("Select Doctor-Clear_Cancel button");
				extentTest.log(LogStatus.FAIL, "Select Doctor-Clear_Cancel button validation test case failed ");
				testresultdata.put("23", new Object[] {22d, "Select Doctor-Clear_Cancel button", "On clicking cancel button in clear pop up doctors are unselected","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Select Doctor-Clear_Cancel button");
	}
	
	@Test
	public void test023_TodayPatientStatus() throws Exception{
		Log.startTestCase("Today Patient Status");
		extentTest = extent.startTest("Today Patient Status", 
				"verify view Today Patient Status link");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",22);
		try{
			boolean flag = receptionist.PatientStatus(22);
			if(flag == true){
				Constant.log.info("test023_TodayPatientStatus: Today Patient Status validation test case is successful");
				extentTest.log(LogStatus.PASS, "Today Patient Status validation test case is successful");
				testresultdata.put("24", new Object[] {23d, "View Today Patient status", "Search results get displayed","Pass"});
			}else{
				System.err.println("test023_TodayPatientStatus: Today Patient Status validation test case failed ");
				Constant.captureScreen_Negative("Today Patient Status");
				extentTest.log(LogStatus.FAIL, "Today Patient Status validation test case failed ");
				testresultdata.put("24", new Object[] {23d, "View Today Patient status", "Search results does not display","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Today Patient Status");
	}
	
	@Test
	public void test024_RescheduleCancelledAppt() throws Exception{
		Log.startTestCase("Reschedule Cancelled Appointment");
		extentTest = extent.startTest("Reschedule Cancelled Appointment", 
				"Verify whether cancelled appointment can be rescheduled");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",23);
		try{
			boolean flag = receptionist.RescheduleCancelledAppt(23);
			if(flag == true){
				Constant.log.info("Reschedule Cancelled Appointment test case is successful");
				extentTest.log(LogStatus.PASS, "Reschedule Cancelled Appointment test case is successful");
				testresultdata.put("25", new Object[] {24d, "Reschedule from Cancelled appointments", "Appointment is rescheduled","Pass"});
			}else{
				System.err.println("Reschedule Cancelled Appointment test case failed ");
				Constant.captureScreen_Negative("Reschedule Cancelled Appointment");
				extentTest.log(LogStatus.FAIL, "Reschedule Cancelled Appointment test case failed ");
				testresultdata.put("25", new Object[] {24d, "Reschedule from Cancelled appointments", "Appointment is not rescheduled","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule Cancelled Appointment");
	}
	
	@Test
	public void test025_Cancel_Reschdule() throws Exception{
		Log.startTestCase("Cancel Reschedule");
		extentTest = extent.startTest("Cancel Reschedule", 
				"verify Cancel button in Reschdule pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",24);
		try{
			boolean flag = receptionist.Cancel_Reschedule(24);
			if(flag == true){
				Constant.log.info("test025_Cancel_Reschdule: Cancel button in Reschedule pop up validation test case is successful");
				extentTest.log(LogStatus.PASS, " Cancel button in Reschedule pop up validation test case is successful");
				testresultdata.put("26", new Object[] {25d, "Cancel from the Reschedule pop up", "On click closes Reschedule pop up","Pass"});
			}else{
				System.err.println("test025_Cancel_Reschdule:  Cancel button in Reschedule pop up validation test case failed ");
				Constant.captureScreen_Negative("Cancel Reschedule");
				extentTest.log(LogStatus.FAIL, " Cancel button in Reschedule pop up validation test case failed ");
				testresultdata.put("26", new Object[] {25d, "Cancel from the Reschedule pop up", "On click does not close Reschedule pop up","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel Reschedule");
	}
	
	@Test
	public void test026_Calendar() throws Exception{
		Log.startTestCase("Calendar");
		extentTest = extent.startTest("Calendar", 
				"verify Calendar pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",25);
		try{
			boolean flag1 = receptionist.Calendar_NextDate();
			boolean flag2 = receptionist.Calendar_Nextmonth();
			boolean flag3 = receptionist.Calendar_PreviousMonth();
			boolean flag4 = receptionist.Calendar_Today();
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("test026_Calendar: Calendar pop up verification test case is successful");
				extentTest.log(LogStatus.PASS, "Calendar pop up verification test case is successful");
				testresultdata.put("27", new Object[] {26d, "Calendar", "Validated calendar pop up","Pass"});
			}else{
				System.err.println("test026_Calendar: Calendar pop up verification test case failed ");
				Constant.captureScreen_Negative("Calendar");
				extentTest.log(LogStatus.FAIL, "Calendar pop up verification test case failed ");
				testresultdata.put("27", new Object[] {26d, "Calendar", "Calendar pop up validation failed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Calendar");
	}
	
	@Test
	public void test027_CancelledAppointmentLnk() throws Exception{
		Log.startTestCase("Cancelled Appointment Link");
		extentTest = extent.startTest("Cancelled Appointment link", 
				"Verify cancel appointment link");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",26);
		try{
			boolean flag1 = receptionist.RescheduleBtn(26);
			boolean flag2 = receptionist.Calendar_NextDate();
			boolean flag3 = receptionist.Calendar_Nextmonth();
			boolean flag4 = receptionist.Calendar_PreviousMonth();
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("Cancelled Appointment Link test case is successful");
				extentTest.log(LogStatus.PASS, "Cancelled Appointment link test case is successful");
				testresultdata.put("28", new Object[] {27d, "Cancelled appointments link", "Validated Cancelled appointments link pop up","Pass"});
			}else{
				System.err.println("Cancelled Appointment Link test case failed ");
				Constant.captureScreen_Negative("Cancelled Appointment Link");
				extentTest.log(LogStatus.FAIL, "Cancelled Appointment link test case failed ");
				testresultdata.put("28", new Object[] {27d, "Cancelled appointments link", "Cancelled appointments link pop up validation failed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancelled Appointment Link");
	}
	
	@Test
	public void test028_ChangeSchedule() throws Exception{           
		Log.startTestCase("Change Schedule");
		extentTest = extent.startTest("Change Schedule", 
				"verification of Change schedule of doctor");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",27);
		try{
			boolean flag1 = receptionist.ChangeSchedule(27);
			if(flag1 == true){
				Constant.log.info("test028_ChangeSchedule: verification of Change schedule of doctor test case is successful");
				extentTest.log(LogStatus.PASS, "verification of Change schedule of doctor test case is successful");
				testresultdata.put("29", new Object[] {28d, "Change Schedule", "Able to change schedule and book appointment ","Pass"});
			}else{
				System.err.println("test028_ChangeSchedule: verification of Change schedule of doctor test case failed ");
				Constant.captureScreen_Negative("Change Schedule");
				extentTest.log(LogStatus.FAIL, "verification of Change schedule of doctor test case failed ");
				testresultdata.put("29", new Object[] {28d, "Change Schedule", "Unable to change schedule and book appointment ","fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Change Schedule");
	}
	
	@Test
	public void test029_Logout() throws Exception{
		Log.startTestCase("Logout");
		extentTest = extent.startTest("Logout", 
				"verification of Logout");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",28);
		try{
			boolean flag1 = receptionist.logout();
			if(flag1 == true){
				Constant.log.info("test029_Logout: Logout test case is successful");
				extentTest.log(LogStatus.PASS, "verification of logout test case is successful");
				testresultdata.put("30", new Object[] {29d, "Logout", "Login page is displayed ","Pass"});
			}else{
				System.err.println("test029_Logout: Logout test case failed ");
				Constant.captureScreen_Negative("Logout");
				extentTest.log(LogStatus.FAIL, "verification of logout test case failed ");
				testresultdata.put("30", new Object[] {29d, "Logout", "Login page is not displayed ","Fail"});
			}
			Assert.assertTrue(flag1 == true);
			receptionist.login("Receptionist",28);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Logout");
	}
	
	@Test
	public void test030_ReportSearch() throws Exception{
		Log.startTestCase("Report search");
		extentTest = extent.startTest("Report search", 
				"verification of Report Search button");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",29);
		try{
			boolean flag1 = receptionist.reports_search(29);
			if(flag1 == true){
				Constant.log.info("test030_ReportSearch: Report search button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Report search button validation test case is successful");
				testresultdata.put("31", new Object[] {30d, "Report search", "Search results are displayed ","Pass"});
			}else{
				System.err.println("test030_ReportSearch: Report search button validation test case failed ");
				Constant.captureScreen_Negative("Report search");
				extentTest.log(LogStatus.FAIL, "Report search button validation test case failed ");
				testresultdata.put("31", new Object[] {30d, "Report search", "Search results are not displayed ","fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Report search");
	}
	
	@Test
	public void test031_ReportClose() throws Exception{
		Log.startTestCase("Report Close");
		extentTest = extent.startTest("Report Close", 
				"verification of Report Close button");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",30);
		try{
			boolean flag1 = receptionist.Report_Cancel(30);
			if(flag1 == true){
				Constant.log.info("test031_ReportClose: Report Close button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Report Close button validation test case is successful");
				testresultdata.put("32", new Object[] {31d, "Report close", "Able to close report pop up ","Pass"});
			}else{
				System.err.println("test031_ReportClose: Report Close button validation test case failed ");
				Constant.captureScreen_Negative("Report Close");
				extentTest.log(LogStatus.FAIL, "Report Close button validation test case failed ");
				testresultdata.put("32", new Object[] {31d, "Report close", "Unable to close report pop up ","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Report Close");
	}
	
	@Test
	public void test032_ReportReset() throws Exception{
		Log.startTestCase("Report Reset");
		extentTest = extent.startTest("Report Reset", 
				"verification of Report Reset button");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",31);
		try{
			boolean flag1 = receptionist.Report_Reset(31);
			if(flag1 == true){
				Constant.log.info("test032_ReportReset: Report Reset button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Report Reset button validation test case is successful");
				testresultdata.put("33", new Object[] {32d, "Report Reset", "Able to reset all the field values ","Pass"});
			}else{
				System.err.println("test032_ReportReset: Report Reset test case failed ");
				Constant.captureScreen_Negative("Report Reset");
				extentTest.log(LogStatus.FAIL, "Report Reset button validation test case failed ");
				testresultdata.put("33", new Object[] {32d, "Report Reset", "Unable to reset all the field values ","fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Report Reset");
	}
	
	@Test
	public void test033_ReportExport() throws Exception{
		Log.startTestCase("Report Export");
		extentTest = extent.startTest("Report Export", 
				"verification of Report Export button");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",32);
		try{
			boolean flag1 = receptionist.Report_Export(32);
			if(flag1 == true){
				Constant.log.info("test033_ReportExport: Report Export button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Report Export button validation test case is successful");
				testresultdata.put("34", new Object[] {33d, "Report Export", "Able to export search results ","Pass"});
			}else{
				System.err.println("test033_ReportExport: Report Export button validation test case failed ");
				Constant.captureScreen_Negative("Report Export");
				extentTest.log(LogStatus.FAIL, "Report Export button validation test case failed ");
				testresultdata.put("34", new Object[] {33d, "Report Export", "Unable to export search results ","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Report Export");
	}
	
	@Test
	public void test034_ReportPrint() throws Exception{
		Log.startTestCase("Report Print ");
		extentTest = extent.startTest("Report Print", 
				"verify print in Report is working");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",33);
		try{
			boolean flag1 = receptionist.ReportPrint(33);
			if(flag1 == true){
				Constant.log.info("Report Print test case is successful");
				extentTest.log(LogStatus.PASS, "Report Print test case is successful");
				testresultdata.put("35", new Object[] {34d, "Report Print", "Able to print search results ","Pass"});
			}else{
				System.err.println("Report Print  test case failed ");
				Constant.captureScreen_Negative("Report Print ");
				extentTest.log(LogStatus.FAIL, "Report Print test case failed ");
				testresultdata.put("35", new Object[] {34d, "Report Print", "Unable to print search results ","Fail"});
			}
   		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Report Print ");
	}
	
	@Test
	public void test035_AdvancedSearch() throws Exception{
		Log.startTestCase("Advanced Search");
		extentTest = extent.startTest("Advanced Search", 
				"verification of Advanced Search");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",34);
		try{
			boolean flag1 = receptionist.AdvancedSearch_WithoutFilter(34);
			boolean flag2 = receptionist.AdvancedSearch_WithFilter(34);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test035_AdvancedSearch: Advanced Search validation test case is successful");
				extentTest.log(LogStatus.PASS, "Advanced Search validation test case is successful");
				testresultdata.put("36", new Object[] {35d, "Advanced Search", "Search results are displayed ","Pass"});
			}else{
				System.err.println("test035_AdvancedSearch: Advanced Search validation test case failed ");
				Constant.captureScreen_Negative("Advanced Search");
				extentTest.log(LogStatus.FAIL, "Advanced Search validation test case failed ");
				testresultdata.put("36", new Object[] {35d, "Advanced Search", "Search results are not displayed ","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Advanced Search");
	}
	
	@Test
	public void test036_ViewMore() throws Exception{
		Log.startTestCase("View More button");
		extentTest = extent.startTest("View more button", 
				"verification of View more button");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",35);
		try{
			boolean flag1 = receptionist.viewMore(35);
			if(flag1 == true){
				Constant.log.info("test036_ViewMore: View More button validation test case is successful");
				extentTest.log(LogStatus.PASS, "View More button validation n test case is successful");
				testresultdata.put("37", new Object[] {36d, "View More", "View more button is displayed when 11 patients available ","Pass"});
			}else{
				System.err.println("test036_ViewMore: View More button validation test case failed ");
				Constant.captureScreen_Negative("View More button");
				extentTest.log(LogStatus.FAIL, "View More button validation test case failed ");
				testresultdata.put("37", new Object[] {36d, "View More", "View more button is not displayed when 11 patients available ","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("View More button");
	}
	
	@Test
	public void test037_WaitingTab() throws Exception{
		Log.startTestCase("Waiting tab");
		extentTest = extent.startTest("Waiting tab", 
				"verification of Waiting tab");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",36);
		try{
			boolean flag1 = receptionist.waiting_AfterToken(36);
			boolean flag2 = receptionist.waiting_AfterReschedule();
			if(flag1 == true && flag2 == true){
				Constant.log.info("test037_WaitingTab: validation of Waiting tab test case is successful");
				extentTest.log(LogStatus.PASS, "validation of Waiting tab test case is successful");
				testresultdata.put("38", new Object[] {37d, "Waiting Tab", "If token alloted then patient is displayed in waiting tab ","Pass"});
			}else{
				System.err.println("test037_WaitingTab: validation of Waiting tab test case failed ");
				Constant.captureScreen_Negative("Waiting tab");
				extentTest.log(LogStatus.FAIL, "validation of Waiting tab test case failed ");
				testresultdata.put("38", new Object[] {37d, "Waiting Tab", "Though token alloted patient is not displayed in waiting tab ","fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Waiting tab");
	}
		
	@Test	
	public void test038_RemainingTab() throws Exception{
		Log.startTestCase("Remaining tab");
		extentTest = extent.startTest("Remaining tab", 
				"verification of Remaining tab");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",37);
		try{
			boolean flag1 = receptionist.Remaining_AfterAppointment(37);
			boolean flag2 = receptionist.Remaining_AfterReschedule(37);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test038_RemainingTab: validation of Remaining tab test case is successful");
				extentTest.log(LogStatus.PASS, "validation of Remaining tab test case is successful");
				testresultdata.put("39", new Object[] {38d, "Remaining Tab", "If appointment is booked then patient is displayed in remaining tab ","Pass"});
			}else{
				System.err.println("test038_RemainingTab: validation of Remaining tab test case failed ");
				Constant.captureScreen_Negative("Remaining tab");
				extentTest.log(LogStatus.FAIL, "validation of Remaining tab test case failed");
				testresultdata.put("39", new Object[] {38d, "Remaining Tab", "Though appointment booked, patient is not displayed in remaining tab ","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Remaining tab");
	}
	
	@Test
	public void test039_LapsedTab() throws Exception{
		Log.startTestCase("Lapsed tab");
		extentTest = extent.startTest("Lapsed tab", 
				"verification of Lapsed tab");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",38);
		try{
			boolean flag1 = receptionist.Lapsed_AfterReschedule();
			if(flag1 == true){
				Constant.log.info("test039_LapsedTab: validation of Lapsed tab test case is successful");
				extentTest.log(LogStatus.PASS, "validation of Lapsed tab test case is successful");
				testresultdata.put("40", new Object[] {39d, "Lapsed Tab", "Able to reschedule patient from lapsed tab","Pass"});
			}else{
				System.err.println("test039_LapsedTab: validation of Lapsed tab test case failed ");
				Constant.captureScreen_Negative("Lapsed tab");
				extentTest.log(LogStatus.FAIL, "validation of Lapsed tab test case failed");
				testresultdata.put("40", new Object[] {39d, "Lapsed Tab", "Unable to reschedule patient from lapsed tab","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Lapsed tab");
	}
	
	@Test
	public void test040_CheckoutTab() throws Exception{
		Log.startTestCase("Checkout tab");
		extentTest = extent.startTest("Checkout tab", 
				"verification of Checkout tab");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",39);
		try{
			boolean flag1 = receptionist.CheckedOut_count(39);
			boolean flag2 = receptionist.CheckedOut_AfterReschedule();
			if(flag1 == true && flag2 == true){
				Constant.log.info("test040_CheckoutTab: validation of Checkout tab test case is successful");
				extentTest.log(LogStatus.PASS, "validation of Checkout tab test case is successful");
				testresultdata.put("41", new Object[] {40d, "Checkout Tab", "Able to reschedule appointment from Checkout tab","Pass"});
			}else{
				System.err.println("test040_CheckoutTab: validation of Checkout tab test case failed ");
				Constant.captureScreen_Negative("Checkout tab");
				extentTest.log(LogStatus.FAIL, "validation of Checkout tab test case failed");
				testresultdata.put("41", new Object[] {40d, "Checkout Tab", "Unable to reschedule appointment from Checkout tab","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Checkout tab");
	}
	
	@Test
	public void test041_ValidateSymptom() throws Exception{
		Log.startTestCase("Symptom validate");
		extentTest = extent.startTest("Symptom validate", 
				"verification of Symptom validate");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",40);
		try{
			boolean flag1 = receptionist.SymptomVerify(40);
			if(flag1 == true){
				Constant.log.info("test041_ValidateSymptom: Symptom validate test case is successful");
				extentTest.log(LogStatus.PASS, "Symptom validate  test case is successful");
				testresultdata.put("42", new Object[] {41d, "Symptom", "Symptom is displayed in allot token pop up","Pass"});
			}else{
				System.err.println("test041_ValidateSymptom: Symptom validate test case failed ");
				Constant.captureScreen_Negative("Symptom validate");
				extentTest.log(LogStatus.FAIL, "Symptom validate test case failed");
				testresultdata.put("42", new Object[] {41d, "Symptom", "Symptom is not displayed in allot token pop up","fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Symptom validate");
	}
	
	@Test
	public void test042_Token_DocRef() throws Exception{
		Log.startTestCase("Token with Doctor Reference");
		extentTest = extent.startTest("Symptom validate", 
				"verification of Symptom validate");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",41);
		try{
			boolean flag1 = receptionist.Token_DocRef(41);
			if(flag1 == true){
				Constant.log.info("test042_Token_DocRef: Add token with Doctor reference test case is successful");
				extentTest.log(LogStatus.PASS, "Symptom validate  test case is successful");
				testresultdata.put("43", new Object[] {42d, "Allot token with Doctor refrence", "Token alloted with doctor reference","Pass"});
			}else{
				System.err.println("test042_Token_DocRef: Add token with Doctor reference test case failed ");
				Constant.captureScreen_Negative("Token with Doctor Reference");
				extentTest.log(LogStatus.FAIL, "Symptom validate test case failed");
				testresultdata.put("43", new Object[] {42d, "Allot token with Doctor refrence", "Token is not alloted with doctor reference","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Token with Doctor Reference");
	}
	
	@Test
	public void test043_UpdateFee() throws Exception{
		Log.startTestCase("Update Fee & Validate in Print");
		extentTest = extent.startTest("Update Fee details", 
				"Update Fee & Validate in Print bill");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",42);
		try{
			boolean flag1 = receptionist.UpdateFee(42);
			if(flag1 == true){
				Constant.log.info("test043_UpdateFee: Update Fee & Validate in Print bill test case is successful");
				extentTest.log(LogStatus.PASS, "Update Fee & Validate in Print bill test case is successful");
				testresultdata.put("44", new Object[] {43d, "Update fee", "Fee is updated","Pass"});
			}else{
				System.err.println("test043_UpdateFee: Update Fee & Validate in Print test case failed ");
				Constant.captureScreen_Negative("Update Fee & Validate in Print");
				extentTest.log(LogStatus.FAIL, "Update Fee & Validate in Print bill test case failed");
				testresultdata.put("44", new Object[] {43d, "Update fee", "Fee is not updated","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Update Fee & Validate in Print");
	}
	
	@Test
	public void test044_TodayBtn() throws Exception{
		Log.startTestCase("Today button");
		extentTest = extent.startTest("Today button", 
				"Today button validation");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",43);
		try{
			boolean flag1 = receptionist.TodayButton();
			if(flag1 == true){
				Constant.log.info("test044_TodayBtn: Today button validation test case is successful");
				extentTest.log(LogStatus.PASS, "Today button validation test case is successful");
				testresultdata.put("45", new Object[] {44d, "Today button", "Current date is displayed","Pass"});
			}else{
				System.err.println("test044_TodayBtn: Today button validation  test case failed ");
				Constant.captureScreen_Negative("Today button");
				extentTest.log(LogStatus.FAIL, "Today button validation test case failed");
				testresultdata.put("45", new Object[] {44d, "Today button", "Current date is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Today button");
	}
	
	@Test
	public void test045_PatientProfileUpdate() throws Exception{
		Log.startTestCase("Patient Profile update");
		extentTest = extent.startTest("update Patient Profile ", 
				" validate Patient Profile update");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",44);
		try{
			boolean flag1 = receptionist.UpdateProfile(44);
			if(flag1 == true){
				Constant.log.info("test045_PatientProfileUpdate: validate Patient Profile updated successfully");
				extentTest.log(LogStatus.PASS, "validate Patient Profile update test case is successful");
				testresultdata.put("46", new Object[] {45d, "Update patient profile", "Profile is updated","Pass"});
			}else{
				System.err.println("test045_PatientProfileUpdate: validate Patient Profile update test case failed ");
				Constant.captureScreen_Negative("Patient Profile update");
				extentTest.log(LogStatus.FAIL, "validate Patient Profile update test case failed");
				testresultdata.put("46", new Object[] {45d, "Update patient profile", "Profile is not updated","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Patient Profile update");
	}
	
	@Test
	public void test046_AllotToken_Associate() throws Exception{
		Log.startTestCase("Allot Token with Associate");
		extentTest = extent.startTest("Allot Token with Associate", 
				"Allot Token with Associate");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",45);
		try{
			boolean flag1 = receptionist.Token_Associate(45);
			if(flag1 == true){
				Constant.log.info("test046_AllotToken_Associate: Allot Token with Associate test case is successful");
				extentTest.log(LogStatus.PASS, "Allot Token with Associate test case is successful");
				testresultdata.put("47", new Object[] {46d, "Allot token with Associate", "Token alloted with associate","Pass"});
			}else{
				System.err.println("test046_AllotToken_Associate: Allot Token with Associate test case failed ");
				Constant.captureScreen_Negative("Allot Token with Associate");
				extentTest.log(LogStatus.FAIL, "Allot Token with Associate test case failed");
				testresultdata.put("47", new Object[] {46d, "Allot token with Associate", "Token not alloted with associate","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Allot Token with Associate");
	}
	
	@Test
	public void test047_checkDOB_YearMonth() throws Exception{
		Log.startTestCase("check DOB with Yr & Month");
		extentTest = extent.startTest("check DOB with Yr & Month", 
				"validate DOB with Yr & Month combination");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",46);
		try{
			boolean flag1 = receptionist.ValidateAge_AllotToken(46);
			boolean flag2 = receptionist.ValidateAge_ViewPatientStatus(46);
			boolean flag3 = receptionist.ValidateAge_ViewMore(46);
			if(flag1 == true && flag2 == true && flag3 == true){
				Constant.log.info("test047_checkDOB_YearMonth: validate DOB with Yr & Month combination test case is successful");
				extentTest.log(LogStatus.PASS, "validate DOB with Yr & Month combination test case is successful");
				testresultdata.put("48", new Object[] {47d, "DOB check with year and month combination", "DOB with Yr and Month is displayed","Pass"});
			}else{
				System.err.println("test047_checkDOB_YearMonth: validate DOB with Yr & Month combination test case failed ");
				Constant.captureScreen_Negative("validate DOB with Yr & Month combination");
				extentTest.log(LogStatus.FAIL, "validate DOB with Yr & Month combination test case failed");
				testresultdata.put("48", new Object[] {47d, "DOB check with year and month combination", "DOB with Yr and Month is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("check DOB with Yr & Month");
	}
	
	@Test
	public void test048_checkDOB_Year() throws Exception{
		Log.startTestCase("check DOB with only year");
		extentTest = extent.startTest("check DOB with only year", 
				"validate DOB with only year");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",47);
		try{
			boolean flag1 = receptionist.ValidateAge_AllotToken(47);
			boolean flag2 = receptionist.ValidateAge_ViewPatientStatus(47);
			boolean flag3 = receptionist.ValidateAge_ViewMore(47);
			if(flag1 == true && flag2 == true && flag3 == true){
				Constant.log.info("test048_checkDOB_Year: validate DOB with only year test case is successful");
				extentTest.log(LogStatus.PASS, "validate DOB with only year test case is successful");
				testresultdata.put("49", new Object[] {48d, "DOB check with only year", "DOB with Yr is displayed","Pass"});
			}else{
				System.err.println("test048_checkDOB_Year: validate DOB with only year test case failed ");
				Constant.captureScreen_Negative("validate DOB with only year");
				extentTest.log(LogStatus.FAIL, "validate DOB with only year test case failed");
				testresultdata.put("49", new Object[] {48d, "DOB check with only year", "DOB with Yr is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("check DOB with only year");
	}
	
	@Test
	public void test049_checkDOB_Month() throws Exception{
		Log.startTestCase("check DOB with only Month");
		extentTest = extent.startTest("check DOB with only Month", 
				"validate DOB with only Month");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",48);
		try{
			boolean flag1 = receptionist.ValidateAge_AllotToken(48);
			boolean flag2 = receptionist.ValidateAge_ViewPatientStatus(48);
			boolean flag3 = receptionist.ValidateAge_ViewMore(48);
			if(flag1 == true && flag2 == true && flag3 == true){
				Constant.log.info("test049_checkDOB_Month: validate DOB with only Month test case is successful");
				extentTest.log(LogStatus.PASS, "validate DOB with only Month test case is successful");
				testresultdata.put("50", new Object[] {49d, "DOB check with only month", "DOB with month is displayed","Pass"});
			}else{
				System.err.println("test049_checkDOB_Month: validate DOB with only Month test case failed ");
				Constant.captureScreen_Negative("validate DOB with only Month");
				extentTest.log(LogStatus.FAIL, "validate DOB with only Month test case failed");
				testresultdata.put("50", new Object[] {49d, "DOB check with only month", "DOB with month is not displayed","fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("check DOB with only Month");
	}
	
	@Test
	public void test050_checkDOB_Days() throws Exception{
		Log.startTestCase("check DOB with only Days");
		extentTest = extent.startTest("check DOB with only Days", 
				"validate DOB with only Days");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",49);
		try{
			boolean flag1 = receptionist.ValidateAge_AllotToken(49);
			boolean flag2 = receptionist.ValidateAge_ViewPatientStatus(49);
			boolean flag3 = receptionist.ValidateAge_ViewMore(49);
			if(flag1 == true && flag2 == true && flag3 == true){
				Constant.log.info("test050_checkDOB_Days: validate DOB with only Days test case is successful");
				extentTest.log(LogStatus.PASS, "validate DOB with only Days test case is successful");
				testresultdata.put("51", new Object[] {50d, "DOB check with only Days", "DOB with days is displayed","Pass"});
			}else{
				System.err.println("test050_checkDOB_Days: validate DOB with only Days test case failed ");
				Constant.captureScreen_Negative("validate DOB with only Days");
				extentTest.log(LogStatus.FAIL, "validate DOB with only Days test case failed");
				testresultdata.put("51", new Object[] {50d, "DOB check with only Days", "DOB with days is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("check DOB with only Days");
	}
	
	@Test
	public void test051_CheckSmartPhoneAndMedicApp() throws Exception{
		Log.startTestCase("Check Smart Phone and Medic App");
		extentTest = extent.startTest("Check Smart Phone and Medic App", 
				"Validate check mark near medic id in allot token");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",50);
		try{
			boolean flag1 = receptionist.Check_SmartAndMedicOpt(50);
			boolean flag2 = receptionist.UnCheck_SmartAndMedicOpt(50);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test051_CheckSmartPhoneAndMedicApp: validate check mark near medic id in allot token test case is successful");
				extentTest.log(LogStatus.PASS, "validate check mark near medic id in allot token test case is successful");
				testresultdata.put("52", new Object[] {51d, "Smart & Medic usage check", "Smart & Medic usage checked ","Pass"});
			}else{
				System.err.println("test051_CheckSmartPhoneAndMedicApp: validate check mark near medic id in allot token test case failed ");
				Constant.captureScreen_Negative("validate check mark of Medic ID");
				extentTest.log(LogStatus.FAIL, "validate check mark near medic id in allot token test case failed");
				testresultdata.put("52", new Object[] {51d, "Smart & Medic usage check", "Smart & Medic usage does not work ","fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Check Smart Phone and Medic App");
	}
	
	@Test
	public void test052_FutureDayAppointment() throws Exception{
		Log.startTestCase("Future Day Appointment");
		extentTest = extent.startTest("Future Day Appointment", 
				"Validate whether appointment can be booked for future date");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",51);
		try{
			boolean flag1 = receptionist.FutureDayAppointment(51);
			if(flag1 == true){
				Constant.log.info("test052_FutureDayAppointment: validate appointment booked for future date test case is successful");
				extentTest.log(LogStatus.PASS, "validate appointment booked for future date test case is successful");
				testresultdata.put("53", new Object[] {52d, "Future day appointment", "Future day appointment is booked","Pass"});
			}else{
				System.err.println("test052_FutureDayAppointment: validate appointment booked for future date test case failed ");
				Constant.captureScreen_Negative("Future Day Appointment");
				extentTest.log(LogStatus.FAIL, "validate appointment booked for future date test case failed");
				testresultdata.put("53", new Object[] {52d, "Future day appointment", "Future day appointment is not booked","fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Future Day Appointment");
	}
	
	@Test
	public void test053_CancelFutureDayAppointment() throws Exception{
		Log.startTestCase("Cancel future day appointment");
		extentTest = extent.startTest("Cancel future day appointment", 
				"Verify whether future day appointment can be cancelled");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",52);
		try{
			boolean flag1 = receptionist.CancelFutureAppt(52);
			if(flag1 == true){
				Constant.log.info("Cancel future day appointment test case is successful");
				extentTest.log(LogStatus.PASS, "Cancel future day appointment test case is successful");
				testresultdata.put("54", new Object[] {53d, "Future day appointment cancel", "Future day appointment is cancelled","Pass"});
			}else{
				System.err.println("Cancel future day appointment test case failed ");
				Constant.captureScreen_Negative("Cancel future day appointment");
				extentTest.log(LogStatus.FAIL, "Cancel future day appointment test case failed ");
				testresultdata.put("54", new Object[] {53d, "Future day appointment cancel", "Future day appointment is not cancelled","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel future day appointment");
	}
	
	@Test
	public void test054_FutureApointmentReschdule() throws Exception{
		Log.startTestCase("Future Day Appointment reschedule");
		extentTest = extent.startTest("Future Day Appointment reschedule", 
				"Validate whether appointment of future date can be reschduled ");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",53);
		try{
			boolean flag1 = receptionist.FutureDayAppointmentReschedule(53);
			if(flag1 == true){
				Constant.log.info("test054_FutureApointmentReschdule: Validate whether appointment of future date can be reschduled test case is successful");
				extentTest.log(LogStatus.PASS, "Validate whether appointment of future date can be reschduled test case is successful");
				testresultdata.put("55", new Object[] {54d, "Future day appointment cancel", "Future day appointment is cancelled","Pass"});
			}else{
				System.err.println("test055_FutureApointmentReschdule: Validate whether appointment of future date can be reschduled test case failed ");
				Constant.captureScreen_Negative("Future Day Appointment");
				extentTest.log(LogStatus.FAIL, "Validate whether appointment of future date can be reschduled test case failed");
				testresultdata.put("55", new Object[] {54d, "Future day appointment cancel", "Future day appointment is not cancelled","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Future Day Appointment reschedule");
	}
	
	@Test
	public void test055_Refresh() throws Exception{
		Log.startTestCase("Refresh");
		extentTest = extent.startTest("Refresh", 
				"Verify medic icon by clicking on the icon and refreshing the application");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",54);
		try{
			boolean flag1 = receptionist.refresh();
			if(flag1 == true){
				Constant.log.info("test055_Refresh: Verify medic icon by clicking on the icon and refreshing the application test case is successful");
				extentTest.log(LogStatus.PASS, "Verify medic icon by clicking on the icon and refreshing the application test case is successful");
				testresultdata.put("56", new Object[] {55d, "Refresh", "Refresh the application","Pass"});
			}else{
				System.err.println("test055_Refresh: Verify medic icon by clicking on the icon and refreshing the application test case failed ");
				Constant.captureScreen_Negative("Refresh");
				extentTest.log(LogStatus.FAIL, "Verify medic icon by clicking on the icon and refreshing the application test case failed");
				testresultdata.put("56", new Object[] {55d, "Refresh", "Application not refreshed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Refresh");
	}
	
	@Test
	public void test056_BackslashCheck() throws Exception{
		Log.startTestCase("Refresh");
		extentTest = extent.startTest("Refresh", 
				"Verify medic icon by clicking on the icon and refreshing the application");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",55);
		try{
			boolean flag1 = receptionist.CheckSymptomfield();
			boolean flag2 = receptionist.CheckCancelReason(55);
			if(flag1 == true && flag2 == true){
				Constant.log.info("Backslash check test case is successful");
				extentTest.log(LogStatus.PASS, "Backslash check test case is successful");
				testresultdata.put("57", new Object[] {56d, "Backslash Check", "Backslash is not entered","Pass"});
			}else{
				System.err.println("Backslash check test case failed ");
				Constant.captureScreen_Negative("Backslash check");
				extentTest.log(LogStatus.FAIL, "Backslash check test case failed ");
				testresultdata.put("57", new Object[] {56d, "Backslash Check", "Backslash is entered","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Backslash check");
	}
	
	@Test
	public void test057_AppointmentBookedTime() throws Exception{
		Log.startTestCase("Appointment booked time validation");
		extentTest = extent.startTest("Appointment booked time validation", 
				"Verify appointment booked time is displayed in the print token");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",56);
		try{
			boolean flag1 = receptionist.appointmentBookedTime(56);
			if(flag1 == true){
				Constant.log.info("test057_AppointmentBookedTime: Verify appointment booked time is displayed in the print token test case is successful");
				extentTest.log(LogStatus.PASS, "Verify appointment booked time is displayed in the print token test case is successful");
				testresultdata.put("58", new Object[] {57d, "Appointment booked time in print", "Appointment booked time is displayed in print","Pass"});
			}else{
				System.err.println("test057_AppointmentBookedTime: Verify appointment booked time is displayed in the print token test case failed ");
				Constant.captureScreen_Negative("Appointment booked time validation");
				extentTest.log(LogStatus.FAIL, "Verify appointment booked time is displayed in the print token test case failed");
				testresultdata.put("58", new Object[] {57d, "Appointment booked time in print", "Appointment booked time is not displayed in print","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Appointment booked time validation");
	}
	
	@Test
	public void test058_Check40Characters() throws Exception{
		Log.startTestCase("check 40 characters");
		extentTest = extent.startTest("check 40 characters", 
				"Verify 40 characters in field values");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",57);
		try{
			boolean flag1 = receptionist.check40Char_AllotToken(57);
			boolean flag2 = receptionist.check40Char_PrintToken(57);
			boolean flag3 = receptionist.check40Char_PrintBill(57);
			boolean flag4 = receptionist.check40Char_PrintIDCard(57);
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true){
				Constant.log.info("test058_Check40Characters: Verify 40 characters in field values test case is successful");
				extentTest.log(LogStatus.PASS, "Verify 40 characters in field values test case is successful");
				testresultdata.put("59", new Object[] {58d, "check 40 characters", "40 characters entered successfully","Pass"});
			}else{
				System.err.println("test058_Check40Characters: VVerify 40 characters in field values test case failed ");
				Constant.captureScreen_Negative("check 40 characters");
				extentTest.log(LogStatus.FAIL, "Verify 40 characters in field values test case failed");
				testresultdata.put("59", new Object[] {58d, "check 40 characters", "40 characters is not entered","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true && flag3 == true && flag4 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("check 40 characters");
	}
	
	@Test
	public void test059_MandatoryCancelReasonCheck() throws Exception{
		Log.startTestCase("Mandatory cancel reson check");
		extentTest = extent.startTest("Mandatory cancel reson check", 
				"Verify cancel reason is a mandatory field");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",58);
		try{
			boolean flag = receptionist.MandatoryCancelReasonCheck(58);
			if(flag == true){
				Constant.log.info("Mandatory cancel reson check test case is successful");
				extentTest.log(LogStatus.PASS, "Mandatory cancel reson check test case is successful");
				testresultdata.put("60", new Object[] {59d, "Mandatory Cancel Reason", "Mandatory warning message displayed","Pass"});
			}else{
				System.err.println("Mandatory cancel reson check test case failed ");
				Constant.captureScreen_Negative("Mandatory cancel reson check");
				extentTest.log(LogStatus.FAIL, "Mandatory cancel reson check test case failed ");
				testresultdata.put("60", new Object[] {59d, "Mandatory Cancel Reason", "Mandatory warning message not displayed","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Mandatory cancel reson check");
	}
	
	@Test
	public void test060_CashOption_DefaultCheck() throws Exception{
		Log.startTestCase("Cash option is selected by default");
		extentTest = extent.startTest("Cash option is selected by default", 
				"Verify whether Cash option is selected by default");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",59);
		try{
			boolean flag1 = receptionist.CashOption_Enabled(59);
			if(flag1 == true){
				Constant.log.info("test059_CashOption_DefaultCheck: Verify whether Cash option is selected by default test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether Cash option is selected by default test case is successful");
				testresultdata.put("61", new Object[] {60d, "Cash Option selected by default", "Cash option is selected by default","Pass"});
			}else{
				System.err.println("test059_CashOption_DefaultCheck: Verify whether Cash option is selected by default test case failed ");
				Constant.captureScreen_Negative("Cash option is selected by default");
				extentTest.log(LogStatus.FAIL, "Verify whether Cash option is selected by default test case failed");
				testresultdata.put("61", new Object[] {60d, "Cash Option selected by default", "Cash option is not selected by default","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cash option is selected by default");
	}
	
	@Test
	public void test061_MedicalOfficer() throws Exception{
		Log.startTestCase("Medical Officer");
		extentTest = extent.startTest("Medical Officer", 
				"Verify whether Medical Officer does not have Dr initials");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",60);
		try{
			boolean flag1 = receptionist.MedicalOfficer(60);
			if(flag1 == true){
				Constant.log.info("test061_MedicalOfficer: Verify whether Medical Officer does not have Dr initials test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether Medical Officer does not have Dr initials test case is successful");
				testresultdata.put("62", new Object[] {61d, "Medical Officer", "Medical Officer should not have Dr. prefix","Pass"});
			}else{
				System.err.println("test061_MedicalOfficer: Verify whether Medical Officer does not have Dr initials test case failed ");
				Constant.captureScreen_Negative("Medical Officer");
				extentTest.log(LogStatus.FAIL, "Verify whether Medical Officer does not have Dr initials test case failed");
				testresultdata.put("62", new Object[] {61d, "Medical Officer", "Medical Officer has Dr. prefix","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Medical Officer");
	}
	
	@Test
	public void test062_WarningMsg_Reschedule() throws Exception{
		Log.startTestCase("Warning Msg check in Reschedule pop up");
		extentTest = extent.startTest("Warning Msg check in Reschedule pop up", 
				"Verify whether warning message is displayed in the reschedule pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",61);
		try{
			boolean flag1 = receptionist.WarningMsg_Reschedule(61);
			if(flag1 == true){
				Constant.log.info("test062_WarningMsg_Reschedule: Verify whether warning message is displayed in the reschedule pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether warning message is displayed in the reschedule pop up test case is successful");
				testresultdata.put("63", new Object[] {62d, "Warning Msg in Reschedule pop up", "Warning message is displayed when reschedule is clicked without slot","Pass"});
			}else{
				System.err.println("test062_WarningMsg_Reschedule: Verify whether warning message is displayed in the reschedule pop up test case failed ");
				Constant.captureScreen_Negative("Warning Msg check in Reschedule pop up");
				extentTest.log(LogStatus.FAIL, "Verify whether warning message is displayed in the reschedule pop up test case failed");
				testresultdata.put("63", new Object[] {62d, "Warning Msg in Reschedule pop up", "Warning message is not displayed when reschedule is clicked without slot","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Warning Msg check in Reschedule pop up");
	}
	
	@Test
	public void test063_ValidatePatientStatus() throws Exception{
		Log.startTestCase("Validate count of Patient status");
		extentTest = extent.startTest("Validate count of Patient status", 
				"Verify whether count of available patients equals the patient status");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",62);
		try{
			boolean flag1 = receptionist.ValidatePatientStautsView(62);
			if(flag1 == true){
				Constant.log.info("test063_ValidatePatientStatus: Verify whether count of available patients equals the patient status test case is successful");
				extentTest.log(LogStatus.PASS, "Verify whether count of available patients equals the patient status test case is successful");
				testresultdata.put("64", new Object[] {63d, "Validate patient count in tab", "Patient count matches","Pass"});
			}else{
				System.err.println("test063_ValidatePatientStatus: Verify whether count of available patients equals the patient status test case failed ");
				Constant.captureScreen_Negative("Validate count of Patient status");
				extentTest.log(LogStatus.FAIL, "Verify whether count of available patients equals the patient status test case failed");
				testresultdata.put("64", new Object[] {63d, "Validate patient count in tab", "Patient count does not match","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate count of Patient status");
	}
	
	@Test
	public void test064_AppoinmentSuccessMsg() throws Exception{
		Log.startTestCase("Validate appointment success message");
		extentTest = extent.startTest("Validate appointment success message", 
				"Verify appointment success message");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",63);
		try{
			boolean flag1 = receptionist.CheckAppointmentSuccessMessage(63);
			if(flag1 == true){
				Constant.log.info("test064_AppoinmentSuccessMsg: Verify appointment success message test case is successful");
				extentTest.log(LogStatus.PASS, "Verify appointment success message test case is successful");
				testresultdata.put("65", new Object[] {64d, "Validate appointment success msg", "Success pop up is displayed","Pass"});
			}else{
				System.err.println("test064_AppoinmentSuccessMsg: Verify appointment success message test case failed ");
				Constant.captureScreen_Negative("Validate appointment success message");
				extentTest.log(LogStatus.FAIL, "Verify appointment success message test case failed");
				testresultdata.put("65", new Object[] {64d, "Validate appointment success msg", "Success pop up is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate appointment success message");
	}
	
	@Test
	public void test065_RescheduleSuccessMsg() throws Exception{
		Log.startTestCase("Validate reschedule success message");
		extentTest = extent.startTest("Validate reschedule success message", 
				"Verify reschedule success message");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",64);
		try{
			boolean flag1 = receptionist.CheckRescheduleSuccessMsg(64);
			if(flag1 == true){
				Constant.log.info("test065_RescheduleSuccessMsg: Verify reschedule success message test case is successful");
				extentTest.log(LogStatus.PASS, "Verify reschedule success message test case is successful");
				testresultdata.put("66", new Object[] {65d, "Validate reschedule success msg", "Success pop up is displayed","Pass"});
			}else{
				System.err.println("test065_RescheduleSuccessMsg: Verify appointreschedulement success message test case failed ");
				Constant.captureScreen_Negative("Validate reschedule success message");
				extentTest.log(LogStatus.FAIL, "Verify reschedule success message test case failed");
				testresultdata.put("66", new Object[] {65d, "Validate reschedule success msg", "Success pop up is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate reschedule success message");
	}
	
	@Test
	public void test066_CancelpopUpMsgValidation() throws Exception{
		Log.startTestCase("Check Cancel Pop up of appointment and token");
		extentTest = extent.startTest("Validate reschedule success message", 
				"Verify reschedule success message");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",65);
		try{
			boolean flag1 = receptionist.CancelPopUpMsgValidation(65);
			if(flag1 == true){
				Constant.log.info("Check Cancel Pop up of appointment and token test case is successful");
				extentTest.log(LogStatus.PASS, "Check Cancel Pop up of appointment and token test case is successful");
				testresultdata.put("67", new Object[] {66d, "Validate Cancel Token and Appointment pop up", "Success pop up is displayed","Pass"});
			}else{
				System.err.println("Check Cancel Pop up of appointment and token test case failed ");
				Constant.captureScreen_Negative("Check Cancel Pop up of appointment and token");
				extentTest.log(LogStatus.FAIL, "Check Cancel Pop up of appointment and token test case failed ");
				testresultdata.put("67", new Object[] {66d, "Validate Cancel Token and Appointment pop up", "Success pop up is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Check Cancel Pop up of appointment and token");
	}
	
	@Test
	public void test067_MandatoryFields_AddPatient() throws Exception{
		Log.startTestCase("validate mandatory fields in Add patient pop up");
		extentTest = extent.startTest("validate mandatory fields in Add patient pop up", 
				"validate mandatory fields in Add patient pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",66);
		try{
			boolean flag1 = receptionist.mandatoryField_AddPatient();
			if(flag1 == true){
				Constant.log.info("test067_MandatoryFields_AddPatient: validate mandatory fields in Add patient pop up test case is successful");
				extentTest.log(LogStatus.PASS, "validate mandatory fields in Add patient pop up test case is successful");
				testresultdata.put("68", new Object[] {67d, "Mandatory error msg in Add patient pop up", "Error message is displayed","Pass"});
			}else{
				System.err.println("test067_MandatoryFields_AddPatient: validate mandatory fields in Add patient pop up test case failed ");
				Constant.captureScreen_Negative("validate mandatory fields in Add patient pop up");
				extentTest.log(LogStatus.FAIL, "validate mandatory fields in Add patient pop up test case failed");
				testresultdata.put("68", new Object[] {67d, "Mandatory error msg in Add patient pop up", "Error message is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("validate mandatory fields in Add patient pop up");
	}

	@Test
	public void test068_AllotToken_SpecificDoc() throws Exception{
		Log.startTestCase("allot token for after selecting specific doctor");
		extentTest = extent.startTest("allot token for after selecting specific doctor", 
				"validate whether token is alloted for a selected doctor");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",67);
		try{
			boolean flag1 = receptionist.particularDoc(67);
			if(flag1 == true){
				Constant.log.info("test068_AllotToken_SpecificDoc: Validation on allot token for a selected doctor test case is successful");
				extentTest.log(LogStatus.PASS, "Validation on allot token for a selected doctor test case is successful");
				testresultdata.put("69", new Object[] {68d, "Add token for specific doctor", "Token added for specific doctor","Pass"});
			}else{
				System.err.println("test068_AllotToken_SpecificDoc: Validation on allot token for a selected doctor test case failed ");
				Constant.captureScreen_Negative("allot token for after selecting specific doctor");
				extentTest.log(LogStatus.FAIL, "Validation on allot token for a selected doctor test case failed");
				testresultdata.put("69", new Object[] {68d, "Add token for specific doctor", "Token not added for specific doctor","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("allot token for after selecting specific doctor");
	}
	
	@Test
	public void test069_CheckBookedAppointmentMsg() throws Exception{
		Log.startTestCase("Validate booked appointment message");
		extentTest = extent.startTest("Validate booked appointment message", 
				"validate whether already booked appointment message is displayed");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",68);
		try{
			boolean flag1 = receptionist.ValidateBookedApptMsg(68);
			if(flag1 == true){
				Constant.log.info("test069_CheckBookedAppointmentMsg: validate mandatory fields in Add patient pop up test case is successful");
				extentTest.log(LogStatus.PASS, "validate mandatory fields in Add patient pop up test case is successful");
				testresultdata.put("70", new Object[] {69d, "Appointment already booked information", "Appointment already booked for the selected patient link displayed","Pass"});
			}else{
				System.err.println("test069_CheckBookedAppointmentMsg: validate mandatory fields in Add patient pop up test case failed ");
				Constant.captureScreen_Negative("Validate booked appointment message");
				extentTest.log(LogStatus.FAIL, "validate mandatory fields in Add patient pop up test case failed");
				testresultdata.put("70", new Object[] {69d, "Appointment already booked information", "Appointment already booked for the selected patient link not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate booked appointment message");
	}
	
	@Test
	public void test070_ChangePassword() throws Exception{
		Log.startTestCase("Change password");
		extentTest = extent.startTest("Validate change password", 
				"validate password change");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",69);
		try{
			boolean flag1 = receptionist.ChangePassword(69);
			if(flag1 == true){
				Constant.log.info("test070_ChangePassword: validate password change test case is successful");
				extentTest.log(LogStatus.PASS, "validate password change test case is successful");
				testresultdata.put("71", new Object[] {70d, "Change Password with valid password", "Password is changed","Pass"});
			}else{
				System.err.println("test070_ChangePassword: validate password change test case failed ");
				Constant.captureScreen_Negative("Validate change password");
				extentTest.log(LogStatus.FAIL, "validate password change test case failed");
				testresultdata.put("71", new Object[] {70d, "Change Password with valid password", "Password is not changed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Change password");
	}
	
	@Test
	public void test071_ChangePassword_InvalidPwd() throws Exception{
		Log.startTestCase("Validate change password with invalid password");
		extentTest = extent.startTest("Validate change password with invalid password", 
				"validate warning message when password changed with invalid password");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",70);
		try{
			boolean flag1 = receptionist.ChangePwdwithWrongPwd();
			if(flag1 == true){
				Constant.log.info("test071_ChangePasswordwithWrongPwd: validate warning message when password changed with invalid password test case is successful");
				extentTest.log(LogStatus.PASS, "validate warning message when password changed with invalid password test case is successful");
				testresultdata.put("72", new Object[] {71d, "Change Password with invalid password", "Password is not changed","Pass"});
			}else{
				System.err.println("test071_ChangePasswordwithWrongPwd: validate warning message when password changed with invalid password test case failed ");
				Constant.captureScreen_Negative("Validate change password with invalid password");
				extentTest.log(LogStatus.FAIL, "validate warning message when password changed with invalid password test case failed");
				testresultdata.put("72", new Object[] {71d, "Change Password with invalid password", "Password is changed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate change password with invalid password");
	}
	
	@Test
	public void test072_MismatchNewAndOldPwd() throws Exception{
		Log.startTestCase("Mismatch between new and old password");
		extentTest = extent.startTest("Mismatch between new and old password", 
				"Validate warning message is displayed if new and old password does not match");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",71);
		try{
			boolean flag1 = receptionist.PwdDoesNotMatchMsg();
			if(flag1 == true){
				Constant.log.info("test072_MismatchNewAndOldPwd: Validate warning message is displayed if new and old password does not match test case is successful");
				extentTest.log(LogStatus.PASS, "Validate warning message is displayed if new and old password does not match test case is successful");
				testresultdata.put("73", new Object[] {72d, "Mismatch new and old password", "Warning message is displayed","Pass"});
			}else{
				System.err.println("test072_MismatchNewAndOldPwd: Validate warning message is displayed if new and old password does not match test case failed ");
				Constant.captureScreen_Negative("Mismatch between new and old password");
				extentTest.log(LogStatus.FAIL, "Validate warning message is displayed if new and old password does not match test case failed");
				testresultdata.put("73", new Object[] {72d, "Mismatch new and old password", "No Warning message is displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Validate change password with wrong password");
	}
	
	@Test
	public void test073_CancelBtn_ChangePwd() throws Exception{
		Log.startTestCase("Cancel button in Change password pop up");
		extentTest = extent.startTest("Cancel button in Change password pop up", 
				"Validate cancel button in Change password pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",72);
		try{
			boolean flag1 = receptionist.CancelBtnPwdpopup(72);
			if(flag1 == true){
				Constant.log.info("test073_CancelBtn_ChangePwd: Validate cancel button in Change password pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validate cancel button in Change password pop up test case is successful");
				testresultdata.put("74", new Object[] {73d, "Cancel button in Change Password", "Cancel button closes the pop up","Pass"});
			}else{
				System.err.println("test073_CancelBtn_ChangePwd: Validate cancel button in Change password pop up test case failed ");
				Constant.captureScreen_Negative("Cancel button in Change password pop up");
				extentTest.log(LogStatus.FAIL, "Validate cancel button in Change password pop up test case failed");
				testresultdata.put("74", new Object[] {73d, "Cancel button in Change Password", "Cancel button does not close the pop up","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel button in Change password pop up");
	}
	
	@Test
	public void test074_MandatoryFields_ChangePwd() throws Exception{
		Log.startTestCase("Mandatory field check in Change password pop up");
		extentTest = extent.startTest("Mandatory field check in Change password pop up", 
				"Validate Mandatory field check in Change password pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",73);
		try{
			boolean flag1 = receptionist.PwdPopup_MandatoryFieldCheck();
			if(flag1 == true){
				Constant.log.info("test074_MandatoryFields_ChangePwd: Validate Mandatory field check in Change password pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Mandatory field check in Change password pop up test case is successful");
				testresultdata.put("75", new Object[] {74d, "Mandatory field check in Change password", "Mandatory error message displays","Pass"});
			}else{
				System.err.println("test074_MandatoryFields_ChangePwd: Validate Mandatory field check in Change password pop up test case failed ");
				Constant.captureScreen_Negative("Mandatory field check in Change password pop up");
				extentTest.log(LogStatus.FAIL, "Validate Mandatory field check in Change password pop up test case failed");
				testresultdata.put("75", new Object[] {74d, "Mandatory field check in Change password", "Mandatory error message is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Mandatory field check in Change password pop up");
	}
	
	@Test
	public void test075_MultiplePatientIdPopup() throws Exception{
		Log.startTestCase("Multiple Patient ID's pop up");
		extentTest = extent.startTest("Multiple Patient ID's pop up", 
				"Validate Multiple Patient ID's pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",74);
		try{
			boolean flag1 = receptionist.ValidateMultiplePatientPopup(74);
			if(flag1 == true){
				Constant.log.info("test075_MultiplePatientIdPopup: Validate Multiple Patient ID's pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Multiple Patient ID's pop up test case is successful");
				testresultdata.put("76", new Object[] {75d, "Multiple patient id pop up", "Able to select patient from the multiple patient is pop up","Pass"});
			}else{
				System.err.println("test075_MultiplePatientIdPopup: Validate Multiple Patient ID's pop up test case failed ");
				Constant.captureScreen_Negative("Multiple Patient ID's pop up");
				extentTest.log(LogStatus.FAIL, "Validate Multiple Patient ID's pop up test case failed");
				testresultdata.put("76", new Object[] {75d, "Multiple patient id pop up", "Unable to select patient from the multiple patient is pop up","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Multiple Patient ID's pop up");
	}
	
	@Test
	public void test076_LastSlotTime() throws Exception{
		Log.startTestCase("Last slot Time");
		extentTest = extent.startTest("Last slot Time", 
				"Validate Last slot time of a doctor");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",75);
		try{
			boolean flag1 = receptionist.LastSlotTime();
			if(flag1 == true){
				Constant.log.info("test076_LastSlotTime: Validate Last slot time of a doctor test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Last slot time of a doctor test case is successful");
				testresultdata.put("77", new Object[] {76d, "Last slot time validation", "Last slot time is 11:45pm","Pass"});
			}else{
				System.err.println("test076_LastSlotTime: Validate Last slot time of a doctor test case failed ");
				Constant.captureScreen_Negative("Last slot Time");
				extentTest.log(LogStatus.FAIL, "Validate Last slot time of a doctor test case failed");
				testresultdata.put("77", new Object[] {76d, "Last slot time validation", "Last slot time is not 11:45pm","Pass"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Last slot Time");
	}
	
	@Test
	public void test077_FutureDaySlotTime() throws Exception{
		Log.startTestCase("Future day slots start and end Time");
		extentTest = extent.startTest("Future day slots start and end Time", 
				"Validate Future day slots start and end Time of a doctor");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",76);
		try{
			boolean flag1 = receptionist.LastSlotTime();
			boolean flag2 = receptionist.FirstSlotTime_FutureDay();
			if(flag1 == true && flag2 == true){
				Constant.log.info("test077_FutureDaySlotTime: Validate Future day slots start and end Time of a doctor test case is successful");
				extentTest.log(LogStatus.PASS, "Validate Future day slots start and end Time of a doctor test case is successful");
				testresultdata.put("78", new Object[] {77d, "Future day slot time validation", "Time slots start at 12:00am and end at 11:45pm","Pass"});
			}else{
				System.err.println("test077_FutureDaySlotTime: Validate Future day slots start and end Time of a doctor test case failed ");
				Constant.captureScreen_Negative("Future day slots start and end Time");
				extentTest.log(LogStatus.FAIL, "Validate Future day slots start and end Time of a doctor test case failed");
				testresultdata.put("78", new Object[] {77d, "Future day slot time validation", "Time slots does not start at 12:00am and end at 11:45pm","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Future day slots start and end Time");
	}
	
	@Test
	public void test078_RescheduleSlotValidation() throws Exception{
		Log.startTestCase("Reschedule slots validation");
		extentTest = extent.startTest("Reschedule slots validation", 
				"Validate first and last slots of reschedule pop up");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",77);
		try{
			boolean flag1 = receptionist.RescheduleApptFutureSlots(77);
			boolean flag2 = receptionist.RescheduleApptPresentSlot(77);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test078_RescheduleSlotValidation: Validate first and last slots of reschedule pop up test case is successful");
				extentTest.log(LogStatus.PASS, "Validate first and last slots of reschedule pop up test case is successful");
				testresultdata.put("79", new Object[] {78d, "Reschedule slots validation", "Time slots start at 12:00am and end at 11:45pm","Pass"});
			}else{
				System.err.println("test078_RescheduleSlotValidation: Validate first and last slots of reschedule pop up test case failed ");
				Constant.captureScreen_Negative("Reschedule slots validation");
				extentTest.log(LogStatus.FAIL, "Validate first and last slots of reschedule pop up test case failed");
				testresultdata.put("79", new Object[] {78d, "Reschedule slots validation", "Time slots does not start at 12:00am and end at 11:45pm","Pass"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule slots validation");
	}
	
	@Test
	public void test079_PrintTokenInTamil() throws Exception{
		Log.startTestCase("Print token in tamil");
		extentTest = extent.startTest("Print token in tamil", 
				"Validate whether print token checkbox is working");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",78);
		try{
			boolean flag1 = receptionist.PrintToken_TamilInPopup(78);
			boolean flag2 = receptionist.PrintToken_TamilAllotTokenPage(78);
			if(flag1 == true && flag2 == true){
				Constant.log.info("test079_PrintTokenInTamil: Validate Print token in tamil checkbox is successful");
				extentTest.log(LogStatus.PASS, "Validate Print token in tamil checkbox is successful");
				testresultdata.put("80", new Object[] {79d, "Print token in tamil", "Token print is displayed","Pass"});
			}else{
				System.err.println("test079_PrintTokenInTamil: Validate first and last slots of reschedule pop up test case failed ");
				Constant.captureScreen_Negative("Print token in tamil");
				extentTest.log(LogStatus.FAIL, "Validation of Print token in tamil checkbox failed");
				testresultdata.put("80", new Object[] {79d, "Print token in tamil", "Token print is not displayed","Fail"});
			}
			Assert.assertTrue(flag1 == true && flag2 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Print token in tamil");
	}
	
	@Test
	public void test080_DiabeticCamp() throws Exception{
		Log.startTestCase("Diabetic Camp");
		extentTest = extent.startTest("Diabetic Camp", 
				"Validate whether diabetic camp token is displayed in report");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",79);
		try{
			boolean flag1 = receptionist.DiabeticCamp(79);
			if(flag1 == true){
				Constant.log.info("test080_DiabeticCamp: Diabetic camp token details is displayed in report");
				extentTest.log(LogStatus.PASS, "Validate whether diabetic camp token is displayed in report");
				testresultdata.put("81", new Object[] {80d, "Diabetic Camp", "Diabetic campt token details are displayed in report","Pass"});
			}else{
				System.err.println("test080_DiabeticCamp: Validate first and last slots of reschedule pop up test case failed ");
				Constant.captureScreen_Negative("Diabetic Camp");
				extentTest.log(LogStatus.FAIL, "Diabetic camp token is not displayed in report");
				testresultdata.put("81", new Object[] {80d, "Diabetic Camp", "Diabetic campt token details are not displayed in report","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Diabetic Camp");
	}
	
	@Test
	public void test081_MultipleId_close() throws Exception{
		Log.startTestCase("Multiple ID Close");
		extentTest = extent.startTest("Multiple ID Close", 
				"Validate whether token is alloted even if multiple id pop up is closed");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",80);
		try{
			boolean flag1 = receptionist.CloseMultipleIDPopUp(80);
			if(flag1 == true){
				Constant.log.info("test081_MultipleId_close: Token is alloted even if multiple patient id pop up is closed without selecting patient");
				extentTest.log(LogStatus.PASS, "Token is alloted even if multiple patient id pop up is closed without selecting patient");
				testresultdata.put("80", new Object[] {81d, "Multiple ID Close", "Token is alloted even if multiple patient id pop up is closed without selecting patient","Pass"});
			}else{
				System.err.println("test081_MultipleId_close: Token is not alloted when multiple patient id pop up is closed without selecting patient");
				Constant.captureScreen_Negative("Multiple ID Close");
				extentTest.log(LogStatus.FAIL, "Token is not alloted when multiple patient id pop up is closed without selecting patient");
				testresultdata.put("80", new Object[] {81d, "Multiple ID Close", "Token is not alloted when multiple patient id pop up is closed without selecting patient","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Multiple ID Close");
	}
	
	@Test
	public void test082_ApptBookedStatus_Report() throws Exception{
		Log.startTestCase("Appointment Booked status in report");
		extentTest = extent.startTest("Appointment Booked status verification in report", 
				"Validate appointment booked status is displayed in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",81);
		try{
			boolean flag1 = receptionist.bookedApptStatus(81);
			if(flag1 == true){
				Constant.log.info("test082_ApptBookedStatus_Report: Appointment Booked status is displayed in reports");
				extentTest.log(LogStatus.PASS, "Appointment Booked status is displayed in reports");
				testresultdata.put("81", new Object[] {82d, "Appointment Booked status in report", "Appointment Booked status is displayed in reports","Pass"});
			}else{
				System.err.println("test082_ApptBookedStatus_Report: Appointment Booked status is not displayed in reports");
				Constant.captureScreen_Negative("Appointment Booked status in report");
				extentTest.log(LogStatus.FAIL, "Appointment Booked status is not displayed in reports");
				testresultdata.put("81", new Object[] {82d, "Appointment Booked status in report", "Appointment Booked status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag1 == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Appointment Booked status in report");
	}
	
	@Test
	public void test083_AllotTokenForApptStatus_Report() throws Exception{
		Log.startTestCase("Allot token for appointment and check status in report");
		extentTest = extent.startTest("Allot token for appointment and check status in report", 
				"Validate Alloted token for appointment status is displayed in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",82);
		try{
			boolean flag = receptionist.AllotTokenForAppt_Status(82);
			if(flag == true){
				Constant.log.info("test083_AllotTokenForApptStatus_Report: Alloted token for appointment status is displayed in reports");
				extentTest.log(LogStatus.PASS, "Alloted token for appointment status is displayed in reports");
				testresultdata.put("82", new Object[] {83d, "Allot token for appointment and check status in report", "Alloted token for appointment status is displayed in reports","Pass"});
			}else{
				System.err.println("test083_AllotTokenForApptStatus_Report: Alloted token for appointment status is not displayed in reports");
				Constant.captureScreen_Negative("Alloted token for appointment status in report");
				extentTest.log(LogStatus.FAIL, "Alloted token for appointment status is not displayed in reports");
				testresultdata.put("82", new Object[] {83d, "Alloted token status in report", "Alloted token for appointment status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Alloted token for appointment status in report");
	}
	
	@Test
	public void test084_FutureDayApptStatus_Report() throws Exception{
		Log.startTestCase("Future day appointment status in report");
		extentTest = extent.startTest("Future day appointment status in report", 
				"Validate Future day appointment status is displayed in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",83);
		try{
			boolean flag = receptionist.FutureDayApt_Reports(83);
			if(flag == true){
				Constant.log.info("test084_FutureDayApptStatus_Report: Future day appointment status is displayed in reports");
				extentTest.log(LogStatus.PASS, "Future day appointment status is displayed in reports");
				testresultdata.put("83", new Object[] {84d, "Future day appointment status in report", "Future day appointment is displayed in reports","Pass"});
			}else{
				System.err.println("test084_FutureDayApptStatus_Report: Future day appointment status is not displayed in reports");
				Constant.captureScreen_Negative("Future day appointment status in report");
				extentTest.log(LogStatus.FAIL, "Future day appointment status is not displayed in reports");
				testresultdata.put("83", new Object[] {84d, "Future day appointment status in report", "Future day appointment status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Future day appointment status in report");
	}
	
	@Test
	public void test085_AllotTokenStatus_Report() throws Exception{
		Log.startTestCase("Alloted token status in report");
		extentTest = extent.startTest("Alloted token status verification in report", 
				"Validate Alloted token status is displayed in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",84);
		try{
			boolean flag = receptionist.AllotToken_Reports(84);
			if(flag == true){
				Constant.log.info("test085_AllotTokenStatus_Report: Alloted token status is displayed in reports");
				extentTest.log(LogStatus.PASS, "Alloted token status is displayed in reports");
				testresultdata.put("84", new Object[] {85d, "Alloted token status in report", "Alloted token status is displayed in reports","Pass"});
			}else{
				System.err.println("test085_AllotTokenStatus_Report: Alloted token status is not displayed in reports");
				Constant.captureScreen_Negative("Alloted token status in report");
				extentTest.log(LogStatus.FAIL, "Alloted token status is not displayed in reports");
				testresultdata.put("84", new Object[] {85d, "Alloted token status in report", "Alloted token status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Alloted token status in report");
	}
	
	@Test
	public void test086_RescheduleApt_Reports() throws Exception{
		Log.startTestCase("Reschedule appointment and check in reports");
		extentTest = extent.startTest("Reschedule appointment and check in reports", 
				"Validate rescheduled appointment status in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",85);
		try{
			boolean flag = receptionist.RescheduleApt_Reports(85);
			if(flag == true){
				Constant.log.info("test086_RescheduleApt_Reports: Rescheduled appointment status is displayed in the reports");
				extentTest.log(LogStatus.PASS, "Rescheduled appointment status is displayed in the reports");
				testresultdata.put("85", new Object[] {86d, "Reschedule appointment and check in reports", "Rescheduled appointment status is displayed in the reports","Pass"});
			}else{
				System.err.println("test086_RescheduleApt_Reports: Rescheduled appointment status is not displayed in reports");
				Constant.captureScreen_Negative("Reschedule appointment and check in reports");
				extentTest.log(LogStatus.FAIL, "Rescheduled appointment status is not displayed in reports");
				testresultdata.put("85", new Object[] {86d, "Reschedule appointment and check in reports", "Rescheduled appointment status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule appointment and check in reports");
	}
	
	@Test
	public void test087_RescheduleToken_Reports() throws Exception{
		Log.startTestCase("Reschedule Token and check in reports");
		extentTest = extent.startTest("Reschedule Token and check in reports", 
				"Validate rescheduled Token status in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",86);
		try{
			boolean flag = receptionist.RescheduledToken_Reports(86);
			if(flag == true){
				Constant.log.info("test087_RescheduleToken_Reports: Rescheduled Token status is displayed in the reports");
				extentTest.log(LogStatus.PASS, "Rescheduled Token status is displayed in the reports");
				testresultdata.put("86", new Object[] {87d, "Reschedule Token and check in reports", "Rescheduled Token status is displayed in the reports","Pass"});
			}else{
				System.err.println("test087_RescheduleApt_Reports: Rescheduled Token status is not displayed in reports");
				Constant.captureScreen_Negative("Reschedule Token and check in reports");
				extentTest.log(LogStatus.FAIL, "Rescheduled Token status is not displayed in reports");
				testresultdata.put("86", new Object[] {87d, "Reschedule Token and check in reports", "Rescheduled Token status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Reschedule Token and check in reports");
	}
	
	@Test
	public void test088_CancelAppt_Reports() throws Exception{
		Log.startTestCase("Cancel appointment and check status in reports");
		extentTest = extent.startTest("Cancel appointment and check status in reports", 
				"Validate cancelled appointment status in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",87);
		try{
			boolean flag = receptionist.CancelAptStatus_Reports(87);
			if(flag == true){
				Constant.log.info("test088_CancelAppt_Reports: Cancelled appointment status is displayed in the reports");
				extentTest.log(LogStatus.PASS, "Cancelled appointment status is displayed in the reports");
				testresultdata.put("87", new Object[] {88d, "Cancel appointment and check status in reports", "Cancelled appointment status is displayed in the reports","Pass"});
			}else{
				System.err.println("test088_CancelAppt_Reports: Cancelled appointment status is not displayed in reports");
				Constant.captureScreen_Negative("Cancel appointment and check status in reports");
				extentTest.log(LogStatus.FAIL, "Cancelled appointment status is not displayed in reports");
				testresultdata.put("87", new Object[] {88d, "Cancel appointment and check status in reports", "Cancelled appointment status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel appointment and check status in reports");
	}
	
	@Test
	public void test089_CancelFutureDayAppt_Reports() throws Exception{
		Log.startTestCase("Cancel future day appointment and check status in reports");
		extentTest = extent.startTest("Cancel future day appointment and check status in reports", 
				"Validate cancelled future day appointment status in reports");
		 extentTest.log(LogStatus.INFO, "Browser Launched");
		receptionist.login("Receptionist",88);
		try{
			boolean flag = receptionist.CancelAptStatus_FutureReport(88);
			if(flag == true){
				Constant.log.info("test088_CancelAppt_Reports: Cancelled future day appointment status is displayed in the reports");
				extentTest.log(LogStatus.PASS, "Cancelled future day appointment status is displayed in the reports");
				testresultdata.put("88", new Object[] {89d, "Cancel future day appointment and check status in reports", "Cancelled future day appointment status is displayed in the reports","Pass"});
			}else{
				System.err.println("test088_CancelAppt_Reports: Cancelled future day appointment status is not displayed in reports");
				Constant.captureScreen_Negative("Cancel future day appointment and check status in reports");
				extentTest.log(LogStatus.FAIL, "Cancelled future day appointment status is not displayed in reports");
				testresultdata.put("88", new Object[] {89d, "Cancel future day appointment and check status in reports", "Cancelled future day appointment status is not displayed in reports","Fail"});
			}
			Assert.assertTrue(flag == true);
		}catch(Exception e){
			System.err.println(e);
		}
		Log.endTestCase("Cancel future day appointment and check status in reports");
	}
	
    @After
	public void After() throws Exception{
    	receptionist.logout();
    	Thread.sleep(Constant.Min_Sleep);
    	extentTest.log(LogStatus.INFO, "Browser closed");
		// close report.
		extent.endTest(extentTest);
		// writing everything to document.
    	extent.flush();
		 //write excel file and file name is TestResult.xls 
		
    	Set<String> keyset = testresultdata.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = testresultdata.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof Date) 
                    cell.setCellValue((Date)obj);
                else if(obj instanceof Boolean)
                    cell.setCellValue((Boolean)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
            }
        }
        try {
            FileOutputStream out =new FileOutputStream(new File("MedicTestResults.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
	}
	
	@AfterClass
	public static void AfterClass() throws Exception{
		Constant.closeBrowser();
	}
}
