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
		System.out.println("Find an element in rotated array ");
		int x = scanner.nextInt();
		System.out.println("Position of element in rotated array is " +findElementInSortedRotatedArray(arr, arr.length, x));
		
	}

	/**
	 * @param arr
	 * @param d
	 * 
	 * METHOD 1 (Using temp array) T= O(n) ,S= O(d)
	 * METHOD 2 (Rotate one by one) T= O(n*d)
	 * 
	 * METHOD 3 (A Juggling Algorithm)
	 * This is an extension of method 2. Instead of moving one by one, divide the array in different sets 
	 * where number of sets is equal to GCD of n and d and move the elements within sets.
	 * If GCD is 1 as is for the above example array (n = 7 and d =2), then elements will be moved within one set only,
	 * we just start with temp = arr[0] and keep moving arr[I+d] to arr[I] and finally store temp at the right place.
	 * example for n =12 and d = 3. GCD is 3  hence there will be 3 sets {1,4,7,10},{2,5,8,11},{3,6,9,12}.
	 * At each iteration one of the set rotate there position.
	 * 
	 * 
	 */
	private static void rotateArray(int[] arr, int d) {
		int i,j,k;
		
		for (i=0;i<gcd(d,arr.length);i++){  // note gcd or hcf gives number of sets formed for iteration
			int temp = arr[i];
			j=i;
			while(true){
				k=j+d;
				if(k > arr.length-1)
					k = k-arr.length;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}
	}

	private static int gcd(int a, int b) {
		if(a==0)
			return b;
		else
			return gcd(b%a,a);
	}
	
	public static int findElementInSortedRotatedArray(int arr[] , int length , int x){
		// assume ascending and left rotation
		int l,r,mid;
		l=0;
		r=length;
		int xPosition =-1;
		mid = l + (r-l)/2;
		if(l<r){
			if(arr[mid] == x)
				return mid;
			int p = findPivot(arr,l,r);
			
			if(p==-1){
				xPosition = binarySearch(arr,l,r,x);
			}else
			if(x> arr[l])
				xPosition = binarySearch(arr,l,p,x);
			else
				xPosition = binarySearch(arr,p,r,x);
		}
		return xPosition;
	}

	private static int binarySearch(int[] arr, int l, int r, int x) {
		int mid = l + (r-l)/2;
		if(l<r){
			if(arr[mid]==x)
				return mid;
			else if(x < arr[mid])
				return binarySearch(arr, l, mid-1, x);
			else
				return binarySearch(arr, mid+1, r, x);
		}
		return -1;
	}

	private static int findPivot(int[] arr, int l, int r) {
		if(l<r){
			int mid = l +(r-l)/2;
			if(arr[mid]> arr[mid+1])
				return mid;
			if(arr[mid] < arr[mid-1])
				return mid-1;
			if(arr[l]<=arr[mid])
				return findPivot(arr, mid, r);
			else if(arr[mid] < arr[r])
				return findPivot(arr, l, mid);
		}		
		return -1;
	}

}
