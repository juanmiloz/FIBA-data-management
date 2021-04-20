package gui;

import java.io.*;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.DataManagement;
import model.Player;

public class DataManagementGUI {

	private DataManagement dataManagement;


	//Attributes mainPane.fxml
	private final static String DATA_BASE = "data/dataBase/NBA_Season_Data.csv";
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
    private TableView<Player> tvPlayers;

    @FXML
    private TableColumn<Player, Integer> tcYear;

    @FXML
    private TableColumn<Player, String> tcTeam;

    @FXML
    private TableColumn<Player, String> tcName;

    @FXML
    private TableColumn<Player, Integer> tcAge;

    @FXML
    private TableColumn<Player, Double> tcPER;

    @FXML
    private TableColumn<Player, Double> tcTrueShooting;

    @FXML
    private TableColumn<Player, Double> tcRebounds;

    @FXML
    private TableColumn<Player, Double> tcAssits;

    @FXML
    private TableColumn<Player, Double> tcSteals;

	@FXML
	private JFXButton btnImportData;

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
	public void importData(ActionEvent event) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(DATA_BASE));
		String line = br.readLine();
		line = br.readLine();
		while(line!=null){
			String [] pLine = line.split(";");
			dataManagement.addPlayer(pLine[2],pLine[1],Integer.parseInt(pLine[0]),Integer.parseInt(pLine[3]),Double.parseDouble(pLine[4]),Double.parseDouble(pLine[5]),Double.parseDouble(pLine[6]),Double.parseDouble(pLine[7]),Double.parseDouble(pLine[8]));
			line = br.readLine();
		}
		loadPlayers();
	}

	public void loadPlayers(){
		ObservableList<Player> observableList;
		observableList = FXCollections.observableList(dataManagement.getListPlayer());
		tvPlayers.setItems(observableList);
		tcYear.setCellValueFactory(new PropertyValueFactory<Player, Integer>("year"));
		tcTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("team"));
		tcName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		tcAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		tcPER.setCellValueFactory(new PropertyValueFactory<Player, Double>("per"));
		tcTrueShooting.setCellValueFactory(new PropertyValueFactory<Player, Double>("trueShooting"));
		tcRebounds.setCellValueFactory(new PropertyValueFactory<Player, Double>("rebounds"));
		tcAssits.setCellValueFactory(new PropertyValueFactory<Player, Double>("assists"));
		tcSteals.setCellValueFactory(new PropertyValueFactory<Player, Double>("steals"));
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
