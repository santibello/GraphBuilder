# GraphBuilder
```
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Use a string with format "(a,b) (c,d) ..." where a and b are linked
		 * and c and d are linked.
		 */
		BuildGraph("(3,2) (3,4) (1,2)");
		
	

	}
	
	// Constructor to transfer the string into a matrix of integers
	private static void BuildGraph(String inputString) {
		
		// Create an array of links, separated by spaces
		String[] inputLinks = inputString.split(" ");
		
		// Initialise an int to store link components
		int[][] sLink = new int[inputLinks.length][2];
		for (int x=0; x<inputLinks.length; x++)	{
			System.out.println(inputLinks[x]);
			// Use a temporary string as I don't know how to split
			// elements of an array.
			String tempString = inputLinks[x];
			sLink[x][0] = Integer.parseInt(tempString.split("")[1]);
			sLink[x][1] = Integer.parseInt(tempString.split("")[3]);
			//System.out.println(sLink[x][0]+" "+sLink[x][1]);
		}
		
		// Call the constructor with a matrix of integers as index
		BuildGraph(sLink);
				
	}
	
	// Constructor to transfer a matrix of integers into a graph.
	private static void BuildGraph(int[][] inputIntegers) {
		
		// Figure out individuals in network and construct an empty graph

		List<Integer> node = new ArrayList<Integer>();
		
		for(int i=0;i<inputIntegers.length;i++) {
			for(int j=0; j<inputIntegers[i].length;j++) {
				if( !node.contains(inputIntegers[i][j]) ) {
					node.add(inputIntegers[i][j]);
				}
			}
		}
		
		// Sort nodes so that the smallest integer comes first.
		Collections.sort(node);
		
		
		// Initialise graph
		int[][] graph = new int[node.size()][node.size()];
		
		// Assign value of 1 for any pairing given.
		for(int i=0;i<inputIntegers.length;i++) {
			graph[inputIntegers[i][0]-1][inputIntegers[i][1]-1] = 1;
			graph[inputIntegers[i][1]-1][inputIntegers[i][0]-1] = 1;
			
			
		}
		
		// Output the graph
		for(int i=0; i<node.size(); i++) {
			for(int j=0;j<node.size();j++) {
				System.out.print(graph[i][j] + " ");
				
			}
			System.out.println();
		}
	}		
}
```

