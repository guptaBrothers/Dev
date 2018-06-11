package rk.org.matrix;

public class RotateMat90degree {

	public static void main(String[] args) {

		int mat[][] = { { 1, 2, 3, 4, 5 },
						{ 16, 17, 18, 19, 6 },
						{ 15, 24, 25, 20, 7 },
						{ 14, 23, 22, 21, 8 },
						{ 13, 12, 11, 10, 9}};

		RotateMat90degree obj = new RotateMat90degree();
		obj.rotateBy90degree(mat ,5,5);

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
		//obj.rotateBy90degree(mat, 5, 5);
	}

	private void rotateBy90degree(int[][] mat, int rowSize, int colSize) {
		if(rowSize!=colSize){
			System.out.println("For in-place rotation, it should be square matrix ");
			return;
		}
		int rowStart,rowEnd,colStart,colEnd;
		rowStart = 0;
		rowEnd = rowSize-1;
		colStart = 0;
		colEnd = colSize-1;
		int temp;
		int temp1;
		
		/*
		 * Remember offset at each variable index
		 * follow sequence of fixed index at each iteration colEnd->rowEnd->colStart->rowStart
		 * */
		while(rowStart<rowEnd && colStart<colEnd){
			int i=0;
			int k=colEnd-colStart;
			while(i<k){
				temp = mat[rowStart+i][colEnd];         

				mat[rowStart+i][colEnd] = mat[rowStart][colStart+i];

				temp1 = mat[rowEnd][colEnd-i];
				mat[rowEnd][colEnd-i] = temp;

				temp = mat[rowEnd-i][colStart];
				mat[rowEnd-i][colStart] = temp1;

				mat[rowStart][colStart+i] = temp;
				i++;
			}
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
			
		}
	}

}
