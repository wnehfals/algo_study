import java.io.*;
import java.util.*;

public class Solution_BOJ_2644_촌수계산 {

	/*
		n : 전체 사람의 수 
		startNode : 촌수 시작노드 
		endNode : 촌수 마지막 노드 
		m : 부모 자식간의 관계의 개수 
	 */
	
	
	static int n, startNode, endNode, m;
	static int[][]rel = new int[101][101];
	static int[]visit = new int[101];
	static LinkedList<Integer>queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		startNode = Integer.parseInt(st.nextToken());
		endNode = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			rel[x][y] = 1;
			rel[y][x] = 1;
			
		}
		
		findFamily(startNode,endNode);
		
		// 촌수가 없는 경우 -1로 출력 
		if(visit[endNode]<1)System.out.println(-1);
		
		// 촌수가 있는 경우 해당 촌수 출력 
		else System.out.println(visit[endNode]-1);
		

	}

	// bfs로직 시작 -> 부모를 찾아나가면서 경로의 수를 각각 배열에 저장 
	private static void findFamily(int start, int end) {
		queue.add(start);
		visit[start]=1;
	
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for(int next=1; next<=n; next++) {
				
				// 이미 방문한 노드의 경우 넘어간다. 
				if(visit[next]!=0)continue;
				
				// 촌수가 없는 경우 그냥 넘어간다. 
				if(rel[cur][next]==0)continue;
				
				// 촌수가 있는 경우에는 큐에 저장하고 다음 촌수를 찾아나간다. 
				queue.add(next);
				visit[next]=visit[cur]+1;
			}
		}
		
		
	}

}
