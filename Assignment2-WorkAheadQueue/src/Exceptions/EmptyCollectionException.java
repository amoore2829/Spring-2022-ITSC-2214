package Exceptions;

/**
 * An Empty Collection Exception class Prints out what type of collection is
 * empty For use in ITCS 2214 Data Structures and Algorithms UNC Charlotte, 2016
 * 
 * @author clatulip
 */
public class EmptyCollectionException extends Exception {

/**
* Exception that throws if the collection is empty
*/
    public EmptyCollectionException() {
        super("The collection is empty.");
    }

/**
* Exception that throws if the String collection is empty
* @param collection that is checked
*/
    public EmptyCollectionException(String collection) {
        super("The " + collection + " is empty.");
    }

}
