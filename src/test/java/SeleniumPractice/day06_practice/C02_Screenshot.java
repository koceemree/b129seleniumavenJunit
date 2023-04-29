package SeleniumPractice.day06_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class C02_Screenshot extends TestBase {
 //   @Test
//    public void test01() throws IOException, InterruptedException {
//        // https://www.teknosa.com/ adresine gidin
//        driver.get("https://www.teknosa.com/");
//        // arama cubuguna oppo yazip enter'a basınız
//        WebElement search = driver.findElement(By.xpath("//input[@id='search-input']"));
//        search.sendKeys("oppo", Keys.ENTER);
//        // sonuc sayisini yazdiriniz
//        WebElement result = driver.findElement(By.xpath("//div[@class='plp-info']"));
//        System.out.println(result.getText());
//        // ilk urunun fotografını cekin
//        WebElement product = driver.findElement(By.xpath("//a[@class='prd-link gowitPlp-js'])[1]"));
//       File tumsayfa = new File("target/ekrangoruntusu/tumsayfa.Jpeg");
//       File gecici = product.getScreenshotAs(OutputType.FILE);
//       FileUtils.copyFile(gecici,tumsayfa);
//
//      //  driver.findElement(By.xpath("//div[@id='button-1580496494']")).click();
//      //  driver.switchTo().frame("insider-worker");
//        Thread.sleep(5000);
//        // cikan ilk urune tiklayiniz
//          product.click();
//
//
//
//        // iki ArrowDown sayfayı asagiya kaydirin
//        // sepete ekleyiniz
//        // sepetim'e git tilayiniz
//        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
//        // Alisverisi tamamlayiniz
//        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
//    }

    @Test
    public void test02() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo" + Keys.ENTER);


        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println("SONUC YAZİSİ: " + sonucYazisi.getText());



        // ilk urunun fotografını cekin

        LocalDateTime date =LocalDateTime.now();
        DateTimeFormatter dtf =DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);


        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class='prd-link gowitPlp-js'])[1]"));

        File kayit = new File("target/ekranGoruntusu/tumSayfa"+tarih+".Jpeg");

        File gecici = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(gecici,kayit);






        // cikan ilk urune tiklayiniz
        ilkUrun.click();



        // sepete ekleyiniz butonu gorununceye kadar bir PAGE_DOWN sayfayı asagiya kaydirin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();




        // sepete ekleyiniz
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();




        // sepetim'e git tilayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();




        // "Siparis Ozeti" webelementinin text'ini yazdiriniz
        WebElement siparisOzeti = driver.findElement(By.xpath("//div[text()='Sipariş Özeti']"));
        System.out.println("SİPARİS OZETİ TEXT: " + siparisOzeti.getText());



        // Alisverisi tamamlayiniz
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();



        // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
        WebElement teknosayaHosgeldiniz = driver.findElement(By.xpath("//div[text()='Teknosa’ya Hoş Geldiniz']"));
        System.out.println("TEKNOSAYA HOSGELDİNİZ TEXT: " + teknosayaHosgeldiniz.getText());



    }
}
