public class ransomnote {
    public boolean canConstruct(String ransomNote, String magazine) {
        char count[] = new char[26];
        for(char c:magazine.toLowerCase().toCharArray()){
            ++count[c-'a'];
        }
        for(char c:ransomNote.toLowerCase().toCharArray()){
            if(count[c-'a']<=0) return false;
            --count[c-'a'];
        }
        return true;
    }
}
