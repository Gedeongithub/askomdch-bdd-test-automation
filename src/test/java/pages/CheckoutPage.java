package pages;

import constants.EndPoint;
import domain_objects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage{
    private final By FirstName = By.id("billing_first_name");
    private final By LastName = By.id("billing_last_name");
    private final By StreetAddress= By.id("billing_address_1");
    private final By City = By.id("billing_city");
    private final By Phone = By.id("billing_phone");
    private final By Email = By.id("billing_email");
    private final By ZIPCode = By.id("billing_postcode");
    private final By placeOrderButton = By.id("place_order");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void openCheckoutPage(){
        load(EndPoint.CHECKOUT.url);
    }

    public void setBillingDetails(BillingDetails billingDetails){
        enterFirstName(billingDetails.getBillingFirstName()).
                enterLastName(billingDetails.getBillingLastName()).
                enterStreetAddress(billingDetails.getBillingStreetAddress()).
                enterCity(billingDetails.getBillingCity()).
                enterZIPCode(billingDetails.getBillingZipCode()).
                enterPhone(billingDetails.getBillingPhone()).
                enterEmail(billingDetails.getBillingEmail());

    }


    public CheckoutPage enterFirstName(String firstname){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(FirstName)));
        element.clear();
        element.sendKeys(firstname);
        return this;
    }
    public CheckoutPage enterLastName(String lastname){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(LastName)));
        element.clear();
        element.sendKeys(lastname);
        return this;
    }
    public CheckoutPage enterStreetAddress(String address){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(StreetAddress)));
        element.clear();
        element.sendKeys(address);
        return this;
    }
    public CheckoutPage enterCity(String city){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(City)));
        element.clear();
        element.sendKeys(city);
        return this;
    }
    public CheckoutPage enterPhone(String phone){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(Phone)));
        element.clear();
        element.sendKeys(phone);
        return this;
    }
    public CheckoutPage enterEmail(String email){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(Email)));
        element.clear();
        element.sendKeys(email);
        return this;
    }
    public CheckoutPage enterZIPCode(String zipCode){
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(ZIPCode)));
        element.clear();
        element.sendKeys(zipCode);
        return this;
    }
    public CheckoutPage clickPlaceOrderButton(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(placeOrderButton))).click();
        return this;
    }



}
