import java.util.*;
public class U7L1CA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		String str = "";
		System.out.println("Please enter words, enter STOP to stop the loop.");
		while (!(str.equals("STOP"))) {
			str = sc.next();
		if (!(str.equals("STOP"))) {
			list.add(str);
			}
		}
		System.out.println(list.size());
		System.out.println(list.toString());
		list.remove(0);
		list.remove(list.size() - 1);
		System.out.println(list.toString());
	}

}
