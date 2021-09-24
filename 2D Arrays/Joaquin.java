import java.util.*;
import java.io.*;
public class Joaquin {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("joaquin.dat"));
		int noSets = scan.nextInt();
		while(noSets-->0) {
			int num = scan.nextInt();
			String[][] arr = new String[num][num];
			
			for(int pattern = 0;pattern<=arr.length/2;pattern+=2) {//sets the boundary for the "square"
				for(int r=pattern;r<arr.length-pattern;r++) {
					for(int c = pattern;c<arr.length-pattern;c++) {
						if(r==pattern||c==pattern) {
							arr[r][c]="X";
						}else if(r==arr.length-pattern-1 || c == arr[r].length-pattern-1) {
							arr[r][c]="X";
						}else {
							arr[r][c]=" ";
						}
					}
				}
			}
			for(int r = 0; r<arr.length;r++) {
				for(int c = 0; c<arr[r].length;c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			System.out.println("--------------------");
		}
	}

}
