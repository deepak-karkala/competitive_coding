

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        return uniquePathsRecurse(m-1, n-1, grid);
    }

    public static int uniquePathsRecurse(int i, int j, int[][] grid) {
        if (i==0 || j==0) {
            grid[i][j] = 1;
            return grid[i][j];
        }
        if (grid[i][j] == 0) {
            grid[i][j] = uniquePathsRecurse(i-1, j, grid) + uniquePathsRecurse(i, j-1, grid); 
        }
        return grid[i][j];
    }

    public static void main(String[] args) {
        int num_paths = uniquePaths(3, 7);
        System.out.println(num_paths);
    }
}
