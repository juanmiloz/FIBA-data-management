package structures.binaryTree;

public interface BinaryTreeInterface <K extends Comparable<K>,E>{
	public void insert(K key, E element);
	public E delete(K key);
	public E search(K key);
	public Node<K,E> searchNode(K key);
}
