package stepDefinitions;

import PageObjectModel.AbstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ConstAndMethods extends AbstractClass {
    WebDriver driver;
    public ConstAndMethods()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
}
