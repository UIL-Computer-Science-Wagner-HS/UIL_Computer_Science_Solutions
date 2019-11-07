package Sorting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class pr56 {

	private static void process(String[] arr) {
		// Create int[] copy of arr parameter
		int[] intArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
			intArr[i] = Integer.parseInt(arr[i]);

		// Sort the int array
		Arrays.sort(intArr);

		// Make two lists to add to alternately
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();

		/*
		 * Add to each list alternately so that the smallest goes into list1, the next
		 * smallest gets added to the beginning of list2, and so on. Then, when when we
		 * add the lists together, the elements will be ordered such that the smallest
		 * is first, the next smallest is last, the next smallest is second, the next
		 * smallest is next to last, and so on.
		 */
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				list1.add(intArr[i]);
			} else {
				list2.add(0, intArr[i]);
			}
		}

		//Add the second list to the first list
		list1.addAll(list2);
		
		//Print all elements of the the updated list.
		list1.forEach(x -> System.out.print(x + " "));
		
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr56.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			process(scan.nextLine().split(" "));
		}
		scan.close();

	}

}
