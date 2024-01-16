package pl.pwr.edu.restauracja_app.model.datamodels;

public record Skladnik(
        Float ilosc,
        DefinicjaSkladnika definicja,
        Integer identyfikator) {
}