public class LIS {

    private int lis(int[] nums){
        // Dynamic Programming array to store the length of LIS ending at each index.
        int[] dp = new int[nums.length];
        // The LIS for the first element is always 1.
        dp[0] = 1;    
        
        // Variable to keep track of the maximum length of LIS found so far.
        int maxLength = 1;
        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) { 
            // Initially, set the LIS ending at index i as 1 (the element itself).
            dp[i] = 1; 
            // Check with all elements before the current element.
            for (int j = 0; j < i; j++)   
                // If current element is greater than the previous element and
                // the LIS at current index is not longer than LIS at previous index.
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    // Update the LIS length for current index.
                    dp[i] = dp[j] + 1;  
                    // Update the overall maximum LIS length.
                    maxLength = max(maxLength, dp[i]);
                }
        } 
        // Return the maximum LIS length found.
        return maxLength;
    }
    
    private static int max (int a, int b){
        // Return the larger of a and b
        if (a > b){
            return a;
        } else {
            return b;
        }
     }



  
    public static void main(String[] args) {
      LIS l = new LIS();
      int[] nums = {4,2,3,6,10,1,12};
      System.out.println(l.lis(nums));
      nums = new int[]{-4,10,3,7,15};
      System.out.println(l.lis(nums));
    }
  }