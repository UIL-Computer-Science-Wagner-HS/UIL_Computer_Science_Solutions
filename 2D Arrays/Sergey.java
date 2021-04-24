package uil2013;
import java.io.*;
import java.util.*;
public class Sergey {

	static char[][] rot90(char[][] arr){
		int len = arr.length;
		char[][] ans = new char[len][len];
		for(int i = 0; i<len; i++) {
			for(int j =0; j<len; j++)
				ans[j][len-i-1]=arr[i][j];
		
		}
		return ans;
	}
	static char[][] rot180(char[][] arr){
		int len = arr.length;
		char[][] ans = new char[len][len];
		for(int i = 0; i<len; i++) {
			for(int j =0; j<len; j++)
				ans[len-i-1][len-j-1]=arr[i][j];
		
		}
		return ans;
	}
	static char[][] rot270(char[][] arr){
		int len = arr.length;
		char[][] ans = new char[len][len];
		for(int i = 0; i<len; i++) {
			for(int j =0; j<len; j++)
				ans[len-j-1][i]=arr[i][j];
		
		}
		return ans;
	}
	static void pr(char[][] arr) {
		for(char[] c: arr) {
			for(char c1: c)
				System.out.print(c1);
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("ser.dat"));
		int n = scan.nextInt();
		while(n-->0) {
			int dim = scan.nextInt();
			int rot = scan.nextInt()/90%4;
			System.out.println(rot);
			scan.nextLine();
			char[][] arr =new char[dim][];
			char[][] ans =new char[dim][];
			for(int i = 0; i<dim ; i++)
				arr[i]=scan.nextLine().toCharArray();
			switch(rot) {
			case 0: pr(arr); break;
			case 1: pr(rot90(arr));break;
			case 2: pr(rot180(arr)); break;
			case 3: pr(rot270(arr)); 
			
			
			}
			
			System.out.println("DONE");
			
			
		}

	}

}
