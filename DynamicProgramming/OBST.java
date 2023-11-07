public class OBST {

    // O(n^3) - Total runtime complexity of optimalSearchTree method
    static int optimalSearchTree(int keys[], int freq[], int n) {

        // O(n) - Initializing the 2D array 'cost'
        int cost[][] = new int[n + 1][n + 1];

        // O(n) - Initializing the diagonal elements of 'cost' array
        for (int i = 0; i < n; i++)
            cost[i][i] = freq[i];

        // O(n^3) - Triple nested loops contribute to cubic runtime
        for (int L = 2; L <= n; L++) {

            // O(n) - Outer loop for the length of the sequence
            for (int i = 0; i <= n - L + 1; i++) {

                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int off_set_sum = sum(freq, i, j); // O(n) - Called within the second loop

                // O(n) - Innermost loop
                for (int r = i; r <= j; r++) {

                    // O(1) - Constant time calculations inside the loop
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + off_set_sum;
                    if (c < cost[i][j])
                        cost[i][j] = c;
                }
            }
        }
        return cost[0][n - 1];
    }

    // O(n) - Runtime complexity of sum method
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {

        // O(1) - Initialization of arrays and an integer
        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;

        // O(n^3) - Call to optimalSearchTree method
        System.out.println("Cost of Optimal BST is "
                + optimalSearchTree(keys, freq, n));
    }

}
