package day12_WindowHandles_BasicAut_Cookies;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test() {

//    1-Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
//    2-tum cookie’leri listeleyin
      //Tüm Cookie'leri Listeleyebilmek için  driver.manage().getCookies() methodunu kullanırız.
        Set<Cookie> cookieSet =driver.manage().getCookies();
        int sayac =1;
        for (Cookie cookie : cookieSet) {
            System.out.println(sayac + ".ci cookie : " + cookie);
            System.out.println ("Name : " + cookie.getName());
            System.out.println ("Value : " + cookie.getValue());
        }
//    3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookiesNum= cookieSet.size();
        Assert.assertTrue(cookiesNum>5);
//    4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValue);
         /*
        for (Cookie each:cookieSet) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",cookieValue);
            }
        }
         */
//    5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        driver.manage().addCookie(new Cookie("en sevdigim cookie","cikolatali"));
//    6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        sayac=1;
        for (Cookie cookie : cookieSet) {
            System.out.println(sayac + "ci cookie" + cookie);
            sayac++;
        }
//    7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
//    8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
    }
}
