/**
* Comparable.java is an Interface that implements the compareTo method
* @author Alex Moore
*/
public interface Comparable<T> {
    /**
    * Take an argument and compares it with another argument and returns an int based on the comparison
    * @param other datatype which is being compared to
    * @return int returns the value of the two objects being compared
    */
    public int compareTo(T other);
}
