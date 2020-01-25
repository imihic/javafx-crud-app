package hr.java.vjezbe;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class VjezbeController {
	@FXML
    private MenuItem odabirAutomobiliPretraga;

    @FXML
    private MenuItem odabirAutomobiliUnos;

    @FXML
    private MenuItem odabirStanoviPretraga;

    @FXML
    private MenuItem odabirStanoviUnos;

    @FXML
    private MenuItem odabirUslugePretraga;

    @FXML
    private MenuItem odabirUslugeUnos;

    @FXML
    private MenuItem odabirPrivatniPretraga;

    @FXML
    private MenuItem odabirPrivatniUnos;

    @FXML
    private MenuItem odabirPoslovniPretraga;

    @FXML
    private MenuItem odabirPoslovniUnos;
    
    @FXML
    private MenuItem odabirProdajaPretraga;

    @FXML
    private MenuItem odabirProdajaUnos;
    
    @FXML
	void pretragaAutomobiliWindow(ActionEvent event) {
    	try {
    		 BorderPane center = FXMLLoader.load(getClass().getResource("Automobili.fxml"));
    		 Main.setMainPage(center);
    		 } catch (IOException e) {
    			 e.printStackTrace();
    		 }
    }
	@FXML
    void pretragaPoslovniWindow(ActionEvent event) {
		try {
   		 BorderPane center = FXMLLoader.load(getClass().getResource("PoslovniKorisnik.fxml"));
   		 Main.setMainPage(center);
   		 } catch (IOException e) {
   			 e.printStackTrace();
   		 }
    }

    @FXML
    void pretragaPrivatniWindow(ActionEvent event) {
    	try {
      		 BorderPane center = FXMLLoader.load(getClass().getResource("PrivatniKorisnik.fxml"));
      		 Main.setMainPage(center);
      		 } catch (IOException e) {
      			 e.printStackTrace();
      		 }
    }

    @FXML
    void pretragaStanoviWindow(ActionEvent event) {
    	try {
   		 BorderPane center = FXMLLoader.load(getClass().getResource("Stanovi.fxml"));
   		 Main.setMainPage(center);
   		 } catch (IOException e) {
   			 e.printStackTrace();
   		 }
    }

    @FXML
    void pretragaUslugeWindow(ActionEvent event) {
    	try {
      		 BorderPane center = FXMLLoader.load(getClass().getResource("Usluge.fxml"));
      		 Main.setMainPage(center);
      		 } catch (IOException e) {
      			 e.printStackTrace();
      		 }
    }
    
    @FXML
    void unosAutomobiliWindow(ActionEvent event) {
    	try {
     		 BorderPane center = FXMLLoader.load(getClass().getResource("AutomobiliUnos.fxml"));
     		 Main.setMainPage(center);
     		 } catch (IOException e) {
     			 e.printStackTrace();
     		 }
    }

    @FXML
    void unosPoslovniWindow(ActionEvent event) {
    	try {
     		 BorderPane center = FXMLLoader.load(getClass().getResource("PoslovniKorisnikUnos.fxml"));
     		 Main.setMainPage(center);
     		 } catch (IOException e) {
     			 e.printStackTrace();
     		 }
    }

    @FXML
    void unosPrivatniWindow(ActionEvent event) {
    	try {
     		 BorderPane center = FXMLLoader.load(getClass().getResource("PrivatniKorisnikUnos.fxml"));
     		 Main.setMainPage(center);
     		 } catch (IOException e) {
     			 e.printStackTrace();
     		 }
    }

    @FXML
    void unosStanoviWindow(ActionEvent event) {
    	try {
    		 BorderPane center = FXMLLoader.load(getClass().getResource("StanoviUnos.fxml"));
    		 Main.setMainPage(center);
    		 } catch (IOException e) {
    			 e.printStackTrace();
    		 }
    }

    @FXML
    void unosUslugeWindow(ActionEvent event) {
    	try {
    		 BorderPane center = FXMLLoader.load(getClass().getResource("UslugeUnos.fxml"));
    		 Main.setMainPage(center);
    		 } catch (IOException e) {
    			 e.printStackTrace();
    		 }
    }
    
    @FXML
    void unosProdajaWindow(ActionEvent event) {
    	try {
   		 BorderPane center = FXMLLoader.load(getClass().getResource("ProdajaUnos.fxml"));
   		 Main.setMainPage(center);
   		 } catch (IOException e) {
   			 e.printStackTrace();
   		 }
    }
    
    @FXML
    void pretragaProdajaWindow(ActionEvent event) {
    	try {
   		 BorderPane center = FXMLLoader.load(getClass().getResource("Prodaja.fxml"));
   		 Main.setMainPage(center);
   		 } catch (IOException e) {
   			 e.printStackTrace();
   		 }
    }
	
}