import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class May {
    public boolean canConstruct(String r, String m) {
        int[] i = new int[256];
        for(char c : m.toCharArray()) {
            i[c]++;
        }
        for(char c: r.toCharArray()) {
            if(--i[c] < 0) return false;
        }


        return true;
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> jewel = new HashSet<>();

        for(char c : J.toCharArray()){
            jewel.add(c);
        }
        int i = 0;
        for(char c : S.toCharArray()){
            if(jewel.contains(c)) {
                i++;
            }
        }
        return i;
    }

    class Trie {

        /** Initialize your data structure here. */
        public boolean end;
        public HashMap<Character,Trie> map;
        public Trie() {
            end = false;
            map = new HashMap<>();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie current = this;
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(current.map.containsKey(c)) {
                    current = current.map.get(c);
                }
                else {
                    current.map.put(c, new Trie());
                    current = current.map.get(c);
                }
                if(i == word.length() - 1) {
                    current.end = true;
                }
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie current = this;
            for(char c : word.toCharArray()) {
                if(!current.map.containsKey(c)){
                    return false;
                }
                current = current.map.get(c);
            }
            return current.end;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie current = this;
            for(char c : prefix.toCharArray()) {
                if(!current.map.containsKey(c)){
                    return false;
                }
                current = current.map.get(c);
            }
            return true;
        }
    }

}
