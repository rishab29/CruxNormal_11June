package Lecture19and20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
	private class Vertex {
		String name;
		HashMap<Vertex, Integer> nbrs;

		Vertex(String name) {
			this.name = name;
			this.nbrs = new HashMap<>();
		}

		public void display() {
			String str = this.name + "=>";
			Set<Vertex> nbrs = this.nbrs.keySet();
			for (Vertex nbr : nbrs) {
				str = str + nbr.name + "(" + this.nbrs.get(nbr) + "), ";
			}

			str = str + "END";
			System.out.println(str);
		}
	}

	HashMap<String, Vertex> vtces;

	Graph() {
		this.vtces = new HashMap<>();
	}

	public int numVtces() {
		return this.vtces.size();
	}

	public void addVertex(String name) {
		if (this.vtces.containsKey(name)) {
			return;
		}

		Vertex vtx = new Vertex(name);
		this.vtces.put(name, vtx);
	}

	public void removeVertex(String name) {
		if (!this.vtces.containsKey(name)) {
			return;
		}

		Vertex vtr = this.vtces.get(name);
		Set<Vertex> nbrs = vtr.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			nbr.nbrs.remove(vtr);
		}
		this.vtces.remove(name);
	}

	public int numEdges() {

		Collection<Vertex> vtces = this.vtces.values();
		int rv = 0;
		for (Vertex vtx : vtces) {
			rv = rv + vtx.nbrs.size();
		}

		rv = rv / 2;
		return rv;
	}

	public void addEdge(String name1, String name2, int cost) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.put(vtx2, cost);
		vtx2.nbrs.put(vtx1, cost);
	}

	public void removeEdge(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.remove(vtx2);
		vtx2.nbrs.remove(vtx1);
	}

	public void display() {
		Collection<Vertex> vtces = this.vtces.values();

		for (Vertex vtx : vtces) {
			vtx.display();
		}
	}

	public boolean hasPath(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null || vtx2 == null) {
			return false;
		}
		HashMap<Vertex, Boolean> traversed = new HashMap<>();
		return this.hasPathIterative(vtx1, vtx2);
	}

	private boolean hasPathRecursive(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> traversed) {
		if (!traversed.containsKey(vtx1)) {
			traversed.put(vtx1, true);
		} else {
			return false;
		}

		if (vtx1.nbrs.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			if (this.hasPathRecursive(nbr, vtx2, traversed)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasPathIterative(Vertex vtx1, Vertex vtx2) {
		HashMap<Vertex, Boolean> traversed = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(vtx1);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.remove();
			if (!traversed.containsKey(rvtx)) {
				traversed.put(rvtx, true);
				if (rvtx.nbrs.containsKey(vtx2)) {
					return true;
				}
				Set<Vertex> nbrs = rvtx.nbrs.keySet();
				for (Vertex nbr : nbrs) {
					if (!traversed.containsKey(nbr)) {
						queue.add(nbr);
					}
				}
			}
		}
		return false;
	}

	public void bft() {
		LinkedList<Vertex> queue = new LinkedList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			while (!queue.isEmpty()) {
				Vertex rv = queue.remove();
				if (!explored.containsKey(rv)) {
					explored.put(rv, true);
					System.out.print(rv.name);
					Set<Vertex> nbrs = rv.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}
				}
			}
		}
	}

	public void dft() {
		LinkedList<Vertex> stack = new LinkedList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				stack.addFirst(vtx);
			}
			while (!stack.isEmpty()) {
				Vertex rv = stack.removeFirst();
				if (!explored.containsKey(rv)) {
					explored.put(rv, true);
					System.out.print(rv.name);
					Set<Vertex> nbrs = rv.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}
				}
			}
		}
	}

	public boolean isConnected() {
		LinkedList<Vertex> queue = new LinkedList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vtces.values();
		queue.add((Vertex) vtces.toArray()[0]);
		while (!queue.isEmpty()) {
			Vertex rv = queue.remove();
			if (!explored.containsKey(rv)) {
				explored.put(rv, true);
				// System.out.print(rv.name);
				Set<Vertex> nbrs = rv.nbrs.keySet();
				for (Vertex nbr : nbrs) {
					if (!explored.containsKey(nbr)) {
						queue.add(nbr);
					}
				}
			}
		}

		return this.vtces.size() == explored.size();

	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		HashMap<Vertex, Boolean> explored = new HashMap<>();
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			if (!explored.containsKey(vtx)) {
				queue.add(vtx);
			}
			ArrayList<String> cc = new ArrayList<>();
			while (!queue.isEmpty()) {
				Vertex rv = queue.remove();
				if (!explored.containsKey(rv)) {
					explored.put(rv, true);
					cc.add(rv.name);
					Set<Vertex> nbrs = rv.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!explored.containsKey(nbr)) {
							queue.add(nbr);
						}
					}
				}
			}
			if (cc.size() != 0) {
				ans.add(cc);
			}
		}
		return ans;
	}
	
	

}
