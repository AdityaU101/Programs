class restore_string{
    public String restoreString(String s, int[] indices) {
       char c[] = new char[s.length()];
       for (int i = 0; i < s.length(); i++) {
        c[indices[i]]=s.charAt(i);
       } 
       return String.valueOf(c);
    }
}