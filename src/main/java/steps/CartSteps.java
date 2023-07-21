package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {
    CartPage cartPage = new CartPage();
    ProductPage productPage = new ProductPage();

    @Step("Открытие корзины")
    public void openCartPageGetInfoItem() {
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        String ItemName = productPage.inventoryItemElements.productName.getText();
        String ItemPrice = productPage.inventoryItemElements.productPrice.getText();
        productPage.productsElement.shoppingCart.click();
        assertThat(cartPage.cartElements.inventoryItemName.getText()).as("Наименование товара не соответствует выбранному значению").isEqualTo(ItemName);
        assertThat(cartPage.cartElements.inventoryItemPrice.getText()).as("Цена товара не соответствует выбранному значению").isEqualTo(ItemPrice);
    }

    @Step("Возвращение на страницу продуктов")
    public void continueShoppingOnProduct() {
        cartPage.cartElements.continueShoppingButton.click();
        assertThat(productPage.productsElement.productHeader.exists()).as("Страница Products не открывается").isTrue();
    }
}
