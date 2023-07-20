package com.example.testik;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    ProductPage productPage = new ProductPage();
    SelenideElement InventoryItemName = $(".inventory_item_name");
    SelenideElement InventoryItemPrice = $(".inventory_item_price");
    SelenideElement ContinueShoppingButton = $("#continue-shopping");
    SelenideElement CheckoutButton = $("#checkout");
    SelenideElement RemoveFromCartBackPack = $("#remove-sauce-labs-backpack");

    @Step("Открытие корзины")
    public boolean openCartPageGetInfoItem(){
        productPage.InventoryItemSauceLabsBackpack.click();
        String ItemName = productPage.ProductName.getText();
        String ItemPrice = productPage.ProductPrice.getText();
        productPage.ShoppingCart.click();
        if ((InventoryItemName.getText().equals(ItemName)) && (InventoryItemPrice.getText().equals(ItemPrice))){
            return true;
        }
        return false;
    }
    @Step("Возвращение на страницу продуктов")
    public boolean continueShoppingOnProduct(){
        ContinueShoppingButton.click();
        if (productPage.ProductHeader.exists()){
            return true;
        }
        return false;
    }

}
