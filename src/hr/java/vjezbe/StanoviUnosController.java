package hr.java.vjezbe;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.List;
import java.util.OptionalLong;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Automobil;
import hr.java.vjezbe.entitet.Entitet;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class StanoviUnosController {
	 @FXML
	    private TextField unosNaslova;

	    @FXML
	    private TextField unosOpisa;

	    @FXML
	    private TextField unosKvadrature;

	    @FXML
	    private TextField unosCijene;

	    @FXML
	    private ComboBox<Stanje> unosStanja;

	    @FXML
	    private Button unesiButton;

	    @FXML
	    void unesi(ActionEvent event) {
	    	String naslov = unosNaslova.getText();
	    	String opis = unosOpisa.getText();
	    	String kvadratura = unosKvadrature.getText();
	    	String cijena = unosCijene.getText();
	    	Stanje stanje1 = unosStanja.getSelectionModel().getSelectedItem();
	    	String stanje = "";
	    	if(stanje1 != null) {
	    		stanje = stanje1.toString();
	    	}
	    	Alert alert = new Alert(AlertType.ERROR);
	    	if(naslov.isBlank() && opis.isBlank() && kvadratura.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nKvadratura je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(opis.isBlank() && kvadratura.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Opis je obavezan unos!\nKvadratura je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && kvadratura.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nKvadratura je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && opis.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && opis.isBlank() && kvadratura.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nKvadratura je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(kvadratura.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Kvadratura je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(opis.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Opis je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(opis.isBlank() && kvadratura.isBlank()) {
	    		alert.setContentText("Opis je obavezan unos!\nKvadratura je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && cijena.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nCijena je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && opis.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank() && kvadratura.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!\nKvadratura je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(naslov.isBlank()) {
	    		alert.setContentText("Naslov je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(opis.isBlank()) {
	    		alert.setContentText("Opis je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(kvadratura.isBlank()) {
	    		alert.setContentText("Kvadratura je obavezan unos!");
	    		alert.showAndWait(); 
	    	}
	    	else if(cijena.isBlank()) {
	    		alert.setContentText("Cijena je obavezan unos!");
	    		alert.showAndWait();
	    		
	    	} else {
	    			new Thread(() -> {
	    				try {
							BazaPodataka.pohraniNoviStan(new Stan(naslov, opis, new BigDecimal(cijena), stanje1, Integer.parseInt(kvadratura)));
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (BazaPodatakaException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    			Alert uspjeh = new Alert(AlertType.INFORMATION);
		    			uspjeh.setContentText("Uspješan unos!");
		    			uspjeh.showAndWait(); 
	    			}).start();
	    	}
		}
	    
	    @FXML
	    public void initialize() {
	    	//ucitaj data
	    	ObservableList<Stanje> value = FXCollections.observableArrayList(Stanje.values());
	    	unosStanja.setItems(value);
	    	unosStanja.setValue(Stanje.novo);
	    }

}
