import java.io.*;
import java.util.*;

public class Johnny {
public static void main(String[] args) throws IOException{
	Scanner scan = new Scanner(new File("johnny.dat"));
	String[] inp = new String[0];	
	while(scan.hasNextLine()) {
			 inp = scan.nextLine().trim().split("[ /]");
			 Map<String, String> map = new HashMap<>();
			 //System.out.println(Arrays.toString(inp));
			 if(inp[0].matches("\\W")) {
				 for(int i = 1; i<inp.length; i++)
					 map.put(inp[i], inp[0]);
				 
			 }
			 else {
				 for(String s: inp)
					 System.out.print(s+" ");
				 System.out.println();
				 
			 }
			
			
			
		}
	
}
}