import java.util.*;
import java.io.*;
public class Emily {
public static void main(String... args) throws IOException {

	Scanner scan = new Scanner(new File("emily.dat"));
	int noSets = scan.nextInt();
	scan.nextLine();
	while (noSets-- > 0) {
		String str = scan.nextLine();
		String[] arr = str.split("\\s+");
		System.out.print(str+" = ");
		if(arr[1].matches("[*xX]"))
			System.out.println(Integer.parseInt(arr[0])*Integer.parseInt(arr[2]));
		else if(arr[1].equals("-")) {
			System.out.println(Integer.parseInt(arr[0])-Integer.parseInt(arr[2]));
		}
		else if(arr[1].equals("+")) {
			System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[2]));
		}
		else {
			System.out.println(Integer.parseInt(arr[0])/Integer.parseInt(arr[2])+" remainder "+(Integer.parseInt(arr[0])%Integer.parseInt(arr[2])));
			
		}
			

	}
}
}
