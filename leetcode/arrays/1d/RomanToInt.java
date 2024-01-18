/*
13. Roman to integer
*/

import java.util.*;

class RomanToInt {
    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] charr = s.toCharArray();
        int integer = 0;
        for(int i=0; i<charr.length; i++) {
            if (i<=charr.length-2 && map.get(charr[i]) < map.get(charr[i+1])) {
                integer -= map.get(charr[i]);
            } else {
                integer += map.get(charr[i]);
            }
        }
        return integer;
    }

    private static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        char[] charr = s.toCharArray();
        int i = charr.length - 1;
        int integer = 0;
        while(i >= 0) {
            if (i > 0 && charr[i] == 'V' && charr[i-1] == 'I') { integer += map.get("IV"); i--; }
            else if (i > 0 && charr[i] == 'X' && charr[i-1] == 'I') { integer += map.get("IX"); i--; }
            else if (i > 0 && charr[i] == 'L' && charr[i-1] == 'X') { integer += map.get("XL"); i--; }
            else if (i > 0 && charr[i] == 'C' && charr[i-1] == 'X') { integer += map.get("XC"); i--; }
            else if (i > 0 && charr[i] == 'D' && charr[i-1] == 'C') { integer += map.get("CD"); i--; }
            else if (i > 0 && charr[i] == 'M' && charr[i-1] == 'C') { integer += map.get("CM"); i--; }
            else integer += map.get(String.valueOf(charr[i]));
            i--;
        }
        return integer;
    }

    public static void main(String[] args) {
    	String s = "III";
    	System.out.println(romanToInt(s));
    }
}