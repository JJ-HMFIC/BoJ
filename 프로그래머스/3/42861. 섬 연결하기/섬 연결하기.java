import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for(int i = 0 ; i<n;i++){
            parent[i] = i;
        }
        Arrays.sort(costs, (o1,o2)->{
            return Integer.compare(o1[2],o2[2]);
        });
        int answer = kruscal(costs);
        return answer;
    }
    public void union(int x , int y){
        x = find(x);
        y = find(y);
        if(x<y) parent[y] = x;
        else parent[x] = y;
    }
    public int find(int x){
        if(parent[x] == x) return x;
        else return(find(parent[x]));
    }
    public int kruscal(int[][] costs){
        int cost = 0;
        for(int i = 0 ; i<costs.length;i++){
            if(find(costs[i][0])!=find(costs[i][1])){
                union(costs[i][0],costs[i][1]);
                cost+= costs[i][2];
            }      
        }
        return cost;
    }
}