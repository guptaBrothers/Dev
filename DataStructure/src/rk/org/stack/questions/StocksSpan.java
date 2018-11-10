package rk.org.stack.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * @author rahul
 * 
 *  The stock span problem is a financial problem where we have a series of n daily price quotes
 *  for a stock and we need to calculate span of stock’s price for all n days. 
 *  The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days
 *  just before the given day, for which the price of the stock on the current day is less than or equal 
 *  to its price on the given day.
 *
 */
public class StocksSpan {


	public static void main(String[] args) {
		int[] dailyStocks = {4,7,3,2,4,5,8,6,3};

		//getSpanBruteForceApproach(dailyStocks);
		int[] spanArray = getSpanEfficientApproach(dailyStocks);
		//Arrays.asList(spanArray).stream().forEach(e -> System.out.println(e));
		//IntStream intStream =((Object) Arrays.asList(spanArray)).range(0,spanArray.length-1);
		IntStream.range(0,spanArray.length-1)
				 .forEach(i -> System.out.println("Span of "+ dailyStocks[i] +" is "+ spanArray[i]));

	}

	/**
	 * @param dailyStocks
	 * 
	 * Have an output array that stores the span of individual element , which can be 
	 * used as already calculated operation for other elements.
	 * 
	 * In stack , new element is pushed if it is smaller then top element,
	 * else it pops elements until it finds value greater then itself and 
	 * then finally push itself to the stack
	 * 
	 * note for application convenience , the stack is storing index(day) of the stock
	 * instead of stock value.
	 * @return 
	 * 
	 *   
	 */
	private static int[] getSpanEfficientApproach(int[] dailyStocks) {
		Stack<Integer> tempStack = new Stack<>();
		int[] spanArray ;
		if(dailyStocks == null || dailyStocks.length == 0){
			spanArray = new int[0];
		}	
		else if(dailyStocks.length ==1)
			return (spanArray = new int[]{1});
		else{
			spanArray = new int[dailyStocks.length];
			spanArray[0] =1;
			tempStack.push(0);
			for(int i = 1 ;i < dailyStocks.length ; i++){
				spanArray[i] =1;
				while(!tempStack.isEmpty() && dailyStocks[tempStack.peek()] < dailyStocks[i]){
					spanArray[i] += spanArray[tempStack.pop()];
				}
				tempStack.push(i);
			}

		}
		return spanArray;
	}

	/**
	 * @param dailyStocks
	 * 
	 * Brute force approach
	 * Complexity : O(n^2)
	 * 
	 */
	private static void getSpanBruteForceApproach(int[] dailyStocks) {
		for(int i = 0;i < dailyStocks.length ; i++){
			int span = 1;
			for(int j=i-1;j>=0 && dailyStocks[i]>= dailyStocks[j];j--){
				span++;
			}
			System.out.println("Span of " +dailyStocks[i] +" is "+ span);
		}
	}

}
