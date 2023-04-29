package junit_Task;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.*;

import static org.apache.logging.log4j.core.impl.ThrowableFormatOptions.FILE_NAME;

public class Task11File extends TestBase {
    private static String ortak = System.getProperty("user.home") + "\\Desktop\\data.xlsx";
    //-İki tane test methodu oluşturalım
    @Test
    public void test01() throws IOException {

        //Yeni bir Excel Workbook nesnesi oluşturun
        Workbook workbook = new XSSFWorkbook();

        //Workbook içine yeni bir çalışma sayfası ekleyin
        Sheet sheet = workbook.createSheet("sayf1");

        // Satır olustur
        Row row = sheet.createRow(0);

        //hucreyi olustur ve değer ataması yap
        Cell cell = row.createCell(0);
        cell.setCellValue("email");
        Cell cell1 = row.createCell(1);
        cell1.setCellValue("password");

        Row row1 = sheet.createRow(1);
        Cell cell2 = row1.createCell(0);
        cell2.setCellValue("emre@gmail.com");
        Cell cell3=row1.createCell(1);
        cell3.setCellValue("1236Dfg");

      //  Dosyayı kaydetmek için FileOutputStream kullanın
        FileOutputStream fileOut = new FileOutputStream(ortak);
        workbook.write(fileOut);


        // Bellek yönetimi için kaynakları serbest bırakın
        fileOut.close();
        workbook.close();

        // Dosyanın başarıyla oluşturulduğunu yazdırır.
        System.out.println("Excel dosyası " + ortak + " adresinde başarıyla oluşturuldu.");

    }

    @Test
    public void test02() throws IOException {
    driver.get("https://www.bluerentalcars.com/");
        //Login butonuna tıklarız.
        WebElement loginButton = driver.findElement(By.xpath("(//a[@role='button'])[1]"));
        loginButton.click();
        bekle(2);
        //email input locaterını aldık
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='formBasicEmail']"));
        //password input locaterını aldık
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='formBasicPassword']"));
        //FileInputStream bir dosyadan veri okumak için kullnılır.inputStream değişkenine atanan nesne, belirtilen dosyanın içeriğini okumamızı sağlar.
        FileInputStream inputStream = new FileInputStream(new File(ortak));
        //inputStream'ten verileri okur ve bunları XSSFWorkbook nesnesine yükler
        Workbook workbook = new XSSFWorkbook(inputStream);
        // XSSFWorkbook nesnesinden belirtilen indeksteki sayfa bilgilerini almak için kullanılır.
        // getSheetAt metodu, belgenin belirtilen indeksindeki veriyi alır.
        Sheet sheet = workbook.getSheetAt(0);

        String email = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);


        workbook.close();
        inputStream.close();

    WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
    button.click();

    }
}
