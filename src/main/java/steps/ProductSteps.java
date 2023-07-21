package steps;

import io.qameta.allure.Step;
import pages.ProductPage;

public class ProductSteps {
    ProductPage productPage = new ProductPage();
    @Step("Проверка изменения кнопки на Remove")
    public boolean addBackpackInCart(){
        productPage.productsElement.addSauceLabsBackpack.click();
        if(productPage.productsElement.removeSauceLabsBackpack.exists()){
            return true;
        }
        return false;
    }

    public boolean cartBadgeNumber(){
        if (productPage.productsElement.shoppingBadge.exists()){
            String Badge = productPage.productsElement.shoppingBadge.getText();
            if(Badge.equals("1")){
                return true;
            }
        }
        return false;
    }


    public void getSauceLabsBackpackInCart(){
        if (productPage.productsElement.removeSauceLabsBackpack.exists()){
            productPage.productsElement.removeSauceLabsBackpack.click();
        } else if (productPage.productsElement.removeSauceLabsBikeLight.exists()){
            productPage.productsElement.removeSauceLabsBikeLight.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirt.exists()) {
            productPage.productsElement.removeSauceLabsBoltTshirt.click();
        } else if (productPage.productsElement.removeSauceLabsFleeceJacket.exists()){
            productPage.productsElement.removeSauceLabsFleeceJacket.click();
        } else if (productPage.productsElement.removeSauceLabsOnesie.exists()) {
            productPage.productsElement.removeSauceLabsOnesie.click();
        } else if (productPage.productsElement.removeSauceLabsBoltTshirtRed.exists()){
            productPage.productsElement.removeSauceLabsBoltTshirtRed.click();
        } else {}
        productPage.productsElement.inventoryItemSauceLabsBackpack.click();
        productPage.productsElement.addToCartButton.click();
        productPage.productsElement.shoppingCart.click();
    }
}

