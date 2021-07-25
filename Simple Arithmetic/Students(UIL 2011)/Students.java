import java.io.*;
import java.util.*;

public class Students {
	static String as(int n){
		String ans = "";
		for(int i = 0; i<n; i++)
			ans = ans+"*";
		return ans;
		
	}
	public static void main(String[] args) throws FileNotFoundException {

		Scanner scan = new Scanner(new File("students.dat"));
		int noSets = scan.nextInt();
		int[] arr = new int[noSets];
		scan.nextLine();
		for(int i = 0; i<noSets; i++){
		String [] str = scan.nextLine().split(" ");
		int inp = Integer.parseInt(str[str.length-1]);
		if(inp<40)
			arr[0]++;
		else
			arr[inp/10-3]++;
		}
		
		System.out.println("  <40: "+ as(arr[0]));
		for(int i = 1; i<7; i++){
			String ans = ""+(30+i*10)+"-"+(30+i*10+9)+": "+as(arr[i]);
			System.out.println(ans);
			
			
			
		}
			
	}
}
