package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    protected static WebDriver driver;
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
    //Orn: TestBase base=new TestBase();
    //Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws Exception {
        bekle(3);
    //    driver.quit();
    }
    //HARD WAIT METHOD
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm, String secenek){
       Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitcToWindow
    public static void switcToWindow(int sayi){
        List<String> tumHandle = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tumHandle.get(sayi));
    }

    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }

}
