import java.util.*;
public class U7L4CA1 {
	public static int countInitial (ArrayList<String> list, String letter) {
		int count = 0; String str = "";
		for (int i = 0; i < list.size(); i ++) {
			str = list.get(i);
			if (str.substring(0,1).equals(letter)) {
				count ++;
			}
		}
		return count;
	}
}
