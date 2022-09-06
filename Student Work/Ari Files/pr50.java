import java.util.*;
public class pr50 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = "ALPHABET";
		String s = "";
		char[] arr = new char[str.length()];
		for (int i = 0; i < arr.length; i ++) {
			arr[i] = str.charAt(i);
		}
		Arrays.sort(arr);
		for (char n : arr) {
			s += n;
		}
		System.out.print(s);
	}

}
