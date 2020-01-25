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
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.entitet.Usluga;
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

public class UslugeUnosController {

    @FXML
    private TextField unosNaslova;

    @FXML
    private TextField unosOpisa;

    @FXML
    private TextField unosCijene;

    @FXML
    private ComboBox<Stanje> unosStanja;

    @FXML
    private Button unesiiButton;

    @FXML
    void unesi(ActionEvent event) {
    	String tip = "1";
    	String naslov = unosNaslova.getText();
    	String opis = unosOpisa.getText();
    	String snaga = "NULL";
    	String cijena = unosCijene.getText();
    	Stanje stanje1 = unosStanja.getSelectionModel().getSelectedItem();
    	String stanje = "";
    	if(stanje1 != null) {
    		stanje = stanje1.toString();
    	}
    	Alert alert = new Alert(AlertType.ERROR);
    	if(naslov.isBlank() && opis.isBlank() && snaga.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nSnaga je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(opis.isBlank() && snaga.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Opis je obavezan unos!\nSnaga je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(naslov.isBlank() && snaga.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Naslov je obavezan unos!\nSnaga je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(naslov.isBlank() && opis.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(naslov.isBlank() && opis.isBlank() && snaga.isBlank()) {
    		alert.setContentText("Naslov je obavezan unos!\nOpis je obavezan unos!\nSnaga je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(snaga.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Snaga je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(opis.isBlank() && cijena.isBlank()) {
    		alert.setContentText("Opis je obavezan unos!\nCijena je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(opis.isBlank() && snaga.isBlank()) {
    		alert.setContentText("Opis je obavezan unos!\nSnaga je obavezan unos!");
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
    	else if(naslov.isBlank()) {
    		alert.setContentText("Naslov je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(opis.isBlank()) {
    		alert.setContentText("Opis je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(snaga.isBlank()) {
    		alert.setContentText("Snaga je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(cijena.isBlank()) {
    		alert.setContentText("Cijena je obavezan unos!");
    		alert.showAndWait();
    		
    	} else {
    		try{
    			BazaPodataka.pohraniNovuUslugu(new Usluga(naslov, opis, new BigDecimal(cijena), Stanje.valueOf(stanje)));
    			Alert uspjeh = new Alert(AlertType.INFORMATION);
    			uspjeh.setContentText("Uspješan unos!");
    			uspjeh.showAndWait(); 
            } catch(BazaPodatakaException e) {
                e.printStackTrace();
                System.out.println("\tGreška pri upisivanju datoteke");
            }
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
