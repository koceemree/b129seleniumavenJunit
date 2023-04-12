package day15_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;





public class C04_ExplicitWait extends TestBase {

    @Test
    public void test() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
        //Bir webelementin görünürlüğünü implicitly wait ile bu sayfada çözemedik
        //Hello World! Yazının sitede oldugunu test edin

        //1.Yol
        /*
        WebElement helloWordText = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        //visibilityOfElementLocated() webelementin görünür olmasını bekler
         */
        //2.Yol
        WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        visibleWait(helloWordText1,20);
        Assert.assertTrue(helloWordText1.isDisplayed());
    }
}
