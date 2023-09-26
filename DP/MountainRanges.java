public class MountainRanges {
    /*
     * given upstoke and downstoke find number of mountain ranges
     * 
     */
    public static int mountainRanges(int n){//O(n^2)
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            //-> i pairs->mountain ranges=>Ci
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] +=inside*outside;
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(mountainRanges(n));
    }
}
