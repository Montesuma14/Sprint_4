package tests;

import models.ScooterPraktikumMainPageModel;
import models.ScooterPraktikumOrderPageModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

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

    public OrderTest(String firstName,
                     String secondName,
                     String address,
                     String subwayStation,
                     String phone,
                     String date,
                     String period,
                     String color,
                     String comment,
                     String buttonType) {
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
        return new Object[][]{
                {
                        "Петя",
                        "Ванин",
                        "Москва, Ленина 15",
                        "Бульвар Рокоссовского",
                        "89093333333",
                        "26.11.2026",
                        "сутки",
                        "чёрный жемчуг",
                        "Тестовый комментарий номер 1",
                        "headerButton"
                },
                {
                        "Елена",
                        "Неванина",
                        "Ярославль, Ленина 15",
                        "Черкизовская",
                        "89091111111",
                        "21.11.2026",
                        "двое суток",
                        "серая безысходность",
                        "Тестовый комментарий номер 2. Ура!",
                        "mainButton"
                },
        };
    }

    @Test
    public void orderScooter() {
        ScooterPraktikumMainPageModel mainPage =
                new ScooterPraktikumMainPageModel(driver);

        mainPage.clickOrderButton(buttonType);

        ScooterPraktikumOrderPageModel orderPage =
                new ScooterPraktikumOrderPageModel(driver);

        orderPage.fillFirstPageOrderForm(
                firtsName,
                secondName,
                address,
                subwayStation,
                phone
        );

        orderPage.fillSecondPageOrderForm(
                date,
                period,
                color,
                comment
        );

        assertTrue(
                "Заказ не был успешно оформлен",
                orderPage.isOrderAccepted()
        );
    }

}
