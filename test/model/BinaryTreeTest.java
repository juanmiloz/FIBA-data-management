package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import structures.binaryTree.BinaryTree;

class BinaryTreeTest {
	
	@Test
	void testInsert() {
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
		
		assertEquals(player1, tree.getRoot().getElement());
		assertEquals(player2, tree.getRoot().getLeftSon().getElement());
		assertEquals(player3, tree.getRoot().getRightSon().getElement());
		assertEquals(player4, tree.getRoot().getRightSon().getLeftSon().getElement());
		assertEquals(player5, tree.getRoot().getRightSon().getRightSon().getElement());
	}
	
	@Test
	void testSearch() {
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
		BinaryTree<Integer,Player> tree = new BinaryTree<>();
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
	}

}
