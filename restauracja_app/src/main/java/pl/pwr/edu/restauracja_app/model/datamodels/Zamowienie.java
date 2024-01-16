package pl.pwr.edu.restauracja_app.model.datamodels;

import java.sql.Timestamp;
import java.util.List;

public record Zamowienie(
        Timestamp data,
        List<Danie> dania,
        StatusZamowienia status) {

}