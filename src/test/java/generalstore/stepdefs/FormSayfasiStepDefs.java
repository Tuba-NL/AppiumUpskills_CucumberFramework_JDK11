package generalstore.stepdefs;

import generalstore.pages.FormSayfasi;
import generalstore.utils.ReusableMethods;
import io.appium.java_client.AppiumBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static generalstore.utils.Driver.driver;

public class FormSayfasiStepDefs {
    FormSayfasi formSayfasi = new FormSayfasi();
    @When("Ulke menusunden {string} secilir")
    public void ulkeMenusundenSecilir(String ulke ) {
        formSayfasi.ulkeMenusu.click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ulke+"\"))"));
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\""+ulke+"\"]")).click();
    }

    @And("Isim kutusuna {string} girilir")
    public void isimKutusunaGirilir(String isim) {
        formSayfasi.isimAlani.sendKeys(isim);
    }

    @And("Cinsiyet seceneklerinden {string} secilir")
    public void cinsiyetSeceneklerindenSecilir(String cinsiyet) {
        if (cinsiyet.equalsIgnoreCase("female")){
            formSayfasi.cinsiyetFemale.click();
        }else {
            formSayfasi.cinsiyetMale.click();
        }
    }

    @And("Lets Shop butonuna tiklanir")
    public void letsShopButonunaTiklanir() {
        formSayfasi.letsShopButonu.click();
    }

    @Then("Sayfa basliginin {string} oldugu dogrulanir")
    public void sayfaBasligininOlduguDogrulanir(String baslik) {
        ReusableMethods.bekle(1);
        Assert.assertEquals(formSayfasi.sayfaBasligi.getText(), baslik);
    }

    @And("Isim kutusu bos birakilir")
    public void ısimKutusuBosBirakilir() {
        formSayfasi.isimAlani.sendKeys("");
    }

    @Then("Hata mesajinin {string} oldugu dogrulanir")
    public void hataMesajininOlduguDogrulanir(String mesaj) {
        Assert.assertEquals(formSayfasi.hataMesaji.getAttribute("name"), mesaj);
    }
}
