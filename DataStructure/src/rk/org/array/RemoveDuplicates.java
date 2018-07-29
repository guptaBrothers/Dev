package rk.org.array;

public class RemoveDuplicates {
	
	
	public static void main(String[] args) {
		int arr[] = {1,2,2,3,4,5,5,5,6,7,7,8,8,9};
		
		int lastIndex = unique(arr);
		for(int i=0;i<lastIndex;i++){
			System.out.print(" " + arr[i]);
		}
	}

	private static int unique(int[] arr) {
		// TODO Auto-generated method stub
		int j=1;
		boolean isDuplicate = false;
		for(int i =1; i<arr.length; i++){
			while(arr[i] == arr[i-1]){
				isDuplicate =true;
				i++;
			}
			if(isDuplicate){
				arr[j++] = arr[i];
			}else{
				j++;
			}
		}
		return j;
	}

}
