package structures.binaryTree;

import java.util.ArrayList;

public class Node <K extends Comparable<K>,E>{
	
	private K key;
	private E element;
	private ArrayList<E> elements;
	private Node<K,E> leftSon;
	private Node<K,E> rightSon;
	private Node<K,E> father;
	
	public Node(K key, E element) {
		this.key = key;
		this.element = element;
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
		return element;
	}

	public void setElement(E element) {
		this.element = element;
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
