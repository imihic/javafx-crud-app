package hr.java.vjezbe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Usluga;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UslugeController {

    @FXML
    private TextField naslovOglasa;

    @FXML
    private TextField opisOglasa;

    @FXML
    private TextField cijenaOglasa;

    @FXML
    private Button pretraziButton;

    @FXML
    private TableView<Usluga> uslugeTable;

    @FXML
    private TableColumn<Usluga, String> naslovOglasaCollumn;

    @FXML
    private TableColumn<Usluga, String> opisOglasaCollumn;

    @FXML
    private TableColumn<Usluga, BigDecimal> cijenaOglasaCollumn;
    
    @FXML
    void pretrazi(ActionEvent event) {
    	String uneseniNaslov = naslovOglasa.getText();
    	String uneseniOpis = opisOglasa.getText();
    	String unesenaCijena = cijenaOglasa.getText();
    	List<Usluga> list = new ArrayList<>();
    	try {
			// Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje)
    		if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
    			list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, null, null, null));
        	}
        	else if(uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(uneseniNaslov, null, null, null));
        	}
        	else if(uneseniNaslov.isBlank() && unesenaCijena.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, uneseniOpis, null, null));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, null, new BigDecimal(unesenaCijena), null));
        	}
        	else if(uneseniNaslov.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(null, uneseniOpis,new BigDecimal(unesenaCijena), null));
        	}
        	else if(uneseniOpis.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(uneseniNaslov, null, new BigDecimal(unesenaCijena), null));
        	}
        	else if(unesenaCijena.isBlank()) {
        		list = BazaPodataka.dohvatiUslugePremaKriterijima(new Usluga(uneseniNaslov, uneseniOpis, null, null));
        	}
			System.out.println(uneseniNaslov);
		} catch (BazaPodatakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
    	ObservableList<Usluga> lista = FXCollections.observableArrayList(list);
    	uslugeTable.setItems((ObservableList<Usluga>) lista);
    }
    
    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	uslugeTable.setEditable(false);
    	uslugeTable.setVisible(true);
    	//postavi collumn
    	naslovOglasaCollumn.setCellValueFactory(new PropertyValueFactory<Usluga, String>("naslov"));
    	opisOglasaCollumn.setCellValueFactory(new PropertyValueFactory<Usluga, String>("opis"));
    	cijenaOglasaCollumn.setCellValueFactory(new PropertyValueFactory<Usluga, BigDecimal>("cijena"));  	

    	//ucitaj data
    	
    	List<Usluga> listItems = BazaPodataka.dohvatiUsluge();
    	ObservableList<Usluga> lista = (ObservableList<Usluga>) FXCollections.observableArrayList(listItems);
    	
    	uslugeTable.setItems((ObservableList<Usluga>) lista);
    }
}
