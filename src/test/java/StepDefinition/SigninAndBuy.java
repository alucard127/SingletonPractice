package StepDefinition;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SigninAndBuy {
    private WebDriver Driver;

    @Before
    public void Driver() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALUCARD\\IdeaProjects\\AutomationPractice\\src\\main\\resources\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();
        options.setCapability("marionette", false);

        Driver = new ChromeDriver(options);

        Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        Driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        Driver.manage().window().maximize();
    }

    @Test
    public void Buy() {

        Driver.get("http://www.automationpractice.com/index.php");


        WebElement labelSignIn = Driver.findElement(By.xpath("//*[@title='Log in to your customer account']"));
        labelSignIn.click();


        WebElement campoEmail = Driver.findElement(By.cssSelector("#email"));
        campoEmail.sendKeys("unisoftbo@gmail.com");


        WebElement campoPassword = Driver.findElement(By.cssSelector("#passwd"));
        campoPassword.sendKeys("00000");


        WebElement botonSignIn = Driver.findElement(By.cssSelector("#SubmitLogin"));
        botonSignIn.click();


        WebElement etiquetaTshirts = Driver.findElement(By.xpath("//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/a[contains(text(),\"T-shirts\")]"));
        etiquetaTshirts.click();


        Actions action = new Actions(Driver);


        WebElement we = Driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));


        action.moveToElement(we).moveToElement(Driver.findElement(By.cssSelector(".ajax_add_to_cart_button.btn.btn-default"))).click().build().perform();


        WebElement botonCerrarCompra = Driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        botonCerrarCompra.click();


        WebElement botonSegundoCerrarCompra = Driver.findElement(By.xpath("//p//*[contains(text(),'Proceed to checkout')]"));
        botonSegundoCerrarCompra.click();


        WebElement botonTercerCerrarCompra = Driver.findElement(By.xpath("//button/span[contains(text(),'Proceed to checkout')]"));
        botonTercerCerrarCompra.click();


        WebElement checkboxAceptoLasCondiciones = Driver.findElement(By.cssSelector("#cgv"));
        checkboxAceptoLasCondiciones.click();


        WebElement botonCuartoCerrarCompra = Driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]"));
        botonCuartoCerrarCompra.click();



        WebElement botonPagarConCheque = Driver.findElement(By.cssSelector(".cheque"));
        botonPagarConCheque.click();


        WebElement botonConfirmarOrden = Driver.findElement(By.xpath("//*[contains(text(),'I confirm my order')]"));
        botonConfirmarOrden.click();


        WebElement bannerOrdenCompleta = Driver.findElement(By.className("alert"));
        Assert.assertTrue(bannerOrdenCompleta.isDisplayed());
    }

    @After
    public void closeDriver() {

        Driver.quit();
    }
}