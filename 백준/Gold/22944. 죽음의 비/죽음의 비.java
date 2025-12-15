import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,h,d;
	static char[][] map;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Node{
		int x, y, h, cost, cnt;
		public Node(int x, int y, int h, int cost, int cnt) {
			this.x = x;
			this.y = y;
			this.h = h;
			this.cost = cost;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new char[n][n];
		check = new int[n][n];
		
		int startX=0, startY=0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') {
					startX = i;
					startY = j;
				}
			}
		}
		
		int ans = BFS(startX, startY);
		System.out.println(ans);
	}
	
	//sx,sy : 시작위치
	public static int BFS(int sx, int sy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx,sy,h,0,0));//시작점 추가
		check[sx][sy] = h;//시작점 방문처리
		
		int min = Integer.MAX_VALUE;//최소이동 거리
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//상하좌우 탐색
			for(int i=0; i<4; i++) {
				int hp=cur.h, cost=cur.cost, cnt=cur.cnt;
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				//경계 바깥
				if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
				
				//E에 도달했으면 min갱신
				if(map[nx][ny]=='E') {
					min = Math.min(min, cnt+1);
					continue;
				}
				
				//우산이면 갈아치우기
				if(map[nx][ny]=='U') cost = d;
				
				//E,U는 위에서 처리했기 때문에 남은건 . 밖에 없음.
				if(cost!=0) cost--; //우산 내구도 있을떄
				else hp--; //없을떄
				
				//죽는경우는 다시 탐색
				if(hp==0) continue;
				
				//현재 요소가 전에 방문했던 요소보다 진행을 더 할수 있다 = 현재요소로 방문처리하기
				if(check[nx][ny]<hp+cost) {
					check[nx][ny] = hp+cost;
					q.add(new Node(nx, ny, hp, cost, cnt+1));
				}
			}
		}//while
		
		if(min==Integer.MAX_VALUE) return -1;//E에 도달 못함
		return min;//E에 도달함.
	}
}