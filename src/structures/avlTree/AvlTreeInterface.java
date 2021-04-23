package structures.avlTree;

import java.util.ArrayList;


public interface AvlTreeInterface <K extends Comparable<K>,E>{
	public void insert(K key, E element);
	public ArrayList<E> delete(K key);
	public ArrayList<E> search(K key);
	public Node<K,E> searchNode(K key);
	public Node<K,E> rotateRight(Node<K,E> n);
	public Node<K,E> rotateLeft(Node<K,E> n);
	public void rebalance(Node<K,E> n);
	
}
