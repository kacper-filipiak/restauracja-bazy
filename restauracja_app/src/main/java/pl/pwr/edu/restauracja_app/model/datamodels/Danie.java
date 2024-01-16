package pl.pwr.edu.restauracja_app.model.datamodels;

import java.util.Map;

public record Danie(String nazwa_dania,
					Float cena,
					Map<DefinicjaSkladnika, Float> skladniki) {
}