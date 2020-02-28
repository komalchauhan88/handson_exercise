package test.java.com.tests;

import main.java.com.framework.setup.BaseTest;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class JohnLewisTest extends BaseTest {

    @Given("we navigate to following $url")
    public void navigateToURL(String url) {
        loginPage.navigateToURL(url);
    }

    @When("we search for following $product")
    public void searchForProduct(String product) {
        loginPage.setSearchBox(product);
    }

    @When("we add the product to basket")
    public void addProductToBasket() {
        loginPage.navigateToFirstItem();
        loginPage.clickOnAddToBasket();
        loginPage.clickOnGoToBasket();
    }

    @When("we continue to checkout")
    public void whenWeContinueToCheckOut() {
        basketPage.clickOnContinueToCheckout();
    }

    @When("we use following $email to checkout as guest")
    public void checkEmail(String email) {
        checkoutPage.clickOnCheckoutAsGuest();
        checkoutPage.enterEmail(email);
    }

    @When("we select $option as checkoutOption")
    public void selectCheckOutOption(String option) {
        deliveryPage.setSelectCheckOutOption(option);
    }

    @When("we add following delivery address: $deliveryAddress")
    public void selectDeliveryOption(ExamplesTable deliveryAddress) {
    deliveryAddress.getRow(0).entrySet().stream().forEach(entry->{
        deliveryPage.enterValueInField(entry.getKey(), entry.getValue());
    });
    deliveryPage.clickOnContinueToCheckOut();
    }

    @When("we choose $deliveryOption with days plus $days")
    public void selectDeliveryOption(String deliveryOption, String days) {
        deliveryPage.clickOnDeliveryOption(deliveryOption, days);
    }

    @When("we click on continue to payment")
    public void clickOnContinueTpPayment() {
        deliveryPage.clickOnContinueToPayment();
    }

    @Then("we take a screenshot of the reviewPage")
    public void takeScreenShot() throws Exception{
       deliveryPage.takeScreenShot();
    }

}
