public class PowOfFour {
    public boolean isPowerOfFour(int num) {
        while (num>0 && (num % 4 == 0)) {
            num /= 4;
        }
        return num == 1;
    }
}
