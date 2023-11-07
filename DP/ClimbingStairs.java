import java.lang.reflect.Array;
import java.util.Arrays;

public class ClimbingStairs {
    /*
     * count ways to reach nth stairs.
     * the steps can be 1 or 2 stairs only
     * //O(n)
     */
    public static int countWays(int n, int f[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (f[n] != -1) {
            return f[n];
        }
        f[n] = countWays(n - 1, f) + countWays(n - 2, f);
        return f[n];

    }

    public static int countWaysTabulation(int n) {
        int ways[] = new int[n + 1];

        ways[0] = 1;
        for (int i = 1; i < ways.length; i++) {
            if (i == 1) {
                ways[i] = ways[i - 1];
            } else {
                ways[i] = ways[i - 1] + ways[i - 2];
            }
        }

        return ways[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int f[] = new int[n + 1];

        Arrays.fill(f, -1);
        System.out.println(countWays(5, f));
        System.out.println(countWaysTabulation(5));
    }
}
