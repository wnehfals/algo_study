import java.io.*;
import java.util.*;

public class Solution_BOJ_10828_스택 {

	static int N;
	static int num;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		
		for(int i=0 ;i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
		
			//push 명령
			if(s.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if(s.equals("pop")) {
				if(stack.isEmpty())System.out.println(-1);
				else System.out.println(stack.pop());
			}
			else if(s.equals("size")) {
				System.out.println(stack.size());
			}
			else if(s.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(s.equals("top")) {
				if(stack.isEmpty())System.out.println(-1);
				else System.out.println(stack.peek());
				
			}
			
		}

	}

}
