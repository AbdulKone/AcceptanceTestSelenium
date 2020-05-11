package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class CommandPage {
	
	private WebDriver webdriver;
	public static String name = "";
	public static String tel ="";
	public static String pizza = "";
	
	public CommandPage(WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public CommandPage openCommandePage() {
		webdriver.navigate().to("http://localhost:8080/pizza-spring/commande");
		assertTrue(webdriver.getTitle().startsWith("Pizza Spring"));
		return this;
	}


	public static CommandPage openWith(WebDriver webDriver) {
		CommandPage commandPage = new CommandPage(webDriver);
		commandPage.openCommandePage();
		return commandPage;
	}

	public CommandPage setName (String... words) {
		WebElement input = webdriver.findElement(By.id("nom"));
		input.sendKeys(String.join(" ", words));
		name = String.join(" ", words);
		return this;
	}
	

	public CommandPage setTel(String telNumber) {
		WebElement input = webdriver.findElement(By.id("telephone"));
		input.sendKeys(telNumber);
		tel = telNumber;
		return this;
	}
	
	public CommandPage SelectPizzas(String pizza) throws Exception {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectByVisibleText(pizza);   
		return this;
	}
	
	public void clickOnCommander() {
		WebElement submit_button = webdriver.findElement(By.cssSelector("button"));
		submit_button.click();
	}
	public boolean is_phoneInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("telephone.errors"));
		return label.isDisplayed();
	}
	public boolean is_pizzaInvalid() throws Exception {
		WebElement label = webdriver.findElement(By.id("pizzaId.errors"));
		return label.isDisplayed();
	}
	
	public CommandPage DeselectAllPizza() {
		WebElement select = webdriver.findElement(By.id("pizzaId"));
        Select selectPizzas = new Select(select);
        selectPizzas.deselectAll();
        return this;
	}
	
}
