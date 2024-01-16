package pl.pwr.edu.restauracja_app.model.datamodels;

import java.util.List;

public record Stolik(
        String numer, StatusStolika status, List<Zamowienie> zamowienia) {
}