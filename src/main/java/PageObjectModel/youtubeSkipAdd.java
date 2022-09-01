package PageObjectModel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.ConstAndMethods;

import java.util.concurrent.TimeUnit;

public class youtubeSkipAdd {
    ConstAndMethods constAndMethods = new ConstAndMethods();
    WebDriver driver;
    int randomNumber;
    String videoUrl;
    String videoSure ="?t=60";
    String kelime;
    String sarilanSure;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/cucumbersenaryo/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^Go to google$")
    public void go_to_google() throws Throwable {
        constAndMethods.gotoGoogle();
    }

    @When("^Result is between (\\d+) with (\\d+)$")
    public void result_is_between_with(int arg1, int arg2) throws Throwable {
    }

    @Then("^Go to youtube and search Matematik$")
    public void go_to_youtube_and_search_Matematik() throws Throwable {
    }

    @Then("^Go to youtube and search Türkçe$")
    public void go_to_youtube_and_search_Türkçe() throws Throwable {
    }

    @Given("^List to videos without playlist$")
    public void list_to_videos_without_playlist() throws Throwable {
    }

    @When("^Search to TYT word in title$")
    public void search_to_TYT_word_in_title() throws Throwable {
    }

    @Then("^Select video$")
    public void select_video() throws Throwable {
    }

    @Given("^Click skip add button$")
    public void click_skip_add_button() throws Throwable {
    }

    @When("^There is a add$")
    public void there_is_a_add() throws Throwable {
    }

    @Then("^Skip add or wait to finish$")
    public void skip_add_or_wait_to_finish() throws Throwable {
    }

    @Given("^Skip (\\d+)st minute of video$")
    public void skip_st_minute_of_video(int arg1) throws Throwable {
    }

    @When("^Pause video$")
    public void pause_video() throws Throwable {
    }

    @Then("^Control to minute of video$")
    public void control_to_minute_of_video() throws Throwable {

    }


}
