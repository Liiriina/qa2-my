package homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DelfiTests {


    private WebDriver browser;
    private final String HOME_PAGE_URL = "http://rus.delfi.lv";
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By HEADLINE_TITLE_INSIDE = By.xpath(".//div[contains(@class, 'article-title')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());


    @Test

    public void titleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count");

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        LOGGER.info("Opening browser");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));

        browser.manage().window().maximize();
        LOGGER.info("Opening homepage");
        browser.get(HOME_PAGE_URL);
        LOGGER.info("Waiting for accept cookies btn");
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        LOGGER.info("Accepting cookies");
        browser.findElement(ACCEPT_COOKIES_BTN).click();

        WebElement firstTitle = browser.findElement(ARTICLE_TITLE);
        System.out.println(firstTitle.getText());
        browser.findElement(ARTICLE_TITLE).click();
        WebElement headlineTitle = browser.findElement(HEADLINE_TITLE_INSIDE);
        System.out.println(headlineTitle.getText());

        //вывожу в консоль все статьи со страницы статьи (не все статьи которые на главное страницу)

        List<WebElement> titles = browser.findElements(ARTICLE_TITLE);
        for (int i = 0; i < titles.size(); i++) {
            if (!titles.get(i).getText().isEmpty()) {
                System.out.println(i + ": " + titles.get(i).getText());

            }
        }
    }
}



