package models;


import models.supportClasses.Chevron;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ScooterPraktikumPageModel {

    private WebDriver driver;
    final private Chevron[] FAQchevrons = new Chevron[]{new Chevron("Сколько это стоит? И как оплатить?",
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой."),
            new Chevron("Хочу сразу несколько самокатов! Так можно?",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."),
            new Chevron("Как рассчитывается время аренды?",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."),
            new Chevron("Можно ли заказать самокат прямо на сегодня?",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее."),
            new Chevron("Можно ли продлить заказ или вернуть самокат раньше?",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."),
            new Chevron("Вы привозите зарядку вместе с самокатом?",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."),
            new Chevron("Можно ли отменить заказ?",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."),
            new Chevron("Я жизу за МКАДом, привезёте?",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области."),

    };

    final private By headerOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()='Заказать']");
    final private By mainOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");




    public ScooterPraktikumPageModel(WebDriver driver){
        this.driver = driver;
    }






    public void checkingChevrons(){

        for(int i = 0; i < FAQchevrons.length; i++){
            WebElement AccordionItem = driver.findElement(By.xpath(".//div[contains(text(),'" + FAQchevrons[i].getChevronQuestion() + "')]/parent::div/parent::div"));
            WebElement question = AccordionItem.findElement(By.cssSelector("[data-accordion-component='AccordionItemButton']"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", question);
            question.click();
            WebElement answer = AccordionItem.findElement(By.xpath(".//div[@class='accordion__panel']//p"));
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", answer);
            assertTrue(answer.isDisplayed());
            assertEquals(
                    FAQchevrons[i].getChevronAnswer(),
                    answer.getText()
            );

        }
    }

    public void clickOrderButton(String OrderButton){
        if(OrderButton == "headerButton"){
            WebElement button  = driver.findElement(headerOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
        } else if (OrderButton == "mainButton") {
            WebElement button  = driver.findElement(mainOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", button);
            button.click();
            
        }


    }





}



