public class LcpString {
    
    public static String lcpString(String [] strs) {
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

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(lcpString(strs));
    }
}
