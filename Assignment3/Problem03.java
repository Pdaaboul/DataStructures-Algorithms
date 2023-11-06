import java.util.HashSet;

public class Problem03 {

    // O(n) - Overall runtime complexity of hasZeroSumSubsequence method
    static boolean hasZeroSumSubsequence(int[] A) {
        
        // O(1) - Initialization of cumSum and sumSet
        int cumSum = 0;
        HashSet<Integer> sumSet = new HashSet<>();

        // O(n) - Iterating through the array once
        for (int value : A) {
        
            // O(1) - Simple arithmetic operation
            cumSum += value;

            // O(1) - Checking cumSum and looking up in the hash set (average case)
            if (cumSum == 0 || sumSet.contains(cumSum)) {
                return true;  // Exiting early if condition is met
            }
            
            // O(1) - Adding to the hash set (average case)
            sumSet.add(cumSum);
        }
        
        // O(1) - Returning a boolean value
        return false;
    }

    public static void main(String[] args) {
        
        // O(1) - Initialization of the array A
        int[] A = {1, 2, -3, 3, 4};
       
        
        // O(n) - Calling the hasZeroSumSubsequence method
        System.out.println("Does the array have a zero-sum subsequence? " + hasZeroSumSubsequence(A));
    }
}
