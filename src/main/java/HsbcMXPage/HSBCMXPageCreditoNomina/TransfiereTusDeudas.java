package HsbcMXPage.HSBCMXPageCreditoNomina;

import CommonMethods.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransfiereTusDeudas extends CommonMethods {
    @FindBy(id = "pp_tools_button_2")
    WebElement btnTransfiereDudas;

    @FindBy(id = "pp_main_button_2")
    WebElement traeTuNomina;

    public void transfiereTusDudasNomina() throws InterruptedException {
        clickElement(btnTransfiereDudas);
        Thread.sleep(3000);
        clickElement(traeTuNomina);
    }

}
