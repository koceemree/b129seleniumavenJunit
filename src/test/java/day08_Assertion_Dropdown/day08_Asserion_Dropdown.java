package day08_Assertion_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class day08_Asserion_Dropdown {
       /*
1)https://amazon.com adresine gidin
2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
*/
   static WebDriver driver;
    @BeforeClass
    public static  void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void amazonTitle() {

        Assert.assertTrue("Amazon içeriği yok",driver.getTitle().contains("Amazon"));

    }

    @Test
    public void amazonImage() {
        WebElement img = driver.findElement(By.id("nav-logo-sprites"));
        System.out.println(img.isDisplayed());
    }

    @Test
    public void amazonSearchBox() {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(searchBox.isEnabled());
    }

    @Test
    public void title() {
    Assert.assertFalse(driver.getTitle().contains("amazon"));
    }
}
