package day08_Assertion_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown ");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void test01() {
        //a. Yil,ay,gün dropdown menu'leri locate ediniz
        //b. Select objesi olustur
        //c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        Select select = new Select(yil);
        select.selectByIndex(5);//index 0 dan başlar DropDown menüde 6.yı alır
        //yil.sendKeys("2016");--> Bu şekilde de seçebilirim
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); --> Bu şekilde de seçebilirim
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        Select select1 = new Select(ay);
        //select1.selectByVisibleText("April");
        select1.selectByValue("6");
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
    }

    @Test
    public void test02() {
      //  a. Tüm eyalet isimlerini yazdıralım

        //a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();
        for (WebElement w:stateList) {
            System.out.println(w.getText());
        }
    }

    @Test
    public void test03() {
        //State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        String sonSecilenText = select.getFirstSelectedOption().getText();
        //getFirstSelectedOption() --> son seçilen option'i verir
        System.out.println(sonSecilenText);
        Assert.assertEquals("Select a State",sonSecilenText);
    }


}
