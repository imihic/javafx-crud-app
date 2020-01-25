package hr.java.vjezbe;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class prodajaController {

    @FXML
    private TableView<Prodaja> prodajaTable;

    @FXML
    private TableColumn<Prodaja, Artikl> oglasCollumn;

    @FXML
    private TableColumn<Prodaja, Korisnik> korisnikCollumn;

    @FXML
    private TableColumn<Prodaja, LocalDate> datumCollumn;

    @FXML
    private ComboBox<Artikl> odabirArtikla;

    @FXML
    private ComboBox<Korisnik> odabirKorisnika;

    @FXML
    private DatePicker odabirDatuma;

    @FXML
    private Button pretraga;

    @FXML
    void pretrazi(ActionEvent event) throws BazaPodatakaException {
    	Artikl artikl = odabirArtikla.getValue();
    	Korisnik korisnik = odabirKorisnika.getValue();
    	LocalDate datum = odabirDatuma.getValue();
    	List<Prodaja> list = new ArrayList<>();
    	list = BazaPodataka.dohvatiProdajuPremaKriterijima(new Prodaja(artikl, korisnik, datum));
    	ObservableList<Prodaja> lista = FXCollections.observableArrayList(list);
    	prodajaTable.setItems((ObservableList<Prodaja>) lista);
    }
    
    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	prodajaTable.setEditable(false);
    	prodajaTable.setVisible(true);
    	//postavi collumn
    	oglasCollumn.setCellValueFactory(new PropertyValueFactory<Prodaja, Artikl>("artikl"));
    	korisnikCollumn.setCellValueFactory(new PropertyValueFactory<Prodaja, Korisnik>("korisnik"));
    	datumCollumn.setCellValueFactory(new PropertyValueFactory<Prodaja, LocalDate>("datumObjave"));

    	//ucitaj data
    	ObservableList<Korisnik> korisnici = FXCollections.observableArrayList(BazaPodataka.dohvatiKorisnike());
    	odabirKorisnika.setItems(korisnici);
    	ObservableList<Artikl> artikli = FXCollections.observableArrayList(BazaPodataka.dohvatiArtikle());
    	odabirArtikla.setItems(artikli);
    	List<Prodaja> listItems = BazaPodataka.dohvatiProdajuPremaKriterijima(null);
    	ObservableList<Prodaja> lista = FXCollections.observableArrayList(listItems);
    	prodajaTable.setItems((ObservableList<Prodaja>) lista);
    }
}

