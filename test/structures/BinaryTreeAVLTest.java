package structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Player;
import structures.avlTree.AvlTree;
import structures.avlTree.Node;
import structures.binaryTree.BinaryTree;

class BinaryTreeTestAVL {
	
	public Node<Integer,Player> setupScenary1(){
		Player player1 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		Player player2 = new Player("Giovanni", "CHI", 2002, 18, 2, 2.1, 3, 5, 1, 10);
		Player player3 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> rightSon = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> rightSon2 = new Node<>(player1.getYear(), player1);
		
		root.setRightSon(rightSon);
		rightSon.setFather(root);
		rightSon.setRightSon(rightSon2);
		rightSon.setRightSon(rightSon);
		
		return root;
	}
	
	@Test
	void testInsert() {
		Player player1 = new Player("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		Player player2 = new Player("cobe", "CHI", 1985, 40, 2, 1, 20, 39, 0.4, 20);
		Player player3 = new Player("lebron", "CHI", 1995, 40, 2, 1, 20, 39, 0.4, 20);
		Player player4 = new Player("raul", "CHI", 1993, 40, 2, 1, 20, 39, 0.4, 20);
		Player player5 = new Player("lebron", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		Player player6 = new Player("james", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		Player player7 = new Player("Giovanni", "CHI", 2000, 40, 2, 1, 20, 39, 0.4, 20);
		AvlTree<Integer,Player> tree = new AvlTree<>();
		tree.insert(player1.getYear(), player1);
		assertEquals(0, tree.getRoot().getBalanceFactor());
		tree.insert(player2.getYear(), player2);
		assertEquals(1, tree.getRoot().getBalanceFactor());
		tree.insert(player3.getYear(), player3);
		assertEquals(0, tree.getRoot().getBalanceFactor());
		tree.insert(player4.getYear(), player4);
		assertEquals(-1, tree.getRoot().getBalanceFactor());
		assertEquals(1, tree.getRoot().getRightSon().getBalanceFactor());
		tree.insert(player5.getYear(), player5);
		tree.insert(player6.getYear(), player6);
		tree.insert(player7.getYear(), player7);
		/*System.out.println(tree.getRoot().getBalanceFactor());
		System.out.println(tree.getRoot().getLeftSon().getBalanceFactor());
		System.out.println(tree.getRoot().getRightSon().getBalanceFactor());
		System.out.println(tree.getRoot().getRightSon().getLeftSon().getBalanceFactor());
		System.out.println(tree.getRoot().getRightSon().getRightSon().getBalanceFactor());*/
		assertEquals(player1, tree.getRoot().getElement());
		assertEquals(player2, tree.getRoot().getLeftSon().getElement());
		assertEquals(player3, tree.getRoot().getRightSon().getElement());
		assertEquals(player4, tree.getRoot().getRightSon().getLeftSon().getElement());
		assertEquals(player5, tree.getRoot().getRightSon().getRightSon().getElement());
		assertEquals(player6, tree.getRoot().getElements().get(1));
		assertEquals(-2, tree.getRoot().getBalanceFactor());
	}
	
	@Test
	void testSearch() {
		Player player1 = new Player("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		Player player2 = new Player("cobe", "CHI", 1985, 40, 2, 1, 20, 39, 0.4, 20);
		Player player3 = new Player("lebron", "CHI", 1995, 40, 2, 1, 20, 39, 0.4, 20);
		Player player4 = new Player("lebron", "CHI", 1993, 40, 2, 1, 20, 39, 0.4, 20);
		Player player5 = new Player("lebron", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		AvlTree<Integer,Player> tree = new AvlTree<>();
		tree.insert(player1.getYear(), player1);
		tree.insert(player2.getYear(), player2);
		tree.insert(player3.getYear(), player3);
		tree.insert(player4.getYear(), player4);
		tree.insert(player5.getYear(), player5);
		
		assertEquals(player1, tree.search(1990).get(0));
		assertEquals(player2, tree.search(1985).get(0));
		assertEquals(player3, tree.search(1995).get(0));
		assertEquals(player4, tree.search(1993).get(0));
		assertEquals(player5, tree.search(1997).get(0));
		assertNull(tree.search(2000));
	}
	
	@Test
	void testSearchNode() {
		Player player1 = new Player("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		Player player2 = new Player("cobe", "CHI", 1985, 40, 2, 1, 20, 39, 0.4, 20);
		Player player3 = new Player("lebron", "CHI", 1995, 40, 2, 1, 20, 39, 0.4, 20);
		Player player4 = new Player("lebron", "CHI", 1993, 40, 2, 1, 20, 39, 0.4, 20);
		Player player5 = new Player("lebron", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		Player player6 = new Player("Pepe", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		AvlTree<Integer,Player> tree = new AvlTree<>();
		tree.insert(player1.getYear(), player1);
		tree.insert(player2.getYear(), player2);
		tree.insert(player3.getYear(), player3);
		tree.insert(player4.getYear(), player4);
		tree.insert(player5.getYear(), player5);
		tree.insert(player6.getYear(), player6);
		
		assertEquals(tree.getRoot(), tree.searchNode(1990));
		assertEquals(tree.getRoot().getLeftSon(), tree.searchNode(1985));
		assertEquals(tree.getRoot().getRightSon(), tree.searchNode(1995));
		assertEquals(tree.getRoot().getRightSon().getLeftSon(), tree.searchNode(1993));
		assertEquals(tree.getRoot().getRightSon().getRightSon(), tree.searchNode(1997));
		assertEquals(tree.getRoot().getRightSon().getRightSon().getElements().get(1), tree.searchNode(1997).getElements().get(1));
		assertNull(tree.searchNode(2000));
	}
	
	/*
	@Test
	void testDelete() {
		Player player1 = new Player("michael", "CHI", 1990, 40, 2, 1, 20, 39, 0.4, 20);
		Player player2 = new Player("cobe", "CHI", 1985, 40, 2, 1, 20, 39, 0.4, 20);
		Player player3 = new Player("lebron", "CHI", 1995, 40, 2, 1, 20, 39, 0.4, 20);
		Player player4 = new Player("lebron", "CHI", 1993, 40, 2, 1, 20, 39, 0.4, 20);
		Player player5 = new Player("lebron", "CHI", 1997, 40, 2, 1, 20, 39, 0.4, 20);
		BinaryTree<Integer,Player> tree = new BinaryTree<>();
		tree.insert(player1.getYear(), player1);
		tree.insert(player2.getYear(), player2);
		tree.insert(player3.getYear(), player3);
		tree.insert(player4.getYear(), player4);
		tree.insert(player5.getYear(), player5);
		
		tree.delete(1985);
			
		//assertNull(tree.getRoot().getLeftSon());
	}*/
	
	@Test
	public void testRotateLeftCaseA() {
		Player player1 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		Player player2 = new Player("Giovanni", "CHI", 2002, 18, 2, 2.1, 3, 5, 1, 10);
		Player player3 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> rightSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> rightSon2 = new Node<>(player3.getYear(), player3);
		
		root.setRightSon(rightSon);
		rightSon.setFather(root);
		rightSon.setRightSon(rightSon2);
		rightSon2.setFather(rightSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		avlTree.rotateLeft(avlTree.getRoot());
		
		assertEquals(player1, avlTree.getRoot().getLeftSon().getElement());
		assertEquals(player2, avlTree.getRoot().getElement());
		assertEquals(player3, avlTree.getRoot().getRightSon().getElement());
	}
	
	@Test
	public void testRotateLeftCaseB() {
		Player player1 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		Player player2 = new Player("Giovanni", "CHI", 2004, 18, 2, 2.1, 3, 5, 1, 10);
		Player player3 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		Player player4 = new Player("Juan", "BOS", 2005, 17, 1, 1, 2, 3, 4, 6);
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> rightSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> rightSonLeftSon = new Node<>(player3.getYear(), player3);
		Node<Integer,Player> rightSonRightSon = new Node<>(player4.getYear(), player4);
		
		root.setRightSon(rightSon);
		rightSon.setFather(root);
		rightSon.setLeftSon(rightSonLeftSon);
		rightSonLeftSon.setFather(rightSon);
		rightSon.setRightSon(rightSonRightSon);
		rightSonRightSon.setFather(rightSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		avlTree.rotateLeft(avlTree.getRoot());
		
		assertEquals(player1, avlTree.getRoot().getLeftSon().getElement());
		assertEquals(player2, avlTree.getRoot().getElement());
		assertEquals(player4, avlTree.getRoot().getRightSon().getElement());
		assertEquals(player3, avlTree.getRoot().getLeftSon().getRightSon().getElement());		
	}
	
	@Test
	public void testRotateLeftCaseC() {
		Player player1 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		Player player2 = new Player("Giovanni", "CHI", 2004, 18, 2, 2.1, 3, 5, 1, 10);
		Player player3 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> rightSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> rightSonLeftSon = new Node<>(player3.getYear(), player3);
		
		root.setRightSon(rightSon);
		rightSon.setFather(root);
		rightSon.setLeftSon(rightSonLeftSon);
		rightSonLeftSon.setFather(rightSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		/*System.out.println("Inicial:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("Hijo derecho:" + avlTree.getRoot().getRightSon().getElement().getName());
		System.out.println("Hijo izquierdo del hijo derecho:" + avlTree.getRoot().getRightSon().getLeftSon().getElement().getName());*/
		avlTree.rotateRight(avlTree.getRoot().getRightSon());
		/*System.out.println("\nPaso 1:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("hijo derecho: " + avlTree.getRoot().getRightSon().getElement().getName());
		System.out.println("hijo derecho del hijo derecho:" + avlTree.getRoot().getRightSon().getRightSon().getElement().getName());*/
		avlTree.rotateLeft(avlTree.getRoot());
		/*System.out.println("\nPaso 2:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("hijo derecho: " + avlTree.getRoot().getRightSon().getElement().getName());
		System.out.println("hijo izquierdo : " + avlTree.getRoot().getLeftSon().getElement().getName());*/
		
		assertEquals(player1, avlTree.getRoot().getLeftSon().getElement());
		assertEquals(player3, avlTree.getRoot().getElement());
		assertEquals(player2, avlTree.getRoot().getRightSon().getElement());
				
	}
	
	@Test
	public void testRotateRightCaseD() {
		Player player1 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		Player player2 = new Player("Giovanni", "CHI", 2002, 18, 2, 2.1, 3, 5, 1, 10);
		Player player3 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> leftSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> leftSon2 = new Node<>(player3.getYear(), player3);
		
		root.setLeftSon(leftSon);
		leftSon.setFather(root);
		leftSon.setLeftSon(leftSon2);
		leftSon2.setFather(leftSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		avlTree.rotateRight(avlTree.getRoot());
		
		assertEquals(player1, avlTree.getRoot().getRightSon().getElement());
		assertEquals(player2, avlTree.getRoot().getElement());
		assertEquals(player3, avlTree.getRoot().getLeftSon().getElement());
	}
	
	@Test
	public void testRotateLeftCaseE() {
		Player player1 = new Player("Juan", "BOS", 2005, 17, 1, 1, 2, 3, 4, 6);
		Player player2 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		Player player3 = new Player("Giovanni", "CHI", 2004, 18, 2, 2.1, 3, 5, 1, 10);
		Player player4 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> leftSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> leftSonRightSon = new Node<>(player3.getYear(), player3);
		Node<Integer,Player> leftSonLeftSon = new Node<>(player4.getYear(), player4);
		
		root.setLeftSon(leftSon);
		leftSon.setFather(root);
		leftSon.setRightSon(leftSonRightSon);
		leftSonRightSon.setFather(leftSon);
		leftSon.setLeftSon(leftSonLeftSon);
		leftSonLeftSon.setFather(leftSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		avlTree.rotateRight(avlTree.getRoot());
		
		assertEquals(player1, avlTree.getRoot().getRightSon().getElement());
		assertEquals(player2, avlTree.getRoot().getElement());
		assertEquals(player4, avlTree.getRoot().getLeftSon().getElement());
		assertEquals(player3, avlTree.getRoot().getRightSon().getLeftSon().getElement());		
	}
	
	@Test
	public void testRotateLeftCaseF() {
		Player player1 = new Player("Giovanni", "CHI", 2004, 18, 2, 2.1, 3, 5, 1, 10);
		Player player2 = new Player("Sanin", "HOU", 2000, 20, 4, 5, 20, 30, 2, 30);
		Player player3 = new Player("Sebastian", "BOS", 2003, 17, 1, 1, 2, 3, 4, 6);
		
		
		Node<Integer,Player> root = new Node<>(player1.getYear(), player1);
		Node<Integer,Player> leftSon = new Node<>(player2.getYear(), player2);
		Node<Integer,Player> leftSonRightSon = new Node<>(player3.getYear(), player3);
		
		root.setLeftSon(leftSon);
		leftSon.setFather(root);
		leftSon.setRightSon(leftSonRightSon);
		leftSonRightSon.setFather(leftSon);
		
		AvlTree<Integer, Player> avlTree = new AvlTree<>();
		avlTree.setRoot(root);
		
		/*System.out.println("Inicial:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("Hijo izquierdo:" + avlTree.getRoot().getLeftSon().getElement().getName());
		System.out.println("Hijo derecho del hijo izquierdo:" + avlTree.getRoot().getLeftSon().getRightSon().getElement().getName());*/
		avlTree.rotateLeft(avlTree.getRoot().getLeftSon());
		/*System.out.println("\nPaso 1:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("hijo izquierdo: " + avlTree.getRoot().getLeftSon().getElement().getName());
		System.out.println("hijo izquierdo del hijo izquierdo:" + avlTree.getRoot().getLeftSon().getLeftSon().getElement().getName());*/
		avlTree.rotateRight(avlTree.getRoot());
		/*System.out.println("\nPaso 2:");
		System.out.println("raiz: " + avlTree.getRoot().getElement().getName());
		System.out.println("hijo derecho: " + avlTree.getRoot().getRightSon().getElement().getName());
		System.out.println("hijo izquierdo : " + avlTree.getRoot().getLeftSon().getElement().getName());*/
		
		assertEquals(player1, avlTree.getRoot().getRightSon().getElement());
		assertEquals(player3, avlTree.getRoot().getElement());
		assertEquals(player2, avlTree.getRoot().getLeftSon().getElement());
				
	}
}
