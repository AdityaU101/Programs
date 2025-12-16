public class LongestPaliString {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int longest = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = s.length()-1; j >=0 ; j--) {
                if(i == j || (s.charAt(i) == s.charAt(j) && i - j < 2) || (s.charAt(i) == s.charAt(j) && dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if(i - j + 1 > longest) {
                        longest = i - j + 1;
                        start = j;
                        end = i;
                    }
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
