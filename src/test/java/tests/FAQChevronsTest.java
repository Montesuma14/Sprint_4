package tests;

import models.ScooterPraktikumPageModel;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FAQChevronsTest {
    private WebDriver driver;

    @Test
    public void checkFAQChevronsInStartPage(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterPraktikumPageModel scooterPraktikumPageModel = new ScooterPraktikumPageModel(driver);
        scooterPraktikumPageModel.checkingChevrons();



    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }


}
