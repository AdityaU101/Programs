import java.util.ArrayList;

public class UniqueMorseCode {
    public int uniqueMorseRepresentations(String[] words) {
        ArrayList<String> a= new ArrayList<>();
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for (String str : words) {
            char[] c = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char x : c) {
                sb.append(codes[x-'a']);
            }
            if(!a.contains(sb.toString())) a.add(sb.toString()); 
        }
        return a.size();
    }
}
