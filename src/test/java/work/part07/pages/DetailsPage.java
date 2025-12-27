package work.part07.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

// https://travel.agileway.net/flights/

public class DetailsPage {

    @Step("переход на страницу Passenger Details")
    public void Details() {
        $(By.tagName("h2")).shouldHave(text("Passenger Details"));
    }
}
