import java.util.HashSet;

public class HappyNum {
    public boolean isHappy(int n) {
            HashSet<Integer> st = new HashSet<Integer>();
            while (n != 1) {
                int sum = 0;
                while (n > 0) {
                    sum += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = sum;
                if (st.contains(n)) {
                    break;
                }
                st.add(n);
            }

            return n == 1;
        }
}
