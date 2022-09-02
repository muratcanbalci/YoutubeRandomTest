package stepDefinitions;

import PageObjectModel.AbstractClass;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ConstAndMethods extends AbstractClass {
    WebDriver driver;

    String videoTitleString = "yt-formatted-string[class='style-scope ytd-video-renderer']";
    String videoLink = "a[id='video-title']";
    String gecilmeyenReklamStr = "div[class='ytp-ad-text ytp-ad-preview-text']";
    String skipAddBtn = "button[class='ytp-ad-skip-button ytp-button']";
    String ytTimeRemaining = "ytp-ad-duration-remaining";
    String ytAddTime = "ytp-ad-text";
    String ytCurrentTimeStr = "span[class='ytp-time-current']";


    String sarilanSure;
    List<String> baslikList;
    WebElement selectedVideo;
    List<WebElement> gecilmeyenReklam;
    List<WebElement> skipAddButton;

    public ConstAndMethods()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(css ="input[class='gLFyf gsfi']")
    private WebElement searchField;

    @FindBy(className = "gws-csf-randomnumber__result")
    private WebElement randomNumberElement;

    @FindBy(css = "input[id='search']")
    private WebElement ytSearchField;

    @FindAll({
            @FindBy(css="ytd-video-renderer[class='style-scope ytd-item-section-renderer']")
    })
    private List<WebElement> videoList;

    public void gotoGoogle(){driver.get("https://www.google.com");}
    public void gotoYoutube(){driver.get("https://www.youtube.com");}
    public void searchRadomNumber() {
        sendKeysFunction(searchField, "random number");
        sendKeysFunction(searchField, Keys.ENTER);
    }
    public String getRandomNumber(){
        String number = randomNumberElement.getText();
        return number;
    }
    public void youtubeSearch(int num){
        gotoYoutube();
        if(num <= 5)
        {
            sendKeysFunction(ytSearchField,"Matematik Konu Anlatımı");
            sendKeysFunction(ytSearchField,Keys.ENTER);
        }
        else if(num > 5)
        {
            sendKeysFunction(ytSearchField,"Türkçe Konu Anlatımı");
            sendKeysFunction(ytSearchField,Keys.ENTER);
        }
        else{
            System.out.println("Number search error.");
        }
    }
    public void listToVideos() throws InterruptedException {
        for(int i=0;i<videoList.size();i++)
        {
            String baslik = videoList.get(i).findElement(By.cssSelector(videoTitleString)).getText();
            baslik=baslik.toLowerCase();
            baslikList.add(baslik);
        }
    }
    public void searchTytWord(){
        for(int i=0;i<baslikList.size();i++)
        {
            if(baslikList.get(i).contains("tyt"))
            {
                selectedVideo = videoList.get(i);
                break;
            }
        }
    }
    public void selectVideo() throws InterruptedException {
        selectedVideo.findElement(By.cssSelector(videoLink)).click();
    }
    public void pauseVideo(){
        WebElement video = driver.findElement(By.tagName("video"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].pause();", video);
    }
    public void skipCurrentTime(){
        WebElement video = driver.findElement(By.tagName("video"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].currentTime=60",video);
    }
    public void skipORwaitADD() throws InterruptedException {
        gecilmeyenReklam = driver.findElements(By.cssSelector(gecilmeyenReklamStr));
        skipAddButton = driver.findElements(By.cssSelector(skipAddBtn));

        if((gecilmeyenReklam.size()==0 || gecilmeyenReklam==null) && (skipAddButton.size()==0 || skipAddButton==null))
        {
            skipCurrentTime();
            pauseVideo();
        }
        else if(skipAddButton.size() != 0)
        {
            skipAdd();
        }
        else if(gecilmeyenReklam.size() !=0)
        {
            waitAdd();
        }
        else
        {
            System.out.println("Koşul sorgusunda bir hata oluştu.");
        }
    }
    public void skipAdd() throws InterruptedException {
        WebElement sureElement = driver.findElement(By.className(ytTimeRemaining));
        String reklamSuresi=sureElement.findElement(By.className(ytAddTime)).getText();
        String[] parcali;
        parcali=reklamSuresi.split(":");
        switch (parcali[0])
        {
            case "1":
                parcali[0] = "60";
                break;
            case "2":
                parcali[0] = "120";
                break;
        }
        int toplamSure = Integer.parseInt(parcali[0]) + Integer.parseInt(parcali[1]);
        System.out.println("VİDEO SÜRESİ ESKİ HAL: "+reklamSuresi);
        System.out.println("VİDEO SÜRESİ YENİ HAL: "+toplamSure);
        driver.findElement(By.cssSelector(skipAddBtn)).click();
        Thread.sleep(2000);
        skipCurrentTime();
        pauseVideo();
        Thread.sleep(2000);
    }
    public void waitAdd() throws InterruptedException {
        String sureText = driver.findElement(By.cssSelector(gecilmeyenReklamStr)).getText();
        String[] sureTextList = sureText.trim().split("");
        int sure = Integer.parseInt(sureTextList[sureTextList.length-1]);
        System.out.println("Geçilmeyen reklam süresi: "+sure);
        System.out.println("Uzunluk Length: "+sureTextList.length);
        System.out.println(sureTextList[0]);
        Thread.sleep(sure + 1000);
        skipCurrentTime();
        pauseVideo();
        Thread.sleep(2000);

    }
    public void videoisPlaying(){
        String sure = driver.findElement(By.cssSelector(ytCurrentTimeStr)).getText();
        String[] bolunenSure = sure.split(":");
        if(Integer.parseInt(bolunenSure[1]) > 0)
        {
            System.out.println("Video oynatılıyor.");
        }
    }
    public void controlToCurrentTime(){
        sarilanSure = driver.findElement(By.cssSelector(ytCurrentTimeStr)).getText();
        System.out.println("Sarılan Süre: "+sarilanSure);
        String[] sarilanSureList = sarilanSure.split(":");
        if(sarilanSureList[0].equals("1"))
        {
            System.out.println("Dakika 1e sarıldı.");
        }
        else{
            System.out.println("Dakika sarılamadı.");
        }
    }
}
