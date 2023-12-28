import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int index;
		int dist;
		List<Node> directNodes = new ArrayList<>();

		public Node(int index) {
			this.index = index;
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
		int M = Integer.parseInt(st.nextToken());
		List<Node> nodeList = new ArrayList<>();
		boolean[] visited = new boolean[101];
		for (int i = 0; i < 101; i++) {
			nodeList.add(new Node(i));
		}
		int[] dist = new int[101];
		for (int i = 0; i < 101; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for (int i = 1; i <= 7; i++) {
			nodeList.get(i).dist = 1;
			dist[i] = 1;
		}
		for (int i = 2; i + 6 < 101; i++) {
			nodeList.get(i + 6).dist = nodeList.get(i).dist + 1;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodeList.get(from).directNodes.add(nodeList.get(to));
			visited[from] = true;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			nodeList.get(from).directNodes.add(nodeList.get(to));
			visited[from] = true;
		}

		for (int j = 1; j < 101; j++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(nodeList.get(j));
			while (!pq.isEmpty()) {
				Node current = pq.poll();
				int currentIndex = current.index;
				for (Node node : current.directNodes) {
					int ni = node.index;
					if (dist[currentIndex] < dist[ni]) {
						dist[ni] = dist[currentIndex];
						node.dist = dist[ni];
						pq.add(node);
					}
				}
				if(visited[currentIndex]){
					continue;
				}
				for (int i = 1; i <= 6; i++) {
					int ni = currentIndex + i;
					if (ni > 100) {
						continue;
					}
					if (dist[currentIndex] + 1 < dist[ni]) {
						dist[ni] = dist[currentIndex] + 1;
						nodeList.get(ni).dist = dist[ni];
						pq.add(nodeList.get(ni));
					}
				}
			}
		}
		System.out.println(dist[100]);

	}
}
