public class countBST {
    /*
     *  find all possible BST formed from the given nodes
     * [10, 20]
     *   20   and 10
     *  /           \
     * 10           20
     * only 2
     */

     public static int countingBST(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                int leftsubtree = dp[j];
                int rightsubttree = dp[i-j-1];
                dp[i] +=leftsubtree*rightsubttree;
            }
        }
        return dp[n];
     }
    public static void main(String[] args) {
        System.out.println(countingBST(3));
    }
}
