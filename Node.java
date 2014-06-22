/**
 * Node class with reference to the right and left node
 * and with a specific value.
 * 
 * @author Johannes Fag
 */

public class Node {
    
    private Node left;
    private Node right;
    private int element;
    
    /**
     * Constructor to store the int value to the Node object.
     * 
     * @param value 
     */
    public Node(int value) {
        this.element = value;
    }

    /**
     * Returns the left node in tree
     * 
     * @return Node Left node in binary tree
     */
    public Node getLeft() {
        return left;
    }
    
    /**
     * Sets the left node in tree
     * 
     * @param left Left Node in binary tree
     */
    public void setLeft(Node left) {
        this.left = left;
    }
      
    /**
     * Returns the right node in binary tree
     * 
     * @return Node Right node in binary tree
     */
    public Node getRight() {
        return right;
    }
    
    /**
     * Sets the right node in tree
     * 
     * @param right Right Node in binary tree
     */
    public void setRight(Node right) {
        this.right = right;
    }
    
    /**
     * Returns the element of the node object
     * 
     * @return the Element
     */
    public int getElement() {
        return element;
    }
    
    /**
     * Sets the element of the node object
     * 
     * @param element  Element of the node object
     */
    public void setElement(int element) {
        this.element = element;
    }
}
