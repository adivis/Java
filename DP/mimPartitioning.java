package Java.DP;
public class mimPartitioning {
    /*
     * diff after partition is min
     * numbers[] = {1,6,11,5}
     * {1,6} {11,5} - 7
     * {1,11} {6,5} -  1
     * sum1 and sum2
     * total sum = sum
     * sum1 = sum/2 and sum2 = sum/2 - ideal situation
     * -this is what we should achieve
     * basically decide set1 and the set2 will automatically be decided
     * so try to achieve set1 whose sum is sum/2
     * so this is a knapsack problem with capacity sum/2 - variation of 0-1 knapsack
     * every elem has 2 set to be included or excluded
     * dp[n+1][w+1] w=sum/2 n = tot elem
     * 1. find sum
     * 2. dp[n+1][w+1]
     * 3. knapsack 0-1
     * 
     */
    public static int minPartition(int arr[]){
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int W = sum/2;
        int dp[][] = new int[n+1][W+1];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < W+1; j++) {
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][W];
        int sum2 = sum  - sum1;
        return Math.abs(sum1 - sum2);
    }
    public static void main(String[] args) {
        int arr[] = {1,6,11,5};
        System.out.println(minPartition(arr));
    }
}
