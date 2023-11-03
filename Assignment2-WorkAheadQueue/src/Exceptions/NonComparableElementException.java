
package Exceptions;

/**
 * Exception class for comparing collection elements that haven't
 * implemented Comparable (and don't have a compareTo(..) method)
 * 
 * @author clatulip
 */
public class NonComparableElementException extends Exception {

    public NonComparableElementException(String collection) {
        super("The element passed in to " + collection + " does not implement Comparable.");
    }

}
