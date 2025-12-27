package work.part07;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.openqa.selenium.By;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import work.part07.pages.LoginPage;
import work.part07.pages.DetailsPage;
import work.part07.pages.SelFlight;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMTest {

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        Configuration.browser = "firefox";
        open("https://travel.agileway.net/login");
    }


    // Успешная авторизация
     @Test
    void LoginCorrect() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.isLoginSuccessful();
        //loginPage.logout();
    }

    //  Авторизация с некорректным паролем
    @Test
    void WrongPass() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "12345");
        loginPage.isLoginUnsuccessful();
    }

    //  Выход
    @Test
    void LogOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");
        loginPage.logout();
        $(By.id("flash_notice")).shouldHave(text("Signed out!"));
    }

    @Test
    void TestOneWay(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");

         SelFlight selectFlightPage = new SelFlight();
        selectFlightPage.oneWayButton();
        selectFlightPage.oneWaySuccessful();
    }

    @Test
    void FlightListShow(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("agileway", "test$W1se");

        SelFlight selectFlightPage = new SelFlight();
        selectFlightPage.chooseFlight();
        selectFlightPage.TabShowing();
    }

    @Test
    void PassengerDetails(){
        FlightListShow();
        $x("//input[@value='Continue']").click();

        DetailsPage passDetailPage = new DetailsPage(); //
        passDetailPage.Details();
    }


}
