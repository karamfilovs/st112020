import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ItemPageTest extends BaseTest {
    InvAPI api = new InvAPI();

    @Test
    public void canCreateNewItem() {
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        loginPage.login("karamfilovs@gmail.com", "123456");
        //Check page title/logged user
        Assertions.assertEquals("karamfilovs@gmail.com", homePage.getLoggedUser());
        //Navigate to Items page
        itemPage.navigateTo();
        //Check page title
        Assertions.assertEquals("Управление на артикули - QA Ground", itemPage.getPageTitle());
        //Create new item
        itemPage.createItem("MyAutomatedItem", "5");
        //Check success message
        Assertions.assertEquals("Артикулът е добавен успешно.", itemPage.getSuccessMessage());
        //API cleanup
        api.deleteAllItems();
        //Navigate to items page
        itemPage.navigateTo();
        Assertions.assertEquals("Все още нямате добавени артикули.", itemPage.getEmptyListMessage());
    }


    @Test
    public void canDeleteItem(){
        loginPage.navigateTo();
        //Check the page title
        Assertions.assertEquals("Вход - QA Ground", driver.getTitle());
        loginPage.login("karamfilovs@gmail.com", "123456");
        //Check page title/logged user
        Assertions.assertEquals("karamfilovs@gmail.com", homePage.getLoggedUser());
        //Navigate to Items page
        itemPage.navigateTo();
        //Check page title
        Assertions.assertEquals("Управление на артикули - QA Ground", itemPage.getPageTitle());
        //Create item using API
        Item item = new Item();
        item.setItem_name("MyAPINAME6");
        item.setPrice_for_quantity("5");
        item.setQuantity_unit("кг.");
        api.createItem(item);
        //Delete item using UI

    }
}
