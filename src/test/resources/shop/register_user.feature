Feature: Rejestracja uzytkownika
  Funkcjonalnosc rejestracji uzytkownika dla
  sklepu internetowego seleniumdemo.com

  Background: Uzytkownik znajduje sie na stronie My Account
    Given Uzytkownik znajduje sie na stronie glownej sklepu
    When Przejscie do strony MyAccount

  Scenario: Rejestracja z poprawnym adresem email i haslem
    And Wprowadzamy poprawne dane do formularza rejestracji
    Then Uzytkownik zostaje przekierowany do strony Moje Konto
    But Nie jest widoczny formularz rejestracji uzytkownika

  Scenario: Rejestracja z niepoprawnym adresem email i poprawnym haslem
#    And Wprowadzamy niepoprawne dane do formularza rejestracji
    And Wprowadzamy email "test1@test1.com" i haslo "test1@test1.com"
    Then Wyswietla sie komunikat o niepoprawnym adresie email