import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class GaleShapley {
    int[][] Women;
    int[][] Men;
    int[] MM; // this array to keep track of the matched men
    int[] MW;
    int ArrLength;
    public GaleShapley(int[][] men, int[][] women){
        Women = women; // O(1)
        Men = men;     // O(1)
        ArrLength = men.length;  // O(1)
        MM = new int [ArrLength];  // O(1)
        MW = new int [ArrLength];  // O(1)
    }

    public void match() { // O(n^2)

        int counter = 0; // To keep track of the number of iterations

        int[][] W = swap(Women); // O(n^2)
        Queue<Integer> queue = new LinkedList<>(); // O(1)
        for (int i = 1; i < ArrLength + 1; i++) { // O(n)
            queue.add(i);  // O(1)

        }

        while (!queue.isEmpty()) {

            int i = queue.poll() - 1;  // O(1)

            for (int j = 0; j < ArrLength; j++) { // O(n)
                counter ++; // Increment the counter each time the loop runs
                int w = Men[i][j] - 1; // O(1)

                if((MM[i] == 0 ) && (MW[w] == 0)){// O(1)
                    MM[i] = w+1;// O(1)


                    MW[w] = i + 1;// O(1)

                    System.out.println("Matched " + (i+1) + " with " + (w+1));
                    break;
                }
                else if ((MM[i] ==0) && MW[w] !=0){// O(1)
                    int currentMan = MW[w] -1; // O(1)
                    if(W[w][currentMan] > W[w][i]){// O(1)

                        MM[currentMan] = 0;// O(1)

                        MM[i] = w + 1;// O(1)
                        MW[w] = i + 1;// O(1)
                        queue.add(currentMan + 1);// O(1)
                        System.out.println("Rematched " + (i+1) + " with " + (w+1));
                        queue.add(currentMan + 1);// O(1)
                        break;
                    }
                }
            }

        }
        System.out.println("Number of iterations: " + counter);
        System.out.println("MM array: " + Arrays.toString(MM));

    }
    public int [] [] swap(int[][] women){ // O(n^2)
        //this method swaps the rankings of the women's array, into their corresponding indices for a quicker access
        int[][] temp1 = new int [women.length][women.length];

        for (int i = 0; i< women.length; i ++ ){ // O(n)
            for (int j = 0; j < women.length; j ++){ // O(n)

                int x = women [i][j]; // O(1)

                temp1[i][x - 1] = j + 1;  // O(1)
            }
        }
        return temp1;  // O(1)
    }

    //In summary, the overall time complexity remains  O(n^2)


    public static void main (String[] args){
        System.out.println("input size of n=3 : ");
        int[][] menPreferences3 = {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };

        int[][] womenPreferences3 = {
                {3, 1, 2},
                {1, 2, 3},
                {2, 3, 1}
        };
        GaleShapley g3 = new GaleShapley(menPreferences3, womenPreferences3); //O(1)
        g3.match();  // O(n^2)

        System.out.println("input size of n= 5 : ");
        // Initializing variables here: O(1)
        int[][] menPreferences5 = {
                {4,2,3,1,5},
                {5,4,2,1,4},
                {2,5,1,4,3},
                {5,2,4,3,1},
                {4,1,2,3,5}
        };

        int[][] womenPreferences5 = {
                {4,2,5,3,1},
                {2,1,4,3,5},
                {1,3,5,4,2},
                {4,1,3,2,5},
                {2,5,1,3,4}
        };
        GaleShapley g5 = new GaleShapley(menPreferences5, womenPreferences5); //O(1)
        g5.match();   // O(n^2)

        System.out.println("input size of n=7 : ");

        int[][] menPreferences7 = {
                {2, 1, 7, 6, 5, 4, 3},
                {1, 7, 6, 5, 4, 3, 2},
                {7, 6, 5, 4, 3, 2, 1},
                {6, 5, 4, 3, 2, 1, 7},
                {5, 4, 3, 2, 1, 7, 6},
                {4, 3, 2, 1, 7, 6, 5},
                {4, 3, 1, 7, 6, 5, 4}
        };


        int[][] womenPreferences7 = {
                {7, 6, 5, 4, 3, 2, 1},
                {1, 7, 6, 5, 4, 3, 2},
                {2, 1, 7, 6, 5, 4, 3},
                {3, 2, 1, 7, 6, 5, 4},
                {4, 3, 2, 1, 7, 6, 5},
                {5, 4, 3, 2, 1, 7, 6},
                {6, 5, 4, 3, 2, 1, 7}
        };

        GaleShapley g7 = new GaleShapley(menPreferences7, womenPreferences7); //O(1)
        g7.match();//O(n^2)

    }

}
