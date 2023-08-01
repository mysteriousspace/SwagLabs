package servise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductPage;
import servise.WebDriver.LocalWebDriverProvider;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class BaseTest extends LocalWebDriverProvider{
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    LocalWebDriverProvider localWebDriverProvider = new LocalWebDriverProvider();
    String getBaseUrl = ConfigProvider.URL;
    String getLogin = ConfigProvider.LOGIN;
    String getPassword = ConfigProvider.PASSWORD;


    @BeforeClass
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
    @BeforeMethod
    public void setUpAll() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--incognito").addArguments("--window-size=1920,1080");
        open(getBaseUrl);
    }

    public void loginInOnStartPage() {
        loginPage.loginElements.userNameField.sendKeys(getLogin);
        loginPage.loginElements.passwordField.sendKeys(getPassword);
        loginPage.loginElements.loginButton.click();
    }

    public void getSauceLabsBackpackInCart() {
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        productPage.productsElement.addToCartButton.click();
        productPage.productsElement.shoppingCart.click();
    }


    public void cycleForPasha() {
        while (productPage.productsElement.removeFromCart.exists()) {
            productPage.productsElement.removeFromCart.click();
        }
    }
    //Не нашел информации по коллекциям, как можно реализовать в одну строку
    public void collectionForPasha() {
        for (WebElement element: productPage.productsElement.itemListButton.filterBy(text("Remove"))){
            element.click();
        }
    }


    public void removeAllItemFromCart() {
        if (productPage.productsElement.removeSauceLabsBackpack.exists()) {
            productPage.productsElement.removeSauceLabsBackpack.click();
        } else if (productPage.productsElement.removeSauceLabsBikeLight.exists()) {
            productPage.productsElement.removeSauceLabsBikeLight.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirt.exists()) {
            productPage.productsElement.removeSauceLabsBoltTshirt.click();
        } else if (productPage.productsElement.removeSauceLabsFleeceJacket.exists()) {
            productPage.productsElement.removeSauceLabsFleeceJacket.click();
        } else if (productPage.productsElement.removeSauceLabsOnesie.exists()) {
            productPage.productsElement.removeSauceLabsOnesie.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirtRed.exists()) {
            productPage.productsElement.removeSauceLabsBoltTshirtRed.click();
        }
    }
}
