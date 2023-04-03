package day11_Ifrma_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle extends TestBase {
    /*
    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de https://www.youtube.com sayfasını açınız:
    //Window 3'te https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:
     */

    @Test
    public void test() {
        driver.get("https://www.techproeducation.com");

        String tecproHandle = driver.getWindowHandle();
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String title = driver.getTitle();
        String expected = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expected,title);
        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);//--> yeni bir pencereye driveri tasır
        //-->windowType.TAB yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeHandle=driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(" https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        List<String> tumWindowHandle = new ArrayList<>(driver.getWindowHandles());
        //butun actıgım pencerelerin handle değerlerini bir ArrayList'e atadık.

     //   driver.switchTo().window(tecproHandle);
        driver.switchTo().window(tumWindowHandle.get(0));
       // driver.switchTo().window(youtubeHandle);
        driver.switchTo().window(tumWindowHandle.get(1));
     //   driver.switchTo().window(linkedinHandle);
        driver.switchTo().window(tumWindowHandle.get(2));
    }
}
