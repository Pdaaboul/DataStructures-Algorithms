import java.util.Vector;

public class PalindromePartitionResult {
    public static void main(String[] args) {
        String s = "mabast";
        PalindromePartition pp = minPalindromePartition(s);
        System.out.println("Minimum splits needed: " + pp.splits);
        System.out.println("Partitions: " + pp.partitions);
    }

    static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    static PalindromePartition minPalindromePartition(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int[] split = new int[n];
        Vector<String> partitions = new Vector<>();

        for (int i = 0; i < n; i++) {
            dp[i] = i;
            split[i] = i;
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(s, j, i)) {
                    if (j == 0) {
                        dp[i] = 0;
                    } else if (dp[j - 1] + 1 < dp[i]) {
                        dp[i] = dp[j - 1] + 1;
                        split[i] = j;
                    }
                }
            }
        }


        int i = n - 1;
        while (i >= 0) {
            partitions.add(0, s.substring(split[i], i + 1));
            i = split[i] - 1;
        }

        return new PalindromePartition(dp[n - 1], partitions);
    }
}
