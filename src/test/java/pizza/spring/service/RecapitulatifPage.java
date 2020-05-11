package pizza.spring.service;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

public class RecapitulatifPage {
	
	WebDriver webdriver;
	public RecapitulatifPage(WebDriver webdriver) {
		this.webdriver = webdriver;

	}
	
	public boolean isNamePresent() {
		System.out.println("Recap name:"+ CommandPage.name);
		return webdriver.getPageSource().contains(CommandPage.name);
		
	}
	public boolean isPizzaPresent() {
		return webdriver.getPageSource().contains(CommandPage.tel);
	}
	public boolean isPhoneNumberPresent() {
		return webdriver.getPageSource().contains(CommandPage.tel);
	}
}
