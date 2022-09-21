import java.io.*;
import java.util.*;

public class Shake {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("shake.dat"));
		 int n = scan.nextInt();
		 scan.nextLine();
		 
		 
		 while (n-- > 0) {
			 //scanning in the input
			 String word = "";
			 String[] str = scan.nextLine().split("");
			
			 //calculating the size needed for 2-D Array
			 int size = (int) Math.sqrt(str.length);			 
			 String[][] arr = new String[size][size]; // creating new array
			 
			 // filling in the 2-D array
			 int index = 0;
			 for (int row = 0; row < arr.length; row++) {
				 for (int col = 0; col < arr.length; col++) {
					 arr[row][col] = str[index]; index++;
				 }
			 }
			 
			 // check the 2-D Array
			 /*for (String[]r : arr) {
				 for (String c: r) {
					 System.out.print(c);
				 }
				 System.out.println();
			 }
			 System.out.println(); */
			 
			 for (int row = 0; row < arr.length; row++) {
				 if (row%2 == 0) {
					 for (int i = 1; i < arr[row].length; i++) {
						 word += arr[row][i];
					 }
					 word += arr[row][0];
				 }
				 if(row%2==1) {
					 word += arr[row][arr[row].length-1];
					 for (int i = 0; i < arr[i].length-1; i++) {
						 word += arr[row][i];
					 }
				 }
				 
			 }
			 int index_asterisk = word.indexOf("*");
			 if (index_asterisk != -1)
				 word = word.substring(0,index_asterisk);
			 System.out.print(word);
			 System.out.println();
			 
		 }
	}

}
