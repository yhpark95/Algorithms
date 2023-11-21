import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Points implements Comparable<Points>{
		int x;
		int y;
		Points(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Points points){
			if(this.x == points.x){
				return this.y - points.y;
			}
			return this.x - points.x;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<Points> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			pq.add(new Points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
			Points p = pq.poll();
			sb.append(p.x).append(" ").append(p.y).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length()-1));

	}
}
