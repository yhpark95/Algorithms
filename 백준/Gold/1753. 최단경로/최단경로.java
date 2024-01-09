import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int value;
		int weight;

		public Node(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			return this.weight - node.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<List<Node>> nodeList = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			nodeList.add(new ArrayList<>());
		}
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodeList.get(from).add(new Node(to, weight));
		}
		int[] distance = dijkstra(V, start, nodeList);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			int v = distance[i];
			if (v == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
				continue;
			}
			sb.append(v).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length() - 1));
	}

	private static int[] dijkstra(int V, int start, List<List<Node>> nodeList) {
		int[] distance = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node current = pq.poll();
			visited[current.value] = true;
			for (Node n : nodeList.get(current.value)) {
				if (visited[n.value]) {
					continue;
				}
				if (distance[n.value] > distance[current.value] + n.weight) {
					distance[n.value] = distance[current.value] + n.weight;
					pq.add(new Node(n.value, distance[n.value]));
				}
			}
		}
		return distance;
	}
}
