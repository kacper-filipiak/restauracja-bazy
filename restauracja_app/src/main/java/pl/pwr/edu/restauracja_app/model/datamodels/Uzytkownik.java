package pl.pwr.edu.restauracja_app.model.datamodels;

public record Uzytkownik(
        String nazwa,
        String haslo,
        Rola rola,
        Boolean zalogowany) {

}