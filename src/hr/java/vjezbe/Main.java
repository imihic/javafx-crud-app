package hr.java.vjezbe;
	

import hr.java.vjezbe.niti.DatumObjaveNit;
import hr.java.vjezbe.niti.ZadnjiStanNit;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private static BorderPane root;
	@Override
	public void start(Stage primaryStage) {
		
		Timeline prikazSlavljenika = new Timeline(new KeyFrame(Duration.seconds(10),
                new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		   Platform.runLater(new DatumObjaveNit());
		}
		}));
		prikazSlavljenika.setCycleCount(Timeline.INDEFINITE);
		prikazSlavljenika.play();

		Timeline prikazStana = new Timeline(new KeyFrame(Duration.seconds(1),
		        new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
		Platform.runLater(new ZadnjiStanNit());
		}
		}));
		prikazStana.setCycleCount(Timeline.INDEFINITE);
		prikazStana.play();
	
		try {
			root = (BorderPane)FXMLLoader.load(getClass().getResource("Vjezbe.fxml"));
			Scene scene = new Scene(root,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void setMainPage(BorderPane root1) {
		root.setCenter(root1);
	}
	public static void main(String[] args) {
		launch(args);
	}

	public static void setBottomPage(BorderPane bottom) {
		// TODO Auto-generated method stub
		root.setBottom(bottom);
	}
}
