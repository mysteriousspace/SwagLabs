package tests;

import org.testng.annotations.Test;
import servise.BaseSteps;
import steps.CartSteps;
import steps.ProductSteps;

public class DeleteItemFromCart extends BaseSteps {
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test(description = "Удаление товара из корзины")
    public void removeBackPackFromCart() {
        loginInOnStartPage();
        removeAllItemFromCart();
        productSteps.addBackpackInCart();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.removeBackPack();
        cartSteps.continueShoppingOnProduct();
    }

}
