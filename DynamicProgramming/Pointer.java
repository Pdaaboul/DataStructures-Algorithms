public class Pointer {
    private int i;
    private int j;
    String operation;
    
    public Pointer(int i, int j) {
        this.i = i;
        this.j = j;
    }
  public Pointer(int i,int j, String s){
    this.i = i;
    this.j = j;
    this.operation = s;
  }
    public void setPointers(int x, int y){
        i = x;
        j = y;
    }
    public int getI() {
        return i;
    }
    public String getOperation(){
        return operation;
    }

    public int getJ() {
        return j;
    }
}
