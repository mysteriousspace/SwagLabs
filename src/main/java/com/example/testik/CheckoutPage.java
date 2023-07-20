package com.example.testik;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import javax.lang.model.element.Name;

import static com.codeborne.selenide.Selenide.*;

public class CheckoutPage {
    CartPage cartPage= new CartPage();
    public static String FirstName = ("Георгий");
    public static String LastName = ("Жигарев");
    public static String ZipPostalCode = ("156000");

    SelenideElement FirstNameField = $("#first-name");
    SelenideElement LastNameField = $("#last-name");
    SelenideElement ZipPostalCodeField = $("#postal-code");
    ElementsCollection YourInformationForm = $$(".form_group");
    SelenideElement ContinueButton = $("#continue");
    SelenideElement FinishButton = $("#finish");
    SelenideElement InventoryItemName = $(".inventory_item_name");
    SelenideElement InventoryItemPrice = $(".inventory_item_price");
    SelenideElement CheckoutOverview = $x("//*[@class='title' and contains(text(), 'Checkout: Overview')]");
    SelenideElement ItemTotal = $(".summary_subtotal_label");
    SelenideElement Tax  = $(".summary_tax_label");
    SelenideElement Total = $x("//*[@class='summary_info_label summary_total_label']");
    SelenideElement PaymentInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Payment Information')]/following::div[1]");
    SelenideElement ShippingInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Shipping Information')]/following::div[1]");
    SelenideElement CompleteMessage = $(".complete-header");
    SelenideElement CompletePage = $x("//*[@class='title' and contains(text(), 'Checkout: Complete!')]");

    @Step ("Нажать на кнопку Checkout")
    public boolean openFormYourInformation (){
        cartPage.CheckoutButton.click();
        if((FirstNameField.exists()) && (LastNameField.exists()) && (ZipPostalCodeField.exists())){
            return true;
        }
        return false;
    }

    public void editYourInformation (String a, String b, String c){
        FirstNameField.sendKeys(a);
        LastNameField.sendKeys(b);
        ZipPostalCodeField.sendKeys(c);
    }
    @Step ("Проверка заполнения полей")
    public boolean fillingFeildYourInformation(){
        editYourInformation(FirstName,LastName, ZipPostalCode);
        if ((FirstNameField.getValue().equals(FirstName)) && (LastNameField.getValue().equals(LastName)) && (ZipPostalCodeField.getValue().equals(ZipPostalCode))){
            return true;
        }
        return false;
    }
    @Step ("")
    public boolean finishForm(){

    }

}
