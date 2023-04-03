package day09_DropDown;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {

    @Test
    public void test() {
        //Techproeducation adresine gidelim
        driver.get("https://www.techproeducation.com");
        //başlığın "Botcamp" içerirdiğini test edelim
        String actual = driver.getTitle();
        String expedted = "Botcamp";
        Assert.assertTrue(actual.contains(expedted));
    }
}
