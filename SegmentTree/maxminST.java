package SegmentTree;

public class maxminST {
    /*
     * output max/min for subarrary[i,j]
     * update the elem at idx
     */
    static int tree[];
    public static void init(int n){
    tree = new int[4*n];
}
//o(n)
public static void buildMaxST(int arr[], int i, int start, int end){
    if(start==end){
        tree[i] = arr[start];
        return ;
    }

    int mid = (start+end)/2;
    //left subtree
    buildMaxST(arr, 2*i+1, start, mid);
    //right subtree
    buildMaxST(arr, 2*i+2, mid+1, end);
    //root
    tree[i] = Math.max(tree[2*i+1],tree[2*i+2]);
    
}
public static int getMaxUtil(int i, int si, int sj, int qi, int qj){
    if(qi<si||qj>sj){
        return Integer.MIN_VALUE;
    }else if(si>=qi&&sj<=qj){
        return tree[i];
    }else{
        int mid = (si+sj)/2;
        int left = getMaxUtil(2*i+1, si, mid, qi, qj);
        int right = getMaxUtil(2*i+2, mid+1, sj, qi, qj);
        return Math.max(left,right);
    }
}
public static int getMax(int arr[], int qi, int qj){
return getMaxUtil(0, 0, arr.length-1, qi, qj);
}
public static void updateUtil(int i, int si, int sj, int idx, int newVal){
    if(idx>sj||idx<si){
        return;
    }
    tree[i]=Math.max(tree[i], newVal);
    if(si!=sj)//non-leaf
       
    {
        int mid = (si+sj)/2;
        updateUtil(2*i+1, si, mid, idx, newVal);
        updateUtil(2*i+2, mid+1, sj, idx, newVal);
    }
    }
    public static void Update(int arr[], int idx, int newVal){
       
        arr[idx] = newVal;

        //segment tree updation
        updateUtil(0, 0, arr.length-1, idx, newVal);
    }

    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildMaxST(arr, 0, 0, n-1);
        // for (int i = 0; i < tree.length; i++) {
        //     System.out.print(tree[i]+" ");
        // }
        int max = getMax(arr, 2, 5);
        System.out.println(max);
    }
}
