import java.io.*;
import java.util.*;

public class Paaus {
	
	public static void main(String... args) throws IOException {
		Scanner scan = new Scanner(new File("paaus.dat"));
		int noSets = scan.nextInt();
		int count = 1;
		while (noSets-- > 0) {
			int num = scan.nextInt();
			int nogo = scan.nextInt();
			String b2 = "0b"+Integer.toBinaryString(num);
			String b8 = "0"+Integer.toOctalString(num);
			String b10 = ""+num;
			String b16= "0x"+Integer.toHexString(num);
			List<String> list = new ArrayList<>();
			String[] arr = {b2,b8,b10,b16};
			for(String s: arr)
				if(!s.contains(nogo+""))
					list.add(s);
			list.sort((a,b)->a.length()-b.length());
			if(list.size()==0)
				System.out.println("Case #"+count++ +": Impossible");
			else
				System.out.println("Case #"+count++ +": "+list.get(0));

				
					
			
			
			
			
		}

	}
}