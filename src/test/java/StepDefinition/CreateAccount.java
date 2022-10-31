package StepDefinition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	WebDriver Driver;
	@Before
	public void Driver() {

		try {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALUCARD\\IdeaProjects\\AutomationPractice\\src\\main\\resources\\chromedriver.exe");
			Driver = new ChromeDriver();
			Driver.manage().window().maximize();
			Driver.manage().deleteAllCookies();
			Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			fillForm();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	public void fillForm() {
		try {
			Driver.navigate().to("http://www.automationpractice.com");
			Driver.findElement(By.className("login")).click();

			Driver.findElement(By.cssSelector("#email_create")).sendKeys("unisoftb1o@gmail.com");

			Driver.findElement(By.cssSelector("#email_create")).sendKeys(Keys.TAB);

			Driver.findElement(By.cssSelector("#SubmitCreate")).click();
			Driver.findElement(By.id("uniform-id_gender1")).isEnabled();

			WebElement radioButton = Driver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]"));
			radioButton.click();


			Driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Roberto");
			Driver.findElement(By.cssSelector("#customer_firstname")).sendKeys(Keys.TAB);


			Driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Franco");
			Driver.findElement(By.cssSelector("#customer_lastname")).sendKeys(Keys.TAB);


			Driver.findElement(By.cssSelector("#email")).sendKeys(Keys.TAB);


			Driver.findElement(By.cssSelector("#passwd")).sendKeys("123456789");
			Driver.findElement(By.cssSelector("#passwd")).sendKeys(Keys.TAB);


			Select dayDropDown = new Select(Driver.findElement(By.id("days")));
			dayDropDown.selectByIndex(20);


			Select monthDropDown = new Select(Driver.findElement(By.id("months")));
			monthDropDown.selectByIndex(1);


			Select yearDropDown = new Select(Driver.findElement(By.id("years")));
			yearDropDown.selectByIndex(35);


			WebElement newsLetterCheckBox = Driver.findElement(By.id("newsletter"));
			newsLetterCheckBox.click();


			WebElement specialOffersCheckBox = Driver.findElement(By.id("optin"));
			specialOffersCheckBox.click();

			Driver.findElement(By.id("address1")).sendKeys("Calle Sucre");
			Driver.findElement(By.id("address1")).sendKeys(Keys.TAB);

			Driver.findElement(By.id("address2")).sendKeys("Calle Bolivar");
			Driver.findElement(By.id("address2")).sendKeys(Keys.TAB);

			Driver.findElement(By.id("city")).sendKeys("Cochabamba");
			Driver.findElement(By.id("city")).sendKeys(Keys.TAB);

			Select stateDropDown = new Select(Driver.findElement(By.id("id_state")));
			stateDropDown.selectByIndex(5);

			Driver.findElement(By.id("postcode")).sendKeys("01021");

			Driver.findElement(By.id("phone_mobile")).sendKeys("12345678");

			Driver.findElement(By.id("submitAccount")).click();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	@After
	public void closeDriver() {

		Driver.quit();
	}


}
