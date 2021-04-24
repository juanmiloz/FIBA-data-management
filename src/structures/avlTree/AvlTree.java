package structures.avlTree;

import java.util.ArrayList;


public class AvlTree <K extends Comparable<K>,E> implements AvlTreeInterface<K,E>{

	
	private Node<K,E> root;
	
	public AvlTree() {
		this.root = null;
	}
	
	@Override
	public void insert(K key, E element) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<E> delete(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<E> search(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Node<K, E> searchNode(K key) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Node<K, E> rotateRight(Node<K, E> n) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Node<K, E> rotateLeft(Node<K, E> n) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void rebalance(Node<K, E> n) {
		// TODO Auto-generated method stub
		
	}
	
	public Node<K,E> getRoot(){
		return root;
	}
	
	public void setRoot(Node<K,E> root) {
		this.root = root;
	}


	


	
	


}
