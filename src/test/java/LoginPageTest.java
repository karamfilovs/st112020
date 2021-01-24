import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void cantLoginWithInvalidCredentials() {
        loginPage.navigateTo();
        Assertions.assertEquals("Вход - QA Ground", loginPage.getPageTitle());
        loginPage.login("karamfilovs@gmail.com", "1212434343");
        Assertions.assertEquals("Грешно потребителско име или парола. Моля, опитайте отново.", loginPage.getLoginError());
    }

    @Test
    public void cantLoginWithBlankEmail() {
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        loginPage.clickLoginButton();
        Assertions.assertEquals("Моля, попълнете вашия email", loginPage.getLoginError());
    }

    @Test
    public void cantLoginWithBlankPassword() {
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        loginPage.login("karamfilovs@gmail.com", "");
        Assertions.assertEquals("Моля, попълнете вашата парола", loginPage.getLoginError());
    }


    @Test
    public void canLoginWithValidCredentials() {
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        loginPage.login("karamfilovs@gmail.com", "123456");
        //Check page title/logged user
        Assertions.assertEquals("karamfilovs@gmail.com", homePage.getLoggedUser());
    }


    @Test
    public void canLoginWithValidCredentialsAndLogout() {
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        //Check page title/logged user
        loginPage.login("karamfilovs@gmail.com", "123456");
        Assertions.assertEquals("karamfilovs@gmail.com", homePage.getLoggedUser());
        //Check page title
        homePage.logout();
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        // Assertions.assertEquals("Вие излязохте от акаунта си.", logoutSuccessMessage.getText().trim());
    }
}
