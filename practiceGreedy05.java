package PROGRAMMERS;

import java.util.PriorityQueue;

//프로그래머스 코딩테스트 연습 / 탐욕법 / 섬 연결하기
public class practiceGreedy05 {

	private static int[] parents;
	
	private static class point implements Comparable<point>{
		int start; int end; int cost;
		point(int start,int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		@Override
		public int compareTo(point o) {
			return this.cost - o.cost;
		}
	}
	
	private static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	private static void union(int x,int y) {
		int xx = find(x);
		int yy = find(y);
		if(xx != yy) parents[yy] = xx;
	}
	
	public int solution(int n, int[][] costs) {
		parents = new int[n];
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		PriorityQueue<point> queue = new PriorityQueue<>();
		for (int i = 0; i < costs.length; i++) {
			queue.add(new point(costs[i][0],costs[i][1],costs[i][2]));
		}
		int answer = 0;
		
		while(!queue.isEmpty()) {
			point tmp = queue.poll();
			int x = tmp.start;
			int y = tmp.end;
			if(find(x) == find(y)) continue;
			else {
				answer += tmp.cost;
				union(x,y);
			}
		}
		return answer;
	}

}
