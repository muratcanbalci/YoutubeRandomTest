package stepDefinitions;

import PageObjectModel.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ConstAndMethods extends AbstractClass {
    WebDriver driver;
    public ConstAndMethods()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
        String asd = "asd";
    }
    @FindBy(css ="input[class='gLFyf gsfi']")
    private WebElement searchField;


    public void gotoGoogle(){driver.get("https://www.google.com");}
    public void searchRadomNumber() {
        sendKeysFunction(searchField, "random number");
        sendKeysFunction(searchField, Keys.ENTER);
    }
}
