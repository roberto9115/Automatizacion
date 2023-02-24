package HomePage;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonMethods {
    @FindBy(linkText = "Ofertas")
    WebElement ofertas;

    @FindBy(linkText = "Historial")
    WebElement historial;

    public void menuOfertas(){
        clickElement(ofertas);
    }

    public void menuHistorial(){
        clickElement(historial);
    }
}
