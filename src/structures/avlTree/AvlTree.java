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
		current.setBalanceFactor(maxDepth(current.getLeftSon()) - maxDepth(current.getRightSon()));
		recalculateFactorBalances(current.getFather());
		return 0;
	}
	
	public int maxDepth(Node<K,E> node)
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.getLeftSon());
            int rDepth = maxDepth(node.getRightSon());
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        }
    }
	
	@Override
	public void insert(K key, E element) {
		recalculateFactorBalances(this.getRoot());
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
	
	public Node<K,E> getRoot(){
		return root;
	}
	
	public void setRoot(Node<K,E> root) {
		this.root = root;
	}

	@Override
	public structures.avlTree.Node<K, E> rotateLeft(structures.avlTree.Node<K, E> n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void rebalance(structures.avlTree.Node<K, E> n) {
		// TODO Auto-generated method stub
		
	}


	


	
	


}
