import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner( System.in);
		
		ArrayList<Integer>[] comp = (ArrayList<Integer>[])new ArrayList[scanner.nextInt()];
		
		for (int i = 0; i < comp.length; i++) {
			comp[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < comp.length; i++) {
			int connNum = scanner.nextInt();
			for (int j = 0; j < connNum; j++) {
				comp[i].add( scanner.nextInt() - 1);
			}
		}
		
		int compA = scanner.nextInt() - 1;
		int compB = scanner.nextInt() - 1;
		
		scanner.close();
		
		/*for (int i = 0; i < comp.length; i++) {
			for (int j = 0; j < comp[i].size(); j++) {
				System.out.print(comp[i].get(j) + " ");
			}
			System.out.println("");
		}*/
		
		ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[comp.length];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < comp.length; i++) {
			for (int j = 0; j < comp[i].size(); j++) {	
				for (int k = 0; k < comp.length; k++) {
					for (int l = 0; l < comp[k].size(); l++) {
						if (i != k && comp[i].get(j) == comp[k].get(l))
							graph[i].add(k);
					}
				}
			}
		}
		
		/*System.out.println("");
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].size(); j++) {
				System.out.print(graph[i].get(j) + " ");
			}
			System.out.println("");
		}*/
		
		int[] graphDist = new int[comp.length];
		for (int i = 0; i < comp.length; i++) {
			graphDist[i] = 0;
		}
		
		graphDist[compA] = 1;
		for (int k = 0; k < comp.length; k++)
			for (int i = 0; i < comp.length; i++) {
				for (int j = 0; j < graph[i].size(); j++) {
					if (graphDist[ graph[i].get(j) ] == 0 && graphDist[i] != 0)
						graphDist[ graph[i].get(j) ] = graphDist[i] + 1;
			}
		}
		
		if (graphDist[compB] == 0)
			System.out.println(-1);
		else {
			System.out.println(graphDist[compB] - 2);
			if (graphDist[compB] > 2) {
				ArrayList<Integer> path = new ArrayList<Integer>();
				int count = 1;
				for (int j = 0; j < comp.length; j++)
					for (int i = 0; i < comp.length; i++)
						if (graphDist[i] == count+1)
						{
							path.add(i);
							count++;
						}
				
				for (int i = 0; i < path.size() - 1; i++)
					System.out.print( (path.get(i) + 1) + " ");
			}
		}
		
		/*System.out.println("");
		for (int i = 0; i < comp.length; i++)
			System.out.print(graphDist[i] + " ");*/
	}
	
	
	
	
}
