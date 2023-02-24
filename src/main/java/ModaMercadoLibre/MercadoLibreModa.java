package ModaMercadoLibre;

import CommonMethods.CommonMethods;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class MercadoLibreModa extends CommonMethods {
    @FindBy(linkText = "Moda")
    WebElement moda;
    @FindBy(xpath = "/html/body/main/div/div[1]/article/div/div/div/div/div/div[10]/div/a")
    WebElement mujer;
    @FindBy(css = "#root-app > div > div:nth-child(6) > div > div > h2")
    WebElement marca;
    public void menuModa(){
        clickElement(moda);
    }

    public void opcionMujer() throws InterruptedException {
//        clickElement(driver.findElement(By.cssSelector(mujer)));
//        Thread.sleep(2000);
        clickElement(mujer);
//        Assert.assertTrue(ExpectedConditions.titleContains("MUJER")
//                .apply(CommonMethods.driver).booleanValue());

    }



    /**
     * invocar un frame
     * driver.switchTo().frame("id of the element");
     * https://www.guru99.com/handling-iframes-selenium.html
     */

    public String getTextMarcas(final String ruta, final String nombre){
        elementScroll(marca);
        String text = getTextElement(marca);
        try {
            screenShoot(ruta, nombre);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return  text;
    }

}
