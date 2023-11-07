public class minArraysJumps {
    /*
     * given an array each elem represent the max steps you can take from that elem
     * int arr[] = 2,3,1,1,4
     * find the min jumps
     * take one jump from 1st elem that is 2
     * take three jump(max) from 2nd elem that is 3
     * we will reach the end
     * ans - min jumps = 2
     *       /\
     *  /\  /  \
     * /  \/    \
     * 2   3 1 1 4
     * 0->n-1 (n)
     * 1->n-1  (n-1)
     * 2->n-1 (n-2)....
     * n-2->n-1(1)
     * destination is same but starting point is diff
     * dp[i] = i->n-1 min jumps
     * dp[n-1] = 0(n-1->n-1 is 0)
     * we will use tabulation
     * 
     */

     public static int minArrJumps(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[n-1] = 0;
        for(int i=0;i<n-1;i++){
            dp[i] = -1;
        }

        for (int i = n-2; i >=0; i--) {
           int steps = arr[i];
           int ans = Integer.MAX_VALUE;
           for (int j = i+1; j <=i+steps&&j<n; j++) {
            if(dp[j]!=-1){
                ans = Math.min(ans, dp[j]+1);
            }
           }
           if(ans!=Integer.MAX_VALUE){
            dp[i] = ans;
           }
        }
       
        return dp[0];

     }
    public static void main(String[] args) {
        int arr[] = {2,3,1,1,4};
        System.out.println(minArrJumps(arr));
    }
}
