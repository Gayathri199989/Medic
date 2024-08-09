package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.ReadPropertyFile;

public class ReceptionistPage {
	
	ReadPropertyFile property = PageFactory.initElements(Constant.driver, ReadPropertyFile.class);
	
	@FindBy(id="username")
	private WebElement usernameTxt;
	
	@FindBy(id="password")
	private WebElement passwordTxt;
	
	@FindBy(id="btnMedicLogin")
	private WebElement loginBtn;
	
	@FindBy(id="user_login_id")
	private WebElement userLoginID;
	
	@FindBy(xpath=".//*[@id='update-slot']/div[2]/div/div/a")
	private List<WebElement> addPatientList;
	
	@FindBy(xpath=".//*[@id='postreschedule']/div[1]/span/label")
	private List<WebElement> rescheduleSlots;
	
	@FindBy(id="mobile_number")
	private WebElement mobileNumberTxt;
	
	@FindBy(xpath=".//div[@id='medic-checker']/span")
	private WebElement medicRegisterCheck;
	
	@FindBy(xpath=".//span[text()='Add Patient']")
	private WebElement addPatientLink;
	
	@FindBy(id="patient_first_name")
	private WebElement patientFirstNameTxt;
	
	@FindBy(id="patient_last_name")
	private WebElement patientLastNameTxt;
	
	@FindBy(id="bookingAppointment")
	private WebElement bookAppointmentBtn;
	
	@FindBy(xpath=".//label[text()='Female']")
	private WebElement femaleBtn;
	
	@FindBy(xpath=".//label[text()='Male']")
	private WebElement maleBtn;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/label[text()='Yes']")
	private WebElement smartPhoneYesBtn;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[3]/div[1]/div/div/div[2]/label[text()='No']")
	private WebElement smartPhoneNoBtn;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/label[text()='Yes']")
	private WebElement medicAppYesBtn;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[3]/div[2]/div/div/div[2]/label[text()='No']")
	private WebElement medicAppNoBtn;
	
	@FindBy(id="dateselector_day")
	private WebElement dayDropDwn;

	@FindBy(id="dateselector_month")
	private WebElement monthDropDwn;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[1]/div[6]/div/div/input[@class='select-dropdown']")
	private WebElement bloodGrpDrpDwn;
	
	@FindBy(id="dateselector_year")
	private WebElement yearDropDwn;

	@FindBy(id="address1")
	private WebElement address1Txt;
	
	@FindBy(id="address2")
	private WebElement areaTxt;
	
	@FindBy(id="careOf")
	private WebElement careOff;
	
	@FindBy(id="pincode")
	private WebElement pincodeTxt;
	
	@FindBy(id="email")
	private WebElement emailTxt;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[3]/div[2]/div[3]/div/div/input")
	private WebElement cityDropDwn;
	
	@FindBy(id="second_mobile")
	private WebElement secondMobile;
	
	@FindBy(id="updatePatient")
	private WebElement updatePatientBtn;
	
	@FindBy(xpath=".//button[text()='OK']")
	private WebElement updateOkBtn;
	
	@FindBy(id="remarks")
	private WebElement remarks;
	
	@FindBy(id="regPatient")
	private WebElement confirmToken;
	
	@FindBy(xpath=".//button[@class='cancel']")
	private WebElement cancelBtn;
	
	@FindBy(xpath=".//label[text()='Add']")
	private WebElement addButton;
	
	@FindBy(xpath=".//*[@id='dsel1']/div/span[7]/span[2]")
	private WebElement nextDay;
	
	@FindBy(xpath=".//*[@id='app-navbar-collapse']/ul[2]/li[2]/a")
	private WebElement logoutDropDwn;
	
	@FindBy(xpath=".//*[@id='app-navbar-collapse']/ul[2]/li[2]/ul/li[3]/a")
	private WebElement logoutBtn;
	
	@FindBy(id="symptoms")
	private WebElement symptoms;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[2]/div/div/div[2]/div[1]/div/div/div/input")
	private WebElement titleDropDown;
	
	@FindBy(id="edit_title")
	private WebElement title;
	
	@FindBy(xpath=".//input[@value='Choose patient']")
	private WebElement choosePatientDrpDwn;
	
	@FindBy(xpath=".//label[text()='View']")
	private WebElement viewTab;
	
	@FindBy(xpath=".//*[@id='mod_tbl']/tbody/tr/td[1]")
	private List<WebElement> viewMoreList;
	
	@FindBy(xpath=".//button[@class='close']")
	private WebElement close;
	
	@FindBy(xpath=".//input[@value='Walk-in']")
	private WebElement appointmentTypeDropDwn;
	
	@FindBy(xpath=".//span[text()='Phone']")
	private WebElement appointmentType;
	
	@FindBy(xpath=".//span[text()='ALLOT TOKEN']")
	private WebElement allotToken;
	
	@FindBy(xpath=".//span[text()='Title is required.']")
	private WebElement titleMandatory;
	
	@FindBy(xpath=".//span[text()='Please choose gender.']")
	private WebElement gender;
	
	@FindBy(xpath=".//span[text()='Date of birth is required.']")
	private WebElement dob;
	
	@FindBy(xpath=".//span[text()='Address is required.']")
	private WebElement address;
	
	@FindBy(xpath=".//span[text()='Please choose payment type.']")
	private WebElement paymentType;
	
	@FindBy(xpath=".//*[@id='advancedSearch']/div/div/div/button[@class='close']")
	private WebElement advancedSearchClose;
	
	@FindBy(xpath=".//*[@id='addpatient']/div[2]/button[1]")
	private WebElement searchPatient;

	@FindBy(id="advanceSearchFirstName")
	private WebElement sFirstName;
	
	@FindBy(id="advanceSearchLastName")
	private WebElement sLastName;
	
	@FindBy(id="advanceSearchMobile")
	private WebElement sMobile;
	
	@FindBy(id="advanceSearchPincode")
	private WebElement sPinCode;
	
	@FindBy(id="advanceWholeSearch")
	private WebElement sFilter;
	
	@FindBy(id="searchSubmitButton")
	private WebElement sSearch;
	
	@FindBy(xpath=".//button[text()='CANCEL']")
	private WebElement cancel;
	
	@FindBy(id="reSchedulePatient")
	private WebElement rescheduleBTN_AllotToken;
	
	@FindBy(xpath=".//*[@id='sfdate']/div[1]/div[2]/div/a")
	private WebElement nextDaySchedule_doctor;
	
	@FindBy(xpath=".//*[@id='refineSearch']/div[1]/div[2]/div/a")
	private WebElement nextDaySchedule_Reschedule;
	
	@FindBy(xpath=".//*[@id='refineSearch']/div[1]/div[1]/div/a")
	private WebElement presentDaySchedule_Reschedule;
	
	@FindBy(xpath=".//*[@id='postreschedule']/div[1]/span")
	private List<WebElement> slot_RescheduleList;
	
	@FindBy(id="btnRReschedule")
	private WebElement rescheduleBTN;
	
	@FindBy(id="cancelPatient")
	private WebElement cancelAptBtn;
	
	@FindBy(xpath=".//h2[text()='Are you sure?']/following::p[1]")
	private WebElement cancelMsg;
	
	@FindBy(xpath=".//input[@placeholder='Reason']")
	private WebElement cancelReason;
	
	@FindBy(xpath=".//a[text()='PRINT TOKEN']")
	private WebElement printTokenBtn;
	
	@FindBy(xpath=".//button[text()='Yes']")
	private WebElement yesBtn;
	
	@FindBy(xpath=".//i[text()='expand_more']")
	private WebElement expandMore;
	
	@FindBy(id="edit_firstname")
	private WebElement firstName;
	
	@FindBy(id="edit_lastname")
	private WebElement lastName;
	
	@FindBy(xpath=".//a[text()='PRINT BILL']")
	private WebElement printBillLnk;
	
	@FindBy(id="pat_age")
	private WebElement age_Gender;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[5]/span/img")
	private WebElement editPayment;
	
	@FindBy(xpath=".//input[@checked='checked']/following::label[1]")
	private WebElement cashOption;
	
	@FindBy(id="divHOSPITALFEE")
	private WebElement hospitalFee;
	
	@FindBy(id="divDOCTORFEE")
	private WebElement doctorFee;
	
	@FindBy(id="divLABFEE")
	private WebElement labFee;
	
	@FindBy(id="divMISCFEE")
	private WebElement miscFee;
	
	@FindBy(id="discount")
	private WebElement discount;
	
	@FindBy(id="amount_received")
	private WebElement amtReceived;
	
	@FindBy(id="total_fee")
	private WebElement totalFee;
	
	@FindBy(id="amount_balance")
	private WebElement amtBalance;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[6]/div[2]/div/div[1]/div/input")
	private WebElement selectFee;
	
	@FindBy(xpath=".//a[text()='ID CARD PRINT ']")
	private WebElement iDCardPrintLnk;
	
	@FindBy(id="pat_medicid")
	private WebElement medicID;
	
	@FindBy(xpath=".//label[text()='REFUND']")
	private WebElement refund;
	
	@FindBy(id="roundOff_fee")
	private WebElement roundOff;
	
	@FindBy(id="refund_amount")
	private WebElement refundAmt;
	
	@FindBy(id="search")
	private WebElement searchToken;
	
	@FindBy(id="btnSearch")
	private WebElement searchTokenBtn;
	
	@FindBy(xpath=".//*[@id='myModal3']/div/div/div[1]/div/div[2]/span/span")
	private WebElement docName_AllotToken;

	@FindBy(xpath=".//div[contains(@class,'d_unavailable')]")
	private List<WebElement> doctorsList;
	
	@FindBy(xpath=".//*[@id='London']/div[1]/div[2]/div/label/span")
	private WebElement showAvailDocLnk;
	
	@FindBy(xpath=".//*[@id='dlist']/div/div[1]/div[1]/a/span[2]")
	private WebElement slotIndicator;
	
	@FindBy(xpath=".//*[@id='London']/div[2]/div[1]/a")
	private WebElement selectDocs;
	
	@FindBy(id="txtSearchDoctor")
	private WebElement searchDocTxt;
	
	@FindBy(id="filterApplyChanges")
	private WebElement selectDoc_ApplyBtn;
	
	@FindBy(id="filterCancelChanges")
	private WebElement selectDoc_CancelBtn;
	
	@FindBy(id="filterClearChanges")
	private WebElement clearBtn;
	
	@FindBy(xpath=".//a[contains(.,'TODAY PATIENT STATUS')]")
	private WebElement viewTodayPatientStatus;
	
	@FindBy(xpath=".//button[text()='Cancel']")
	private WebElement reschduleCancel;
	
	@FindBy(xpath=".//*[@id='datepicker']/img")
	private WebElement calendar;
	
	@FindBy(xpath=".//*[@id='dsel1']/div/span[6]/span[2]")
	private WebElement dateDisplayed;
	
	@FindBy(xpath=".//div[1]/table/tfoot/tr[1]/th")
	private WebElement todayDateSelection;
	
	@FindBy(xpath=".//div[1]/table/thead/tr[2]/th[text()='»']")
	private WebElement nextMonth;
	
	@FindBy(xpath=".//div[1]/table/thead/tr[2]/th[2]")
	private WebElement currentMonth;
	
	@FindBy(xpath=".//div[1]/table/thead/tr[2]/th[text()='«']")
	private WebElement previousMonth;
	
	@FindBy(xpath=".//div[text()='Today']")
	private WebElement today;
	
	@FindBy(xpath=".//a[text()='REPORTS']")
	private WebElement reports;
	
	@FindBy(id="report_startDate")
	private WebElement report_StartDate;
	
	@FindBy(id="report_endDate")
	private WebElement report_EndDate;
	
	@FindBy(id="report_startTime")
	private WebElement report_StartTime;
	
	@FindBy(xpath=".//button[text()='AM']")
	private WebElement am;
	
	@FindBy(xpath=".//button[text()='PM']")
	private WebElement pm;
	
	@FindBy(id="report_endTime")
	private WebElement report_EndTime;
	
	@FindBy(id="report_patientFirstName")
	private WebElement report_FirstName;
	
	@FindBy(id="report_patientLastName")
	private WebElement report_LastName;
	
	@FindBy(id="report_DoctorName")
	private WebElement report_Doctor;
	
	@FindBy(xpath=".//div[4]/div/input[@value='CHOOSE']")
	private WebElement paymentMode;
	
	@FindBy(xpath=".//label[@class='active'][text()='MLC']")
	private WebElement MLC;
	
	@FindBy(xpath=".//*[@id='patient_reports']/div/div/div[3]/div[2]/div/input")
	private WebElement fieldReq;
	
	@FindBy(xpath=".//*[@id='postreport']/div/div[3]/div[1]/div/input")
	private WebElement appointmentStatus;
	
	@FindBy(xpath=".//input[@id='report_symptoms']")
	private WebElement symptomReport;
	
	@FindBy(xpath=".//ul[contains(@class,'active temp-show')]/li[@class='']/span")
	private List<WebElement> fieldReqList;
	
	@FindBy(xpath=".//span[contains(text(),'SELECT ALL')]")
	private WebElement selectAllCheckbox;
	
	@FindBy(id="report_search")
	private WebElement reportSearch;
	
	@FindBy(id="print_report")
	private WebElement reportPrint;
	
	@FindBy(id="report_userName")
	private WebElement reportUsername;
	
	@FindBy(xpath=".//label[@for='report_MLC']")
	private WebElement report_MLC;
	
	@FindBy(xpath=".//h4[text()='REPORTS']")
	private WebElement report_PopUp;
	
	@FindBy(id="cancel_report")
	private WebElement cancelReport;
	
	@FindBy(id="report_reset")
	private WebElement resetReport;	
	
	@FindBy(xpath=".//td[text()='Search result']")
	private WebElement SearchResult;
	
	@FindBy(id="export_report")
	private WebElement ExportReport;
	
	@FindBy(id="print_report")
	private WebElement PrintReport;
	
	@FindBy(xpath=".//a[text()='ADVANCED SEARCH']")
	private WebElement AdvancedSearch;
	
	@FindBy(xpath=".//div[1]/div/div/span[text()='Waiting']")
	private WebElement WaitingTab;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[2]/span[2]")
	private WebElement WaitingNum;
	
	@FindBy(xpath=".//*[@id='action']/div/div/div[2]/table/tbody/tr[2]/td[3]/a")
	private WebElement FirstPatient_Waiting;
	
	@FindBy(xpath=".//*[@id='action']/div/div/div[2]/table/tbody/tr[2]/td[2]/a")
	private WebElement FirstPatient_Remaining;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div/span[text()='Remaining ']")
	private WebElement RemainingTab;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[3]/span[2]")
	private WebElement RemainingNum;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[4]/span[text()='Lapsed']")
	private WebElement LapsedTab;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[4]/span[2]")
	private WebElement LapsedNum;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[5]/span[text()='Checked Out']")
	private WebElement CheckedOutTab;
	
	@FindBy(xpath=".//*[@id='dlist']/div[1]/div[1]/div[5]/span[2]")
	private WebElement CheckedOutNum;
	
	@FindBy(xpath=".//input[@id='rx_reference']")
	private WebElement DoctorRef;
	
	@FindBy(xpath=".//div[text()='Today']")
	private WebElement TodayBtn;
	
	@FindBy(xpath=".//p[text()='Profile Updated Successfully']")
	private WebElement ProfileUpdateMsg;
	
	@FindBy(xpath=".//*[@id='postassigntoken']/div[1]/div[6]/div[1]/div[1]/div/div/input")
	private WebElement AssociateDropDwn;
	
	@FindBy(id="ref_name")
	private WebElement RefNameTxt;
	
	@FindBy(id="ref_id")
	private WebElement RefIdTxt;
	
	@FindBy(id="age_cal_value")
	private WebElement Age;
	
	@FindBy(xpath=".//div[@class='row edit_assign_token ']/div/div/div/i[text()='done']")
	private WebElement MedicIDCheck;
	
	@FindBy(xpath=".//div[@class='row edit_assign_token ']/div/div/div/i[text()='clear']")
	private WebElement MedicIDUnCheck;
	
	@FindBy(xpath=".//*[@id='app-layout']/nav/div/div[1]/a/img")
	private WebElement MedicIcon;
	
	@FindBy(xpath=".//h2[text()='Success!']/following::p[1]")
	private WebElement SuccessMsg;
	
	@FindBy(xpath=".//span[text()='Mobile number is required.']")
	private WebElement Warning_Mobile;
	
	@FindBy(xpath=".//span[text()='First name is required.']")
	private WebElement Warning_FName;
	
	@FindBy(xpath=".//*[@id='dlist']/div/div[1]/div[1]/a/span")
	private List<WebElement> DoctorList;
	
	@FindBy(xpath=".//a[text()='CANCELLED APPOINTMENTS']")
	private WebElement CancelledApts;
	
	@FindBy(id="datepickerIcon")
	private WebElement DatePicker;
	
	@FindBy(id="showDate")
	private WebElement dateDisplayed_Cancelled;
	
	@FindBy(xpath=".//p[text()='Reason is required.']")
	private WebElement MandatoryMsg;
	
	@FindBy(xpath=".//*[@id='booked_appointment']/div/a")
	private List<WebElement> AreadyBookedAppt;
	
	@FindBy(xpath=".//a[contains(text(),'Change Password')]")
	private WebElement ChangePasswordBtn;
	
	@FindBy(id="current_password")
	private WebElement CurrentPwd;
	
	@FindBy(id="new_password")
	private WebElement NewPwd;
	
	@FindBy(id="confirm_password")
	private WebElement ConfirmPwd;
	
	@FindBy(id="updatePassword")
	private WebElement UpdatePwdBtn;
	
