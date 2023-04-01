package SeleniumPractice.day02_practtice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    // https://www.amazon.com/ adresine gidin
    // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
    // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
    // sayfayi kapatiniz

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void amazonTestInput() {
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String actualTagName = aramaKutusu.getTagName();
        String expectedTagName = "input";
        Assert.assertEquals(actualTagName, expectedTagName);

        String actualName=aramaKutusu.getAttribute("name");
        String expectedName="field-keywords";
        Assert.assertEquals(actualName,expectedName);
    }
}
