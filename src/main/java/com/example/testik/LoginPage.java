package com.example.testik;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    ProductPage productPage = new ProductPage();
    public SelenideElement UserNameField = $("#user-name");
    public SelenideElement PasswordField = $("#password");
    public SelenideElement LoginButton = $("#login-button");



    @Step("open URL")
    public boolean openUrl(String URL){
        open(URL);
        if ((UserNameField.exists()) && (PasswordField.exists()) && (LoginButton.exists())){
            return true;
        } else {
            return false;}
    }

    @Step ("Заполнение логина")
    public String setName (String a){
        UserNameField.sendKeys(a);
        return UserNameField.getValue();
    }

    @Step ("Заполнение пароля")
    public String setPasswordField(String b){
        PasswordField.sendKeys(b);
        return PasswordField.getValue();
    }

    @Step ("Нажатие на кнопку Логин")
    public boolean openStartPage(){
        LoginButton.click();
        if(productPage.ProductHeader.exists()){
            return true;
        }else{
            return false;
        }
    }

    /*Метод авторизации*/
    public void loginInOnStartPage(String a, String b){
        UserNameField.sendKeys(a);
        PasswordField.sendKeys(b);
        LoginButton.click();
    }
}
