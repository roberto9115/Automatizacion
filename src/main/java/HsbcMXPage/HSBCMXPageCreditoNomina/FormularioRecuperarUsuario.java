package HsbcMXPage.HSBCMXPageCreditoNomina;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormularioRecuperarUsuario extends CommonMethods {
    @FindBy(id = "PT")
    WebElement selectModoIdentificacion;

    @FindBy (id = "acc_no")
    WebElement numeroCuenta;

    @FindBy (id = "deb_no")
    WebElement numeroTarjeta;

    @FindBy (id = "pin_no")
    WebElement numeroNip;

    @FindBy(id = "card_2")
    WebElement numeroCuentaCC;

    @FindBy(id = "security_code")
    WebElement numeroNipCC;
    @FindBy(id = "tel_no")
    WebElement numeroTel;
    @FindBy (id = "ivr_pin_no")
    WebElement pinTel;

    @FindBy(xpath = "//*[@id=\"demoform\"]/div[2]/div/div[2]/div/span/input")
    WebElement btnContinuar;
    public void FormularioIdentificacion(final String opcionIdent){
        selectElement(selectModoIdentificacion, opcionIdent);
    }

    public void opcionTarjetaDebito(final String cuenta, final String tarjeta, final String nip){
        sendKeysElement(numeroCuenta, cuenta);
        sendKeysElement(numeroTarjeta, tarjeta);
        sendKeysElement(numeroNip, nip);
    }

    public void opcionTarjetaCredito(final String numCuenta, final String numNip){
        sendKeysElement(numeroCuentaCC, numCuenta);
        sendKeysElement(numeroNipCC, numNip);
    }
    public void opcionTelefono(String numCuenta, String numNip){
        sendKeysElement(numeroTel, numCuenta);
        sendKeysElement(pinTel, numNip);
    }
    public void botonContinuar(){
        clickElement(btnContinuar);
    }

}
