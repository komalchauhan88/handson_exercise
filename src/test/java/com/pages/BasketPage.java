package test.java.com.pages;

import main.java.com.Elements.Element;
import main.java.com.framework.setup.BasePage;

public class BasketPage extends BasePage {

    private Element checkoutButton = new Element("//div[@class='basket-checkout']/div[2]/a[1]", Element.LocatorType.XPATH);

    public void clickOnContinueToCheckout() {
        checkoutButton.click();
    }
}
