/*
171. Excel Sheet Column Number - Easy
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
*/

class TitleToNumber {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += (columnTitle.charAt(i)-'A'+1) * Math.pow(26, len-i-1);
        }
        return sum;
    }
}