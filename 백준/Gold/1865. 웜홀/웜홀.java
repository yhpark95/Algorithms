import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<List<Node>> nodeList;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			nodeList = new ArrayList<>();
			for (int j = 0; j <= V; j++) {
				nodeList.add(new ArrayList<>());
			}
			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				nodeList.get(from).add(new Node(to, weight));
				nodeList.get(to).add(new Node(from, weight));
			}
			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				nodeList.get(from).add(new Node(to, -weight));
			}
			boolean cycle = false;
			// for(int j = 1; j <= V; j++){
			// 	if(bellmanFord(V,j,nodeList)){
			// 		cycle = true;
			// 	}
			// }
			cycle = bellmanFord(V, 1, nodeList);
			if (cycle) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}

		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));

	}

	private static boolean bellmanFord(int V,int start, List<List<Node>> nodeList) {
		int[] distances = new int[V + 1];
		Arrays.fill(distances, 100000);
		distances[start] = 0;
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (Node node : nodeList.get(j)) {
					if (distances[node.v] > distances[j] + node.w) {
						distances[node.v] = distances[j] + node.w;
						if (i == V) {
							return true;
						}
					}
				}
			}

		}
		return false;
	}
}
