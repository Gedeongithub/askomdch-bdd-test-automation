package pages;

import constants.EndPoint;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCartPage(){
        load(EndPoint.CART.url);
    }
}
