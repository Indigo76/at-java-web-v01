package work.part07.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

// https://travel.agileway.net/flights/start

public class SelFlight {

    @Step("Выбор полета в одну сторону")
    public void oneWayButton() {

        $x("//input[@name='tripType' and @value='oneway']").click();
    }

    @Step("Поле обратного рейса должно исчезнуть")
    public void oneWaySuccessful() {
        $(By.id("returnTrip")).shouldNot(visible);
    }

    @Step("Выбор времени рейса")
    public void chooseFlight() {
        Configuration.pageLoadStrategy = "eager";
        $(By.name("fromPort")).selectOption(3); // From: San Fr
        $(By.name("fromPort")).selectOption(2); // To: Sidney
        $(By.id("departDay")).selectOption(11);
        $(By.id("departMonth")).selectOption("January 2025");
        $(By.id("returnDay")).selectOption(13);
        $(By.id("returnMonth")).selectOption("May 2025");
    }

    @Step("Таблица рейсов появилась")
    public void TabShowing() {
        $(By.id("flights")).shouldBe(visible);
    }





}
