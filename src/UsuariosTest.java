import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UsuariosTest {
	
	private WebDriver driver;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "/home/aroldo/Projetos/exemplo-selenium-webdriver/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/usuarios");
		WebElement btNovoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		btNovoUsuario.click();
	}

	@After
	public void finaliza(){
		driver.close();
	}
	
	@Test
	public void adicionarUsuarioComSucesso() {

		
		WebElement campoNome = driver.findElement(By.name("usuario.nome"));
		WebElement campoEmail = driver.findElement(By.name("usuario.email"));
		WebElement btSalvar = driver.findElement(By.id("btnSalvar"));
		
		campoNome.sendKeys("Aroldo Xavier Leite Filho");
		campoEmail.sendKeys("aroldoxleite@gmail.com");
		btSalvar.click();
		
		boolean achouNome = driver.getPageSource().contains("Aroldo Xavier Leite Filho");
		boolean achouEmail = driver.getPageSource().contains("aroldoxleite@gmail.com");
		
		assertTrue(achouNome);
		assertTrue(achouEmail);
	}
	
	@Test
	public void adicionarUsuarioSemNomeComEmail() {
		
		WebElement campoNome = driver.findElement(By.name("usuario.nome"));
		WebElement campoEmail = driver.findElement(By.name("usuario.email"));
		WebElement btSalvar = driver.findElement(By.id("btnSalvar"));
		
		campoNome.sendKeys("");
		campoEmail.sendKeys("aroldoxleite@gmail.com");
		btSalvar.click();
		
		
		boolean msgNomeObrigatorio = driver.getPageSource().contains("Nome obrigatorio!");
		
		assertTrue(msgNomeObrigatorio);
	}
	
	@Test
	public void adicionarUsuarioSemNomeSemEmail() {
		
		WebElement campoNome = driver.findElement(By.name("usuario.nome"));
		WebElement campoEmail = driver.findElement(By.name("usuario.email"));
		WebElement btSalvar = driver.findElement(By.id("btnSalvar"));
		
		campoNome.sendKeys("");
		campoEmail.sendKeys("");
		btSalvar.click();
		
		boolean msgNomeObrigatorio = driver.getPageSource().contains("Nome obrigatorio!");
		boolean msgEmailObrigatorio = driver.getPageSource().contains("E-mail obrigatorio");
		
		assertTrue(msgNomeObrigatorio);
		assertTrue(msgEmailObrigatorio);
	}
}
