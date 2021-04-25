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

	private Stage modalStage;

	private ArrayList<Player> playerTempotares;

	public DataManagementGUI(DataManagement dataManagement) {
		this.dataManagement = dataManagement;
	}


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

	public void loadPlayers(){
		ObservableList<Player> observableList;
		observableList = FXCollections.observableList(dataManagement.getListPlayer());
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

	public void loadTimeModal(long timeToSearch) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalTime.fxml"));
		fxmlLoader.setController(this);

		Parent modalTime = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalTime));
		txtLabelTime.setText(timeToSearch + " ms");;
		modalStage.setTitle("Elapsed Time");
		modalStage.initModality(Modality.APPLICATION_MODAL);

		modalStage.showAndWait();

	}


	public void loadScreenPlayerInfo(ArrayList<Player> playerInfo) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screenInfoPlayer.fxml"));
		fxmlLoader.setController(this);

		Parent infoPlayer = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(infoPlayer));
		modalStage.setTitle("Info Player");
		modalStage.initModality(Modality.APPLICATION_MODAL);
		loadInfoPlayer(playerInfo, 0, 1);
		modalStage.showAndWait();

	}

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

	@FXML
	void filterByAssists(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalAST.fxml"));
		fxmlLoader.setController(this);

		Parent modalAST = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalAST));

		modalStage.setTitle("Assists Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);

		modalStage.showAndWait();
	}

	@FXML
	void filterByPER(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalPER.fxml"));
		fxmlLoader.setController(this);

		Parent modalPer = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalPer));

		modalStage.setTitle("Player Efficiency Rating Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);
		modalStage.showAndWait();

	}

	@FXML
	void filterByRebounds(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalREB.fxml"));
		fxmlLoader.setController(this);

		Parent modalREB = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalREB));
		modalStage.setTitle("Rebounds Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);

		modalStage.showAndWait();
	}

	@FXML
	void filterBySteals(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalSTL.fxml"));
		fxmlLoader.setController(this);

		Parent modalSTL = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalSTL));

		modalStage.setTitle("Steals Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);

		modalStage.showAndWait();
	}

	@FXML
	void filterByTrueShooting(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalTS.fxml"));
		fxmlLoader.setController(this);

		Parent modalTS = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalTS));

		modalStage.setTitle("True Shooting Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);


		modalStage.showAndWait();
	}

	@FXML
	void filterByBlocks(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("modalBLK.fxml"));
		fxmlLoader.setController(this);

		Parent modalBLK = fxmlLoader.load();

		modalStage = new Stage();
		modalStage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		modalStage.setScene(new Scene(modalBLK));
		modalStage.setTitle("Blocks Filter");
		modalStage.initModality(Modality.APPLICATION_MODAL);


		modalStage.showAndWait();
	}

	//methods modals

	@FXML
	void btnFilterPERContinue(ActionEvent event) {

		int min;
		int max;
		if(txtFieldPERLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldPERLower.getText());	
		}
		if(txtFieldPERUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldPERUpper.getText());
		}

		filter(min, max,1);
		txtFieldPERLower.setText("");
		txtFieldPERUpper.setText("");
	}

	@FXML
	void btnFilterTSContinue(ActionEvent event) {
		int min;
		int max;
		if(txtFieldTSLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldTSLower.getText());	
		}
		if(txtFieldTSUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldTSUpper.getText());
		}

		filter(min, max,2);
		txtFieldTSLower.setText("");
		txtFieldTSUpper.setText("");
	}




	@FXML
	void btnFilterREBContinue(ActionEvent event) {
		int min;
		int max;
		if(txtFieldREBLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldREBLower.getText());	
		}
		if(txtFieldREBUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldREBUpper.getText());
		}

		filter(min, max,3);
		txtFieldREBLower.setText("");
		txtFieldREBUpper.setText("");
	}

	@FXML
	void btnFilterASTContinue(ActionEvent event) {
		int min;
		int max;
		if(txtFieldASTLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldASTLower.getText());	
		}
		if(txtFieldASTUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldASTUpper.getText());
		}

		filter(min, max,4);
		txtFieldASTLower.setText("");
		txtFieldASTUpper.setText("");
	}

	@FXML
	void btnFilterSTLContinue(ActionEvent event) {
		int min;
		int max;
		if(txtFieldSTLLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldSTLLower.getText());	
		}
		if(txtFieldSTLUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldSTLUpper.getText());
		}

		filter(min, max,5);
		txtFieldSTLLower.setText("");
		txtFieldSTLUpper.setText("");
	}

	@FXML
	void btnFilterBLKContinue(ActionEvent event) {
		int min;
		int max;
		if(txtFieldBLKLower.getText().isEmpty()) {
			min=Integer.MIN_VALUE;;
		}else {
			min= Integer.parseInt(txtFieldBLKLower.getText());	
		}
		if(txtFieldBLKUpper.getText().isEmpty()) {
			max=Integer.MAX_VALUE;
		}else {
			max= Integer.parseInt(txtFieldBLKUpper.getText());
		}

		filter(min, max,6);
		txtFieldBLKLower.setText("");
		txtFieldBLKUpper.setText("");
	}

	@FXML
	void btnOkTime(ActionEvent event) {
		modalStage.close();
	}


	public void filter(int min, int max, int tree) {
		System.out.println(min);
		System.out.println(max);

		switch(tree) {
		//PER
		case 1:
			System.out.println("PER");
			break;

			//TS
		case 2:
			System.out.println("TS");
			break;

			//REB
		case 3:
			System.out.println("REB");
			break;

			//AST
		case 4:
			System.out.println("AST");
			break;

			//STL
		case 5:
			System.out.println("STL");
			break;
			
			//BLK
		case 6:
			System.out.println("BLK");
			break;
		}

		modalStage.close();
	}


	//methods screenInfoPlayer

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

	public void txtEmptyAlert() throws FileNotFoundException {
		Alert alert = new Alert(AlertType.ERROR);
		Stage stage = (Stage)alert.getDialogPane().getScene().getWindow();
		stage.getIcons().add(new Image(new FileInputStream("data/images/FIBA_logo.png")));
		alert.setTitle("Alert");
		alert.setHeaderText("field empty");
		alert.setContentText("The field cannot be empty");
		alert.show();
	}

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
