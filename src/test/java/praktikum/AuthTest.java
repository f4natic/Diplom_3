package praktikum;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.base.TestBase;
import praktikum.constants.Constants;
import praktikum.pageobjects.*;

@Epic("Тесты на авторизацию пользователя")
public class AuthTest extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private RestorePasswordPage restorePasswordPage;
    private ProfilePage profilePage;

    @Before
    public void init() throws JsonProcessingException {
        super.init();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @Step("Логинимся по кнопке <Войти в аккаунт>")
    public void shouldLoginByLoginButton() {
        mainPage.clickByLoginButton();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    @Step("Логинимся по ссылке <Личный кабинет>")
    public void shouldLoginByloginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    @Step("Логинимся по ссылке <Личный кабинет> из формы регистрации")
    public void shouldLoginByRegistrationLoginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    @Step("Логинимся по ссылке <Личный кабинет> из формы восстановления пароля")
    public void shouldLoginByRestorePasswordLoginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.clickByRestorePasswordAnchor();
        restorePasswordPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    @Step("Выходим из аккаунта по кнопке <Выйти>")
    public void shouldExitFromProfile() {
        mainPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        mainPage.clickByLoginAnchor();
        profilePage.clickOnExitButton();
        Assert.assertTrue(loginPage.isLoginDivVisible());
    }
}
