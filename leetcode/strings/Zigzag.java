/*
6. Zigzag Conversion
Medium
Topics
Companies
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
*/

class Zigzag {
    private static String zigzag(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i=0; i<sb.length; i++) sb[i] = new StringBuilder();

        int writeIdx = 0, readIdx = 0;
        while(readIdx < s.length()) {
        	// Insert row by row
        	for(writeIdx = 0; writeIdx < numRows && readIdx < s.length(); writeIdx++)
        		sb[writeIdx].append(s.charAt(readIdx++));

        	// Insert diagonally, from down to up
        	for(writeIdx = numRows - 2; writeIdx >= 1 && readIdx < s.length(); writeIdx--)
        		sb[writeIdx].append(s.charAt(readIdx++));
        }

        //Concatenate all stringbuilders
        for(int i=1; i<sb.length; i++) sb[0].append(sb[i]);
        return sb[0].toString();
    }

    public static void main(String[] args) {
    	String s = "PAYPALISHIRING";
    	int numRows = 4;
    	System.out.println(zigzag(s, numRows));
    }
}