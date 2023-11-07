public class WildcardMatching {
    /*
     * given a text and wildcaard pattern, find if wildcard pattern is matched with
     * text.
     * 
     * ? - matches any single char
     * * - match any seq of chara
     * 
     * text - baaabab
     * pattern****ba****ab
     * output - tue
     * text - baaabab
     * pattern - a*ab
     * op - false
     * since patterns starts with a but text with b
     */

    public static boolean isMatch(String s, String p, int n, int m) {
        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

        String s = "baaabab";
        String p = "a**ab";
        System.out.println(isMatch(s, p, s.length(), p.length()));
    }
}