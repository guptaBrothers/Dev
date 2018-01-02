package rk.org.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayRotation {
	
	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int arr[] =new int[10];
		for(int i=0;i<arr.length;i++){
			System.out.println("Enter the element of the array");
			arr[i] = scanner.nextInt();
		}
		System.out.println("Enter the number of postions the array need s to be rotated");
		int d= scanner.nextInt();
		
		rotateArray(arr,d);
		
		for(int a:arr){
			System.out.print(a + " ");
		}
	}

	private static void rotateArray(int[] arr, int d) {
		// TODO Auto-generated method stub
		int i,j;
		int len =arr.length;
		for (i=0;i<d;i++){
			int temp = arr[i];
			for (j=i;j<len-d;j+=d){
				arr[j]=arr[j+d];
			}
			arr[j]=temp;
		}
		
		Map<Integer,String> map = new HashMap();
		map.put(1,"a");
		map.put(2,"b");
		System.out.println("1 : "+ map.get(1).hashCode()  );
		System.out.println("2 : "+ map.get(2).hashCode()  );
	}

}
