package LoginPage;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMercadoLibre extends CommonMethods {

    @FindBy(xpath = "//*[@id='cb1-edit']")
    WebElement usuario;

    @FindBy(xpath = "//*[@id='cb1-edit']")
    WebElement password;

    @FindBy(xpath = "/html/body/header/div/form/button")
    WebElement enter;


    public void userPassword(final String user, final String pass){
        sendKeysElement(usuario, user);
        sendKeysElement(password, pass);
    }

    public void enterLogin(){
        clickElement(enter);
    }


}

