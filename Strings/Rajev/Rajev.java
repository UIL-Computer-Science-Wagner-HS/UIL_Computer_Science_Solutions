package Progs;
import java.util.*;
import java.io.*;
public class Rajev {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rejeev.dat"));
		while(scan.hasNextLine()) {
			String str = scan.nextLine();
			//System.out.println(str);
			String[] arr = str.split(",");
			//System.out.println(Arrays.toString(arr));
			for(int i = 2; i<arr.length; i++) {
				if(!arr[i].matches(".*uiltexas.org")&&!arr[i].matches(".*uil.net"))
					System.out.println(arr[i]);
				
				
				
			}
			
		}
		

	}

}
