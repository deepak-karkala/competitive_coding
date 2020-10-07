package bit_manipulation;

/*
Insertion: You are given two 32-bit numbers, N and M, and two
bit positions, iand j. Write a method to insert Minto N such
that M starts at bit j and ends at bit i. You can assume that
the bits j through ihave enough space to fit all of M. That is,
if M= 10011, you can assume that there are at least 5 bits between
j and i. You would not, for example, have j = 3and i= 2, because
Mcould not fully fit between bit 3 and bit 2.
  EXAMPLE
Input: N 10000000000, M 10011, i = 2, j 6 Output: N 10001001100
*/


class Insertion {
	
	public int insertMintoN (int N, int M, int i, int j) {
		int result = 0;
		
		int N_cleared_from_j_to_i = N & ((-1 << (j+1)) | ((1<<i)-1));
		int M_shifted_by_i = M << i;
		
		result = N_cleared_from_j_to_i | M_shifted_by_i;
		
		return result;
	}
	
	public static void main(String[] args) {
		int N = 53;
		int M = 6;
		int i = 1;
		int j = 3;
		
		Insertion ins = new Insertion();
		System.out.println(ins.insertMintoN(N, M, i, j));
	}
}