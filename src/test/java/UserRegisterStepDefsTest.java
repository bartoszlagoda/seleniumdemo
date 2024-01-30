import io.cucumber.java.en.*;

public class UserRegisterStepDefsTest {

    @Given("Uzytkownik znajduje sie na stronie glownej sklepu")
    public void uzytkownik_znajduje_sie_na_stronie_glownej_sklepu() {
        System.out.println("Przejscie na strone glowna sklepu");
    }

    @When("Przejscie do strony MyAccount")
    public void przejscie_do_strony_my_account() {
        System.out.println("Przejscie do strony MyAccount");
    }


    @And("Wprowadzamy poprawne dane do formularza rejestracji")
    public void wprowadzamyPoprawneDaneDoFormularzaRejestracji() {
        System.out.println("Wprowadzenie poprawnych danych");
    }

    @Then("Uzytkownik zostaje przekierowany do strony Moje Konto")
    public void uzytkownikZostajePrzekierowanyDoStronyMojeKonto() {
        System.out.println("Uzytkownik przekierowany na stronę My Account");
    }

    @But("Nie jest widoczny formularz rejestracji uzytkownika")
    public void nieJestWidocznyFormularzRejestracjiUzytkownika() {
        System.out.println("Nie jest widoczny formularz rejestracji");
    }

    @And("Wprowadzamy niepoprawne dane do formularza rejestracji")
    public void wprowadzamyNiepoprawneDaneDoFormularzaRejestracji() {
        System.out.println("Wprowadzamy niepoprawne dane");
    }

    @Then("Wyswietla sie komunikat o niepoprawnym adresie email")
    public void wyswietlaSieKomunikatONiepoprawnymAdresieEmail() {
        System.out.println("Wyswietla sie komunikat o niepoprawnym adresie email");
    }
}
