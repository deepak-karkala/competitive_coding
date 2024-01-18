/*
12 - Integer to Roman
*/

class IntToRoman {
    private static String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        while (num > 0) {
        	if (num >= 1000)     { num -= 1000;s.append("M"); }
        	else if (num >= 900) { num -= 900; s.append("CM"); }
        	else if (num >= 500) { num -= 500; s.append("D"); }
        	else if (num >= 400) { num -= 400; s.append("CD"); }
        	else if (num >= 100) { num -= 100; s.append("C"); }
        	else if (num >= 90)  { num -= 90;  s.append("XC"); }
        	else if (num >= 50)  { num -= 50;  s.append("L"); }
        	else if (num >= 40)  { num -= 40;  s.append("XL"); }
        	else if (num >= 10)  { num -= 10;  s.append("X"); }
        	else if (num >= 9)   { num -= 9;   s.append("IX"); }
        	else if (num >= 5)   { num -= 5;   s.append("V"); }
        	else if (num >= 4)   { num -= 4;   s.append("IV"); }
        	else 				 { num -= 1;   s.append("I"); }
        }
        return s.toString();
    }

    public static void main(String[] args) {
    	System.out.println(intToRoman(1994));
    }
}