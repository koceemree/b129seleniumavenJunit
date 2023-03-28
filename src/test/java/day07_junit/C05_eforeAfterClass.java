package day07_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_eforeAfterClass {
    WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Tüm testlerden once bir kez calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon testi başlatıldı");
    }

    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-orgins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void after(){
        driver.close();
    }
    @Test
    public void test01(){
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);
    }
    @Test
    public void test02(){
        System.out.println("test02");
    }
}
