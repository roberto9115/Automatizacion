package HsbcMXPage.CambiaNomina;

import CommonMethods.CommonMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DejanosTusDatos extends CommonMethods {
    @FindBy(id = "pp_tools_button_2")
    WebElement dejanosTusDatos;

    @FindBy(xpath = "//button [@class = 'A-BTNP-RW-ALL mw-allow-trigger']")
    WebElement aceptarAlerta;

    @FindBy(xpath = "//button [@class = 'A-BTNSO-RW-ALL mw-cancel-trigger']")
    WebElement cancelarAlerta;

    public void opcionDejanosTusDatos() {
        clickElement(dejanosTusDatos);
    }

    public void aceptarAlerta() {
        clickElement(aceptarAlerta);
    }

    public void cancelarAlerta(){
        clickElement(cancelarAlerta);
    }
}

