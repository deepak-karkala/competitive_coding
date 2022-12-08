public class RangeSearch {
    public static int[] rangeSearch(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums==null || nums.length==0) return result;

        result[0] = binaryFirstSearch(nums, target);
        result[1] = binaryLastSearch(nums, target);

        return result;
    }

    public static int binaryFirstSearch(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    public static int binaryLastSearch(int[] arr, int target) {
        int result = -1;
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high-low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = rangeSearch(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
