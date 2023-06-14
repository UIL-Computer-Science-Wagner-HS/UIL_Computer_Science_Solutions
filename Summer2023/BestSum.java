/*
 * Write a function 'bestSum(targetSum, numbers)' that takes in a targetSum and an array of numbers as arguments.
 * The function should return an array containing the shortest combination of numbers that add up to exactly the targetSum.
 * If there is a tie for the shortest combination, you may return any one of the shortest.
 */

// by Lia

import java.io.*;
import java.util.*;

public class BestSum {
	
	// sets up memoization object and passes it to main recursive method
	public static List<Integer> bestSum(int target, int[] vals)
	{
		// stores a given target sum as a key paired with a list value representing the shortest combination for that target sum
		Map<Integer, List<Integer>> memo = new HashMap<>();
		return bestSumRec(target, vals, memo);
	}
	
	// main recursive method
	public static List<Integer> bestSumRec(int target, int[] vals, Map<Integer, List<Integer>> memo)
	{
		if (memo.containsKey(target))
			return memo.get(target);
		if (target == 0)
			return new ArrayList<>();
		if (target < 0)
			return null;
		
		List<Integer> shortest = null;
		for (int i = 0; i < vals.length; i++)
		{
			int remainder = target - vals[i];
			List<Integer> remainderCombo = bestSumRec(remainder, vals, memo);
			
			// if a combination exists for the given remainder
			if (remainderCombo != null)
			{
				// creates a copy of remainderCombo that adds the current element vals[i]
				List<Integer> combo = new ArrayList<>();
				combo.addAll(remainderCombo);
				combo.add(vals[i]);
				
				// if the combination is shorter than the current 'shortest', update it
				if (shortest == null || combo.size() < shortest.size())
				{
					shortest = combo;
				}
			}
		}
		
		memo.put(target, shortest);
		return shortest;
	}
	
	public static void main(String[] args) throws IOException {
		// test cases from video
		System.out.println(bestSum(7, new int[] {5, 3, 4, 7})); // [7]
		System.out.println(bestSum(8, new int[] {2, 3, 5})); // [5, 3]
		System.out.println(bestSum(8, new int[] {1, 4, 5})); // [4, 4]
		System.out.println(bestSum(100, new int[] {1, 2, 5, 25})); // [25, 25, 25, 25]
	}
}
