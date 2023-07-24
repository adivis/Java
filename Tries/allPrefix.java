package Tries;

public class allPrefix {
    // find the longest string whoes all prefix are there

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    static String ans = "";

    public static void longestWordWithPrefix(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                char ch = (char) (i + 'a');
                temp.append(ch);
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWordWithPrefix(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);// backtrack
            }
        }
    }

    public static void main(String[] args) {
        String word[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }

        longestWordWithPrefix(root, new StringBuilder(""));
        System.out.println(ans);

    }
}
