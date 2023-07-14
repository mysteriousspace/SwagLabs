package com.example.testik;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import javax.lang.model.element.Name;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {

    SelenideElement FirstNameField = $x("//*[@id='first-name']");
    SelenideElement LastNameField = $x("//*[@id='last-name']");
    SelenideElement ZipPostalCodeField = $x("//*[@id='postal-code']");
    ElementsCollection CheckoutForm = $$x("//*[@class='input_error form_input']");
    SelenideElement ContinueButton = $x("//*[@id='continue']");
    SelenideElement FinishButton = $x("//*[@class='btn btn_action btn_medium cart_button']");
    SelenideElement InventoryItemName = $x("//*[@class='inventory_item_name']");
    SelenideElement InventoryItemPrice = $x("//*[@class='inventory_item_price']");
    SelenideElement CheckoutOverview = $x("//*[@class='title' and contains(text(), 'Checkout: Overview')]");
    SelenideElement ItemTotal = $x("//*[@class='summary_subtotal_label']");
    SelenideElement Tax  = $x("//*[@class='summary_tax_label']");
    SelenideElement Total = $x("//*[@class='summary_info_label summary_total_label']");
    SelenideElement PaymentInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Payment Information')]/following::div[1]");
    SelenideElement ShippingInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Shipping Information')]/following::div[1]");
    SelenideElement CompleteMessage = $x("//*[@class='complete-header']");
    SelenideElement CompletePage = $x("//*[@class='title' and contains(text(), 'Checkout: Complete!')]");

    public void editCheckOutForm(String a, String b, String c){
        FirstNameField.sendKeys(a);
        LastNameField.sendKeys(b);
        ZipPostalCodeField.sendKeys(c);
    }
}
