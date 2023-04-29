package junit_Task;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Task12_Calculator extends TestBase {
    int sayi1;
    int sayi2;
    int son;

    @Test
    public void calculator() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        WebElement screen = driver.findElement(By.xpath("//div[@class='screen']"));
        islemNum();
       //Esittir  tıklıyoruz.
        WebElement esittir = driver.findElement(By.xpath("//span[@class='btn btn-outline-warning']"));
       esittir.click();
        //6 saniye bekeleyerek sonuc textinişn cıkmasını bekliyoruz.
        bekle(6);
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='screen']"));
        String result = sonuc.getText();
        int result1 = Integer.parseInt(result);
        String result2 = String.valueOf(result1);
        String islemsonuc = String.valueOf(son);
        Assert.assertEquals(result2,islemsonuc);
        System.out.println(islemsonuc   + "-----------++++++++++------" + result);

    }


    public void islemNum() {
        //sayıların locaterını bir liste aktararak esitledik.Math.rondom sayısıyla esitse tıkladık.
        List<WebElement> num = driver.findElements(By.xpath("//span[@class='btn btn-outline-primary']"));
        Random rand = new Random();
        String num1 = String.valueOf(rand.nextInt(90) + 10);
        String num2 = String.valueOf(rand.nextInt(90) + 10);
        //işlem secimlerinde işlemleri yapabilmek için bunları inte cevirdim.
        sayi1 = Integer.parseInt(num1);
        sayi2 = Integer.parseInt(num2);
        //gelen cift sayıyı tek tek split methodu ile bolerek alıp arrayın içine aldık
        String[] sayi = num1.split("");
        String[] sayiArray = num2.split("");


        //içiçe foreach olsuturup ilk foreach dongusunde arraydeki sayıları tek tek  alıp ikinci for dongusunde de listten gelen sayılar if ile birlikte birbirine eşitlik
        // sağlıyorsa o sayıya tıkla komutunu verdik.

        for (String s : sayi) {

            System.out.println("split sayı kac " + s);
            for (WebElement w : num) {
                System.out.println("w kac : " + w.getText());
                if (s.equals(w.getText())) {
                    w.click();
                }
            }
        }
        //işlem secimi methoduyla işlem secimini yaptırıyoruz
        islemSecimi();
        //2.inci foreach
        for (String s : sayiArray) {


            System.out.println("split sayı kac " + s);
            for (WebElement w : num) {
                System.out.println("w kac : " + w.getText());
                if (s.equals(w.getText())) {
                    w.click();
                }
            }
        }

    }

    public void islemSecimi() {
        // Math.random methoduyla 1 den 4 e kadar işlem sectiriyoruz
        String islem = String.valueOf((int) (Math.random() * 4) + 1);

        switch (islem) {
            case "1":
                driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success'][1]")).click();
                System.out.println("sonuc : " + (son = sayi1 + sayi2));
                break;
            case "2":
                driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success'][2]")).click();
                System.out.println("sonuc : " + (son = sayi1 - sayi2));
                break;
            case "3":
                driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success'][3]")).click();
                System.out.println("sonuc : " + (son = sayi1 / sayi2));
                break;
            case "4":
                driver.findElement(By.xpath("//span[@class='operator btn btn-outline-success'][4]")).click();
                System.out.println("sonuc : " + (son = sayi1 * sayi2));
                break;
        }
    }
}
