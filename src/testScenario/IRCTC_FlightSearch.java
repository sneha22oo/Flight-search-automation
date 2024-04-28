package testScenario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testObjectRepository.IRCTC_FlightSearchElements_Page;
import userDefinedLibraries.DriverSetup;
import userDefinedLibraries.ScreenShot;

public class IRCTC_FlightSearch {
	
	 public static WebElement popUp, validation, logo, from, hyderabadoption, to, puneoption, todayDate, travellerDropDown, dropdown, search, validateFrom, validateTo, w ;
	 public static WebDriver driver;
	 
	 
	//Instantiate driver
	 public static void driverconfig(String browser)
	    { 
	    	driver=DriverSetup.driverInstantiate(browser);   
	    }
	 
	 //Validating the Site
	 public static void siteValidation() {
		 
		 String cururl=driver.getCurrentUrl();
		 String expurl="https://www.air.irctc.co.in";
		 if(cururl.contains(expurl)){
				System.out.println("The Appropriate site Opened");
			}else {
				System.out.println("The Appropriate site not opened");
			}
		 }
	 
	 //Closing the PopUp
	 public static void handlePopUps() {
		 popUp=IRCTC_FlightSearchElements_Page.getPopUp(driver);
		 
		 popUp.click();
	 }
	 
	 //Validating the Application
	 public static void applicationValidation() {
		 logo=IRCTC_FlightSearchElements_Page.getLogo(driver);
			if(logo.isDisplayed()) {
				System.out.println("Appropriate Application Opened Successfully");
			}else {
				System.out.println("Appropriate Application is not Opened");
			}
	 }
	 
	 //Sending "HYD" In From TextBox
	 public static void insertTextInFromAndSelectHyderabad()  {
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 from=IRCTC_FlightSearchElements_Page.getFrom(driver);
		 from.click();
		 from.sendKeys("Hyd");
	
	 }
	 
	 //Clicking On Hyderabad City
	 public static void selectHyderabad() 
	 {
		 hyderabadoption=IRCTC_FlightSearchElements_Page.getFromOptions(driver);
		   if(hyderabadoption.getText().contains("HYD")) {
			   hyderabadoption.click();
		   }
	 }
	 
	 //Sending "Pune" In To TextBox
	 public static void insertTextInTo() {
		to=IRCTC_FlightSearchElements_Page.getTo(driver);
		 to.click();
		   to.sendKeys("Pune");
	 }
	 
	 //Clicking On Pune City
	 public static void selectPune() {
		 puneoption=IRCTC_FlightSearchElements_Page.getToOption(driver);
		 if(puneoption.getText().contains("PNQ")) {
			  puneoption.click();
		 }
	 }
	 
	 //Clicking On Today Date
	 public static void selecttodayDate() {
		 todayDate=IRCTC_FlightSearchElements_Page.getDate(driver);
		 todayDate.click();
		 
	 }
	 
	 //Clicking On TravellerDetails
	 public static void clickOnTravellerDetails() {
		 travellerDropDown=IRCTC_FlightSearchElements_Page.getTravellerDetail(driver);
		 travellerDropDown.click();
	 }
	 
	 //Clicking On Business Class
	 public static void selectBusinessClass() {
		 dropdown=IRCTC_FlightSearchElements_Page.getTravellerDropDown(driver);
		 Select drp=new Select(dropdown);
		   drp.selectByVisibleText("Business");
	 }
	 
	 //Clicking On Search Button
	 public static void clickSearch() {
		 search=IRCTC_FlightSearchElements_Page.getSearchButton(driver);
		 search.click();
	 }
	 
	 //Validating FROM City
	 public static void validatingFromCity() {
		   validateFrom=IRCTC_FlightSearchElements_Page.checkFrom(driver);
		   String actcity="Hyderabad(HYD)";
		   String presentCity=validateFrom.getText();
		   if(actcity.contains(presentCity)) {
				  System.out.println("From City matched");
			   }else {
				  System.out.println("From City not matched");
			   }   
	 }
	 
	 //Validating TO City
	 public static void validatingToCity() {
		 validateTo=IRCTC_FlightSearchElements_Page.checkTo(driver);
		 String acttocity="Pune(PNQ)";
		 String presenttocity=validateTo.getText();
		 if(acttocity.contains(presenttocity)) {
			  System.out.println("Destination City matched");
		   }else {
			  System.out.println("Destination City not matched");
		   }
	 }
	 
	 //Validating DATE 
	 public static void validatingDate() {
		  LocalDate date1=LocalDate.now();
		  DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		  
		  String actDate=date1.format(dtf);
		  WebElement selecteddate=IRCTC_FlightSearchElements_Page.checkDate(driver);
		  System.out.println(actDate);
		  System.out.println(selecteddate.getAttribute("value"));
		  if(actDate.equals(selecteddate.getAttribute("value"))) {
			  System.out.println("Date Matched");
		  }else {
			  System.out.println("Date Not Matched");
		  }
	 }
	 
	 //Todays Flight Details
	 public static void flightDetails(){
		 try {
		 List<WebElement> flightDetails=IRCTC_FlightSearchElements_Page.getFlightDetails(driver);
		 
		 System.out.println("Total Number Of Flights Available For Today : "+flightDetails.size());
		 
		 if(flightDetails.size()==0) 
		 {
			 System.out.println("There Is No Flights Available Today From Afternoon Onward.");
		 }
		
		 for(WebElement f:flightDetails)
		  {
		    System.out.println("Available Flight Name and Number: "+f.getText());
		  }
		 }
		 
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 try {
		 ScreenShot.screenShotOfResultPage(driver,"result_page.png");
		 }
		 catch(Exception e) {
			e.printStackTrace();
		 }
		 
		 List<WebElement>  results=IRCTC_FlightSearchElements_Page.getResults(driver);
		 int i=1;
		 for(WebElement w:results){
			 ScreenShot.screenShotOfResults(w, "result"+i+".png");
			 i++;
		 }   
	 }
	 
	 
	 public static void tearDown() {
		 DriverSetup.driverTearDown();
	 }

	public static void main(String[] args) 
	{
		String browser="";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter browser type (Chrome/Edge)");
		browser=sc.nextLine();
		sc.close();
		driverconfig(browser);
		
		//Calling Methods
		siteValidation();
		handlePopUps();
		applicationValidation();
		insertTextInFromAndSelectHyderabad();
		selectHyderabad();
		insertTextInTo();
		selectPune();
		selecttodayDate();
		clickOnTravellerDetails();
		selectBusinessClass();
		clickSearch();
		validatingFromCity();
		validatingToCity();
		validatingDate();
		flightDetails();
		tearDown();
		
	}

}
