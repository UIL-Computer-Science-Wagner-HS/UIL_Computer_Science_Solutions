import java.util.*;

public class U7L2CA3 {
	public static ArrayList<Integer> getOdds (ArrayList<Integer> vals){
		ArrayList<Integer> odds = new ArrayList<>();
		for (int i = 0; i < vals.size(); i ++) {
			int x = vals.get(i) % 2;
			if (x != 0){
				odds.add(vals.get(i));
			}
		}
		return odds;
	}
}
