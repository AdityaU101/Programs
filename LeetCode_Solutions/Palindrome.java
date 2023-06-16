package LeetCode_Solutions;
class Palindrome {
    public boolean isPalindrome(String s) {
        s=s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String rev = new StringBuffer(s).reverse().toString();
        return rev.equals(s);
    }
}
/*ALTERNATIVELY 
class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j = s.length()-1;
        while(i<j){
            Character start = s.charAt(i);
            Character end = s.charAt(j);

            //if the character is digit, then don't consider that
            if(!Character.isLetterOrDigit(start)){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(end)){
                j--;
                continue;
            }

            //check if they both equal
            if(Character.toLowerCase(start)!=Character.toLowerCase(end)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
} */