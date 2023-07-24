package tests;

import org.testng.annotations.Test;
import servise.BaseSteps;
import steps.CheckoutSteps;

public class OrderProcessing extends BaseSteps {

    CheckoutSteps checkoutSteps = new CheckoutSteps();

    @Test(description = "Добавление товара в корзину")
    public void productClearance() {
        loginInOnStartPage();
        getSauceLabsBackpackInCart();
        checkoutSteps.openFormYourInformation();
        checkoutSteps.editYourInformation();
        checkoutSteps.continueCheckInformation();
        checkoutSteps.clickFinishButton();
    }

}
