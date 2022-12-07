public class TotalHammingDistance {
    public static int totalHammingDistance(int[] nums) {
        int count = 0;
        /*
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                count += Integer.bitCount(nums[i] ^ nums[j]);
            }
        }
        */
        for(int i=0; i<32; i++){
            int numOnes = 0;
            for (int num: nums){
                numOnes += (num >> i) & 1;
            }
            count += numOnes*(nums.length - numOnes);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {2, 14, 4};
        System.out.println(totalHammingDistance(nums));
    }
}