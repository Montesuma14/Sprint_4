package tests;

import models.ScooterPraktikumMainPageModel;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox",
                //"--headless",
                "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ScooterPraktikumMainPageModel.MAIN_PAGE_URL);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
