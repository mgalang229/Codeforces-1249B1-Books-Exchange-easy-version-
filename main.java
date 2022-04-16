import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int[] p = fs.readArray(n);
			Graph g = new Graph(n);
			for(int i = 0; i < n; i++) {
				g.addEdge(i, p[i] - 1);
			}
//			g.printAdjacencyList();
			for(int i = 0; i < n; i++) {
				g.setStartingIndex(i);
				g.DFS(i);
			}
			System.out.println();
		}
		out.close();
	}
	
	static class Graph {
		
		private int v;
		private LinkedList<Integer> adj[];
		private int startingIndex;
		private int counter;
		
		Graph(int v) {
			this.v = v;
			adj = new LinkedList[v];
			for(int i = 0; i < v; i++) {
				adj[i] = new LinkedList();
			}
		}
		
		void addEdge(int u, int v) {
			adj[u].add(v);
		}
		
		void DFSUtil(int u, boolean[] visited) {
			visited[u] = true;
			counter++;
			Iterator<Integer> itr = adj[u].listIterator();
			while(itr.hasNext()) {
				int v = itr.next();
				if(v == startingIndex) {
					System.out.print(counter + " ");
					break;
				}
				else if(!visited[v]) {
					DFSUtil(v, visited);
				}
			}
		}
		
		void DFS(int u) {
			boolean[] visited = new boolean[this.v];
			Arrays.fill(visited, false);
			DFSUtil(u, visited);
		}
		
		void setStartingIndex(int startingIndex) {
			this.startingIndex = startingIndex;
			counter = 0;
		}
		
		void printAdjacencyList() {
			int n = this.v;
			for(int u = 0; u < n; u++) {
				System.out.print(u + 1);
				for(int v = 0; v < adj[u].size(); v++) {
					System.out.print("->" + (adj[u].get(v) + 1));
				}
				System.out.println();
			}
		}
		
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for(int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for(int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
		
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while(!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for(int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
