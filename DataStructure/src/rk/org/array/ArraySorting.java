package rk.org.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rahul
 *
 */
/**
 * @author rahul
 *
 */
public class ArraySorting {
	

	/**
	 * Buble sort 
	 * O(n2) complexity
	 * Adaptibility improved: If array is already sorted then have a check in inner loop to break.
	 * Hence , advntage of buble sort is to detect already sorted array in O(n)
	 * 
	 * @param arr
	 */
	public void bubleSort(int arr[]){
		boolean isSorted =false;
		for(int i=0;i<arr.length-1 && !isSorted;i++){
			isSorted =true;
			for (int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					swap(arr, i, j);
					isSorted = false;           // check for sorted ness
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j] = temp;
	}

	/**
	 * Selection sort
	 * Advantage: Comparatively lesser number of swaps hence can be used for array with larger value but smaller keys
	 * Less scalable
	 * @param arr
	 */
	public void selectionSort(int [] arr){
		int i,j,minIndex;
		for( i=0;i<arr.length-1;i++){
			minIndex=i;
			for( j=i+1;j<arr.length;j++){
				if(arr[j]<arr[minIndex]){
					minIndex=j;
				}
			}
			swap(arr,i,minIndex); // O(n) swaps
		}

	}

	/**
	 * Insertion Sort 
	 * Advantage : Swap reduced, scalable, practically more efficient then other two sorting, adaptive , stable
	 * @param arr
	 */
	public void insertionSort(int [] arr){
		int i,j,insertIndex,temp;
		for(i=1;i<arr.length-1;i++){
			temp =arr[i];         // store temp 
			insertIndex =i;
			for(j=i-1;j>=0;j--){
				if(arr[j]>temp){          // compare with temp
					arr[j+1]=arr[j];
					insertIndex=j;
				}
			}
			if(insertIndex!=i){        // imples no greater value found int the sub sorted array
				arr[insertIndex] = temp;
			}
		}
	}


	/**
	 * Follow divide and conquer
	 * Partitioning to find the pivot element
	 * Pivot element forms the boundary between elements less then and greater then in sub array
	 * Then perform quickSort on the two partion and so on..
	 * Not adaptive :O(n^2) for similar elements, sorted elements(asc/desc)
	 * Smaller number of inputs run faster then merge sort
	 * taking Median as a pivot element reduces the algo to best case i.e O(nlogn),
	 * but for mediun have to sort the array
	 * 
	 * @param arr
	 * @param start index for sub array to be conquered
	 * @param end 
	 */
	public void quickSort(int[] arr,int start ,int end){
        if(start<end){
		int pivot = partition(arr,start,end);
		quickSort(arr,start,pivot-1);
		quickSort(arr,pivot,end);
        }
	}


	private int partition(int[] arr, int start, int end) {
		int pivotElement= arr[end];
		int i=start-1,j=start;
		while(j<end){
			if(arr[j]<=pivotElement){
				i++;
				swap(arr,i,j);
			}
			j++;
		}
		swap(arr,i+1,end);
		return i+1;
	}
	
	public void mergeSort(int arr[],int start, int end){
		int mid;
		if(start<end  ){
			mid =start+ (end-start)/2;
			mergeSort(arr,start,mid);
			mergeSort(arr,mid+1,end);
			merge(arr,start,mid,end);
		}
	}

	private void merge(int[] arr, int start, int mid, int end) {
		int leftSubArraySize,rightSubArraySize,i,j,k;
		leftSubArraySize =mid-start+1;
		rightSubArraySize = end-mid;
		int [] leftSubArray = new int[leftSubArraySize];
		for(i=0;i<leftSubArraySize;i++){
			leftSubArray[i] =arr[start+i];
		}
		int [] rightSubArray = new int[rightSubArraySize];
		for(j=0;j<rightSubArraySize;j++){
			rightSubArray[j] =arr[mid+1+j];
		}
		k=start;
		i=0;
		j=0;
		while(i<leftSubArraySize && j<rightSubArraySize){
			if(leftSubArray[i]<=rightSubArray[j]){
				arr[k++]=leftSubArray[i++];
			}
			else{
				arr[k++]=rightSubArray[j++];
			}
		}
		
	    while(i<leftSubArraySize){
	    	arr[k++]=leftSubArray[i++];
	    }
	    while(j<rightSubArraySize){
	    	arr[k++]=rightSubArray[j++];
	    }
	}

	
	public void heapSort(int arr[]){
		buildMaxHeap(arr);
		for(int i=arr.length-1;i>0;i--){
			swap(arr,0,i);
			maxHeapify(arr,i,0);
		}
		
	}

	/**
	 * @param arr
	 */
	private void buildMaxHeap(int[] arr) {
		
		for(int i =(arr.length-1)/2; i>=0;i--){
			maxHeapify(arr,arr.length, i);
		}
		
	}
	
	
	private void maxHeapify(int[] arr,int length, int i) {
		int l =2*i;
		int r = 2*i+1;
		int largest;
		if(l<length && arr[l]>arr[i]){
			largest =l;
		}
		else{
			largest =i;
		}
			
		if(r<length && arr[r]>arr[largest]){
			largest =r;
		}
		
		if(largest != i ){
			swap(arr, i, largest);
			maxHeapify(arr,length, largest);
		}
	}
	
	public void countingSort(int arr[],int start,int end){
		int range = end-start+1;
		int output[] =new int[range];
		for(int i=0;i<range;i++){
			output[i]=0;
		}
		
		for(int  j=0;j<arr.length;j++){
			output[arr[j]-start]++;
		}
		
		for(int i=0,j=0;i<range;i++){
			while(output[i] >0){
					arr[j++] =i+start;
					output[i]--;
			}
		}
		this.dispayArray(arr);
	}

	public static void main(String[] args) {
		ArraySorting obj = new ArraySorting();
		int[] arr = {4,8,5,7,2,9,4,8};
		System.out.println("\n Array before  sorting is " );
		dispayArray(arr);
		//obj.bubleSort(arr);
		//obj.selectionSort(arr);
		//obj.insertionSort(arr);
		//obj.quickSort(arr, 0, arr.length-1);
		obj.mergeSort(arr, 0, arr.length-1);
		//obj.heapSort(arr);
		//obj.countingSort(new int []{5,6,7,8,9,4,5,6,3,7,8,9}, 1, 10);
		System.out.println("Array after  sorting is ");
		dispayArray(arr);

		//  List<Integer> l = new ArrayList<Integer>();
		 // l.add(0,2);
		  //l.add(0,1);
	}

	private static void dispayArray(int[] arr) {
		for(int i : arr){
			System.out.print(" " + i);
		}
	}
}
