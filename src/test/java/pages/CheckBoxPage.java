package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage {
    private WebDriver driver; // Instancia del navegador WebDriver

    // Localización de los checkboxes usando XPath
    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    private WebElement firstCheckbox;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    private WebElement secondCheckbox;

    /**
     * Constructor de la página de checkboxes.
     * Inicializa los elementos de la página utilizando PageFactory.
     * @param driver WebDriver utilizado para interactuar con la página.
     */
    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Abre la página de checkboxes en el navegador.
     */
    public void openCheckBoxPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    /**
     * Marca el primer checkbox si no está seleccionado.
     */
    public void checkFirstCheckbox() {
        if (!firstCheckbox.isSelected()) {
            firstCheckbox.click();
        }
    }

    /**
     * Verifica si el primer checkbox está marcado.
     * @return true si el checkbox está seleccionado, false en caso contrario.
     */
    public boolean isFirstCheckboxChecked() {
        return firstCheckbox.isSelected();
    }

    /**
     * Desmarca el segundo checkbox si está seleccionado.
     */
    public void uncheckSecondCheckbox() {
        if (secondCheckbox.isSelected()) {
            secondCheckbox.click();
        }
    }

    /**
     * Verifica si el segundo checkbox está desmarcado.
     * @return true si el checkbox no está seleccionado, false en caso contrario.
     */
    public boolean isSecondCheckboxUnchecked() {
        return !secondCheckbox.isSelected();
    }
}
