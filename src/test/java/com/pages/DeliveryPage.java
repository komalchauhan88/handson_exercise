package test.java.com.pages;

import main.java.com.Elements.Element;
import main.java.com.framework.setup.BasePage;

public class DeliveryPage extends BasePage {

    private Element selectCheckOutOption = new Element("//div[contains(@class,'delivery-choice_container')]/button[1]", Element.LocatorType.XPATH);

    private Element title = new Element("//input[@id='title']", Element.LocatorType.XPATH);

    private Element firstName = new Element("//input[@id='firstName']", Element.LocatorType.CSS);

    private Element lastName = new Element("//input[@id='lastName']", Element.LocatorType.CSS);

    private Element phoneNumber = new Element("//input[@id='phoneNumber-number']", Element.LocatorType.CSS);

    private Element address = new Element("//input[@id='addressLine1']", Element.LocatorType.CSS);

    private Element town = new Element("//input[@id='townOrCity']", Element.LocatorType.CSS);

    private Element postcode = new Element("//input[@id='postcode']", Element.LocatorType.CSS);

    private Element continueToCheckOut = new Element("", Element.LocatorType.CSS);

    private Element enterAddressManually = new Element("//span[text()='Enter address manually']", Element.LocatorType.XPATH);

    private Element useThisAddress = new Element("//button[@id='deliveryAddressForm']", Element.LocatorType.XPATH);

    private Element nextOrNamedDayDeliveryOption = new Element("//div[contains(@class,'delivery-details_container')]/form/fieldset/div/div[2]", Element.LocatorType.XPATH);

    private Element availableDates = new Element("//button[contains(@class,'dateButton--available')]", Element.LocatorType.XPATH);

    private Element continueToPayment = new Element("//span[text()='Continue to payment']", Element.LocatorType.XPATH);

    public void setSelectCheckOutOption(String option) {
        selectCheckoutOption(option);
    }

    private void selectCheckoutOption(String option) {
        switch (option) {
            case "delivery" :
                selectCheckOutOption.click();
        }
    }

    public void enterValueInField(String field, String value) {
        switch (field) {
            case "title":
                sendKeys(title, value);
            case "firstName":
                sendKeys(firstName, value);
            case "lastName":
                sendKeys(lastName, value);
            case "phoneNumber":
                sendKeys(phoneNumber, value);
                clickOnEnterAddressManually();
            case "address":
                sendKeys(address, value);
            case "town":
                sendKeys(town, value);
            case "postcode":
                sendKeys(postcode, value);
                clickOnUseThisAddress();
        }
    }

    private void sendKeys(Element element, String value) {
        element.getElement().sendKeys(value);
    }

    private void clickOnEnterAddressManually() {
        enterAddressManually.getElement().click();
    }

    public void clickOnContinueToCheckOut() {
        continueToCheckOut.getElement().click();
    }

    public void clickOnUseThisAddress() {
        useThisAddress.getElement().click();
    }

    public void clickOnDeliveryOption(String option, String days) {
        switch (option) {
            case "nextOrNamedDayDelivery":
                nextOrNamedDayDeliveryOption.getElement().click();
                selectDeliveryDate(days);
        }
    }

    public void selectDeliveryDate(String date) {
        availableDates.getElements().get(Integer.parseInt(date)-1).click();
    }

    public void clickOnContinueToPayment() {
        continueToPayment.click();
    }
}
