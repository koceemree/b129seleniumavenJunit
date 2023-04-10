package day14_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_Faker {
    @Test
    public void test() {
        //1. Faker objesi olusturunuz
        Faker faker = new Faker();

        //yada Faker.instance() methodu ile de kullanabiliriz.
        System.out.println("isim " +faker.name().firstName());
        System.out.println("soyisim " +faker.name().lastName());
        System.out.println("ülke " +faker.address().country());
        System.out.println("sehir " + faker.address().city());
        System.out.println("artist "+faker.artist().name());
        System.out.println("meslek " + faker.job().title());
        System.out.println("meslek pozisyonu " + faker.job().position());
        System.out.println("telefon num " + faker.phoneNumber().cellPhone());
        System.out.println("numara " + faker.number().digits(15));
        System.out.println("email " + faker.internet().emailAddress());
    }
}
