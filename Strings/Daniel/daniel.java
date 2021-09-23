import java.io.*;
import java.util.*;
public class daniel {
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("daniel.dat"));
		while(scan.hasNextLine()) {
			String[] arr = scan.nextLine().split(" ");
			String prt = "";
			int place = 1;
			boolean reset = false;
			boolean done = false;
			int count = 0;
			//we want to iterate through the arr array to put a string together
			//this string is what we'll use to print out all the words in the "triangle" format
			while(!done && count<arr.length) {
				boolean check = false;
				if(reset) {
					place = 1;
					reset = false;
				}
				for(int j = 0; j<place && count<arr.length;j++) {
					String test = prt+" "+arr[count];//create a "fake" string to check its size- if it's good, then we'll set our "real" string to what we set to this
					if((test.trim()).length()<=30) {//check to make sure any additions will stay within the 30 character limit
						prt = (prt+" "+arr[count++]).trim();//piece together the temporary string to print out the words
					}else {
						reset = true;
					}
				}
				place++;
				System.out.println(prt);
				prt = "";
			}
			System.out.println("---------*---------*---------*");
			
		}
	}

}
