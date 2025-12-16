import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class rev_vowels {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int i=0,j=s.length()-1;
        char[] c= s.toCharArray();
        while(i<j){
            if(!vowels.contains(c[i])){i++;continue;}
            if(!vowels.contains(c[j])){j--;continue;}
            char temp=c[i];
            c[i]=c[j];
            c[j]=temp;
            i++;
            j--;
        }
        return new String(c);
    }
}
