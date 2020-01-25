package hr.java.vjezbe;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Stan;
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

public class PrivatniController {

    @FXML
    private TextField ime;

    @FXML
    private TextField prezime;

    @FXML
    private TextField email;
    
    @FXML
    private Button pretraziButton;
    
    @FXML
    private TableView<PrivatniKorisnik> privatniTable;

    @FXML
    private TableColumn<PrivatniKorisnik, String> imeCollumn;

    @FXML
    private TableColumn<PrivatniKorisnik, String> prezimeCollumn;

    @FXML
    private TableColumn<PrivatniKorisnik, String> emailCollumn;

    @FXML
    private TableColumn<PrivatniKorisnik, String> telefonCollumn;

    @FXML
    private TextField telefon;

    @FXML
    void pretrazi(ActionEvent event) {
    	String unesenoIme = ime.getText();
    	String unesenoPrezime = prezime.getText();
    	String uneseniEmail = email.getText();
    	String uneseniTelefon = telefon.getText();
    	List<PrivatniKorisnik> list = new ArrayList<>();
    	try {
    		if(unesenoIme.isBlank() && unesenoPrezime.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,null,null,null));
        	}
        	else if(unesenoPrezime.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,unesenoIme,null,null,null));
        	}
        	else if(unesenoIme.isBlank() && uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,unesenoPrezime,null,null));
        	}
        	else if(unesenoIme.isBlank() && unesenoPrezime.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,null,uneseniEmail,null));
        	}
        	else if(unesenoIme.isBlank() && unesenoPrezime.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,null,null,uneseniTelefon));
        	}
        	else if(uneseniEmail.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,unesenoIme,unesenoPrezime,null,uneseniTelefon));
        	}
        	else if(unesenoPrezime.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,unesenoIme,null,uneseniEmail,null));
        	}
        	else if(unesenoPrezime.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,unesenoIme,null,null,uneseniTelefon));
        	}
        	else if(unesenoIme.isBlank() && uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,unesenoPrezime,uneseniEmail,null));
        	}
        	else if(unesenoIme.isBlank() && unesenoPrezime.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,null,uneseniEmail,uneseniTelefon));
        	}
        	else if(unesenoIme.isBlank() && uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,unesenoPrezime,null,uneseniTelefon));
        	}
        	else if(unesenoIme.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,null,unesenoPrezime,uneseniEmail,uneseniTelefon));
        	}
        	else if(unesenoPrezime.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null,unesenoIme,null,uneseniEmail,uneseniTelefon));
        	}
        	else if(uneseniEmail.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null, unesenoIme ,unesenoPrezime ,null,uneseniTelefon));
        	}
        	else if(uneseniTelefon.isBlank()) {
        		list = BazaPodataka.dohvatPrivatnihKorisnika(new PrivatniKorisnik((Long) null, unesenoIme ,unesenoPrezime ,uneseniEmail,null));
        	}
    		}
    		catch(BazaPodatakaException e) {
    			e.printStackTrace();
    		}
    	ObservableList<PrivatniKorisnik> lista = FXCollections.observableArrayList(list);
    	privatniTable.setItems((ObservableList<PrivatniKorisnik>) lista);
    }
    @FXML
    public void initialize() throws BazaPodatakaException {
    	System.out.println("Print");
    	privatniTable.setVisible(true);
    	//postavi collumn
    	imeCollumn.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("ime"));
    	prezimeCollumn.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("prezime"));
    	emailCollumn.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("email"));  	
    	telefonCollumn.setCellValueFactory(new PropertyValueFactory<PrivatniKorisnik, String>("telefon"));  
    	//ucitaj data
    	
    	List<PrivatniKorisnik> listItems = BazaPodataka.dohvatPrivatnihKorisnika();
    	ObservableList<PrivatniKorisnik> lista = (ObservableList<PrivatniKorisnik>) FXCollections.observableArrayList(listItems);
    	privatniTable.setItems((ObservableList<PrivatniKorisnik>) lista);
    }
}
