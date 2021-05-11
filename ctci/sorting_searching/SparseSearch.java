package sorting_searching;

/*
 * Given a sorted array of strings that is interspersed with empty strings, 
 * write a method to find the location of a given string.
 */


public class SparseSearch {
	
	public static int sparseSearch(String[] strArray, String str) {
		if (strArray == null || str == "" || str == null) {
			return -1;
		}
		return search(strArray, str, 0, strArray.length-1);
	}
	
	public static int search(String[] s, String key, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) >>> 1;
		
		String middle = s[mid];
		
		// If middle is empty Find nearest non-empty string and update mid
		if (middle.isEmpty()) {
			int left = mid - 1;
			int right = mid + 1;
			
			
			while (1 > 0) {
				if (left < low || right > high) {
					return -1;
				} else if (right <= high && !s[right].isEmpty()) {
					mid = right;
					break;
				} else if (left >= low && !s[left].isEmpty()) {
					mid = left;
					break;
				}
				left--;
				right++;
			}
		}
		
		middle = s[mid];

		// Binary search
		if (key == middle) {
			return mid;
		} else if (key.compareTo(middle) > 0) {
			return search(s, key, mid+1, high);
		} else {
			return search(s, key, low, mid-1);
		}
		
	}
	
	
	public static void main(String[] args) {
		String[] strArray = {"a", "", "", "ball", "", "", "", "cat", ""};
		String str = "cat";
		int idx = sparseSearch(strArray, str);
		System.out.println(idx);
	}
}