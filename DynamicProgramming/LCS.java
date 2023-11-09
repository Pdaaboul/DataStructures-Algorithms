// LCS class for computing the Longest Common Subsequence
public class LCS {
    
    // Main method to run the program
    public static void main (String[] args){
        // Initialize two arrays for LCS calculation
        int[] arr1 = {1, 0, 1, 1, 1, 0, 0, 1};
        int[] arr2 = {0, 1, 0, 1, 1, 0, 0};

        // Print the length of the LCS
        System.out.print(lcs(arr1, arr2));
    }

    // Method to calculate the LCS length and print the sequence
    private static int lcs(int[] arr1, int[] arr2){
        // Lengths of the input arrays
        int n = arr1.length;
        int m = arr2.length;

        // dp array to store lengths of LCS at sub-problems
        int[][] dp = new int[n + 1][m + 1];

        // backTrack array to trace back the LCS
        Pointer[][] backTrack = new Pointer[n + 1][m + 1];

        // Iterating over each element of the arrays
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If elements match, increment the length of LCS
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    backTrack[i][j] = new Pointer(i - 1, j - 1);
                }
                else {
                    // If elements don't match, take the max from previous sub-problems
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                    // Update backTrack accordingly
                    if (dp[i][j] == dp[i - 1][j]) {
                        backTrack[i][j] = new Pointer(i - 1, j);
                    } else {
                        backTrack[i][j] = new Pointer(i, j - 1);
                    }
                }
            }
        }

        // Print the LCS in the correct order
        System.out.print("The LCS in correct order: ");
        printLCS(backTrack, arr1, n, m);
        System.out.println();

        // Return the length of the LCS
        return dp[n][m];
    }

    // Method to return the larger of two integers
    private static int max(int a, int b){
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // Recursive method to print the LCS using backTrack array
    private static void printLCS(Pointer[][] backTrack, int[] arr1, int i, int j) {
        // Base case: if either index reaches 0
        if (i == 0 || j == 0) {
            return;
        }

        // Retrieve the pointer from the backTrack array
        Pointer p = backTrack[i][j];

        // If both indices have changed, print the element from arr1
        if (p.getI() < i && p.getJ() < j) {
            printLCS(backTrack, arr1, p.getI(), p.getJ());
            System.out.print(arr1[i - 1] + " ");
        } else {
            // Continue backtracking without printing
            printLCS(backTrack, arr1, p.getI(), p.getJ());
        }
    }

    // Pointer class to hold the indices for backtracking
    static class Pointer {
        private int i, j;

        // Constructor to initialize i and j
        public Pointer(int i, int j) {
            this.i = i;
            this.j = j;
        }

        // Getter for i
        public int getI() {
            return i;
        }

        // Getter for j
        public int getJ() {
            return j;
        }
    }
}
