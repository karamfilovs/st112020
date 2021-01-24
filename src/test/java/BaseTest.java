import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ItemPage itemPage;
    protected WebDriver driver;
    private static final String BROWSER = "chrome";

    @BeforeAll
    public static void beforeAllTests() {
        downloadDriver(BROWSER);
    }

    private static void downloadDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                break;
            default:
                throw new IllegalArgumentException("Not supported browser");
        }
    }

    private void startBrowser(String browser) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Not supported browser");
        }

        driver.manage().deleteAllCookies(); //Delete all browser cookies
        driver.manage().window().maximize(); //Maximizes browser instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("------------------------ Starting test ------------------------");
    }

    @BeforeEach
    public void beforeEachTest() {
        startBrowser(BROWSER);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        itemPage = new ItemPage(driver);
        //Check the page title
    }

    @AfterEach
    public void afterEachTest() {
        driver.quit();
    }

}
