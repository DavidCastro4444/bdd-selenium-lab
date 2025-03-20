package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.CheckBoxPage;

import java.util.concurrent.TimeUnit;

public class CheckboxesStepDefinitions {
    private WebDriver driver;  // Instancia del navegador
    private CheckBoxPage checkBoxPage; // Página de los checkboxes

    /**
     * Configura el navegador y abre la página de checkboxes.
     */
    @Given("I open the checkboxes page")
    public void openCheckboxesPage() {
        setupWebDriver(); // Configuración del navegador
        checkBoxPage = new CheckBoxPage(driver); // Inicializa la página de checkboxes
        checkBoxPage.openCheckBoxPage(); // Abre la página
    }

    /**
     * Marca el primer checkbox.
     */
    @When("I check the first checkbox")
    public void checkFirstCheckbox() {
        checkBoxPage.checkFirstCheckbox();
    }

    /**
     * Verifica que el primer checkbox esté marcado.
     */
    @Then("The first checkbox should be checked")
    public void verifyFirstCheckboxIsChecked() {
        Assert.assertTrue("The first checkbox is not checked!", checkBoxPage.isFirstCheckboxChecked());
    }

    /**
     * Desmarca el segundo checkbox.
     */
    @When("I uncheck the second checkbox")
    public void uncheckSecondCheckbox() {
        checkBoxPage.uncheckSecondCheckbox();
    }

    /**
     * Verifica que el segundo checkbox esté desmarcado.
     */
    @Then("The second checkbox should be unchecked")
    public void verifySecondCheckboxIsUnchecked() {
        Assert.assertTrue("The second checkbox is still checked!", checkBoxPage.isSecondCheckboxUnchecked());
    }

    /**
     * Configura el WebDriver para ejecutar pruebas en Chrome con opciones avanzadas.
     */
    private void setupWebDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--no-sandbox", 
                             "--disable-dev-shm-usage", "--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Espera implícita para la carga de elementos
    }
}
