package test.java.com.pages;

import main.java.com.Elements.Element;
import main.java.com.framework.setup.BasePage;

public class LoginPage extends BasePage {

    private Element searchBox = new Element("#desktopSearch", Element.LocatorType.CSS);
    private Element firstItem = new Element("//div[@class='product-list-container']/div[1]/section[1]/div[1]/a/img", Element.LocatorType.XPATH);
    private Element addToBasket = new Element("//form/input[@value='237624164']/parent::form/button", Element.LocatorType.XPATH);
    private Element goToBasket = new Element("//form/input[@value='237624164']/parent::form/a", Element.LocatorType.XPATH);

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void setSearchBox(String product) {
        searchBox.sendKeys(product);
        pressEnterKey();
    }

    public void navigateToFirstItem() {
        getActions().moveToElement(firstItem.getElement()).build().perform();
    }

    public void clickOnAddToBasket() {
        addToBasket.click();
    }

    public void clickOnGoToBasket() {
        goToBasket.click();
    }
}
