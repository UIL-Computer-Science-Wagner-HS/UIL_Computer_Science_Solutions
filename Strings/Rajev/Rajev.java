package Progs;
import java.util.*;
import java.io.*;
public class Rajev {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("rejeev.dat"));
		while(scan.hasNextLine()) {
			
			String str = scan.nextLine();
			String[] arr = str.split(",");
			//ArrayList to store Strings to print
			ArrayList<String> list = new ArrayList();
			//add the fisrt part of the line
			list.add(arr[0]+":"+arr[1]);
			//we will only print the line if we find an email that does not belong
			boolean flag = false;
			for(int i = 2; i<arr.length; i++) 
				if(!arr[i].matches(".*uiltexas.org")&&!arr[i].matches(".*uil.net")) {
					list.add(arr[i]);
					 flag = true;
				}
			//Now to print the data
			String ans="";
			if(flag==true) {
			for(String s: list)
				ans+=":"+s;
			//sub(1) to cut off the first :
			System.out.println(ans.substring(1));
			}
		
		
		}
		
			
		
		
 
	}

}


}
