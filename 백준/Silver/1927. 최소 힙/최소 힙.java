import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++){
			list.add(Integer.parseInt(br.readLine()));
		}
		StringBuilder sb = new StringBuilder();
		for(Integer x : list){
			if(x == 0){
				if(q.isEmpty()){
					sb.append(0).append("\n");
				} else {
					sb.append(q.poll()).append("\n");
				}
				continue;
			}
			q.add(x);
		}
		System.out.println(sb.deleteCharAt(sb.length()-1));

	}
}
