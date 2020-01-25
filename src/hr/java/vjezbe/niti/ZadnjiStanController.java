package hr.java.vjezbe.niti;

import java.net.URL;
import java.util.ResourceBundle;

import hr.java.vjezbe.baza.BazaPodataka;
import hr.java.vjezbe.entitet.Stan;
import hr.java.vjezbe.iznimke.BazaPodatakaException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

public class ZadnjiStanController implements Initializable {
	
	@FXML
	private Text textStana = new Text();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		Stan stan =  null;
		try {
			stan = BazaPodataka.dohvatiZadnjiStan();
		} catch (BazaPodatakaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textStana.setText(stan.toString());
		System.out.println(stan.toString());
	}

}
