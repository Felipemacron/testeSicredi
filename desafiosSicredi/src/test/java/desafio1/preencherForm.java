package desafio1;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class preencherForm {
	
    private WebDriver driver;
    private WebDriverWait wait;
	
	@BeforeEach
	public void antesDoTeste() {
		driver = new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap");
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		
	}
	
	@AfterEach
	public void depoisDoTeste() {
		driver.quit();
		
	}
	
	@Test
	public void testeForm() {
	    
	    WebElement selectElement = driver.findElement(By.id("switch-version-select"));
	    Select dropdown = new Select(selectElement);
	    dropdown.selectByVisibleText("Bootstrap V4 Theme");
	    
	    driver.findElement(By.xpath("//a[@class='btn btn-default btn-outline-dark']")).click();
	    
	    driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
	    driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
	    driver.findElement(By.id("field-contactFirstName")).sendKeys("seu nome");
	    driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
	    driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
	    driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
	    driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
	    driver.findElement(By.id("field-state")).sendKeys("RS");
	    driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
	    driver.findElement(By.id("field-country")).sendKeys("Brasil");
	    driver.findElement(By.id("field-salesRepEmployeeNumber")).sendKeys("Fixter");
	    driver.findElement(By.id("field-creditLimit")).sendKeys("200");
	    
	    driver.findElement(By.id("form-button-save")).click();
	    
	    WebElement successMessage = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='report-success']"))
	    );
	    
	    String mensagemAtual = successMessage.getText();
	    String mensagemEsperada = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
	    
	    assertEquals(mensagemEsperada, mensagemAtual);
	}

	
	

}
