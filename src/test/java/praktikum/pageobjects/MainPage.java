package praktikum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private By loginAnchor = By.xpath(".//a[@class='AppHeader_header__link__3D_hX' and @href='/account']");
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Войти в аккаунт']");
    private By createOrderButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg' and text()='Оформить заказ']");
    public MainPage() {}

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickByLoginAnchor() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(loginAnchor));
        driver.findElement(loginAnchor).click();
    }

    public void clickByLoginButton() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }

    public boolean isCreateOrderVisible() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }
}
