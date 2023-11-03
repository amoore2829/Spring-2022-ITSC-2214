public class Student implements Comparable <Student> {
    public String name;
    public char grade;
    
    @Override
    public int compareTo(Student other) {
        if(this.grade < other.grade) {
            return 1;
        }
        else if(this.grade > other.grade) {
            return -1;
        }
        else 
        {
        if(this.name.toUpperCase().charAt(0) < other.name.toUpperCase().charAt(0)) {
        return 1;
        }
        else if(this.name.toUpperCase().charAt(0) > other.name.toUpperCase().charAt(0)) {
        return -1;
        }
        else {
            return 0;
        }
        }
        
    }
}   
