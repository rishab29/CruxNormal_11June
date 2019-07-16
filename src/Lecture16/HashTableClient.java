package Lecture16;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		HashTable<String, Integer> map = new HashTable<>(4);
		// System.out.println(map);
		map.put("India", 300);
		map.put("Russia", 200);
		System.out.println(map);

		map.put("China", 325);
		
		map.put("Finland", 50);
		map.put("Aus", 100);
		map.put("NZ", 150);
//		map.put("India", 320);
		map.put("USA", 155);
		System.out.println(map);
//		
//		System.out.println(map.get("Russia"));
//		System.out.println(map.get("USA"));
//		
//		
//		map.remove("Finland");
//		System.out.println(map);

	}

}
