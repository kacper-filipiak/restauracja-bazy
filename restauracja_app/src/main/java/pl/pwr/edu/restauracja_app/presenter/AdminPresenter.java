package pl.pwr.edu.restauracja_app.presenter;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.util.Pair;
import pl.pwr.edu.restauracja_app.NavHelper;
import pl.pwr.edu.restauracja_app.model.datamodels.Danie;
import pl.pwr.edu.restauracja_app.model.datamodels.DefinicjaSkladnika;
import pl.pwr.edu.restauracja_app.model.datamodels.Skladnik;
import pl.pwr.edu.restauracja_app.model.domain.*;
import pl.pwr.edu.restauracja_app.model.utils.UserHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    private DodajSkladnikUseCase dodajSkladnikUseCase;
    private AktualizujSkladikUseCase aktualizujSkladnikUseCase;
    private PobierzSkladnikiUseCase pobierzSkladnikiUseCase;
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
            UsunDefinicjeSkladnikaUseCase usunDefinicjeSkladnikaUseCase,
            PobierzDefinicjeSkladnikaUseCase pobierzDefinicjeSkladnikaUseCase,
            AktualizujDefinicjeSkladnikaUseCase aktualizujDefinicjeSkladnikaUseCase,
            PobierzSkladnikiUseCase pobierzSkladnikiUseCase,
            AktualizujSkladikUseCase aktualizujSkladnikUseCase,
            DodajSkladnikUseCase dodajSkladnikUseCase,
            PobierzDanieZMenuUseCase pobierzDanieZMenuUseCase,
            UsunDanieZMenuUseCase usunDanieZMenuUseCase,
            DodajDanieDoMenuUseCase dodajDanieDoMenuUseCase
    ) {
        this.navHelper = navHelper;
        this.dodajDefinicjeSkladnikaUseCase = dodajDefinicjeSkladnikaUseCase;
        this.usunDefinicjeSkladnikaUseCase = usunDefinicjeSkladnikaUseCase;
        this.pobierzDefinicjeSkladnikaUseCase = pobierzDefinicjeSkladnikaUseCase;
        this.aktualizujDefinicjeSkladnikaUseCase = aktualizujDefinicjeSkladnikaUseCase;
        this.pobierzSkladnikiUseCase = pobierzSkladnikiUseCase;
        this.aktualizujSkladnikUseCase = aktualizujSkladnikUseCase;
        this.dodajSkladnikUseCase = dodajSkladnikUseCase;
        this.pobierzDanieZMenuUseCase = pobierzDanieZMenuUseCase;
        this.usunDanieZMenuUseCase = usunDanieZMenuUseCase;
        this.dodajDanieDoMenuUseCase = dodajDanieDoMenuUseCase;
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
            DodajSkladnikUseCase dodajSkladnikUseCase,
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
        this.pobierzSkladnikiUseCase = pobierzSkladnikiUSeCase;
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
        List<DefinicjaSkladnika> definicjaSkladnikaList = pobierzDefinicjeSkladnikaUseCase.execute(null);
        navHelper.navigateTo("dodaj-pozycje-view");
        List<Pair<String, Float>> list = new ArrayList<>();
        TableView<Pair<String, Float>> tableView = (TableView<Pair<String, Float>>) navHelper.getFromCurrentSceneById("skladnikTable");
        TableColumn<Pair<String, Float>, String> nameColumn = (TableColumn<Pair<String, Float>, String>) tableView.getColumns().get(0);
        nameColumn.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().getKey())));
        TableColumn<Pair<String, Float>, String> iloscColumn = (TableColumn<Pair<String, Float>, String>) tableView.getColumns().get(1);
        iloscColumn.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().getValue().toString())));
        ComboBox<String> nazwy = (ComboBox<String>) navHelper.getFromCurrentSceneById("skladnikNazwaComboBox");
        ObservableList<String> items = FXCollections.observableArrayList(definicjaSkladnikaList.stream().map(DefinicjaSkladnika::nazwa).collect(Collectors.toList()));
        nazwy.setItems(items);
        Button dodajBtn = (Button) navHelper.getFromCurrentSceneById("dodajBtn");
        dodajBtn.setOnAction(x -> {
            ComboBox<String> _nazwy = (ComboBox<String>) navHelper.getFromCurrentSceneById("skladnikNazwaComboBox");
            TextField _ilosc = (TextField) navHelper.getFromCurrentSceneById("skladnikIloscComboBox");
            TableView<Pair<String, Float>> _tableView = (TableView<Pair<String, Float>>) navHelper.getFromCurrentSceneById("skladnikTable");
            ObservableList<Pair<String, Float>> it = _tableView.getItems();
            Pair<String, Float> pair = new Pair<>(_nazwy.getSelectionModel().getSelectedItem(), Float.parseFloat(_ilosc.getText()));
            if (!it.contains(pair)) {
                _tableView.getItems().add(pair);
            }
        });
        Button usunBtn = (Button) navHelper.getFromCurrentSceneById("usunBtn");
        usunBtn.setOnAction(x -> {
            TableView<Pair<String, Float>> _tableView = (TableView<Pair<String, Float>>) navHelper.getFromCurrentSceneById("skladnikTable");
            ObservableList<Pair<String, Float>> it = _tableView.getItems();
                _tableView.getItems().remove(_tableView.getSelectionModel().getSelectedItem());
        });
    }
    public void onZatwierdzDodajPozycje(ActionEvent actionEvent) {
        TableView<Pair<String, Float>> tableView = (TableView<Pair<String, Float>>) navHelper.getFromCurrentSceneById("skladnikTable");
        Map<DefinicjaSkladnika, Float> map = new HashMap<>();
        for (Pair<String, Float> item : tableView.getItems()) {
            map.put(new DefinicjaSkladnika(item.getKey(), null), item.getValue());
        }

        dodajDanieDoMenuUseCase.execute(new DodajDanieDoMenuUseCase.Params(new Danie(
                ((TextField) navHelper.getFromCurrentSceneById("nazwaTextField")).getText(),
                Float.parseFloat(((TextField) navHelper.getFromCurrentSceneById("cenaTextField")).getText()),
                map
        )));
        onCancel();
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
        List<Danie> pozycje = pobierzDanieZMenuUseCase.execute(null);
        navHelper.navigateTo("usun-pozycje-view");
        ObservableList<String> items = FXCollections.observableArrayList(pozycje.stream().map(Danie::nazwa_dania).collect(Collectors.toList()));
        ListView<String> definicjaSkladnikaListView = (ListView<String>) navHelper.getFromCurrentSceneById("pozycjaList");
        definicjaSkladnikaListView.setItems(items);
    }

    public void onZatwierdzUsunPozycje(ActionEvent actionEvent) {
        usunDanieZMenuUseCase.execute(
                new UsunDanieZMenuUseCase.Params(
                        ((ListView<String>) navHelper.getFromCurrentSceneById("pozycjaList")).getSelectionModel().getSelectedItem()
                )
        );
        onCancel();
    }

    public void onZaktualizujStanMagazynu(ActionEvent actionEvent) {

        List<Skladnik> produktList = pobierzSkladnikiUseCase.execute(null);
        navHelper.navigateTo("zaktualizuj-stan-magazynu-view");
        System.out.println("In zaktualizuj stan magazynu");
        ObservableList<Skladnik> items = FXCollections.observableArrayList(produktList);
        TableView<Skladnik> produktTableListView = (TableView) navHelper.getFromCurrentSceneById("produktTable");
        TableColumn<Skladnik, String> columnNazwa = (TableColumn<Skladnik, String>) produktTableListView.getColumns().get(0);
        columnNazwa.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().definicja().nazwa())));
        TableColumn<Skladnik, String> columnIlosc = (TableColumn<Skladnik, String>) produktTableListView.getColumns().get(1);
        columnIlosc.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().ilosc().toString())));
        TableColumn<Skladnik, String> columnJednostka = (TableColumn<Skladnik, String>) produktTableListView.getColumns().get(2);
        columnJednostka.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().definicja().jednostka())));
        TableColumn<Skladnik, String> columnDataWaz = (TableColumn<Skladnik, String>) produktTableListView.getColumns().get(3);
        columnDataWaz.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().dataWaznosci().format(DateTimeFormatter.ISO_DATE))));
        produktTableListView.setItems(items);
    }

    public void onZatwierdzZaktualizujStanMagazynu(ActionEvent actionEvent) {

        Skladnik selected = ((TableView<Skladnik>) navHelper.getFromCurrentSceneById("produktTable")).getSelectionModel().getSelectedItem();
        Float newIlosc = Float.parseFloat(((TextField) navHelper.getFromCurrentSceneById("iloscTextField")).getText());
        if (selected != null) {
            aktualizujSkladnikUseCase.execute(
                    new AktualizujSkladikUseCase.Params(
                            new Skladnik( newIlosc, selected.definicja(), selected.dataWaznosci())
                    )
            );
        }
        onCancel();

    }

   public void onDodajProdukt(ActionEvent actionEvent) {

       List<DefinicjaSkladnika> definicjaSkladnikaList = pobierzDefinicjeSkladnikaUseCase.execute(null);
       navHelper.navigateTo("produkt-form-view");
       System.out.println("In dodaj produkt form");
       ObservableList<String> items = FXCollections.observableArrayList(definicjaSkladnikaList.stream().map(DefinicjaSkladnika::nazwa).collect(Collectors.toList()));
       ComboBox<String> typComboBox = (ComboBox<String>) navHelper.getFromCurrentSceneById("typComboBox");
       typComboBox.setItems(items);
   }

    public void onZatwierdzDodajProdukt(ActionEvent actionEvent) {
        dodajSkladnikUseCase.execute(new DodajSkladnikUseCase.Params(
                new Skladnik(
                        Float.parseFloat(((TextField) navHelper.getFromCurrentSceneById("iloscTextField")).getText()),
                        new DefinicjaSkladnika(((ComboBox<String>) navHelper.getFromCurrentSceneById("typComboBox")).getSelectionModel().getSelectedItem(), null),
                        LocalDate.parse(((TextField) navHelper.getFromCurrentSceneById("dataTextField")).getText(), DateTimeFormatter.ISO_DATE)
                )
        ));
        onCancel();
        onCancel();
        onZaktualizujStanMagazynu(null);
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
        List<DefinicjaSkladnika> definicjaSkladnikaList = pobierzDefinicjeSkladnikaUseCase.execute(null);
        navHelper.navigateTo("edytuj-definicja-skladnika-view");
        System.out.println("In edytuj definicje");
        ObservableList<DefinicjaSkladnika> items = FXCollections.observableArrayList(definicjaSkladnikaList);
        TableView<DefinicjaSkladnika> definicjaSkladnikaListView = (TableView) navHelper.getFromCurrentSceneById("definicjaSkladnikaTable");
        TableColumn<DefinicjaSkladnika, String> columnNazwa = (TableColumn<DefinicjaSkladnika, String>) definicjaSkladnikaListView.getColumns().get(0);
        columnNazwa.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().nazwa())));
        TableColumn<DefinicjaSkladnika, String> columnJednostka = (TableColumn<DefinicjaSkladnika, String>) definicjaSkladnikaListView.getColumns().get(1);
        columnJednostka.setCellValueFactory((param -> new SimpleObjectProperty<>(param.getValue().jednostka())));
        definicjaSkladnikaListView.setItems(items);
    }

    public void onZatwierdzEdytujDefinicjeSkladnika(ActionEvent actionEvent) {
        aktualizujDefinicjeSkladnikaUseCase.execute(
                new AktualizujDefinicjeSkladnikaUseCase.Params(
                        new DefinicjaSkladnika(
                                ((TextField) navHelper.getFromCurrentSceneById("nazwaTextField")).getText(),
                                ((TextField) navHelper.getFromCurrentSceneById("jednostkaTextField")).getText()
                                ),
                        ((TableView<DefinicjaSkladnika>) navHelper.getFromCurrentSceneById("definicjaSkladnikaTable")).getSelectionModel().getSelectedItem().nazwa()

                ));
        onCancel();
    }

    public void onUsunDefinicjeSkladnika() {
        System.out.println("usuwanie definicji skladnika");
        List<DefinicjaSkladnika> definicjaSkladnikaList = pobierzDefinicjeSkladnikaUseCase.execute(null);
        ObservableList<String> items = FXCollections.observableArrayList(definicjaSkladnikaList.stream().map(DefinicjaSkladnika::nazwa).collect(Collectors.toList()));
        navHelper.navigateTo("usun-definicje-skladnika-view");
        ListView<String> definicjaSkladnikaListView = (ListView<String>) navHelper.getFromCurrentSceneById("definicjaSkladnikaList");
        definicjaSkladnikaListView.setItems(items);
    }

    public void onZatwierdzUsunDefinicjeSladnika(ActionEvent actionEvent) {
        usunDefinicjeSkladnikaUseCase.execute(
                new UsunDefinicjeSkladnikaUseCase.Params(
                        ((ListView<String>) navHelper.getFromCurrentSceneById("definicjaSkladnikaList")).getSelectionModel().getSelectedItem()
                )
        );
        onCancel();
    }

    public void onCancel() {
        navHelper.navigateBack();
    }

    public void onLogout() {
        // TODO - implement AdminPresenter.onLogout
        throw new UnsupportedOperationException();
    }

}