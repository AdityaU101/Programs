package LeetCode_Solutions;
class VowelCount {
    public int vowelStrings(String[] words, int left, int right) {
        int count=0;
        for(int i=left;i<=right;i++){
            String s=words[i];
            s=s.toLowerCase();
            if((s.startsWith("a")||s.startsWith("e")||s.startsWith("i")||s.startsWith("o")||s.startsWith("u"))&&(s.endsWith("a")||s.endsWith("e")||s.endsWith("i")||s.endsWith("o")||s.endsWith("u"))) count++;
        }
        return count;
    }
}