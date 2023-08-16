import java.util.ArrayList;
import java.util.List;

public class ListSeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        String g=Character.toString(separator);
        ArrayList<String> ls = new ArrayList<>();
        for (String string : words) {
            String word[] = string.split(g);
            for (String string2 : word) {
                ls.add(string2);
            }
        }
        return ls;
    }
}
