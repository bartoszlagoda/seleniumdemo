Feature: User registration
  User registration functionality for
  seleniumdemo.com online store

  Background: The user is on the My Account page
    Given Uzytkownik znajduje sie na stronie glownej sklepu
    When Przejscie do strony MyAccount

  Scenario: Registration with correct email address and password
    And Wprowadzamy poprawne dane do formularza rejestracji
    Then Uzytkownik zostaje przekierowany do strony Moje Konto
    But Nie jest widoczny formularz rejestracji uzytkownika

  Scenario Outline: Registration with incorrect email address and correct password
    And Wprowadzamy email "test1@test1.com" i haslo "<password>"
    Then Wyswietla sie komunikat o niepoprawnym adresie email

    Examples:
    |password|
    |test1@test1.com|
    |test1@test1.comtest1@test1.comtest1@test1.com|
    |test1@test1.comtest1@test1.comtest1@test1.comtest1@test1.com|