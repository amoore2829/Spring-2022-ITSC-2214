package DataStructures;

import ADTs.StackADT;
import Exceptions.EmptyCollectionException;

import java.util.NoSuchElementException;

/**
 * An implementation of the stack interface using singly-linked nodes.
 */
public class LinkedStack<T> implements StackADT<T> {

    private SinglyLinkedNode<T> top = null;

    public void push(T item) {
        if (size() == 0) {
            top = new SinglyLinkedNode<T>(item);
        } else {
            SinglyLinkedNode<T> node = new SinglyLinkedNode<T>(item);
            node.setNext(top);
            
            top = node;
        }
    }

    public T pop() throws EmptyCollectionException {
        int count = size();

        if (count == 0) {
            throw new EmptyCollectionException();
        } else if (count == 1) {
            T elem = top.getElement();
            top = null;
            return elem;
        } else {
            T elem = top.getElement();
            top = top.getNext();
            return elem;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public T peek() {
        if (top == null) {
            throw new NoSuchElementException();
        }
        return top.getElement();
    }

    public int size() {
        int count = 0;
        for (SinglyLinkedNode<T> node = top; node != null; node = node.getNext()) {
            count++;
        }
        return count;
    }
}
