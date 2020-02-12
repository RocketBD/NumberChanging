package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import window.MainController;


public class Main extends Application {
	private Pane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("½øÖÆ×ª»»");
			FXMLLoader fl = new FXMLLoader();
			fl.setLocation(MainController.class.getResource("Main.fxml"));
			rootLayout = (Pane)fl.load();
			Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
