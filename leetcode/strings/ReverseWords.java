import java.util.Stack;

public class ReverseWords {
    public static String reverseWords(String s) {
        /*
         * Split by (" "), keep inserting words at
         * 0th position into StringBuilder object
         */
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++) {
            if (!words[i].isEmpty()) { // Insert if not space
                sb.insert(0, words[i]);
                // Insert space before each word except for last word
                if (i!=words.length-1) { 
                    sb.insert(0, " ");
                }
            }
        }
        return sb.toString();
    }


    public static String reverseWordsStack(String s){
        Stack<String> st = new Stack<String>();
        String[] words = s.split(" ");

        //Insert into stack
        for(String word: words) {
            if(!word.isEmpty()) st.push(word);
        }

        StringBuilder sb = new StringBuilder();
        // Pop from stack and insert into StringBuilder
        while(!st.isEmpty()) {
            sb.append(st.pop());
            if (!st.isEmpty()) sb.append(" ");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWordsStack(" a  good   example "));
    }
}
