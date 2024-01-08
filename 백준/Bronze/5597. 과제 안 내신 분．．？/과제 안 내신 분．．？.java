
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int T = 28;
        while(T-->0){
            String input = br.readLine();
            pq.add(Integer.parseInt(input));
        }

        int size = pq.size();
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while(size > 0){
            if(pq.peek() == count){
                pq.poll();
                size--;
                count++;
                continue;
            }
            sb.append(count).append(" ");
            count++;
        }
        if(sb.length() == 2){
            sb.append(30);
        }
        System.out.println(sb);

    }
}
