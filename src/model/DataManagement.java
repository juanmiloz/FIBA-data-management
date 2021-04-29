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
	/**
	 * Name: createBinaryTrees
	 * Method used to create a new binary tree by filter. <br>
	 */
	@SuppressWarnings("unchecked")
	public void createBinaryTrees() {
		for(int c = 0; c < listPlayer.size(); c++) {
			avlTreePER.insert(listPlayer.get(c).getPer(), listPlayer.get(c));
			avlTreeTS.insert(listPlayer.get(c).getTrueShooting(), listPlayer.get(c));
			avlTreeRB.insert(listPlayer.get(c).getRebounds(), listPlayer.get(c));
			avlTreeAS.insert(listPlayer.get(c).getAssists(), listPlayer.get(c));
			abbTreeSTL.insert(listPlayer.get(c).getSteals(), listPlayer.get(c));
		}
		System.out.println(listPlayer.size());
		displayList=(ArrayList<Player>) listPlayer.clone();
	}


	//Filter methods
	/**
	 * Name: filter
	 * Method used to filter by caracters. <br>
	 * @param root - root of the binary tree - root = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 */
	public void filter(Node<Double,Player> root,Double min,Double max) {

		
		Node<Double,Player> minNode= findMin(root,min);
		if(!minNode.equals(root)) {
			while(minNode!=null) {
				if(minNode.getKey()>=min && minNode.getKey()<=max) {
					displayList.addAll(minNode.getElements());
				}
				addInorder(minNode.getRightSon(),min,max);
				minNode=minNode.getFather();
			}
		}else {
			while(minNode.getRightSon()!= null && minNode.getKey()<min) {
				minNode=minNode.getRightSon();
			}
			addInorder(minNode,min,max);
		}
	}




	/**
	 * Name: findMin
	 * Method find min key in the binary tree. <br>
	 * @param node - root of the binary tree - node = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @return a Node<Double,Player> representing min node
	 */
	public Node<Double,Player> findMin(Node<Double,Player> node, Double min) {
		Node<Double,Player> current= node;

		
		while(current.getLeftSon() != null && current.getKey()>min) {
				current=current.getLeftSon();
			
		}
		
		
		return current;
	}
	/**
	 * Name: findMinAVL
	 * Method find min key in the binary tree. <br>
	 * @param node - root of the binary tree - node = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @return a structures.avlTree.Node<Double,Player> representing min node
	 */
	public structures.avlTree.Node<Double,Player> findMinAVL(structures.avlTree.Node<Double, Player> node, Double min) {
		structures.avlTree.Node<Double,Player> current= node;

		
		while(current.getLeftSon() != null && current.getKey()>min) {
				current=current.getLeftSon();
			
		}
		
		
		return current;
	}
	/**
	 * Name: addInorder
	 * Method to add in order in the binary tree. <br>
	 * @param root - root of the binary tree - root = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 */
	public void addInorder(Node<Double,Player> root,Double min,Double max) {

		if (root != null) {

			addInorder(root.getLeftSon(),min,max);
			if(root.getKey()>=min && root.getKey()<=max) {
				displayList.addAll(root.getElements());
			}
			
				addInorder(root.getRightSon(),min,max);
			

		}
	}
	/**
	 * Name: addInorderAVL
	 * Method to add in order in the binary tree. <br>
	 * @param root - root of the binary tree - root = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 */
	public void addInorderAVL(structures.avlTree.Node<Double,Player> root,Double min,Double max) {

		if (root != null) {

			addInorderAVL(root.getLeftSon(),min,max);
			if(root.getKey()>=min && root.getKey()<=max) {
				displayList.addAll(root.getElements());
			}
			addInorderAVL(root.getRightSon(),min,max);

		}
	}
	
	/**
	 * Name: filterAVL
	 * Method used to filter by caracters in avl. <br>
	 * @param root - root of the binary tree - root = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 */
	private void filterAVL(structures.avlTree.Node<Double, Player> root, Double min, Double max) {
		structures.avlTree.Node<Double, Player> minNode= findMinAVL(root,min);
		if(!minNode.equals(root)) {
			while(minNode!=null) {
				if(minNode.getKey()>=min && minNode.getKey()<=max) {
					displayList.addAll(minNode.getElements());
				}
				addInorderAVL(minNode.getRightSon(),min,max);
				minNode=minNode.getFather();
			}
		}else {
			while(minNode.getRightSon()!= null && minNode.getKey()<min) {
				minNode=minNode.getRightSon();
			}
			addInorderAVL(minNode,min,max);
		}
	}
	/**
	 * Name: filter
	 * Method used to filter by caracters. <br>
	 * @param root - root of the binary tree - root = Node<Double,Player>
	 * @param min - min rank - min = double
	 * @param tree - binary tree to filter - tree = int
	 */
	public void filter(Double min,Double max,int tree) {
		//prueba();
		displayList.clear();
		switch(tree) {
		//PER
		case 1:
			filterAVL(avlTreePER.getRoot(), min, max);
			System.out.println(displayList.size());
			break;

			//TS
		case 2:
			filterAVL(avlTreeTS.getRoot(), min, max);
			System.out.println(displayList.size());
			break;

			//REB
		case 3:
			filterAVL(avlTreeRB.getRoot(), min, max);
			System.out.println(displayList.size());
			break;

			//AST
		case 4:
			filterAVL(avlTreeAS.getRoot(), min, max);
			System.out.println(displayList.size());
			break;

			//STL
		case 5:
			filter(abbTreeSTL.getRoot(), min, max);
			System.out.println(displayList.size());
			//System.out.println("STL");

			break;

			//BLK
		case 6:
			linealSearch(min, max);
			break;
		}
	}
	/**
	 * Name: linealSearch
	 * Method used to search linearly. <br>
	 * @param min - min rank - min = double
	 * @param max - max rank - max = double
	 */
	private void linealSearch(Double min, Double max) {
		for(int c = 0; c < listPlayer.size(); c++) {
			if(listPlayer.get(c).getBlocks() >= min && listPlayer.get(c).getBlocks() <= max) {
				displayList.add(listPlayer.get(c));
			}
		}
	}
	
	/**
	 * Name: getDisplayList
	 * Method used to get displayList. <br>
	 * @return a ArrayList<Player> representing player list to show
	 */
	public ArrayList<Player> getDisplayList() {
		return displayList;
	}
	/**
	 * Name: setDisplayList
	 * Method used update displayList. <br>
	 * @param displayList - list to show - displayList = ArrayList<Player>
	 */
	public void setDisplayList(ArrayList<Player> displayList) {
		this.displayList = displayList;
	}
	
	
}
