public class AddBinary {
    
    public static String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();

        int idxa = a.length()-1;
        int idxb = b.length()-1;
        int carry = 0;
        
        while(idxa>=0 || idxb>=0) {
            int bita = idxa >= 0 ? ((int) a.charAt(idxa--)) - '0' : 0;
            int bitb = idxb >= 0 ? ((int) b.charAt(idxb--)) - '0' : 0;

            int sum = bita ^ bitb ^ carry;
            carry = (bita + bitb + carry)>1 ? 1 : 0;
            s.insert(0, sum);
        }
        if (carry==1) s.insert(0, carry);

        return s.toString();
    }

    public static void main(String[] args) {
        String s = addBinary("1010", "1011");
        System.out.println(s);
    }
}
