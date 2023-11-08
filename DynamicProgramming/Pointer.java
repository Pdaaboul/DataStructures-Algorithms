public class Pointer {
    private int i;
    private int j;

    
    public Pointer(int i, int j) {
        this.i = i;
        this.j = j;
    }
  
    public void setPointers(int x, int y){
        i = x;
        j = y;
    }
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
