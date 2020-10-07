package bit_manipulation;

/*
 * Binary to String: Given a real number between 0 and 1 (e.g., 0.72)
 * that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at
 * most 32 characters, print"ERROR
 */


class BinaryToString {
	
	public String getStringFromBinary(double num) {
		StringBuilder binary = new StringBuilder();
		
		binary.append(".");
		double frac = 0.5;
		while (num > 0) {
			
			if (binary.length() > 32) {
				return "ERROR";
			}
			
			if (num >= frac) {
				binary.append(1);
				num -= frac;
			} else {
				binary.append(0);
			}
			frac /= 2;
		}
		
		return binary.toString();
	}
	
	public static void main(String[] args) {
		double n = 0.625;
		BinaryToString bts = new BinaryToString();
		String str = bts.getStringFromBinary(n);
		System.out.println(str);
	}
}