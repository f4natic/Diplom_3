package praktikum;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.base.TestBase;
import praktikum.pageobjects.MainPage;

@Epic("Тесты на переходы по конструктору")
public class ConstructorTest extends TestBase {
    private MainPage mainPage;

    @Before
    public void init() throws JsonProcessingException {
        super.init();
        mainPage = new MainPage(driver);
    }

    @Test
    @Step("Должны переместиться на вкладку Соусы")
    public void shouldMoveToSouce(){
        mainPage.clickBySauceSpan();
        Assert.assertTrue(mainPage.isSouceSelected());
    }

    @Test
    @Step("Должны переместиться на вкладку Начинки")
    public void shouldMoveToFilling(){
        mainPage.clickByFillingSpan();
        Assert.assertTrue(mainPage.isFillingSelected());
    }

    @Test
    @Step("Должны переместиться на вкладку Булки")
    public void shouldMoveToBread(){
        mainPage.clickBySauceSpan();
        mainPage.clickByBreadSpan();
        Assert.assertTrue(mainPage.isBreadSelected());
    }
}
