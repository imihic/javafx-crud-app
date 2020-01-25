package hr.java.vjezbe;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.OptionalLong;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Artikl;
import hr.java.vjezbe.entitet.Entitet;
import hr.java.vjezbe.entitet.PrivatniKorisnik;
import hr.java.vjezbe.entitet.Stanje;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrivatniKorisnikUnosController {

    @FXML
    private TextField unosIme;

    @FXML
    private TextField unosPrezime;

    @FXML
    private TextField unosEmail;

    @FXML
    private TextField unosTelefon;

    @FXML
    private Button unosButton;

    @FXML
    void unesi(ActionEvent event) {
    	String ime = unosIme.getText();
    	String prezime = unosPrezime.getText();
    	String email = unosEmail.getText();
    	String telefon = unosTelefon.getText();
    	Alert alert = new Alert(AlertType.ERROR);
    	if(ime.isBlank() && prezime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nPrezime je obavezan unos!\nEmail je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Prezime je obavezan unos!\nEmail je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nEmail je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nPrezime je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank() && email.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nPrezime je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Email je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Prezime je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && email.isBlank()) {
    		alert.setContentText("Prezime je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nPrezime je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && email.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank()) {
    		alert.setContentText("Ime je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank()) {
    		alert.setContentText("Prezime je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(email.isBlank()) {
    		alert.setContentText("Email je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(telefon.isBlank()) {
    		alert.setContentText("Telefon je obavezan unos!");
    		alert.showAndWait();
    	} else {
    		try{
                //Files.writeString(Path.of(Datoteke.FILE_ARTIKLI), unos);
        		BazaPodataka.pohraniNovogPrivatnogKorisnika(new PrivatniKorisnik((Long) null, ime, prezime, email, telefon));
    			Alert uspjeh = new Alert(AlertType.INFORMATION);
    			uspjeh.setContentText("Uspješan unos!");
    			uspjeh.showAndWait(); 

            } catch(BazaPodatakaException e) {
                e.printStackTrace();
                System.out.println("\tGreška pri pisanju u datoteku FILE_KORISNICI");
            }
    	}
    }
}
