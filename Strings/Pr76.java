import java.io.*;
import java.util.*;

import org.omg.Messaging.SyncScopeHelper;

public class Pr76 {

	static String fix(String first40, int spaceIndex){
		
		//System.out.println("First 40: "+ first40+" //with spaceIndex: "+spaceIndex);
		
		while (first40.length()<40){
			int space = first40.substring(spaceIndex).indexOf(" ")+spaceIndex;
			first40=first40.substring(0,space)+" "+first40.substring(space);
			//System.out.println(space+" space");
			spaceIndex = space+2;
			
			
		}
		return first40;	
		
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("pr76.dat"));
		String str = "";
		while (scan.hasNextLine())
			str = str + scan.nextLine();

		while (str.length() > 0) {
			if (str.length() <= 40) {
				System.out.println(str);
				str = "";
				break;
			}
			String first40 = str.substring(0, 40);
			if (str.charAt(40) == ' ') {
				System.out.println(first40);
				str = str.substring(40);
				//System.out.println("hit it");
				continue;

			}
			int lastSpace = first40.lastIndexOf(' ');
			str = str.substring(lastSpace+1);
			
			first40 = fix(first40.substring(0, lastSpace),0);
			System.out.println(first40);
			

			
		}

	}
}