import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int value;
		int dist;

		public Node(int value, int dist) {
			this.value = value;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node node) {
			return this.dist - node.dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		List<List<Node>> nodelist = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			nodelist.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			nodelist.get(from).add(new Node(to, distance));
			nodelist.get(to).add(new Node(from, distance));
		}
		st = new StringTokenizer(br.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		int[] fromOne = dijkstra(N, 1, nodelist);
		int[] fromU = dijkstra(N, u, nodelist);
		int[] fromV = dijkstra(N, v, nodelist);
		int r1 = fromOne[u] + fromU[v] + fromV[N];
		int r2 = fromOne[v] + fromV[u] + fromU[N];
		int r = Math.min(r1, r2);
		if(fromOne[u] == Integer.MAX_VALUE || fromOne[v] == Integer.MAX_VALUE || fromOne[N] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		System.out.println(r);
	}

	private static int[] dijkstra(int N, int x, List<List<Node>> nodelist) {
		boolean[] visited = new boolean[N+1];
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		distance[x] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x, 0));
		while(!pq.isEmpty()){
			Node current = pq.poll();
			int cv = current.value;
			int cd = current.dist;
			visited[cv] = true;
			for(Node node : nodelist.get(cv)){
				int nv = node.value;
				int nd = node.dist;
				if(!visited[nv] && distance[nv] >  distance[cv] + nd){
					distance[nv] = distance[cv] + nd;
					pq.add(new Node(nv, distance[nv]));
				}
			}
		}
		return distance;
	}

}
