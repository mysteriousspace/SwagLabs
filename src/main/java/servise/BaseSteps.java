package servise;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.ProductPage;
import servise.WebDriver.BrowserSettings;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();
    BrowserSettings browserSettings = new BrowserSettings();
    String getBaseUrl = ConfigProvider.URL;
    String getLogin = ConfigProvider.LOGIN;
    String getPassword = ConfigProvider.PASSWORD;


    @BeforeClass
    public static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        BrowserSettings.chromeSettings();
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

    public void collectionForPasha() {
        if (productPage.productsElement.itemList.findBy(exactText("Remove")).exists()) {
            productPage.productsElement.itemList.findBy(exactText("Remove")).click();
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
