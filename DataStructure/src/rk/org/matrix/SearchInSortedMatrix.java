package rk.org.matrix;

/**
 * @author rahul
 *
 * Search an element in a row and column wise sorted matrix
 */
public class SearchInSortedMatrix {
	private int mat [][] = { {10, 20, 30, 40},
            				 {15, 25, 35, 45},
            				 {27, 29, 37, 48},
            				 {32, 33, 39, 50}};
	
	public static void main(String[] args) {
		SearchInSortedMatrix obj = new SearchInSortedMatrix();
		obj.findElementInSortedMatrix(obj.mat, 4, 4, 100);
	}
	
	/**
	 * Steps
	 * 1) Start with top right element
	 * 2) Loop: compare this element e with x.
	 * 		i) if they are equal then return its position
	 * 		ii) e < x then move it to down (if out of bound of matrix then break return false) 
	 * 		iii) e > x then move it to left (if out of bound of matrix then break return false)
	 * 3) repeat the i), ii) and iii) till you find element or returned false
	 * 
	 * 
	 * @param mat
	 * @param rowSize
	 * @param colSize
	 * @param x
	 * @return
	 */
	public boolean findElementInSortedMatrix(int mat[][], int rowSize, int colSize, int x){
		
		int i=0;
		int j =colSize-1;
		while(i<rowSize && j>=0){
			if(mat[i][j] == x){
				System.out.println("position is ( "+ i +" , "+ j +" )" );
				return true;
			}
			if(mat[i][j]<x){ 
				i++;
			}else{
				j--;
			}
		}
		System.out.println("Not Found");
		return false;
	}

}
