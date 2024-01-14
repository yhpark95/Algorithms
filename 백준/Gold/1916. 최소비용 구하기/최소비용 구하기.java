import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Node node){
			return this.w - node.w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		List<List<Node>> nodeList = new ArrayList<>();
		for(int i = 0; i <= N; i++){
			nodeList.add(new ArrayList<>());
		}
		StringTokenizer st;
		for(int i = 0; i < B; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList.get(from).add(new Node(to, weight));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int result = dijkstra(N, nodeList, start, end);
		System.out.println(result);
	}

	private static int dijkstra(int N, List<List<Node>> nodeList, int start, int end) {
		boolean[] visited = new boolean[N+1];
		int[] distances = new int[N+1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		distances[start] = 0;
		while(!pq.isEmpty()){
			Node current = pq.poll();
			if(visited[current.v]) continue;
			visited[current.v] = true;
			for(Node node : nodeList.get(current.v)){
				if(visited[node.v]) continue;
				if(distances[node.v] > distances[current.v] +  node.w){
					distances[node.v] = distances[current.v] +  node.w;
					pq.add(new Node(node.v, distances[node.v]));
				}
			}
		}
		return distances[end];
	}
}
