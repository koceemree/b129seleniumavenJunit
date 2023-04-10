package day13_ActionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions01 extends TestBase {
    @Test
    public void test() {

//    https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get(" https://the-internet.herokuapp.com/context_menu");

//    Kutuya sağ tıklayın
        WebElement box = driver.findElement(By.id("hot-spot"));
        //Webelemente sağ click yapabilmek için Actions classında obje olusturmalıyız
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
//    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String actualText = driver.switchTo().alert().getText();
        String expectedTitle = "You selected a context menu";
        Assert.assertEquals(expectedTitle,actualText);
//    Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();

    }
}
