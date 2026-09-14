package tests;

import models.ScooterPraktikumOrderPageModel;
import models.ScooterPraktikumPageModel;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private String firtsName;
    private String secondName;
    private String address;
    private String subwayStation;
    private String phone;
    private String date;
    private String period;
    private String color;
    private String comment;
    private String buttonType;



    public OrderTest(String firstName, String secondName, String address, String subwayStation, String phone, String date, String period, String color, String comment, String buttonType){

        this.firtsName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
        this.buttonType = buttonType;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "Петя", "Ванин", "Москва, Ленина 15", "Бульвар Рокоссовского","89093333333", "26.11.2026", "сутки", "чёрный жемчуг", "Тестовый комментарий номер 1", "headerButton"},
                { "Елена", "Неванина", "Ярославль, Ленина 15", "Черкизовская","89091111111", "21.11.2026", "двое суток", "серая безысходность", "Тестовый комментарий номер 2. Ура!","mainButton"},
        };
    }









    @Test
    public void orderScooter(){
        ChromeOptions options = new ChromeOptions();
        //FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox",
                //"--headless",
                "--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        //driver = new FirefoxDriver(options);

        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
        ScooterPraktikumPageModel scooterPraktikumPageModel = new ScooterPraktikumPageModel(driver);
        scooterPraktikumPageModel.clickOrderButton(buttonType);
        ScooterPraktikumOrderPageModel scooterPraktikumOrderPageModel = new ScooterPraktikumOrderPageModel(driver);
        scooterPraktikumOrderPageModel.fillFirstPageOrderForm(firtsName, secondName, address, subwayStation, phone);
        scooterPraktikumOrderPageModel.fillSecondPageOrderForm(date, period, color, comment);
        scooterPraktikumOrderPageModel.checkingOrderWasAccepted();


    }

    @After
    public void teardown() {
        driver.quit();
    }




}
