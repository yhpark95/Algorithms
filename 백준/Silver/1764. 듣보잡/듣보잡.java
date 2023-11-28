import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++){
			map.put(br.readLine(),1);
		}
		for(int i = 0; i < M; i++){
			String name = br.readLine();
			map.put(name,map.getOrDefault(name, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();
		PriorityQueue<String> q = new PriorityQueue<>();
		for(String key : map.keySet()){
			if(map.get(key)>1){
				q.add(key);
			}
		}
		sb.append(q.size()).append("\n");
		while(!q.isEmpty()){
			sb.append(q.poll()).append("\n");
		}
		System.out.print(sb.deleteCharAt(sb.length()-1));
	}
}
