public class KnapSack {
    public static void main (String[] args){
        int [][] arr = {{2,1,3,2},{12,10,20,15}};
        int Tweight = 5;
       System.out.print( knapSack(arr, Tweight));
    }
private static int knapSack(int[][] arr,int Tweight){
    int n = arr[0].length;
    int[] weight = arr[0];
    int[] value = arr[1];
    int[][] dp = new int[n + 1][Tweight + 1];
    Pointer [][] backTrack = new Pointer [n+1] [Tweight + 1];
    // Initialize the first row and first column to 0
    for (int i = 0; i <= n; i++) {
        dp[i][0] = 0;
    }
    for (int j = 0; j <= Tweight; j++) {
        dp[0][j] = 0;
    }

    // Build the dp table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= Tweight; j++) {
            if (weight[i - 1] <= j) {
                dp[i][j] = max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
                if (dp[i][j] == value[i - 1] + dp[i - 1][j - weight[i - 1]]){
                    backTrack[i][j] = new Pointer(i-1, j- weight[i-1]);
                }
                else{
                    backTrack[i][j]= new Pointer(i-1,j);
                }
            } else {
                dp[i][j] = dp[i - 1][j];
                backTrack[i][j]= new Pointer(i-1,j);
            }
        }
    }
    int i = arr[0].length; int j = Tweight;
    System.out.print("The elements taken are : ");
    while (i>0 && j >0){
        Pointer p = backTrack[i][j];
        int prevI = p.getI(); int prevJ = p.getJ();
        if (prevJ< j){
            System.out.print(i + " ");
        }
        i = prevI;
        j = prevJ;

    }


    System.out.println();
    return dp[n][Tweight];
}

private static int max (int a, int b){
    // Return the larger of a and b
    if (a > b){
        return a;
    } else {
        return b;
    }
 }


}
