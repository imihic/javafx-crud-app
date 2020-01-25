package hr.java.vjezbe;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AutomobiliController {

    @FXML
    private TextField naslovAutomobila;

    @FXML
    private TextField opisAutomobila;

    @FXML
    private TextField snagaAutomobila;

    @FXML
    private TextField cijenaAutomobila;

    @FXML
    private Button pretraziButton;

    @FXML
    private TableView<Automobil> automobiliTable;

    @FXML
    private TableColumn<Automobil, String> naslovCollumn;

    @FXML
    private TableColumn<Automobil, String> opisCollumn;

    @FXML
    private TableColumn<Automobil, BigDecimal> snagaCollumn;

    @FXML
    private TableColumn<Automobil, BigDecimal> cijenaCollumn;

    @FXML
    private TableColumn<Automobil, Stanje> stanjeCollumn;

    @FXML
    private MenuItem odabirAutomobiliPretraga;

    @FXML
    private MenuItem odabirStanoviPretraga;

    @FXML
    private MenuItem odabirUslugePretraga;

    @FXML
    private MenuItem odabirPrivatniPretraga;

    @FXML
    private MenuItem odabirPoslovniPretraga;

    @FXML
    void pretragaAutomobiliWindow(ActionEvent event) {
    	try {
    		 BorderPane center = FXMLLoader.load(getClass().
    		 getResource("Automobili.fxml"));
    		 Main.setMainPage(center);
    		 } catch (IOException e) {
    			 e.printStackTrace();
    		 }
    }
    @FXML
    void pretrazi(ActionEvent event) {
    	String uneseniNaslov = naslovAutomobila.getText();
    	String uneseniOpis = opisAutomobila.getText();
    	String unesenaSnaga = snagaAutomobila.getText();
    	String unesenaCijena = cijenaAutomobila.getText();
    	System.out.println(unesenaCijena);
    	List<Automobil> list = new ArrayList<>();
		try {
			// Automobil(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal unesenaSnaga)
			if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaSnaga.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, null, null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaSnaga.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, null, null, null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaSnaga.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, uneseniOpis, null, null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, null, null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaSnaga.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, new BigDecimal(unesenaCijena), null, null));
	    	}
	    	else if(unesenaSnaga.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, uneseniOpis, null, null, null));
	    	}
	    	else if(uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, null, null, null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(uneseniOpis.isBlank() && unesenaSnaga.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, null, new BigDecimal(unesenaCijena), null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, uneseniOpis, null, null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaSnaga.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, uneseniOpis, new BigDecimal(unesenaCijena), null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, null, new BigDecimal(unesenaCijena), null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(uneseniNaslov.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(null, uneseniOpis, new BigDecimal(unesenaCijena), null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(uneseniOpis.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, null, new BigDecimal(unesenaCijena), null, new BigDecimal(unesenaSnaga)));
	    	}
	    	else if(unesenaSnaga.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, uneseniOpis, new BigDecimal(unesenaCijena), null, null));
	    	}
	    	else if(unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiAutomobilePremaKriterijima(new Automobil(uneseniNaslov, uneseniOpis, null, null, new BigDecimal(unesenaSnaga)));
	    	}
			System.out.println(uneseniNaslov);
		} catch (BazaPodatakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	ObservableList<Automobil> lista = FXCollections.observableArrayList(list);
    	automobiliTable.setItems((ObservableList<Automobil>) lista);
    }


    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	automobiliTable.setEditable(false);
    	automobiliTable.setVisible(true);
    	//postavi collumn
    	naslovCollumn.setCellValueFactory(new PropertyValueFactory<Automobil, String>("naslov"));
    	opisCollumn.setCellValueFactory(new PropertyValueFactory<Automobil, String>("opis"));
    	snagaCollumn.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("snagaKs"));
    	cijenaCollumn.setCellValueFactory(new PropertyValueFactory<Automobil, BigDecimal>("cijena"));
    	stanjeCollumn.setCellValueFactory(new PropertyValueFactory<Automobil, Stanje>("stanje"));
    	

    	//ucitaj data
    	
    	List<Automobil> listItems = BazaPodataka.dohvatiAutomobile();
    	ObservableList<Automobil> lista = FXCollections.observableArrayList(listItems);
    	automobiliTable.setItems((ObservableList<Automobil>) lista);
    	System.out.println(lista.get(0).getCijena());
    }
    
    
}
