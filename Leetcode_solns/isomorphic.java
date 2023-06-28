import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class isomorphic {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
		Set<Character> uc = new HashSet<>();
        if(s.length()!=t.length()) return false;
		for(int i=0;i<s.length();i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if(map.containsKey(cs)){
				if(map.get(cs)!=ct) return false;
			}
			else {
				if(uc.contains(ct)) return false;
				map.put(cs,ct);
				uc.add(ct);
			}
		}
		return true;
    }
}
