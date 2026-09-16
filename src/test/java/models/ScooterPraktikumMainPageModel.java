package models;

import models.support.Chevron;
import org.openqa.selenium.*;

public class ScooterPraktikumMainPageModel {

    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private WebDriver driver;
    final private By headerOrderButton = By.xpath(
            ".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    final private By mainOrderButton = By.xpath(
            ".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public ScooterPraktikumMainPageModel(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFaqDisplayedWithExpectedContent(Chevron chevron) {
        WebElement accordionItem = driver.findElement(By.xpath(
                ".//div[contains(text(),'" + chevron.getChevronQuestion() + "')]/parent::div/parent::div"));
        WebElement question = accordionItem.findElement(By.cssSelector("[data-accordion-component='AccordionItemButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", question);
        question.click();
        WebElement answer = accordionItem.findElement(By.xpath(".//div[@class='accordion__panel']//p"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", answer);
        if (answer.isDisplayed()) {
            if (chevron.getChevronAnswer().equals(answer.getText())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void clickOrderButton(String orderButton) {
        if (orderButton == "headerButton") {
            WebElement button = driver.findElement(headerOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
        } else if (orderButton == "mainButton") {
            WebElement button = driver.findElement(mainOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
        }
    }
}



