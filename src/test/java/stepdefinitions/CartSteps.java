package stepdefinitions;

import domain_objects.Product;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.*;
import java.util.List;

public class CartSteps {
    private final WebDriver driver = Hooks.driver;

    @Given("I am on the Store page")
    public void iAmOnTheStorePage() {
        new StorePage(driver).openStorePage();
    }

    @When("I add the following products to the cart")
    public void iAddToTheCart(List<Product> products) {
//        List<String> products = dataTable.asList(String.class);

        for(Product product:products){
            new StorePage(driver).addProductToCart(product.getName());
        }

    }

    @And("open Cart page")
    public void openCartPage() {
       new CartPage(driver).openCartPage();
    }

    @Then("products should be added to the cart")
    public void shouldBeAddedToTheCart(List<Product> products) {
//        List<String> products = dataTable.asList(String.class);
        for (Product product : products) {
            new StorePage(driver).isProductInCart(product.getName());
        }
    }
}
