package junit_Task;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Color extends TestBase {
    @Test
    public void test() {
       // -https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        bekle(5);
        driver.switchTo().frame(0);
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement red = driver.findElement(By.xpath("//div[@id='red']/span"));
        WebElement yesil = driver.findElement(By.xpath("//div[@id='green']/span"));
        WebElement mavi = driver.findElement(By.xpath("//div[@id='blue']/span"));
        Actions actions = new Actions(driver);
//       
        actions.dragAndDropBy(red, 100, 0).perform();
        bekle(5);
       
        actions.dragAndDropBy(yesil, 300, 0).perform();
        actions.dragAndDropBy(yesil, -300, 0).perform();
        bekle(5);
       
        actions.dragAndDropBy(mavi, 300, 0).perform();
        actions.dragAndDropBy(mavi, -300, 0).perform();

        //sarı renk için
        actions.dragAndDropBy(yesil, 300, 0).perform();
    //2.yol
//        actions.moveToElement(red).clickAndHold().moveByOffset(100, 0).release().perform();
//        actions.moveToElement(yesil).clickAndHold().moveByOffset(300, 0).release().perform();
//        actions.moveToElement(yesil).clickAndHold().moveByOffset(-300, 0).release().perform();
//        actions.moveToElement(mavi).clickAndHold().moveByOffset( 300, 0).release().perform();
//        actions.moveToElement(mavi).clickAndHold().moveByOffset(-300, 0).release().perform();
        bekle(5);

       //sarı renk
        actions.moveToElement(yesil).clickAndHold().moveByOffset(300, 0).release().perform();
          //      -Sarı olduğunu test edelim
        WebElement colorBox = driver.findElement(By.id("swatch"));
        String backgroundColor = colorBox.getCssValue("background-color");
        System.out.println(backgroundColor); // rgba(255, 255, 1, 1)
        if (backgroundColor.equals("rgba(255, 255, 1, 1)")) {
            System.out.println("Renk sarıdır.");
        } else {
            System.out.println("Renk sarı değildir.");
        }


    }
}
