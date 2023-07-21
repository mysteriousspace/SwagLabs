package tests;

import org.testng.annotations.Test;
import servise.BaseSteps;
import steps.CartSteps;
import steps.ProductSteps;

public class GetItemInCart extends BaseSteps {
    ProductSteps productSteps = new ProductSteps();
    CartSteps cartSteps = new CartSteps();

    @Test(description = "Добавление товара в корзину")
    public void getProductsInBasket() {
        loginInOnStartPage();
        productSteps.addBackpackInCart();
        productSteps.cartBadgeNumber();
        cartSteps.openCartPageGetInfoItem();
        cartSteps.continueShoppingOnProduct();
    }
}
