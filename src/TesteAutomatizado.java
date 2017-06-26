import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteAutomatizado {
	public static void main(String[] args) {
		
		//Abaixo site para baixar drivers do chrome, atenção com a versão do navegador ser compatível com a do site
		//https://github.com/mozilla/geckodriver/releases
		//System.setProperty("webdriver.gecko.driver", "/home/aroldo/Projetos/testes-de-sistema/geckodriver");
		
		//Abaixo site para baixar drivers do chrome, atenção com a versão do navegador ser compatível com a do site
		//https://sites.google.com/a/chromium.org/chromedriver/downloads
		System.setProperty("webdriver.chrome.driver", "/home/aroldo/Projetos/exemplo-selenium-webdriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com.br/");
		
		WebElement campoBusca = driver.findElement(By.name("q"));
		campoBusca.sendKeys("Caelum");	
		campoBusca.submit();
	}
}
