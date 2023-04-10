package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandlesMethod extends TestBase {
    @Test
    public void windowHandles() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",sayfaTexti.getText());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet",actualTitle);
        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //Açılan pencereye geçin.
        /*
            Eğer bir button'a click yaptığımızda bizim kontrolümüz dışında yeni bir pencere açılıyorsa,
         o pencere içindeki webelementleri handle edebilmem için swichtto() methodu ile geçiş yapmam gerekir
         fakat kontrolümüz dışında açıldığı için handle değerini bilmediğimiz için tüm açılan pencereleri
         getWindowHandles() methodunu kullanarak bir SET'e assing ederiz. Yada ArrayList'e assing ederiz
         */
        //switchToWindow(1);
        window(1);
        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window",gercekBaslik);

        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        //switchToWindow(0);
        window(0);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(3);

        //2. pencereye tekrar geçin.
        //switchToWindow(1);
        window(1);
        bekle(3);

        //1. pencereye tekrar dönün.
        //switchToWindow(0);
        window(0);
    }
}
