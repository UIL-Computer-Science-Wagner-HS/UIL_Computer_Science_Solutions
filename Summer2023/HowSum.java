/**
 * Write a function 'canSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
 * The function should return an array containing any combination of elements that add up to exactly targetSum.
 * If there is no combination that adds up to the target sum, then return null.
 * If there are multiple combinations possible, you may return a single any single one.
 */

// by Lia

import java.io.*;
import java.util.*;

public class HowSum {
	
	// sets up memoization object and passes it to main recursive method
	public static List<Integer> howSum(int target, int[] vals)
	{
		/* stores a given remainder (or target) as a key with a list value
		 * representing a combination of elements that adds up to that remainder
		 */
		Map<Integer, List<Integer>> memo = new HashMap<>();
		return howSumRec(target, vals, new ArrayList<>(), memo);
	}
	
	// main recursive method
	public static List<Integer> howSumRec(int target, int[] vals, List<Integer> ans, Map<Integer, List<Integer>> memo)
	{
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return ans;
		if (target < 0)
			return null;
		
		for (int i = 0; i < vals.length; i++)
		{
			int remainder = target - vals[i];
			ans.add(vals[i]);
			if (howSumRec(remainder, vals, ans, memo) != null)
			{
				memo.put(remainder, ans);
				return ans;
			}
			ans.remove(ans.size()-1);
		}
		
		memo.put(target, null);
		return null;
	}
	
	public static void main(String[] args) throws IOException {
		// test cases from video
		System.out.println(howSum(7, new int[] {2, 3})); // [2, 2, 3]
		System.out.println(howSum(7, new int[] {5, 3, 4, 7})); // [3, 4]
		System.out.println(howSum(7, new int[] {2, 4})); // null
		System.out.println(howSum(8, new int[] {2, 3, 5})); // [2, 2, 2, 2]
		System.out.println(howSum(300, new int[] {7, 14})); // null
	}
}
