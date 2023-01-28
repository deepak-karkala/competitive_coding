import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the 
 * non-overlapping intervals that cover all the intervals in the input.
Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them 
into [1,6]. 
 */

class MergeIntervals {
    public List<List<Integer>> mergeIntervals(List<List<Integer>> intervals) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        int low = 0;
        int high = intervals.size()-1;

        if (high <= 1) {
            return intervals;
        }

        while (low <= high) {
            int mid = (int) Math.ceil((low + high) / 2);

        	System.out.println(low + " " +  mid + " " + high);

            //List<List<Integer>> llist = mergeIntervals(intervals.subList(low, mid));
            //List<List<Integer>> rlist = mergeIntervals(intervals.subList(mid, high+1));

            List<List<Integer>> llist = mergeIntervals(Arrays.asList(Arrays.asList(1,3)));
            List<List<Integer>> rlist = mergeIntervals(Arrays.asList(Arrays.asList(2,6)));

            int left = llist.get(llist.size()-1).get(1);
            int right = rlist.get(0).get(0);

            

            if (left >= right){
                for (int i=0; i<llist.size()-1; i++) {
                    lists.add(llist.get(i));
                }
                lists.add(Arrays.asList(llist.get(llist.size()-1).get(0), rlist.get(0).get(1) ));
                for (int i=1; i<rlist.size(); i++) {
                    lists.add(rlist.get(i));
                }

            } else {
                for (int i=0; i<llist.size(); i++) {
                    lists.add(llist.get(i));
                }
                for (int i=0; i<rlist.size(); i++) {
                    lists.add(rlist.get(i));
                }
            }

        }

        return lists;
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> intervals = new ArrayList<List<Integer>>();

        intervals.add(Arrays.asList(1,3));
        intervals.add(Arrays.asList(2,6));
        //intervals.add(Arrays.asList(8,10));
        //intervals.add(Arrays.asList(15,18));

        //System.out.println(intervals.size());

        MergeIntervals e = new MergeIntervals();
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	lists = e.mergeIntervals(intervals);

        for (List<Integer> l1 : lists) {
            for (Integer n : l1) {
                System.out.print(n + " "); 
            }
            System.out.println();
         } 
    }
}
