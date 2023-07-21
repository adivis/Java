package programs.Hashing;

import java.util.HashMap;

public class findItinerary {

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> tofrom = new HashMap<>();
        for (String key : tickets.keySet()) {
            tofrom.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!tofrom.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();

        tickets.put("chennai", "bengaluru");
        tickets.put("mumbai", "delhi");
        tickets.put("goa", "chennai");
        tickets.put("delhi", "goa");

        String start = getStart(tickets);
        System.out.println(start);
        for (String key : tickets.keySet()) {
            System.out.println(tickets.get(start));
            start = tickets.get(start);
        }
    }
}
