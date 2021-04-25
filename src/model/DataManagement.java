package model;

import java.util.ArrayList;

import structures.avlTree.AvlTree;
import structures.binaryTree.BinaryTree;

public class DataManagement {

	ArrayList<Player> listPlayer;
	AvlTree<Double,Player> avlTreePER;
	AvlTree<Double,Player> avlTreeTS;
	AvlTree<Double,Player> avlTreeRB;
	AvlTree<Double,Player> avlTreeAS;
	BinaryTree<Double,Player> abbTreeSTL;

	public DataManagement() {
		listPlayer = new ArrayList<>();
		avlTreePER = new AvlTree<>();
		avlTreeTS = new AvlTree<>();
		avlTreeRB = new AvlTree<>();
		avlTreeAS = new AvlTree<>();
		abbTreeSTL = new BinaryTree<>();
	}
	/**
     * Name: addPlayer
     * Method used to add new player to list of players<br>
     * @param name - name of the player  - name = String, name != null, name != ""
     * @param team - team of the player  - team = String, team != null, team != ""
     * @param year - year of player´s debut - year = int
     * @param age - age of player - age = int
     * @param per - Player efficiency rating - per = double
     * @param trueShooting - TrueShoting - trueShooting = double
     * @param rebounds - rebounds of the player - rebounds = double
     * @param assists - assists of the player - assists = double
     * @param steals - steals of the player - steals = double
     * @param blocks - blocks of the player - block = double
	 */
	public void addPlayer(String name, String team, int year, int age, double per, double trueShooting, double rebounds, double assists, double steals, double blocks){
		Player newPlayer = new Player(name,team,year,age,per,trueShooting,rebounds,assists,steals, blocks);
		listPlayer.add(newPlayer);
	}
	/**
	 * Name: getListPlayer
	 * Method used to get players list. <br>
	 * @return A ArrayList<Player> representing players list.
	*/
	public ArrayList<Player> getListPlayer(){
		return listPlayer;
	}
	/**
	 * Name: searchPlayerLinearly
	 * Method used to get players list by linearly search. <br>
	 * @param name - name of the player  - name = String, name != null, name != ""
	 * @return A ArrayList<Player> representing players list.
	 */
	public ArrayList<Player> searchPlayerLinearly(String name){
		ArrayList<Player> playerTemporates = new ArrayList<>();
		for(int i = 0; i < listPlayer.size(); i++){
			if(listPlayer.get(i).getName().equalsIgnoreCase(name)){
				playerTemporates.add(listPlayer.get(i));
			}
		}
		return playerTemporates;
	}
	
	public void createBinaryTrees() {
		for(int c = 0; c < listPlayer.size(); c++) {
			avlTreePER.insert(listPlayer.get(c).getPer(), listPlayer.get(c));
			avlTreeTS.insert(listPlayer.get(c).getTrueShooting(), listPlayer.get(c));
			avlTreeRB.insert(listPlayer.get(c).getRebounds(), listPlayer.get(c));
			avlTreeAS.insert(listPlayer.get(c).getAssists(), listPlayer.get(c));
			abbTreeSTL.insert(listPlayer.get(c).getSteals(), listPlayer.get(c));
		}
	}
}
