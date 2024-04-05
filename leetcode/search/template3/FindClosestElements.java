/*
658. Find K Closest Elements
Solved
Medium
Topics
Companies
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
*/

class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
		int hi = arr.length - 1;
		while (hi - lo >= k) {
			if (Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)) {
				lo++;
			} else {
				hi--;
			}
		}
		List<Integer> result = new ArrayList<>(k);
		for (int i = lo; i <= hi; i++) {
			result.add(arr[i]);
		}
		return result;
    }

    public List<Integer> findClosestElementsBinarySearch(int[] arr, int k, int x) {
        int low = 0, high = arr.length - k;
        List<Integer> list = new ArrayList<>();

        while(low < high) {
            int mid = low + (high - low) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                low = mid + 1;
            else
                high = mid;
        }
        return Arrays.stream(arr, low, low + k).boxed().collect(Collectors.toList());
    }
}