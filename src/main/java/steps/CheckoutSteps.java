package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    public static String FIRSTNAME = ("Георгий");
    public static String LASTNAME = ("Жигарев");
    public static String ZIPPOSTALCODE = ("156000");



    @Step("Нажать на кнопку Checkout")
    public boolean openFormYourInformation (){
        cartPage.cartElements.checkoutButton.click();
        if((checkoutPage.checkoutElements.firstNameField.exists()) && (checkoutPage.checkoutElements.lastNameField.exists()) && (checkoutPage.checkoutElements.zipPostalCodeField.exists())){
            return true;
        }
        return false;
    }

    public void editYourInformation (String a, String b, String c){
        checkoutPage.checkoutElements.firstNameField.sendKeys(a);
        checkoutPage.checkoutElements.lastNameField.sendKeys(b);
        checkoutPage.checkoutElements.zipPostalCodeField.sendKeys(c);
    }
    @Step ("Проверка заполнения полей")
    public boolean fillingFeildYourInformation(){
        editYourInformation(FIRSTNAME, LASTNAME, ZIPPOSTALCODE);
        if ((checkoutPage.checkoutElements.firstNameField.getValue().equals(FIRSTNAME)) && (checkoutPage.checkoutElements.lastNameField.getValue().equals(LASTNAME)) && (checkoutPage.checkoutElements.zipPostalCodeField.getValue().equals(ZIPPOSTALCODE))){
            return true;
        }
        return false;
    }
}
