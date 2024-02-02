Feature: Cwiczenie majace na celu pokazanie dzialania
  listy w pliku feature

  Scenario: Rejestracja z poprawnym adresem email i haslem
    And Wprowadzamy zadania do wykonania
    |name     |value            |status|
    |zadanie 1|wyprowadz psa    |Done  |
    |zadanie 2|umyj okna        |To Do |
    |zadanie 3|wynies smieci    |To Do |
    |zadanie 4|zaplacic rachunki|Done  |

  Scenario: Wydrukowanie na ekranie zadan za pomoca listy
    And Drukowanie na ekranie zadan za pomoca listy
      |wyprowadz psa|
      |umyj okna|
      |wynies smieci|
      |zaplacic rachunki|

  Scenario: Wydrukowanie na ekranie zadan za pomoca mapy
    And Drukowanie na ekranie zadan za pomoca mapy
      |zadanie 1|wyprowadz psa|
      |zadanie 2|umyj okna|
      |zadanie 3|wynies smieci|
      |zadanie 4|zaplacic rachunki|
    And Drukowanie na ekranie zadan za pomoca jawnego podawania mapy
      |zadanie 1|wyprowadz psa|
      |zadanie 2|umyj okna|
      |zadanie 3|wynies smieci|
      |zadanie 4|zaplacic rachunki|
