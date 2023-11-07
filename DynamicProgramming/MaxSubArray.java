public class MaxSubArray {

    public static void main(String[] args) {
        // O(1) - Initialization of a fixed-size array
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // O(n) - maxSubArraySum function call
        int[] result = maxSubArraySum(array);

        // O(1) - Printing a line
        System.out.println("Maximum contiguous sum is " + result[0]);

        // O(k) - Where k is the length of the subarray
        System.out.print("Subarray with maximum sum: ");
        for (int i = result[1]; i <= result[2]; i++) {
            System.out.print(array[i] + " ");
        }
        // Total run-time of the code is O(n) 
          
         
    }

    private static int[] maxSubArraySum(int[] a) {
        // O(1) - Initialization of variables
        int size = a.length;
        int globalMax = Integer.MIN_VALUE, localMax = 0;
        int start = 0, end = 0, s = 0;

        // O(n) - Loop over the array, where n is the length of the array
        for (int i = 0; i < size; i++) {
            localMax += a[i];

            // O(1) - Constant time checks and updates
            if (localMax > globalMax) {
                globalMax = localMax;
                start = s;
                end = i;
            }

            // O(1) - Another constant time check and update
            if (localMax < 0) {
                localMax = 0;
                s = i + 1;
            }
        }

        // O(1) - Returning an array of fixed size
        return new int[] {globalMax, start, end};
    }
}
