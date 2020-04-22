package practice.leetcode.medium;

public class RotateImage_48 {

	public static void main(String[] args) {
		int[][] matrix = { {5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16} };
		rotate_2(matrix);
	}// end main()

	/**
	 * Conventional idea.<br>
	 * 1. It's rotating diagonally<br>
	 * 2. 2. Rotating column.<br>
	 * 3. Print the array of matrix.<br>
	 * */
	/*
	 * Test Data: Example 1: Given input matrix = { {1,2,3}, {4,5,6}, {7,8,9} },
	 * rotate the input matrix in-place such that it becomes: { {7,4,1},{8,5,2},{9,6,3} }
	 * 
	 * Example 2:
	 * Given input matrix = { {5, 1, 9,11}, { 2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16} },
	 * rotate the input matrix in-place such that it becomes: { {15,13, 2, 5}, {14,3, 4, 1}, {12, 6, 8, 9}, {16, 7,10,11} }
	 */
	public static void rotate_1(int[][] matrix) {
		if(matrix==null) {
			return;
		}//end for
//=====================================================
		// 1. It's rotating diagonally
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i < j) {
					matrix[i][j] = matrix[i][j] ^ matrix[j][i];
					matrix[j][i] = matrix[i][j] ^ matrix[j][i];
					matrix[i][j] = matrix[i][j] ^ matrix[j][i];
				} else {
					continue;
				} // end if
			} // end for
		} // end for
		
		//2. Rotating column.
		for(int i=0;i<matrix.length;i++) {
			int length = matrix[i].length;
			for(int j=0;j<length/2;j++) {
				matrix[i][j] = matrix[i][j] ^  matrix[i][length-j-1] ;
				matrix[i][length-j-1] = matrix[i][j] ^  matrix[i][length-j-1] ;
				matrix[i][j] = matrix[i][j] ^  matrix[i][length-j-1] ;
			}//end for
		}//end for
//=====================================================
		//3. Print the array of matrix.
		for (int x[] : matrix) {
			for (int y : x) {
				System.out.print(y + " ");
			} // end for
			System.out.println();
		} // end for
	}// end rotate()
	
	/**
	 * 
	 * */
	public static void rotate_2(int[][] matrix) {
		if(matrix==null) {
			return;
		}//end for
//=====================================================
		int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n - 1 - i; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = tmp;
            }//end for
        }//end for

//=====================================================
		//Print the array of matrix.
		for (int x[] : matrix) {
			for (int y : x) {
				System.out.print(y + " ");
			} // end for
			System.out.println();
		} // end for
	}// end rotate()
}// end RotateImage_48
