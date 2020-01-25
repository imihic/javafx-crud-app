package hr.java.vjezbe.niti;

import java.io.IOException;

import hr.java.vjezbe.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

public class ZadnjiStanNit implements Runnable {

	@Override
	public void run() {
		try {
			BorderPane bottom = (BorderPane)FXMLLoader.load(getClass().getResource("ZadnjiStan.fxml"));
			System.out.println("Postavljanje kontrolera");
			Main.setBottomPage(bottom);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
