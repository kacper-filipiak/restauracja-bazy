package pl.pwr.edu.restauracja_app.model.utils;

import pl.pwr.edu.restauracja_app.model.datamodels.Rola;
import pl.pwr.edu.restauracja_app.model.datamodels.Uzytkownik;
import pl.pwr.edu.restauracja_app.model.domain.ZalogujUzytkownikaUseCase;

public class UserHelper {

	private Uzytkownik uzytkownik;
	private ZalogujUzytkownikaUseCase zalogujUzytkownikaUseCase;

	/**
	 * 
	 * @param nazwa
	 * @param haslo
	 */
	public Boolean zaloguj(String nazwa, String haslo) {
		// TODO - implement UserHelper.zaloguj
		throw new UnsupportedOperationException();
	}

	public void wyloguj() {
		// TODO - implement UserHelper.wyloguj
		throw new UnsupportedOperationException();
	}

	public Rola zalogowanyJako() {
		// TODO - implement UserHelper.zalogowanyJako
		throw new UnsupportedOperationException();
	}

	public Uzytkownik getUzytkownik() {
		return uzytkownik;
	}
}