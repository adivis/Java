public class EditDistance {
    /*
     * min number to convert word1 to word2
     * 1. insert a character
     * 2.delete a ""
     * 3. replace a ""
     * word1 = intention word2=execution ans = 5
     * inention
     * enention
     * exention
     * exection
     * execution
     * same as LCS
     * 
     */

    public static int editDist(String s1, String s2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (s1.charAt(n - 1) == s2.charAt(n - 1)) {
            return editDist(s1, s2, n - 1, m - 1);
        } else {
            // add
            int add = editDist(s1, s2, n - 1, m) + 1;
            int delete = editDist(s1, s2, n, m - 1) + 1;
            int replace = editDist(s1, s2, n - 1, m - 1) + 1;

            return Math.min(add, Math.min(delete, replace));
        }
    }

    /*
     * 
     * 0
     * 1
     * 2
     * 3
     * case for i&j==0{
     * if my string is empty and the string to convert is of size 1,2,3 then add
     * 1,2,3 in the empty
     * if my string is 1,2,3 and the string to convert is of size 0 then delete
     * 1,2,3 in the empty
     * }
     * 
     */

    public static int editDistTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = dp[i - 1][j] + 1;
                    int delete = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(add, Math.min(delete, replace));
                }
            }

        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution";
        System.out.println(editDist(s1, s2, s1.length(), s2.length()));
        System.out.println(editDistTabulation(s1, s2));
    }
}
