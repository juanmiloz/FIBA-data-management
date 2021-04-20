package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DataManagement;

public class DataManagementGUI {

	private DataManagement dataManagement;


	//Attributes mainPane.fxml
	@FXML
	private BorderPane mainPane;

	@FXML
	private JFXButton btnPER;

	@FXML
	private JFXButton btnTrueShooting;

	@FXML
	private JFXButton btnRebounds;

	@FXML
	private JFXButton btnAssists;

	@FXML
	private JFXButton btnSteals;

	@FXML
	private JFXButton btnSearchByName;

	@FXML
	private TextField txtFieldSearchName;


    @FXML
    private TableView<?> tvPlayers;

    @FXML
    private TableColumn<?, ?> tcYear;

    @FXML
    private TableColumn<?, ?> tcTeam;

    @FXML
    private TableColumn<?, ?> tcName;

    @FXML
    private TableColumn<?, ?> tcAge;

    @FXML
    private TableColumn<?, ?> tcPER;

    @FXML
    private TableColumn<?, ?> tcTrueShooting;

    @FXML
    private TableColumn<?, ?> tcRebounds;

    @FXML
    private TableColumn<?, ?> tcAssits;

    @FXML
    private TableColumn<?, ?> tcSteals;

	public DataManagementGUI(DataManagement dataManagement) {
		this.dataManagement = dataManagement;
	}

	public void showMainScreen() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreen.fxml"));
		fxmlLoader.setController(this);

		Parent mainScreen = fxmlLoader.load();

		mainPane.getStyleClass().addAll(mainScreen.getStylesheets());
		mainPane.getChildren().clear();
		mainPane.setCenter(mainScreen);

	}


	@FXML
	void filterByAssists(ActionEvent event) {

	}

	@FXML
	void filterByPER(ActionEvent event) {

	}

	@FXML
	void filterByRebounds(ActionEvent event) {

	}

	@FXML
	void filterBySteals(ActionEvent event) {

	}

	@FXML
	void filterByTrueShooting(ActionEvent event) {

	}

	@FXML
	void showAbout(ActionEvent event) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Alert");
		alert.setHeaderText("Credits");
		alert.setContentText("Juan Pablo Sanin\nJuan Camilo Zorrilla \nGiovanni Mosquera\nJuan Sebastian Rodriguez\nData Structures");

		alert.showAndWait();
	}



}
