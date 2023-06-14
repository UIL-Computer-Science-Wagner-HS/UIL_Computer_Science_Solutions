/**
 * Write a function 'canSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
 * The function should return a boolean indicating whether or not it is possible to generate the targetSum using numbers from the array.
 * You may use an element of the array as many times as needed.
 * You may assume all input numbers are nonnegative
 */

// by Lia

import java.io.*;
import java.util.*;

public class CanSum {
	
	// sets up memoization object and passes it to main recursive method
	public static boolean canSum(int target, int[] vals)
	{
		/*stores a given remainder (or target) as a key paired with a 
		boolean value representing if a sum can be made to reach that remainder*/
		Map<Integer, Boolean> memo = new HashMap<>(); 
		return canSumRec(target, vals, memo);
	}
	
	// main recursive method
	public static boolean canSumRec(int target, int[] vals, Map<Integer, Boolean> memo)
	{
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return true;
		if (target < 0)
			return false;
		
		for (int i = 0; i < vals.length; i++)
		{
			int remainder = target - vals[i];
			if (canSumRec(remainder, vals, memo))
			{
				memo.put(remainder, true);
				return true;
			}
		}
		
		memo.put(target, false);
		return false;
	}
	public static void main(String[] args) throws IOException {
		// test cases from video
		System.out.println(canSum(7, new int[] {2, 3})); // true
		System.out.println(canSum(7, new int[] {5, 3, 4, 7})); // true
		System.out.println(canSum(7, new int[] {2, 4})); // false
		System.out.println(canSum(8, new int[] {2, 3, 5})); // true
		System.out.println(canSum(300, new int[] {7, 14})); // false
	}
}
