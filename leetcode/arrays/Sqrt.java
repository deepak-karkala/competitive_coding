/* Given a non-negative integer x, return the square root of x
rounded down to the nearest integer. The returned integer should
be non-negative as well
*/

class Sqrt {
    public static int sqrt(int x) {
        if (x==0) return 0;
        int low = 1;
        int high = x;

        while(true) {
            int mid = low + (high-low)/2;

            if (mid > x/mid) {
                high = mid - 1;
            } else {
                if ( (mid+1) > x/(mid+1)) {
                    return mid;
                }
                low = mid + 1;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(sqrt(5));
    }

}