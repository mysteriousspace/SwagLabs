package com.example.testik;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class UITest {

    private final static String BASE_URL = ("https://www.saucedemo.com/");
    private final static String USER = ("standard_user");
    private final static String PASS = ("secret_sauce");
    public static String FirstName = ("Георгий");
    public static String LastName = ("Жигарев");
    public static String ZipPostalCode = ("156000");
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open(BASE_URL);
    }

    @Test /*Проверка авторизации*/
    public void loginIn() {
        assertTrue(loginPage.UserNameField.exists(), "Элемент не найден на странице");
        assertTrue(loginPage.PasswordField.exists(), "Элемент не найден на странице");
        assertTrue(loginPage.LoginButton.exists(), "Элемент не найден на странице");
        loginPage.UserNameField.sendKeys(USER);
        assertEquals(USER, loginPage.UserNameField.getValue(), "Логин не соответствует введенному значению");
        loginPage.PasswordField.sendKeys(PASS);
        assertEquals(PASS, loginPage.PasswordField.getValue(), "Пароль не соответствует введенному значению");
        loginPage.LoginButton.click();
        assertTrue(productPage.ProductHeader.exists(), "Элемент не найден на странице");
        assertEquals(productPage.ProductHeader.getText(), "Products", "Значение атрибута элемента неверное");
        assertEquals(url(), "https://www.saucedemo.com/inventory.html", "URL не соответствует ожидаемому результату");
    }

    @Test /*Добавление товара в корзину*/
    public void getProductsInBasket(){
        loginPage.LoginOnStartPage(USER, PASS);
        productPage.InventoryItemSauceLabsBackpack.click();
        String NameItem = productPage.ProductName.getText();
        String PriceItem = productPage.ProductPrice.getText();
        productPage.AddToCartButton.click();
        assertTrue(productPage.RemoveFromCart.exists(), "Элемент не найден на странице");
        if (productPage.ShoppingBadge.exists()){
            assertEquals( "1", productPage.ShoppingBadge.getText(), "Некорректное количество товара в корзине");
        } else {
            assertTrue(productPage.ShoppingBadge.exists(), "Не отображается иконка количества товаров в корзине");
        }
        productPage.ShoppingCart.click();
        assertEquals(cartPage.InventoryItemName.getText(), NameItem,"Наименование товара не совпадает");
        assertEquals(cartPage.InventoryItemPrice.getText(), PriceItem, "Цена товара не совпадает");
        cartPage.ContinueShoppingButton.click();
        assertTrue(productPage.ProductHeader.exists(), "Элемент не найден на странице");
        assertEquals(productPage.ProductHeader.getText(), "Products", "Значение атрибута элемента неверное");
        assertEquals(url(), "https://www.saucedemo.com/inventory.html", "URL не соответствует ожидаемому результату");
    }

    @Test() /*Оформение товара*/
    public void productClearance() {
        loginPage.LoginOnStartPage(USER, PASS);
        productPage.getSauceLabsBackpackInCart();
        productPage.ShoppingCart.click();
        cartPage.CheckoutButton.click();
        assertEquals(checkoutPage.CheckoutForm.size(), 3, "Количество элементов не соответствует ожидаемому");
        assertEquals(checkoutPage.CheckoutForm.get(0), checkoutPage.FirstNameField,"Элемент не найден на странице");
        assertEquals(checkoutPage.CheckoutForm.get(1), checkoutPage.LastNameField,"Элемент не найден на странице");
        assertEquals(checkoutPage.CheckoutForm.get(2), checkoutPage.ZipPostalCodeField,"Элемент не найден на странице");
        checkoutPage.editCheckOutForm(FirstName, LastName, ZipPostalCode);
        assertEquals(checkoutPage.FirstNameField.getValue(), FirstName, "Значение атрибута элемента неверное");
        assertEquals(checkoutPage.LastNameField.getValue(), LastName,"Значение атрибута элемента неверное");
        assertEquals(checkoutPage.ZipPostalCodeField.getValue(), ZipPostalCode,"Значение атрибута элемента неверное");
        checkoutPage.ContinueButton.click();
        assertTrue(checkoutPage.CheckoutOverview.exists(), "Элемент не найден на странице");
        assertTrue(checkoutPage.InventoryItemName.exists(), "Элемент не найден на странице");
        assertTrue(checkoutPage.InventoryItemPrice.exists(), "Элемент не найден на странице");
        assertEquals(checkoutPage.PaymentInformation.getText(),"SauceCard #31337","Значение атрибута элемента неверное");
        assertEquals(checkoutPage.ShippingInformation.getText(), "Free Pony Express Delivery!", "Значение атрибута элемента неверное");
        assertEquals(checkoutPage.ItemTotal.getText(), "Item total: $29.99", "Значение атрибута элемента неверное");
        assertEquals(checkoutPage.Tax.getText(), "Tax: $2.40","Значение атрибута элемента неверное");
        assertEquals(checkoutPage.Total.getText(), "Total: $32.39","Значение атрибута элемента неверное");
        checkoutPage.FinishButton.click();
        assertEquals(checkoutPage.CompletePage.getText(), "Checkout: Complete!", "");
        assertEquals(url(), "https://www.saucedemo.com/checkout-complete.html", "URL не соответствует ожидаемому результату");
    }

    @Test /*Удаление товара из корзины*/
    public void deleteProductFromCart(){
        loginPage.LoginOnStartPage(USER, PASS);
        productPage.InventoryItemSauceLabsBackpack.click();
        String NameItem = productPage.ProductName.getText();
        String PriceItem = productPage.ProductPrice.getText();
        productPage.BackToProductsButton.click();
        productPage.getSauceLabsBackpackInCart();
        assertTrue(productPage.RemoveSauceLabsBackpack.exists(), "Элемент не найден на странице");
        if (productPage.ShoppingBadge.exists()){
            assertEquals( "1", productPage.ShoppingBadge.getText(), "Некорректное количество товара в корзине");
        } else {
            assertTrue(productPage.ShoppingBadge.exists(), "Не отображается иконка количества товаров в корзине");
        }
        productPage.ShoppingCart.click();
        assertEquals(cartPage.InventoryItemName.getText(), NameItem,"Наименование товара не совпадает");
        assertEquals(cartPage.InventoryItemPrice.getText(), PriceItem, "Цена товара не совпадает");
        cartPage.RemoveFromCart.click();
        assertFalse(productPage.ShoppingBadge.exists(), "Иконка отображается");
        assertFalse(cartPage.InventoryItemName.exists(), "Элемент найден на странице");
        assertFalse(cartPage.InventoryItemPrice.exists(),"Элемент найден на странице");
        cartPage.ContinueShoppingButton.click();
        assertEquals(productPage.ProductHeader.getText(), "Products", "Значение атрибута элемента неверное");
        assertEquals(url(), "https://www.saucedemo.com/inventory.html", "URL не соответствует ожидаемому результату");
    }

}