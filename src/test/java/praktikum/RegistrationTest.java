package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.constants.Constants;
import praktikum.pageobjects.LoginPage;
import praktikum.pageobjects.MainPage;
import praktikum.pageobjects.RegistrationPage;

public class RegistrationTest extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @Before
    public void init() {
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void shouldCreateAccount() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.createAccount(Constants.EMAIL, Constants.NAME, Constants.PASSWORD);
        Assert.assertFalse(registrationPage.userAlreadyExistsMessage());
    }

    @Test
    public void shouldReturnWrongPasswordMessage() {
        mainPage.clickByLoginAnchor();
        loginPage.clickOnRegistrationLink();
        registrationPage.createAccount(Constants.EMAIL, Constants.NAME, Constants.PASSWORD.substring(0, 2));
        Assert.assertTrue(registrationPage.isVisibleWrongPasswordMessage());
    }
}
