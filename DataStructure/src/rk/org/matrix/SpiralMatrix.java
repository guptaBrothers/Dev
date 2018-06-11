package rk.org.matrix;

public class SpiralMatrix {
	
	
	
	public static void main(String[] args) {
		
		int mat[][] ={{1,2,3,4,5},
					  {14,15,16,17,6},
					  {13,20,19,18,7},
					  {12,11,10,9,8}};
		int row=4,col=5;
		SpiralMatrix obj = new SpiralMatrix();
		obj.printSpiral(mat,row,col);
		
	}

	private void printSpiral(int[][] mat, int rowSize, int colSize) {
		int rowStart,rowEnd,colStart,colEnd;
		rowStart =0;
		rowEnd = rowSize-1;
		colStart=0;
		colEnd = colSize-1;
		
		while(rowStart<rowEnd && colStart <colEnd){
			
			for(int i =colStart;i<=colEnd;i++){
				System.out.print(mat[rowStart][i] + " ");
			}
			rowStart++;
			System.out.println();
			for(int i=rowStart;i<=rowEnd;i++){
				System.out.println(mat[i][colEnd]);
			}
			colEnd--;
			for(int i =colEnd;i>=colStart;i--){
				System.out.print(mat[rowEnd][i] + " ");
			}
			rowEnd--;
			System.out.println();
			for(int i=rowEnd;i>=rowStart;i--){
				System.out.println(mat[i][colStart]);
			}
			colStart++;
		}
		
	}

}
