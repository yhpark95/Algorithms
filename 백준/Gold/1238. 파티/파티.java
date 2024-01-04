import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node>{
		int value;
		int time;

		public Node(int value, int time) {
			this.value = value;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			if(this.time == o.time) return this.value - o.value;
			return this.time- o.time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		List<List<Node>> nodeList = new ArrayList<>();
		for(int i = 0; i <= N;i++){
			nodeList.add(new ArrayList<>());
		}
		for(int i = 0; i < M;i++){
			st = new StringTokenizer(br.readLine());
			int nodeValue = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			nodeList.get(nodeValue).add(new Node(to, time));
		}
		int[] fromX = dijkstra(N, X, nodeList);
		int max = 0;
		for(int i = 1; i <= N; i++){
			if(i == X) continue;
			max = Math.max(max, dijkstra(N,i,nodeList)[X] + fromX[i]);
		}
		System.out.println(max);
	}

	private static int[] dijkstra(int N, int X, List<List<Node>> nodeList) {
		boolean[]visited = new boolean[N+1];
		int[] distance = new int[N+1];
		distance[0] = -1;
		Arrays.fill(distance, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(X, 0));
		distance[X] = 0;
		while(!pq.isEmpty()){
			Node current = pq.poll();
			int cv = current.value;
			visited[cv] = true;
			for(Node n : nodeList.get(cv)){
				int nv = n.value;
				if(visited[nv]) continue;
				if(distance[nv] > distance[cv] + n.time){
					distance[nv] = distance[cv] + n.time;
					pq.add(new Node(nv, distance[nv]));
				}
			}
		}
		return distance;
	}
}
