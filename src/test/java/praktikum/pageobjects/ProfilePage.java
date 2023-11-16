package praktikum.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private WebDriver driver;
    private By changeDataText = By.xpath(".//p[@class='Account_text__fZAIn text text_type_main-default' and text()='В этом разделе вы можете изменить свои персональные данные']");
    private By exitButton = By.xpath(".//button[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive' and text()='Выход']");

    public ProfilePage() {}

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на кнопку <Выйти>")
    public void clickOnExitButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    @Step("Проверяем, что информация профиля отображается")
    public boolean isChangeDataTextVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(changeDataText));
        return driver.findElement(changeDataText).isDisplayed();
    }
}
