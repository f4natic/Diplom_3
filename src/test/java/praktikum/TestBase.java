package praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected WebDriver driver;
    private static final String url = "https://stellarburgers.nomoreparties.site";

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
