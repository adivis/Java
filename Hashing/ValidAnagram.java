package programs.Hashing;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        HashMap<Character, Integer> hm = new HashMap<>();

        String s1 = "knae", s2 = "keen";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (hm.containsKey(ch)) {
                if (hm.get(ch) == 1)
                    hm.remove(ch);
                else
                    hm.put(ch, hm.get(ch) - 1);
            } else {
                break;
            }
        }

        if (hm.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
