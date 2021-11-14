package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JanisRoze {

    private final String HOME_PAGE_URL = "https://www.janisroze.lv/";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[contains(@class,'ch2-btn-text-xxs')]");
    private final By DROPDOWN_MENU = By.xpath(".//ul[contains(@class,'account-dropdown long')]");
    private final By LOGIN_INPUT = By.id("email");
    private final By PASSWORD_INPUT = By.id("pass");
    private final By LOGIN_BTN = By.id("send2");

    private WebDriver browser;

    @Test
    public void logIn() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        browser.manage().window().maximize();
        browser.get(HOME_PAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();
        browser.findElement(DROPDOWN_MENU).click();
        browser.findElement(LOGIN_INPUT).sendKeys("annakalinina3472@gmail.com");
        browser.findElement(PASSWORD_INPUT).sendKeys("Lovemyjob123");
        browser.findElement(LOGIN_BTN).click();


    }

    @AfterEach
    public void closeBrowser() {
        browser.close();

    }
}
