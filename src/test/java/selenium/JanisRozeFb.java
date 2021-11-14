package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JanisRozeFb {


    private final String HOME_PAGE_URL = "https://www.janisroze.lv/";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[contains(@class,'ch2-btn-text-xxs')]");
    private final By DROPDOWN_MENU = By.xpath(".//ul[contains(@class,'account-dropdown long')]");
    private final By FACEBOOK_BTN = By.xpath(".//div[contains(@class,'scandi-facebookconnect-facebook-inner')]");
    private final By ACCEPT_FB_COOKIES_BTN = By.xpath(".//button[contains(@data-cookiebanner, 'accept_button')]");
    private final By FB_EMAIL_INPUT_FORM = By.id("email");
    private final By FB_PASSWORD_INPUT_FORM = By.id("pass");
    private final By FB_LOGIN_BTN = By.id("loginbutton");
    private WebDriver browser;


    @Test
    public void logInFb() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        browser.findElement(DROPDOWN_MENU).click();
        browser.findElement(FACEBOOK_BTN).click();
        browser.findElement(ACCEPT_FB_COOKIES_BTN).click();
        browser.findElement(FB_EMAIL_INPUT_FORM).sendKeys("annakalinina98@inbox.lv");
        browser.findElement(FB_PASSWORD_INPUT_FORM).sendKeys("Lovemyjob123");
        browser.findElement(FB_LOGIN_BTN).click();

    }
}