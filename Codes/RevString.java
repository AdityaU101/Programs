public class RevString {
    public String reverseString(String input) {

        StringBuilder s = new StringBuilder(input);
        s.reverse();

        return s.toString();
    }
}
