package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.*;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUpload() throws AWTException {
        /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */
        driver.get("https://the-internet.herokuapp.com/upload");

        /*
        Bir Web sayfasında upload işlemi yapmamız gerekirse;
            1-Öncelikle upload edeceğimiz webelementi locate ederiz
            2-Upload edeceğimiz dosya yolunu bir string'e assingn ederiz
            3-Locate ettiğimiz webelement'e sendkeys() methodu ile dosyayolunu aldığımız string değişkeni göndeririz
         */


        WebElement fileChoose = driver.findElement(By.id("file-upload"));
       // "C:\\Users\\asd\\Desktop\\Yeni Metin Belgesi.txt"
        String dosyaYolu = System.getProperty("user.home") +"\\Desktop\\Yeni Metin Belgesi.txt";
        fileChoose.sendKeys(dosyaYolu);

        driver.findElement(By.id("file-submit")).click();

        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "File Uploaded!";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(actualText.contains(expectedText));
       //Buna bak oğren önemli sayılır
           Robot robot=new Robot();




    }
}
