package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.DataManagement;

import java.io.FileInputStream;

public class Main extends Application {
	private DataManagementGUI dataManagementGUI;
	private DataManagement dataManagement;

	public Main(){
		dataManagement = new DataManagement();
		dataManagementGUI = new DataManagementGUI(dataManagement);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
		fxmlLoader.setController(dataManagementGUI);
		primaryStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root,1366,700);
		dataManagementGUI.showMainScreen();
		primaryStage.setScene(scene);
		primaryStage.setTitle("Data Management");

		primaryStage.show();
	}
}
