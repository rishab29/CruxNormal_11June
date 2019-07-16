package Lecture16;

public class HashTable<K, V> {
	private class HTPair {
		K key;
		V value;

		public HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object obj) {
			HTPair op = (HTPair) obj;
			return this.key.equals(op.key);
		}

		public String toString() {
			return "{" + this.key + ":" + this.value + "}";
		}
	}

	public static final int DEFAULT_CAPACITY = 10;
	private LinkedList<HTPair>[] bucketArray;
	private int size;

	public HashTable() {
		this(DEFAULT_CAPACITY);
	}

	public HashTable(int capacity) {
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pta = new HTPair(key, value);
		if (bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pta);
			this.size++;
			this.bucketArray[bi] = bucket;
		} else {
			int foundAt = bucket.find(pta);
			if (foundAt == -1) {
				bucket.addLast(pta);
				this.size++;
			} else {
				HTPair pair = bucket.getAt(foundAt);
				pair.value = value;
			}
		}

		double lamda = (this.size * 1.0) / this.bucketArray.length;
		if (lamda > 0.75) {
			this.rehash();
		}
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);
		int bi = hc % this.bucketArray.length;
		return bi;
	}

	public String toString() {
		String str = "";
		for (LinkedList<HTPair> bucket : this.bucketArray) {
			if (bucket != null && !bucket.isEmpty()) {
				str = str + bucket;
			} else {
				str = str + "NULL";
			}
			str = str + "\n";
			str = str + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		}
		str = str + "\n";
		str = str + "***********************************";
		return str;

	}

	public V get(K key) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int foundAt = bucket.find(ptf);
			if (foundAt == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(foundAt);
				return pair.value;
			}
		}
	}

	public V remove(K key) throws Exception {
		int bi = this.hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair ptf = new HTPair(key, null);
		if (bucket == null) {
			return null;
		} else {
			int foundAt = bucket.find(ptf);
			if (foundAt == -1) {
				return null;
			} else {
				HTPair pair = bucket.getAt(foundAt);
				bucket.removeAt(foundAt);
				this.size--;
				return pair.value;
			}
		}
	}

	private void rehash() throws Exception {
		LinkedList<HTPair>[] oba = this.bucketArray;
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2 * oba.length];
		this.size = 0;
		for (LinkedList<HTPair> ob : oba) {
			while (ob != null && !ob.isEmpty()) {
				HTPair rp = ob.removeFirst();
				this.put(rp.key, rp.value);
			}
		}
	}

}
