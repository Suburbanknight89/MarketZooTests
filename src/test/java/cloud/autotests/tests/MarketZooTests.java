package cloud.autotests.tests;

import cloud.autotests.allure.JiraIssue;
import cloud.autotests.allure.JiraIssues;
import cloud.autotests.allure.Layer;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MarketZooTests extends TestBase {

	@Test
	@DisplayName("Положить 2 кошачих лакомства в корзину, свравнить по параметрам и удалить из списка " +
			"сравнения")
	@Layer("web")
	@Story("market.yandex.ru tests")
	@Tags({ @Tag("web") })
	@Owner("ZaytsevE")
	@JiraIssues({ @JiraIssue("HOMEWORK-300") })
	void putAndDeleteCatFeedTest() {
		step("open https://market.yandex.ru/", () -> {
			open("https://market.yandex.ru/");
		});

		step("Нажать кнопку 'каталог'", () -> {
			$(byText("Каталог")).click();
		});

		step("Навести курсор на «Зоотовары, в блоке «Для кошек» нажать на «Лакомства» ", () -> {
			$(byText("Зоотовары")).hover();
			$(byLinkText("Лакомства")).click();
		});

		step("Установить фильтры и нажать 'сравнить'", () -> {
			$("#glpricefrom").val("50");
			$("#glpriceto").val("150");
			$(byText("С учётом доставки курьером")).click();
			$(byText("Molina")).click(); //при анонимном входе корм вискас недоступен для выбора
			$(byPartialLinkText("Лакомство для кошек Molina")).click();
		});

		step(" Перейти в первый товар в списке, нажать на кнопку «Сравнить» ", () -> {
			switchTo().window(1);
			$(byText("Сравнить")).closest("div").click();
		});

		step("Вернуться на предыдущую страницу", () -> {
			switchTo().window(0);
		});

		step("В фильтре снять галочку с производителя «Whiskas» и установить производителя «Мнямс» ",
				() -> {
					$(byText("Molina")).click();
					$(byText("Мнямс")).click();
					$(byPartialLinkText("Лакомство для кошек Мнямс"), 1).click();
				});

		step("Перейти во второй товар в списке, нажать на кнопку «Сравнить» ", () -> {
			switchTo().window(2);
			$(byText("Сравнить")).closest("div").click();
		});

		step("Перейти в «Сравнение», проверить, что имена товаров в сравнении соответствуют " +
				"именам товаров, добавленных на шагах 5 и 8 ", () -> {
			$(byText("Сравнить")).click();
			$(byPartialLinkText("Лакомство для кошек Мнямс")).should(exist);
			$(byPartialLinkText("Лакомство для кошек Molina")).should(exist);
		});

		step("Проверить, что сумма стоимостей товаров не превышает 300 руб", () -> {
			String price1 =
					$(byXpath("/html/body/div[1]/div[5]/div[2]/div/div[4]/div/div[1]/div/span")).text();
			//получили строку с ценой товара 1
			String x1 = price1.replaceAll("[^0-9]", ""); //оставили в цене только цифры
			String price2 =
					$(byXpath("/html/body/div[1]/div[5]/div[2]/div/div[4]/div/div[2]/div/span")).text();
			//получили строку с ценой товара 1
			String x2 = price2.replaceAll("[^0-9]", ""); //оставили в цене только цифры
			int x3 = Integer.parseInt(x1); //перевели числа текстовом формате в int
			int x4 = Integer.parseInt(x2); //перевели числа текстовом формате в int
			int y = x3 + x4;
			System.out.println(y < 300);
		});

		step("Удалить товар производителя «Whiskas» из сравнения и проверить, что товар производителя " +
				"«Whiskas» не отображается " +
				"именам товаров, добавленных на шагах 5 и 8 ", () -> {
			$("._2bqiO").hover().click();
			$(byText("Лакомство для кошек Мнямс Крем-лакомство с курицей")).shouldNot(exist);
		});

		step("Нажать на «Удалить список» (значок мусорного бака), проверить, что товары не отображаются " +
				"именам товаров, добавленных на шагах 5 и 8 ", () -> {
			$("._1KU3s").click();
			$("._2szVR").shouldHave(text("Сравнивать пока нечего"));
		});
	}
}
