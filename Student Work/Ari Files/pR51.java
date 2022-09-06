import java.util.*;
import java.io.*;
public class pR51 {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File ("pr51"));
		int x = sc.nextInt();
		sc.nextLine();
		while (x-- > 0) {
			Set <Character> set = new TreeSet<>();
			String str = sc.nextLine();
			String s = "";
			char[] arr = new char[str.length()];
			for (int i = 0; i < arr.length; i ++) {
				arr[i] = str.charAt(i);
			}
			for (int i = 0; i < arr.length; i ++) {
				set.add(arr[i]);
			}
			for (char c : set)
				s += c;
			System.out.println(s);
		}
	}

}
