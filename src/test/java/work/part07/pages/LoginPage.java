package work.part07.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

// https://travel.agileway.net/flights/

public class LoginPage {

    SelenideElement
            username = $(By.id("username")),
            password = $(By.id("password")),
            loginButton = $(By.name("commit")),
            greeting = $(By.id("user_nav")),
            loginErrormessage = $(By.id("flash_alert")),
            logoutMessage = $(By.id("flash_notice"));

    @Step("Вход в систему")
    public void login(String username, String password) {
        this.username.setValue(username);
        this.password.setValue(password);
        this.loginButton.click();
    }

    @Step("Успешный логин")
    public void isLoginSuccessful() {
       greeting.shouldHave(text("Welcome"));
    }

    @Step("Некорректный логин")
    public void isLoginUnsuccessful() {
        loginErrormessage.shouldHave(text("Invalid email or password"));
    }

    @Step("Выход из системы")

    public void logout() {
               $x("//a").click();
    }

    @Step("выход из системы")
    public void isLogoutSuccessful() {
        logoutMessage.shouldHave(text("Signed out!"));
    }


}
