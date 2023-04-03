package day09_DropDown;

import utilities.TestBase;

public class C01_DropDown extends TestBase {


       /*
    -DropDown Nedir : Altbaşlıkların olduğu açılır menü listesi
    -DropDown nasıl automate edilir(Handle):
           a-DropDown menuyu ilk olarak locate ederiz
           b-Select objesi oluştururuz
           c-Select objesinin ddm webelementi'nin içeriğine ve seçeneklerine
           erişim sağlaması için SELECT sınıfına arguman olarak locate ettiğimiz webelementi koyarız
           Syntax: Select select = new Select(ddm webelement)
           d-Select class'ı, sadece <select> tag'ı ile oluşturulmuş dropdown menulere uygulanabilir.
           e-select objesi ddm'yü handle edebilmek için 3 method kullanılır
                 -selectByVisibleText() ->Ddm deki elemente görünür metin ile ulaşmak için kullanılır
                 -selectByIndex() -> Index ile ulaşmak için kullanılır(Index 0 dan başlar)
                 -selectByValue() -> Elementin değeri ile ulaşmak için kullanılır(option tag'ındaki değer ile)
           f-getOptions()->Locate ettiğimiz ddm'deki tüm seçenekleri bize döndürür
           g-getFirstSelectedOption()->Ddm'deki en son seçili kalan ilk seçeneği bize döndürür

     */


}
