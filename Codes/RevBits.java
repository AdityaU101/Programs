public class RevBits {
    public int reverseBits(int n) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(n));
        String ans=bin.reverse().toString();
        return Integer.parseInt(ans);
    }
}
