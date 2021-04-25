package structures.binaryTree;

import java.util.ArrayList;

public class BinaryTree<K extends Comparable<K>,E> implements BinaryTreeInterface<K,E>{

	private Node<K,E> root;
	

	public BinaryTree() {
		this.root = null;
	}


	@Override
	public void insert(K key, E element) {
		if(root == null) {
			root = new Node<K,E>(key,element);
		}else {
			insert(root, key, element);
		}
	}

	public void insert(Node<K,E> current, K key, E element) {
		if(key.compareTo(current.getKey())==0){
			current.addElement(element);
		}
		if(key.compareTo(current.getKey())<0 && current.getLeftSon() == null) {
			Node<K,E> newNode = new Node<>(key, element);
			current.setLeftSon(newNode);
			newNode.setFather(current);
		}else if(key.compareTo(current.getKey())<0 && current.getLeftSon() != null) {
			insert(current.getLeftSon(), key, element);
		}
		if(key.compareTo(current.getKey())>0 && current.getRightSon() == null) {
			Node<K,E> newNode = new Node<K,E>(key,element);
			current.setRightSon(newNode);
			newNode.setFather(current);
		}else if(key.compareTo(current.getKey())>0 && current.getRightSon() != null) {
			insert(current.getRightSon(),key,element);
		}
	}

	@Override
	public ArrayList<E> delete(K key) {
		Node<K,E> toDelete = searchNode(key);
		Node<K,E> y = null;

		if(toDelete!=null) {
			if(toDelete.getLeftSon()==null || toDelete.getRightSon()==null){
				y = toDelete;
			}else{
				y = getSuccessor(toDelete.getRightSon());
			}
			Node<K,E> x;
			x = (y.getLeftSon()!=null)?y.getLeftSon():y.getRightSon();
			if(x!= null){
				x.setFather(y.getFather());
			}
			if(x.getFather()==null){
				root = x;
			}else if(y.getFather().getLeftSon().equals(y)){
				y.getFather().setLeftSon(x);
			}else{
				y.getFather().setRightSon(x);
			}
			if(!y.equals(toDelete)){
				toDelete = y;
			}
		}else{
			//retornar error de que no existe el nodo
		}
		return y.getElements();
	}

	public Node<K,E> getSuccessor(Node<K,E> current){
		Node<K,E> successor = current;
		while(current.getLeftSon()!=null){
			successor = current.getLeftSon();
			current = current.getLeftSon();
		}
		return successor;
	}

	@Override
	public ArrayList<E> search(K key) {
		if(root == null) {
			return null;
		}else {
			return search(key, root);
		}
	}

	public ArrayList<E> search(K key,Node<K,E> current) {
		if(key.equals(current.getKey())) {
			return current.getElements();
		}else {
			if(key.compareTo(current.getKey()) < 0 && current.getLeftSon() != null) {
				return search(key, current.getLeftSon());
			}else if(key.compareTo(current.getKey()) > 0 && current.getRightSon() != null) {
				return search(key, current.getRightSon());
			}else {
				return null;
			}
		}
	}

	@Override
	public Node<K,E> searchNode(K key) {
		if(root == null) {
			return null;
		}else {
			return searchNode(key, root);
		}
	}

	public Node<K,E> searchNode(K key,Node<K,E> current) {
		if(key.equals(current.getKey())) {
			return current;
		}else {
			if(key.compareTo(current.getKey()) < 0 && current.getLeftSon()!= null) {
				return searchNode(key, current.getLeftSon());
			}else if(key.compareTo(current.getKey()) > 0 && current.getRightSon()!= null) {
				return searchNode(key, current.getRightSon());
			}else {
				return null;
			}
		}
	}

	public void rotateLeft(Node<K,E> root) {
		Node<K,E> temp = root.getRightSon().getLeftSon();;
		root.getRightSon().setLeftSon(root);
		root.getRightSon().setFather(root.getFather());
		root.setFather(root.getRightSon());
		root.setRightSon(temp);
	}

	public void rotateRight(Node<K,E> root) {
		Node<K,E> temp = root.getLeftSon().getRightSon();
		root.getLeftSon().setRightSon(root);
		root.getLeftSon().setFather(root.getFather());
		root.setFather(root.getLeftSon());
		root.setLeftSon(temp);
	}

	public Node<K,E> getRoot(){
		return root;
	}

	public void setRoot(Node<K,E> root) {
		this.root = root;
	}
}
