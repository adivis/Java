import java.util.LinkedHashMap;

class LinkedHM {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 10);
        lhm.put("ndia", 50);
        lhm.put("dia", 12);
        System.out.println(lhm);
    }
}