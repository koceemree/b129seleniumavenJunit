package junit_Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Heroku_TestCase {
/*
        *** Aşağıdaki Task'i Junit framework'u ile yapınız
                - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
                - Add Element butonuna 100 defa basınız
                - 100 defa basıldığını test ediniz
                - 90 defa delete butonuna basınız
                - 90 defa basıldığını doğrulayınız
                - Sayfayı kapatınız
 */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

//    @After
//    public void tearDown() throws Exception {
//        driver.close();
//    }


    @Test
    public void herokuTest() {
        //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // - Add Element butonuna 100 defa basınız
        for (int i = 1; i<101; i++){
            WebElement btn = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
            btn.click();

        }
        List<WebElement> btnList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("btnList.size() = " + btnList.size());
        if(btnList.size()==100){
            System.out.println("AddElement butonuna tıklanma sayısı = " + btnList.size());
        }else {
            System.out.println("AddElement butonuna tıklanma sayısı = " + btnList.size());
        }
        // - 90 defa delete butonuna basınız
        int count = 1;
        for (int i = 1; i<90; i++){
            WebElement deleteClick = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
            deleteClick.click();
            count++;
        }
        List<WebElement> deleteList = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        System.out.println("deleteList.size() = " + deleteList.size());
        if(deleteList.size()==10){
            System.out.println("AddElement butonuna tıklanma sayısı = " + count);
        }else {
            System.out.println("AddElement butonuna tıklanma sayısı = " + count);
        }
    }
}
