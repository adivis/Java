package programs.Hashing;

import java.util.TreeMap;;

public class TreeMapClass {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("india", 10);
        tm.put("ia", 10);
        tm.put("ndia", 10);
        tm.put("dia", 10);
        System.out.println(tm);
    }
}
