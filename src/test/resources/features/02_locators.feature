@locators
  Feature: locators
    Scenario: TC01 locators
      Given kullanici "https://testcenter.techproeducation.com/index.php?page=form-authentication" adresine gider
      And 3 saniye bekler
      And kullanici adini gir
      And 3 saniye bekler
      And kullanici sifresini gir
      And 3 saniye bekler
      And submit butonuna tikla
      And 5 saniye bekler
      And giris yapildigini test et
