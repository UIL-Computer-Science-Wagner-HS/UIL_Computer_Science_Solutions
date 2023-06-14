/*
 * Write a function 'countConstruct(target, wordBank)' that accepts a target string and an array of strings.
 * The function should return the number of ways that the 'target' can be constructed by concatenating elements of the 'wordBank' array.
 * You may reuse elements of 'wordBank' as many times as needed.
 */

// by Lia

import java.io.*;
import java.util.*;

public class CountConstruct {
	// sets up memoization object and passes it to main recursive method
	static int countConstruct(String target, String[] wordBank)
	{
		/* 
		 * stores a given target string as a key with an integer value representing 
		 * the number of ways it can be constructed with the elements in 'wordBank'
		 */
		Map<String, Integer> memo = new HashMap<>();
		return countConstructRec(target, wordBank, memo);
	}
	
	// main recursive method
	static int countConstructRec(String target, String[] wordBank, Map<String, Integer> memo)
	{
		if (memo.containsKey(target))
			return memo.get(target);
		if (target.length() == 0)
			return 1;
		
		int count = 0;
		for (int i = 0; i < wordBank.length; i++)
		{
			// only consider wordBank elements that are prefixes of 'target' to avoid removing from the middle of the string
			if (target.indexOf(wordBank[i]) == 0)
			{
				String remainder = target.substring(wordBank[i].length()); // the rest of 'target' if the prefix 'wordBank[i]' is removed from it
				count += countConstructRec(remainder, wordBank, memo);
			}
		}
		
		memo.put(target, count);
		return count;
	}
	public static void main(String[] args) throws IOException {
		// test cases from video
		System.out.println(countConstruct("purple", new String[] {"purp", "p", "ur", "le", "purpl"})); // 2
		System.out.println(countConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); // 1
		System.out.println(countConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // 0
		System.out.println(countConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // 4
		System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
										new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // 0
	}
}
