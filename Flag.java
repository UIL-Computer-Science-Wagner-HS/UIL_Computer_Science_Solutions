import java.io.*;
import java.util.*;

/**
*Make a flag according to a specific pattern.
*(Pattern in UIL Problem. Sorry, I couldn't find it)
*/
public class Flag {
	
	public static void process(int width, int height) {
		char[][] arr = new char[height][width];
		int actualWidth = width/3;
		
		for(int c = 0;c<arr[0].length;c++) {
			arr[0][c] = '-';			
		}
		
		for(int c = 0;c<arr[arr.length-1].length;c++) {
			arr[arr.length-1][c] = '-';			
		}
		
		for(int r = 0;r<arr.length;r++) {
			for(int c = 0;c<actualWidth;c++) {
				arr[r][c] = 'G';
			}
			for(int c = arr[r].length-actualWidth;c<arr[r].length;c++) {
				arr[r][c] = 'R';
			}
			
		}
		
		printArr(arr);
		System.out.println();
	}
	
	public static void printArr(char[][]arr) {
		for(char[]a:arr) {
			for(char b:a) {
				System.out.print(b);
			}
			System.out.println();
		}
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("flag.dat"));
		int no = Integer.parseInt(scan.nextLine());
		while(no-->0) {
			process(scan.nextInt(),scan.nextInt());
		}
		scan.close();

	}

}
