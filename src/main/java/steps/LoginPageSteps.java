package steps;

import io.qameta.allure.Step;
import pages.LoginPage;
import pages.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    ProductPage productPage = new ProductPage();

    @Step("open URL")
    public void openLoginForm (){
         assertThat((loginPage.loginElements.LoginButton.exists()) && (loginPage.loginElements.PasswordField.exists()) && (loginPage.loginElements.LoginButton.exists()))
                .isEqualTo(true);
    }

    @Step ("Заполнение логина")
    public void setName (String a){
        loginPage.loginElements.UserNameField.sendKeys(a);
        assertThat(loginPage.loginElements.UserNameField.getValue()).isEqualTo(a);
    }

    @Step ("Заполнение пароля")
    public void setPasswordField(String b){
        loginPage.loginElements.PasswordField.sendKeys(b);
        assertThat(loginPage.loginElements.PasswordField.getValue()).isEqualTo(b);
    }

    @Step ("Нажатие на кнопку Логин")
    public void openStartPage(){
        loginPage.loginElements.LoginButton.click();
        assertThat(productPage.productsElement.productHeader.exists()).isEqualTo(true);
    }

    /*Метод авторизации*/
    public void loginInOnStartPage(String a, String b){
        loginPage.loginElements.UserNameField.sendKeys(a);
        loginPage.loginElements.PasswordField.sendKeys(b);
        loginPage.loginElements.LoginButton.click();
    }
}
