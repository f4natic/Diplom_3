package praktikum.pageobjects;

import com.thoughtworks.qdox.model.expression.Constant;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.constants.Constants;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage {
    private WebDriver driver;
    private By loginAnchor = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    private By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    private By constructorText = By.xpath(".//h1[@class='text text_type_main-large mb-5 mt-10' and text()='Соберите бургер']");
    private By breadSpan = By.xpath(String.format(".//span[@class='text text_type_main-default' and text()='%s']", Constants.BREAD));
    private By sauceSpan = By.xpath(String.format(".//span[@class='text text_type_main-default' and text()='%s']", Constants.SOUCE));
    private By fillingSpan= By.xpath(String.format(".//span[@class='text text_type_main-default' and text()='%s']", Constants.FILLING));
    private By selectedSpan = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[@class='text text_type_main-default']");


    public MainPage() {}

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажимаем на ссылку <Личный кабинет>")
    public void clickByLoginAnchor() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(loginAnchor));
        driver.findElement(loginAnchor).click();
    }

    @Step("Нажимаем на кнопку <Войти в аккаунт>")
    public void clickByLoginButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    @Step("Нажимаем на span <Булки>")
    public void clickByBreadSpan() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(breadSpan));
        driver.findElement(breadSpan).click();
    }

    @Step("Нажимаем на span <Соусы>")
    public void clickBySauceSpan() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(breadSpan));
        driver.findElement(sauceSpan).click();
    }

    @Step("Нажимаем на span <Начинки>")
    public void clickByFillingSpan() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(breadSpan));
        driver.findElement(fillingSpan).click();
    }

    @Step("Проверяем, что после было нажатие на span <Булки>")
    public boolean isBreadSelected() {
        return driver.findElement(selectedSpan).getText().equals(Constants.BREAD);
    }

    @Step("Проверяем, что после было нажатие на span <Соусы>")
    public boolean isSouceSelected() {
        return driver.findElement(selectedSpan).getText().equals(Constants.SOUCE);
    }

    @Step("Проверяем, что после было нажатие на span <Начинки>")
    public boolean isFillingSelected() {
        return driver.findElement(selectedSpan).getText().equals(Constants.FILLING);
    }

    @Step("Проверяем, что кнопка <Заказать> отображается")
    public boolean isCreateOrderVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    @Step("Проверяем, что текст <Соберите бургер> отображается")
    public boolean isConstructorTextVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(constructorText));
        return driver.findElement(constructorText).isDisplayed();
    }
}
