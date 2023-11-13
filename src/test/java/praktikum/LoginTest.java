package praktikum;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.constants.Constants;
import praktikum.pageobjects.LoginPage;
import praktikum.pageobjects.MainPage;
import praktikum.pageobjects.RegistrationPage;
import praktikum.pageobjects.RestorePasswordPage;

public class LoginTest extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private RestorePasswordPage restorePasswordPage;

    @Before
    public void init() throws JsonProcessingException {
        super.init();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        restorePasswordPage = new RestorePasswordPage(driver);
    }

    @Test
    public void shouldLoginByLoginButton() {
        mainPage.clickByLoginButton();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    public void shouldLoginByloginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    public void shouldLoginByRegistrationLoginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }

    @Test
    public void shouldLoginByRestorePasswordLoginAnchor() {
        mainPage.clickByLoginAnchor();
        loginPage.clickByRestorePasswordAnchor();
        restorePasswordPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        Assert.assertTrue(mainPage.isCreateOrderVisible());
    }
}
