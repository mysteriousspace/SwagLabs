package com.example.testik;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {

    SelenideElement InventoryItemSauceLabsBackpack = $x("//*[@class='inventory_item_name' and contains (text(), 'Sauce Labs Backpack')]");
    SelenideElement AddToCartButton = $("#add-to-cart-sauce-labs-backpack");
    SelenideElement RemoveFromCart = $("#remove-sauce-labs-backpack");
    SelenideElement AddSauceLabsBackpack= $("#add-to-cart-sauce-labs-backpack");
    SelenideElement RemoveSauceLabsBackpack = $("#remove-sauce-labs-backpack");
    SelenideElement RemoveSauceLabsBikeLight = $("#remove-sauce-labs-bike-light");
    SelenideElement RemoveSauceLabsBoltTshirt = $("#remove-sauce-labs-bolt-t-shirt");
    SelenideElement RemoveSauceLabsFleeceJacket = $("#remove-sauce-labs-fleece-jacket");
    SelenideElement RemoveSauceLabsOnesie = $("#remove-sauce-labs-onesie");
    SelenideElement RemoveSauceLabsBoltTshirtRed = $("#remove-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    SelenideElement ShoppingCart = $(".shopping_cart_link");
    SelenideElement ShoppingBadge = $(".shopping_cart_badge");
    SelenideElement ProductName = $(".inventory_details_name");
    SelenideElement ProductPrice = $(".inventory_details_price");
    SelenideElement BackToProductsButton = $("#back-to-products");
    SelenideElement ProductHeader = $x("//*[@class=\"title\" and contains(text(), 'Products')]");

    @Step ("Проверка изменения кнопки на Remove")
    public boolean addBackpackInCart(){
        AddSauceLabsBackpack.click();
        if(RemoveSauceLabsBackpack.exists()){
                return true;
        }
        return false;
    }

    public boolean cartBadgeNumber(){
        if (ShoppingBadge.exists()){
            String Badge = ShoppingBadge.getText();
            if(Badge.equals("1")){
                return true;
            }
        }
        return false;
    }



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

