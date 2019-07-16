package Lecture16;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();

		map.put("Russia", 200);
		map.put("India", 300);
		map.put("China", 325);
		map.put("Finland", 50);
		map.put("Aus", 100);
		map.put("NZ", 150);

		System.out.println(map);

		System.out.println(map.get("India"));
		System.out.println(map.get("SA"));

		map.remove("Aus");
		System.out.println(map);

		System.out.println(map.containsKey("Russia"));
		System.out.println(map.containsKey("USA"));

		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}
		System.out.println("**********************");
		Collection<Integer> values = map.values();
		for (Integer value : values) {
			System.out.println(value);
		}
		System.out.println("**********************");
		Set<Map.Entry<String, Integer>> entries = map.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=>" + entry.getValue());
		}

		int[] one = { 3, 1, 5, 7 };
		int[] two = { 1, 5, 3, 4, 6 };

		System.out.println(getIntersection(one, two));

	}

	public static ArrayList<Integer> getIntersection(int[] one, int[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < one.length; i++) {
			map.put(one[i], false);
		}

		for (int i = 0; i < two.length; i++) {
			if (map.containsKey(two[i])) {
				list.add(two[i]);
			}
		}

		return list;

	}

}
