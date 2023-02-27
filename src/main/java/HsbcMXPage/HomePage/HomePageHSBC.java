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

    @FindBy(xpath = "/html/body/div[1]/div/header/div[3]/div/div[2]/div/div/nav/ul/li[3]/div[1]/span[2]")
    WebElement menuCredito;

    @FindBy(xpath = "/html/body/div[1]/div/header/div[3]/div/div[2]/div/div/nav/ul/li[3]/div[2]/div/div[1]/div/div[1]/div/div/ul/li[1]/a")
    WebElement menuCreditoNomina;



    public void menuCuentasPlanes(){
        functionMouseOver(cuentaDebito, cuentasPlanes);
    }

    public void menuCambiaNomina(){
        clickElement(cuentaDebito);
        clickElement(cambiaNomina);
        //functionMouseOver(cuentaDebito, cambiaNomina);
    }


    public void menuCreditoNomina() throws InterruptedException {
        Thread.sleep(20000);
        clickElement(menuCredito);
        clickElement(menuCreditoNomina);
        //functionMouseOver(cuentaDebito, cambiaNomina);
    }

}
