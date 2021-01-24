import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPage {
    private WebDriver driver;
    private final String BASE_URL = "https://st2016.inv.bg";
    private final String ITEM_PAGE_URL = "/objects/manage";
    private final By createNewButtonLocator = By.cssSelector("a.newbtn.selenium-add-item");
    private final By nameLocator = By.name("name");
    private final By priceNameLocator = By.name("price");
    private final By addButtonLocator = By.name("do_submit");
    private final By successMessageLocator = By.id("okmsg");
    private final By emptyListMessage = By.id("emptylist");

    public ItemPage(WebDriver driver){
        this.driver = driver;
    }

    public void navigateTo(){
        driver.navigate().to(BASE_URL + ITEM_PAGE_URL);
    }

    public void createItem(String name, String price){
        clickCreateNewItemButton();
        enterName(name);
        enterPrice(price);
        clickAddButton();
    }

    private void clickCreateNewItemButton(){
        System.out.println("Clicking new item button");
        WebElement createNewItem = driver.findElement(createNewButtonLocator);
        createNewItem.click();
    }

    private void clickAddButton(){
        System.out.println("Clicking add item button");
        WebElement addButton = driver.findElement(addButtonLocator);
        addButton.click();
    }

    private void enterName(String name){
        System.out.println("Entering name:" + name);
        WebElement itemNameField = driver.findElement(nameLocator);
        itemNameField.clear();
        itemNameField.sendKeys(name);
    }

    private void enterPrice(String price){
        System.out.println("Entering price:" + price);
        WebElement priceField = driver.findElement(priceNameLocator);
        priceField.clear();
        priceField.sendKeys(price);

    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getSuccessMessage(){
        return driver.findElement(successMessageLocator).getText().trim();
    }

    public String getEmptyListMessage(){
        return driver.findElement(emptyListMessage).getText().trim();
    }
}
