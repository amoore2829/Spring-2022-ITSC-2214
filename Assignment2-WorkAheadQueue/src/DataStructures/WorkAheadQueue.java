package DataStructures;

import java.util.ArrayList;

import ADTs.WorkAheadQueueADT;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;

/**
* Class that implements workaheadqueueAdT
*/
public class WorkAheadQueue<T> implements WorkAheadQueueADT<T> {

    /**
    *front of node
    */
    protected SinglyLinkedNode<T> front;

    /**
    *back of node
    */
    protected SinglyLinkedNode<T> back;

    /**
    *first three nodes
    */
    protected ArrayList<SinglyLinkedNode<T>> frontThreeNodes;

    /**
    *first three elements
    */
    protected ArrayList<T> frontThreeElements;

    /**
    *number of total nodes
    */
    protected int numNodes;
    /**
    *constructor taking in no arguments
    */
    public WorkAheadQueue() {

        front = back = null;
        numNodes = 0;
        frontThreeNodes = new ArrayList<SinglyLinkedNode<T>>();
        frontThreeElements = new ArrayList<T>();

    }

    @Override public T dequeue(int x)throws EmptyCollectionException, InvalidArgumentException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty collection");

        }

        if (x >= 5 || x >= size()) {
            throw new InvalidArgumentException("Invaid index");
        }


        SinglyLinkedNode<T> curr = front;
        T temp = null;
        if (x == 0) {
            return dequeue();
        }
        for (int i = 0; i < x; i++) {

            if (i == x - 1) {

                temp = curr.getNext().getElement();
                curr.setNext(curr.getNext().getNext());
                numNodes--;
                
            }

            curr = curr.getNext();

        }

        frontThreeNodes = getFrontThreeNodes();
        frontThreeElements = getFrontThreeElements();

        return temp;

   

    }

    @Override public ArrayList<T> firstThreeElements()throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("firstThreeElements(): empty queue");
        }



        return getFrontThreeElements();
    }

    @Override public ArrayList<SinglyLinkedNode<T>> firstThreeNodes()throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("firstThreeElements(): empty queue");
        }
        

        return getFrontThreeNodes();
    }

    @Override public T first(int x)throws EmptyCollectionException, InvalidArgumentException {

        if (x >= 5 || x >= size()) {
            throw new InvalidArgumentException("out of bounds");
        }
        SinglyLinkedNode<T> curr = front;
        for (int i = 0; i <= x; i++) {
            if (i == x) {
                return curr.getElement();
            }
            curr = curr.getNext();
        }
        return null;
    }

    @Override public T first()throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("Collection is empty");
        }

        return front.getElement();
    }

    @Override public T dequeue()throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Empty collection");
        }

        T temp;
        if (this.front == null) {
            throw new EmptyCollectionException("empty");
        } else {

            temp = front.getElement();
            SinglyLinkedNode<T> nodeTemp = front;


            front = nodeTemp.getNext();
            numNodes--;
            


        }

        frontThreeNodes = getFrontThreeNodes();
        frontThreeElements = getFrontThreeElements();

        return temp;


    }

    @Override public void enqueue(T element) {

        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>(element);


        if (isEmpty()) {
            front = temp;
            back = temp;
        } else {
            back.setNext(temp);
            back = temp;
        }

        frontThreeNodes = getFrontThreeNodes();
        frontThreeElements = getFrontThreeElements();

        numNodes++;

    }

    @Override public boolean isEmpty() {
        return numNodes == 0;
    }

    @Override public int size() {
        return numNodes;
    }

    



        /**
    * gets the front three elements of the list
    * @return ArrayList of the first three elements
    */
    public ArrayList<T> getFrontThreeElements() {
        frontThreeElements.clear();
        SinglyLinkedNode<T> temp = front;

        for (int i = 0; i < 3 && i < size(); i++) {
            frontThreeElements.add(i, temp.getElement());
            temp = temp.getNext();
        }

        return frontThreeElements;

    }

    /**
    *gets the front three nodes of the list
    * @return ArrayList of the first three nodes
    */
    public ArrayList<SinglyLinkedNode<T>> getFrontThreeNodes() {
        frontThreeNodes.clear();
        SinglyLinkedNode<T> temp = front;
        
        for (int i = 0; i <= 2 && (i < size()); i++) {
            frontThreeNodes.add(i, temp);
            temp = temp.getNext();
        }

        return frontThreeNodes;
    }


    
}