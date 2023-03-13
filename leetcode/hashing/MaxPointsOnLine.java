/*
149. Max Points on a Line
Hard
3.5K
406
Companies
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane,
return the maximum number of points that lie on the same straight line.
*/
import java.util.*;

public class MaxPointsOnLine {
	private static int maxPointsOnLine(int[][] points){
		if (points==null) return 0;
		if (points.length <= 2) return points.length;

		int maxPointsOverall = 0;

		for(int i=0; i<points.length; i++){
			HashMap <String, Integer> map = new HashMap<String, Integer>();
			int maxPointsForI = 0;

			for(int j=i+1; j<points.length; j++){

				int dx = points[i][0] - points[j][0];
				int dy = points[i][1] - points[j][1];
				int gcd = greatestCommonDivisor(dx, dy);
				dx /= gcd;
				dy /= gcd;

				String key = dy + "/" + dx;
				map.put(key, map.getOrDefault(key, 0)+1);

				//Update result
				maxPointsForI = Math.max(maxPointsForI, map.get(key));
			}
			maxPointsOverall = Math.max(maxPointsOverall, maxPointsForI+1);
		}
		return maxPointsOverall;
	}

	private static int greatestCommonDivisor(int a, int b){
		if (b==0) return a;
		else return greatestCommonDivisor(b, a%b);
	}

	public static void main(String[] args) {
		int[][] points = {{1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4}};
		System.out.println(maxPointsOnLine(points));
	}
}