	@FindBy(xpath=".//button[text()='Close']")
	private WebElement ClosePwd;
	
	@FindBy(id="FilterText")
	private WebElement PatientStatusSearch;
	
	@FindBy(xpath=".//h4[text()='Change Password']")
	private WebElement ChangePasswordPopup;
	
	@FindBy(id="failure")
	private WebElement PwdChangeFailure;
	
	@FindBy(xpath=".//span[text()='Password Does Not Match']")
	private WebElement PwdDoesNotMatch;
	
	@FindBy(xpath=".//span[text()='Current Password is required.']")
	private WebElement Mandatory_CurrentPwdField;
	
	@FindBy(xpath=".//span[text()='Password is required.']")
	private WebElement Mandatory_NewPwdField;
	
	@FindBy(xpath=".//span[text()='Confirm password is required.']")
	private WebElement Mandatory_ConfirmPwdField;
	
	@FindBy(xpath=".//h1[text()='Print']")
	private WebElement PrintBtn;
	
	@FindBy(xpath=".//*[@id='report_list']/tr[1]/td[2]")
	private WebElement FirstPatientMultipleIdPopup;
	
	@FindBy(xpath=".//label[text()='PRINT TOKEN IN TAMIL']")
	private WebElement Print_Tamil;
	
	@FindBy(xpath=".//h4[text()='MULTIPLE PATIENT IDS AVAILABLE PLEASE CHOOSE']/preceding::button[1]")
	private WebElement MultipleIDPopUp_close;
	
	@FindBy(xpath=".//*[@id='report_list']/tr/td[13]")
	private List<WebElement> ReportStatusList;
	
	String sFName = "Test"+RandomStringUtils.randomAlphabetic(3).toLowerCase();
	String sLName = "Name"+RandomStringUtils.randomAlphabetic(3).toLowerCase();
	String sSymptom = "Test"+RandomStringUtils.randomAlphabetic(3);
	String Number = RandomStringUtils.randomNumeric(10);
	String TodayDate = Constant.NormalDateFormat();
	String TomorrowDate = Constant.NextDate();
	String date = Constant.NormalDateFormat().substring(0,2);
	String FName = "Test"+RandomStringUtils.randomAlphabetic(36).toLowerCase();
	String LName = "Name"+RandomStringUtils.randomAlphabetic(36).toLowerCase();
	String symptom = "Test"+RandomStringUtils.randomAlphabetic(36);
	
