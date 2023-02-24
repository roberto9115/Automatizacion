package CommonMethods;

import net.serenitybdd.core.webdriver.RemoteDriver;
import org.apache.commons.io.FileUtils;
import org.apache.xalan.templates.ElemElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonMethods {
    public static WebDriver driver;

    public static WebDriverWait webDriverWait;
    static int time = 30000;



    public void Seleccionaaplicacion(){
        String mainHandle=driver.getWindowHandle();
        System.out.println("Main Handle --> "+ mainHandle);
        Set<String> handles= driver.getWindowHandles();
        for(String actual: handles){
            System.out.println("Handle ID --> "+ actual);
            if(!actual.equalsIgnoreCase(mainHandle)){
                System.out.println("changing tab");
                driver.switchTo().window(actual);
            }

        }
    }

    public  WebDriver startBrowser(final String typeBrowser, final String Url) throws MalformedURLException {
        URL remoteUrl = new URL("http://alm-seleniumgrid2.systems.uk.hsbc:9020/wd/hub");

        try {
            if (typeBrowser.equals("ChromeL")) {
                ChromeOptions optNav = new ChromeOptions();
                optNav.addArguments("--incognito");
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
                CommonMethods.driver = new ChromeDriver(optNav);
                CommonMethods.driver.manage().window().maximize();
            } else if (typeBrowser.equals("FirefoxL")) {
                FirefoxOptions optFirefox = new FirefoxOptions();
                System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
                CommonMethods.driver = new FirefoxDriver(optFirefox);

            } else if (typeBrowser.equals("SeleniumG")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                CommonMethods.driver = new RemoteWebDriver(remoteUrl, chromeOptions);
                CommonMethods.driver.manage().deleteAllCookies();
                CommonMethods.driver.get(Url);
                CommonMethods.driver.manage().window().maximize();
                CommonMethods.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


            }
            CommonMethods.driver.manage().deleteAllCookies();
            CommonMethods.driver.get(Url);

            CommonMethods.driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CommonMethods.driver;
    }

    public void sendKeysElement(final WebElement element, final String text) {
        CommonMethods.webDriverWait = new WebDriverWait(CommonMethods.driver, CommonMethods.time);
        CommonMethods.webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(final WebElement element) {
        CommonMethods.webDriverWait = new WebDriverWait(CommonMethods.driver, CommonMethods.time);
//        CommonMethods.webDriverWait.until(ExpectedConditions.visibilityOf(element));
        CommonMethods.webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        element.click();

    }

    public void clickElementAction(final WebElement element) {
        CommonMethods.webDriverWait = new WebDriverWait(CommonMethods.driver, CommonMethods.time);
        CommonMethods.webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
    }
    public void functionMouseOver(final WebElement elementUno, final WebElement elementDos){
        Actions actions = new Actions(CommonMethods.driver);
        actions.moveToElement(elementUno);
        actions.moveToElement(elementDos);
        actions.click().build().perform();
    }

    public void selectElement(final WebElement element, final String opcion){
        Select select = new Select(element);
        select.selectByValue(opcion);
    }



    /**
     * Ingresar a un Frame
     * @param element
     */
    public void switchFrame(final WebElement element){
        driver.switchTo().frame(element);
    }

    /**
     * Regresar al Frame principal
     */
    public void defaultContentFrame(){
        driver.switchTo().defaultContent();
    }

    public String getTextElement(final WebElement element){
        CommonMethods.webDriverWait = new WebDriverWait(CommonMethods.driver, CommonMethods.time);
        CommonMethods.webDriverWait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }


    public void elementScroll(final WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void screenShoot(final String ruta, final String name) throws IOException {
        File screenShoot = ((TakesScreenshot)CommonMethods.driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShoot, new File(ruta + name + ".jpg"));
    }

}
