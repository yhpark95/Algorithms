import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int value;
		Map<Node, Integer> nodes = new HashMap<>();

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Node> nodeList = new ArrayList<>();
		nodeList.add(new Node(0));
		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			nodeList.add(new Node(i));
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int nodeValue = Integer.parseInt(st.nextToken());
			Node node = nodeList.get(nodeValue);
			while (true) {
				int n = Integer.parseInt(st.nextToken());
				if (n == -1) {
					break;
				}
				int dist = Integer.parseInt(st.nextToken());
				node.nodes.put(nodeList.get(n), dist);
			}
		}
		int[] indexMax = DFS(nodeList, nodeList.get(1), N);
		Node edge = nodeList.get(indexMax[0]);
		int[] indexMax2 = DFS(nodeList, edge, N);
		System.out.println(indexMax2[1]);
	}

	private static int[] DFS(List<Node> nodeList, Node node, int N) {
		Stack<Node> stack = new Stack<>();
		stack.add(node);
		boolean[] visited = new boolean[N + 1];
		int[] arr = new int[N + 1];
		int max = 0;
		int index = 0;
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			visited[current.value] = true;
			for (Node key : current.nodes.keySet()) {
				if (visited[key.value]) {
					continue;
				}
				arr[key.value] = arr[current.value] + current.nodes.get(key);
				int value = arr[key.value];
				if (value > max) {
					max = value;
					index = key.value;
				}
				stack.add(key);
			}
		}
		return new int[] {index, max};
	}
}
