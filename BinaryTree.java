import java.util.ArrayList;
import java.util.List;

/**
 * This class contains public methods to add, order and
 * remove nodes in a binary tree.
 * 
 * @author Johannes Millegard 2014
 */
public class BinaryTree {
    
    private Node root = null;
    private List<Integer> list = new ArrayList<Integer>();
    
    /**
     * Add an element to the binary tree with an element.
     * 
     * @param element The element of the node as an int
     */
    public void add(int element) {
    
        if (root == null) {
            root = new Node(element);
        }
    
        Node temp = root;
    
        while (temp != null) {
            
            if (element == temp.getElement()) {
                return;
            } 
            
            else if (element < temp.getElement()) {

                if (temp.getLeft() == null) {
                    temp.setLeft(new Node(element));
                    return;
                } 
                
                else {
                    temp = temp.getLeft();
                }
            } 
            
            else {

                if (temp.getRight() == null) {
                    temp.setRight(new Node(element));
                    return;
                } 
                
                else {
                    temp = temp.getRight();
                }
            }  
        }
    }
    
    /**
     * Clear the whole binary tree by 
     * removing the root node and clear the list.
     */
    public void clear() {
        root = null;
        list.clear();
    }
    
    /**
     * Searching for a specific element to see if its in the binary tree.
     * 
     * @param element The element we are searching for.
     * @return boolean true/false
     */
    public boolean contains(int element) {
        return contains(root, element);
    }
  
    /**
     * Private method to search for a specific node with an element.
     * 
     * @param p  the Node that is searched for
     * @param element  the element
     * @return boolean true/false
     */
    private boolean contains(Node p, int element) {
      
        if (p == null) {
            return false;
        }
        
        // the node value equals the element. return true.
        else if (element - p.getElement() == 0) {
            return true;
        }
    
        else if (element - p.getElement() < 0) {
            return contains(p.getLeft(), element);
        }
    
        else {
            return contains(p.getRight(), element);
        }
    }
    
    /** 
     * Visit the specific node and adds it to the list of nodes
     * 
     * @param p Node 
     */
    private void visit(Node p) {
        list.add(p.getElement());
    }
    
    /**
     * Puts the binary tree in order
     * 
     * @param p Node
     */
    public void inOrder(Node p) {
        
        if (p != null) {
            inOrder(p.getLeft());
            visit(p);
            inOrder(p.getRight());
        } 
    }

    /**
     * Puts the binary tree in post order
     * 
     * @param p Node
     */
    public void postOrder(Node p) {
        
        if (p != null) {
            postOrder(p.getLeft());
            postOrder(p.getRight());
            visit(p);
        }
    }
    
    /**
     * Puts the binary tree in preorder
     * 
     * @param p Node
     */
    public void preOrder(Node p) {

        if (p != null) {
            visit(p);
            preOrder(p.getLeft());
            preOrder(p.getRight());
        }
    }
    
    /**
     * Removes a specific element in the binary tree.
     * 
     * @param element Element
     */
    public void remove(int element) {
	root = remove(element, root);
    }

    /**
     * Removes a specific node in the binary tree.
     * 
     * @param p Node
     */
    private static Node remove(Node p) {
	
        if (p.getLeft() == null) {
	    return p.getRight();
        }
        
	else if (p.getRight() == null) {
	    return p.getLeft();
        }
        
        else {
	    p.setRight(remove(p.getRight(), p));
	    return p;
	}
    }
     
    /**
     * Search for a specific node with an element in the binary tree
     * and removes it.
     * 
     * @param element Element
     * @param p Node
     */
    private static Node remove(int element, Node p) {
        
	if (p == null) {
	    return null;
        }
        	
        else if (element - p.getElement() > 0) {
	    p.setRight(remove(element, p.getRight()));
	    return p;
	}
        
	else if (element - p.getElement() < 0) {
	    p.setLeft(remove(element, p.getLeft()));
	    return p;
	}
        
        else {
	    return remove(p);
        }
    }
    
    /**
     * Search for children node and returns it.
     * 
     * @param node  Node
     * @param p  Node
     * @return node Node
     */
    private static Node remove(Node node, Node p) {
	
        if (node.getLeft() == null) {
	    p.setElement(node.getElement());
	    return node.getRight();
	}
        
        else {
	    node.setLeft(remove(node.getLeft(), p));
	    return node;
	}
    }
    
    /** 
     * Returns the size of the tree.
     * 
     * @return Size
     */
    public int size() {
        return size(root);
    }
  
    /**
     * Search for how many nodes the tree contains of.
     * 
     * @param p Node
     * @return size
     */
    private static int size(Node p) {
        if (p == null) {
            return 0;
        } 
        
        else {
            int size = size(p.getRight()) + size(p.getLeft()) + 1;
            return size;
        }
    }
    
    /**
     * Returns an array of the tree in order.
     * @return array
     */
    public int[] inOrder() {
             
        list.clear();
        // placing the tree in order
        inOrder(root);
        
        // Convert arraylist to int array
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    /**
     * Returns an array of the tree in postOrder.
     * @return array
     */
    public int[] postOrder() {
             
        list.clear();
        // placing the tree in order
        postOrder(root);
        
        // Convert arraylist to int array
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }

        return array;
    }
 
    /**
     * Returns an array of the tree in preOrder
     * 
     * @return array
     */
    public int[] preOrder() {
               
        list.clear();
        // placing the tree in order
        preOrder(root);
        
        // Convert arraylist to int array
        int[] array = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        
        return array;
    }
    
    /**
     * Returns the whole binary tree as a sorted array
     * 
     * @return array Sorted Array
     */
    public int[] toArray() {
        
        list.clear();
        // placing the tree in order
        inOrder(root);
        
        // Convert arraylist to int array
        int[] array = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    /**
     * Returns the binary three as a string
     * 
     * @return toString  Sorted string
     */
    @Override
    public String toString() {
        
        list.clear();
        // placing the tree in order
        inOrder(root);
        
        return list.toString();
    }  
}
