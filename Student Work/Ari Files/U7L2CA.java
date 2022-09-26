import java.util.*;
public class U7L2CA {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		ArrayList<String> list = new ArrayList<>();
		String str = "";
		System.out.println("Please enter words, enter STOP to stop the loop");
		while (!(str.equals("STOP"))) {
			str = sc.next();
		if (!(str.equals("STOP"))) {
			list.add(str);
			}
		}
		System.out.println(list.toString());
		for(int i = list.size() - 1; i >= 0; i --) {
			System.out.println(list.get(i));
		}
	}

}
