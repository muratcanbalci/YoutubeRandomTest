package PageObjectModel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import java.time.Duration;


public abstract class AbstractClass {
    private WebDriver driver= Driver.getDriver();
    WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

    public void clickFunction(WebElement clickElement1)
    {
        wait.until(ExpectedConditions.elementToBeClickable(clickElement1));
        clickElement1.click();
    }
    public void sendKeysFunction(WebElement sendKeysElement,String value){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
    }
    public void sendKeysFunction(WebElement sendKeysElement, Keys keys){
        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(keys);
    }
    public final String showUsernameFunction(WebElement myacc,WebElement usernameElement){
        wait.until(ExpectedConditions.elementToBeClickable(myacc));
        myacc.click();
        wait.until(ExpectedConditions.visibilityOf(usernameElement));
        String username = usernameElement.getText();
        return username;
    }
    public void selectElementFromDropDown(WebElement dropdown,String element){
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(element);
    }
    public void Assertion(WebElement actual,String expected){
        wait.until(ExpectedConditions.visibilityOf(actual));
        if(actual.getText() == expected)
        {
            System.out.println(true);
        }
        System.out.println("My Message: "+actual.getText());

    }
}
