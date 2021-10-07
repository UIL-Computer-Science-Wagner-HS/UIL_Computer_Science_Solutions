import java.io.*;
import java.util.*;

public class Noah {
	String make;
	String model;
	Integer year;
	public static ArrayList<Noah> list = new ArrayList<Noah>();
	public Noah(String make, String model, Integer year) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public static void main(String[] args)throws IOException {
		Scanner scan = new Scanner(new File("noah.dat"));
		int count = scan.nextInt();
		
		Map<String, Integer> makeMap = new TreeMap();
		Map<String, Integer> modelMap = new TreeMap();
		Map<Integer, Integer> yearMap = new TreeMap();
		
		Comparator<Noah> comp = (a,b) -> a.make.compareTo(b.make);
		scan.nextLine();
		while(count-->0) {
			String[] arr = scan.nextLine().split(",");
			list.add(new Noah(arr[0],arr[1],Integer.valueOf(arr[2])));
			if(makeMap.containsKey(arr[0])) {
				makeMap.put(arr[0], makeMap.get(arr[0])+1);
			}
			else {
			makeMap.putIfAbsent(arr[0], 1);
			}
			
			if(modelMap.containsKey(arr[1])) {
				modelMap.put(arr[1], modelMap.get(arr[1])+1);
			}
			else {
			modelMap.putIfAbsent(arr[1], 1);
			}
			
			if(yearMap.containsKey(Integer.valueOf(arr[2]))) {
				yearMap.put(Integer.valueOf(arr[2]), yearMap.get(Integer.valueOf(arr[2]))+1);
			}
			else {
			yearMap.putIfAbsent(Integer.valueOf(arr[2]), 1);
			}
			
		}
		list.sort(comp.thenComparing((a,b)->a.model.compareTo(b.model)).thenComparing((a,b)-> a.year-b.year));
		System.out.println("---Data Sorted---");
		for(Noah n: list) {
			System.out.println(n.make+" "+n.model+" "+n.year);
		}
		System.out.println("---Make Breakdown---");
		for(Map.Entry<String, Integer> e: makeMap.entrySet()) {
			System.out.println(e.getKey()+": "+e.getValue());
		}
		System.out.println("---Model Breakdown---");
		for(Map.Entry<String, Integer> e: modelMap.entrySet()) {
			System.out.println(e.getKey()+": "+e.getValue());
		}
		System.out.println("---Year Breakdown---");
		for(Map.Entry<Integer, Integer> e: yearMap.entrySet()) {
			System.out.println(e.getKey()+": "+e.getValue());
		}
	}

}
