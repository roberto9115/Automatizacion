import CommonMethods.CommonMethods;
import HsbcMXPage.CambiaNomina.DejanosTusDatos;
import HsbcMXPage.HSBCMXPageCreditoNomina.FormularioRecuperarUsuario;
import HsbcMXPage.HSBCMXPageCreditoNomina.Login;
import HsbcMXPage.HSBCMXPageCreditoNomina.TransfiereTusDeudas;
import HsbcMXPage.HomePage.HomePageHSBC;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.util.ArrayList;

public class HSBCMXSteps extends CommonMethods {

    @Given("Cargar Pagina HSBC MX {string}")
    public void cargarPaginaMercadoLibre(final String browser) throws MalformedURLException {
        startBrowser(browser, "https://www.hsbc.com.mx/digital/pago-de-impuestos/");
    }
    /*
     *Home Page inicio
     */
    @When("Ingreso a Opcion Cuentas y Planes")
    public void ingresoAOpcionCuentasYPlanes() {
        HomePageHSBC homePageHSBC = PageFactory.initElements(CommonMethods.driver, HomePageHSBC.class);
        homePageHSBC.menuCuentasPlanes();
    }
    /*
     *Home Page Fin
     */
    @And("Valido Alerta Llevar a Sitio Externo {string}")
    public void validoAlertaLlevarASitioExterno(final String opcionAlerta) throws InterruptedException {
        DejanosTusDatos dejanosTusDatos = PageFactory.initElements(CommonMethods.driver, DejanosTusDatos.class);
        if (opcionAlerta.equals("aceptar")){
            dejanosTusDatos.aceptarAlerta();
            ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Thread.sleep(2000);
//            driver.switchTo().window(tabs2.get(0));
        } else if (opcionAlerta.equals("cancelar")) {
            dejanosTusDatos.cancelarAlerta();
        }
    }


    @When("Ingreso a Menu Cambia Nomina")
    public void ingresoAMenuCambiaNomina() {
        HomePageHSBC homePageHSBC = PageFactory.initElements(CommonMethods.driver, HomePageHSBC.class);
        homePageHSBC.menuCambiaNomina();
    }

    @And("Doy Click en Dejanos tus Datos")
    public void doyClickEnDejanosTusDatos() {
        DejanosTusDatos dejanosTusDatos = PageFactory.initElements(CommonMethods.driver, DejanosTusDatos.class);
        dejanosTusDatos.opcionDejanosTusDatos();
    }

    @When("Ingresar a Menu Credito Nomina")
    public void ingresarAMenuCreditoNomina() {
        HomePageHSBC homePageHSBC = PageFactory.initElements(CommonMethods.driver, HomePageHSBC.class);
        homePageHSBC.menuCreditoNomina();
    }
    @And("Dar Click en Transfiere tus Deudas")
    public void darClickEnTransfiereTusDeudas() throws InterruptedException {
        TransfiereTusDeudas transfiereTusDeudas = PageFactory.initElements(CommonMethods.driver, TransfiereTusDeudas.class);
        transfiereTusDeudas.transfiereTusDudasNomina();
    }

    @And("Selecciono Opcion Recuperar Usuario {string}")
    public void seleccionoOpcionRecuperarUsuario(final String opcion) {
        FormularioRecuperarUsuario formulario = PageFactory.initElements(CommonMethods.driver, FormularioRecuperarUsuario.class);
        formulario.FormularioIdentificacion(opcion);
    }

    @And("Lleno Campos Tarjeta de Debito {string} {string} {string}")
    public void llenoCamposTarjetaDeDebitofinal( String cuenta, final String tarjeta, final String nip ) {
        FormularioRecuperarUsuario formulario = PageFactory.initElements(CommonMethods.driver, FormularioRecuperarUsuario.class);
        formulario.opcionTarjetaDebito(cuenta, tarjeta, nip);
    }


    @And("Dar Click en Olvide mi Usuario {string}")
    public void darClickEnOlvideMiUsuario(final String user) throws InterruptedException {
        Login login = PageFactory.initElements(CommonMethods.driver, Login.class);
        Thread.sleep(10000);
        login.recuperarUsuario(user);
        login.olvidasteTuUsuario();

    }
    @And("Lleno Campos Tarjeta Credito {string} {string}")
    public void llenoCamposTarjetaCredito(String cuenta, String nip) {
        FormularioRecuperarUsuario formulario = PageFactory.initElements(CommonMethods.driver, FormularioRecuperarUsuario.class);
        formulario.opcionTarjetaCredito(cuenta, nip);
    }
    @And("Lleno Campos Acceso Telefonico {string} {string}")
    public void llenoCamposAccesoTelefonico(String telefono, String nip) {
        FormularioRecuperarUsuario formulario = PageFactory.initElements(CommonMethods.driver, FormularioRecuperarUsuario.class);
        formulario.opcionTelefono(telefono, nip);
    }


}
