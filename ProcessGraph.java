// The Class suppose to be the class that generate the prime pathes
import java.util.ArrayList;


/*
 * @uthor Yousef Hamza
 * This Class is made to take  a data structure graph (ArrayList of ArrayList ) then generate the simplepath & primepath & testcases
 **/
public class ProcessGraph {
	private  ArrayList<ArrayList<ArrayList<Integer> > > simplepaths;
	private ArrayList<ArrayList<Integer> > primepaths;
	private ArrayList<ArrayList<Integer> > subpaths;
	private ArrayList<Boolean> visited;
	private ArrayList<ArrayList<Integer>> graph;
	
	/*
	 * Intializing the class with the graph used
	 * for all the functions of the class. 
	 * the costructor takes the generated data structure
	 * */
	public ProcessGraph(ArrayList<ArrayList<Integer>> g) {
		graph =g;
	}
	
	/*
	 * Generate simple paths from the given graph
	 * by DFS ever node to all the nodes in the graph
	 * with a little modification about the visited condition
	 * */
	public void generateSimplePaths() {
		simplepaths = new ArrayList<ArrayList<ArrayList<Integer> > >();
		subpaths = new ArrayList<ArrayList<Integer> >();
		visited = new ArrayList<Boolean>();
		//Intializing ArrayLists
		for(int i=0;i<graph.size();i++){
			simplepaths.add(new ArrayList<ArrayList<Integer>>());
			visited.add(false);
		}
		
		for(int i=0;i<graph.size();i++)
		{
			DFS(i,i,graph,new ArrayList<Integer>());
			for(int j=0;j<subpaths.size();j++)
			{
				simplepaths.get(
						subpaths.get(j).size()-1).add(subpaths.get(j));
			}
			
			subpaths = new ArrayList<ArrayList<Integer> >();
			visited = new ArrayList<Boolean>();
			//Re-intializing ArrayLists
			for(int j=0;j<graph.size();j++)
			{
				visited.add(false);
			}
		}
		//Trim the arraylist.
		for(int i=simplepaths.size()-1;i>0;i--)
		{
			if(simplepaths.get(i).size() == 0)simplepaths.remove(i);
			else break;
		}
	}
	
	/*
	 * Helper Function Used in Generate Prime paths
	 * it's the famous DFS with modification of the 
	 * visited part of it.
	 * */
	private void DFS(int i,int intial,
			ArrayList<ArrayList<Integer>> graph,
			ArrayList<Integer > pathnow) {
		
		visited.set(i, true);
		pathnow.add(i);
		subpaths.add(new ArrayList<Integer>(pathnow));
		for(int j=0;j<graph.get(i).size();j++)
		{
			if(visited.get(graph.get(i).get(j))== false) {
				DFS(graph.get(i).get(j),intial,graph,pathnow);
			}
			else
			{
				if(canBeAdded(pathnow,intial,graph.get(i).get(j)))
				{
					pathnow.add(graph.get(i).get(j));
					if(intial != graph.get(i).get(j)){
						pathnow.remove(pathnow.size()-1);
						DFS(graph.get(i).get(j),intial,graph,pathnow);
					}
					else
					{
						subpaths.add(new ArrayList<Integer>(pathnow));
						pathnow.remove(pathnow.size()-1);
					}
				}
			}
		}
		pathnow.remove(pathnow.size()-1);
	}
	/*
	 * Helper Function Used in DFS.
	 * */
	private boolean canBeAdded(ArrayList<Integer> pathnow, int intial,int toBeAdded) {
		for(int i=0;i<pathnow.size();i++) {
			if(toBeAdded==pathnow.get(i) && toBeAdded != intial)return false;//If errors found later start by debugging this one.
		}
		return true;
	}

	/*
	 * Generation of prime paths by checking every entry
	 * in length (from  len1) if it's subset of another path
	 * from the next len list.
	 * 
	 * max len paths are all taken since it can't be subset
	 * of another path.
	 * */
	public void generatePrimePaths() {
		primepaths = new ArrayList<ArrayList<Integer> >();
		for(int i=1;i<simplepaths.size();i++)
		{
			for(int j=0;j<simplepaths.get(i).size();j++)
			{
				if(i ==simplepaths.size()-1 ||!intersect(simplepaths.get(i).get(j),simplepaths.get(i+1)))
				{
					primepaths.add(simplepaths.get(i).get(j));
				}
			}
		}
	}
	
	/*
	 * Helper Function Used in generatePrimePaths
	 * */
	private boolean intersect(ArrayList<Integer> path,
			ArrayList<ArrayList<Integer>> List) {
		
		for(int i=0;i<List.size();i++)
		{
			int counter=0;
			for(int j=0;j<List.get(i).size();j++)
			{
				if(List.get(i).get(j)==path.get(counter))
				{
					int k;
					for(k=j;k<List.get(i).size()&& counter <path.size();k++,counter++)
					{
						if(List.get(i).get(k)!=path.get(counter))break;
					}
					if((k==List.get(i).size() && counter == path.size()) ||
							counter == path.size()){
						return true;
						}
				}
				counter=0;
			}
		}
		return false;
	}
	
	//Getters.
	
	public ArrayList<ArrayList<Integer> > getPrimepaths() {
		return primepaths;
	}
	
	public ArrayList<ArrayList<ArrayList<Integer> > > getSimplepaths() {
		return simplepaths;
	}
	
}
