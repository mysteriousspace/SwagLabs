package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.ProductPage;

public class CartSteps {
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();
    @Step("Открытие корзины")
    public boolean openCartPageGetInfoItem(){
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        String ItemName = productPage.inventoryItemElements.productName.getText();
        String ItemPrice = productPage.inventoryItemElements.productPrice.getText();
        productPage.productsElement.shoppingCart.click();
        if ((cartPage.cartElements.inventoryItemName.getText().equals(ItemName)) && (cartPage.cartElements.inventoryItemPrice.getText().equals(ItemPrice))){
            return true;
        }
        return false;
    }
    @Step("Возвращение на страницу продуктов")
    public boolean continueShoppingOnProduct(){
        cartPage.cartElements.continueShoppingButton.click();
        if (productPage.productsElement.productHeader.exists()){
            return true;
        }
        return false;
    }
}
