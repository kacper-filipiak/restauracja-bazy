package pl.pwr.edu.restauracja_app.presenter;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import pl.pwr.edu.restauracja_app.NavHelper;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.domain.*;
import pl.pwr.edu.restauracja_app.model.utils.UserHelper;

public class AdminPresenter {

    private DodajDanieDoMenuUseCase dodajDanieDoMenuUseCase;
    private UsunDanieZMenuUseCase usunDanieZMenuUseCase;
    private PobierzDanieZMenuUseCase pobierzDanieZMenuUseCase;
    private AktualizujDanieWMenuUseCase aktualizujDanieWMenuUseCase;
    private DodajUzytkownikaUseCase dodajUzytkownikaUseCase;
    private AktualizujUzytkownikaUseCase aktualizujUzytkownikaUseCase;
    private UsunUzytkownikaUseCase usunUzytkownikaUseCase;
    private DodajDefinicjeSkladnikaUseCase dodajDefinicjeSkladnikaUseCase;
    private PobierzDefinicjeSkladnikaUseCase pobierzDefinicjeSkladnikaUseCase;
    private AktualizujDefinicjeSkladnikaUseCase aktualizujDefinicjeSkladnikaUseCase;
    private UsunDefinicjeSkladnikaUseCase usunDefinicjeSkladnikaUseCase;
    private DodajSkladikUseCase dodajSkladnikUseCase;
    private AktualizujSkladikUseCase aktualizujSkladnikUseCase;
    private PobierzSkladnikiUseCase pobierzSkladnikiUSeCase;
    private UsunSkladikUseCase usunSkladnikUseCase;
    private UserHelper userHelper;
    private NavHelper navHelper;


