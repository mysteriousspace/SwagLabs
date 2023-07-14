package com.example.testik;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    SelenideElement ProductHeader = $x("//*[@class=\"title\"]");
    SelenideElement InventoryItemSauceLabsBackpack = $x("//*[@class='inventory_item_name' and contains (text(), 'Sauce Labs Backpack')]");
    SelenideElement AddToCartButton = $x("//*[@class=\"btn btn_primary btn_small btn_inventory\"]");
    SelenideElement RemoveFromCart = $x("//*[@class=\"btn btn_secondary btn_small btn_inventory\"]");
    SelenideElement RemoveSauceLabsBackpack = $x("//*[@id='remove-sauce-labs-backpack']");
    SelenideElement RemoveSauceLabsBikeLight = $x("//*[@id='remove-sauce-labs-bike-light']");
    SelenideElement RemoveSauceLabsBoltTshirt = $x("//*[@id='remove-sauce-labs-bolt-t-shirt']");
    SelenideElement RemoveSauceLabsFleeceJacket = $x("//*[@id='remove-sauce-labs-fleece-jacket']");
    SelenideElement RemoveSauceLabsOnesie = $x("//*[@id='remove-sauce-labs-onesie']");
    SelenideElement RemoveSauceLabsBoltTshirtRed = $x("//*[@id='remove-test.allthethings()-t-shirt-(red)']");
    SelenideElement ShoppingCart = $x("//*[@class=\"shopping_cart_link\"]");
    SelenideElement ShoppingBadge = $x("//*[@class=\"shopping_cart_badge\"]");
    SelenideElement ProductName = $x("//*[@class='inventory_details_name large_size']");
    SelenideElement ProductPrice = $x("//*[@class=\"inventory_details_price\"]");
    SelenideElement BackToProductsButton = $x("//*[@id='back-to-products']");

      public void getSauceLabsBackpackInCart(){
        if (RemoveSauceLabsBackpack.exists()){
            RemoveSauceLabsBackpack.click();
        } else if (RemoveSauceLabsBikeLight.exists()){
            RemoveSauceLabsBikeLight.click();
        } else if (RemoveSauceLabsBoltTshirt.exists()) {
            RemoveSauceLabsBoltTshirt.click();
        } else if (RemoveSauceLabsFleeceJacket.exists()){
            RemoveSauceLabsFleeceJacket.click();
        } else if (RemoveSauceLabsOnesie.exists()) {
            RemoveSauceLabsOnesie.click();
        } else if (RemoveSauceLabsBoltTshirtRed.exists()){
            RemoveSauceLabsBoltTshirtRed.click();
        } else {}
        InventoryItemSauceLabsBackpack.click();
        AddToCartButton.click();
        ShoppingCart.click();
    }
}

