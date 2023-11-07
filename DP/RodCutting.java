public class RodCutting {
    // weight = length , val =>price, w=>totRod
    public static int rotCut(int length[], int price[], int rodLength) {
        int n = length.length;
        int dp[][] = new int[n + 1][rodLength + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                int l = length[i - 1];
                int p = price[i - 1];

                if (l <= j) {
                    int incProfit = p + dp[i][j - l];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][rodLength];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = 8;
        System.out.println(rotCut(length, price, rodLength));
    }
}
