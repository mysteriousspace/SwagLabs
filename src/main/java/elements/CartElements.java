package elements;

import com.codeborne.selenide.SelenideElement;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.$;

public class CartElements {
    ProductPage productPage = new ProductPage();
    public SelenideElement inventoryItemName = $(".inventory_item_name");
    public SelenideElement inventoryItemPrice = $(".inventory_item_price");
    public SelenideElement continueShoppingButton = $("#continue-shopping");
    public SelenideElement checkoutButton = $("#checkout");
    public SelenideElement removeFromCartBackPack = $("#remove-sauce-labs-backpack");
}
