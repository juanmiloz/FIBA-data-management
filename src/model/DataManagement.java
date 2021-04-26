package model;

import java.util.ArrayList;

import structures.avlTree.AvlTree;
import structures.binaryTree.BinaryTree;
import structures.binaryTree.Node;

public class DataManagement {

	private ArrayList<Player> listPlayer;
	private AvlTree<Double,Player> avlTreePER;
	private AvlTree<Double,Player> avlTreeTS;
	private AvlTree<Double,Player> avlTreeRB;
	private AvlTree<Double,Player> avlTreeAS;
	private BinaryTree<Double,Player> abbTreeSTL;
	private ArrayList<Player> displayList;

	public DataManagement() {
		listPlayer = new ArrayList<>();
		avlTreePER = new AvlTree<>();
		avlTreeTS = new AvlTree<>();
		avlTreeRB = new AvlTree<>();
		avlTreeAS = new AvlTree<>();
		abbTreeSTL = new BinaryTree<>();
		displayList=new ArrayList<>();
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
		
		displayList=listPlayer;
	}


	//Filter methods
	public void filter(Node<Double,Player> root,Double min,Double max) {

		
		Node<Double,Player> minNode= findMin(root,min);
		System.out.println(minNode.getElement().getName());
		System.out.println(minNode.getKey());
		if(!minNode.equals(root)) {
			while(minNode!=null) {
				if(minNode.getKey()>=min) {
					displayList.addAll(minNode.getElements());
				}
				addInorder(minNode.getRightSon(),min,max);
				minNode=minNode.getFather();
			}
		}else {
			while(minNode.getKey()<min) {
				minNode=minNode.getRightSon();
			}
			if(minNode.getKey()>=min) {
				displayList.addAll(minNode.getElements());
			}
			addInorder(minNode.getRightSon(),min,max);
		}
		
		//verificar si el nodominimo es menor al valor minimo
		//recorrer el derecho del nodo minimo
		//al finalizar subir y repitar hasta que sea nulo o maximo
		//if(minNode)
		System.out.println(min);
		System.out.println(max);
	}





	public Node<Double,Player> findMin(Node<Double,Player> node, Double min) {
		Node<Double,Player> current= node;

		if(current.getKey()>=min) {
			while(current.getLeftSon() != null) {
				current=current.getLeftSon();
			}
		}
		return current;
	}

	public void addInorder(Node<Double,Player> root,Double min,Double max) {

		if (root != null) {

			addInorder(root.getLeftSon(),min,max);
			if(root.getKey()>=min && root.getKey()<=max) {
				System.out.println("sisas "+root.getElements().get(0).getName());
				displayList.addAll(root.getElements());
				addInorder(root.getRightSon(),min,max);
			}

		}
	}

	public void filter(Double min,Double max,int tree) {
		displayList.clear();
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
			filter(abbTreeSTL.getRoot(), min, max);
			System.out.println(displayList.size());
			//System.out.println("STL");

			break;

			//BLK
		case 6:
			System.out.println("BLK");
			break;
		}
	}

	public ArrayList<Player> getDisplayList() {
		return displayList;
	}

	public void setDisplayList(ArrayList<Player> displayList) {
		this.displayList = displayList;
	}
	
	
}
