package pl.pwr.edu.restauracja_app.model.datamodels;

import java.sql.Timestamp;
import java.time.LocalDate;

public record Skladnik(
        Float ilosc,
        DefinicjaSkladnika definicja,
        LocalDate dataWaznosci) {
}