package praktikum;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.base.TestBase;
import praktikum.constants.Constants;
import praktikum.pageobjects.LoginPage;
import praktikum.pageobjects.MainPage;
import praktikum.pageobjects.RegistrationPage;

@Epic("Тесты на создание пользователя")
public class RegistrationTest extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Before
    public void init() {
        initDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    @Step("Успешное создание пользователя")
    public void shouldCreateAccount() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.createAccount(Constants.EMAIL, Constants.NAME, Constants.PASSWORD);
        Assert.assertFalse(registrationPage.userAlreadyExistsMessage());
    }

    @Test
    @Step("Успешное получение ошибки о неподходящем пароле")
    public void shouldReturnWrongPasswordMessage() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.createAccount(Constants.EMAIL, Constants.NAME, Constants.PASSWORD.substring(0, 2));
        Assert.assertTrue(registrationPage.isVisibleWrongPasswordMessage());
    }
}
