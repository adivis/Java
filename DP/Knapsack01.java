public class Knapsack01 {
    public static int knapsack(int val[], int wt[], int dp[][], int w, int n) {// O(2^n) recursion
        if (w == 0 || n == 0) {
            return 0;
        }
        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // include
            int ans1 = val[n - 1] + knapsack(val, wt, dp, w - wt[n - 1], n - 1);
            // exclude
            int ans2 = knapsack(val, wt, dp, w, n - 1);

            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];

        } else {
            dp[n][w] = knapsack(val, wt, dp, w, n - 1);
            return dp[n][w];

        }
    }

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];

                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        printDP(dp);
        return dp[n][W];
    }

    public static void printDP(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        int dp[][] = new int[wt.length + 1][w + 1];

        // i is number and j is tot weight
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack(val, wt, dp, w, wt.length));
        System.out.println(knapsackTabulation(val, wt, w));
    }
}
