package pl.pwr.edu.restauracja_app.model.datamodels;

public record DefinicjaSkladnika(String nazwa,
                                 String jednostka) {
    String getNazwa() {
        return nazwa;
    }
    String getJednostka() {
        return jednostka;
    }
}