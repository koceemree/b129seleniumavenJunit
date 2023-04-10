package day14_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist extends TestBase {

    public void fileExist() {
        //Masaustunde bir dosya olusturalım
        //Bu dosyanın varlığını doğruluyalım
        System.out.println(System.getProperty("use.dir")); //Projemizin içinde bulunduğu yolu verir
        System.out.println(System.getProperty("user.home")); //PC c:users\kullanıcı adı   verir
       // String farkliKisim ="C:\\Users\\asd\\Desktop\\b129.txt";
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\b129.txt";
        String dosyaYolu = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