    public void onDodajUzytkownika() {
        // TODO - implement AdminPresenter.onDodajUzytkownika
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzDodajUzytkownika(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzDodajUzytkownika
        throw new UnsupportedOperationException();
    }

    public AdminPresenter(
            NavHelper navHelper,
            DodajDefinicjeSkladnikaUseCase dodajDefinicjeSkladnikaUseCase,
            UsunDefinicjeSkladnikaUseCase usunDefinicjeSkladnikaUseCase
    ) {
        this.navHelper = navHelper;
        this.dodajDefinicjeSkladnikaUseCase = dodajDefinicjeSkladnikaUseCase;
        this.usunDefinicjeSkladnikaUseCase = usunDefinicjeSkladnikaUseCase;
    }

    public AdminPresenter(
            DodajDanieDoMenuUseCase dodajDanieDoMenuUseCase,
            UsunDanieZMenuUseCase usunDanieZMenuUseCase,
            PobierzDanieZMenuUseCase pobierzDanieZMenuUseCase,
            AktualizujDanieWMenuUseCase aktualizujDanieWMenuUseCase,
            DodajUzytkownikaUseCase dodajUzytkownikaUseCase,
            AktualizujUzytkownikaUseCase aktualizujUzytkownikaUseCase,
            UsunUzytkownikaUseCase usunUzytkownikaUseCase,
            DodajDefinicjeSkladnikaUseCase dodajDefinicjeSkladnikaUseCase,
            PobierzDefinicjeSkladnikaUseCase pobierzDefinicjeSkladnikaUseCase,
            AktualizujDefinicjeSkladnikaUseCase aktualizujDefinicjeSkladnikaUseCase,
            UsunDefinicjeSkladnikaUseCase usunDefinicjeSkladnikaUseCase,
            DodajSkladikUseCase dodajSkladnikUseCase,
            AktualizujSkladikUseCase aktualizujSkladnikUseCase,
            PobierzSkladnikiUseCase pobierzSkladnikiUSeCase,
            UsunSkladikUseCase usunSkladnikUseCase,
            UserHelper userHelper,
            NavHelper navHelper
    ) {
        this.dodajDanieDoMenuUseCase = dodajDanieDoMenuUseCase;
        this.usunDanieZMenuUseCase = usunDanieZMenuUseCase;
        this.pobierzDanieZMenuUseCase = pobierzDanieZMenuUseCase;
        this.aktualizujDanieWMenuUseCase = aktualizujDanieWMenuUseCase;
        this.dodajUzytkownikaUseCase = dodajUzytkownikaUseCase;
        this.aktualizujUzytkownikaUseCase = aktualizujUzytkownikaUseCase;
        this.usunUzytkownikaUseCase = usunUzytkownikaUseCase;
        this.dodajDefinicjeSkladnikaUseCase = dodajDefinicjeSkladnikaUseCase;
        this.pobierzDefinicjeSkladnikaUseCase = pobierzDefinicjeSkladnikaUseCase;
        this.aktualizujDefinicjeSkladnikaUseCase = aktualizujDefinicjeSkladnikaUseCase;
        this.usunDefinicjeSkladnikaUseCase = usunDefinicjeSkladnikaUseCase;
        this.dodajSkladnikUseCase = dodajSkladnikUseCase;
        this.aktualizujSkladnikUseCase = aktualizujSkladnikUseCase;
        this.pobierzSkladnikiUSeCase = pobierzSkladnikiUSeCase;
        this.usunSkladnikUseCase = usunSkladnikUseCase;
        this.userHelper = userHelper;
        this.navHelper = navHelper;
    }

    public void onEdytujUzytkownika() {
        // TODO - implement AdminPresenter.onEdytujUzytkownika
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzEdytujUzytkownika(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzEdytujUzytkownika
        throw new UnsupportedOperationException();
    }

    public void onUsunUzytkownika() {
        // TODO - implement AdminPresenter.onUsunUzytkownika
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzUsunUzytkownika(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzUsunUzytkownika
        throw new UnsupportedOperationException();
    }

    public void onDodajPozycje() {
        // TODO - implement AdminPresenter.onDodajPozycje
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzDodajPozycje(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzDodajPozycje
        throw new UnsupportedOperationException();
    }

    public void onEdytujPozycje() {
        // TODO - implement AdminPresenter.onEdytujPozycje
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzEdytujPozycje(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzEdytujPozycje
        throw new UnsupportedOperationException();
    }

    public void onUsunPozycje() {
        // TODO - implement AdminPresenter.onUsunPozycje
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzUsunPozycje(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzUsunPozycje
        throw new UnsupportedOperationException();
    }

    public void onZaktualizujStanMagazynu() {
        // TODO - implement AdminPresenter.onZaktualizujStanMagazynu
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzZaktualizujStanMagazynu(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzZaktualizujStanMagazynu
        throw new UnsupportedOperationException();
    }

    public void onDodajDefinicjeSkaldnika(ActionEvent event) {
        System.out.println("Dodaje definicje skladnika");
        navHelper.navigateTo("dodaj-definicje-skladnika-view");
    }

    public void onZatwierdzDodajDefinicjeSkaldnika(ActionEvent event) {
        dodajDefinicjeSkladnikaUseCase.execute(
                new DodajDefinicjeSkladnikaUseCase.Params(
                        new DefinicjaSkladnika(
                                ((TextField) navHelper.getFromCurrentSceneById("nazwaTextField")).getText(),
                                ((TextField) navHelper.getFromCurrentSceneById("jednostkaTextField")).getText()
                        )
                )
        );
        onCancel();
    }

    public void onEdytujDefinicjeSkladnika() {
        // TODO - implement AdminPresenter.onEdytujDefinicjeSkladnika
        throw new UnsupportedOperationException();
    }

    /**
     * @param String
     */
    public void onZatwierdzEdytujDefinicjeSkladnika(int[] String) {
        // TODO - implement AdminPresenter.onZatwierdzEdytujDefinicjeSkladnika
        throw new UnsupportedOperationException();
    }

    public void onUsunDefinicjeSkladnika() {
        // TODO - implement AdminPresenter.onUsunDefinicjeSladnika
        System.out.println("usuwanie definicji skladnika");
        navHelper.navigateTo("usun-definicje-skladnika-view");
    }

    /**
     * @param String
     */
    public void onZatwierdzUsunDefinicjeSladnika(ActionEvent actionEvent) {
        // TODO - implement AdminPresenter.onZatwierdzUsunDefinicjeSladnika
        usunDefinicjeSkladnikaUseCase.execute(
                new UsunDefinicjeSkladnikaUseCase.Params(
                        ((TextField) navHelper.getFromCurrentSceneById("nazwaTextField")).getText()
                )
        );
        onCancel();
    }

    public void onCancel() {
        navHelper.navigateTo("admin-menu-view");
    }

    public void onLogout() {
        // TODO - implement AdminPresenter.onLogout
        throw new UnsupportedOperationException();
    }

}