import java.util.HashMap;

public class LargestSubArray {
    // Largest subarray whose sum is zero

    public static void main(String[] args) {// O(n)
        HashMap<Integer, Integer> hm = new HashMap<>();// <sum, idx>

        int sum = 0;
        int len = 0;

        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (hm.containsKey(sum)) {
                len = Math.max(len, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }
        }

        System.out.println(len);
    }
}
