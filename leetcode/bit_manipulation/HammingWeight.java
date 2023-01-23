public class HammingWeight {
    
    public static int hammingweight(int n) {
        int count = 0;

        /*
        while(n != 0) {
            count += (n & 1);
            n = n>>>1;
        }
        */

        /*
        for(int i=0; i<32; i++) {
            count += (n>>i & 1);
        }
        */

        while (n!=0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingweight(13));
    }
}
