package models;

import org.openqa.selenium.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ScooterPraktikumOrderPageModel {
    private WebDriver driver;

    private final By frstPageFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private final By frstPageSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By frstPageAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By frstPageSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By frstPagePhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By frstPageNextButton = By.xpath(".//button[text()='Далее']");

    private final By scndPageDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By scndPageRentalPeriod = By.xpath(".//div[text()='* Срок аренды']/parent::div/parent::div[contains(@class,'Dropdown-root')]");
    private final By scndPageColor= By.xpath(".//div[text()='Цвет самоката']/parent::div");
    private final By scndPageComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By scndPageOrderButton = By.xpath(".//button[text()='Заказать' and @class='Button_Button__ra12g Button_Middle__1CSJM']");

    private final By acceptOrderButton = By.xpath(".//button[text()='Да']");

    private final By modalWindowOrderAcceptedTitle = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and contains(text(),'Заказ оформлен')]");
    private final By modalWindowOrderAcceptedButton = By.xpath(".//button[text()='Посмотреть статус']");



    public ScooterPraktikumOrderPageModel(WebDriver driver) {
        this.driver = driver;
    }





    private void setFirstName(String firstName){
        driver.findElement(frstPageFirstName).sendKeys(firstName);
    }

    private void setSecondName(String secondName){
        driver.findElement(frstPageSecondName).sendKeys(secondName);
    }

    private void setAddress(String address){
        driver.findElement(frstPageAddress).sendKeys(address);
    }
    private void selectMetroStation(String subwayStation){
        driver.findElement(frstPageSubwayStation).sendKeys(subwayStation);
        WebElement button = driver.findElement(By.xpath("//div[text()='" + subwayStation + "']/parent::button"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);

        button.click();

    }
    private void setPhone(String phone){
        driver.findElement(frstPagePhone).sendKeys(phone);
    }
    public void fillFirstPageOrderForm(String firstName, String secondName, String address, String subwayStation, String phone){
        setFirstName(firstName);
        setSecondName(secondName);
        setAddress(address);
        selectMetroStation(subwayStation);
        setPhone(phone);
        WebElement nextButton = driver.findElement(frstPageNextButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", nextButton);
        nextButton.click();

    }

    private void setDate(String date){
        driver.findElement(scndPageDate).sendKeys(date, Keys.ENTER);
    }

    private void setRentalPeriod(String period){
        WebElement rentalInput = driver.findElement(scndPageRentalPeriod).findElement(By.xpath("//div[text()='* Срок аренды']"));
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", rentalInput);
        rentalInput.click();

        driver.findElement(scndPageRentalPeriod).findElement(By.xpath("//div[@class='Dropdown-menu']/div[text()='" + period + "']")).click();
    }

    private void setColor(String color){
        driver.findElement(scndPageColor).findElement(By.xpath("//label[text() ='" + color + "']")).click();
    }

    private void setComment(String comment){
        driver.findElement(scndPageComment).sendKeys(comment);
    }

    private void clickAcceptButton(){
        driver.findElement(acceptOrderButton).click();
    }


    public void fillSecondPageOrderForm(String date, String period, String color, String comment){
        setDate(date);
        setRentalPeriod(period);
        setColor(color);
        setComment(comment);
        WebElement orderButton = driver.findElement(scndPageOrderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButton);
        orderButton.click();
        clickAcceptButton();

    }

    public void checkingOrderWasAccepted(){
        assertFalse(driver.findElements(modalWindowOrderAcceptedTitle).isEmpty());
        WebElement modalWindowTitle = driver.findElement(modalWindowOrderAcceptedTitle);
        assertTrue(modalWindowTitle.isDisplayed());
        assertTrue(modalWindowTitle.isEnabled());
        WebElement modalWindowbutton = driver.findElement(modalWindowOrderAcceptedButton);
        modalWindowbutton.click();

    }











}
