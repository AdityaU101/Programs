public class SqrtBinarySearch {
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }

        if (x == 0 || x == 1) {
            return x;
        }

        int low = 1;
        int up = x;
        int mid = -1;
        while (low <= up) {
            mid = low + (up - low) / 2;

            
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) { // eg: 2^2 <=5, 3^2 > 5
                return mid;
            } else if (mid < x / mid) {
                low = mid + 1;
            } else {
                up = mid - 1;
            }
        }
        return mid;
    }
}
