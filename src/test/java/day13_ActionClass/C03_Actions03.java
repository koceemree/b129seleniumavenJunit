package day13_ActionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.DriverManager;

public class C03_Actions03 extends TestBase {
    @Test
    public void test() {

//     https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
//     Sayfanın alt tarafına gidin
        Actions actions =new Actions(driver);
      //  actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.END);//sayfanın footer bolumune kadar gider.
//     Sayfanın üst tarafına gidin
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
        actions.sendKeys(Keys.HOME).build().perform();//sayfanın navbar bolumune kadar cıkar
        //build() methodu ile birden fazla action objesini birbirne bağlayabiliriz
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        WebElement searcbox= driver.findElement(By.id("twotabsearchtextbox"));
        searcbox.sendKeys(Keys.SHIFT,"s",Keys.SHIFT,"amsung");
    }
}
