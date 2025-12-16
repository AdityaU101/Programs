public class ReverseInt {
    public int reverse(int x) {

        int flag = 1;

        if (x < 0) {
            x *= -1;
            flag = -1;
        }

        long result = 0; // initialize as long type

        while(x > 0) {
            int least = x % 10;
            result = result * 10 + least;
            x /= 10;
        }

        // check overflow
        if(result > Integer.MAX_VALUE || result * flag < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) (flag * result);
    }
}
