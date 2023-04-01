package junit_Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Ebay {
    /*
    *** Aşağıdaki Task'i Junit framework'u ile yapınız
            - ebay sayfasına gidiniz
            - electronics bölümüne tıklayınız
            - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
            - Her sayfanın sayfa başlığını yazdıralım
            - sayfayı kapatalım
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
    public void ebay() throws InterruptedException {
      //  - ebay sayfasına gidiniz
        driver.get("https://www.ebay.com/");

        String homeTitle=driver.getTitle();
        System.out.println("homeTitle = " + homeTitle);

        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("//li[@data-currenttabindex='0']")).click();
        String elecPage= driver.getTitle();
        System.out.println("elecPage = " + elecPage);
//- Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        List<WebElement> img = driver.findElements(By.cssSelector("img[width='225'][height='225']"));

        for (int i = 0; i<img.size(); i++) {
            WebElement image = driver.findElements(By.cssSelector("img[width='225'][height='225']")).get(i);
            image.click();
            Duration timeout = Duration.ofSeconds(10);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.stalenessOf(image));
            System.out.println("driver.getTitle() = " + driver.getTitle());
            driver.navigate().back();


        }

    }
}
