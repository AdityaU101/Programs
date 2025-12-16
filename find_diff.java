public class find_diff {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c : s.toCharArray()) res ^= c;
        for (char c : t.toCharArray()) res ^= c;
        return res;
    }
    /* Alternative 1
     * public char findTheDifference(String s, String t) {
            char res = 0;
            for (char c : s.toCharArray()) res -= c;
            for (char c : t.toCharArray()) res += c;
            return res;

        }
        

        Alternative 2
        public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            ++cnt[s.charAt(i) - 'a'];
        }
        for (int i = 0;; ++i) {
            if (--cnt[t.charAt(i) - 'a'] < 0) {
                return t.charAt(i);
            }
        }
    }
     */
}
