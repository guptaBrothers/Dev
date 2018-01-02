package rk.org.matrix;

public class MatrixPattern1 {
	
	
	// Q 1 : initialize matrix with 0 and 1, convert matrix such that if cell has 1 then corresponding row and coloumn is made 1
	// Q 2 : All posibble paths from start to end.
	
//	
//	000000               010000
//	010000    ====>      111111  
//	000000               010000 
//
	
	
	public void drawMatrixPattern1(int [][] sourceMatrix,int rowSize, int colSize){
		for (int i=0;i<rowSize;i++){
			for(int j=0;j<colSize;j++){
				if(sourceMatrix[i][j]==1){
					adjsutMatrixAsPerPattern(sourceMatrix,rowSize,colSize,i,j);
				}
			}
		}
		
		for (int i=0;i<rowSize;i++){
			for(int j=0;j<colSize;j++){
				System.out.print(" " + sourceMatrix[i][j]);
			}
			System.out.println();
		}
	}

	private void adjsutMatrixAsPerPattern(int[][] sourceMatrix, int rowSize, int colSize, int i, int j) {
		// TODO Auto-generated method stub
		for (int k=0;k<colSize;k++){
			sourceMatrix[i][k]=1;
		}
		for(int k=0;k<rowSize;k++){
			sourceMatrix[k][j]=1;
		}
	}
	
	public static void main(String[] args) {
		MatrixPattern1 matPattern1 = new MatrixPattern1();
		int[][] m1 = {{0,0,0,0,0},
				        {0,1,0,0,0},
				        {0,0,0,0,0},
				        {0,0,0,0,0}};
	matPattern1.drawMatrixPattern1(m1,4,5);
	}
	
}
