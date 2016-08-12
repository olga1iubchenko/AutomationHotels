package Lesson7.Automation;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class HotelTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void appstate(){
		driver = new FirefoxDriver();	
		driver.get("http://localhost:8080/article/faces/hotel.xhtml");
	} 
	
	@Test
	public void testNewHotelNameValue(){
		
		RegisterNewHotelPage newHotelPage = new RegisterNewHotelPage(driver);
		
		String expected = "test123";
		newHotelPage.setNameField(expected);
		
		String actualNameFieldValue = newHotelPage.getNameFieldValue();
		
		AssertJUnit.assertEquals(actualNameFieldValue, expected);
	}
	
	@Test
	public void testNewHotelDateOfConstructionValue(){
        RegisterNewHotelPage newHotelPageDateOfConstructionField = new RegisterNewHotelPage(driver);
        
        String expectedDateOfConstruction = "12/16/2005";
        newHotelPageDateOfConstructionField.setDateOfConstructionFieldValue(expectedDateOfConstruction);
        
        String actualDateOfConctructionFieldValue = newHotelPageDateOfConstructionField.getDateOfConstructionFieldValue();
        
        Assert.assertEquals(actualDateOfConctructionFieldValue, expectedDateOfConstruction);
	}
	
	@Test
	public void testHotelGlobalRaitingValue(){
        RegisterNewHotelPage newHotelGlobalraiting = new RegisterNewHotelPage(driver);
        
        String expectedGlobalRaitingValue = "2";
        newHotelGlobalraiting.setHotelGlobalRaiting(expectedGlobalRaitingValue);
        
        String actualHotelGlobalRaitingValue = newHotelGlobalraiting.getHotelGlobalRaiting();
        
        Assert.assertEquals(actualHotelGlobalRaitingValue, expectedGlobalRaitingValue);
	}
	
	@Test
	public void testSelectedHotelCountry(){
        RegisterNewHotelPage newHotelCountry = new RegisterNewHotelPage(driver);
        
        String expectedSelectedCountry = "Ukraine";
        newHotelCountry.selectHotelCountry(expectedSelectedCountry);
        
        String actualHotelCountrySelected = newHotelCountry.getHotelCountry();
        
        Assert.assertEquals(actualHotelCountrySelected, expectedSelectedCountry);
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();	
		}
	}



//String footballUA = "football.ua";
//google = PageFactory.initElements(driver, GooglePage.class);
//google = google.setValue(footballUA);
//google = google.clickFind();
//FootballUaPage footballUAPage = google.clickLink(footballUA);
//Assert.assertTrue(footballUAPage.isOpened());