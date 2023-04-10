package day13_ActionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    @Test
    public void test() {
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);
//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        //1.yontem
//        actions.dragAndDrop(drag,drop).perform();
        //2.yontem
//            actions.clickAndHold(drag).moveToElement(drop).release().//serbest bırakır mouse
//        perform();
        //3.yontem
        actions.clickAndHold(drag).moveByOffset(162,27).perform();
    }
}
