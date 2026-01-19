package stepdefinitions;

import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.StorePage;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortingSteps {
    private WebDriver driver = Hooks.driver;
    private List<Double> expectedAscendingDataList = List.of(12.0, 20.0, 25.0, 34.0, 35.0, 34.0, 45.0, 45.0);
    private List<Double> expectedDescendingDataList = List.of(145.0, 100.0, 100.0, 100.0, 75.0, 45.0, 45.0, 34.0);

    @When("I sort products by Sort by price: low to high in ascending order")
    public void SortProductInAscendingOrder(DataTable tableList) {
        Map<String,String> sortOption = tableList.asMap(String.class,String.class);
        new StorePage(driver).sortBy(sortOption.get("SortOption"));
    }

    @Then("products should be displayed in ascending order of price")
    public void productsShouldBeDisplayedInAscendingOrderOfPrice() {
        System.out.println("They are sorted");
        new StorePage(driver).productsSortedAscendingOrder();
        assertEquals("Products are not well sorted form low to high price",expectedAscendingDataList, new StorePage(driver).productsSortedAscendingOrder());
    }

    @When("I sort products by Sort by price: high to low in descending order")
    public void SortProductsInDescendingOrder(DataTable tableList) {
        Map<String,String> sortOption = tableList.asMap(String.class,String.class);
        new StorePage(driver).sortBy(sortOption.get("SortOption"));
    }

    @Then("products should be displayed in descending order of price")
    public void productsShouldBeDisplayedInDescendingOrderOfPrice() {
        System.out.println("They are sorted");
        new StorePage(driver).productsSortedAscendingOrder();
        assertEquals("Products are not well sorted from high to low price",expectedDescendingDataList, new StorePage(driver).productsSortedAscendingOrder());
    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {
        new StorePage(driver).sortBy(sortOption);
    }

    @Then("products should be sorted by {string}")
    public void productsShouldBeSortedBy(String SortOption) {
        System.out.println("Products are sorted by: "+SortOption);
    }
}
