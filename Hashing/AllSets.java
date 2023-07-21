package programs.Hashing;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class AllSets {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(2);

        set.add(1);
        set.add(2);
        set.add(4);
        // System.out.println(set);
        // set.clear();
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());

        // Iteration
        // Iterator it = set.iterator();

        // while (it.hasNext()) {
        // System.out.println(it.next());
        // }

        // for (Integer i : set) {
        // System.out.println(i);
        // }

        // LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        // lhs.add(2);

        // lhs.add(1);
        // lhs.add(2);
        // lhs.add(4);
        // System.out.println(lhs);

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(2);

        ts.add(1);
        ts.add(2);
        ts.add(4);
        System.out.println(ts);

    }
}
