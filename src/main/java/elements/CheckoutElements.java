package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class CheckoutElements {
    public SelenideElement firstNameField = $("#first-name");
    public SelenideElement lastNameField = $("#last-name");
    public SelenideElement zipPostalCodeField = $("#postal-code");
    public ElementsCollection yourInformationForm = $$(".form_group");
    public SelenideElement continueButton = $("#continue");
    public SelenideElement finishButton = $("#finish");
    public SelenideElement inventoryItemName = $(".inventory_item_name");
    public SelenideElement inventoryItemPrice = $(".inventory_item_price");
    public SelenideElement checkoutOverview = $x("//*[@class='title' and contains(text(), 'Checkout: Overview')]");
    public SelenideElement itemTotal = $(".summary_subtotal_label");
    public SelenideElement textTax  = $(".summary_tax_label");
    public SelenideElement textTotal = $x("//*[@class='summary_info_label summary_total_label']");
    public SelenideElement paymentInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Payment Information')]/following::div[1]");
    public SelenideElement shippingInformation = $x("//*[@class='summary_info_label' and contains (text(), 'Shipping Information')]/following::div[1]");
    public SelenideElement completeMessage = $(".complete-header");
    public SelenideElement completePage = $x("//*[@class='title' and contains(text(), 'Checkout: Complete!')]");
}
