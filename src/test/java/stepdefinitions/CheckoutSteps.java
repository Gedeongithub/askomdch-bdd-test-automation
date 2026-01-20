package stepdefinitions;

import domain_objects.BillingDetails;
import hooks.Hooks;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;

public class CheckoutSteps {
    private WebDriver driver = Hooks.driver;
    private BillingDetails billingDetails;


    @And("I proceed to the Checkout page")
    public void iProceedToTheCheckoutPage() {
     new CheckoutPage(driver).openCheckoutPage();
    }

    @When("I fill in the checkout form with valid details")
    public void iFillInTheCheckoutFormWithValidDetails(BillingDetails billingDetails) {
        new CheckoutPage(driver).setBillingDetails(billingDetails);
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        new CheckoutPage(driver).clickPlaceOrderButton();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {

    }

    @And("I should see an order confirmation message")
    public void iShouldSeeAnOrderConfirmationMessage() {

    }
}
