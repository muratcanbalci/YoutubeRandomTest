package PageObjectModel;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stepDefinitions.ConstAndMethods;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class youtubeSkipAdds {
    ConstAndMethods constAndMethods = new ConstAndMethods();
    WebDriver driver;
    int randomNumber;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:/YoutubeRandomTest/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Given("^Go to google$")
    public void go_to_google() throws Throwable {
        constAndMethods.gotoGoogle();
        constAndMethods.searchRadomNumber();
    }

    @When("^Result is between (\\d+) with (\\d+)$")
    public void result_is_between_with(int arg1, int arg2) throws Throwable {
        randomNumber = Integer.parseInt(constAndMethods.getRandomNumber());
    }

    @Then("^Go to youtube and search Matematik$")
    public void go_to_youtube_and_search_Matematik() throws Throwable {
        constAndMethods.youtubeSearch(randomNumber);
    }

    @Then("^Go to youtube and search Türkçe$")
    public void go_to_youtube_and_search_Türkçe() throws Throwable {
        constAndMethods.youtubeSearch(randomNumber);
    }

    @Given("^List to videos without playlist$")
    public void list_to_videos_without_playlist() throws Throwable {
        constAndMethods.listToVideos();
    }

    @When("^Search to TYT word in title$")
    public void search_to_TYT_word_in_title() throws Throwable {
        constAndMethods.searchTytWord();
    }

    @Then("^Select video$")
    public void select_video() throws Throwable {
        constAndMethods.selectVideo();
    }

    @Given("^Video is playing$")
    public void video_is_playing() throws Throwable {
        constAndMethods.videoisPlaying();
    }

    @When("^Skip (\\d+)st minute of video and pause$")
    public void skip_st_minute_of_video_and_pause(int arg1) throws Throwable {
        constAndMethods.skipORwaitADD();
    }

    @Then("^Control to minute of video$")
    public void control_to_minute_of_video() throws Throwable {
        constAndMethods.controlToCurrentTime();
        Driver.closeDriver();
    }
}
