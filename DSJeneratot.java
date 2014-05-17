import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class YAK2Graph {
	
	private Graph g;

	public Graph getG() {
		return g;
	}

	public void setG(Graph g) {
		this.g = g;
	}

	YAK2Graph(File file) throws FileNotFoundException {
		File f = file;
		Scanner s = new Scanner(f);
		
		String[] line = s.nextLine().split(" ");
		
		// Get Number Of Nodes
		int nNodes = 0;
		line = s.nextLine().split(" ");
		if(line.length == 3 && line[0].equals("#number") && line[1].equals("=")) {
			nNodes = Integer.parseInt(line[2]);
		} else {
			System.exit(0);
		}
		
		// Construct The Graph
		g = new Graph(nNodes);
		while(s.hasNextLine()) {
			line = s.nextLine().split(" ");
			if(line[0].equals("#") || line[0].equals("@begin") || line[0].equals("ls") || line[0].equals("@end")) {
				continue;
			}
			if(line.length == 3 && line[1].equals(">>") && !line[0].equals("@")) {
				g.add(Integer.parseInt(line[0]), Integer.parseInt(line[2]));
			}
			else {
				break;
			}
		}
		s.close();
	}
}
