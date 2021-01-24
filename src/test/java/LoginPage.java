import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private final String BASE_URL = "https://st2016.inv.bg";
    private final String LOGIN_PAGE_URL = "/login";
    private final By emailLocator = By.id("loginusername");
    private final By passwordLocator = By.name("password");
    private final By loginButtonLocator = By.id("loginsubmit");
    private final By logoutSuccessMessageLocator = By.id("okmsg");
    private final By badLoginErrorLocator = By.cssSelector("div.selenium-error-block");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        //Navigate to Login page
        System.out.println("Navigating to:" + BASE_URL + LOGIN_PAGE_URL);
        driver.navigate().to(BASE_URL + LOGIN_PAGE_URL);
    }


    public void enterEmail(String email) {
        System.out.println("Entering email:" + email);
        //Enter email
        WebElement emailField = driver.findElement(emailLocator);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        System.out.println("Entering password:" + password);
        //Enter password
        WebElement passwordField = driver.findElement(passwordLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        //Click Login button
        System.out.println("Click login button");
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getLoginError(){
        return driver.findElement(badLoginErrorLocator).getText().trim();
    }

    public String getLogoutSuccessMessage(){
        return driver.findElement(logoutSuccessMessageLocator).getText().trim();
    }







    public void sleep (int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
