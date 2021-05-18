package dynamic_programming;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RobotGrid {
	
	
	public static ArrayList<Point> findPath(int[][] maze) {
		ArrayList<Point> path = new ArrayList<Point>();
		int r = maze.length - 1;
		int c = maze[0].length - 1;
		
		// Save already visited points in Hashset for memoization
		HashSet<Point> alreadyVisited = new HashSet<Point>();
		if(findPath(maze, r, c, path, alreadyVisited))
			return path;
		
		return null;
	}
	
	
	public static boolean findPath(int[][] maze, int r, int c,
			ArrayList<Point> path, HashSet<Point> alreadyVisited) {
		
		// Check invalid values of r, c and off limit points
		if (r < 0 || c < 0 || maze[r][c]==-1)
			return false;
		
		Point p = new Point(r,c);
		
		// Check if point is already visited, return false
		if (alreadyVisited.contains(p)) return false;
		
		// Check for origin
		boolean isOrigin = false;
		if (r == 0 && c ==0) isOrigin = true;
		
		// Add point to path if origin or if there is a path till r-1,c or r,c-1
		if (isOrigin || findPath(maze, r-1, c, path, alreadyVisited) || 
				findPath(maze, r, c-1, path, alreadyVisited)) {
			path.add(p);
			return true;
		}
		
		alreadyVisited.add(p);
		return false;
	}
	
	
	public static void main(String[] args) {
		int numRows = 4, numCols = 6;
		int[][] maze = new int[numRows][numCols];
		for (int i = 0; i < numRows; i++)
			Arrays.fill(maze[i], 0);
		
		// Off-limit points
		maze[2][1] = -1;
		maze[1][3] = -1;
		maze[3][3] = -1;
		
		// findPath
		ArrayList<Point> path = findPath(maze);
		for(Point p: path) {
			System.out.print(p.x + "," + p.y + "->");
		}
	}
}