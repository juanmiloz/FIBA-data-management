package model;

import java.util.ArrayList;

public class DataManagement {

	ArrayList<Player> listPlayer;

	public DataManagement() {
		listPlayer = new ArrayList<>();
	}

	public void addPlayer(String name, String team, int year, int age, double per, double trueShooting, double rebounds, double assists, double steals){
		Player newPlayer = new Player(name,team,year,age,per,trueShooting,rebounds,assists,steals);
		listPlayer.add(newPlayer);
	}

	public ArrayList<Player> getListPlayer(){
		return listPlayer;
	}
}
