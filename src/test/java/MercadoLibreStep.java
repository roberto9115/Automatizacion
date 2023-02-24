import CommonMethods.CommonMethods;
import HomePage.HomePage;
import LoginPage.LoginMercadoLibre;
import ModaMercadoLibre.MercadoLibreModa;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class MercadoLibreStep extends CommonMethods {


    @Given("Cargar Pagina Mercado Libre {string}")
    public void cargarPaginaMercadoLibre(String navegador) throws MalformedURLException {
        System.out.println("NAVEGADOR=" + navegador);
        startBrowser(navegador,"https://www.mercadolibre.com.mx/");
    }

    @And("Ingreso User {string} y Password {string}")
    public void ingresoUserYPassword(String user, String pass) {
        System.out.println("USUARIO= " + user + " PASS= "+pass);
        LoginMercadoLibre login = PageFactory.initElements(CommonMethods.driver, LoginMercadoLibre.class);
        login.userPassword(user, pass);
        login.enterLogin();
    }

    @When("Ingresar a Menu Ofertas")
    public void ingresarAMenuOfertas() {
        HomePage homePage = PageFactory.initElements(CommonMethods.driver, HomePage.class);
        homePage.menuOfertas();
    }

    @And("Regresar a Pagina Inicio")
    public void regresarAPaginaInicio() {
        CommonMethods.driver.navigate().back();
    }

    @When("Ingresar a Menu Historial")
    public void ingresarAMenuHistorial() {
        HomePage homePage = PageFactory.initElements(CommonMethods.driver, HomePage.class);
        homePage.menuHistorial();
    }

    @When("Ingresar a Menu Moda")
    public void ingresarAMenuModa() {
        MercadoLibreModa homePage = PageFactory.initElements(CommonMethods.driver, MercadoLibreModa.class);
        homePage.menuModa();
    }

    @And("Opcion Mujer")
    public void opcionMujer() throws InterruptedException {
        MercadoLibreModa homePage = PageFactory.initElements(CommonMethods.driver, MercadoLibreModa.class);
        homePage.opcionMujer();
    }

    @Then("Imprimir Texto Marca")
    public void imprimirTextoMarca() {
        MercadoLibreModa homePage = PageFactory.initElements(CommonMethods.driver, MercadoLibreModa.class);
        String text = homePage.getTextMarcas("C:\\Users\\Familia\\Pictures\\escaner", "test");
        System.out.println("El test es ==== "+text);
        Assert.assertEquals("MARCAS ORIGINALES E ICÓNICAS", text);

    }
//    @After
//    public void closeDriver() throws InterruptedException {
//        Thread.sleep(3000);
//        CommonMethods.driver.close();
//    }

}
