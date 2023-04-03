package day11_Ifrma_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*

   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/iframe");

       // Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
      WebElement editor =   driver.findElement(By.tagName("h3"));
        Assert.assertTrue(editor.getText().contains("Editor"));
      //  Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();//parent frame ile aynıdır.
       driver.navigate().refresh();//sayfa yenleyerekde frame cıkıp anasayfaya doneriz.
       WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));

       seleniumText.isDisplayed();

    }
}
