package hr.java.vjezbe.niti;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Prodaja;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DatumObjaveNit implements Runnable{
	
	private Thread nit;
	


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Prodaja prodaja = null;
		try {
			prodaja = BazaPodataka.dohvatiZadnjuProdaju();
		} catch (BazaPodatakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Zadnja prodaja");
		alert.setContentText("Oglas: " + prodaja.getArtikl().toString() + "\nKorisnik: " + prodaja.getKorisnik() + "\nDatum objave: " + prodaja.getDatumObjave());
		alert.showAndWait();
	}}
