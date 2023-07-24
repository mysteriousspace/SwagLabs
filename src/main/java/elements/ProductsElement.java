package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductsElement {
    public SelenideElement inventoryItemSauceLabsBackpack = $x("//*[@class='inventory_item_name' and contains (text(), 'Sauce Labs Backpack')]");
    public SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    public SelenideElement removeFromCart = $("#remove-sauce-labs-backpack");
    public SelenideElement addSauceLabsBackpack = $("#add-to-cart-sauce-labs-backpack");
    public SelenideElement removeSauceLabsBackpack = $("#remove-sauce-labs-backpack");
    public SelenideElement removeSauceLabsBikeLight = $("#remove-sauce-labs-bike-light");
    public SelenideElement removeSauceLabsBoltTshirt = $("#remove-sauce-labs-bolt-t-shirt");
    public SelenideElement removeSauceLabsFleeceJacket = $("#remove-sauce-labs-fleece-jacket");
    public SelenideElement removeSauceLabsOnesie = $("#remove-sauce-labs-onesie");
    public SelenideElement removeSauceLabsBoltTshirtRed = $("#remove-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    public SelenideElement shoppingCart = $(".shopping_cart_link");
    public SelenideElement shoppingBadge = $(".shopping_cart_badge");
    public SelenideElement productHeader = $x("//*[@class=\"title\" and contains(text(), 'Products')]");
}