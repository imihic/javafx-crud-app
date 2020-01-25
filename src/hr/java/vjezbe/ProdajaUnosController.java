package hr.java.vjezbe;
import java.time.LocalDate;
import java.util.List;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Korisnik;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ProdajaUnosController {

    @FXML
    private ComboBox<Artikl> odabirArtikla;

    @FXML
    private ComboBox<Korisnik> odabirKorisnika;

    @FXML
    private DatePicker odabirDatuma;

    @FXML
    void unesi(ActionEvent event) throws BazaPodatakaException {
    	Prodaja prodaja = new Prodaja(odabirArtikla.getSelectionModel().getSelectedItem(), odabirKorisnika.getSelectionModel().getSelectedItem(), odabirDatuma.getValue());
    	BazaPodataka.pohraniNovuProdaju(prodaja);
    }
    	
    @FXML
    public void initialize() throws BazaPodatakaException {
    	//ucitaj data
    	ObservableList<Korisnik> korisnici = FXCollections.observableArrayList(BazaPodataka.dohvatiKorisnike());
    	odabirKorisnika.setItems(korisnici);
    	ObservableList<Artikl> artikli = FXCollections.observableArrayList(BazaPodataka.dohvatiArtikle());
    	odabirArtikla.setItems(artikli);
    }
    
}

