

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] distance;
    static boolean[] visited;
    static boolean[][] check;

    static List<Position> list;

    static int N;

    static List<List<Integer>> beforePositions;

    static boolean secondTime = false;


    static class Position implements Comparable<Position> {
        int value;

        int distance;

        List<Position> connectedPositions = new ArrayList<>();

        Map<Integer, Integer> posDistance = new HashMap<>();

        public Position(int value) {
            this.value = value;
        }

        public Position(int value, int distance) {
            this.value = value;
            this.distance = distance;
        }

        @Override
        public int compareTo(Position o) {
            return distance - o.distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();


        while (N != 0 && M != 0) {
            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
                list.add(new Position(i));
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                //다른 포지션에 가는 값추가
                list.get(a).connectedPositions.add(new Position(b, p));
                list.get(a).posDistance.put(b,p);
            }

            distance = new int[N + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            visited = new boolean[N + 1];
            check = new boolean[N + 1][N + 1];
            beforePositions = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                beforePositions.add(new ArrayList<>());
            }

            dijkstra(S);


            visited = new boolean[N + 1];
            check = new boolean[N + 1][N + 1];
            distance[S] = 0;
            dfs(D);

            Arrays.fill(distance, Integer.MAX_VALUE);
            secondTime = true;
            dijkstra(S);
            secondTime = false;

            int shortestWay = distance[D];
            if (shortestWay == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            } else {
                sb.append(shortestWay).append("\n");
            }


            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);

    }

    private static void dijkstra(int startNum) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        Position startPos = list.get(startNum);
        startPos.distance = 0;
        pq.add(startPos);

        while (!pq.isEmpty()) {
            Position APos = pq.poll();
            int APosValue = APos.value;

            if (visited[APosValue]) continue;

            visited[APosValue] = true;
            if (APos.distance > distance[APosValue]) continue;

            for (Position BPos : list.get(APosValue).connectedPositions) {
                if (!check[APosValue][BPos.value] && distance[BPos.value] >= APos.distance + BPos.distance) {
                    distance[BPos.value] = APos.distance + BPos.distance;
                    pq.add(new Position(BPos.value, distance[BPos.value]));
                    if (!secondTime) beforePositions.get(BPos.value).add(APosValue);
                }
            }
        }
    }

    static void dfs(int destination) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(destination);

        while(!queue.isEmpty()){
            int current = queue.poll();
            for (Integer pos : beforePositions.get(current)) {
                int currentDistance = list.get(pos).posDistance.get(current);
                if(check[pos][current]) continue;
                if (distance[current] == currentDistance + distance[pos]) {
                    check[pos][current] = true;
                    queue.add(pos);
                }
            }
        }


    }
}
