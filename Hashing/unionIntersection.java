package programs.Hashing;

import java.util.HashSet;

public class unionIntersection {
    public static void main(String[] args) {
        HashSet<Integer> union = new HashSet<>();

        int a[] = { 7, 3, 9 };
        int b[] = { 6, 3, 9, 2, 9, 4 };

        for (int i = 0; i < a.length; i++) {
            union.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            union.add(b[i]);
        }

        System.out.println(union);
        union.clear();
        for (int i = 0; i < a.length; i++) {
            union.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            if (union.contains(b[i])) {
                union.remove(b[i]);
                System.out.println(b[i]);
            }
        }

    }
}
