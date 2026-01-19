package pages;

import constants.EndPoint;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class StorePage extends BasePage {
    private By optionContainer = By.cssSelector("select[name='orderby']");



    public StorePage(WebDriver driver) {
        super(driver);
    }

    public void openStorePage(){
        load(EndPoint.STORE.url);
    }
//---------Sorting methods------------------
    public void sortBy(String optionValue){
        WebElement dropdown=  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(optionContainer)));
        dropdown.click();
        Select select = new Select(dropdown);
        select.selectByVisibleText(optionValue);
    }

    public List<Double> productsSortedAscendingOrder(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> products = driver.findElements(By.cssSelector(".astra-shop-summary-wrap"));
        List<Double> prices = new ArrayList<>();

        for (WebElement product : products) {

            WebElement priceElement = product.findElement(
                    By.cssSelector("span.woocommerce-Price-amount.amount bdi")
            );

            String text = priceElement.getText();
            text = text.replaceAll("[^0-9.]", "");

            prices.add(Double.parseDouble(text));
        }
        return prices;
    }
//---------End of sorting methods-----------

//----------Cart methods----------
    public void addProductToCart(String productName){
        By product = By.xpath("//h2[normalize-space()='"+productName+"']");
        By addToCartBtn = By.xpath("//a[contains(@aria-label, 'Add') and contains(@aria-label, '"
                + productName + "')]");

        WebElement productElement =  wait.until(driver ->
                driver.findElement(product));
        System.out.println("Title: "+productElement.getText());
        productElement.findElement(addToCartBtn).click();
    }

    public boolean isProductInCart(String productName){
        return driver.findElements(By.xpath("//td[@class='product-name']//a[normalize-space()='" +productName+ "']")).size()> 0;

    }
//------------End of Cart methods------------

}
