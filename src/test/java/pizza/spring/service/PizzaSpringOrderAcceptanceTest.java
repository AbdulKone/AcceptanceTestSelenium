package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PizzaSpringOrderAcceptanceTest {
		
	private WebDriver webdriver;
	@Before
	public void creatWebDriver() {
		webdriver = new ChromeDriver();
	}
	
	@After
	public void closeWebDriver() {
		webdriver.quit();
	}
	
	@Test
	public void SuccessfulPizza() throws Exception {
		RecapitulatifPage recapitulatifPage = new RecapitulatifPage(webdriver);
		CommandPage.openWith(webdriver)
							.SelectPizzas("Regina")
							.SelectPizzas("Margherita")
							.setName("Abdul KONE")
							.setTel("0615177055")
							.clickOnCommander();
		assertTrue(recapitulatifPage.isPizzaPresent() && recapitulatifPage.isPhoneNumberPresent());
	}
	
	@Test
	public void telMissing() throws Exception{
		CommandPage commandPage = new CommandPage(webdriver);
		CommandPage.openWith(webdriver)
					.openCommandePage()
					.SelectPizzas("Margherita")
					.setName(" I aint got no tel")
					.setTel("")
					.clickOnCommander();
		assertTrue(commandPage.is_phoneInvalid());;
	}
	
	@Test
	public void PizzaMissing() throws Exception{
		CommandPage commandPage = new CommandPage(webdriver);
		CommandPage.openWith(webdriver)
					.openCommandePage()
					.DeselectAllPizza()
					.setName("I don't know the pizza i want")
					.setTel("0615177055")
					.clickOnCommander();
		assertTrue(commandPage.is_pizzaInvalid());;
	}
	
}
