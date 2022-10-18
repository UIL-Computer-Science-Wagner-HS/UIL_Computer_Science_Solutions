import java.io.*;
import java.util.*;

public class Magda {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File ("magda.dat"));
		
		while (scan.hasNext()) {
			String base_2 = ".";
			double num = scan.nextDouble();
			while (num != 1.0 && base_2.length()<11) {
				num = num*2;
				if (num >= 1.0) {
					base_2 += "1"; 
					if (num>1.0) {
						String str = String.valueOf(num); str = str.substring(str.indexOf("."));
						num = Double.parseDouble(str);
					}
				}
				else {
					base_2 += "0";
				}
			}
			System.out.println(base_2);
		}
	}

}
