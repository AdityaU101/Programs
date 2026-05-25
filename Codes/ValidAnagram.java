import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] x = s.toCharArray();
        char[]y = t.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }
}
