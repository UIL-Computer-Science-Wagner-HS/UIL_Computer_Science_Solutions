/*
 * Write a function 'canConstruct(target, wordBank)' that accepts a target string and an array of strings.
 * The function should return a boolean indicating whether or not the 'target' can be constructed by concatenating elements of the 'wordBank' array.
 * You may reuse elements of 'wordBank' as many times as needed.
 */

// by Lia

import java.io.*;
import java.util.*;

public class CanConstruct {
	// sets up memoization object and passes it to main recursive method
	static boolean canConstruct(String target, String[] wordBank)
	{
		// stores a given target string as a key with a boolean value representing if it can be constructed with the elements of wordBank
		Map<String, Boolean> memo = new HashMap<>();
		return canConstructRec(target, wordBank, memo);
	}
	
	//main recursive method
	static boolean canConstructRec(String target, String[] wordBank, Map<String, Boolean> memo)
	{
		if (memo.containsKey(target))
			return memo.get(target);
		if (target.length() == 0)
			return true;
		
		for (int i = 0; i < wordBank.length; i++)
		{
			// only consider wordBank elements that are prefixes of 'target' to avoid removing from the middle of the string
			if (target.indexOf(wordBank[i]) == 0)
			{
				String remainder = target.substring(wordBank[i].length()); // the rest of 'target' if the prefix 'wordBank[i]' is removed from it
				if (canConstructRec(remainder, wordBank, memo))
				{
					memo.put(remainder, true);
					return true;
				}
			}
		}
		
		memo.put(target, false);
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// test cases from video
		System.out.println(canConstruct("abcdef", new String[] {"ab", "abc", "cd", "def", "abcd"})); //true
		System.out.println(canConstruct("skateboard", new String[] {"bo", "rd", "ate", "t", "ska", "sk", "boar"})); // false
		System.out.println(canConstruct("enterapotentpot", new String[] {"a", "p", "ent", "enter", "ot", "o", "t"})); // true
		System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", 
										new String[] {"e", "ee", "eee", "eeee", "eeeee", "eeeeee"})); // false
	}
}
