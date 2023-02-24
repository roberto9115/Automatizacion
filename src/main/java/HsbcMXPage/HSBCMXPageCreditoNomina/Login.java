package HsbcMXPage.HSBCMXPageCreditoNomina;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends CommonMethods {
    @FindBy(id = "username")
    WebElement user;

    @FindBy(id = "forgotUsernamediv")
    WebElement forgotUser;

    public void recuperarUsuario(final String userTxt){
        sendKeysElement(user, userTxt);
    }

    public void olvidasteTuUsuario(){
        clickElement(forgotUser);
    }

}
