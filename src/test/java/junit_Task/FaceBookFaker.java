package junit_Task;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class FaceBookFaker extends TestBase {

    @Test
    public void faceFaker() {
//        1. "https://facebook.com" Adresine gidin
        driver.get("https://facebook.com");
//        2. “create new account” butonuna basin
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
//        3. “firstName” giris kutusuna bir isim yazin
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        WebElement firstName = driver.findElement(By.xpath("//*[@name='firstname']"));
        String email = faker.internet().emailAddress();
        actions.click(firstName).sendKeys(faker.name()
                        .firstName())
//        4. “surname” giris kutusuna bir soyisim yazin
                .sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
//        5. “email” giris kutusuna bir email yazin
                .sendKeys(Keys.TAB).sendKeys(email)
//        6. “email” onay kutusuna emaili tekrar yazin
                .sendKeys(Keys.TAB).sendKeys(email)
//        7. Bir sifre girin
                .sendKeys(Keys.TAB).sendKeys(faker.internet().password())
//        8. Tarih icin gun secin
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1, 31)))
//        9. Tarih icin ay secin
                .sendKeys(Keys.TAB).sendKeys("May")
//        10. Tarih icin yil secin
                .sendKeys(Keys.TAB).sendKeys(String.valueOf(faker.number().numberBetween(1992, 2008)))
//        11. Cinsiyeti secin
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();//Kaydol butonuna gelmek için tab yaptım
//        12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test
//        edin.
        List<WebElement> genderContainer = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba']/input"));


        for (WebElement option : genderContainer) {
            if (option.isSelected()) {
                System.out.println("Seçili olan cinsiyet: " + option.getAttribute("value"));
                break;
            }
//        13. Sayfayi kapatin
        }
    }
}
