package com.example.testik;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    public SelenideElement UserNameField = $x("//*[@id='user-name']");
    public SelenideElement PasswordField = $x("//*[@id='password']");
    public SelenideElement LoginButton = $x("//*[@id='login-button']");


    public String GetValueFromLogin(){
        UserNameField.sendKeys("standard_user");
        String userName = UserNameField.getValue();
        return userName;
    }


    public void LoginOnStartPage (String UserName, String Password){
        UserNameField.sendKeys(UserName);
        PasswordField.sendKeys(Password);
        LoginButton.click();

    }
}
