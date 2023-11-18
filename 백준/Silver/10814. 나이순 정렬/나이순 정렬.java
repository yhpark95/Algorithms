import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class AgeName implements Comparable<AgeName>{
		int age;
		int order;
		String name;
		AgeName(int age,int order, String name){
			this.name = name;
			this.age = age;
			this.order = order;
		}
		@Override
		public int compareTo(AgeName other) {
			int ageComparison = Integer.compare(this.age, other.age);

			if (ageComparison == 0) {
				// If ages are equal, compare by order
				return Integer.compare(this.order, other.order);
			}

			return ageComparison;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		PriorityQueue<AgeName> pq = new PriorityQueue<>();
		for(int i = 0; i < T; i++){
			st = new StringTokenizer(br.readLine());
			pq.add(new AgeName(Integer.parseInt(st.nextToken()),i, st.nextToken()));
		}
		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
			AgeName ageName = pq.poll();
			sb.append(ageName.age).append(" ").append(ageName.name).append("\n");
		}
		System.out.println(sb.deleteCharAt(sb.length()-1));


	}
}
