public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

        /*
        int mid = low + (high-low)/2;

        if (nums.length == 1) {
            return (nums[0] >= target) ? 0 : 1
        }

        if (target < nums[0]) return 0;
        if (target > nums[high]) return high + 1;

        while (low < high) {
            mid = low + (high-low)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                if (nums[mid-1] < target) return mid;
                high = mid - 1;
            } else {
                if (nums[mid+1] >= target) return mid+1;
                low = mid + 1;
            }
        }

        return mid;
        */
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }
}
