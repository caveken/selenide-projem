package stepdefinitions;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;

public class TestCenterStepDefinitions {
    TestCenterPage testCenterPage = new TestCenterPage();

    @Given("kullanici adini gir")
    public void kullanici_adini_gir() {
        testCenterPage.kullaniciAdi.setValue("techproed");
    }

    @Given("kullanici sifresini gir")
    public void kullanici_sifresini_gir() {
        testCenterPage.kullaniciSifresi.setValue("SuperSecretPassword");
    }

    @Given("submit butonuna tikla")
    public void submit_butonuna_tikla() {
        testCenterPage.submitButton.click();
    }

    @Given("giris yapildigini test et")
    public void giris_yapildigini_test_et() {
//        Assert.assertTrue(testCenterPage.girisMesaji.isDisplayed());//JUNIT
//        testCenterPage.girisMesaji.shouldBe(Condition.visible);
        testCenterPage.girisMesaji.shouldBe(visible);// SELENIDE ASSERTION
        // FAIL EDERSE EKRAN GORUNTUSU OTOMATIK OLARAK ALINIR VE build DOSYASINA KAYDEDILIR
    }

    @Given("{string} secili degilse sec")
    public void secili_degilse_sec(String text) {
//        eger text = Checkbox 1 VE checkbox 1 secili degise, checkbox1 e tikla
        if (text.equals("Checkbox 1") && !testCenterPage.checkbox1.isSelected()) {
            testCenterPage.checkbox1.click();
//            Assert.assertTrue(testCenterPage.checkbox1.isSelected());//junit
//            testCenterPage.checkbox1.shouldBe(Condition.checked);//selenide uzun version
            testCenterPage.checkbox1.shouldBe(checked);//selenide kisa version
        }
        if (text.equals("Checkbox 2") && !testCenterPage.checkbox2.isSelected()) {
            testCenterPage.checkbox2.shouldNotBe(checked);
            testCenterPage.checkbox2.click();
            testCenterPage.checkbox2.shouldBe(checked);
        }
        if (text.equals("Red") && !testCenterPage.red.isSelected()) {
            testCenterPage.red.shouldNotBe(checked);//secili olmadigini test et
            testCenterPage.red.click();//sec
            testCenterPage.red.shouldBe(checked);//secili oldugunu test et
        }
        if (text.equals("Football") && !testCenterPage.football.isSelected()) {
            testCenterPage.football.shouldNotBe(checked);//secili olmadigini test et
            testCenterPage.football.click();//sec
            testCenterPage.football.shouldBe(checked);//secili oldugunu test et
        }

        }
    }
