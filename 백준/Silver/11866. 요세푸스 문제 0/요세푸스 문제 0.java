	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.ArrayDeque;
	import java.util.Queue;
	import java.util.StringTokenizer;

	public class Main {
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			Queue<Integer> q = new ArrayDeque<>();
			for(int i = 1; i <= N; i++){
				q.add(i);
			}

			StringBuilder sb = new StringBuilder();
			sb.append("<");
			int count = 1;
			while(!q.isEmpty()){
				int a = q.poll();
				if(count == index){
					if(q.isEmpty()){
						sb.append(a).append(">");
					}else {
						sb.append(a).append(", ");
					}
					count = 1;
					continue;
				}
				q.add(a);
				count++;
			}
			System.out.println(sb);


		}
	}
