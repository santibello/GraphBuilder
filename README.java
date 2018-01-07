# GraphBuilder
```
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildGraph {

	public static void main(String[] args) {
		
		// buildGraph requires a String as input, with format "(a,b) (c,d) ..." 
		// where a and b are linked, and c and d are linked.
		int[][] network = buildGraph("(3,2) (3,4) (1,2)");

		// Output the graph
		for (int i = 0; i < network.length; i++) {
			for (int j = 0; j < network.length; j++) {
				System.out.print(network[i][j] + " ");

			}
			System.out.println();
		}
	}
	
	// Method converting a String into a G matrix representing the graph
	public static int[][] buildGraph(String inputString) {
		// Create an array of links, separated by spaces
		String[] inputLinks = inputString.split(" ");

		// Initialise an int to store link components
		int[][] sLink = new int[inputLinks.length][2];
		for (int x = 0; x < inputLinks.length; x++) {
			System.out.println(inputLinks[x]);
			// Use a temporary string as I don't know how to split
			// elements of an array.
			String tempString = inputLinks[x];
			sLink[x][0] = Integer.parseInt(tempString.split("(|)|,")[1]);
			sLink[x][1] = Integer.parseInt(tempString.split("")[3]);
			//System.out.println(tempString.split("(|)|,"));
			// System.out.println(sLink[x][0]+" "+sLink[x][1]);
		}
		// Figure out individuals in network and construct an empty graph

		List<Integer> node = new ArrayList<Integer>();

		for (int i = 0; i < sLink.length; i++) {
			for (int j = 0; j < sLink[i].length; j++) {
				if (!node.contains(sLink[i][j])) {
					node.add(sLink[i][j]);
				}
			}
		}

		// Sort nodes so that the smallest integer comes first.
		Collections.sort(node);

		// Initialise graph
		int[][] graph = new int[node.size()][node.size()];

		// Assign value of 1 for any pairing given.
		for (int i = 0; i < sLink.length; i++) {
			graph[sLink[i][0] - 1][sLink[i][1] - 1] = 1;
			graph[sLink[i][1] - 1][sLink[i][0] - 1] = 1;

		}

		return graph;
		}
}
```

