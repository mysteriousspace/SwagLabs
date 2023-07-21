package com.example.testik;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ProductPage;
import steps.LoginPageSteps;
import steps.ProductSteps;

import static com.codeborne.selenide.Selenide.open;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UITest {
    ProductSteps productSteps = new ProductSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();

    private final static String BASE_URL = ("https://www.saucedemo.com/");
    private final static String USER = ("standard_user");
    private final static String PASS = ("secret_sauce");

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

    @Test(description = "Проверка авторизации")
    public void LoginIn() {
        loginPageSteps.openLoginForm();
        loginPageSteps.setName(USER);
        loginPageSteps.setPasswordField(PASS);
        loginPageSteps.openStartPage();
    }
}
/*
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

}*/