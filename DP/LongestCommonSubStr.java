public class LongestCommonSubStr {

    /*
     * s1 = "abcde" s2 = "abgce"
     * ans = "ab" = 2
     */

    public static int lcsTabulation(String s1, String s2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abgce";
        System.out.println(lcsTabulation(s1, s2, s1.length(), s2.length()));

    }
}
