public class Editdistance {
 
    public static void main (String[] args){
        Editdistance edit = new Editdistance();
         // Test case 1: Different strings
         System.out.println("Edit Distance (horse, ros): " + edit.ed("horse".toCharArray(), "ros".toCharArray()));

         // Test case 2: Identical strings
         System.out.println("Edit Distance (abcd, abcd): " + edit.ed("abcd".toCharArray(), "abcd".toCharArray()));
 
         // Test case 3: Empty strings
         System.out.println("Edit Distance (, ): " + edit.ed("".toCharArray(), "".toCharArray()));
 
         // Test case 4: One empty string
         System.out.println("Edit Distance (abcd, ): " + edit.ed("abcd".toCharArray(), "".toCharArray()));
 
         // Test case 5: No common characters
         System.out.println("Edit Distance (abcd, efgh): " + edit.ed("abcd".toCharArray(), "efgh".toCharArray()));
     
    }
private  int ed(char[] string1, char[] string2){
    int n = string1.length;
    int m = string2.length;
    int [][] dp = new int[n+1][m+1];
    Pointer [][] backTrack = new Pointer[n+1][m+1];
    for (int i = 0; i <= n; i++) {
        dp[i][0] = i;
    }
    for (int j = 0; j <= m; j++) {
        dp[0][j] = j;
    }
    for (int i = 1; i<=n; i ++){
        for (int j = 1 ; j<=m ; j ++){
           if (string1[i-1] == string2[j-1]){
                dp[i][j] =  dp[i-1][j-1];
        
            }
            else{
                int minVal = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                dp[i][j] =  1 +  minVal;
                if (minVal == dp[i - 1][j]) {
                    backTrack[i][j] = new Pointer(i - 1, j, "delete");
                } else if (minVal == dp[i][j - 1]) {
                    backTrack[i][j] = new Pointer(i, j - 1, "insert");
                } else {
                    backTrack[i][j] = new Pointer(i - 1, j - 1, "substitute");
                }
            }
        }
     
        
    }
    return dp[n][m];
  


}
private static int min(int a, int b, int c){
int min = a;


if (b < min) {
    min = b;
}


if (c < min) {
    min = c;
}

return min;
}
}
