package DataStructures;

import ADTs.*;
import Exceptions.*;

/**
 *
 * @author ITCS2214
 */
public class LinkedQueue<T> implements QueueADT<T> {

    SinglyLinkedNode<T> front, rear;
    int count;
    // Initializes the data member variables front, rear and count
    public LinkedQueue() {
        
        front = rear = null;
        count = 0;
    }

    @Override
    public void enqueue(T element) {
        // TODO add a node which holds given element to the rear of queue. For example,
        // Create a new singly linear node, holding the reference to given element
        // if queue is empty, set front and rear to temp node. Or else
        // -set the next reference of the rear node to the new node
        // -set rear to point to the new node
        // Increment count

    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Queue [first()]");
        }
        return front.getElement();
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        // TODO remove node in the front of queue and return its held element. For
        // example,
        // If queue is empty, throw an EmptyCollectionException exception.
        // Declare a temporary node, temp and set it to be the same as front
        // Set front to the node next to the front
        // if queue is empty, set rear to null.
        // Decrease count
        // Return the data element of them temporary node
        throw new EmptyCollectionException();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0 ? true : false;
    }

    @Override
    public int size() {
        return this.count;
    }
}
