package junit_Task;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;

public class Google {
    static  WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Before
    public void setUp() throws Exception {
        driver.get("https://www.google.com");
    }

    @Test
    public void theGoaFather() {
        driver.findElement(By.className("gLFyf")).sendKeys("The God Father" + Keys.ENTER);

    }
    @Test
    public void lordofTheRings() {
        driver.findElement(By.className("gLFyf")).sendKeys("Lord of the Rings" + Keys.ENTER);

    }
    @Test
    public void killBill() {
        driver.findElement(By.className("gLFyf")).sendKeys("Kill Bill" + Keys.ENTER);

    }

    @After
    public void tearDown() throws Exception {
        String [] resulText= driver.findElement(By.xpath("//div[@id='result-stats']")).getText().split(" ");
        String sonuc="";
        for (int i=0; i<resulText.length; i++){
             sonuc = Arrays.toString(resulText);

        }
        System.out.println(sonuc);
      //  System.out.println(Arrays.toString(resulText));
    }

    @AfterClass
    public static void afterClass() throws Exception {
       // driver.quit();
    }
}
