package Lecture18;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tries trie = new Tries();

		trie.add("art");
		trie.add("arts");
		trie.add("bug");
		trie.add("boy");
		trie.add("sea");
		trie.add("see");
		trie.add("seen");
		//trie.add("artist");
		trie.display();

		System.out.println(trie.search("art"));
		System.out.println(trie.search("aman"));

		trie.displayAsTree();
		System.out.println("********************");
		trie.remove("art");
		trie.displayAsTree();
		trie.display();
		System.out.println("********************");
		trie.remove("arts");
		trie.displayAsTree();
	}

}
