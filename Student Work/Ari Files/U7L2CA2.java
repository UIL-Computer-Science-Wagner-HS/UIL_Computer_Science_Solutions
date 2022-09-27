import java.util.*;
public class U7L2CA2 {

	public static double average (ArrayList<Double> dub) {
		double avg = 0;
		double sum = 0;
		for (int i = 0; i < dub.size(); i ++) {
			sum += dub.get(i);
		}
		avg = sum / dub.size();
		return avg;
	}

}
