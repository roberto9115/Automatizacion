import CommonMethods.CommonMethods;
import HomePage.HomePage;
import LoginPage.LoginMercadoLibre;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class BasicJunit extends CommonMethods {

    @Test
    public void TestUno() throws MalformedURLException {
        startBrowser("ChromeL", "https://www.mercadolibre.com.mx/");

        LoginMercadoLibre login = PageFactory.initElements(CommonMethods.driver, LoginMercadoLibre.class);
        login.userPassword("roberto","telefono");
        login.enterLogin();

        HomePage homePage = PageFactory.initElements(CommonMethods.driver, HomePage.class);
        homePage.menuOfertas();
        CommonMethods.driver.navigate().back();
        homePage.menuHistorial();
    }
}
