import java.util.ArrayList;

public class StringSegments {
    public int countSegments(String s) {
        String[] str= s.split(" ");
        ArrayList<String> fin = new ArrayList<>();
        for(String g:str){
            if(!g.isBlank()) fin.add(g);
        }
        return fin.size();
    } 
}
