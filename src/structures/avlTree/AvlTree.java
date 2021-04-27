package structures.avlTree;

import java.util.ArrayList;

public class AvlTree <K extends Comparable<K>,E> implements AvlTreeInterface<K,E>{

	
	private Node<K,E> root;
	
	public AvlTree() {
		this.root = null;
	}
	
	private int recalculateFactorBalances(Node<K,E> current) {
		if(current == null) {
			return 0;
		}
		int pLeft = maxDepth(current.getLeftSon());
		int pRight = maxDepth(current.getRightSon());
		int newBalance = pRight - pLeft;
		current.setBalanceFactor(newBalance);
		if(newBalance > 1 || newBalance < -1) {
			rebalance(current);
		}
		recalculateFactorBalances(current.getFather());
		return 0;
	}
	
	public int maxDepth(Node<K,E> node) {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.getLeftSon());
            int rDepth = maxDepth(node.getRightSon());
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
	
	@Override
	public void insert(K key, E element) {
		if(root == null) {
			root = new Node<K,E>(key,element);
			recalculateFactorBalances(root);
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
			recalculateFactorBalances(newNode);
		}else if(key.compareTo(current.getKey())<0 && current.getLeftSon() != null) {
			insert(current.getLeftSon(), key, element);
		}
		if(key.compareTo(current.getKey())>0 && current.getRightSon() == null) {
			Node<K,E> newNode = new Node<K,E>(key,element);
			current.setRightSon(newNode);
			newNode.setFather(current);
			recalculateFactorBalances(newNode);
		}else if(key.compareTo(current.getKey())>0 && current.getRightSon() != null) {
			insert(current.getRightSon(),key,element);
		}
	}

	@Override
	public ArrayList<E> delete(K key) {
		// TODO Auto-generated method stub
		return null;
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
		Node<K,E> temp = root.getRightSon().getLeftSon();
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

	@Override
	public void rebalance(Node<K, E> n) {
		//Caso A y Caso B
		if(n.getBalanceFactor() > 1 && (n.getRightSon().getBalanceFactor() == 0 || n.getRightSon().getBalanceFactor() == 1)) {
			rotateLeft(n);
		}
		
		//Caso C
		if(n.getBalanceFactor() > 1 && n.getRightSon().getBalanceFactor() == -1) {
			rotateRight(n.getRightSon());
			rotateLeft(n);
		}
		
		//Caso D y Caso E
		if(n.getBalanceFactor() < -1 && (n.getLeftSon().getBalanceFactor() == 0 || n.getLeftSon().getBalanceFactor() == -1)) {
			rotateRight(n);
		}
				
		//Caso F
		if(n.getBalanceFactor() < -1 && n.getLeftSon().getBalanceFactor() == 1) {
			rotateLeft(n.getLeftSon());
			rotateRight(n);
		}
	}

}
