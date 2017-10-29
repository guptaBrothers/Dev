package rk.org.matrix;

import java.util.Collections;
import java.util.Scanner;

public class MatrixMultiplication {
	
	public static void main (String args[]){
		MatrixMultiplication matrix = new MatrixMultiplication();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter row and column of first matrix");
		int row1 = sc.nextInt();
		int col1 = sc.nextInt();
		System.out.println("Enter row and column of second Matrix");
		int row2= sc.nextInt();
		int col2 = sc.nextInt();
		int A[][] = new int[row1][col1];
		int B[][] = new int[row2][col2];
		matrix.intializiseMatrix(A, row1, col1);
		matrix.intializiseMatrix(B, row2, col2);
		
		System.out.println("Matrix A");
		matrix.displayMat(A, row1, col1);
		System.out.println("Matrix B");
		matrix.displayMat(B, row2, col2);
		
		System.out.println("Matrix multiplication is");
		
		matrix.matMultiplication(A, row1, col1, B, row2, col2);
		System.out.println("Enter the number to be searched in the matrix");
		//matrix.findCoordinateOfAnElementInSortedMatrix(A, row1, col1, sc.nextInt());
		matrix.dispalyMatrixInSpiralForm(A, row1, col1);
		
		
	}
	
	public int[][] intializiseMatrix(int A[][],int row,int col){
		for(int i=0; i<row ; i++){
			for(int j=0; j<col ; j++)
				A[i][j]=i+j;
		}
		return A;
	}
	
	public void displayMat(int A[][],int row,int col){
		for(int i=0; i<row ; i++){
			for(int j=0; j<col ; j++){
				System.out.print(" " +A[i][j]);
			}
			System.out.println();
		}
		
	}
	
	public int[][] matMultiplication(int A[][],int row1,int col1 ,int B[][],int row2,int col2){
		
		if(col1!=row2){
			System.out.println("Matrix multiplication not possible");
		}else{
		
		int C[][] = new int[row1][col2];
		
		for (int i=0; i<row1; i++){
			for(int k=0;k<col2;k++ ){
			    for(int j=0; j<col1; j++){
				    C[i][k] += A[i][j]*B[j][k];
			    }
			}
		}
		
		displayMat(C,row1,col2);
		return C;
		}
		return null;
		
	}
	
   public void findCoordinateOfAnElementInSortedMatrix(int a[][],int row,int col,int n){
	   int x_coordinate=-1;
	   int y_coordinate=-1;
	   Outer: for(int i=0;i<row;i++){
			   if(a[i][0] ==n){
				   x_coordinate =i;
				   y_coordinate =0;
				   break;
			   }
			   if(n==a[i][col-1]){
				   x_coordinate =i;
				   y_coordinate =col-1;
				   break;
			   }
			   if(n<=a[i][col-1]){
				   x_coordinate =i;
				   y_coordinate = binarySearch(a[i],n);
				   break Outer;
			   }
	   }
	   if(x_coordinate!=-1){
		   System.out.println("Element found at co-ordinate : (" +x_coordinate + ","+y_coordinate +")");
	   }
	   else{
		   System.out.println("Number not found");
	   }
   }

	private int binarySearch(int[] array, int n) {
		int len = array.length;
		int start = 0;
		int end = len;
		int mid = 0;

		while (start < end){
			if ((end-start) % 2 == 0) {
				mid = (end-start) / 2 - 1;
			} else {
				mid = (end-start) / 2;
			}

			if (array[mid] == n) {
				return mid;
			} else if (array[mid] < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		} 
		
		return mid;
	}
	
	public void dispalyMatrixInSpiralForm(int[][] mat,int row,int col){
		int row_Min = 0;
		int row_Max = row-1;
		int col_Min = 0;
		int col_Max = col-1;
		int i;
		while(row_Min<row_Max && col_Min <=col_Max
				||(row_Min<=row_Max && col_Min <col_Max)){
			
			//print upper row
			for(i=col_Min;i<=col_Max;i++)
				System.out.println(mat[row_Min][i]);
			row_Min++;
			System.out.println();
			// print right column
			for(i=row_Min;i<=row_Max;i++)
				System.out.println(mat[i][col_Max]);
			col_Max--;
			System.out.println();
			// print lower row
			for(i=col_Max;i>=col_Min;i--){
				System.out.println(mat[row_Max][i]);
			}
			row_Max--;
			System.out.println();			
			//print right column
			for(i=row_Max;i>=row_Min;i--){
				System.out.println(mat[i][col_Min]);
			}
			col_Min++;
			System.out.println();
		}
	}
}
