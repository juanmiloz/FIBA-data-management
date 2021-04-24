package structures.binaryTree;

import java.util.ArrayList;

public interface BinaryTreeInterface <K extends Comparable<K>,E>{
	public void insert(K key, E element);
	public ArrayList<E> delete(K key);
	public ArrayList<E> search(K key);
	public Node<K,E> searchNode(K key);
}
