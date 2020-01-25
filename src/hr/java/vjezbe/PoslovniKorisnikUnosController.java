package hr.java.vjezbe;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.PoslovniKorisnik;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PoslovniKorisnikUnosController {
	@FXML
    private TextField unosNaziv;

    @FXML
    private TextField unosWeb;

    @FXML
    private TextField unosEmail;

    @FXML
    private TextField unosTelefon;

    @FXML
    private Button unosButton;

    @FXML
    void unesi(ActionEvent event) {
    	String tip = "2";
    	String ime = unosNaziv.getText();
    	String prezime = unosWeb.getText();
    	String email = unosEmail.getText();
    	String telefon = unosTelefon.getText();
    	Alert alert = new Alert(AlertType.ERROR);
    	if(ime.isBlank() && prezime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nWeb je obavezan unos!\nEmail je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nWeb je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nEmail je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nWeb je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank() && email.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nWeb je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(email.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Email je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Web je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank() && email.isBlank()) {
    		alert.setContentText("Web je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && telefon.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nTelefon je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && prezime.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nPrezime je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank() && email.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!\nEmail je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(ime.isBlank()) {
    		alert.setContentText("Naziv je obavezan unos!");
    		alert.showAndWait(); 
    	}
    	else if(prezime.isBlank()) {
    		alert.setContentText("Web je obavezan unos!");
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
    			BazaPodataka.pohraniNovogPoslovnogKorisnika(new PoslovniKorisnik(null, ime, prezime, email, telefon));
    			Alert uspjeh = new Alert(AlertType.INFORMATION);
    			uspjeh.setContentText("Uspješan unos!");
    			uspjeh.showAndWait(); 

            } catch(BazaPodatakaException e) {
                e.printStackTrace();
                System.out.println("\tGreška pri unosu novog poslovnog korisnika");
            }
    	}
    }
}
