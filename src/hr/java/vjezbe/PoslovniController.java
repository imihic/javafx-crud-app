package hr.java.vjezbe;

import java.util.ArrayList;
import java.util.List;
import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
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

public class PoslovniController {

    @FXML
    private TextField naziv;

    @FXML
    private TextField web;

    @FXML
    private TextField email;

    @FXML
    private Button pretraziButton;

    @FXML
    private TableView<PoslovniKorisnik> poslovniTable;

    @FXML
    private TableColumn<PoslovniKorisnik, String> nazivCollumn;

    @FXML
    private TableColumn<PoslovniKorisnik, String> webCollumn;

    @FXML
    private TableColumn<PoslovniKorisnik, String> emailCollumn;

    @FXML
    private TableColumn<PoslovniKorisnik, String> telefonCollumn;

    @FXML
    private TextField telefon;
    
    @FXML
    void pretrazi(ActionEvent event) {
    	String uneseniNaslov = naziv.getText();
    	String uneseniOpis = web.getText();
    	String uneseniEmail = email.getText();
    	String uneseniTelefon = telefon.getText();
    	List<PoslovniKorisnik> list = new ArrayList<>();
    	try {
    		if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,null,null,null));
        	}
        	else if(uneseniOpis.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,uneseniNaslov,null,null,null));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,uneseniOpis,null,null));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,null,uneseniEmail,null));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,null,null,uneseniTelefon));
        	}
        	else if(uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,uneseniNaslov,uneseniOpis,null,uneseniTelefon));
        	}
        	else if(uneseniOpis.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,uneseniNaslov,null,uneseniEmail,null));
        	}
        	else if(uneseniOpis.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,uneseniNaslov,null,null,uneseniTelefon));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,uneseniOpis,uneseniEmail,null));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniOpis.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,null,uneseniEmail,uneseniTelefon));
        	}
        	else if(uneseniNaslov.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,uneseniOpis,null,uneseniTelefon));
        	}
        	else if(uneseniNaslov.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,null,uneseniOpis,uneseniEmail,uneseniTelefon));
        	}
        	else if(uneseniOpis.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null,uneseniNaslov,null,uneseniEmail,uneseniTelefon));
        	}
        	else if(uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null, uneseniNaslov ,uneseniOpis ,null,uneseniTelefon));
        	}
        	else if(uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPoslovnihKorisnika(new PoslovniKorisnik((Long) null, uneseniNaslov ,uneseniOpis ,uneseniEmail,null));
        	}
    		}
    		catch(BazaPodatakaException e) {
    			e.printStackTrace();
    		}
		
    	ObservableList<PoslovniKorisnik> lista = FXCollections.observableArrayList(list);
    	poslovniTable.setItems((ObservableList<PoslovniKorisnik>) lista);
    }
    
    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	poslovniTable.setVisible(true);
    	//postavi collumn
    	nazivCollumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("naziv"));
    	webCollumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("web"));
    	emailCollumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("email"));  	
    	telefonCollumn.setCellValueFactory(new PropertyValueFactory<PoslovniKorisnik, String>("telefon"));  
    	//ucitaj data
    	
    	List<PoslovniKorisnik> listItems = BazaPodataka.dohvatPoslovnihKorisnika();
    	ObservableList<PoslovniKorisnik> lista = (ObservableList<PoslovniKorisnik>) FXCollections.observableArrayList(listItems);
    	
    	poslovniTable.setItems((ObservableList<PoslovniKorisnik>) lista);
    }
}
