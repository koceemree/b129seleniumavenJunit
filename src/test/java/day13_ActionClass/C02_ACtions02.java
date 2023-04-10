package day13_ActionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_ACtions02 extends TestBase {
    @Test
    public void test() {

//    Amazon anasayfasına gidin
        driver.get("https://www.amazon.com");
//    "Account & List" üzerinde bekleyin (mouse over - hover over)
        WebElement account = driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(account).perform();

//    Açılan menüde "Account" linkine tıklayın
        driver.findElement(By.xpath("//span[text()='Account']")).click();

//    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
        WebElement text = driver.findElement(By.xpath("//h1"));
        String expected = "Your Account";
        Assert.assertTrue(text.getText().contains("Your Account"));

    }
}
