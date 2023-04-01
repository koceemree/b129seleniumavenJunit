package SeleniumPractice.day02_practtice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.bouncycastle.crypto.tls.CipherType.stream;

public class C02 extends C01 {
    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin
    // sayfayı kapatın
    @Test
    public void googleTitle() {
        driver.get("https://www.google.com");
        String googleTitile = driver.getTitle();
        String expectedTitle = "Google";
        Assert.assertEquals(googleTitile, expectedTitle);
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);
        WebElement search = driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("search.getText() = " + search.getText());
        String[] searchText = search.getText().split(" ");
        String sonuc = searchText[1];
        System.out.println(sonuc);
        String check = sonuc.replaceAll("\\D", "");
        int num = Integer.parseInt(check);
        if (num > 100000000) {
            System.out.println("buyuk");
        } else {
            System.out.println("kucuk");
        }

        Stream<String> limit = Arrays.stream(search.toString().split("")).skip(1);


    }
}
