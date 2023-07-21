package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    public SelenideElement userNameField = $("#user-name");
    public SelenideElement passwordField = $("#password");
    public SelenideElement loginButton = $("#login-button");
}
