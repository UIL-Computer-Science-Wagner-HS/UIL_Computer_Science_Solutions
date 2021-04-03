import java.util.*;

class PowerSet {
	static List<ArrayList<Integer>> answers = new ArrayList<>();
	
	static void powerSet(int[] arr, int index, ArrayList<Integer> temp) {
		if(index==arr.length) {
			answers.add(new ArrayList<Integer>(temp));
			return;
		}
		
		temp.add(arr[index]);
		powerSet(arr, index+1, temp);
		temp.remove(Integer.valueOf(arr[index]));
		powerSet(arr, index+1, temp);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		powerSet(arr, 0, new ArrayList<Integer>());
		answers.forEach(System.out::println);
	}
}
