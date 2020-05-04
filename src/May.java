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
}
