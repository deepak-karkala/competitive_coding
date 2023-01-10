public class LcpString {
    
    public static String lcpStringSb(String [] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(int i=0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for(int j=0; j<strs.length; j++){

                if (i < strs[j].length()) {
                    if (ch != strs[j].charAt(i)) {
                        return sb.toString();
                    }
                    if (j==strs.length-1) {
                        sb.append(ch);
                    }
                } 
            }
        }
        return sb.toString();
    }


    public static String lcpString(String[] strs) {
        if (strs==null || strs.length==0) return "";

        for(int i=0; i<strs[0].length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if ( (i>=strs[j].length()) || (strs[0].charAt(i) != strs[j].charAt(i)) ) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(lcpString(strs));
    }
}