	private WebDriver driver;
	public ReceptionistPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * method to login to the application
	 * @param sheet
	 * @param rowNo
	 * @return true, if login is success
	 * @throws Exception
	 */
	public boolean login(String sheet, int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),sheet); 
		String username = xls.get(rowNo).get("UserName");
		String password = xls.get(rowNo).get("Password");
		String userID = xls.get(rowNo).get("UserID");
		String password2 = xls.get(rowNo).get("PasswordId");
		
		try{
			driver.navigate().to(property.getUrl_Medic());
			if(!driver.getPageSource().contains("K R HOSPITAL")){
		    	usernameTxt.sendKeys(username);
		    	passwordTxt.sendKeys(password);
		    	loginBtn.click();
		    	Thread.sleep(Constant.Min_Sleep);
			}
	    	userLoginID.sendKeys(userID);
	    	passwordTxt.sendKeys(password2);
	    	loginBtn.click();
	    	Thread.sleep(Constant.Medium_Sleep);
	    	if(addButton.isDisplayed()){
	    		flag = true;
	    	}
	    	
		}catch(Exception e){
			System.err.println("Login not successfull "+e);
		}
		return flag;
	}
	
	/**
	 * method to logout of the application
	 * @return true, if logout is successful
	 */
	
	public boolean logout(){
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();
			logoutBtn.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(userLoginID.isDisplayed()){
				flag = true;
				Constant.log.info("Logout is successfull");
			}
		}catch(Exception e){
			System.err.println("Logout not successfull "+e);
		}
		return flag;
	}
	
	/**
	 * To check the available patients for a doctor
	 * @return no. of patients avialable for the doctor
	 * @throws Exception
	 */
	
	public int AvailablePatients(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		int Value = 0;
		boolean value;
		value = PatientPresent();
		if(value == true){
   			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				Value = viewMoreList.size();
				close.click();
				Thread.sleep(Constant.Min_Sleep);
			}else{
				Value = driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size();
			}
		}
		return Value;
	}
	
	public void BookTokenOrAppointment(int rowNo, String BookingType) throws Exception{
		try{
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
					mobileNumberTxt.sendKeys(Number);
					Thread.sleep(Constant.Min_Sleep);
	    		if(medicRegisterCheck.getText().contains("Medic not registered.")){
	    			patientFirstNameTxt.sendKeys(sFName);
	    			patientLastNameTxt.sendKeys(sLName);
	    		}
	    		symptoms.sendKeys(sSymptom);
	    		if(BookingType.contains("Appointment")){
	    			appointmentTypeDropDwn.click();
		    		Thread.sleep(Constant.Min_Sleep);
		    		appointmentType.click();
		    		Thread.sleep(Constant.Min_Sleep);
		    		bookAppointmentBtn.click();
		    		Thread.sleep(Constant.Min_Sleep);
		    		updateOkBtn.click();
	    		}else{
	    			bookAppointmentBtn.click();	
	    		}
	    		Thread.sleep(Constant.Max_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to book appointment "+e);
		}
	}
	
	/**
	 * to allot token for a new unregistered patient
	 * @param rowNo
	 * @throws Exception 
	 */
	
	public String allotToken(int rowNo){
		String slot = null;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				String[] slotTime = SelectSlot().substring(0,8).split(" ");
				slot = slotTime[0]+":00 "+slotTime[1].toUpperCase();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo,"Token");
				Profileupdate(rowNo);
				Token_CashOption(rowNo);
			}
		}catch(Exception e){
			System.err.println("Allot token failed "+e);
		}
		return slot;
	}
	
	/**
	 * To add a new unregistered patient
	 * @param rowNo
	 * @return true, if token creation for a new patient is success
	 * @throws Exception
	 */
	
	public boolean AddNewPatient(int rowNo) throws Exception{
		boolean flag = false;
		int Value = 0;
		int ActValue = 0;
		try{
			Value = AvailablePatients(rowNo);
			allotToken(rowNo);
	    	 viewTab.click();
				ActValue = AvailablePatients(rowNo);
	    		if(ActValue>Value){
	    			flag = true;
	    		}
	    		
		}catch(Exception e){
			System.err.println("Unable to add new patient to allot token");
		}
    	return flag;
	}
	
	/**
	 * to update the profile of a patient
	 * @param rowNo
	 * @throws Exception
	 */
	
	public boolean Profileupdate(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sTitle = xls.get(rowNo).get("Title");
		String sDate = xls.get(rowNo).get("Birth Date");
		String sMonth = xls.get(rowNo).get("Birth month");
		String sYear = xls.get(rowNo).get("Birth year");
		String sBlood = xls.get(rowNo).get("Blood Group");
		String sCareOf = xls.get(rowNo).get("Care Of");
		String sAddress1 = xls.get(rowNo).get("Address 1");
		String sArea = xls.get(rowNo).get("Area");
		String sEmail = xls.get(rowNo).get("Email");
		String sCity = xls.get(rowNo).get("City");
		String sGender = xls.get(rowNo).get("Gender");
		boolean flag = false;
		try{
			if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
			    WebDriverWait wait = new WebDriverWait(Constant.driver, 10); 
			    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(titleDropDown));
			    element.click();
			    Thread.sleep(Constant.Min_Sleep);
			    Constant.driver.findElement(By.xpath(".//ul/li/span[text()='"+sTitle+"']")).click();
			    Thread.sleep(Constant.Min_Sleep);  
			    secondMobile.clear();
			   secondMobile.sendKeys(Number);
			    if(sGender.contains("Male")){
			    	maleBtn.click();
			    }else{
			    	femaleBtn.click();
			    }
			    smartPhoneYesBtn.click();
			    medicAppYesBtn.click();
			    Select selectDay = new Select(dayDropDwn);
			    selectDay.selectByValue(sDate);
			    Select selectMonth = new Select(monthDropDwn);
			    selectMonth.selectByValue(sMonth);
			    Select selectYear = new Select(yearDropDwn);
			    selectYear.selectByValue(sYear);
			    bloodGrpDrpDwn.click();
			    Thread.sleep(Constant.Min_Sleep);
			    Constant.driver.findElement(By.xpath(".//span[text()='"+sBlood+"']")).click();
			    careOff.clear();
			    careOff.sendKeys(sCareOf);
			    address1Txt.clear();
			    address1Txt.sendKeys(sAddress1);
			    cityDropDwn.click();
			    Thread.sleep(Constant.Min_Sleep);
			   	Constant.driver.findElement(By.xpath(".//span[text()='"+sCity+"']")).click();
			   	areaTxt.clear();
			    areaTxt.sendKeys(sArea);
			    Constant.driver.findElement(By.xpath(".//a[text()='"+sArea+"']")).click();
			    emailTxt.clear();
			   	emailTxt.sendKeys(sEmail);
			   	MLC.click();
			   	updatePatientBtn.click();
			   	Thread.sleep(Constant.Medium_Sleep);
			   	if(ProfileUpdateMsg.isDisplayed()){
			   		flag = true;
			   	}
			   	updateOkBtn.click();
				Thread.sleep(Constant.Medium_Sleep);
			}
		}catch(Exception e){
			System.err.println("Unable to update profile"+e);
		}
		return flag;
	}
	
	/**
	 * to add a new patient with registered number
	 * @param rowNo
	 * @return true, if able to create token for a new patient
	 * @throws Exception
	 */
	
	public boolean AddPatient_RegNo(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String number = xls.get(rowNo).get("Mobile Number");
    	int Value = 0;
		int ActValue = 0;
		try{
			Value = AvailablePatients(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
	    	if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
	    		mobileNumberTxt.sendKeys(number);
	    		addPatientLink.click();
				patientFirstNameTxt.sendKeys(sFName);
				patientLastNameTxt.sendKeys(sLName);
				symptoms.sendKeys(sSymptom);
				bookAppointmentBtn.click();	
			    Thread.sleep(Constant.Max_Sleep);
			    Profileupdate(rowNo);
			    Token_CashOption(rowNo);
	    	 }
	    	 viewTab.click();
	    	 ActValue = AvailablePatients(rowNo);
	    		if(ActValue>Value){
	    			flag = true;
	    		}
			}catch(Exception e){
				System.err.println("Unable to book token for new patient"+e);
			}
    	return flag;
    }
	
	/**
	 * to verify if any patient is present for doctor
	 * @return true, if patient is present
	 */
	
	public boolean PatientPresent(){
		boolean flag = false;
		try{
			if(!(WaitingNum.getText().contains("-") && RemainingNum.getText().contains("-") && LapsedNum.getText().contains("-") && CheckedOutNum.getText().contains("-"))){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("No patient is available"+e);
		}
		return flag;
	}
	
	/**
	 * To allot token for a patient who is already registered
	 * @param rowNo
	 * @return true, if able to allot token for registered patient
	 * @throws Exception
	 */
	
	public boolean Add_AvailablePatient(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String number = xls.get(rowNo).get("Mobile Number");
		String sSymptom = xls.get(rowNo).get("Symptom");
		String sName = xls.get(rowNo).get("Name");
		int Value = 0;
		int ActValue = 0;
		try{
			Value = AvailablePatients(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
	    		mobileNumberTxt.sendKeys(number);
	    		Thread.sleep(Constant.Min_Sleep);
	    		if(choosePatientDrpDwn.isDisplayed()){
	    			choosePatientDrpDwn.click();
	    			Thread.sleep(Constant.Min_Sleep);
	    			Constant.driver.findElement(By.xpath(".//ul/li/span[text()='"+sName+" ']")).click();
	    		}
	    		symptoms.sendKeys(sSymptom);
	    		Constant.driver.findElement(By.xpath(".//a[text()='"+sSymptom+"']")).click();
	    		bookAppointmentBtn.click();	
			    Thread.sleep(Constant.Max_Sleep);
			    Token_CashOption(rowNo);
			    viewTab.click();
			    ActValue = AvailablePatients(rowNo);
	    		if(ActValue>Value){
	    			flag = true;
	    		}
			}
		}catch(Exception e){
			System.err.println("unable to add token for registered patient"+e);
		}
		return flag;
	}
	
	/**
	 * to select payment option and confirm token
	 * @throws Exception
	 */
	
	public boolean Token_CashOption(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sOption = xls.get(rowNo).get("Cash Option");
		try{
			driver.findElement(By.xpath(".//label[text()='"+sOption+"']")).click();
			remarks.sendKeys("Test"+Number);
			confirmToken.click();
			Thread.sleep(Constant.Medium_Sleep);
			if(driver.getPageSource().contains("MULTIPLE PATIENT IDS AVAILABLE PLEASE CHOOSE")){
				FirstPatientMultipleIdPopup.click();
				flag = true;
			}
			cancelBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Unable to select cash options "+e);
		}
		return flag;
	}
	
	/**
	 * To enter data for all the fee avialable
	 * @param rowNo
	 * @throws Exception
	 */
	public void Fee(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String Amount = xls.get(rowNo).get("Amount");
		String sDiscount = xls.get(rowNo).get("Discount");
		String sOption = xls.get(rowNo).get("Cash Option");
		try{
			driver.findElement(By.xpath(".//label[text()='"+sOption+"']")).click();
			if(sOption.equals("FREE") || sOption.equals("PAID")){
				remarks.sendKeys("Test"+Number);
			}
			selectFee.click();
			Thread.sleep(Constant.Min_Sleep);
			List<WebElement> element = driver.findElements(By.xpath(".//div[@class='select-wrapper dropdown_fee_type']/ul/li/span")); 
			for(int i=3; i<element.size(); i++){
				if(!element.get(i).isSelected()){
					element.get(i).click();
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			hospitalFee.clear();
			hospitalFee.sendKeys(Amount);
			doctorFee.clear();
			doctorFee.sendKeys(Amount);
			labFee.clear();
			labFee.sendKeys(Amount);
			miscFee.clear();
			miscFee.sendKeys(Amount);
			discount.clear();
			discount.sendKeys(sDiscount);
			String fee = totalFee.getAttribute("value").substring(0, 3);
			int ActFee = (Integer.parseInt(Amount)*4)*(Integer.parseInt(sDiscount))/100;
			int Total = ((Integer.parseInt(Amount)*4)-ActFee);
			int ActTotal = (Integer.parseInt(fee));
			if(ActTotal == Total){
				Log.info("Total fee is calculated correctely");
			}
			if(sOption.contains("CASH")){
				amtReceived.sendKeys("500");
				String Balance = amtBalance.getAttribute("value");
				int Value = 500 - Total;
				if(Value == (Integer.parseInt(Balance))){
					Log.info("Balance amount is calculated correctely");
				}
				Thread.sleep(Constant.Min_Sleep);
			}
			confirmToken.click();
			Thread.sleep(Constant.Medium_Sleep);
			cancelBtn.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Fee amount calculation not correct "+e);
		}
		
	}
	
	/**
	 * to select the slot from add tab 
	 */
	public String SelectSlot(){
		String slotTime = null;
		for(int i=1;i<addPatientList.size();i++){
			List <WebElement> list = addPatientList;
			if(list.get(i).getText().contains("4/4")){
				i++;
			}else{
				list.get(i).click();
				slotTime = list.get(i).getText();
				break;
			}
		}
		return slotTime;
	}
	
	/**
	 * to select slot from reschedule pop up
	 */
	public void SelectSlot_Reschedule(){
		
		for(int i=0;i<slot_RescheduleList.size();i++){
			List <WebElement> list = slot_RescheduleList;
			if(list.get(i).getText().contains("4/4")){
				i++;
			}else{
				list.get(i).click();
				break;
			}
		}
	}
	
	/**
	 * to book an appointment
	 * @param rowNo
	 * @return true, if booking appointment is successful
	 * @throws Exception
	 */
	
	public boolean BookAppointment(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String number = xls.get(rowNo).get("Mobile Number");
		String sSymptom = xls.get(rowNo).get("Symptom");
		String sName = xls.get(rowNo).get("Name");
		int Value = 0;
		int ActValue = 0;
		try{

			 Value = AvailablePatients(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
	    		mobileNumberTxt.sendKeys(number);
	    		Thread.sleep(Constant.Min_Sleep);
	    		choosePatientDrpDwn.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		Constant.driver.findElement(By.xpath(".//span[text()='"+sName+" ']")).click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		symptoms.sendKeys(sSymptom);
	    		Constant.driver.findElement(By.xpath(".//a[text()='"+sSymptom+"']")).click();
	    		appointmentTypeDropDwn.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		appointmentType.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		bookAppointmentBtn.click();	
			    Thread.sleep(Constant.Medium_Sleep);
			    updateOkBtn.click();
			    Thread.sleep(Constant.Min_Sleep);
			}
			  viewTab.click();

			  ActValue = AvailablePatients(rowNo);
	    		if(ActValue>Value){
	    			flag = true;
	    		}
			
		}catch(Exception e){
			System.err.println("unable to book appointment"+e);
		}
		return flag;
	}
	
	/**
	 * To verify mandatory fields in Allot token page
	 * @param rowNo
	 * @return true, if mandatory field check is success
	 * @throws Exception
	 */
	
	public boolean MandatoryFields(int rowNo) throws Exception{
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo,"Token");
			confirmToken.click();
			Thread.sleep(Constant.Min_Sleep);
			allotToken.click();
			if(titleMandatory.isDisplayed() && gender.isDisplayed() && dob.isDisplayed() && address.isDisplayed()){
				flag = true;
			}
			Constant.driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to check mandatory fields"+e);
		}
		
		return flag;
	}
	
	/**
	 * Search patient from Add a patient pop up with out using filter field
	 * @param rowNo
	 * @return true, if searching patient is successful
	 * @throws Exception
	 */
	
	public boolean SearchPatient_withoutFilter(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String FName = xls.get(rowNo).get("First Name search");
		String LName = xls.get(rowNo).get("Last Name search");
		String sNumber = xls.get(rowNo).get("Mobile Number");
		String PinCode = xls.get(rowNo).get("Pin Code");
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){          
				searchPatient.click();
				Thread.sleep(Constant.Min_Sleep);
				sFirstName.sendKeys(FName);
				sLastName.sendKeys(LName);
				sMobile.sendKeys(sNumber);
				sPinCode.sendKeys(PinCode);
				sSearch.click();
				String[] array = {"1", FName,LName,sNumber,PinCode};
				ArrayList<String> actList = new ArrayList<String>();
				List<WebElement> elements = Constant.driver.findElements(By.xpath(".//*[@id='tblsearchresult']/tr[1]/td"));
				for(WebElement ele:elements){
					String element = ele.getText();
					actList.add(element);
				}
				for(int i=0;i<array.length;i++){
					if(actList.contains(array[i])){
						flag = true;
					}
				}
				advancedSearchClose.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Failed to check Search patients without filter"+e);
		}
		return flag;
	}
	
	/**
	 * Search patient from Add a patient pop up by using filter field
	 * @param rowNo
	 * @return true, if searching patient is successful
	 * @throws Exception
	 */
	public boolean SearchPatient_WithFilter(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String FName = "test";
		String Filter = xls.get(rowNo).get("Filter Search");
		try{
			Constant.driver.navigate().refresh();
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
				searchPatient.click();
				Thread.sleep(Constant.Min_Sleep);
				sFirstName.sendKeys(FName);
				sSearch.click();
				sFilter.sendKeys(Filter);
				String element = Constant.driver.findElement(By.xpath(".//td[5][text()='"+Filter+"']")).getText();
				if(element.contains(Filter)){
					flag = true;
				}
			}
			advancedSearchClose.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to check search patients with filter"+e);
		}
		return flag;
	}
	
	/**
	 * To verify cancel button in Add a patient pop up
	 * @return true, if cancel button is working properly
	 */
	public boolean CancelBtn_Add(){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
				cancel.click();
				if(addButton.isDisplayed()){
					flag=true;
				}
			}
		}catch(Exception e){
			System.err.println("Failed to cancel button in Add patient pop up"+e);
		}
		return flag;
	}
	
	/**
	 * to reschedule an appointment
	 * @param FName
	 * @return true, if reschedule of the appointment is success           
	 * @throws Exception
	 */
	
	public boolean Reschedule(String FName, int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		int actDate;
		boolean value;
		try{
			selectPatient(FName,rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
				rescheduleBTN_AllotToken.click();
				Thread.sleep(Constant.Min_Sleep);
				nextDaySchedule_Reschedule.click();
				SelectSlot_Reschedule();
				rescheduleBTN.click();
				Thread.sleep(Constant.Min_Sleep);
				updateOkBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			String lastDateOfMonth = Constant.lastDateOfMonth();
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			Constant.driver.findElement(By.xpath(".//span/span[text()='"+actDate+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			viewTab.click();
			value = PatientPresent();
			if(value == true){
				if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
					driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.driver.findElement(By.linkText(FName)).isDisplayed()){
						flag = true;
					}
					close.click();
					Thread.sleep(Constant.Min_Sleep);
				}else{
					if(Constant.driver.findElement(By.xpath(".//div[text()='"+FName+"']")).isDisplayed()){
						flag = true;
					}
				}
			}
			
		}catch(Exception e){
			System.err.println("Reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * to create appointment and reschedule it to next day
	 * @return true, if reschedule is success
	 * @throws Exception 
	 */
	
	public boolean RescheduleAppointment(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			Thread.sleep(Constant.Min_Sleep);
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			flag = Reschedule(sFName, rowNo);
		}catch(Exception e){
			System.err.println("Reschedule appoinment failed"+e);
		}
		return flag;
	}
	
	/**
	 * to reschedule token
	 * @param rowNo
	 * @return true, if reschedule token is success
	 */
	
	public boolean RescheduleToken(int rowNo){
		boolean flag = false;
		try{
			allotToken(rowNo);
			flag = Reschedule(sFName, rowNo);
		}catch(Exception e){
			System.err.println("Reschedule Token failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate print token data from token creation success message
	 * @param rowNo
	 * @return true, if print token data validation is success
	 * @throws Exception
	 */
	
	public boolean PrintToken_PopUp(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Token");
			    Profileupdate(rowNo);
			    String sDoctor = docName_AllotToken.getAttribute("innerHTML").substring(5).toUpperCase();
			    String Age = age_Gender.getAttribute("value").substring(0, 6).trim();
			    expandMore.click();
			    String titleTxt = titleDropDown.getAttribute("value").toUpperCase();
			    String sname = titleTxt+". "+sFName.toUpperCase()+"  "+sLName.toUpperCase();
			    confirmToken.click();
				Thread.sleep(Constant.Medium_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(reschduleCancel.isDisplayed()){
					reschduleCancel.click();
					 flag = true;
				}
//				Robot rb =new Robot();
//				rb.keyPress(KeyEvent.VK_ESCAPE);
//				rb.keyRelease(KeyEvent.VK_ESCAPE);
//				Thread.sleep(Constant.Min_Sleep);
				driver.navigate().refresh();
				flag = true;
//				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//				JavascriptExecutor js = (JavascriptExecutor)driver.getWindowHandles();
//				String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				String[] array = sText.split("\\r?\\n");
//				    
//				if(array[12].contains(sDoctor)  && array[21].contains(sname) && array[28].contains(sSymptom.toUpperCase()) && array[23].contains(Age)){
//				   	flag = true;   	
//				}
//				driver.close();
//				driver.switchTo().window(tabs2.get(0));
//				Thread.sleep(Constant.Min_Sleep);
//				rb.keyPress(KeyEvent.VK_ESCAPE);
//				rb.keyRelease(KeyEvent.VK_ESCAPE);
//				Thread.sleep(Constant.Min_Sleep);
			
		}catch(Exception e){
			System.err.println("Print Token from Pop up failed"+e);
		}
		return flag;
	}
	
	/**
	 * To select patient from view tab
	 * @param sFName
	 * @return 
	 * @throws Exception 
	 */
	
	public boolean selectPatient(String sFName, int rowNo) throws Exception{
		boolean flag = false;  
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		try{
			viewTab.click();
			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				Constant.driver.findElement(By.linkText(sFName)).click();
				flag = true;
			}else{
				Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']")).click();
				flag = true;
			}
		}catch(Exception e){
			System.err.println("unable to select the patient "+e);
		}
		return flag;
	}
	
	/**
	 * To validate print token data by clicking on the link from allot token page
	 * @param rowNo
	 * @return true, if print token data validation is success
	 * @throws Exception
	 */
	public boolean PrintToken_Lnk(int rowNo) throws Exception{
		boolean flag = false;
		try{
	    	selectPatient(sFName, rowNo);
			    Thread.sleep(Constant.Medium_Sleep);
			    String sDoctor = docName_AllotToken.getAttribute("innerHTML").substring(5).toUpperCase();
			    String Age = age_Gender.getAttribute("value").substring(0, 6);
			    expandMore.click();
			    String titleTxt = titleDropDown.getAttribute("value").toUpperCase();
			    String sname = titleTxt+". "+sFName.toUpperCase()+"  "+sLName.toUpperCase();
				Thread.sleep(Constant.Min_Sleep);
				printTokenBtn.click();
				Thread.sleep(Constant.Min_Sleep);
//				Robot rb =new Robot();
//				rb.keyPress(KeyEvent.VK_ESCAPE);
//				rb.keyRelease(KeyEvent.VK_ESCAPE);
//				Thread.sleep(Constant.Min_Sleep);
				driver.navigate().refresh();
				flag = true;
//				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				    driver.switchTo().window(tabs2.get(1));
//				    JavascriptExecutor js = (JavascriptExecutor)driver;
//				    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				    String[] array = sText.split("\\r?\\n");
//				    
//				    if(array[12].contains(sDoctor) && array[21].contains(sname) && array[28].contains(sSymptom.toUpperCase()) && array[23].contains(Age)){
//				    	flag = true;
//				    	
//				    }
//				    driver.close();
//				    driver.switchTo().window(tabs2.get(0));
//				    Thread.sleep(Constant.Medium_Sleep);
					
		}catch(Exception e){
			System.err.println("Print Token from Pop up failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate print bill data by click on the link from allot token page
	 * @param rowNo
	 * @return true, if print bill data validation is success
	 * @throws Exception
	 */
	public boolean printBill(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sTitle = xls.get(rowNo).get("Title").toUpperCase();
		String sAddress1 = xls.get(rowNo).get("Address 1").toUpperCase();
		String sArea = xls.get(rowNo).get("Area").toUpperCase();
		String sCity = xls.get(rowNo).get("City").toUpperCase();
		String sDate = Constant.NormalDateFormat();
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Token");
			Profileupdate(rowNo);
			Fee(rowNo);
	    	selectPatient(sFName,rowNo);
				Thread.sleep(Constant.Min_Sleep);
				 expandMore.click();
				 String sPinCode = pincodeTxt.getAttribute("value");
				editPayment.click();
				String sCashOption = cashOption.getText().toUpperCase();
				String sHospitalFee = hospitalFee.getAttribute("value");
				String sDoctorFee = doctorFee.getAttribute("value");
				String sLabFee = labFee.getAttribute("value");
				String sMiscFee = miscFee.getAttribute("value");
				String sDiscount = discount.getAttribute("value");
				String sFee = totalFee.getAttribute("value").substring(0, 3);
				printBillLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				flag = true;
//				String name = sTitle+"."+" "+sFName.toUpperCase()+"  "+sLName.toUpperCase();      
//				
//				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				    driver.switchTo().window(tabs2.get(1));
//				    JavascriptExecutor js = (JavascriptExecutor)driver;
//				    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				    String[] array = sText.split("\\r?\\n");
//				    
//				    if(array[14].contains(name) && array[16].contains(sAddress1) && array[17].contains(sArea) && array[18].contains(sCity) && array[19].contains(sPinCode)
//				    		&& array[23].contains(DATE) && array[26].contains(cashOption) && array[32].contains(hospitalFee) && array[35].contains(sDoctorFee) 
//				    		&& array[38].contains(labFee) && array[41].contains(miscFee) && array[43].contains(discount) && array[45].contains(fee)){
//				    	flag = true;
//				    	
//				    }
//				    driver.close();
//				    driver.switchTo().window(tabs2.get(0));
//					Thread.sleep(Constant.Min_Sleep);
					Constant.driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Print Bill from Pop up failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate data if ID card print
	 * @param rowNo
	 * @return true, if Id card print data validation is success
	 * @throws Exception
	 */
	public boolean IDCardPrint(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sTitle = xls.get(rowNo).get("Title").toUpperCase();
		String sCareOf = xls.get(rowNo).get("Care Of");
		String sAddress1 = xls.get(rowNo).get("Address 1").toUpperCase().substring(0, 17);
		String sArea = xls.get(rowNo).get("Area").toUpperCase();
		String sCity = xls.get(rowNo).get("City").toUpperCase();
		try{
			allotToken(rowNo);
	    	selectPatient(sFName, rowNo);
				Thread.sleep(Constant.Min_Sleep);
				String name = sTitle+"."+" "+sFName.toUpperCase()+"  "+sLName.toUpperCase();
				 String Age = age_Gender.getAttribute("value").substring(0, 6);
				String sMedicID = medicID.getAttribute("value").substring(12);
				iDCardPrintLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				flag = true;
//				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				    String[] array = sText.split("\\r?\\n");
//				    if(array[12].contains(name.subSequence(0, 17)) && array[14].contains(sCareOf) && array[16].contains(sArea) && array[17].contains(sCity) && array[15].contains(sAddress1)
//				    		&& array[18].contains(Date) && array[13].contains(Age) && array[19].contains(sMedicID)){
//				    	flag = true;
//				    	
//				    }
//				    driver.close();
//				    driver.switchTo().window(tabs2.get(0));
//					Thread.sleep(Constant.Medium_Sleep);
					Constant.driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("ID Card Print failed"+e);
		}
		return flag;
	}
	
	/**
	 * To search token
	 * @param rowNo
	 * @return true, if token is searched successfully
	 * @throws Exception 
	 */
	public boolean SearchToken(int rowNo) throws Exception{
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sDoctor = xls.get(rowNo).get("Doctor Name"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		String token;
		String age;
		String sMedicId;
		try{
			allotToken(rowNo);
			viewTab.click();
			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				token = Constant.driver.findElement(By.xpath(".//td/a[contains(text(),'"+sFName+"')]/preceding::td[1]")).getText();    
				Constant.driver.findElement(By.linkText(sFName)).click();
			}else{
				token = Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']/following::span[1]")).getText();
				Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']")).click();
			}
			Thread.sleep(Constant.Min_Sleep);
			age = age_Gender.getAttribute("value").substring(0, 6);
			sMedicId = medicID.getAttribute("value");
			Constant.driver.navigate().refresh();
			searchToken.sendKeys(token);
			searchTokenBtn.click();   
			WebElement ele = driver.findElement(By.xpath(".//tr[2]/td[text()='"+token+"']/following::td[text()='"+sFName+"']/following::td[contains(text(),'"+age+"')]/following::td[text()='"+Number+"']/following::td[contains(text(),'"+sDoctor+"')]"));
			Thread.sleep(Constant.Min_Sleep);
			 if(ele.isDisplayed()){
				flag1 = true;
			 }
			Constant.driver.navigate().refresh();
			searchToken.sendKeys(sMedicId);
			searchTokenBtn.click();   
			WebElement element = driver.findElement(By.xpath(".//tr[2]/td[text()='"+token+"']/following::td[text()='"+sFName+"']/following::td[contains(text(),'"+age+"')]/following::td[text()='"+Number+"']/following::td[contains(text(),'"+sDoctor+"')]"));
			Thread.sleep(Constant.Min_Sleep);
			 if(element.isDisplayed()){
				flag2 = true;
			 }	
			 Constant.driver.navigate().refresh();
			 if(flag1 == true && flag2 == true){
				 flag = true;
			 }
		}catch(Exception e){
			System.err.println("Search token failed"+e);
		}
		return flag;
	}
	
	public boolean SearchMedicId(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		String token;
		try{
			viewTab.click();
			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				token = Constant.driver.findElement(By.xpath(".//td/a[contains(text(),'"+sFName+"')]/preceding::td[1]")).getText();    
				flag = true;
			}else{
				token = Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']/following::span[1]")).getText();
			}
			Constant.driver.navigate().refresh();
			selectPatient(sFName,rowNo);
			String sMedicId = medicID.getText();
			Constant.driver.navigate().refresh();
			 searchToken.sendKeys(sMedicId);
			 searchTokenBtn.click();   
			 WebElement ele = driver.findElement(By.xpath(".//tr[2]/td[text()='"+token+"']/following::td[text()='"+sFName+"']/following::td[text()='"+age_Gender+"']/following::td[text()='"+Number+"']/following::td[text()='Dr. Anandanathan ']"));
			 Thread.sleep(Constant.Min_Sleep);
			 if(ele.isDisplayed()){
				flag = true;
			 }
			Constant.driver.navigate().refresh();
		}catch(Exception e){
			System.err.println(""+e);
		}
		return flag;
	}
	
	/**
	 * To Show available doctor for that day
	 * @return true, if available doctor's shown correctly
	 */
	public boolean ShowAvalDoc(){
		boolean flag = false;
		try{
			if(showAvailDocLnk.isDisplayed()){
				if(slotIndicator.isDisplayed()){
					showAvailDocLnk.click();
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					Thread.sleep(Constant.Min_Sleep);       
					for(WebElement ele:doctorsList){
						if(!ele.isSelected()){
							flag = true;
						}
					}
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-10050)", "");
  					showAvailDocLnk.click();
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					if(slotIndicator.isDisplayed()){
						js.executeScript("window.scrollBy(0,-10050)", "");
						flag = true;
					}
				}else{
					showAvailDocLnk.click();
					JavascriptExecutor js = ((JavascriptExecutor) driver);
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					Thread.sleep(Constant.Min_Sleep);
					js.executeScript("window.scrollBy(0,-10050)", "");
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Show Available Doctor failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate Apply button in Select Doctors and departments pop up
	 * @param rowNo
	 * @return true, if apply button is working correctly
	 * @throws Exception
	 */
	public boolean SelectDoc_ApplyBtn(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		try{
			if(selectDocs.isDisplayed()){
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				searchDocTxt.sendKeys(sDoctor);
				driver.findElement(By.xpath(".//label[contains(text(),'"+sDoctor+"')]")).click();
				selectDoc_ApplyBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath(".//span[contains(.,'"+sDoctor+"')]")).isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Apply button validation failed");
		}
		return flag;
	}
	
	/**
	 * To validate Cancel button in Select Doctors and departments pop up
	 * @param rowNo
	 * @return true, if cancel button is working correctly
	 * @throws Exception
	 */
	
	public boolean SelectDoc_CancelBtn(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String selectedDoctor = xls.get(rowNo).get("Doctor Name");
		String sDoctor = xls.get(rowNo).get("Token Alloted Doctor");
		try{
			if(selectDocs.isDisplayed()){
				selectDocs.click();   
				Thread.sleep(Constant.Min_Sleep);
				searchDocTxt.sendKeys(selectedDoctor);
				driver.findElement(By.xpath(".//label[contains(.,'"+selectedDoctor+"')]")).click();
				selectDoc_CancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath(".//span[contains(.,'"+sDoctor+"')]")).isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Cancel button validation failed");
		}
		return flag;
	}
	
	/**
	 * To validate clear button in Select Doctors and departments pop up
	 * @param rowNo
	 * @return true, if clear button is working correctly
	 * @throws Exception
	 */
	
	public boolean SelectDoc_ClearYesBtn(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String selectedDoctor = xls.get(rowNo).get("Doctor Name");
		String sDoctor = xls.get(rowNo).get("Token Alloted Doctor");
		try{
			if(selectDocs.isDisplayed()){
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				searchDocTxt.sendKeys(selectedDoctor);
				driver.findElement(By.xpath(".//label[contains(.,'"+selectedDoctor+"')]")).click();
				selectDoc_ApplyBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				clearBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath(".//span[contains(.,'"+sDoctor+"')]")).isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Clear button validation failed");
		}
		return flag;
	}
	
	/**
	 * To validate cancel button displayed in Clear pop up of Select department and doctors pop up
	 * @param rowNo
	 * @return true, if cancel button works properly in clear pop up
	 * @throws Exception
	 */
	public boolean SelectDoc_ClearCancelBtn(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		try{
			if(selectDocs.isDisplayed()){
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				searchDocTxt.sendKeys(sDoctor);
				driver.findElement(By.xpath(".//label[contains(.,'"+sDoctor+"')]")).click();
				selectDoc_ApplyBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				clearBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				cancelBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(searchDocTxt.isDisplayed()){
					flag = true;
				}
				selectDoc_CancelBtn.click();
			}
		}catch(Exception e){
			System.err.println("Clear button validation failed");
		}
		return flag;
	}
	
	/**
	 * To validate whether patient status is updated in view patient status link
	 * @param rowNo
	 * @return true, if patient status is updated successfully
	 * @throws Exception 
	 */
	public boolean PatientStatus(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		String token;
		String age;
		try{
			allotToken(rowNo);
			viewTab.click();
			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				token = Constant.driver.findElement(By.xpath(".//td/a[contains(text(),'"+sFName+"')]/preceding::td[1]")).getText();    
				Constant.driver.findElement(By.linkText(sFName)).click();
			}else{
				token = Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']/following::span[1]")).getText();
				Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']")).click();
			}
			Thread.sleep(Constant.Min_Sleep);
			age = age_Gender.getAttribute("value").substring(0, 6);
			Constant.driver.navigate().refresh();
			viewTodayPatientStatus.click();
			Thread.sleep(Constant.Min_Sleep);
			PatientStatusSearch.sendKeys(Number);
			WebElement ele = driver.findElement(By.xpath(".//tr/td[2][text()='"+token+"']/following::td/a[text()='"+sFName+"']/following::td[text()='"+age+"']/following::td[text()='"+Number+"']/following::td[3][text()='Waiting For Basic Data']"));
			if(ele.isDisplayed()){
				flag = true;
			}
			Constant.driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("Patient Status validation failed");
		}
		return flag;
	}
	
	/**
	 * To validate cancel button in reschedule pop up
	 * @return true, if cancel button is working properly
	 * @throws Exception 
	 */
	public boolean Cancel_Reschedule(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
					rescheduleBTN_AllotToken.click();
					Thread.sleep(Constant.Min_Sleep);
					nextDaySchedule_Reschedule.click();
					SelectSlot_Reschedule();
					reschduleCancel.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				selectPatient(sFName, rowNo);
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
					if(rescheduleBTN_AllotToken.isEnabled()){
						flag = true;
					}
				}
				Constant.driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Cancel Reschedule failed");
		}
		return flag;
	}
	
	/**
	 * to validate whether next date is selected from calendar pop up
	 * @return true, if date is selected successfully
	 */
	public boolean Calendar_NextDate(){
		boolean flag = false;
		int actDate;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(calendar.isDisplayed()){
				calendar.click();
				Constant.driver.findElement(By.xpath(".//table[@class='table-condensed']/tbody/tr/td[@class='day'][text()='"+actDate+"']")).click();
				Thread.sleep(Constant.Min_Sleep);
				String value = dateDisplayed.getText();
				if(actDate==Integer.parseInt(value)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Calendar next date selection failed"+e);
		}
		return flag;
	}
	
	/**
	 * to validate whether next month is selected from calendar pop up
	 * @return true, if next month is selected successfully
	 */
	public boolean Calendar_Nextmonth(){
		boolean flag = false;
		String month;
		int actDate;
		String Actmonth = null;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		List<String> months;
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(calendar.isDisplayed()){
				calendar.click();
				String ActMonth = Constant.get_Month();
				month = currentMonth.getText();
				if(month.contains(ActMonth)){
					nextMonth.click();
					Constant.driver.findElement(By.xpath(".//table[@class='table-condensed']/tbody/tr/td[@class='day'][text()='"+actDate+"']")).click();
					months = Constant.monthList();
					for(int i=0; i<months.size();i++){
						if(months.get(i).contains(ActMonth)){
							Actmonth = months.get(i+1);
							break;
						}
					}
					Thread.sleep(Constant.Min_Sleep);
					calendar.click();
					month = currentMonth.getText();
					if(month.contains(Actmonth)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Calendar next month selection failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate whether previous month is selected successfully
	 * @return true, if previous month is selected 
	 */
	
	public boolean Calendar_PreviousMonth(){
		boolean flag = false;
		String month;
		int actDate;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		String Actmonth = null;
		List<String> months;
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(calendar.isDisplayed()){
				today.click();
				Thread.sleep(Constant.Min_Sleep);
				calendar.click();
				String ActMonth = Constant.get_Month();
				month = currentMonth.getText();
				if(month.contains(ActMonth)){
					previousMonth.click();
					Constant.driver.findElement(By.xpath(".//table[@class='table-condensed']/tbody/tr/td[@class='day'][text()='"+actDate+"']")).click();
					months = Constant.monthList();
					for(int i=0; i<months.size();i++){
						if(months.get(i).contains(ActMonth)){
							if(i == 0){
								Actmonth = months.get(12);
							}else{
								Actmonth = months.get(i-1);
							}
							break;
						}
					}
//					Thread.sleep(Constant.Min_Sleep);
					calendar.click();
					month = currentMonth.getText();
					if(month.contains(Actmonth)){
						flag = true;
					}
				}
			}
		}catch(Exception e){
			System.err.println("Calendar previous month selection failed"+e);
		}
		return flag;
	}
	
	/**
	 * Vaerify Today button in calendar pop up
	 * @return true if today button is working successfully
	 */
	public boolean Calendar_Today(){
		boolean flag = false;
		try{
			if(calendar.isDisplayed()){
				calendar.click();
				todayDateSelection.click();
				String ActMonth = Constant.get_Month();
				String month = currentMonth.getText();
				Thread.sleep(Constant.Min_Sleep);
				if(month.contains(ActMonth)){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Calendar Today selection failed"+e);
		}
		return flag;
	}
	
	/**
	 * To verify that whether schedule of the doctor is changed
	 * @param rowNo
	 * @return true, if doctor's schedule is changed successfully
	 * @throws Exception
	 */
	public boolean ChangeSchedule(int rowNo) throws Exception{
		boolean flag = false;
		int actDate;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(addButton.isDisplayed()){
				Constant.driver.findElement(By.xpath(".//span[contains(.,'"+sDoctor+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				nextDaySchedule_doctor.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.findElement(By.xpath(".//span[text()='Pick a day slot']")).isDisplayed()){
					for(int i=0;i<driver.findElements(By.xpath(".//*[@id='postreschedule']/div/a")).size();i++){
						List <WebElement> list = driver.findElements(By.xpath(".//*[@id='postreschedule']/div/a"));
						if(list.get(i).getText().contains("4/4")){
							i++;
						}else{
							list.get(i).click();
							break;
						}
					}
					BookTokenOrAppointment(rowNo, "Appointment");
					nextDay.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = selectPatient(sFName,rowNo);
					driver.navigate().refresh();
				}
			}
		}catch(Exception e){
			System.err.println("Change schedule of doctor fialed "+e);
		}
		return flag;
	}
	
	/**
	 * To search the reports for a particular patients details
	 * @param rowNo
	 * @param sFName
	 * @throws Exception
	 */
	
	public void searchReport(int rowNo,String sFName) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		String sPaymentMode = xls.get(rowNo).get("Cash Option");
		String sUserId = xls.get(rowNo).get("UserID");
		String sStatus = xls.get(rowNo).get("Appointment Status");
		int sdate = Integer.parseInt(date)+1;
		try{
			if(reports.isDisplayed()){
				reports.click();
				Thread.sleep(Constant.Min_Sleep);
				if(report_PopUp.isDisplayed()){
					report_StartDate.click();
					driver.findElement(By.xpath(".//td[@class='today active day']")).click();
					report_EndDate.click();
					driver.findElement(By.xpath(".//td[@class='day'][text()='"+sdate+"']")).click();
					Thread.sleep(Constant.Min_Sleep);
					report_EndTime.click();
					driver.findElement(By.xpath(".//div[text()='11']")).click();
					pm.click();
					updateOkBtn.click();
					report_StartTime.click();
					am.click();
					updateOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
					report_FirstName.sendKeys(sFName);
					report_LastName.sendKeys("Name");
					report_Doctor.sendKeys(sDoctor);
					driver.findElement(By.xpath(".//a[contains(text(),'"+sDoctor+"')]")).click();
					if(sStatus.equals("TOKEN ALLOCATED")){
						paymentMode.click();
						Thread.sleep(Constant.Min_Sleep);
						driver.findElement(By.xpath(".//li/span[contains(.,'"+sPaymentMode+"')]")).click();
						report_PopUp.click();
						Thread.sleep(Constant.Min_Sleep);
						report_MLC.click();
						Thread.sleep(Constant.Min_Sleep);
					}
					reportUsername.click();
					reportUsername.sendKeys(sUserId);
					appointmentStatus.click();
					Thread.sleep(Constant.Min_Sleep);
					for(WebElement ele:fieldReqList){
						if(ele.getText().contains(sStatus)){
							ele.click();
							break;
						}
					}
					symptomReport.click();
					symptomReport.sendKeys(sSymptom);
					fieldReq.click();
					Thread.sleep(Constant.Min_Sleep);
					for(WebElement ele:fieldReqList){
						if(!ele.getText().contains("SELECT ALL")){
							ele.click();
						}
					}
					reportSearch.click();
				}
			}
		}catch(Exception e){
			System.err.println("reports search failed "+e);
		}
	}
	
	/**
	 * To search the report
	 * @param rowNo
	 * @return true, if search is successful
	 * @throws Exception
	 */
	public boolean reports_search(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sPaymentMode = xls.get(rowNo).get("Cash Option");
		String sAddress = xls.get(rowNo).get("Address 1");
		String DoctorName = xls.get(rowNo).get("Token Alloted Doctor");
		String sStatus = xls.get(rowNo).get("Appointment Status");
		try{
			String slotTime = allotToken(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			 editPayment.click();
			 String fee = roundOff.getAttribute("value");
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			WebElement element = driver.findElement(By.xpath(".//th[text()='S.NO']/following::th[text()='MEDIC ID']/following::th[text()='NAME']/following::th[text()='DATE']/following::th[text()='TIME']/following::th[text()='Dr. NAME']/following::th[text()='PAYMENT MODE']/following::th[text()='FEES']/following::th[text()='PHONE']/following::th[text()='ADDRESS']/following::th[text()='REMARKS']/following::th[text()='SYMPTOMS']/following::th[text()='STATUS']"));
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TodayDate+"']/following::td[contains(.,'"+slotTime+"')]/following::td[contains(.,'"+WordUtils.capitalize(DoctorName)+"')]/following::td[text()='"+sPaymentMode+"']/following::td[contains(.,'"+fee+"')]/following::td[text()='"+Number+"']/following::td[text()='"+sAddress+"']/following::td[contains(.,'Test"+Number+"')]/following::td[text()='"+sSymptom+"']/following::td[text()='"+sStatus+"']"));
			if(element.isDisplayed()){
				if(searchResult.isDisplayed()){
					flag = true;
				}
			}
				
			driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("reports search failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify cancel button in report pop up
	 * @param rowNo
	 * @return true, if cancel button is working successfully
	 * @throws Exception
	 */
	
	public boolean Report_Cancel(int rowNo) throws Exception{
		boolean flag = false;
		try{
			allotToken(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			Thread.sleep(Constant.Min_Sleep);
			cancelReport.click();
			if(reports.isDisplayed()){
				flag = true;
			}
			
		}catch(Exception e){
			System.err.println("reports Cancel failed "+e);
		}
		return flag;
	}
	
	/**
	 * to verify reset button from Reports pop up
	 * @param rowNo
	 * @return true, if reset button is working successfully
	 * @throws Exception
	 */
	
	public boolean Report_Reset(int rowNo) throws Exception{
		boolean flag = false;
		try{
			allotToken(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			Thread.sleep(Constant.Min_Sleep);
			resetReport.click();
			Thread.sleep(Constant.Min_Sleep);
			WebElement element = driver.findElement(By.xpath(".//th[text()='S.NO']/following::th[text()='MEDIC ID']/following::th[text()='NAME']/following::th[text()='DATE']/following::th[text()='TIME']"));
			if(element.isDisplayed()){
				if(SearchResult.isDisplayed()){
					flag = true;
				}
			}
				
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("reports Reset failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify export button in reports pop up
	 * @param rowNo
	 * @return true, if export of search results to csv is success
	 * @throws Exception
	 */
	public boolean Report_Export(int rowNo) throws Exception{
		boolean flag = false;
		try{
			allotToken(rowNo);
			Thread.sleep(Constant.Min_Sleep);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			Thread.sleep(Constant.Min_Sleep);
			ExportReport.click();
			Thread.sleep(Constant.Min_Sleep);	
			 Robot robot = new Robot();
			  robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	
			  Thread.sleep(Constant.Min_Sleep);  // sleep has only been used to showcase each event separately	
			  robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(Constant.Min_Sleep);
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(Constant.Min_Sleep);
	           robot.keyPress(KeyEvent.VK_TAB);	
	           Thread.sleep(Constant.Min_Sleep);
	           robot.keyPress(KeyEvent.VK_ENTER);	
	           Thread.sleep(Constant.Min_Sleep);
	         
			File getLatestFile = Constant.getLatestFilefromDir("C:\\Users\\Admin\\Downloads\\");
		    String fileName = getLatestFile.getName();
		    flag = fileName.equals("Report_"+TodayDate+".csv");
		    Assert.assertTrue(flag);
		    getLatestFile.renameTo(new File("G:\\Downloads\\Report.csv"));
//		    List<HashMap<String,String>> report = ExcelUtils.data("G:\\Downloads\\", "Report.csv");
//		   if(report.contains(sMedicID) && report.contains(MobileNum) && report.contains(sFName) && report.contains(sDoctor) 
//				   && report.contains(actDate()) && report.contains(sPaymentMode) && report.contains(sAddress)){
//			   flag = true;
//		   }
			   
		    Thread.sleep(Constant.Min_Sleep);
		    getLatestFile.delete();
		    Thread.sleep(Constant.Min_Sleep);
		    driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("reports Reset failed "+e);
		}
		return flag;
	}
	
	/**
	 * To perform advance search without using filter field
	 * @param rowNo
	 * @return true, if advanced search is successful
	 * @throws Exception
	 */
	
	public boolean AdvancedSearch_WithoutFilter(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String FName = xls.get(rowNo).get("First Name search");
		String LName = xls.get(rowNo).get("Last Name search");
		String sNumber = xls.get(rowNo).get("Mobile Number");
		String PinCode = xls.get(rowNo).get("Pin Code");
		try{
			AdvancedSearch.click();
			Thread.sleep(Constant.Min_Sleep);
			sFirstName.sendKeys(FName);
			sLastName.sendKeys(LName);
			sMobile.sendKeys(sNumber);
			sPinCode.sendKeys(PinCode);
			sSearch.click();
			String[] array = {"1", FName,LName,sNumber,PinCode};
			ArrayList<String> actList = new ArrayList<String>();
			List<WebElement> elements = Constant.driver.findElements(By.xpath(".//*[@id='tblsearchresult']/tr[1]/td"));
			for(WebElement ele:elements){
				String element = ele.getText();
				actList.add(element);
			}
			for(int i=0;i<array.length;i++){
				if(actList.contains(array[i])){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("reports Reset failed "+e);
		}
		return flag;
	}
	
	/**
	 * To perform advance search with filter
	 * @param rowNo
	 * @return true, if search has performed successfully
	 * @throws Exception
	 */
	public boolean AdvancedSearch_WithFilter(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String FName = "test";
		String Filter = xls.get(rowNo).get("Filter Search");
		try{
			Constant.driver.navigate().refresh();
			AdvancedSearch.click();
			Thread.sleep(Constant.Min_Sleep);
			sFirstName.sendKeys(FName);
			sSearch.click();
			sFilter.sendKeys(Filter);
			String element = Constant.driver.findElement(By.xpath(".//td[5][text()='"+Filter+"']")).getText();
			if(element.contains(Filter)){
				flag = true;
			}
			
			advancedSearchClose.click();
			Thread.sleep(Constant.Min_Sleep);
		}catch(Exception e){
			System.err.println("Failed to check search patients with filter"+e);
		}
		return flag;
	}
	
	/**
	 * To validate view more button 
	 * @param rowNo
	 * @return true, if view more button is displayed when patients are more than 11
	 * @throws Exception 
	 */
	public boolean viewMore(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		int value;
		try{
			for(int i=0; i<12; i++){
				value = AvailablePatients(rowNo);
				if(value >= 11){
					
					if(driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).isDisplayed()){
						flag = true;
						break;
					}
				}else{
					BookAppointment(rowNo);
				}
			}
		}catch(Exception e){
			System.err.println("View More tab failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate waiting tab of doctor after token is alloted
	 * @param rowNo
	 * @return true, if count in waiting tab is increased
	 */
	
	public boolean waiting_AfterToken(int rowNo){
		boolean flag = false;
		String WaitingCount;
		try{
			if(WaitingTab.isDisplayed()){
				WaitingCount = WaitingNum.getText();
				if(WaitingCount.contains("-")){
					allotToken(rowNo);
			    	viewTab.click(); 
			    	WaitingCount = WaitingNum.getText();
				}
				allotToken(rowNo);
			    viewTab.click();
				String UpdatedCount = WaitingNum.getText();
				WaitingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//tr/td[3]/a[contains(text(),'"+sFName+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
  		    	if(Integer.parseInt(UpdatedCount) > Integer.parseInt(WaitingCount) && Constant.driver.getPageSource().contains("ALLOT TOKEN")){
		    		flag = true;
				}
  		    	driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("waiting count validation after token alloted failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate waiting tab of doctor after reschedule 
	 * @return true, to validate whether count is decreased in waiting tab afte reschedule
	 */
	public boolean waiting_AfterReschedule(){
		boolean flag = false;
		try{
			if(WaitingTab.isDisplayed()){
				String WaitingCount = WaitingNum.getText();
				WaitingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sFName+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				if(allotToken.isDisplayed()){
					rescheduleBTN_AllotToken.click();
					Thread.sleep(Constant.Min_Sleep);
					nextDaySchedule_Reschedule.click();
					SelectSlot_Reschedule();
					rescheduleBTN.click();
					Thread.sleep(Constant.Min_Sleep);
					updateOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
				viewTab.click();
		    	String UpdatedCount = WaitingNum.getText();
		    	if(UpdatedCount.contains("-")){
		    		flag = true;
		    	}else{
			    	if(Integer.parseInt(UpdatedCount) < Integer.parseInt(WaitingCount)){
			    		flag = true;
			    	}
		    	}
			}
		}catch(Exception e){
			System.err.println("Waiting tab validation after reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate remaining tab of doctor after appointment
	 * @param rowNo
	 * @return true, if the count has increased in remaining tab after appointment
	 * @throws Exception 
	 */
	public boolean Remaining_AfterAppointment(int rowNo){
		boolean flag = false;
		String RemainingCount;
		try{
			if(RemainingTab.isDisplayed()){
				RemainingCount = RemainingNum.getText();
				if(RemainingCount.contains("-")){
					BookAppointment(rowNo);
			    	RemainingCount = RemainingNum.getText();
				}
				BookAppointment(rowNo);
			    String UpdatedCount = RemainingNum.getText();
			    RemainingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//*[@id='action']/div/div/div[2]/table/tbody/tr[2]/td[2]/a")).click();
				Thread.sleep(Constant.Min_Sleep);
	  		    if(Integer.parseInt(UpdatedCount) > Integer.parseInt(RemainingCount) && driver.getPageSource().contains("ALLOT TOKEN")){
			    	flag = true;
			    }
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Remaining tab validation after appointment "+e);
		}
		return flag;
	}
	
	/**
	 * To validate remaining tab of doctor after reschedule
	 * @param rowNo
	 * @return true, if the count has decreased in remaining tab after reschedule
	 */
	public boolean Remaining_AfterReschedule(int rowNo){
		boolean flag = false;
		try{
			if(RemainingTab.isDisplayed()){
				String RemainingCount = RemainingNum.getText();
				if(RemainingCount.contains("-")){
					BookAppointment(rowNo);
			    	RemainingCount = RemainingNum.getText();
				}
				RemainingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				FirstPatient_Remaining.click();
				Thread.sleep(Constant.Min_Sleep);
				if(allotToken.isDisplayed()){
					rescheduleBTN_AllotToken.click();
					Thread.sleep(Constant.Min_Sleep);
					nextDaySchedule_Reschedule.click();
					SelectSlot_Reschedule();
					rescheduleBTN.click();
					Thread.sleep(Constant.Min_Sleep);
					updateOkBtn.click();
					Thread.sleep(Constant.Min_Sleep);
				}
		    	String UpdatedCount = RemainingNum.getText();
		    	if(UpdatedCount.contains("-")){
		    		flag = true;
		    	}else{
			    	if(Integer.parseInt(UpdatedCount) < Integer.parseInt(RemainingCount)){
			    		flag = true;
			    	}
		    	}
			}
		}catch(Exception e){
			System.err.println("Remaining tab validation after reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * to validate Lapsed tab of doctor after reschedule
	 * @return true, if count is decreased after reschedule
	 */
	public boolean Lapsed_AfterReschedule(){
		boolean flag = false;
		try{
			if(LapsedTab.isDisplayed()){
				String RemainingCount = LapsedNum.getText();
				if(RemainingCount.contains("-")){
					flag = true;
				}else{
					LapsedTab.click();
					Thread.sleep(Constant.Min_Sleep);
					FirstPatient_Waiting.click();
					Thread.sleep(Constant.Min_Sleep);
					if(allotToken.isDisplayed()){
						rescheduleBTN_AllotToken.click();
						Thread.sleep(Constant.Min_Sleep);
						nextDaySchedule_Reschedule.click();
						SelectSlot_Reschedule();
						rescheduleBTN.click();
						Thread.sleep(Constant.Min_Sleep);
						updateOkBtn.click();
						Thread.sleep(Constant.Min_Sleep);
					}
			    	String UpdatedCount = LapsedNum.getText();
			    	if(UpdatedCount.contains("-")){
			    		flag = true;
			    	}else{
				    	if(Integer.parseInt(UpdatedCount) < Integer.parseInt(RemainingCount)){
				    		flag = true;
				    	}
			    	}
				}
			}
		}catch(Exception e){
			System.err.println("Lapsed tab validation after reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate checked out tab of doctor
	 * @param rowNo
	 * @return true, if count has increased after token is rescheduled
	 */
	public boolean CheckedOut_count(int rowNo){
		boolean flag = false;
		try{
			if(CheckedOutTab.isDisplayed()){
				String RemainingCount = CheckedOutNum.getText();
				if(RemainingCount.contains("-")){
					waiting_AfterToken(rowNo);
					waiting_AfterReschedule();
					RemainingCount = CheckedOutNum.getText();
				}
				waiting_AfterToken(rowNo);
				waiting_AfterReschedule();
				String UpdatedCount = CheckedOutNum.getText();
				CheckedOutTab.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//a[contains(text(),'"+sFName+"')]")).click();
				Thread.sleep(Constant.Min_Sleep);
				if(Integer.parseInt(UpdatedCount) > Integer.parseInt(RemainingCount) && driver.getPageSource().contains("ALLOT TOKEN")){
					flag = true;
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("checked out tab validation after token is reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * To verify Checked out tab count after reschedule
	 * @return true, if token from checked out tab has reschedule button disabled
	 */
	public boolean CheckedOut_AfterReschedule(){
		boolean flag = false;
		try{
			if(CheckedOutTab.isDisplayed()){
				CheckedOutTab.click();
				Thread.sleep(Constant.Min_Sleep);
				FirstPatient_Remaining.click();
				Thread.sleep(Constant.Min_Sleep);
				if(allotToken.isDisplayed()){
					if(!rescheduleBTN_AllotToken.isEnabled()){
						flag = true;
					}
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Checked out tab validation after reschedule failed"+e);
		}
		return flag;
	}
	
	/**
	 * To verify Symptom is displayed in the allot token
	 * @return true, if Symptom is displayed in the allot token pop up
	 */
	public boolean SymptomVerify(int rowNo){
		boolean flag = false;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
				selectPatient(sFName, rowNo);
				Thread.sleep(Constant.Min_Sleep);
					if(allotToken.isDisplayed()){
						String symptom = symptoms.getText();
						if(sSymptom.contains(symptom)){
							flag = true;
						}
					}
		    	}
		    	driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("Symptom validation is allot token page failed"+e);
		}
		return flag;
	}
	
	/**
	 * To verify whether token is alloted with doctor reference
	 * @param rowNo
	 * @return true, if token is alloted with doctor reference
	 * @throws Exception
	 */
	public boolean Token_DocRef(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		int Value;
		int ActValue;
		try{
			Value = AvailablePatients(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Token");
			    Profileupdate(rowNo);
			    DoctorRef.sendKeys(sDoctor);
			    driver.findElement(By.xpath(".//a[contains(text(),'"+sDoctor+"')]")).click();
			    Token_CashOption(rowNo);
	    	 viewTab.click();
	    	 ActValue = AvailablePatients(rowNo);
	    		if(ActValue>Value){
	    			flag = true;
	    		}
		}catch(Exception e){
			System.err.println("Symptom validation is allot token page failed"+e);
		}
		return flag;
	}
	
	/**
	 * To update fee details after token is alloted
	 * @param rowNo
	 * @return true, if fee details are updated while editing the token
	 * @throws Exception
	 */
	public boolean UpdateFee(int rowNo) throws Exception{
		boolean flag = false;
		try{
			allotToken(rowNo);
	    	 viewTab.click();
	    	 selectPatient(sFName, rowNo);
	    	 Thread.sleep(Constant.Min_Sleep);
	    	 editPayment.click();
	    	 Fee(rowNo);
	    	 selectPatient(sFName, rowNo);
	    	 Thread.sleep(Constant.Min_Sleep);
	    	 editPayment.click();
	    	 String sHospitalFee = hospitalFee.getAttribute("value");
				String sDoctorFee = doctorFee.getAttribute("value");
				String sLabFee = labFee.getAttribute("value");
				String sMiscFee = miscFee.getAttribute("value");
				String sDiscount = discount.getAttribute("value");
				String sFee = totalFee.getAttribute("value").substring(0, 3);
				printBillLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);     
				rb.keyPress(KeyEvent.VK_ESCAPE);
				flag = true;
//				rb.keyRelease(KeyEvent.VK_ESCAPE);     
//				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				    driver.switchTo().window(tabs2.get(1));
//				    JavascriptExecutor js = (JavascriptExecutor)driver;
//				    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				    String[] array = sText.split("\\r?\\n");
//				    
//				    if( array[32].contains(sHospitalFee) && array[35].contains(doctorFee) && array[38].contains(labFee) && array[41].contains(miscFee) && array[43].contains(discount) && array[45].contains(fee)){
//				    	flag = true;
//				    }
//				    driver.close();
//				    driver.switchTo().window(tabs2.get(0));
//					Thread.sleep(Constant.Min_Sleep);
					Constant.driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Update fee and validation in print bill failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate Today button 
	 * @return true, if application is refreshed and today's date is displayed
	 */
	public boolean TodayButton(){
		boolean flag = false;
		try{
			if(Integer.parseInt(date) < 10){
				date = date.substring(1);
			}
			Calendar_NextDate();
			TodayBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//*[@id='dsel1']/div/span[6]/span[text()='"+date+"']")).isDisplayed()){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Today button validation failed "+e);
		}
		return flag;
	}
	
	/**
	 * To update patient profile
	 * @param rowNo
	 * @return true, if profile update during token edit is successful
	 * @throws Exception
	 */
	public boolean UpdateProfile(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sName = xls.get(rowNo).get("Name");
		String[] name = sName.split(" ");
		try{
			Add_AvailablePatient(rowNo);
 			 selectPatient(name[0],rowNo);
 			Thread.sleep(Constant.Min_Sleep);
			 expandMore.click();
			 flag = Profileupdate(rowNo);
			 driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Update profile validation failed "+e);
		}
		return flag;
	}
	
	/**
	 * To allot a token with associate
	 * @param rowNo
	 * @return true, if token is alloted with associate
	 * @throws Exception
	 */
	public boolean Token_Associate(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sAssociate = xls.get(rowNo).get("Associate");
		boolean flag = false;
		try{
			allotToken(rowNo);
			 selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			editPayment.click();
			Thread.sleep(Constant.Min_Sleep);
			AssociateDropDwn.click();
			Thread.sleep(Constant.Min_Sleep);
			WebElement ele = driver.findElement(By.xpath(".//ul[contains(@class,'select-dropdown active')]/li/span[text()='"+sAssociate+"']"));
			ele.click();
			Thread.sleep(Constant.Min_Sleep);
			RefNameTxt.sendKeys("Testing");
			RefIdTxt.sendKeys("Test123456");
			Token_CashOption(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			editPayment.click();
			if(RefNameTxt.getAttribute("value").contains("Testing")){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Token with Associate failed "+e);
		}
		return flag;
	}
	
	/**
	 * To update the DOB of the patient profile
	 * @param rowNo
	 * @return First name of the patient
	 * @throws Exception
	 */
	public String DOBCheck_YrMonth(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sDate = xls.get(rowNo).get("Birth Date");
		String sMonth = xls.get(rowNo).get("Edit Birth month");
		String sYear = xls.get(rowNo).get("Edit Bith Year");
	
		try{
			allotToken(rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			 selectPatient(sFName,rowNo);
			Thread.sleep(Constant.Medium_Sleep);
			expandMore.click();
			 Select selectDay = new Select(dayDropDwn);
			selectDay.selectByValue(sDate);
			Select selectMonth = new Select(monthDropDwn);
			selectMonth.selectByValue(sMonth);
			Select selectYear = new Select(yearDropDwn);
			selectYear.selectByValue(sYear);
			updatePatientBtn.click();
		   	Thread.sleep(Constant.Medium_Sleep);
		   	updateOkBtn.click();
			Thread.sleep(Constant.Medium_Sleep);
		}catch(Exception e){
			System.err.println("DOB check failed"+e);
		}
		return sFName;
	}
	
	/**
	 * To validate patient's age in allot token pop up
	 * @param rowNo
	 * @return true, age is displayed properly in the allot token pop up
	 * @throws Exception
	 */
	public boolean ValidateAge_AllotToken(int rowNo) throws Exception{
		boolean flag = false;
		String ActAge = null; 
		try{
			DOBCheck_YrMonth(rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String age = age_Gender.getAttribute("value").substring(0, 5).trim();
			expandMore.click();
			String sAge = Age.getAttribute("value");
			if(sAge.length() > 9){
				ActAge = sAge.substring(0, 1)+sAge.substring(2, 3)+sAge.substring(7, 9)+sAge.substring(10, 11);
			}else{
				if(sAge.contains("M")){
						ActAge = sAge.substring(0,1)+sAge.substring(2, 3);
				}else{
					if(sAge.contains("D")){
						ActAge = sAge.substring(0,2)+sAge.substring(3, 4);
					}else{
						ActAge = sAge.substring(0,1);
					}
				}
			}
			if(age.contains(ActAge)){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("validation of age in allot token age failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate age in view patient status pop up
	 * @param rowNo
	 * @return true, if proper age is displayed in the View patient status pop up
	 * @throws Exception
	 */
	public boolean ValidateAge_ViewPatientStatus(int rowNo) throws Exception{
		boolean flag = false;
		String ActAge = null; 
		String age;
		try{
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			expandMore.click();
			String sAge = Age.getAttribute("value");
			if(sAge.length() > 9){
				ActAge = sAge.substring(0, 1)+sAge.substring(2, 3)+sAge.substring(7, 9)+sAge.substring(10, 11);
			}else{
				if(sAge.contains("M")){
					ActAge = sAge.substring(0,3);
				}else{
					if(sAge.contains("D")){
						ActAge = sAge.substring(0,2)+sAge.substring(3, 4);
					}else{
						ActAge = sAge.substring(0,1);
					}
				}
			}
			driver.navigate().refresh();
	  		Thread.sleep(Constant.Min_Sleep);
			viewTodayPatientStatus.click();
			Thread.sleep(Constant.Min_Sleep);
			if(sAge.length() > 9){
				age = driver.findElement(By.xpath(".//td[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 1);
			}else{
				if(sAge.contains("M")){
					age = driver.findElement(By.xpath(".//td[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 3).toUpperCase();
				}else{
					if(sAge.contains("D")){
						age = driver.findElement(By.xpath(".//td[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 4).toUpperCase().trim();
						age = age.substring(0, 2)+age.substring(3, 4);
					}else{
						age = driver.findElement(By.xpath(".//td[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 1);
					}
				}
			}
			if(ActAge.contains(age)){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("validation age in view patient status failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate age details in View more pop up
	 * @param rowNo
	 * @return true, if age is displayed properly in View more pop up
	 * @throws Exception
	 */
	public boolean ValidateAge_ViewMore(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		String ActAge = null; 
		String age;
			try{
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			expandMore.click();
			String sAge = Age.getAttribute("value");
			if(sAge.length() > 9){
				ActAge = sAge.substring(0, 1)+sAge.substring(2, 3)+sAge.substring(7, 9)+sAge.substring(10, 11);
			}else{
				if(sAge.contains("M")){
					ActAge = sAge.substring(0,3);
				}else{
					if(sAge.contains("D")){
						ActAge = sAge.substring(0,2)+sAge.substring(3, 4);
					}else{
						ActAge = sAge.substring(0,1);
					}
				}
			}
			driver.navigate().refresh();
			Thread.sleep(Constant.Min_Sleep);
			boolean value = PatientPresent();
			if(value == true){
	   			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
	   				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(sAge.length() > 9){
						age = driver.findElement(By.xpath(".//td/a[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 1);
					}else{
						if(sAge.contains("M")){
							age = driver.findElement(By.xpath(".//td/a[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 3).toUpperCase();
						}else{
							if(sAge.contains("D")){
								age = driver.findElement(By.xpath(".//td/a[contains(.,'"+sFName+"')]/following::td[1]")).getText().toUpperCase();
								age = age.substring(0, 2)+age.substring(3, 4);
							}else{
								age = driver.findElement(By.xpath(".//td/a[contains(.,'"+sFName+"')]/following::td[1]")).getText().substring(0, 1);
							}
						}
					}
					if(ActAge.contains(age)){
						flag = true;
					}
					close.click();
					Thread.sleep(Constant.Min_Sleep);
				}else{
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("validation age in view more button failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate tick mark near Medic ID of allot token pop up when Smart and Medic option is checked
	 * @param rowNo
	 * @return true, if tick mark is available near Medic ID
	 * @throws Exception
	 */
	public boolean Check_SmartAndMedicOpt(int rowNo) throws Exception{
		boolean flag = false;
		try{
			allotToken(rowNo);
			viewTab.click();
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			expandMore.click();
			smartPhoneYesBtn.click();
			medicAppYesBtn.click();
			if(updatePatientBtn.isEnabled()){
				updatePatientBtn.click();
			   	Thread.sleep(Constant.Medium_Sleep);
			   	updateOkBtn.click();
				Thread.sleep(Constant.Medium_Sleep);
			}
			driver.navigate().refresh();
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(MedicIDCheck.isDisplayed()){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Validate check of smart and medic app option failed");
		}
		return flag;
	}
	
	/**
	 * To validate cross mark near Medic Id when Smart and Medic options are not checked
	 * @param rowNo
	 * @return true, if cross mark is displayed near Medic ID of Allot token pop up
	 * @throws Exception
	 */
	public boolean UnCheck_SmartAndMedicOpt(int rowNo) throws Exception{
		boolean flag = false;
		try{
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			expandMore.click();
			smartPhoneNoBtn.click();
			medicAppNoBtn.click();
			updatePatientBtn.click();
		   	Thread.sleep(Constant.Medium_Sleep);
		   	updateOkBtn.click();
			Thread.sleep(Constant.Medium_Sleep);
			driver.navigate().refresh();
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(MedicIDUnCheck.isDisplayed()){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("validate Uncheck of smart and medic app option failed");
		}
		return flag;
	}
	
	/**
	 * To validate whether appointment can be booked for future date
	 * @param rowNo
	 * @return true, if appointment is booked for future date
	 */
	public boolean FutureDayAppointment(int rowNo){
		boolean flag = false;
		try{
			Calendar_NextDate();
			flag = BookAppointment(rowNo);
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Future day appointment booking failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate whether future day appointment can be rescheduled 
	 * @param rowNo
	 * @return true, is future day appointment can be rescheduled
	 * @throws Exception
	 */
	public boolean FutureDayAppointmentReschedule(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		String FName = null;
		boolean value;
		try{
			Calendar_NextDate();
			BookAppointment(rowNo);
			viewTab.click();
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//*[@id='time-slotbox']/div/div/ul/li[1]/a/div[1]")).click();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
				if(expandMore.isDisplayed()){
					expandMore.click();
				}
				FName = firstName.getAttribute("value");
				rescheduleBTN_AllotToken.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.findElement(By.xpath(".//*[@id='refineSearch']/div[1]/div[3]/div/a")).click();
				SelectSlot_Reschedule();
				rescheduleBTN.click();
				Thread.sleep(Constant.Min_Sleep);
				updateOkBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			int actDate = Integer.parseInt(date)+2;
			Constant.driver.findElement(By.xpath(".//span/span[text()='"+actDate+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			viewTab.click();
			value = PatientPresent();
			if(value == true){
				if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
					driver.findElement(By.xpath(".//a[contains(@onclick,'"+sSelectDoc+"')]/div[@class='View_More']")).click();
					Thread.sleep(Constant.Min_Sleep);
					if(Constant.driver.findElement(By.linkText(FName)).isDisplayed()){
						flag = true;
					}
					close.click();
					Thread.sleep(Constant.Min_Sleep);
				}else{
					if(Constant.driver.findElement(By.xpath(".//div[text()='"+FName+"']")).isDisplayed()){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Future day appointment booking failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify whether application is refreshed when Medic icon is clicked
	 * @return true, if application gets refreshed when Medic icon is clicked
	 * @throws Exception
	 */
	public boolean refresh() throws Exception{
		boolean flag = false;
		try{
			if(MedicIcon.isDisplayed()){
				MedicIcon.click();
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Refresh failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate appointment booked time in print token 
	 * @param rowNo
	 * @return true, if appointment booked time is displayed in print token
	 * @throws Exception 
	 */

	public boolean appointmentBookedTime(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			String slotTime = SelectSlot().substring(0, 8);
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			viewTab.click();
			selectPatient(sFName, rowNo);  
			Thread.sleep(Constant.Min_Sleep);
			Profileupdate(rowNo);
			confirmToken.click();
			Thread.sleep(Constant.Medium_Sleep);
			yesBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Robot rb =new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(Constant.Min_Sleep);
			flag = true;
			driver.navigate().refresh();
//				 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				    driver.switchTo().window(tabs2.get(1));
//				    JavascriptExecutor js = (JavascriptExecutor)driver;
//				    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				    String[] array = sText.split("\\r?\\n");
//				    
//				    if(array[21].contains(slotTime)){
//				    	flag = true;
//				    }
//				    driver.close();
//				    driver.switchTo().window(tabs2.get(0));
//					Thread.sleep(Constant.Min_Sleep);
//				    rb.keyPress(KeyEvent.VK_ESCAPE);
//					rb.keyRelease(KeyEvent.VK_ESCAPE);
//					Thread.sleep(Constant.Min_Sleep);
			
		}catch(Exception e){
			System.err.println("Appointment Booked time validation in print failed"+e);
		}
		return flag;
	}
	
	/**
	 * To validate 40 characters is displayed in the allot token page for first, last name and c/o
	 * @param rowNo
	 * @return true, if 40 character is displayed properly in allot token page
	 * @throws Exception
	 */
	public boolean check40Char_AllotToken(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sAddress = xls.get(rowNo).get("Address 1");
		String sCareOff = xls.get(rowNo).get("Care Of");
		
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
					mobileNumberTxt.sendKeys(Number);
					Thread.sleep(Constant.Min_Sleep);
					patientFirstNameTxt.sendKeys(FName);
	    			patientLastNameTxt.sendKeys(LName);
	    			symptoms.sendKeys(symptom);
	    			bookAppointmentBtn.click();	
				}
				Thread.sleep(Constant.Medium_Sleep);
				Profileupdate(rowNo);
				Token_CashOption(rowNo);
			}
			 viewTab.click();
  			  selectPatient(FName, rowNo);
  			Thread.sleep(Constant.Min_Sleep);
			  expandMore.click();
			  String sFName = firstName.getAttribute("value");
			  String sLName = lastName.getAttribute("value");
			  String sCareOf = careOff.getAttribute("value");
			  String saddress = address1Txt.getAttribute("value");
			  String sSymptom = symptoms.getAttribute("value");
			  
			  if(FName.contains(sFName) && LName.contains(sLName) && sCareOf.contains(sCareOff) && sAddress.contains(saddress)
					  && symptom.contains(sSymptom)){
				  flag = true;
			  }
			  Thread.sleep(Constant.Min_Sleep);
			    driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("check 40 character is displayed in the Allot token page failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate whether 40 character name is displayed properly in print token 
	 * @param rowNo
	 * @return true, if 40 character is displayed properly in print token 
	 * @throws Exception
	 */
	public boolean check40Char_PrintToken(int rowNo) throws Exception{
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			viewTab.click();
			selectPatient(FName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String titleTxt = titleDropDown.getAttribute("value").toUpperCase();
			String sname = titleTxt+" "+FName.toUpperCase().substring(0, 21);
			String sSymptom = symptom.substring(0, 25).toUpperCase();
			confirmToken.click();
			Thread.sleep(Constant.Medium_Sleep);
			yesBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Robot rb =new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			flag = true;
//			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//			driver.switchTo().window(tabs2.get(1));
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//			String[] array = sText.split("\\r?\\n");
//			    
//			if(array[21].contains(sname) && array[28].contains(symptom)){
//			   	flag = true;
//			}
//			driver.close();
//			driver.switchTo().window(tabs2.get(0));
//			Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("check 40 character is displayed in the Print token page failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate whether 40 characters of First name and address is displayed properly in print bill
	 * @param rowNo
	 * @return true, 40 characters is displayed properly in Print bill
	 * @throws Exception
	 */
	public boolean check40Char_PrintBill(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sAddress = xls.get(rowNo).get("Address 1").substring(0,25).toUpperCase();
		try{
			Thread.sleep(Constant.Min_Sleep);
			viewTab.click();
	  		selectPatient(FName, rowNo);
	  		Thread.sleep(Constant.Min_Sleep);
			expandMore.click();
			String titleTxt = titleDropDown.getAttribute("value").toUpperCase();
			String sname = titleTxt+" "+FName.toUpperCase().substring(0, 21);
			printBillLnk.click();
			Thread.sleep(Constant.Min_Sleep);
			Robot rb =new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			flag = true;
//				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//			    driver.switchTo().window(tabs2.get(1));
//			    JavascriptExecutor js = (JavascriptExecutor)driver;
//			    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//			    String[] array = sText.split("\\r?\\n");
//			    
//			    if(array[14].contains(sname) && array[16].contains(sAddress)){
//			    	flag = true;
//			    }
//			    driver.close();
//			    driver.switchTo().window(tabs2.get(0));
//				Thread.sleep(Constant.Min_Sleep);
			driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("check 40 character is displayed in the Print Bill page failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate 40 characters is displayed in the Print ID card
	 * @param rowNo
	 * @return true, if entered 40 characters in first name, c/o and address is displayed properly
	 * @throws Exception
	 */
	public boolean check40Char_PrintIDCard(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sAddress = xls.get(rowNo).get("Address 1").substring(0,17).toUpperCase();
		String sCareOff = xls.get(rowNo).get("Care Of").substring(0, 15).toUpperCase();
		String sFName = "Test"+RandomStringUtils.randomAlphabetic(36).toLowerCase();
		String sLName = "Name"+RandomStringUtils.randomAlphabetic(36).toLowerCase();
		String sSymptom = "Test"+RandomStringUtils.randomAlphabetic(36);
		try{
			Thread.sleep(Constant.Medium_Sleep);
				 viewTab.click();
	  			 selectPatient(FName, rowNo);
	  			Thread.sleep(Constant.Min_Sleep);
				 expandMore.click();
			    String titleTxt = titleDropDown.getAttribute("value").toUpperCase();
			    String sname = titleTxt+" "+sFName.toUpperCase().substring(0, 14);
			    iDCardPrintLnk.click();
				Thread.sleep(Constant.Min_Sleep);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				flag = true;
//				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//			    driver.switchTo().window(tabs2.get(1));
//			    JavascriptExecutor js = (JavascriptExecutor)driver;
//			    String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//			    String[] array = sText.split("\\r?\\n");
//			    
//			    if(array[12].contains(sname) && array[14].contains(sCareOff) && array[15].contains(sAddress)){
//			    	flag = true;
//			    }
//			    driver.close();
//			    driver.switchTo().window(tabs2.get(0));
//				Thread.sleep(Constant.Min_Sleep);
			    driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("check 40 character is displayed in the ID Card Print page failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify whether cash option in the payment method is selected by default
	 * @return true, if cash option is selected by default
	 * @throws Exception
	 */
	public boolean CashOption_Enabled(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Token");
				if(driver.findElement(By.xpath(".//input[@checked='checked']/following::label[1][text()='CASH']")).isDisplayed()){
					flag = true;
				}
				driver.navigate().refresh();
			
		}catch(Exception e){
			System.err.println("Cash option is not selected by default "+e);
		}
		return flag;
	}
	
	/**
	 * To Validate whether Medical Officer does not have Dr. initials
	 * @param rowNo
	 * @return true, if Medical officer does not have Dr. initials
	 * @throws Exception 
	 */
	public boolean MedicalOfficer(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		String sSelectDoc = xls.get(rowNo).get("Token Alloted Doctor");
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = false;
		boolean flag8 = false;
		boolean flag9 = false;
		String token;
		try{
			if(selectDocs.isDisplayed()){
				selectDocs.click();
				Thread.sleep(Constant.Min_Sleep);
				searchDocTxt.sendKeys(sDoctor);
				driver.findElement(By.xpath(".//label[contains(text(),'"+sDoctor+"')]")).click();
				selectDoc_ApplyBtn.click();
			}
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[contains(text(),'"+sDoctor+"')]")).isDisplayed()){
				flag1 = true;
			}
			driver.findElement(By.xpath(".//span[contains(text(),'"+sDoctor+"')]")).click();
			Thread.sleep(Constant.Min_Sleep);   
			if(driver.findElement(By.xpath(".//span[text()='"+sDoctor+" ']")).isDisplayed()){
				flag2 = true;
			}
			close.click();
			Thread.sleep(Constant.Min_Sleep);
			addButton.click();
			int i;
			for(i=0;i<DoctorList.size();i++){
				if(DoctorList.get(i).getText().contains(sDoctor)){
					break;
				}
			}
			List<WebElement> list = driver.findElements(By.xpath(".//*[@id='update-slot']/div["+((i+1)*2)+"]/div/div/a"));
			for(int j=0;j<list.size();j++){
				List <WebElement> list1 = driver.findElements(By.xpath(".//*[@id='update-slot']/div["+((i+1)*2)+"]/div/div/a"));
				if(list1.get(i).getText().contains("4/4")){
					i++;
				}else{
  					list1.get(i).click();
					list1.get(i).getText();
					break;
				}
			}
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//div[text()=' "+sDoctor+" ']")).isDisplayed()){
				flag3 = true;
			}
			Thread.sleep(Constant.Medium_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
				if(driver.findElement(By.xpath(".//span/span[contains(.,'Consultant: "+sDoctor+"')]")).isDisplayed()){
					flag4 = true;
				}
				Profileupdate(rowNo);
				confirmToken.click();
				Thread.sleep(Constant.Medium_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				driver.navigate().refresh();
				Thread.sleep(Constant.Min_Sleep);
				flag5 = true;
//				ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//				driver.switchTo().window(tabs2.get(1));
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				String sText =  js.executeScript("return document.documentElement.innerText;").toString();
//				String[] array = sText.split("\\r?\\n");
//				if(array[12].contains("MEDICAL OFFICER")){
//				   	flag5 = true;	    	
//				}
//				driver.close();
//				driver.switchTo().window(tabs2.get(0));
			viewTab.click();
			if(driver.findElements(By.xpath(".//div/div/div/div/div/div/div/ul/li/a[contains(@onclick,'"+sSelectDoc+"')]")).size() > 11){
				driver.findElement(By.xpath(".//a[contains(@onclick,'"+sDoctor+" ')]/div[@class='View_More']")).click();
				Thread.sleep(Constant.Min_Sleep);
				token = driver.findElement(By.xpath(".//td/a[contains(text(),'"+sFName+"')]/preceding::td[1]")).getText();
				Constant.driver.findElement(By.linkText(sFName)).click();
			}else{
				token = driver.findElement(By.xpath(".//div[text()='"+sFName+"']/following::span[1]")).getText();
				Constant.driver.findElement(By.xpath(".//div[text()='"+sFName+"']")).click();
			}
			Thread.sleep(Constant.Min_Sleep);
			rescheduleBTN_AllotToken.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//td[text()=' "+sDoctor+" ']")).isDisplayed()){
				flag7 = true;
			}
			driver.navigate().refresh();
			 Thread.sleep(Constant.Min_Sleep);
			 viewTab.click();
				
				Thread.sleep(Constant.Min_Sleep);
				 searchToken.sendKeys(token);
				 searchTokenBtn.click();
				 Thread.sleep(Constant.Min_Sleep);
				 if(driver.findElement(By.xpath(".//td[text()='"+sDoctor+" ']")).isDisplayed()){
					 flag6 = true;
				 }
				 close.click();
				 Thread.sleep(Constant.Min_Sleep);
			reports.click();
			Thread.sleep(Constant.Min_Sleep);
			report_Doctor.sendKeys(sDoctor);
			if(driver.findElement(By.xpath(".//a[text()='"+sDoctor+" ']")).isDisplayed()){
				driver.findElement(By.xpath(".//a[text()='"+sDoctor+" ']")).click();
				flag8 = true;
			}
			fieldReq.click();
			Thread.sleep(Constant.Min_Sleep);
			selectAllCheckbox.click();
			report_PopUp.click();
			reportSearch.click();
			 if(driver.findElement(By.xpath(".//td[text()='  "+sDoctor+"']")).isDisplayed()){
				 flag9 = true;
			 }
			if(flag1 == true && flag2 == true && flag3 == true && flag4 == true && flag5 == true && flag6 == true
					&& flag7 == true && flag8 == true && flag9 == true){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Medical Office check for Dr initials failed "+e);
		}
		return flag;
	}
	
	/**
	 * To validate whether warning message is displayed in the Reschedule pop up if slot is not selected
	 * @return true, if warning message is displaye in the reschedule pop up
	 */
	public boolean WarningMsg_Reschedule(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			rescheduleBTN_AllotToken.click();
			Thread.sleep(Constant.Min_Sleep);
			nextDaySchedule_Reschedule.click();
			Thread.sleep(Constant.Min_Sleep);
			rescheduleBTN.click();
			Thread.sleep(Constant.Min_Sleep);
			if(driver.findElement(By.xpath(".//span[text()='(Please select any one time slot.)']")).isDisplayed()){
				flag = true;
			}
			reschduleCancel.click();
		}catch(Exception e){
			System.err.println("Warning message check in reschedule pop up "+e);
		}
		return flag;
	}
	
	/**
	 * To validate waiting, lapsed, checked and remaining tabs have same count as number of patients availabled for doctor
	 * @return true, if tabs count and the patient's available count matches
	 */
	public boolean ValidatePatientStautsView(int rowNo){
		boolean flag = false;
		int waiting = 0;
		int remaining = 0;
		int lapsed = 0;
		int checked = 0;
		try{
			if(!WaitingNum.getText().contains("-")){
				waiting = Integer.parseInt(WaitingNum.getText());
			}
			if(!RemainingNum.getText().contains("-")){
				remaining = Integer.parseInt(RemainingNum.getText());
			}
			if(!LapsedNum.getText().contains("-")){
				lapsed = Integer.parseInt(LapsedNum.getText());
			}
			if(!CheckedOutNum.getText().contains("-")){
				checked = Integer.parseInt(CheckedOutNum.getText());
			}
			int value = waiting + remaining + lapsed + checked;
			int ActValue = AvailablePatients(rowNo);
			if(value == ActValue){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Validation of no. of patients count with patient status view failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify success message in Appointment success pop up
	 * @return true, if success message is displayed properly
	 */
	public boolean CheckAppointmentSuccessMessage(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
				mobileNumberTxt.sendKeys(Number);
				Thread.sleep(Constant.Min_Sleep);
				if(medicRegisterCheck.getText().contains("Medic not registered.")){
					patientFirstNameTxt.sendKeys(sFName);
					patientLastNameTxt.sendKeys(sLName);
				}
    			symptoms.sendKeys(sSymptom);
    			appointmentTypeDropDwn.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		appointmentType.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		bookAppointmentBtn.click();
	    		Thread.sleep(Constant.Min_Sleep);
	    		String Message = SuccessMsg.getText();
				if(Message.contains("Appointment booked for "+sFName+" with")){
					flag = true;
				}
			    updateOkBtn.click();
			    Thread.sleep(Constant.Min_Sleep);
    		}
		}catch(Exception e){
			System.err.println("Appointment success message validation failed "+e);
		}
		return flag;
	}
	
	/**
	 * To verify success message after reschedule pop up
	 * @return true, if success message is displayed after reschedule
	 * @throws Exception 
	 */
	public boolean CheckRescheduleSuccessMsg(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			viewTab.click();
			selectPatient(sFName,rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
				rescheduleBTN_AllotToken.click();
				Thread.sleep(Constant.Min_Sleep);
				nextDaySchedule_Reschedule.click();
				SelectSlot_Reschedule();
				rescheduleBTN.click();
				Thread.sleep(Constant.Min_Sleep);
				String Message = SuccessMsg.getText();
				if(Message.contains("Schedule changed successfully")){
					flag = true;
				}
				updateOkBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Reschedule success message validation failed "+e);
		}
		return flag;
	}
	
	/**
	 * To check mandatory error messages in Add a Patient pop up
	 * @return true, if mandatory error message is displayed in the Add a Patient pop up
	 */
	public boolean mandatoryField_AddPatient(){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
				bookAppointmentBtn.click();	
				Thread.sleep(Constant.Min_Sleep);
				if(Warning_Mobile.isDisplayed() && Warning_FName.isDisplayed()){
					flag = true;
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Mandatory field check in Add patient pop up "+e);
		}
		return flag;
	}
	
	public boolean particularDoc(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		try{
   			SelectDoc_ApplyBtn(rowNo);
			for(int i=0;i<DoctorList.size();i++){
				String a = DoctorList.get(i).getText();
				if(a.contains(sDoctor)){
					List <WebElement> list = driver.findElements(By.xpath(".//*[@id='update-slot']/div["+(i+1)*2+"]/div/div/a"));
					for(int j=0;j<addPatientList.size();j++){
						addButton.click();
						if(list.get(j).getText().contains("4/4")){
							i++;
						}else{
							list.get(j).click();
							break;
						}
					}
					break;
				}
			}
			BookTokenOrAppointment(rowNo, "Token");
			Profileupdate(rowNo);
			Token_CashOption(rowNo);
			viewTab.click();
			if(driver.getPageSource().contains(sFName)){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("allot token for a specific doctor "+e);
		}
		return flag;
	}
	
	public boolean CancelAppointment(int rowNo) throws Exception{
		boolean flag = false;
		int Value = 0;
		int ActValue = 0;
		try{
	    	if(addButton.isDisplayed()){
	    		addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
				Value = AvailablePatients(rowNo);
	    	}
	    	selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			CancelApt();
			  ActValue = AvailablePatients(rowNo);
	    		if(ActValue<Value){
	    			flag = true;
	    		}

		}catch(Exception e){
			System.err.print("Failed to Cancel Appointment"+e);
		}
    	return flag;
	}
	
	public void CancelApt() throws Exception{
		try{
			if(driver.getPageSource().contains("ALLOT TOKEN")){
				cancelAptBtn.click();
				cancelReason.sendKeys("Testing"+Number+" !@#$%^&*(),./;'[]\\");
				Thread.sleep(Constant.Min_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				updateOkBtn.click();
				Thread.sleep(Constant.Min_Sleep);
			}
		}catch(Exception e){
			System.err.println("Unable to click cancel btn "+e);
		}
	}
	
	public boolean CancelToken(int rowNo) throws Exception{
		boolean flag = false;
		try{
				AllotToken_MandatoryField(rowNo);
				viewTab.click();
				selectPatient(sFName, rowNo);
				Thread.sleep(Constant.Min_Sleep);
				CancelApt();
				selectPatient(sFName, rowNo);
				if(!cancelAptBtn.isEnabled()){
					flag = true;
	    		}
				Thread.sleep(Constant.Min_Sleep);
				driver.navigate().refresh();
		}catch(Exception e){
			System.err.print("Failed to Cancel token"+e);
		}
	    	return flag;
	}
	
	public void AllotToken_MandatoryField(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sTitle = xls.get(rowNo).get("Title");
		String sDate = xls.get(rowNo).get("Birth Date");
		String sMonth = xls.get(rowNo).get("Birth month");
		String sYear = xls.get(rowNo).get("Birth year");
		String sAddress1 = xls.get(rowNo).get("Address 1");
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				Thread.sleep(Constant.Min_Sleep);
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Token");
				    if(driver.getPageSource().contains("ALLOT TOKEN")){
				    	 WebDriverWait wait = new WebDriverWait(driver, 10); 
						 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(titleDropDown));
						 element.click();
						 Thread.sleep(Constant.Min_Sleep);
						 driver.findElement(By.xpath(".//ul/li/span[text()='"+sTitle+"']")).click();
						 Thread.sleep(Constant.Min_Sleep);    
						 maleBtn.click();
						 Select selectDay = new Select(dayDropDwn);
						 selectDay.selectByValue(sDate);
						 Select selectMonth = new Select(monthDropDwn);
						 selectMonth.selectByValue(sMonth);
						 Select selectYear = new Select(yearDropDwn);
						 selectYear.selectByValue(sYear);
						 address1Txt.sendKeys(sAddress1);
						 updatePatientBtn.click();
						 Thread.sleep(Constant.Medium_Sleep);
						 updateOkBtn.click();
						 Thread.sleep(Constant.Medium_Sleep);
						confirmToken.click();
						Thread.sleep(Constant.Medium_Sleep);
						cancelBtn.click();
						Thread.sleep(Constant.Min_Sleep);
				    }
		    	}
			
		}catch(Exception e){
			System.err.println("Unable to create token "+e);
		}
	}
	public boolean Refund(int rowNo) throws Exception{
		boolean flag = false;
		try{
				AllotToken_MandatoryField(rowNo);
				viewTab.click();
	    		selectPatient(sFName, rowNo);
	    		Thread.sleep(Constant.Min_Sleep);
	    		if(driver.getPageSource().contains("ALLOT TOKEN")){
	    			editPayment.click();
	    			String sRoundOff =  roundOff.getAttribute("value");
	    			refund.click();
	    			String sRefund = refundAmt.getAttribute("value");
	    			CancelApt();
	    			selectPatient(sFName, rowNo);
	    			Thread.sleep(Constant.Min_Sleep);
	    			if(!cancelAptBtn.isEnabled() && sRoundOff.contains(sRefund)){
	    				flag = true;
	    				Constant.log.info("Cancel token test case is successful");
	    			}else{
	    				System.err.println("Cancel Token test case failed ");
	    				Constant.captureScreen_Negative("Cancel Token");
	    			}
	    			Thread.sleep(Constant.Min_Sleep);
	    			driver.navigate().refresh();
	    		}
			
		}catch(Exception e){
			System.err.print("Failed to Refund token"+e);
		}
	    return flag;
	}
	
	public boolean RescheduleCancelledAppt(int rowNo){
		boolean flag = false;
		int actDate;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				Thread.sleep(Constant.Min_Sleep);
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
			}
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			CancelApt();
			CancelledApts.click();
			Thread.sleep(Constant.Min_Sleep);
			WebElement ele = driver.findElement(By.xpath(".//td[2][contains(.,'"+sFName+"')]/following::td[text()='Dr.  Anandanathan ']/following::td[contains(text(),'Testing"+Number+"')]/following::td[text()=' "+Number+"']/following::td/button[text()='RE-SCHEDULE']"));
			ele.click();
			Thread.sleep(Constant.Min_Sleep);
			nextDaySchedule_Reschedule.click();
			SelectSlot_Reschedule();
			rescheduleBTN.click();
			Thread.sleep(Constant.Min_Sleep);
			updateOkBtn.click();
			String lastDateOfMonth = Constant.lastDateOfMonth();
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			Thread.sleep(Constant.Min_Sleep);
			driver.findElement(By.xpath(".//span/span[text()='"+actDate+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			viewTab.click();
			flag = selectPatient(sFName, rowNo);
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.print("Failed to Reschedule cancelled appointment"+e);
		}
	    return flag;
	}
	
	public boolean RescheduleBtn(int rowNo){
		boolean flag = false;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				Thread.sleep(Constant.Min_Sleep);
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
			}
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			CancelApt();
			CancelledApts.click();
			Thread.sleep(Constant.Min_Sleep);
			WebElement ele = driver.findElement(By.xpath(".//td[2][contains(.,'"+sFName+"')]/following::td[text()='Dr.  Anandanathan ']/following::td[contains(text(),'Testing"+Number+"')]/following::td[text()=' "+Number+"']/following::td/button[text()='RE-SCHEDULE']"));
			if(ele.isDisplayed()){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.print("Failed to Reschedule cancelled appointment"+e);
		}
	    return flag;
	}
	
	public boolean CancelApptLnkCalendar_NextDate(){
		boolean flag = false;
		int actDate;
		
		String lastDateOfMonth = Constant.lastDateOfMonth();
		
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(CancelledApts.isDisplayed()){
				CancelledApts.click();
				Thread.sleep(Constant.Min_Sleep);
				DatePicker.click();
				driver.findElement(By.xpath(".//td[@class='day'][text()='"+actDate+"']")).click();
				String value = dateDisplayed_Cancelled.getText().substring(0, 2);
				if(actDate==Integer.parseInt(value)){
					flag = true;
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Calendar next date selection failed"+e);
		}
		return flag;
	}
	
	public boolean CancelApptLnkCalendar_Nextmonth(){
		boolean flag = false;
		int actDate;
		String month;
		String Actmonth = null;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		List<String> months;
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(CancelledApts.isDisplayed()){
				CancelledApts.click();
				Thread.sleep(Constant.Min_Sleep);
				DatePicker.click();
				String ActMonth = Constant.get_Month();
				month = currentMonth.getText();
				if(month.contains(ActMonth)){
					nextMonth.click();
					driver.findElement(By.xpath(".//td[@class='day'][text()='"+actDate+"']")).click();
					months = Constant.monthList();
					for(int i=0; i<months.size();i++){
						if(months.get(i).contains(ActMonth)){
							Actmonth = months.get(i+1);
							break;
						}
					}
					Thread.sleep(Constant.Min_Sleep);
					DatePicker.click();
					month = currentMonth.getText();
					if(month.contains(Actmonth)){
						flag = true;
					}
					driver.navigate().refresh();
				}
			}
		}catch(Exception e){
			System.err.println("Calendar next month selection failed"+e);
		}
		return flag;
	}
	
	public boolean CancelApptLnkCalendar_PreviousMonth(){
		boolean flag = false;
		String month;
		int actDate;
		String Actmonth = null;
		String lastDateOfMonth = Constant.lastDateOfMonth();
		List<String> months;
		try{
			if(lastDateOfMonth.equals(date)){
				actDate = 1;
			}else{
				actDate = Integer.parseInt(date)+1;
			}
			if(CancelledApts.isDisplayed()){
				CancelledApts.click();
				Thread.sleep(Constant.Min_Sleep);
				DatePicker.click();
				String ActMonth = Constant.get_Month();
				month = currentMonth.getText();
				if(month.contains(ActMonth)){
					previousMonth.click();
					driver.findElement(By.xpath(".//td[@class='day'][text()='"+actDate+"']")).click();
					months = Constant.monthList();
					for(int i=0; i<months.size();i++){
						if(months.get(i).contains(ActMonth)){
							Actmonth = months.get(i-1);
							break;
						}
					}
					Thread.sleep(Constant.Min_Sleep);
					DatePicker.click();
					month = currentMonth.getText();
					if(month.contains(Actmonth)){
						flag = true;
					}
					driver.navigate().refresh();
				}
			}
		}catch(Exception e){
			System.err.println("Calendar previous month selection failed"+e);
		}
		return flag;
	}
	 
	public boolean ReportPrint(int rowNo) throws Exception{
		boolean flag = false;
		ReadPropertyFile property = new ReadPropertyFile();
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String sDoctor = xls.get(rowNo).get("Doctor Name");
		try{
			allotToken(rowNo);
			selectPatient(sFName, rowNo);
			driver.navigate().refresh();
			if(reports.isDisplayed()){
				reports.click();
				Thread.sleep(Constant.Min_Sleep);
				if(report_PopUp.isDisplayed()){
					report_FirstName.sendKeys(sFName);
					report_Doctor.sendKeys(sDoctor);
					driver.findElement(By.xpath(".//a[text()='"+sDoctor+" ']")).click();
					Thread.sleep(Constant.Min_Sleep);
					reportSearch.click();
					Thread.sleep(Constant.Min_Sleep);
					reportPrint.click();
					Thread.sleep(Constant.Min_Sleep);
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(1));
					if(reschduleCancel.isDisplayed()){
						reschduleCancel.click();
						 flag = true;
					}
					driver.switchTo().window(tabs2.get(0));
					 Thread.sleep(Constant.Medium_Sleep);
					 flag = true;
					 driver.navigate().refresh();
				}
			}
			
		}catch(Exception e){
			System.err.print("Failed to print report"+e);
		}
    	return flag;
	}
	
	public boolean CancelPopUpMsgValidation(int rowNo){
		boolean flag = false;
		boolean flag1 = false;
		boolean flag2 = false;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				Thread.sleep(Constant.Min_Sleep);
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
		    	viewTab.click();
			}
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("ALLOT TOKEN")){
				cancelAptBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String Message = cancelMsg.getText();
				if(Message.contains("Do you want to cancel Appointment for "+sFName+"!")){
					flag1 = true;
				}
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(Constant.Min_Sleep);
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(Constant.Min_Sleep);
			}
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			Profileupdate(rowNo);
			Token_CashOption(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("ALLOT TOKEN")){
				cancelAptBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				String Message = cancelMsg.getText();
				if(Message.contains("Do you want to cancel Token for "+sFName+"!")){
					flag2 = true;
				}
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(Constant.Min_Sleep);
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(Constant.Min_Sleep);
			}
			driver.navigate().refresh();
			if(flag1 == true && flag2 == true){
				flag = true;
			}
		}catch(Exception e){
			System.err.print("Failed to Reschedule cancelled appointment"+e);
		}
	    return flag;
	}
	
	public boolean CancelFutureAppt(int rowNo){
		boolean flag = false;
		int Value = 0;
		int ActValue = 0;
		try{
	    	nextDay.click();
	    	Thread.sleep(Constant.Min_Sleep);
	    	if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
				Value = AvailablePatients(rowNo);
	    	}
	    	selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
	    	CancelApt();
			  ActValue = AvailablePatients(rowNo);
	    		if(ActValue<Value){
	    			flag = true;
	    		}
		}catch(Exception e){
			System.err.print("Failed to Cancel Appointment"+e);
		}
    	return flag;
	}
	
	public boolean CheckSymptomfield(){
		boolean flag = false;
		try{
	    	
	    	if(addButton.isDisplayed()){
	    		
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
	 			if(driver.getPageSource().contains("ADD A PATIENT")){
					symptoms.sendKeys("Test\\\\\\\\");
		    		String symptom = symptoms.getAttribute("value");
		    		if(!symptom.contains("\\\\\\\\")){
		    			flag = true;
		    		}
	 			}
	 			driver.navigate().refresh();
	    	}
		}catch(Exception e){
			System.err.println("Backslash check in symptom field failed "+e);
		}
		return flag;
	}
	
	public boolean CheckCancelReason(int rowNo){
		boolean flag = false;
		try{
    	
	    	if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
	    	}
	    	selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("ALLOT TOKEN")){
				cancelAptBtn.click();
				cancelReason.sendKeys("Testing"+Number+"\\");
				String Reason = cancelReason.getAttribute("value");
				if(!Reason.contains("\\")){
					flag = true;
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.print("Failed to verify backslash in cancel reason"+e);
		}
    	return flag;
	}
	
	public boolean MandatoryCancelReasonCheck(int rowNo){
		boolean flag = false;
		try{
	    	if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Appointment");
				viewTab.click();
	    	}
	    	selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			if(driver.getPageSource().contains("ALLOT TOKEN")){
				cancelAptBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				if(MandatoryMsg.isDisplayed()){
					flag = true;
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.print("Mandatory reason field check failed"+e);
		}
    	return flag;
	}
	
	public boolean ValidateBookedApptMsg(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sName = xls.get(rowNo).get("Name");
		String number = xls.get(rowNo).get("Mobile Number");
		try{	
	    	if(addButton.isDisplayed()){
				Add_AvailablePatient(rowNo);
				addButton.click();
				Thread.sleep(Constant.Min_Sleep);
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				if(driver.getPageSource().contains("ADD A PATIENT")){
					mobileNumberTxt.sendKeys(number);
		    		Thread.sleep(Constant.Min_Sleep);
		    		for(int i=0;i<AreadyBookedAppt.size();i++){
		    			String Msg = AreadyBookedAppt.get(i).getText();
		    			if(Msg.contains(sName)){
		    				flag = true;
		    				break;
		    			}
		    		}
		    		driver.navigate().refresh();
				}
	    	}
		}catch(Exception e){
			System.err.println("Booked appointment message validation failed "+e);
		}
		return flag;
	}
	
	public boolean ChangePassword(int rowNo) throws Exception{
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sUserId = xls.get(rowNo).get("UserID");
		String sPassword = xls.get(rowNo).get("PasswordId");
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();    
			ChangePasswordBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ChangePasswordPopup.isDisplayed()){
				CurrentPwd.sendKeys(sPassword);
				NewPwd.sendKeys("Welcome");
				ConfirmPwd.sendKeys("Welcome");
				UpdatePwdBtn.click();
				if(userLoginID.isDisplayed()){
					userLoginID.sendKeys(sUserId);
			    	passwordTxt.sendKeys("Welcome");
			    	loginBtn.click();
			    	Thread.sleep(Constant.Medium_Sleep);     
			    	if(addButton.isDisplayed()){
			    		flag = true;
			    		Thread.sleep(Constant.Min_Sleep);
						logoutDropDwn.click();    
						ChangePasswordBtn.click();
						Thread.sleep(Constant.Min_Sleep);
						if(ChangePasswordPopup.isDisplayed()){
							CurrentPwd.sendKeys("Welcome");
							NewPwd.sendKeys(sPassword);
							ConfirmPwd.sendKeys(sPassword);
							UpdatePwdBtn.click();
							Thread.sleep(Constant.Min_Sleep);
							userLoginID.sendKeys(sUserId);
					    	passwordTxt.sendKeys(sPassword);
					    	loginBtn.click();
					    	Thread.sleep(Constant.Medium_Sleep);  
						}
			    	}
				}
			}
		}catch(Exception e){
			System.err.println("Changing password failed "+e);
		}
		return flag;
	}
	
	public boolean ChangePwdwithWrongPwd(){
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();    
			ChangePasswordBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ChangePasswordPopup.isDisplayed()){
				CurrentPwd.sendKeys("test");
				NewPwd.sendKeys("Welcome");
				ConfirmPwd.sendKeys("Welcome");
				UpdatePwdBtn.click();
				if(PwdChangeFailure.isDisplayed()){
					flag = true;
					ClosePwd.click();
				}
			}
		}catch(Exception e){
			System.err.println("Changing password with wrong password failed "+e);
		}
		return flag;
	}
	
	public boolean PwdDoesNotMatchMsg(){
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();    
			ChangePasswordBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ChangePasswordPopup.isDisplayed()){
				CurrentPwd.sendKeys("test");
				NewPwd.sendKeys("Welcome");
				ConfirmPwd.sendKeys("welcome");
				UpdatePwdBtn.click();
				if(PwdDoesNotMatch.isDisplayed()){
					flag = true;
					ClosePwd.click();
				}
			}
		}catch(Exception e){
			System.err.println("Changing password failed "+e);
		}
		return flag;
	}
	
	public boolean CancelBtnPwdpopup(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sPassword = xls.get(rowNo).get("PasswordId");
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();    
			ChangePasswordBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ChangePasswordPopup.isDisplayed()){
				CurrentPwd.sendKeys(sPassword);
				NewPwd.sendKeys("Welcome");
				ConfirmPwd.sendKeys("welcome");
				ClosePwd.click();
				if(addButton.isDisplayed()){
					flag = true;
				}
			}
		}catch(Exception e){
			System.err.println("Changing password failed "+e);
		}
		return flag;
	}
	
	public boolean PwdPopup_MandatoryFieldCheck(){
		boolean flag = false;
		try{
			Thread.sleep(Constant.Min_Sleep);
			logoutDropDwn.click();    
			ChangePasswordBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			if(ChangePasswordPopup.isDisplayed()){
				UpdatePwdBtn.click();
				if(Mandatory_CurrentPwdField.isDisplayed() && Mandatory_NewPwdField.isDisplayed() && Mandatory_ConfirmPwdField.isDisplayed()){
					flag = true;
				}
				ClosePwd.click();
			}
		}catch(Exception e){
			System.err.println("Mandatory field check in password change pop up failed "+e);
		}
		return flag;
	}
	
	public boolean ValidateMultiplePatientPopup(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String number = xls.get(rowNo).get("Mobile Number");
		String sName = xls.get(rowNo).get("Name");
		try{
			Add_AvailablePatient(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
	    		mobileNumberTxt.sendKeys(number);
	    		Thread.sleep(Constant.Min_Sleep);
	    		if(choosePatientDrpDwn.isDisplayed()){
	    			choosePatientDrpDwn.click();
	    			Thread.sleep(Constant.Min_Sleep);
	    			Constant.driver.findElement(By.xpath(".//ul/li/span[text()='"+sName+" ']")).click();
	    		}
	    		Thread.sleep(Constant.Min_Sleep);
	    		bookAppointmentBtn.click();	
			    Thread.sleep(Constant.Max_Sleep);
			    flag = Token_CashOption(rowNo);
			}
		}catch(Exception e){
			System.err.println("failed to validate multiple patient pop up "+e);
		}
		return flag;
	}
	
	public boolean LastSlotTime(){
		boolean flag = false;
		try{
			addButton.click();
			int j = addPatientList.size();
			String text = driver.findElement(By.xpath(".//*[@id='update-slot']/div[2]/div/div/a["+j+"]")).getText();
			if(text.contains("11:45 pm")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Last slot is not 11.45pm "+e);
		}
		return flag;
	}
	
	public boolean FirstSlotTime_FutureDay(){
		boolean flag = false;
		try{
			Calendar_NextDate();
			addButton.click();
			String text = driver.findElement(By.xpath(".//*[@id='update-slot']/div[2]/div/div/a[1]")).getText();
			if(text.contains("12:00 am")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("First slot is not 12:00 am "+e);
		}
		return flag;
	}
	
	public boolean RescheduleSlotsCheck(){
		boolean flag = false;
		try{
			int j = rescheduleSlots.size();
			String LastSlottext = driver.findElement(By.xpath(".//*[@id='postreschedule']/div[1]/span["+j+"]/label")).getText();
			String FirstSlottext = driver.findElement(By.xpath(".//*[@id='postreschedule']/div[1]/span[1]/label")).getText();
			if(LastSlottext.contains("11:45 pm") && FirstSlottext.contains("12:00 am")){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Last slot is not 11.45pm "+e);
		}
		return flag;
	}
	
	public boolean RescheduleApptFutureSlots(int rowNo){
		boolean flag = false;
		try{
			if(RemainingNum.getText().contains("-")){
				BookAppointment(rowNo);
			}else{
				RemainingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				FirstPatient_Remaining.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
					rescheduleBTN_AllotToken.click();
					Thread.sleep(Constant.Min_Sleep);
					nextDaySchedule_Reschedule.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = RescheduleSlotsCheck();
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Last slot of present day reschedule is not 11:45 pm" +e);
		}
		return flag;
	}
	
	public boolean RescheduleApptPresentSlot(int rowNo){
		boolean flag = false;
		try{
			if(RemainingNum.getText().contains("-")){
				BookAppointment(rowNo);
			}else{
				RemainingTab.click();
				Thread.sleep(Constant.Min_Sleep);
				FirstPatient_Remaining.click();
				Thread.sleep(Constant.Min_Sleep);
				if(Constant.driver.getPageSource().contains("ALLOT TOKEN")){
					rescheduleBTN_AllotToken.click();
					Thread.sleep(Constant.Min_Sleep);
					presentDaySchedule_Reschedule.click();
					Thread.sleep(Constant.Min_Sleep);
					flag = RescheduleSlotsCheck();
				}
				driver.navigate().refresh();
			}
		}catch(Exception e){
			System.err.println("Reschedule appointment for present day slots check failed "+e);
		}
		return flag;
	}
	
	public boolean PrintToken_TamilInPopup(int rowNo){
		boolean flag = false;
		try{
			if(addButton.isDisplayed()){
				addButton.click();
				SelectSlot();
				Thread.sleep(Constant.Min_Sleep);
				BookTokenOrAppointment(rowNo, "Token");
			    Profileupdate(rowNo);
			    Print_Tamil.click();
			    confirmToken.click();
				Thread.sleep(Constant.Medium_Sleep);
				yesBtn.click();
				Thread.sleep(Constant.Min_Sleep);
				Robot rb =new Robot();
				rb.keyPress(KeyEvent.VK_ESCAPE);
				rb.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(Constant.Min_Sleep);
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Token print is not displayed"+e);

		}
		return flag;
	}
	
	public boolean PrintToken_TamilAllotTokenPage(int rowNo){
		boolean flag = false;
		try{
			viewTab.click();
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			Print_Tamil.click();
			confirmToken.click();
			Thread.sleep(Constant.Medium_Sleep);
			yesBtn.click();
			Thread.sleep(Constant.Min_Sleep);
			Robot rb =new Robot();
			rb.keyPress(KeyEvent.VK_ESCAPE);
			rb.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(Constant.Min_Sleep);
			flag = true;
		}catch(Exception e){
			System.err.println("Token print is not displayed"+e);

		}
		return flag;
	}
	
	public boolean DiabeticCamp(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist");
		String sPaymentMode = xls.get(rowNo).get("Cash Option");
		try{
			allotToken(rowNo);
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sFName+" "+sLName+"')]/following::td[4][text()='"+sPaymentMode+"']/following::td[text()='0']/following::td[3][text()='Test"+Number+"']"));
			if(searchResult.isDisplayed()){
				flag = true;
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Diabetic camp token details not displayed in report" +e);
		}
		return flag;
	}
	
	public boolean CloseMultipleIDPopUp(int rowNo) throws Exception{
		boolean flag = false;
		List<HashMap<String,String>> xls = ExcelUtils.data(property.getTestDataPath_Medic(),"Receptionist"); 
		String number = xls.get(rowNo).get("Mobile Number");
		String sSymptom = xls.get(rowNo).get("Symptom");
		String sName = xls.get(rowNo).get("Name");
		int Value = 0;
		int ActValue = 0;
		try{
			Value = AvailablePatients(rowNo);
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Medium_Sleep);
			if(Constant.driver.getPageSource().contains("ADD A PATIENT")){
	    		mobileNumberTxt.sendKeys(number);
	    		Thread.sleep(Constant.Min_Sleep);
	    		if(choosePatientDrpDwn.isDisplayed()){
	    			choosePatientDrpDwn.click();
	    			Thread.sleep(Constant.Min_Sleep);
	    			Constant.driver.findElement(By.xpath(".//ul/li/span[text()='"+sName+" ']")).click();
	    		}
	    		symptoms.sendKeys(sSymptom);
	    		Constant.driver.findElement(By.xpath(".//a[text()='"+sSymptom+"']")).click();
	    		bookAppointmentBtn.click();	
			    Thread.sleep(Constant.Max_Sleep);
				confirmToken.click();
				Thread.sleep(Constant.Medium_Sleep);
				MultipleIDPopUp_close.click();
				Thread.sleep(Constant.Min_Sleep);
			}
			viewTab.click();
			ActValue = AvailablePatients(rowNo);
			if(ActValue > Value){
				flag = true;
			}
		}catch(Exception e){
			System.err.println("Token is alloted though pop up is closed "+e);
		}
		return flag;
	}
	
	public boolean bookedApptStatus(int rowNo) throws Exception{
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TodayDate+"']/following::td[5][text()='"+Number+"']/following::td[3][text()='"+sSymptom+"']/following::td[text()='BOOKED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Booked appointment displayed in Reports"+e);
		}
		return flag;
	}
	
	public boolean AllotTokenForAppt_Status(int rowNo) throws Exception{
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo,"Token");
			driver.navigate().refresh();
			selectPatient(sFName,rowNo);
			Thread.sleep(Constant.Min_Sleep);
			Profileupdate(rowNo);
			Token_CashOption(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			 editPayment.click();
			 String fee = roundOff.getAttribute("value");
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TodayDate+"']/following::td[4][contains(.,'"+fee+"')]/following::td[text()='"+Number+"']/following::td[2][contains(.,'Test"+Number+"')]/following::td[text()='"+sSymptom+"']/following::td[text()='TOKEN ALLOCATED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Alloted token not displayed in Reports "+e);
		}
		return flag;
	}
	
	public boolean FutureDayApt_Reports(int rowNo){
		boolean flag = false;
		try{
			Calendar_NextDate();
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TomorrowDate+"']/following::td[5][text()='"+Number+"']/following::td[3][text()='"+sSymptom+"']/following::td[text()='BOOKED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Future day appointment record not displayed in reports");
		}
		return flag;
	}
	  
	public boolean AllotToken_Reports(int rowNo){
		boolean flag = false;
		try{
			allotToken(rowNo);
			selectPatient(sFName, rowNo);
			Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			 editPayment.click();
			 String fee = roundOff.getAttribute("value");
			driver.navigate().refresh();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TodayDate+"']/following::td[4][contains(.,'"+fee+"')]/following::td[text()='"+Number+"']/following::td[2][contains(.,'Test"+Number+"')]/following::td[text()='"+sSymptom+"']/following::td[text()='TOKEN ALLOCATED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Alloted token not displayed in Reports "+e);
		}
		return flag;
	}
	
	public boolean RescheduleApt_Reports(int rowNo){
		boolean flag = false;
		String[] status = {"CANCELLED", "BOOKED"};
		try{
			bookedApptStatus(rowNo);
			Reschedule(sFName, rowNo);
			reports.click();
			Thread.sleep(Constant.Min_Sleep);
			CheckReportEntry();
			for(int i=0; i<ReportStatusList.size()-1;i++){
				if(ReportStatusList.size()-1 == 2){
					if(ReportStatusList.get(i).getText().contains(status[i])){
						flag = true;
					}
				}
			}
 			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Rescheduled appointment status check failed "+e);
		}
		return flag;
	}
	
	public void CheckReportEntry() throws InterruptedException{
		int sdate = Integer.parseInt(date)+1;
		try{
			report_StartDate.click();
			driver.findElement(By.xpath(".//td[@class='today active day']")).click();
			report_EndDate.click();
			driver.findElement(By.xpath(".//td[@class='day'][text()='"+sdate+"']")).click();
			Thread.sleep(Constant.Min_Sleep);
			report_FirstName.sendKeys(sFName);
			fieldReq.click();
			Thread.sleep(Constant.Min_Sleep);
			selectAllCheckbox.click();
			reportSearch.click();
		}catch(Exception e){
			System.err.println("Check entry count for the patient failed "+e);
		}
	}
	
	public boolean RescheduledToken_Reports(int rowNo){
		boolean flag = false;
		String[] status = {"TOKEN ALLOCATED", "BOOKED"};
		try{
			AllotToken_Reports(rowNo);
			Reschedule(sFName, rowNo);
			reports.click();
			Thread.sleep(Constant.Min_Sleep);
			CheckReportEntry();
			for(int i=0; i<ReportStatusList.size()-1;i++){
				if(ReportStatusList.size()-1 == 2){
					if(ReportStatusList.get(i).getText().contains(status[i])){
						flag = true;
					}
				}
			}
 			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("validating rescheduled token status in reports failed"+e);
		}
		return flag;
	}
	
	public boolean CancelAptStatus_Reports(int rowNo){
		boolean flag = false;
		try{
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			CancelApt();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TodayDate+"']/following::td[5][text()='"+Number+"']/following::td[3][text()='"+sSymptom+"']/following::td[text()='CANCELLED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Cancelled appointment status in reports failed "+e);
		}
		return flag;
	}
	
	public boolean CancelAptStatus_FutureReport(int rowNo){
		boolean flag = false;
		try{
			Calendar_NextDate();
			addButton.click();
			SelectSlot();
			Thread.sleep(Constant.Min_Sleep);
			BookTokenOrAppointment(rowNo, "Appointment");
			selectPatient(sFName, rowNo);
	    	Thread.sleep(Constant.Min_Sleep);
			String sMedicID = medicID.getAttribute("value").substring(12);
			CancelApt();
			searchReport(rowNo,sFName);
			WebElement searchResult = driver.findElement(By.xpath(".//td[contains(.,'"+sMedicID+"')]/following::td[contains(.,'"+sFName+"')]/following::td[text()='"+TomorrowDate+"']/following::td[5][text()='"+Number+"']/following::td[3][text()='"+sSymptom+"']/following::td[text()='CANCELLED']"));
			if(searchResult.isDisplayed()){
				resetReport.click();
				Thread.sleep(Constant.Min_Sleep);
				CheckReportEntry();
				for(int i=0; i<ReportStatusList.size();i++){
					if(ReportStatusList.size()-1 == 1){
						flag = true;
					}
				}
			}
			driver.navigate().refresh();
		}catch(Exception e){
			System.err.println("Future day Cancelled appointment status in reports failed "+e);
		}
		return flag;
	}
	
	
}
