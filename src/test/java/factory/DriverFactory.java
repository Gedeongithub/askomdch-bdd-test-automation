package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigLoader;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigLoader.getInstance().getChrome());
                driver = new ChromeDriver();
//                driver.manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gekco.driver", ConfigLoader.getInstance().getFirefox());
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver",ConfigLoader.getInstance().getEdge());
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalStateException("Invalid browser: "+browser);
        }

        DriverFactory.driver.set(driver);
        return driver;
    }
    public static WebDriver getDriver(){
        return driver.get();
    }
}
