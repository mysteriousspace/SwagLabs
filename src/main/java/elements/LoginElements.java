package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    public SelenideElement UserNameField = $("#user-name");
    public SelenideElement PasswordField = $("#password");
    public SelenideElement LoginButton = $("#login-button");
}
