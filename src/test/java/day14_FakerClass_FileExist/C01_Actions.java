package day14_FakerClass_FileExist;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions(){

    //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.cssSelector("i[class='eicon-close']")).click();
    //İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.

        WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
        Actions actions = new Actions(driver);
        actions.keyDown(search, Keys.SHIFT)//arama kutusu üzerinde shift tusuna basılı tutar
                .sendKeys("techpro").sendKeys(Keys.SPACE).keyUp(search,Keys.SHIFT).sendKeys("education" +Keys.ENTER).perform();
        //sayfayı Richmond Collage Enrollment Form linkine kadar scroll yapalım.
        WebElement richomand = driver.findElement(By.xpath("(//div[@class='elementor-post__card'])[9]"));
        actions.scrollToElement(richomand).perform();
        //scrollToElement() methodu ile locate ettiğiniz bir webelemente kadar yani o element görünene kadar scroll
        //yapabilirsiniz

    }
}
