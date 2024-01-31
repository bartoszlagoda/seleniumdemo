Feature: Rejestracja uzytkownika
  Funkcjonalnosc rejestracji uzytkownika dla
  sklepu internetowego seleniumdemo.com

  Scenario: Rejestracja z poprawnym adresem email i haslem
    Given Uzytkownik znajduje sie na stronie glownej sklepu
    When Przejscie do strony MyAccount
    And Wprowadzamy poprawne dane do formularza rejestracji
    Then Uzytkownik zostaje przekierowany do strony Moje Konto
    But Nie jest widoczny formularz rejestracji uzytkownika

  Scenario: Rejestracja z niepoprawnym adresem email i poprawnym haslem
    Given Uzytkownik znajduje sie na stronie glownej sklepu
    When Przejscie do strony MyAccount
    And Wprowadzamy niepoprawne dane do formularza rejestracji
    Then Wyswietla sie komunikat o niepoprawnym adresie email