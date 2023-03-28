package day07_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_BeforeAfter {
    /*
        @BeforeClass ve AfterClass methodları sadece static methodlar ile calisir
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("Tüm testlerden once bir kez calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Tüm testlerden sonra bir kez calisir");
    }

    @Before
    public void before(){
        System.out.println("Her test methodundan once birkez calısır");
    }
    @After
    public void after(){
        System.out.println("Her test methodundan sonra birkez calısır");
    }
    @Test
    public void test01(){
        System.out.println("test01");
    }
    @Test
    public void test02(){
        System.out.println("test02");
    }
}
