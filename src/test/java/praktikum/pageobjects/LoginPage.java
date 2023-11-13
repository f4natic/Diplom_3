package praktikum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By registrationLink = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/register']");
    private By emailInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @name='name']");
    private By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");
    private By loginButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa' and text()='Войти']");
    private By restorePasswordAnchor = By.xpath(".//a[@class='Auth_link__1fOlj' and @href='/forgot-password']");

    public LoginPage() {}

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegistrationLink() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(registrationLink));
        driver.findElement(registrationLink).click();
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public void clickByRestorePasswordAnchor() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(restorePasswordAnchor));
        driver.findElement(restorePasswordAnchor).click();
    }
}
