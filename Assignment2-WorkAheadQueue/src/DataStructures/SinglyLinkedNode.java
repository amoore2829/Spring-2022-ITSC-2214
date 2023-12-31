
package DataStructures;

/**
 * A simple Linear Node for use in linked structures such as lists
 * 
 * @author clatulip
 */
public class SinglyLinkedNode<T> {
    /**
    * Creates a single empty node called next
    */
    private SinglyLinkedNode<T> next;
    /**
    * Creates a data type paramater named element
    */
    private T element;

    /**
     * Default constructor creates an empty node
     */
    public SinglyLinkedNode() {
        super();
    }

    /**
     * Creates a node containing element
     * 
     * @param elem element to be stored
     */
    public SinglyLinkedNode(T elem) {
        next = null;
        element = elem;
    }

    /**
     * Gets the node that follows this one
     * 
     * @return next linear node
     */
    public SinglyLinkedNode<T> getNext() {
        return next;
    }

    /**
     * Sets the node that follows this one
     * 
     * @param n LinearNode to follow this one
     */
    public void setNext(SinglyLinkedNode<T> n) {
        next = n;
    }

    /**
     * Returns the element stored in this node
     * 
     * @return element stored in the node
     */
    public T getElement() {
        return element;
    }
    /**
    * Sets the element to be stored in this node
    * @param elem to be set
    */
    public void setElement(T elem) {
        element = elem;
    }

    @Override
    public String toString() {
        return "{el=" + element + ", next=" + next + "}";
    }
}
