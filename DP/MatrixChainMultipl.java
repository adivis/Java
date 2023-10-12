import java.util.Arrays;

public class MatrixChainMultipl {
    //recursion
    public static int mcm(int a[], int i, int j){
        if(i==j)
        return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm(a, i, k);
            int cost2 = mcm(a, k+1, j);
            int cost3 = a[i-1]*a[k]*a[j];//big solution
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }
    public static int mcmMemo(int a[], int i, int j, int dp[][]){
        if(i==j)
        return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm(a, i, k);
            int cost2 = mcm(a, k+1, j);
            int cost3 = a[i-1]*a[k]*a[j];//big solution
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        dp[i][j] = ans;
        return dp[i][j];
    }
    public static int mcmTabulation(int a[]){
        int dp[][] = new int[a.length][a.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        
        
      for (int len = 2; len < dp.length; len++) {
         for (int i = 1; i <=dp.length-len; i++) {
          int j = i+len-1;
          dp[i][j] = Integer.MAX_VALUE;
          for (int k = i; k <j; k++) {
            int cost1 = dp[i][k];
            int cost2 = dp[k+1][j];
            int cost3 = a[i-1]*a[j]*a[k];
                        int finalCost = cost1+cost2+cost3;

            dp[i][j] = Math.min(dp[i][j], finalCost);
          }
         }
      }
      return dp[1][dp.length-1];
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,3};
        int n = a.length;
        int dp[][] = new int [n][n];
        for (int i = 0; i < dp.length; i++) {
            
            Arrays.fill(dp[i],-1);
        }
        System.out.println(mcm(a, 1, a.length-1));
        System.out.println(mcmMemo(a, 1, a.length-1, dp));
        System.out.println(mcmTabulation(a));
    }
}
