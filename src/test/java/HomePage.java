import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private final By logoutLinkLocator = By.xpath("//a[@class='selenium-button-logout button-logout']");
    private final By userPanelLocator = By.cssSelector("div.userpanel-header");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public String getLoggedUser(){
        WebElement userPanel = driver.findElement(userPanelLocator);
        return userPanel.getText();
    }

    public void logout(){
        //Click Logout link
        System.out.println("Click logout link");
        WebElement logoutLink = driver.findElement(logoutLinkLocator);
        driver.findElement(userPanelLocator).click();
        logoutLink.click();
    }
}
