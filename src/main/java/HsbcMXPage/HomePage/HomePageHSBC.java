package HsbcMXPage.HomePage;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHSBC extends CommonMethods {

    @FindBy(xpath = "//span[contains(text(),'Cuentas')and @class=\"header-main-navigation-title\"]")
    WebElement cuentaDebito;

    @FindBy(xpath = "//*[contains(text(),'Cuentas y pla')]")
    WebElement cuentasPlanes;

    @FindBy(xpath = "//a[contains(text(),'Cambia tu n')]")
    WebElement cambiaNomina;

    @FindBy(xpath = "//span[contains(text(),'Créditos')]")
    WebElement menuCredito;

    @FindBy(linkText = "Crédito de Nómina HSBC")
    WebElement menuCreditoNomina;



    public void menuCuentasPlanes(){
        functionMouseOver(cuentaDebito, cuentasPlanes);
    }

    public void menuCambiaNomina(){
        clickElement(cuentaDebito);
        clickElement(cambiaNomina);
        //functionMouseOver(cuentaDebito, cambiaNomina);
    }


    public void menuCreditoNomina(){
        clickElement(menuCredito);
        clickElement(menuCreditoNomina);
        //functionMouseOver(cuentaDebito, cambiaNomina);
    }

}
