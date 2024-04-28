package testObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IRCTC_FlightSearchElements_Page {
	
	public static WebElement element = null;
	public static WebDriver driver;
	
	//Handling PopUp
	public static WebElement getPopUp(WebDriver driver) {
		element=driver.findElement(By.xpath("//button[contains(text(),'Later')]"));
		return element;
		}
	
	//Verifying Application Using LOGO WebElement
	public static WebElement getLogo(WebDriver driver) {
		element=driver.findElement(By.xpath("//img[@alt='air-logo.png']"));
		return element;
	}
	
	//Getting From City
	public static WebElement getFrom(WebDriver driver) {
		 element= driver.findElement(By.xpath("//input[@name='From']"));
		 return element;
	}
	
	//Selecting Hyderabad City 
	public static WebElement getFromOptions(WebDriver driver){		
		element=driver.findElement(By.xpath("//div[contains(text(),'HYD')]"));
		return element; 
	}
	
	//Getting To City
	public static WebElement getTo(WebDriver driver) {
		element=driver.findElement(By.xpath("//input[@name='To']"));
		return element; //By.id("stationTo")
	}
	
	//Selecting Pune City 
	public static WebElement getToOption(WebDriver driver) {
		element=driver.findElement(By.xpath("//ul[@id='ui-id-2']//div[contains(text(),'PNQ')]"));
		return element; 
	}
	
	//Selecting Present Date
	public static WebElement getDate(WebDriver driver) {
		element=driver.findElement(By.xpath("//span[@class='act active-red']"));
		return element;
	}
	
	//Selecting Traveller Detail
	public static WebElement getTravellerDetail(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id='noOfpaxEtc']"));
		return element;
	}
	
	//Selecting Traveller Class Detail
	public static WebElement getTravellerDropDown(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[@id='travelClass']"));
		return element;
	}
	
	//Selecting Search Button
	public static WebElement getSearchButton(WebDriver driver) {
		element=driver.findElement(By.xpath("//*[contains(text(),'Search')] "));
		return element;
	}
	
	//Checking From City
	public static WebElement checkFrom(WebDriver driver) {
		element=driver.findElement(By.name("From"));
		return element;
	}
	
	//Checking To City
	public static WebElement checkTo(WebDriver driver) {
		element=driver.findElement(By.id("stationTo"));
		return element;
	}
	
	//Checking Date
	public static WebElement checkDate(WebDriver driver) {
		element=driver.findElement(By.xpath("//input[@id='originDate']"));
		return element;
	}
	
	//Selecting Flight Details
	public static List<WebElement> getFlightDetails(WebDriver driver){
		List<WebElement>  flightDetails=driver.findElements(By.xpath("//*[@class='right-searchbarbtm-in']/div[1]"));
		return flightDetails;
	}
	
	//Capturing ScreenShot
	public static List<WebElement> getResults(WebDriver driver){
		 List<WebElement> results=driver.findElements(By.xpath("//div[@class='right-searchbarbtm']"));
		 return results;
	}

}
