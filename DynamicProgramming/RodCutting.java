

public class RodCutting {
    
    // Main method: Entry point of the program
    public static void main (String[] args){
        // Initialize the prices matrix where the first row is lengths and the second row is prices
        int[][] matrix = {
            {1, 2, 3, 4, 5},  // Lengths of the rod pieces
            {1, 3, 4, 6, 9} // Prices of the rod pieces
        };
        
        // Perform the rod cutting dynamic programming algorithm
        int[][] rod = rodCutting(matrix);
        
        // Iterate over the DP matrix and print the optimal revenues for each sub-length
        for (int i = 0; i < rod.length; i++) {
            for (int j = 0; j < rod[i].length; j++) {
                System.out.print(rod[i][j] + " ");
            }
            System.out.println(); // Print a new line at the end of each row
        }
    }

    // RodCutting method: Calculates the optimal revenues using dynamic programming
    private static int[][] rodCutting(int[][] arr) {
        // Determine the size of the DP table
        int n = arr[0].length + 1;
        
        // Initialize the DP table with extra space for convenience
        int[][] rod = new int[n][n];
        Pointer[][] backTrack = new Pointer[n][n];
        // Initialize base cases: when the length of the rod is 0, the revenue is 0
        for (int i = 0; i < n; i++) {
            rod[0][i] = 0; // Revenue is 0 when length is 0
            rod[i][0] = 0; // Revenue is 0 when length is 0
        }

        // Fill up the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) { 
                // If the current piece size (i) is larger than the subproblem size (j), carry forward the previous value
                if (i > j) {
                    rod[i][j] = rod[i - 1][j];
                    backTrack[i][j] = new Pointer(i-1,j);
                } else {
                    // Check if the index is within the bounds of the price array
                    if (i-1 < arr[1].length) {
                        // Calculate the maximum revenue of cutting vs not cutting at this length
                        rod[i][j] = max(rod[i][j - i] + arr[1][i - 1], rod[i - 1][j]);
                        if (rod[i][j] == rod[i][j-1] + arr[1][i-1]){
                            backTrack[i][j] = new Pointer(i,j-i);
                        }
                        else{
                            backTrack[i][j]=new Pointer(i-1,j);
                        }
                    } else {
                        // If index out of bounds, carry forward the previous value
                        rod[i][j] = rod[i - 1][j];
                        backTrack[i][j]= new Pointer(i-1,j);
                    }
                }
            }
        }

        int i = n - 1, j = n - 1;
        System.out.println("Cuts made at lengths:");
        while (i > 0 && j > 0) {
        Pointer p = backTrack[i][j];
        int prevI = p.getI(), prevJ = p.getJ();

        if (prevJ < j) { // A cut was made at this length
        System.out.print(i); // Print the length where the cut was made
    }

    // Move to the previous position as indicated by the pointer
        i = prevI;
        j = prevJ;
}

System.out.println();
    
        


        // Return the completed DP table containing the optimal revenues
        return rod;
    }

    // max method: Utility to calculate the maximum of two integers
    private static int max (int a, int b){
        // Return the larger of a and b
        if (a > b){
            return a;
        } else {
            return b;
        }
     }
}
