package day11_Ifrma_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends TestBase {


    @Test
    public void test() {

   // https://the-internet.herokuapp.com/windows adresine gidin.
    driver.get(" https://the-internet.herokuapp.com/windows");
    //İlk sayfanın ID'sini(Window Handle değerini) alın.
        String homeHandle = driver.getWindowHandle();
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement titleHome = driver.findElement(By.tagName("h3"));
        String actualText=titleHome.getText();
        String expectedTitle="Opening a new window";
        Assert.assertEquals(expectedTitle,actualText);
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String titleThe= driver.getTitle();
        String expectedThe="The Internet";
        Assert.assertEquals(expectedThe,titleThe);
//    "Click Here" butonuna tıklayın.
        driver.findElement(By.linkText("Click Here")).click();



//    Açılan pencereye geçin.
                /*
Eğer bir button'a tıkladığımızda bizim kontrolümüz dışında yeni bir pencere açılıyorsa
o pencere içindeki webwlwmwntleri handle edebilmem için swichto() methodu ile geçiş yapmma gerekir.
Fakat controlumuz dışında açıldığı için handle değerini bilmediğimiz için tüm açılan pencereleri
getWindowHandles() methodunu kullanarak bir set'e assign ederiz ya da ArrayList'e assign ederiz.
 */
//        Set<String> tumPencereler= driver.getWindowHandles();
//        for (String s : tumPencereler) {
//            if(!s.equals(homeHandle)){
//                driver.switchTo().window(s);
//            }
//
//        }
        List<String> tumHandle = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tumHandle.get(1));
        String newWindow = driver.getWindowHandle();
//    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.getTitle());
//    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(homeHandle);
//    2. pencereye tekrar geçin.
        driver.switchTo().window(newWindow);
//    1. pencereye tekrar dönün.
        driver.switchTo().window(homeHandle);

    }
}
