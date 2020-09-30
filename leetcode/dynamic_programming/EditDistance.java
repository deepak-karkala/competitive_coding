package dynamic_programming;
/*
 * Given two words word1 and word2, find the minimum number of
 * operations required to convert word1 to word2. You have the
 * following 3 operations permitted on a word:
	Insert a character
	Delete a character
	Replace a character 
 */

class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        // Initialize matrix to hold minimum distances
        int[][] dist = new int[m+1][n+1];
        
        // Distance =0 for 0 length subsequences
        for (int i=0; i<=m; i++) {
        	dist[i][0] = i;
        }
        for (int i=0; i<=n; i++) {
        	dist[0][i] = i;
        }
        
        for (int r=1; r<=m; r++) {
        	for (int c=1; c<=n; c++) {
        		
        		if (word1.charAt(r-1) == word2.charAt(c-1)) {
        			dist[r][c] = dist[r-1][c-1];
        		} else {
        			int left_cost = dist[r][c-1];
        			int up_cost = dist[r-1][c];
        			int diag_cost = dist[r-1][c-1];
        			dist[r][c] = Math.min(Math.min(left_cost, up_cost), diag_cost) + 1;
        		}
        	}
        }
        
        return dist[m][n];
    }
    
    public static void main(String[] args) {
    	String word1 = "intention";
    	String word2 = "execution";
    	
    	EditDistance ed = new EditDistance();
    	int minOps = ed.minDistance(word1, word2);
    	System.out.println(minOps);
    }
}
