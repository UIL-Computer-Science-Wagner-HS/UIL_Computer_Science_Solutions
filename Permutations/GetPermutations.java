import java.util.*;

class GetPermutations {
	static List<ArrayList<Integer>> answers = new ArrayList<>();
	
	static void permute(int[] arr, ArrayList<Integer> temp) {
		ArrayList<Integer> copy = new ArrayList<>(temp);
		if(copy.size()==arr.length) {
			answers.add(copy);
			return;
		}
		
		for(int i = 0; i<arr.length;i++) {
			if(!copy.contains(arr[i])) {
				copy.add(arr[i]);
				permute(arr, copy);
				copy.remove(Integer.valueOf(arr[i]));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		permute(arr, new ArrayList<Integer>());
		answers.forEach(System.out::println);
	}
}