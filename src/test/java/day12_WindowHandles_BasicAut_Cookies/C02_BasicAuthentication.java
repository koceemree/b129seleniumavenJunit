package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void test() {
        /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth

    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */
        //Authentication Url: "https://admin:admin@the-internet.herokuapp.com/basic_auth"
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement paragrahp = driver.findElement(By.xpath( "//p"));
        Assert.assertTrue(paragrahp.getText().contains("Congratulations"));
    }
}
