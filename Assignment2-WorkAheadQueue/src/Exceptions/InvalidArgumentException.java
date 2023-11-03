package Exceptions;

/**
 * Exception handler for when an element isn't in a collection
 * 
 * @author clatulip
 */
public class InvalidArgumentException extends Exception {
/**
* Exception that throws when an invalid argument is received
* @param arg that is checked for validity
*/
    public InvalidArgumentException(String arg) {
        super("The argument " + arg + "was invalid.");
    }

}
