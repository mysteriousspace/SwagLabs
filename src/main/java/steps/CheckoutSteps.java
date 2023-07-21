package steps;

import io.qameta.allure.Step;
import pages.CartPage;
import pages.CheckoutPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutSteps {
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    public static String FIRSTNAME = ("Георгий");
    public static String LASTNAME = ("Жигарев");
    public static String ZIPPOSTALCODE = ("156000");


    @Step("Нажать на кнопку Checkout")
    public void openFormYourInformation() {
        cartPage.cartElements.checkoutButton.click();
        assertThat(checkoutPage.checkoutElements.firstNameField.exists()).as("Поле FirstName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.lastNameField.exists()).as("Поле LastName не найдено").isTrue();
        assertThat(checkoutPage.checkoutElements.zipPostalCodeField.exists()).as("Поле ZipPostalCode не найдено").isTrue();
    }

    @Step("Проверка заполнения полей")
    public void editYourInformation() {
        checkoutPage.checkoutElements.firstNameField.sendKeys(FIRSTNAME);
        assertThat(checkoutPage.checkoutElements.firstNameField.getValue()).as("FIRSTNAME не соответствует введеному значению").isEqualTo(FIRSTNAME);
        checkoutPage.checkoutElements.lastNameField.sendKeys(LASTNAME);
        assertThat(checkoutPage.checkoutElements.lastNameField.getValue()).as("LASTNAME не соответствует введеному значению").isEqualTo(LASTNAME);
        checkoutPage.checkoutElements.zipPostalCodeField.sendKeys(ZIPPOSTALCODE);
        assertThat(checkoutPage.checkoutElements.zipPostalCodeField.getValue()).as("ZIPPOSTALCODE не соответствует введеному значению").isEqualTo(ZIPPOSTALCODE);
    }

    @Step("Нажать на кнопку Continue")
    public void continueCheckInformation() {
        checkoutPage.checkoutElements.continueButton.click();
        assertThat(checkoutPage.checkoutElements.checkoutOverview.exists()).as("Не отрывается страница \"CHECKOUT: OVERVIEW\"").isTrue();
        assertThat(checkoutPage.checkoutElements.inventoryItemName.exists()).as("Не отображается имя товара").isTrue();
        assertThat(checkoutPage.checkoutElements.inventoryItemPrice.exists()).as("Не отображается цена товара").isTrue();
        assertThat(checkoutPage.checkoutElements.paymentInformation.getText())
                .as("Payment Information не соответствует ожидаемому").isEqualTo("SauceCard #31337");
        assertThat(checkoutPage.checkoutElements.shippingInformation.getText()).
                as("Shipping Information не соответствует ожидаемому").isEqualTo("Free Pony Express Delivery!");
        assertThat(checkoutPage.checkoutElements.itemTotal.getText()).as("Item total не соответствует ожидаемому").isEqualTo("Item total: $29.99");
        assertThat(checkoutPage.checkoutElements.textTax.getText()).as("Tax не соответствует ожидаемому").isEqualTo("Tax: $2.40");
        assertThat(checkoutPage.checkoutElements.textTotal.getText()).as("Total не соответствует ожидаемому").isEqualTo("Total: $32.39");
    }
    @Step("Завершение оформления товара -Нажать на кнопку Finish")
    public void clickFinishButton(){
        checkoutPage.checkoutElements.finishButton.click();
        assertThat(checkoutPage.checkoutElements.completePage.exists()).as("Не отображается страница \"CHECKOUT: COMPLETE!\"").isTrue();
        assertThat(checkoutPage.checkoutElements.completeMessage.getText()).as("").isEqualTo("Thank you for your order!");
    }
}
