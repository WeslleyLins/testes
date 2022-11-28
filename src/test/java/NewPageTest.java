import com.sun.source.tree.AssertTree;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

@TestInstance(Lifecycle.PER_CLASS)
public class NewPageTest {

  WebDriver webdriver;

  @BeforeAll
  public void setupAll(){
    System.setProperty("webdriver.chrome.driver",
        "src/test/resources/chromedriver.exe");
  }

  @BeforeEach
  public void setup(){
    webdriver = new ChromeDriver();
    webdriver.manage().window().maximize();
  }

  @AfterEach
  public void closeDriver(){
    webdriver.close();
  }


  @Test
  public void openNewPage(){
    webdriver.get("https://www.amazon.com.br/ref=nav_logo");
    Assertions.assertEquals("https://www.amazon.com.br/ref=nav_logo",
        webdriver.getCurrentUrl());
  }

  @Test
  public void openAjudaPage(){
    webdriver.get("https://www.amazon.com.br");
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[7]/ul/li[6]/a"));
    botao.click();
    Assertions.assertTrue(botao.isEnabled());

  }

  @Test
  public void openProductPageUnicap(){
    webdriver.get("https://www.amazon.com.br");
    WebElement botaoFB = webdriver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
    botaoFB.click();
    Assertions.assertEquals("https://www.amazon.com.br/gp/browse.html?node=17877554011&ld=ASBRSOA_retail_sell_header&ref_=nav_cs_sell",
                webdriver.getCurrentUrl());
  }

  @Test
  public void selectCadastroTest(){
    webdriver.get("https://vihhllopes.github.io/StudioMW-vihhllopes-willinny-s/cadastro.html");
    WebElement botaoSelect = webdriver.findElement(By.xpath("/html/body/div/fieldset/form/div[4]/select"));
    Select select = new Select(botaoSelect);
    select.selectByIndex(0);
    Assertions.assertTrue(botaoSelect.isEnabled());

  }


  @Test
  public void openPaginaFantastico (){
    webdriver.get("https://www.amazon.com.br");

    WebElement search = webdriver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));

    search.sendKeys("celular");
    search.submit();



  }

  @Test
  public void moverBotao(){
    webdriver.get("https://www.amazon.com.br");
    Actions actions = new Actions(webdriver);
    WebElement botao = webdriver.findElement(
        By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));
    actions.moveToElement(botao).perform();
  }



  @Test
  public void tooltipTest(){
    webdriver.get("https://www.amazon.com.br");
    Actions actions = new Actions(webdriver);

    WebElement livros = webdriver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[7]"));
    actions.moveToElement(livros).perform();
    Assertions.assertTrue(livros.isEnabled());
  }


}
