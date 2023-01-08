package arrays_strings;

public class IsUnique {
    public static boolean isUnique(String s) {
        // Assuming 256 ASCII characters
        int num_characters = 256;

        if (s.length() > num_characters) return false;

        boolean[] is_present = new boolean[num_characters];

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (is_present[ch]) return false;
            is_present[ch] = true;
        }
        return true;
    }

    public static boolean isUniqueBitVector(String s) {
        // Assuming 32 lower case characters ('a' to 'z')
        int bit_vector = 0;

        for(int i=0; i<s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            if ((bit_vector & (1 << pos))>0) {
                return false;
            }
            bit_vector = bit_vector | (1<<pos); 
        }
        return true;
    }

    public static void main(String[] args) {
        boolean isunique = isUniqueBitVector("abcde");
        System.out.println(isunique);
    }
}


