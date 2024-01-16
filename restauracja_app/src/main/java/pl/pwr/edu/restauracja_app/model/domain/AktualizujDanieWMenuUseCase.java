package pl.pwr.edu.restauracja_app.model.domain;

import pl.pwr.edu.restauracja_app.model.base.BaseUseCase;
import pl.pwr.edu.restauracja_app.model.datamodels.Danie;

public class AktualizujDanieWMenuUseCase implements BaseUseCase<Boolean, AktualizujDanieWMenuUseCase.Params> {

    /**
     * @param params
     */
    public Boolean execute(Params params) {
        // TODO - implement AktualizujDanieWMenuUseCase.execute
        throw new UnsupportedOperationException();
    }


    public record Params(Danie danie, String poprzedniaNazwaDania) {
    }

}