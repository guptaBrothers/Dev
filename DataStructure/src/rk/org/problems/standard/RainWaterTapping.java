package rk.org.problems.standard;

/**
 * @author rahul
 * 
 * Given n non-negative integers representing an elevation map where the width of 
 * each bar is 1, compute how much water it is able to trap after raining.
 * Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
		Output: 6
		       | 
		   |   || |
		_|_||_||||||
		Trap "1 unit" between first 1 and 2, "4 units" between
		first 2 and 3 and "1 unit" between second last 1 and last 2 
 *
 *
 *https://www.geeksforgeeks.org/trapping-rain-water/
 *Solutions:
 *
 *	1. Create two separate array left[] right[]  to each elements left and right maxima
 *		then to calculate water += Math.min(left[i],right[i]) - arr[i];
 *		Time : O(n) Space : O(n)
 *
 *	2. Store left maxima in temporary variable while processing left to right and 
 *		sore right maxima in temporay variable while processing right to left
 *		Time: O(n)
 *	
 *
 */
public class RainWaterTapping {
	
	
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println("units of water tapped : " + calculateWaterTapped(arr));
		
	}

	private static int calculateWaterTapped(int[] arr) {
		
		//return method2(arr);
		return method1(arr);
	}
	
	private static int method2(int[] arr) {
		int hi,lo,leftMax,rightMax;
		hi=arr.length-1;
		lo=0;
		leftMax = 0;
		rightMax = 0;
		
		int result = 0;
		while(lo<=hi){
			if(arr[lo] < arr[hi]){
				if(arr[lo] > leftMax)
					leftMax = arr[lo];
				else
					result += leftMax - arr[lo];
				lo++;
			}
			else{
				if(arr[hi] > rightMax)
					rightMax = arr[hi];
				else
					result += rightMax - arr[hi];
				hi--;
			}
		}
		
		return result;
	}

	private static int method1(int arr[]){
		int water = 0;
		int leftMax[] = new int[arr.length];
		int rightMax[] = new int[arr.length];
		
		leftMax[0] =arr[0];
		for(int i=1;i<arr.length;i++)
			leftMax[i] = Math.max(leftMax[i-1], arr[i]);
		
		rightMax[arr.length-1] = arr[arr.length-1];
		for(int i=arr.length-2;i>=0;i--)
			rightMax[i] = Math.max(rightMax[i+1], arr[i]);
		
		for (int i = 0; i < arr.length; i++)
	           water += Math.min(leftMax[i],rightMax[i]) - arr[i];
		
		return water;
	}

}
