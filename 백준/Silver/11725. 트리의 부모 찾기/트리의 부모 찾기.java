
import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        List<Node> connectedNodes = new ArrayList<>();

        int value;

        Node(int value) {
            this.value = value;
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new Node(0));
        for (int i = 1; i <= N; i++) {
            nodeList.add(new Node(i));
        }

        StringTokenizer st;
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nodeList.get(a).connectedNodes.add(nodeList.get(b));
            nodeList.get(b).connectedNodes.add(nodeList.get(a));

        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new ArrayDeque<>();

        queue.add(nodeList.get(1));
        boolean[] visited = new boolean[N + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            for(Node node : parent.connectedNodes){
                if(!visited[node.value]){
                    map.put(node.value, parent.value);
                    visited[node.value] = true;
                    queue.add(node);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Integer key : map.keySet()){
            sb.append(map.get(key)).append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length()-1));


    }

}
