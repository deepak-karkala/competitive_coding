/*
1861. Rotating the Box
Medium
Topics
Companies
Hint
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.
*/

class RotateTheBox {
    /*
    2 pointers, matrix
    Time: O(m * n) Space: O(1)
    */
    private static char[][] rotateTheBox(char[][] box) {
        int numRows = box.length, numCols = box[0].length;
        char[][] rotatedBox = new char[numCols][numRows];

        for(int i = 0; i<numRows; i++) {
            int empty = numCols - 1;

            for(int j=numCols-1; j>=0; j--) {
                // If obstacle, move empty to obstacle-1
                if (box[i][j] == '*') empty = j - 1;

                // If stone, move stone to empty, empty is decremented by one
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Rotate the box 90 degrees
        //      Cols: 0 to numCol-1 moves to rows 0 to numRows'-1
        //      Rows: 0th row -> nth col, 1st row -> n-1th col... nth row ->0th col
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < numCols; j++) {
                rotatedBox[j][numRows - i - 1] = box[i][j];
            }
        }

        return rotatedBox;
    }

    public static void main(String[] args) {
        char[][] box = {{'#','.','#'}};
        char[][] rotatedBox = rotateTheBox(box);
    }
}