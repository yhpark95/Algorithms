
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int time = 0;


    static boolean amIEatingMe(int x, int y){
        return map[x][y] == 1;
    }

    static void putSerpentOnMap(int x, int y){
        map[x][y] = 1;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        int appleCount = Integer.parseInt(br.readLine());


        for (int i = 0; i < appleCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken()) - 1;
            int row = Integer.parseInt(st.nextToken()) - 1;
            map[row][column] = 2;
        }
        map[0][0] = 1;


        Deque<Integer> serpentX = new ArrayDeque<>();
        Deque<Integer> serpentY = new ArrayDeque<>();
        serpentX.add(0);
        serpentY.add(0);


        int moveCount = Integer.parseInt(br.readLine());

        Deque<String> directions = new ArrayDeque<>();
        directions.addLast("T");
        directions.addLast("L");
        directions.addLast("B");
        directions.addLast("R");


        boolean notAlive = false;

        int timeToChangeDirection = 0;
        String cmd = "a";
        int move = 0;
        int count = 0;
        while(!notAlive){
            if(count< moveCount){
                StringTokenizer st = new StringTokenizer(br.readLine());
                timeToChangeDirection = Integer.parseInt(st.nextToken());
                move = timeToChangeDirection - move;
                cmd = st.nextToken();
                count++;
            }


            while(!notAlive) {
                time++;

                switch (directions.peekLast()) {
                    case "T":
                        if (serpentY.peekFirst() - 1 > -1 && !amIEatingMe(serpentX.peekFirst(),serpentY.peekFirst() - 1)) {

                            if (map[serpentX.peekFirst()][serpentY.peekFirst() - 1] == 2) {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() - 1);
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());

                            } else {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() - 1);
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "L":
                        if (serpentX.peekFirst() - 1 > -1 && !amIEatingMe(serpentX.peekFirst() - 1,serpentY.peekFirst())) {

                            if (map[serpentX.peekFirst() - 1][serpentY.peekFirst()] == 2) {
                                serpentX.addFirst(serpentX.peekFirst() - 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst() - 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "B":

                        if (serpentY.peekFirst() + 1 < size && !amIEatingMe(serpentX.peekFirst(),serpentY.peekFirst() + 1)) {

                            if (map[serpentX.peekFirst()][serpentY.peekFirst() + 1] == 2) {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() + 1);
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst());
                                serpentY.addFirst(serpentY.peekFirst() + 1);
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                    case "R":
                        if (serpentX.peekFirst() + 1 < size && !amIEatingMe(serpentX.peekFirst() + 1,serpentY.peekFirst())) {

                            if (map[serpentX.peekFirst() + 1][serpentY.peekFirst()] == 2) {
                                serpentX.addFirst(serpentX.peekFirst() + 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                putSerpentOnMap(serpentX.peekFirst(),serpentY.peekFirst());
                            } else {
                                serpentX.addFirst(serpentX.peekFirst() + 1);
                                serpentY.addFirst(serpentY.peekFirst());
                                map[serpentX.peekFirst()][serpentY.peekFirst()] = 1;
                                map[ serpentX.pollLast()][serpentY.pollLast()] = 0;
                            }
                        } else {
                            notAlive = true;
                        }
                        break;
                }
                if(time == timeToChangeDirection){
                    if (Objects.equals(cmd, "L")) {
                        directions.addLast(directions.pollFirst());
                    } else {
                        directions.addFirst(directions.pollLast());
                    }
                    break;
                }

            }
            move = timeToChangeDirection;

        }

        System.out.println(time);

    }
}
