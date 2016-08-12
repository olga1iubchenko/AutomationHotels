package Lesson7.Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterNewHotelPage {
	
	private WebDriver driver;
	
    @FindBy(id="add_hotel:name")
    private WebElement nameField;
    
    @FindBy (id="add_hotel:dateOfConstruction_input")
    private WebElement dateOfConstructionField;
    
    @FindBy (id="add_hotel:rate_input")
    private WebElement getGlobalRaiting;
    
    @FindBy (id="add_hotel:country")
    private WebElement expandCountryDDL;
    
    @FindBy (id="add_hotel:country_label")
    private WebElement selectedCountry;
    
    public RegisterNewHotelPage(WebDriver driver){
    	PageFactory.initElements(driver, this);
    	this.driver=driver;
    }
    
    public void setNameField(String value){
    	nameField.sendKeys(value);
    }

    public String getNameFieldValue(){
     return nameField.getAttribute("value");
    }
    
    public void setDateOfConstructionFieldValue(String value){
    	dateOfConstructionField.sendKeys(value);
    }
    
    public String getDateOfConstructionFieldValue(){
    	return dateOfConstructionField.getAttribute("value");
    }
    
    public void setHotelGlobalRaiting(String countOfStars){
    	driver.findElement(By.xpath("//div[@id='add_hotel:rate']/div[@class='ui-rating-star']["+countOfStars+"]/a")).click();
    }
    
    public String getHotelGlobalRaiting(){
    	return getGlobalRaiting.getAttribute("value");
    }
    
    public void selectHotelCountry(String country){
    	expandCountryDDL.click();
    	driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }
    
    public String getHotelCountry(){
    	return selectedCountry.getText();
    }
    
}
