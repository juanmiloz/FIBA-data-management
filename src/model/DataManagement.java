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

	public Player searchPlayerLinearly(String name){
		for(int i = 0; i < listPlayer.size(); i++){
			if(listPlayer.get(i).getName().equalsIgnoreCase(name)){
				return listPlayer.get(i);
			}
		}
		return null;
	}
}
