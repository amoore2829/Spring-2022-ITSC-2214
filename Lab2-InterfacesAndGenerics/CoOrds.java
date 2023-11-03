public class CoOrds implements Comparable <CoOrds> {
    public int x;
    public int y;
    
    @Override
    public int compareTo(CoOrds other) {
        if(this.x < other.x) {
            return -1;
        }
        else if(this.x > other.x) {
            return 1;
        }
        else if(this.x == other.x && this.y == other.y) {
            return 0;
        }
        else if(this.x == other.x) {
            if(this.y > other.y) {
                return 1;
            }
            else{
                return -1;
            }
        }
        return 8;
}
}

