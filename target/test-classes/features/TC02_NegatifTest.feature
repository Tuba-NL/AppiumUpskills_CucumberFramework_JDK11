Feature: General Store
  Scenario: TC02 | Negatif Test
    When Ulke menusunden "Argentina" secilir
    And Isim kutusu bos birakilir
    And Cinsiyet seceneklerinden "Male" secilir
    And Lets Shop butonuna tiklanir
    Then Hata mesajinin "Please enter your names" oldugu dogrulanir