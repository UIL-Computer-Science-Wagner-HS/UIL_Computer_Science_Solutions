package Sorting;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class pr59 {

	/**
	 * Perform an insertion sort on the given array arr.
	 * 
	 * @param arr the input array to perform sort on
	 */
	private static void insertionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int j = i - 1;
			for (; j >= 0 && current < arr[j]; j--) {
				arr[j + 1] = arr[j];
			}
			arr[++j] = current;
		}
	}

	/**
	 * Print the input matrix according to the specifications.
	 * 
	 * @param matrix the 2D array to print out
	 */
	private static void printArr(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row)
				System.out.printf("%4d ", element);
			System.out.println();
		}

		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("pr59.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while (no-- > 0) {
			// Construct matrix
			String[] dimensions = scan.nextLine().split(" ");
			int rows = Integer.parseInt(dimensions[0]);
			int cols = Integer.parseInt(dimensions[1]);
			int[][] matrix = new int[rows][cols];
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {
					matrix[r][c] = Integer.parseInt(scan.next());
				}
			}

			// Quick fix for not having scanner scan a line that doesn't exist after the
			// last dataset.
			try {
				scan.nextLine();
			} catch (NoSuchElementException e) {

			}

			/*
			 * Perform insertion sort on each row. Note that we also could have solved the
			 * problem by loading each line into an ArrayList and sorting line by line
			 * without a matrix, but it's always good to know how to sort by yourself.
			 */
			for (int[] currentRow : matrix)
				insertionSort(currentRow);

			// Print the sorted matrix according to specifications.
			printArr(matrix);
		}
		scan.close();

	}

}
