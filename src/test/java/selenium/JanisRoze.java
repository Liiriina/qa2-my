package selenium;

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
    private final By PROFILE_HEADER = By.xpath(".//[@id='header-account']");

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
        browser.findElement(PROFILE_HEADER).click();



    }

}
