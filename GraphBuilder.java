// this Class is the class to generate the used data structure from the yac file that the user make
import java.util.ArrayList;


public class Graph {

	private int nNodes;
	
	private ArrayList<ArrayList<Integer>> a;
	
	Graph(int nNodes) {
		this.nNodes = nNodes;
		a = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < this.nNodes; i++) {
			a.add(new ArrayList<Integer>());
		}
	}
	
	public void add(Integer from, Integer to) {
			a.get(from.intValue()).add(to);
	}
	
	public void print() {
		for(int i = 0; i < a.size(); i++) {
			for(int j = 0; j < a.get(i).size(); j++) {
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<ArrayList<Integer>> getGraph() {
		return a;
	}
}
