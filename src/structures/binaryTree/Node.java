package structures.binaryTree;

import java.util.ArrayList;

public class Node <K extends Comparable<K>,E>{
	
	private K key;
	private Node<K,E> leftSon;
	private Node<K,E> rightSon;
	private Node<K,E> father;
	private ArrayList<E> elements;
	
	public Node(K key, E element) {
		this.key = key;
		elements= new ArrayList<>();
		addElement(element);
		leftSon = null;
		rightSon = null;
		father = null; 
	}
	
	public K getKey() {
		return key;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public E getElement() {
		return elements.get(0);
	}
	

	public Node<K,E> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Node<K,E> leftSon) {
		this.leftSon = leftSon;
	}

	public Node<K,E> getRightSon() {
		return rightSon;
	}

	public void setRightSon(Node<K,E> rightSon) {
		this.rightSon = rightSon;
	}

	public Node<K,E> getFather() {
		return father;
	}

	public void setFather(Node<K,E> father) {
		this.father = father;
	}

	public ArrayList<E> getElements() {
		return elements;
	}

	public void setElements(ArrayList<E> elements) {
		this.elements = elements;
	}

	public void addElement(E newElement){
		elements.add(newElement);
	}
}
