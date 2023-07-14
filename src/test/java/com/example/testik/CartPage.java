package com.example.testik;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CartPage {
    SelenideElement InventoryItemName = $x("//*[@class=\"inventory_item_name\"]");
    SelenideElement InventoryItemPrice = $x("//*[@class=\"inventory_item_price\"]");
    SelenideElement ContinueShoppingButton = $x("//*[@id=\"continue-shopping\"]");
    SelenideElement CheckoutButton = $x("//*[@class='btn btn_action btn_medium checkout_button']");
    SelenideElement RemoveFromCart = $x("//*[@class='btn btn_secondary btn_small cart_button']");
}
