public class Hanoi {

   public static void main (String[] args){
       Hanoi h = new Hanoi();
       h.move(5,1,2,3);
   }

    public void moveOneDisk(int i, int j) {
        System.out.println("move from " + i + " to " + j);

    }

    public void move(int n, int s, int e, int m) {
        if (n == 0) return;

        else {
            move(n - 1, s, m, e);
            moveOneDisk(s, e);
            move(n - 1, m, e, s);
        }


    }
}
