/*
733. Flood Fill
Easy
7.8K
763
Companies
An image is represented by an m x n integer grid image where image[i][j] represents
the pixel value of the image.

You are also given three integers sr, sc, and color. You should perform a flood fill
on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected
4-directionally to the starting pixel of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels (also with the same color),
and so on. Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.
*/


class FloodFill {
	/*
	Approach: DFS from given cell, (flood fill)
	*/
    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
    	// Do nothing if given cell already has specified color
        if (image[sr][sc] == color) return image;

        return dfs(image, sr, sc, color, image[sr][sc]);
    }

    private static int[][] dfs(int[][] image, int i, int j, int color, int currColor) {
    	// Do nothing if out of bounds or if current cell already has color 'color'
    	if (i<0 || j<0 || i>=image.length || j>=image[0].length || image[i][j]!=currColor || image[i][j]==color) return image;

    	// Change color of current cell
    	image[i][j] = color;

    	// DFS from neighbouring cells, recursively change color if that cell has currentColor
    	image = dfs(image, i-1, j, color, currColor);
    	image = dfs(image, i+1, j, color, currColor);
    	image = dfs(image, i, j-1, color, currColor);
    	image = dfs(image, i, j+1, color, currColor);

    	return image;
    }

    public static void main(String[] args) {
    	int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
    	int sr = 1, sc = 1, color = 2;

    	int[][] board = floodFill(image, sr, sc, color);

    	for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
	        	System.out.print(board[i][j] + " ");
        	}
        	System.out.println("");
        }
    }
}


