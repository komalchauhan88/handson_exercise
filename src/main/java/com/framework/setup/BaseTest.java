package main.java.com.framework.setup;

import com.drivers.DriverFactory;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.openqa.selenium.WebDriver;
import test.java.com.pages.BasketPage;
import test.java.com.pages.CheckoutPage;
import test.java.com.pages.DeliveryPage;
import test.java.com.pages.LoginPage;

public class BaseTest {

    public static WebDriver driver = null;
    protected LoginPage loginPage;
    protected DeliveryPage deliveryPage;
    protected BasketPage basketPage;
    protected CheckoutPage checkoutPage;

    @BeforeScenario
    public void setup() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage();
        deliveryPage = new DeliveryPage();
        basketPage = new BasketPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterScenario
    public void end() {
        driver.quit();
    }

}
