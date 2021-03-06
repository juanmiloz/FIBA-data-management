package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
	private JFXButton btnBlocks;
	
	@FXML
	private JFXButton btnAge;

	@FXML
	private JFXButton btnSearchByName;

	@FXML
	private TextField txtFieldSearchName;


	@FXML
	private TableView<Player> tvPlayers;

	@FXML
	private TableColumn<Player, String> tcYear;

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
	private TableColumn<Player, Double> tcBlocks;

	//attributes screenInfoPlayer

	@FXML
	private Label labNumMax;

	@FXML
	private Label labNumCurrent;

	@FXML
	private JFXTextField txtTeamPlayer;

	@FXML
	private JFXTextField txtYearPlayer;

	@FXML
	private JFXTextField txtAgePlayer;

	@FXML
	private JFXTextField txtPerPlayer;

	@FXML
	private JFXTextField txtTrueShootingPlayer;

	@FXML
	private JFXTextField txtReboundsPlayer;

	@FXML
	private JFXTextField txtAssistsPlayer;

	@FXML
	private JFXTextField txtStealsPlayer;

	@FXML
	private JFXTextField txtNamePlayer;

	//Attributes modalPER
	@FXML
	private JFXTextField txtFieldPERLower;

	@FXML
	private JFXTextField txtFieldPERUpper;



	//Attributes modalTS
	@FXML
	private JFXTextField txtFieldTSLower;

	@FXML
	private JFXTextField txtFieldTSUpper;



	//Attributes modalREB
	@FXML
	private JFXTextField txtFieldREBLower;

	@FXML
	private JFXTextField txtFieldREBUpper;



	//Attributes modalAST
	@FXML
	private JFXTextField txtFieldASTLower;

	@FXML
	private JFXTextField txtFieldASTUpper;



	//Attributes modalSTL
	@FXML
	private JFXTextField txtFieldSTLLower;

	@FXML
	private JFXTextField txtFieldSTLUpper;



	//Attributes modalBLK
	@FXML
	private JFXTextField txtFieldBLKLower;

	@FXML
	private JFXTextField txtFieldBLKUpper;



	//Attributes modalTime
	@FXML
	private Label txtLabelTime;

	private Stage modalStageTime;
	private Stage modalStageFilter;

	private ArrayList<Player> playerTempotares;

	/**
	 * Name: DataManagementGUI
	 * Method create management gui. <br>
	 * @param dataManagement - datamanagement = DataManagement 
	 */
	public DataManagementGUI(DataManagement dataManagement) {
		this.dataManagement = dataManagement;
	}

	/**
	 * Name: showMainScreen
	 * Method to show principal screen. <br>
	 * @throws IOException
	 * @throws CsvException
	 */
	public void showMainScreen() throws IOException, CsvException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreen.fxml"));
		fxmlLoader.setController(this);

		Parent mainScreen = fxmlLoader.load();

		mainPane.getStyleClass().addAll(mainScreen.getStylesheets());
		mainPane.getChildren().clear();
		mainPane.setCenter(mainScreen);
		importData();
		//importDataCSV();		
	}
	/**
	 * Name: importDataCSV
	 * Method to Import data to csv file in the memory of program. <br>
	 * @throws IOException
	 * @throws CsvException
	 */
	public void importDataCSV() throws IOException, CsvException {
		FileReader filereader = new FileReader("data/dataBase/NBA_Season_Data.csv");
		CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
		List<String[]> data = csvReader.readAll();
		loadPlayers();
		System.out.println(data.get(0)[2]);
	}

	/*
	public void loadPlayers(List<String[]> data){
		ObservableList<String[]> observableList;
		observableList = FXCollections.observableList(data);
		tvPlayers.setItems(observableList);
		tcYear.setCellValueFactory();
		tcTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("team"));
		tcName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		tcAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		tcPER.setCellValueFactory(new PropertyValueFactory<Player, Double>("per"));
		tcTrueShooting.setCellValueFactory(new PropertyValueFactory<Player, Double>("trueShooting"));
		tcRebounds.setCellValueFactory(new PropertyValueFactory<Player, Double>("rebounds"));
		tcAssits.setCellValueFactory(new PropertyValueFactory<Player, Double>("assists"));
		tcSteals.setCellValueFactory(new PropertyValueFactory<Player, Double>("steals"));
		tcBlocks.setCellValueFactory(new PropertyValueFactory<Player, Double>("blocks"));
	}*/
	/**
	 * Name: importData
	 * Method to Import data to csv file in the memory of program and create players whit news atributes. <br>
	 * @throws IOException
	 */
	public void importData() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(DATA_BASE));
		String line = br.readLine();
		line = br.readLine();
		while(line!=null){
			String [] pLine = line.split(",");
			dataManagement.addPlayer(pLine[2],pLine[1],Integer.parseInt(pLine[0]),Integer.parseInt(pLine[3]),Double.parseDouble(pLine[4]),Double.parseDouble(pLine[5]),Double.parseDouble(pLine[6]),Double.parseDouble(pLine[7]),Double.parseDouble(pLine[8]), Double.parseDouble(pLine[9]));
			line = br.readLine();
		}
		br.close();
		dataManagement.createBinaryTrees();
		loadPlayers();
	}
	/**
	 * Name: loadPlayers
	 * Method to load news players and create relations. <br>
	 */
	public void loadPlayers(){
		ObservableList<Player> observableList;
		observableList = FXCollections.observableList(dataManagement.getDisplayList());
		tvPlayers.setItems(observableList);
		tcYear.setCellValueFactory(new PropertyValueFactory<Player, String>("year"));
		tcTeam.setCellValueFactory(new PropertyValueFactory<Player, String>("team"));
		tcName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		tcAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		tcPER.setCellValueFactory(new PropertyValueFactory<Player, Double>("per"));
		tcTrueShooting.setCellValueFactory(new PropertyValueFactory<Player, Double>("trueShooting"));
		tcRebounds.setCellValueFactory(new PropertyValueFactory<Player, Double>("rebounds"));
		tcAssits.setCellValueFactory(new PropertyValueFactory<Player, Double>("assists"));
		tcSteals.setCellValueFactory(new PropertyValueFactory<Player, Double>("steals"));
		tcBlocks.setCellValueFactory(new PropertyValueFactory<Player, Double>("blocks"));
	}
	/**
	 * Name: searchByName
	 * Method to search a player by name. <br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	public void searchByName(ActionEvent event) throws IOException {
		long timeToSearch;
		if(!txtFieldSearchName.getText().equalsIgnoreCase("")) {
			long startTime = System.currentTimeMillis();
			playerTempotares = dataManagement.searchPlayerLinearly(txtFieldSearchName.getText());
			long endTime = System.currentTimeMillis();
			timeToSearch = endTime - startTime;
			if(playerTempotares.size() != 0){

				loadTimeModal(timeToSearch);
				loadScreenPlayerInfo(playerTempotares);
			}else{
				playerNotExistAlert(timeToSearch);
			}
		}else{
			txtEmptyAlert();
		}
		txtFieldSearchName.setText("");
	}
	/**
	 * Name: loadTimeModal
	 * Method to count search time. <br>
	 * @param timeToSearch - time to search - timeToSearch = long
	 * @throws IOException
	 */
	public void loadTimeModal(long timeToSearch) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalTime.fxml"));
		fxmlLoader.setController(this);

		Parent modalTime = fxmlLoader.load();

		modalStageTime = new Stage();
		modalStageTime.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageTime.setScene(new Scene(modalTime));
		txtLabelTime.setText(timeToSearch + " ns");
		modalStageTime.setTitle("Elapsed Time");
		modalStageTime.initModality(Modality.APPLICATION_MODAL);

		modalStageTime.showAndWait();

	}

	/**
	 * Name: loadScreenPlayerInfo
	 * Method to load screen for show info players. <br>
	 * @param playerInfo - players info - playerInfo = ArrayList<Player>
	 * @throws IOException
	 */
	public void loadScreenPlayerInfo(ArrayList<Player> playerInfo) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenInfoPlayer.fxml"));
		fxmlLoader.setController(this);

		Parent infoPlayer = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(infoPlayer));
		modalStageFilter.setTitle("Info Player");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);
		loadInfoPlayer(playerInfo, 0, 1);
		modalStageFilter.showAndWait();

	}
	/**
	 * Name: loadInfoPlayer
	 * Method to load info players. <br>
	 * @param playerInfo - players info - playerInfo = ArrayList<Player>
	 * @param pos - position in the table view
	 * @param posCurrentLabel
	 */
	public void loadInfoPlayer(ArrayList<Player> playerInfo, int pos, int posCurrentLabel){
		labNumCurrent.setText(String.valueOf(posCurrentLabel));
		txtNamePlayer.setText(playerInfo.get(pos).getName());
		txtTeamPlayer.setText(playerInfo.get(pos).getTeam());
		txtYearPlayer.setText(String.valueOf(playerInfo.get(pos).getYear()));
		txtAgePlayer.setText(String.valueOf(playerInfo.get(pos).getAge()));
		txtPerPlayer.setText(String.valueOf(playerInfo.get(pos).getPer()));
		txtTrueShootingPlayer.setText(String.valueOf(playerInfo.get(pos).getTrueShooting()));
		txtReboundsPlayer.setText(String.valueOf(playerInfo.get(pos).getRebounds()));
		txtAssistsPlayer.setText(String.valueOf(playerInfo.get(pos).getAssists()));
		txtStealsPlayer.setText(String.valueOf(playerInfo.get(pos).getSteals()));
		labNumMax.setText(String.valueOf(playerInfo.size()));
	}
	/**
	 * Name: filterByAge
	 * Method to filter by player age. <br>
	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
    @FXML
    void filterByAge(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalAST.fxml"));
		fxmlLoader.setController(this);

		Parent modalAST = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalAST));

		modalStageFilter.setTitle("Assists Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);

		modalStageFilter.showAndWait();
    }
    /**
	 * Name: filterByAssists
	 * Method to filter by player assist. <br>
 	 * @param event - event = ActionEvent
     * @throws IOException
     */
	@FXML
	void filterByAssists(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalAST.fxml"));
		fxmlLoader.setController(this);

		Parent modalAST = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalAST));

		modalStageFilter.setTitle("Assists Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);

		modalStageFilter.showAndWait();
	}
    /**
	 * Name: filterByPER
	 * Method to filter by player Player efficiency rating.<br>
 	 * @param event - event = ActionEvent
     * @throws IOException
     */
	@FXML
	void filterByPER(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalPER.fxml"));
		fxmlLoader.setController(this);

		Parent modalPer = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalPer));

		modalStageFilter.setTitle("Player Efficiency Rating Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);
		modalStageFilter.showAndWait();

	}
	/**
	 * Name: filterByRebounds
	 * Method to filter by player rebound.<br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void filterByRebounds(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalREB.fxml"));
		fxmlLoader.setController(this);

		Parent modalREB = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalREB));
		modalStageFilter.setTitle("Rebounds Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);

		modalStageFilter.showAndWait();
	}
	/**
	 * Name: filterBySteals
	 * Method to filter by player steals.<br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void filterBySteals(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalSTL.fxml"));
		fxmlLoader.setController(this);

		Parent modalSTL = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalSTL));

		modalStageFilter.setTitle("Steals Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);

		modalStageFilter.showAndWait();
	}
	/**
	 * Name: filterByTrueShooting
	 * Method to filter by player true shooting.<br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void filterByTrueShooting(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalTS.fxml"));
		fxmlLoader.setController(this);

		Parent modalTS = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalTS));

		modalStageFilter.setTitle("True Shooting Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);


		modalStageFilter.showAndWait();
	}
	/**
	 * Name: filterByBlocks
	 * Method to filter by player blocks.<br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void filterByBlocks(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalBLK.fxml"));
		fxmlLoader.setController(this);

		Parent modalBLK = fxmlLoader.load();

		modalStageFilter = new Stage();
		modalStageFilter.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStageFilter.setScene(new Scene(modalBLK));
		modalStageFilter.setTitle("Blocks Filter");
		modalStageFilter.initModality(Modality.APPLICATION_MODAL);


		modalStageFilter.showAndWait();
	}

	//methods modals
	/**
	 * Name: btnFilterPERContinue
	 * Method to continue filter by player Player efficiency rating.<br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterPERContinue(ActionEvent event) throws IOException {

		double min;
		double max;
		if(txtFieldPERLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldPERLower.getText());	
		}
		if(txtFieldPERUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldPERUpper.getText());
		}

		filter(min, max,1);
		txtFieldPERLower.setText("");
		txtFieldPERUpper.setText("");
	}
	/**
	 * Name: btnFilterTSContinue
	 * Method to continue filter by true shooting. <br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterTSContinue(ActionEvent event) throws IOException {
		double min;
		double max;
		if(txtFieldTSLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldTSLower.getText());	
		}
		if(txtFieldTSUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldTSUpper.getText());
		}

		filter(min, max,2);
		txtFieldTSLower.setText("");
		txtFieldTSUpper.setText("");
	}



	/**
	 * Name: btnFilterREBContinue
	 * Method to continue filter by player rebounds. <br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterREBContinue(ActionEvent event) throws IOException {
		double min;
		double max;
		if(txtFieldREBLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldREBLower.getText());	
		}
		if(txtFieldREBUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldREBUpper.getText());
		}

		filter(min, max,3);
		txtFieldREBLower.setText("");
		txtFieldREBUpper.setText("");
	}
	/**
	 * Name: btnFilterASTContinue
	 * Method to continue filter by AST. <br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterASTContinue(ActionEvent event) throws IOException {
		double min;
		double max;
		if(txtFieldASTLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldASTLower.getText());	
		}
		if(txtFieldASTUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldASTUpper.getText());
		}

		filter(min, max,4);
		txtFieldASTLower.setText("");
		txtFieldASTUpper.setText("");
	}
	/**
	 * Name: btnFilterSTLContinue
	 * Method to continue filter by player steals. <br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterSTLContinue(ActionEvent event) throws IOException {
		double min;
		double max;
		if(txtFieldSTLLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldSTLLower.getText());	
		}
		if(txtFieldSTLUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldSTLUpper.getText());
		}

		filter(min, max,5);
		txtFieldSTLLower.setText("");
		txtFieldSTLUpper.setText("");
		
	}
	/**
	 * Name: btnFilterBLKContinue
	 * Method to continue filter by player blocks. <br>
 	 * @param event - event = ActionEvent
	 * @throws IOException
	 */
	@FXML
	void btnFilterBLKContinue(ActionEvent event) throws IOException {
		double min;
		double max;
		if(txtFieldBLKLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;
		}else {
			min= Double.parseDouble(txtFieldBLKLower.getText());	
		}
		if(txtFieldBLKUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Double.parseDouble(txtFieldBLKUpper.getText());
		}

		filter(min, max,6);
		txtFieldBLKLower.setText("");
		txtFieldBLKUpper.setText("");
		
	}
	/**
	 * Name: btnOkTime
	 * Method to continue show filter time. <br>
 	 * @param event - event = ActionEvent
	 */
	@FXML
	void btnOkTime(ActionEvent event) {
		modalStageTime.close();
		modalStageFilter.close();
	}

	/**
	 * Name: filter
	 * Method used to filter by type to filter. <br>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 * @param tree - search binary tree - tree = int
	 * @throws IOException
	 */
		public void filter(Double min, Double max, int tree) throws IOException {
		long timeToFilter;
	
		long startTime = System.nanoTime();
		dataManagement.filter(min, max, tree);
		long endTime = System.nanoTime();
		timeToFilter= endTime - startTime;

		loadTimeModal(timeToFilter);
		
		loadPlayers();
		tvPlayers.refresh();
		
	
	}


	//methods screenInfoPlayer
	/**
	 * Name: nextPlayer
	 * Method used to show next player. <br>
 	 * @param event - event = ActionEvent
	 */
	@FXML
	public void nextPlayer(ActionEvent event) {
		if(Integer.parseInt(labNumCurrent.getText())==Integer.parseInt(labNumMax.getText())){
			int pos = 0;
			loadInfoPlayer(playerTempotares,pos, 1);
		}else {
			int pos = Integer.parseInt(labNumCurrent.getText());
			loadInfoPlayer(playerTempotares,pos, Integer.parseInt(String.valueOf(labNumCurrent.getText()))+1);
		}
	}
	/**
	 * Name: prevPlayer
	 * Method used to show previous player. <br>
 	 * @param event - event = ActionEvent
	 */
	@FXML
	public void prevPlayer(ActionEvent event) {
		if(Integer.parseInt(labNumCurrent.getText())==1){
			int pos = playerTempotares.size()-1;
			loadInfoPlayer(playerTempotares,pos,playerTempotares.size());
		}else {
			int pos = Integer.parseInt(labNumCurrent.getText())-2;
			loadInfoPlayer(playerTempotares,pos,Integer.parseInt(String.valueOf(labNumCurrent.getText()))-1);
		}
	}

	//alerts
	/**
	 * Name: showAbout
	 * Method used to show credits screen. <br>
 	 * @param event - event = ActionEvent
	 * @throws FileNotFoundException
	 */
	@FXML
	public void showAbout(ActionEvent event) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Alert");
		alert.setHeaderText("Credits");
		alert.setContentText("Juan Pablo Sanin\nJuan Camilo Zorrilla \nGiovanni Mosquera\nJuan Sebastian Rodriguez\nData Structures");

		alert.showAndWait();
	}
	/**
	 * Name: txtEmptyAlert
	 * Method used to show alert screen from empty. <br>
	 * @throws FileNotFoundException
	 */
	public void txtEmptyAlert() throws FileNotFoundException {
		Alert alert = new Alert(AlertType.ERROR);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Alert");
		alert.setHeaderText("field empty");
		alert.setContentText("The field cannot be empty");
		alert.show();
	}
	/**
	 * Name: infoPlayerAlert
	 * Method used to show player info screen. <br>
	 * @param player - player from show - player = Player
	 * @param timeToSearch - timeToSearch = long
	 * @throws FileNotFoundException
	 */
	public void infoPlayerAlert(Player player, long timeToSearch) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.INFORMATION);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Info Player");
		alert.setHeaderText("Name Player: " + player.getName());
		alert.setContentText("Team: " + player.getTeam() + "\nYear: " + player.getYear() + "\nAge: " + player.getAge()
		+ "\nPER: " + player.getPer() + "\nTrue Shooting: " + player.getTrueShooting() + "\nRebounds: " + player.getRebounds()
		+ "\nAssists" + player.getAssists() + "\nSteals: " + player.getSteals() + "\nTime to search: " + timeToSearch + "milliseconds");
		alert.show();
	}
	/**
	 * Name: playerNotExistAlert
	 * Method used to show alert screen from not find player. <br>
	 * @param timeToSearch - timeToSearch = long
	 * @throws FileNotFoundException
	 */
	public void playerNotExistAlert(long timeToSearch) throws FileNotFoundException {
		Alert alert = new Alert(AlertType.ERROR);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Alert");
		alert.setHeaderText("non-existent player");
		alert.setContentText("The player is not on the list \nTime to search: " + timeToSearch + " milliseconds");
		alert.show();
	}
}
