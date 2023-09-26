public class MatrixChainMultipl {
    public static int mcm(int a[], int i, int j){
        if(i==j)
        return 0;

        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j-1; k++) {
            int cost1 = mcm(a, i, k);
            int cost2 = mcm(a, k+1, j);
            int cost3 = a[i-1]*a[k]*a[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }
    public static void main(String[] args) {
        int a[] = {1,2,3,4,3};
        System.out.println(mcm(a, 1, a.length-1));
    }
}
