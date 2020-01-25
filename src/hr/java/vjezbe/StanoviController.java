package hr.java.vjezbe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StanoviController {

    @FXML
    private TextField naslovStana;

    @FXML
    private TextField opisStana;

    @FXML
    private TextField cijenaStana;

    @FXML
    private TextField kvadraturaStana;

    @FXML
    private Button pretraziStanoveButton;

    @FXML
    private TableView<Stan> stanoviTable;

    @FXML
    private TableColumn<Stan, String> tableCollumnNaslov;

    @FXML
    private TableColumn<Stan, String> tableCollumnOpis;

    @FXML
    private TableColumn<Stan, BigDecimal> tableCollumnCijena;
    
    @FXML
    private TableColumn<Stan, Integer> tableCollumnKvadratura;
    @FXML
    private TableColumn<Stan, Stanje> tableCollumnStanje; 
	@FXML
    void pretrazi(ActionEvent event) {
    	String uneseniNaslov = naslovStana.getText();
    	String uneseniOpis = opisStana.getText();
    	String unesenaKvadratura = kvadraturaStana.getText();
    	String unesenaCijena = cijenaStana.getText();
    	
    	List<Stan> list = new ArrayList<>();
    	try {
			// public Stan(long id, String naslov, String opis, BigDecimal cijena, Stanje stanje, int kvadratura)
			if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaKvadratura.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaKvadratura.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, uneseniOpis, null, null));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, null, null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && unesenaKvadratura.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, new BigDecimal(unesenaCijena), null));
	    	}
	    	else if(unesenaKvadratura.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, uneseniOpis, null, null));
	    	}
	    	else if(uneseniOpis.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, null, null, null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(uneseniOpis.isBlank() && unesenaKvadratura.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, null, new BigDecimal(unesenaCijena), null));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, uneseniOpis, null, null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(uneseniNaslov.isBlank() && unesenaKvadratura.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, uneseniOpis, new BigDecimal(unesenaCijena), null));
	    	}
	    	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, null, new BigDecimal(unesenaCijena), null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(uneseniNaslov.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(null, uneseniOpis, new BigDecimal(unesenaCijena), null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(uneseniOpis.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, null, new BigDecimal(unesenaCijena), null, Integer.parseInt(unesenaKvadratura)));
	    	}
	    	else if(unesenaKvadratura.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, uneseniOpis, new BigDecimal(unesenaCijena), null));
	    	}
	    	else if(unesenaCijena.isBlank()) {
	    		list = BazaPodataka.dohvatiStanovePremaKriterijima(new Stan(uneseniNaslov, uneseniOpis, null, null, Integer.parseInt(unesenaKvadratura)));
	    	}
				System.out.println(uneseniNaslov);
			} catch (BazaPodatakaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
    	ObservableList<Stan> lista = FXCollections.observableArrayList(list);
    	stanoviTable.setItems((ObservableList<Stan>) lista);
    }
    
    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	stanoviTable.setEditable(false);
    	stanoviTable.setVisible(true);
    	//postavi collumn
    	tableCollumnNaslov.setCellValueFactory(new PropertyValueFactory<Stan, String>("naslov"));
    	tableCollumnOpis.setCellValueFactory(new PropertyValueFactory<Stan, String>("opis"));
    	tableCollumnCijena.setCellValueFactory(new PropertyValueFactory<Stan, BigDecimal>("cijena"));
    	tableCollumnStanje.setCellValueFactory(new PropertyValueFactory<Stan, Stanje>("stanje"));
    	tableCollumnKvadratura.setCellValueFactory(new PropertyValueFactory<Stan, Integer>("kvadratura"));
    	

    	//ucitaj data
    	Platform.runLater(new Runnable() {
    	    public void run() {
    	    	List<Stan> listItems = null;
    			try {
    				listItems = BazaPodataka.dohvatiStanove();
    			} catch (BazaPodatakaException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            	ObservableList<Stan> lista = (ObservableList<Stan>) FXCollections.observableArrayList(listItems);
            	
            	stanoviTable.setItems((ObservableList<Stan>) lista);
    	    }
    	});
    	
    	/*
    	new Thread(() -> {
    		List<Stan> listItems = null;
			try {
				listItems = BazaPodataka.dohvatiStanove();
			} catch (BazaPodatakaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	ObservableList<Stan> lista = (ObservableList<Stan>) FXCollections.observableArrayList(listItems);
        	
        	stanoviTable.setItems((ObservableList<Stan>) lista);
    	}).start();
    	/*
    	List<Stan> listItems = BazaPodataka.dohvatiStanove();
    	ObservableList<Stan> lista = (ObservableList<Stan>) FXCollections.observableArrayList(listItems);
    	
    	stanoviTable.setItems((ObservableList<Stan>) lista);
    	*/
    }
}
