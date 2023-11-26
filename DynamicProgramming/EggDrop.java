

public class EggDrop {
    public static void main(String[] args) {
        int eggs = 5;
        int floors = 10;
        EggDrop p = new EggDrop();
        System.out.println("Solution:" + p.eggDrop(floors, eggs));
    }

    private int eggDrop(int egg, int floor) {
        int[][] dp = new int[egg + 1][floor + 1];


        for (int i = 1; i <= egg; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int j = 1; j <= floor; j++) {
            dp[1][j] = j;
        }


        for (int i = 2; i <= egg; i++) {
            for (int j = 2; j <= floor; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++) {
                    int res = 1 + max(dp[i - 1][k - 1], dp[i][j - k]);
                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }

        return dp[egg][floor];
    }


    private int max(int a, int b) {
        if (a>b){
            return a;
        }
        else{
            return b;
        }
    }
}
