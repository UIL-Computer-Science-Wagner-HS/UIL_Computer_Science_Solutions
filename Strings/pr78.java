
import java.io.*;
import java.util.*;

public class pr78 {
//check rows
	static boolean chRow(String check, char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			String str = "";
			for (int j = 0; j < arr.length; j++)
				str = str + arr[i][j];

			if (str.indexOf(check) >= 0 || (new StringBuilder(str)).reverse().toString().indexOf(check) >= 0)

				return true;

		}

		return false;
	}
//check columns
	static boolean chCol(String check, char[][] arr) {
		for (int j = 0; j < arr.length; j++) {
			String str = "";
			for (int i = 0; i < arr.length; i++)
				str = str + arr[i][j];
			if (str.contains(check) || (new StringBuilder(str)).reverse().toString().contains(check))
				return true;

		}

		return false;
	}
//check diagonals whew!
	static boolean chDiag(String check, char[][] arr) {
		for (int count = arr.length - 1; count >= 0; count--) {
			String str = "";
			for (int i = count, j = 0; i < arr.length; i++, j++)
				str += arr[i][j];
			if (str.contains(check) || new StringBuilder(str).reverse().toString().contains(check))
				return true;

		}

		for (int count = 1; count < arr.length; count++) {
			String str = "";
			for (int i = 0, j = count; i < arr.length && j < arr.length; i++, j++)
				str += arr[i][j];
			if (str.contains(check) || new StringBuilder(str).reverse().toString().contains(check))
				return true;

		}

		for (int count = 0; count < arr.length; count++) {
			String str = "";
			for (int i = count, j = 0; i >= 0 && j < arr.length; i--, j++)
				str += arr[i][j];
			if (str.contains(check) || new StringBuilder(str).reverse().toString().contains(check))
				return true;

		}
		for (int count = 1; count < arr.length; count++) {
			String str = "";
			for (int i = arr.length - 1, j = count; i >= 0 && j < arr.length; i--, j++)
				str += arr[i][j];
			if (str.contains(check) || new StringBuilder(str).reverse().toString().contains(check))
				return true;

		}

		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr78.dat"));
		char[] str = scan.nextLine().toCharArray();
		System.out.println(Arrays.toString(str));
		int len = str.length;
		char[][] arr = new char[len][len];
		arr[0] = str;
		for (int i = 1; i < len; i++)
			arr[i] = scan.nextLine().toCharArray();

		while (scan.hasNextLine()) {
			String check = scan.nextLine();
			if (chRow(check, arr) || chCol(check, arr) || chDiag(check, arr))
				System.out.println(check + " APPEARS IN THE MATRIX");
			else
				System.out.println(check + " DOES NOT APPEAR IN THE MATRIX");

		}

	}

}