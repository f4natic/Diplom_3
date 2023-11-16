package praktikum;
;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.base.TestBase;
import praktikum.constants.Constants;
import praktikum.pageobjects.LoginPage;
import praktikum.pageobjects.MainPage;
import praktikum.pageobjects.ProfilePage;

@Epic("Тесты на переходы")
public class TransitionTest extends TestBase {
    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @Before
    public void init() throws JsonProcessingException {
        super.init();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @Step("Успешный переход на страницу логина")
    public void shouldTransitionToLoginPage() {
        mainPage.clickByLoginAnchor();
        Assert.assertTrue(loginPage.isLoginButtonVisible());
    }

    @Test
    @Step("Успешный переход в профиль пользователя")
    public void shouldTransitionToProfilePage() {
        mainPage.clickByLoginAnchor();
        loginPage.login(Constants.EMAIL, Constants.PASSWORD);
        mainPage.clickByLoginAnchor();
        Assert.assertTrue(profilePage.isChangeDataTextVisible());
    }

    @Test
    @Step("Успешный переход на главную страницу с конструктором")
    public void shouldTransitionToConstructor() {
        mainPage.clickByLoginAnchor();
        loginPage.clickByConstructorAnchor();
        Assert.assertTrue(mainPage.isConstructorTextVisible());
    }

    @Test
    @Step("Успешный переход на главную страницу")
    public void shouldTransitionToMainPage() {
        mainPage.clickByLoginAnchor();
        loginPage.clickByMainAnchor();
        Assert.assertTrue(mainPage.isConstructorTextVisible());
    }
}
