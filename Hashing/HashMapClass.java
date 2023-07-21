package programs.heap_and_PQ;

import java.util.*;

public class HashMapClass {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        // O(1)
        hm.put("India", 50);
        hm.put("USA", 5);
        hm.put("China", 500);
        hm.put("Bhutan", 10);

        // System.out.println(hm);
        // // O(1)
        // System.out.println(hm.remove("China"));
        // System.out.println(hm.remove("Ind"));
        // // O(1)
        // System.out.println(hm.containsKey("China"));
        // System.out.println(hm.size());
        // hm.clear();
        // System.out.println(hm.isEmpty());

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Keys=" + k + "\tValues=" + hm.get(k));
        }
    }
}
