public class ExcelColumnNumber {
    public static int excelColumnNumber(String columnTitle) {
        int col = 0;
        int len = columnTitle.length();

        for(int i=1; i<len; i++) {
            col += Math.pow(26, i);
        }

        for(int i=0; i<len; i++) {
            col += (columnTitle.charAt(len-i-1) - 'A') * Math.pow(26, i);
        }

        return col + 1;
    }

    public static void main(String[] args) {
        System.out.println(excelColumnNumber("ZY"));
    }
}

